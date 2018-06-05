package com.example.demo.Entity;

/**
 * Created by ggg on 2018/5/28.
 * User实体
 */
public class User {
    private int u_id;
    private String u_name;
    private String u_passwd;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_passwd() {
        return u_passwd;
    }

    public void setU_passwd(String u_passwd) {
        this.u_passwd = u_passwd;
    }
}
