package com.demo.prjspring.service;

import com.demo.prjspring.pojo.Agent;
import com.demo.prjspring.repository.AgentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AgentService {
    @Resource
    private AgentRepository agentRepository;

    public List<Agent> getAllAgents() {
        log.info("Called for getAllAgents ...");
        List<Agent> agentList = agentRepository.findAll();
        if (agentList.size() > 0) {
            return agentList;
        } else {
            return new ArrayList<>();
        }
    }

    public Agent createAgent(Agent agent) {
        log.info("Called for add a Recruiter ...");
        return agentRepository.save(agent);
    }

    public Agent getAgentById(long id) throws Exception {

        log.info("Called for get an agent by id");
        Optional<Agent> agentById = agentRepository.findById(id);
        if (agentById.isPresent()) {
            return agentById.get();
        } else {
            throw new Exception("No recruiter record exist for given id");
        }
    }

    public ResponseEntity<Agent> updateAgent(long id, Agent agent) {
        log.info("Called for update an Agent ...");
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        if (optionalAgent.isPresent()) {
            Agent newAgent = agent;
            newAgent.setIdAgent(agent.getIdAgent());
            newAgent.setLastName(agent.getLastName());
            newAgent.setFirstName(agent.getFirstName());
            newAgent.setMail(agent.getMail());
            newAgent.setAddress(agent.getAddress());
            newAgent.setCity(agent.getCity());
            newAgent.setCountry(agent.getCountry());
            /*newAgent.setSkillList(agent.getSkillList());*/

            Agent updatedAgent = agentRepository.save(newAgent);
            return ResponseEntity.ok(updatedAgent);
        } else {
            agent = agentRepository.save(agent);
            return ResponseEntity.ok(agent);
        }

    }

    public void deleteAgentById(Long id) throws Exception {
        log.info("Called for delete an Agent ...");
        Optional<Agent> agent = agentRepository.findById(id);

        if (agent.isPresent()) {
            agentRepository.deleteById(id);
        } else {
            throw new Exception("No agent record exist for given id");
        }
    }

}
