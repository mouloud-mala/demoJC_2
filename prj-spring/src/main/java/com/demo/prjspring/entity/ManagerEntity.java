package com.demo.prjspring.entity;

import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
// a retirer pour spring security
@AllArgsConstructor
@Getter
@Setter
public class ManagerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idManager;

    private String lastName;

    private String firstName;

    private String mail;

    private String password;

    private String city;

    private String country;

    /*@OneToMany
    private List<JobSheet> jobSheetList = new ArrayList<>();*/

    /*public Manager(long idRecruiter, String lastName, String firstName, String mail, String password, String city, String country) {
        this.idManager = idRecruiter;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.password = BCryptManagerUtil.passwordencoder().encode(password);
        this.city = city;
        this.country = country;
    }

    public void setPassword(String password) {
        if (!password.isEmpty()) {
            this.password = BCryptManagerUtil.passwordencoder().encode(password);
        }
    }*/

    /*public String getPassword() {
        return this.password;
    }*/

    /*public Manager(com.demo.prjspring.pojo.Manager updateCustomer, HttpHeaders httpHeaders, HttpStatus ok) {
    }*/
}
