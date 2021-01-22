package com.example.demo.domain;/*
 * @Author: Haoran
 * @Date: 2021/1/21 15:54
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private int id;

    private String username;

    @JsonIgnore
    private String pwd;

    public User(int id, String username, String pwd){
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
