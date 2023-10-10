package com.montu.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generating id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true,length = 45)
    private  String email;

    @Column(nullable = false,length = 40)
    private String qualificaion;

    @Column(nullable = false,length = 10)
    private String gender;
    @Column(nullable = false,length = 13)
    private String password;

    @Column(nullable = false, length = 500)
    private  String aboutme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualificaion() {
        return qualificaion;
    }

    public void setQualificaion(String qualificaion) {
        this.qualificaion = qualificaion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", qualificaion='" + qualificaion + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", aboutme='" + aboutme + '\'' +
                '}';
    }
}
