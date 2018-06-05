package com.example.demo.Entity;

import java.util.Date;

/**
 * Created by ggg on 2018/5/29.
 * Comment实体
 */
public class Comment {
    private int c_id;
    private int p_id;
    private String c_content;
    private Date c_date;
    private int wa_id;
    private String u_name;

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }


    public int getWa_id() {
        return wa_id;
    }

    public void setWa_id(int wa_id) {
        this.wa_id = wa_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }
}
