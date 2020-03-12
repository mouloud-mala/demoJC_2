package com.demo.prjspring.Mapper;

import com.demo.prjspring.entity.SkillEntity;
import com.demo.prjspring.pojo.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
	
	Skill skillEntityToSkill(SkillEntity entity);
	
	SkillEntity skillToSkillEntity(Skill skill);

}
