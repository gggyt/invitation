package com.example.demo.Entity;

import java.util.List;

/**
 * Created by ggg on 2018/5/30.
 * CommentAndSon实体
 */
public class CommentAndSon {
    private Comment FComment;
    private List<Comment> SComment;

    public Comment getFComment() {
        return FComment;
    }

    public void setFComment(Comment FComment) {
        this.FComment = FComment;
    }

    public List<Comment> getSComment() {
        return SComment;
    }

    public void setSComment(List<Comment> SComment) {
        this.SComment = SComment;
    }
}
