package com.demo.prjspring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

// @Data permet la mise en place automatique des constructeurs et des getteurs setteurs
@Data
@Entity
@Table(name = "JOBSHEET")
@NoArgsConstructor
@AllArgsConstructor
public class JobSheet implements Serializable {

	private static final long serialVersionUID = 5742257974991351871L;

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

    public JobSheet(JobSheet updateJobSheet, HttpHeaders httpHeaders, HttpStatus ok) {
    }
}
