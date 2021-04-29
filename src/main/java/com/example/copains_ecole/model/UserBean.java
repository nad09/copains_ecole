package com.example.copains_ecole.model;


import javax.persistence.*;

@Entity
@Table(name = "users")

public class UserBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pseudo;
    private String password;
    private Double longitude;
    private Double latitude;
    private Integer group_users;
    private String session;

    public UserBean() {}

    public UserBean(String pseudo, Double longitude, Double latitude, Integer group_users, String session) {
        this.pseudo = pseudo;
        this.longitude = longitude;
        this.latitude = latitude;
        this.group_users = group_users;
        this.session = session;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getGroup_users() {
        return group_users;
    }

    public void setGroup_users(Integer group_users) {
        this.group_users = group_users;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }


}
