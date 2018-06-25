package com.example.demo.TempEntity;

/**
 * Created by ggg on 2018/6/16.
 */
public class friendOrNot {
    private String nowUserName;

    private String friendName;

    private int friendOrNot;

    private int fansOrNot;

    public int getFansOrNot() {
        return fansOrNot;
    }

    public void setFansOrNot(int fansOrNot) {
        this.fansOrNot = fansOrNot;
    }

    public String getNowUserName() {
        return nowUserName;
    }

    public void setNowUserName(String nowUserName) {
        this.nowUserName = nowUserName;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getFriendOrNot() {
        return friendOrNot;
    }

    public void setFriendOrNot(int friendOrNot) {
        this.friendOrNot = friendOrNot;
    }

    @Override
    public String toString() {
        return "friendOrNot{" +
                "nowUserName='" + nowUserName + '\'' +
                ", friendName='" + friendName + '\'' +
                ", friendOrNot=" + friendOrNot +
                ", fansOrNot=" + fansOrNot +
                '}';
    }
}
