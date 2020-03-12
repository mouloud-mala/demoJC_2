package com.demo.prjspring.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.prjspring.adapter.JobSheetAdapter;
import com.demo.prjspring.pojo.JobSheet;
import com.demo.prjspring.service.JobSheetService;
import com.demo.prjspring.service.SkillService;

@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/jobSheets", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobSheetController {

    @Autowired
    JobSheetService jobSheetService;
    
    @Autowired
    JobSheetAdapter adapter;

    @Autowired
    SkillService skillService;

    @GetMapping
    public List<JobSheet> getAllJobSheets() {
        return jobSheetService.getAllJobSheets();
    }

    // todo
    @GetMapping("/test")
    public void getAllJobSheetsJson() throws FileNotFoundException {
        jobSheetService.getAllJobSheetsJson();
    }

    @GetMapping("/write")
    public boolean writeFileJson() throws FileNotFoundException {
        boolean test = true;
        try {
            jobSheetService.writeFileJson();
        } catch (Exception e) {
            test = false;
        }
        return test;
    }

    @GetMapping("/read")
    public boolean readFileJson() throws FileNotFoundException {
        boolean test = true;
        try {
            jobSheetService.readFileJson();
            System.out.println(jobSheetService.readFileJson());
        } catch (Exception e) {
            test = false;
        }
        return test;
    }

    /*@GetMapping
    public List<JobSheet> getByRecruiter(Recruiter author) {
        return jobSheetService.getByRecruiter(author);
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public JobSheet getJobSheetById(@PathVariable("id") long id) throws Exception {
        return jobSheetService.getJobSheetById(id);
    }

    @RequestMapping(method = RequestMethod.POST, /*headers = {"Content-type=application/json"},*/ consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createJobSheet(@Valid @RequestBody JobSheet jobSheet) {
        //jobSheetService.createJobSheet(jobSheet);
    }

    @PutMapping("/{id}")
    public void updateJobSheet(@PathVariable("id") Long id, @RequestBody JobSheet jobSheet) {
        jobSheetService.updateJobSheet(id, jobSheet);
    }

    @DeleteMapping("/{id}")
    public void deleteJobSheetById(@PathVariable("id") Long id) throws Exception {
        jobSheetService.deleteJobSheetById(id);
    }
    
    @PostMapping("/insert")
    public JobSheet insertJobSheet(@RequestBody JobSheet jobSheet) {
    	return adapter.insertJobSheet(jobSheet);
    }
}
