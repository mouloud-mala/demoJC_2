package com.demo.prjspring.service;

import com.demo.prjspring.pojo.Manager;
import com.demo.prjspring.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ManagerService {
    @Resource
    private ManagerRepository managerRepository;

    public List<Manager> getAllManagers() {
        log.info("Called for getAllRecruiters ...");
        List<Manager> managerList = managerRepository.findAll();
        if (managerList.size() > 0) {
            return managerList;
        } else {
            return new ArrayList<>();
        }
    }

    public Manager createManager(Manager manager) {
        log.info("Called for add a Recruiter ...");
        return managerRepository.save(manager);
    }

    public Manager getManagerById(long id) throws Exception {

        log.info("Called for get a recruiter by id");
        Optional<Manager> managerById = managerRepository.findById(id);
        if (managerById.isPresent()) {
            return managerById.get();
        } else {
            throw new Exception("No recruiter record exist for given id");
        }
    }

    public Manager getManagerByMail(String mail) {
        log.info("Called for get a Recruiter by mail ...");
        Manager managerByMail = managerRepository.findByMail(mail);
        return managerByMail;
    }

    public ResponseEntity<Manager> updateManager(long id, Manager manager) {
        log.info("Called for update a Recruiter ...");
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if (optionalManager.isPresent()) {
            Manager newManager = manager;
            newManager.setIdManager(manager.getIdManager());
            newManager.setLastName(manager.getLastName());
            newManager.setFirstName(manager.getFirstName());
            newManager.setMail(manager.getMail());
            newManager.setCity(manager.getCity());
            newManager.setCountry(manager.getCountry());

            Manager updatedRecruiter = managerRepository.save(newManager);
            return ResponseEntity.ok(updatedRecruiter);
        } else {
            manager = managerRepository.save(manager);
            return ResponseEntity.ok(manager);
        }

    }

    public void deleteManagerById(Long id) throws Exception {
        log.info("Called for delete a Recruiter ...");
        Optional<Manager> manager = managerRepository.findById(id);

        if (manager.isPresent()) {
            managerRepository.deleteById(id);
        } else {
            throw new Exception("No recruiter record exist for given id");
        }
    }

    public boolean identify(Manager manager) {
        Manager manager1 = managerRepository.identify(manager.getMail(), manager.getPassword());
        return (manager != null);
    }
}
