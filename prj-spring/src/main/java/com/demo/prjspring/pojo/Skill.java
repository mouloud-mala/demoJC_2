package com.demo.prjspring.pojo;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "SKILL")
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Skill implements Serializable {

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
