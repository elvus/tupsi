package com.tupsi.app.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;
    @Column(name="codUser")
    private String codUser;
    @Column(name="password")
    private String password;
    @Column(name="active")
    private boolean active;

    public Users(){

    }

    public Users(String codUser, String password, boolean active){
        this.codUser = codUser;
        this.password = password;
        this.active = active;
    }

    public long getIdUser(){
        return idUser;
    }

    public String getCodUser(){
        return codUser;
    }

    public void setCodUser(String codUser){
        this.codUser = codUser;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean isActive){
        this.active = isActive;
    }
}