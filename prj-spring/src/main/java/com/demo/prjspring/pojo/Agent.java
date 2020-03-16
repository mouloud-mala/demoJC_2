package com.demo.prjspring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

// @Data permet la mise en place automatique des constructeurs et des getteurs setteurs
@Data
@Entity
@Table(name = "AGENT")
@AllArgsConstructor
@NoArgsConstructor
public class Agent implements Serializable{

	private static final long serialVersionUID = 9123078472214313220L;
	
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
