package com.demo.prjspring.controller;

import com.demo.prjspring.pojo.Agent;
import com.demo.prjspring.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/agents", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController {

    @Autowired
    AgentService agentService;

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Agent getAgentById(@PathVariable("id") long id) throws Exception {
        return agentService.getAgentById(id);
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createAgent(@Valid @RequestBody Agent agent) {
        agentService.createAgent(agent);
    }

    @PutMapping("/{id}")
    public void updateAgent(@PathVariable("id") Long id, @RequestBody Agent agent) {
        agentService.updateAgent(id, agent);
    }

    @DeleteMapping("/{id}")
    public void deleteAgentById(@PathVariable("id") Long id) throws Exception {
        agentService.deleteAgentById(id);
    }
}
