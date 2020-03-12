package com.demo.prjspring.service;

import com.demo.prjspring.entity.JobSheetEntity;
import com.demo.prjspring.pojo.JobSheet;
import com.demo.prjspring.pojo.Skill;
import com.demo.prjspring.repository.JobSheetRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class JobSheetService {
    @Resource
    private JobSheetRepository jobSheetRepository;

    @Autowired
    SkillService skillService;

    public List<JobSheet> getAllJobSheets() {
        log.info("Called for getAllJobSheets ...");
        List<JobSheet> jobSheetList = jobSheetRepository.findAll();
        if (jobSheetList.size() > 0) {
            return jobSheetList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * PARSE DES DONNEES EN JSON
     */

    public String getAllJobSheetsJson() throws FileNotFoundException {
        log.info("Called for serialise to Json ...");
        List<JobSheet> jobSheetList = this.getAllJobSheets();

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.serializeNulls()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(jobSheetList);
        /**
         * AUTRE MANIERE DE FAIRE DIRECTEMENT ENREGISTREMENT
         *
         * *gson.toJson(user, new FileWriter(filePath));
         */
        System.out.println("Resultat : " + json);
        return json;
    }

    /**
     * ECRITURE DANS UN FICHIER DU RESULTAT DU PARSE
     */
    public void writeFileJson() throws FileNotFoundException {
        log.info("Called for write a fileJson ...");
        final String jobSheetListJson = this.getAllJobSheetsJson();
        File folder = new File("C:\\DataJson");
        folder.mkdir();
        PrintWriter pw = new PrintWriter("C:\\DataJson\\JSONJobSheet.json");
        pw.write(jobSheetListJson);
        pw.flush();
        pw.close();

    }

    /**
     * LECTURE DANS UN FICHIER DU RESULTAT DU PARSE
     */
    public List<JobSheet> readFileJson() throws FileNotFoundException {
        log.info("Called for read a fileJson ...");
        Gson gson = new Gson();

        // 1. JSON file to Java object
        return (List<JobSheet>) gson.fromJson(new FileReader("src/main/resources/jsonfile/JSONJobSheet.json"), Object.class);
    }

    public boolean writeInDB(List<JobSheet> data) {
        boolean result = false;
        // 1. TRUNCATE TABLE pour vider la table
        // 2. Réécrire dans la base de donnée les data (List<JobSheet>) en INSERT
        return result;
    }


    public JobSheetEntity createJobSheet(JobSheetEntity entity) {
    	
    	
    	
//        log.info("Called for add a JobSheet ...");
//        List<Skill> skillList = new ArrayList<>();
//        Skill jobSheetSkill = new Skill();
//        skillList.add(jobSheetSkill);
//        jobSheet.setSkillList(skillList);
//
//        List<Skill> skillFromDB = extractSKill(jobSheet.getSkillList(), skillService.getAllSkillsStream());
//        jobSheet.getSkillList().removeAll(jobSheet.getSkillList());
//        jobSheet.setSkillList(skillFromDB);
//
//        return jobSheetRepository.save(jobSheet);
    	return null;
    }

    // methode pour mettre a jour la liste de competences
    private List<Skill> extractSKill(List<Skill> skillListFromJobSheet, Stream<Skill> skillStreamFromDB) {
        // Collect UI role names
        List<String> uiSkillNames = skillListFromJobSheet.stream()
                .map(Skill::getName)
                .collect(Collectors.toCollection(ArrayList::new));
        // Filter DB roles
        return skillStreamFromDB
                .filter(skill -> uiSkillNames.contains(skill.getName()))
                .collect(Collectors.toList());
    }

    public JobSheet getJobSheetById(long id) throws Exception {

        log.info("Called for get a jobSheet by id");
        Optional<JobSheet> customerById = jobSheetRepository.findById(id);
        if (customerById.isPresent()) {
            return customerById.get();
        } else {
            throw new Exception("No customer record exist for given id");
        }
    }

    public ResponseEntity<JobSheet> updateJobSheet(long id, JobSheet jobSheet) {
        log.info("Called for update a JobSheet ...");
        Optional<JobSheet> optionalJobSheet = jobSheetRepository.findById(id);
        if (optionalJobSheet.isPresent()) {
            JobSheet newJobSheet = jobSheet;
            newJobSheet.setIdJobSheet(jobSheet.getIdJobSheet());
            newJobSheet.setTitle(jobSheet.getTitle());
            /*newJobSheet.setAuthor(jobSheet.getAuthor());*/
            newJobSheet.setDescription(jobSheet.getDescription());
            newJobSheet.setSkillList(jobSheet.getSkillList());

            JobSheet updatedJobSheet = jobSheetRepository.save(newJobSheet);
            return ResponseEntity.ok(updatedJobSheet);
        } else {
            jobSheet = jobSheetRepository.save(jobSheet);
            return ResponseEntity.ok(jobSheet);
        }

    }

    public void deleteJobSheetById(Long id) throws Exception {
        log.info("Called for delete a JobSheet ...");
        Optional<JobSheet> customer = jobSheetRepository.findById(id);

        if (customer.isPresent()) {
            jobSheetRepository.deleteById(id);
        } else {
            throw new Exception("No job sheet record exist for given id");
        }
    }

    /*public List<JobSheet> getByRecruiter(Recruiter author) {
        List<JobSheet> jobSheetList =jobSheetRepository.findByRecruiter(author);
        return jobSheetList;
    }*/
    
    public JobSheetEntity insertJobSheet(JobSheetEntity entity) {
    	
    	
    	return null;
    }
}
