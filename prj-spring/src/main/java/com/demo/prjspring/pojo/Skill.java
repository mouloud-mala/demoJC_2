package com.demo.prjspring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    private static final long serialVersionUID = 2284252532274015507L;

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
