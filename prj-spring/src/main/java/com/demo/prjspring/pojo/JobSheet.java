package com.demo.prjspring.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @Data permet la mise en place automatique des constructeurs et des getteurs setteurs
@Data
@Entity
@Table(name = "JOBSHEET")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobSheet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOBSHEET_ID", updatable = false, nullable = false)
    private long idJobSheet;

    private String title;

    private String description;

    /*@ManyToOne
    private Recruiter author = new Recruiter();*/

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "JOBSHEET_SKILL", joinColumns = @JoinColumn(name = "JOBSHEET_ID"), inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
    @JsonProperty("skillList")
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
