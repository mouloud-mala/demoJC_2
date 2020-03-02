package com.demo.prjspring.controller;

import com.demo.prjspring.pojo.Manager;
import com.demo.prjspring.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/managers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {

    @Autowired
    ManagerService managerService;

    
    @GetMapping
    public List<Manager> getAllRecruiter() {
        return managerService.getAllManagers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Manager getRecruiterById(@PathVariable("id") long id) throws Exception {
        return managerService.getManagerById(id);
    }

    // todo a voir
    @GetMapping("/login")
    public Manager getRecruiterByMail(@RequestParam String mail) throws Exception {
        System.out.println(mail);
        return managerService.getManagerByMail(mail);
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecruiter(@Valid @RequestBody Manager manager) {
        managerService.createManager(manager);
    }

    @PutMapping("/{id}")
    public void updateRecruiter(@PathVariable("id") Long id, @RequestBody Manager manager) {
        managerService.updateManager(id, manager);
    }

    @DeleteMapping("/{id}")
    public void deleteJRecruiterById(@PathVariable("id") Long id) throws Exception {
        managerService.deleteManagerById(id);
    }
}
