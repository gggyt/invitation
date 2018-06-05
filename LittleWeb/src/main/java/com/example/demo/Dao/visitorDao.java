package com.example.demo.Dao;

import com.example.demo.Entity.Visitor;

/**
 * Created by ggg on 2018/5/29.
 * 管理访客信息
 */
public interface visitorDao {
    //返回所有访客数
    public int findAllNum();
    //添加访客
    public void insertVisitor(Visitor visitor);
}
