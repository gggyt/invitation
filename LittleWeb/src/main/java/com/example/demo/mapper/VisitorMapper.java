package com.example.demo.mapper;

import com.example.demo.Entity.Visitor;

/**
 * Created by ggg on 2018/5/29.
 */
public interface VisitorMapper {
    int findAllNum();
    void insertVisitor(Visitor visitor);
}
