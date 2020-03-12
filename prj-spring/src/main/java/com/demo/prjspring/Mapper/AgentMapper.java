package com.demo.prjspring.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.demo.prjspring.pojo.Agent;
import com.demo.prjspring.pojo.AgentEntity;

@Mapper(componentModel = "spring")
public interface AgentMapper {
	
	Agent agentEntityToAgent(AgentEntity entity);
	
	AgentEntity agentToAgentEntity(Agent agent);

}
