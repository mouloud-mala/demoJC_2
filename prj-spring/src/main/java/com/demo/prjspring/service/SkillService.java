package com.demo.prjspring.service;

import com.demo.prjspring.pojo.Skill;
import com.demo.prjspring.repository.SkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
}
