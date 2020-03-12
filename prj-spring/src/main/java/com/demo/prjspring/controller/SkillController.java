package com.demo.prjspring.controller;

import com.demo.prjspring.pojo.Skill;
import com.demo.prjspring.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/skills", produces = MediaType.APPLICATION_JSON_VALUE)
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public String getSkillById(@PathVariable("id") long id) throws Exception {
        return skillService.getSkillById(id);
    }
}
