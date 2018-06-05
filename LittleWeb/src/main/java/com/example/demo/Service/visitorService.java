package com.example.demo.Service;

import com.example.demo.Entity.Visitor;

/**
 * Created by ggg on 2018/5/29.
 */
public interface visitorService {
    //返回所有访客数
    public int findAllNum();
    //添加访客
    public void insertVisitor(Visitor visitor);
}
