package com.demo.prjspring.entity;

import com.demo.prjspring.pojo.Skill;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "JOBSHEET")
@NoArgsConstructor
@AllArgsConstructor
public class JobSheetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOBSHEET_ID", updatable = false, nullable = false)
    private long idJobSheet;

    private String title;

    private String description;

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

    /*public JobSheet(com.demo.prjspring.pojo.JobSheet updateJobSheet, HttpHeaders httpHeaders, HttpStatus ok) {
    }*/
}
