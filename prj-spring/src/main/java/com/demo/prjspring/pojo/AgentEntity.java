package com.demo.prjspring.pojo;

import lombok.Data;

@Data
public class AgentEntity {

	private long idAgent;

    private String lastName;

    private String firstName;

    private String mail;

    private String password;

    private String address;

    private String city;

    private String country;
    
    public AgentEntity() {
    	super();
    }
    
}
