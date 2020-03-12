package com.demo.prjspring.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.demo.prjspring.Mapper.JobSheetMapper;
import com.demo.prjspring.Mapper.SkillMapper;
import com.demo.prjspring.entity.JobSheetEntity;
import com.demo.prjspring.entity.SkillEntity;
import com.demo.prjspring.pojo.JobSheet;
import com.demo.prjspring.pojo.Skill;
import com.demo.prjspring.service.JobSheetService;

@Component
public class JobSheetAdapter {

	@Autowired
    JobSheetService service;
	
	@Autowired
	JobSheetMapper mapper;
	
	@Autowired
	SkillMapper skillMapper;
	
	public JobSheet insertJobSheet(JobSheet jobSheet) {
		JobSheetEntity entity = mapper.jobSheetToJobSheetEntity(jobSheet);
		if (!CollectionUtils.isEmpty(jobSheet.getSkillList())) {
			List<SkillEntity> skillEntityList = jobSheet.getSkillList().stream().map(skill -> createSkillEntity(skill)).collect(Collectors.toList());
	        entity.setSkillList(skillEntityList);
		}
		
		JobSheetEntity returnEntity = service.insertJobSheet(entity);
		
		JobSheet returnJobSheet = mapper.jobSheetEntityToJobSheet(returnEntity);
		if (!CollectionUtils.isEmpty(returnEntity.getSkillList())) {
			List<Skill> skillList = returnEntity.getSkillList().stream().map(skill -> createSkill(skill)).collect(Collectors.toList());
			returnJobSheet.setSkillList(skillList);
		}
		
		return returnJobSheet;
		
	}
	
	
	private SkillEntity createSkillEntity(Skill skill) {
		return skillMapper.skillToSkillEntity(skill);
	}
	
	private Skill createSkill(SkillEntity entity) {
		return skillMapper.skillEntityToSkill(entity);
	}
}
