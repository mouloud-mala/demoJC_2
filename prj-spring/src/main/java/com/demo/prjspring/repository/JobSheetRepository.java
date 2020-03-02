package com.demo.prjspring.repository;

import com.demo.prjspring.pojo.JobSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSheetRepository extends JpaRepository<JobSheet, Long> {

    /*@Query("SELECT j FROM JobSheet j WHERE j.author = :recruiter")
    List<JobSheet> findByRecruiter(Recruiter author);*/
}
