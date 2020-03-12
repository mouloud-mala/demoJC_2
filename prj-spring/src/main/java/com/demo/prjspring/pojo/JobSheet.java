package com.demo.prjspring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.util.List;

// @Data permet la mise en place automatique des constructeurs et des getteurs setteurs
@Data
@Component
@Table(name = "JOBSHEET")
@NoArgsConstructor
@AllArgsConstructor
public class JobSheet {

    private long idJobSheet;

    private String title;

    private String description;

    private List<Skill> skillList;

    /*public List<String> getSkillsList() {
        if (this.skills.length() > 0) {
            return Arrays.asList(this.skills.split(","));
        }
        return new ArrayList<>();
    }*/

    public JobSheet(JobSheet updateJobSheet, HttpHeaders httpHeaders, HttpStatus ok) {
    }
}
