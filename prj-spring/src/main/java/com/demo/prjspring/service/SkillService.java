package com.demo.prjspring.service;

import com.demo.prjspring.pojo.Skill;
import com.demo.prjspring.repository.SkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Service
public class SkillService {
    @Resource
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        log.info("Called for getAllSkills ...");
        List<Skill> skillsList = skillRepository.findAll();
        if (skillsList.size() > 0) {
            return skillsList;
        } else {
            return new ArrayList<>();
        }
    }

    public Stream<Skill> getAllSkillsStream() {
        return skillRepository.getAllSkillsStream();
    }

    public String getSkillById(long id) throws Exception {
        log.info("Called for get a skill by id");
        Optional<Skill> skillById = skillRepository.findById(id);
        if (skillById.isPresent()) {
            return skillById.get().getName();
        } else {
            throw new Exception("No skill record exist for given id");
        }
    }
}
