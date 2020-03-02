package com.demo.prjspring.repository;

import com.demo.prjspring.pojo.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    /*@Query("SELECT r FROM Recruiter r WHERE r.mail = :mail")*/
    Manager findByMail(String mail);

    @Query("SELECT m FROM Manager m WHERE m.mail = :mail AND m.password = :password")
    Manager identify(String mail, String password);
}
