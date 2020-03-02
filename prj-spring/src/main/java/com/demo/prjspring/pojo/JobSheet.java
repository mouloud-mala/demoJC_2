package com.demo.prjspring.pojo;

import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @Data permet la mise en place automatique des constructeurs et des getteurs setteurs
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"title", "description", "skillList"})
public class JobSheet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJobSheet;

    private String title;

    private String description;

    @ManyToMany
    private List<Skill> skillList = new ArrayList<>();

    /*@ManyToOne
    private Recruiter author = new Recruiter();*/

    /*private String skills;

    public List<String> getSkillsList() {
        if (this.skills.length() > 0) {
            return Arrays.asList(this.skills.split(","));
        }
        return new ArrayList<>();
    }*/

    public JobSheet(JobSheet updateJobSheet, HttpHeaders httpHeaders, HttpStatus ok) {
    }
}
