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
@ToString(of = {"lastName", "firstName", "mail", "password", "address", "city", "country", "skillList"})
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgent;

    private String lastName;

    private String firstName;

    private String mail;

    private String password;

    private String address;

    private String city;

    private String country;

   /* @ManyToMany
    private List<Skill> skillList;*/

   /* public List<String> getSkillsList() {
        if (this.skills.length() > 0) {
            return Arrays.asList(this.skills.split(","));
        }
        return new ArrayList<>();
    }*/

    /*private String skills;

    public List<String> getSkillsList() {
        if (this.skills.length() > 0) {
            return Arrays.asList(this.skills.split(","));
        }
        return new ArrayList<>();
    }*/


    public Agent(Agent updateCustomer, HttpHeaders httpHeaders, HttpStatus ok) {
    }
}
