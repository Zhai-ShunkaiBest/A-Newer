package com.cliffside;

import java.io.Serializable;

/**
 * @author cliffside
 * @date 2021-04-28 22:39
 */
public class User implements Serializable {
    private Integer uid;
    private String realname;
    private String username;
    private String pasword;

    public User(Integer o, String o1, String msb, String s) {
        this.uid = o;
        this.realname = o1;
        this.username = msb;
        this.pasword = s;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
