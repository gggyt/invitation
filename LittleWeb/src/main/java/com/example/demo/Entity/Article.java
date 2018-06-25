package com.example.demo.Entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ggg on 2018/5/29.
 * Article实体
 */
public class Article {
    private int a_id;
    private String a_title;
    private String a_author;
    private String a_content;
    private Date a_date;
    private List<Comment> comments;
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_title() {
        return a_title;
    }

    public void setA_title(String a_title) {
        this.a_title = a_title;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public String getA_author() {
        return a_author;
    }

    public void setA_author(String a_author) {
        this.a_author = a_author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "a_id=" + a_id +
                ", a_title='" + a_title + '\'' +
                ", a_author='" + a_author + '\'' +
                ", a_content='" + a_content + '\'' +
                ", a_date=" + a_date +
                ", comments=" + comments +
                ", categories=" + categories +
                '}';
    }
}
