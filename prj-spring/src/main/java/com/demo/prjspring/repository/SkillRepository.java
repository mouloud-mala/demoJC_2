package com.demo.prjspring.repository;

import com.demo.prjspring.pojo.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    /*@Query("SELECT s FROM Skill s WHERE s.jobsheet = :jobsheet")
    List<Skill> findByJobSheet(Long jobsheet);*/

    Skill findByName(String name);

    @Query("SELECT skill from Skill skill")
    Stream<Skill> getAllSkillsStream();
}
