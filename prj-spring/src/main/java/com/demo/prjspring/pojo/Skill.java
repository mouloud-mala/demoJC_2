package com.demo.prjspring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name = "SKILL")
@AllArgsConstructor
@NoArgsConstructor
public class Skill implements Serializable{

    private static final long serialVersionUID = 2284252532274015507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID", updatable = false, nullable = false)
    private long idSkill;

    private String name;

    /*@ManyToOne
    @JoinColumn(name = "idJobsheet")
    private JobSheet jobSheet;*/

    /*@ManyToOne
    private Agent agent;
*/
    /*@ManyToMany
    private List<JobSheet> jobSheets;

    @ManyToMany
    private List<Agent> agents;*/
}
