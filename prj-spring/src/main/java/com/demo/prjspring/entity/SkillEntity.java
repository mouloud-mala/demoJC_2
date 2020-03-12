package com.demo.prjspring.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SKILL")
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkillEntity implements Serializable {

    private static final long serialVersionUID = 2284252532274015507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID", updatable = false, nullable = false)
    private long idSkill;

    private String name;
}
