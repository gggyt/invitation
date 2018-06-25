package com.example.demo.mapper;

import com.example.demo.Entity.Fans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
@Mapper
public interface FansMapper {
    List<Fans> getAllMyFans(String nowUserName);
    List<Fans> isFansOrNot(@Param("mainFriendName") String mainFriendName, @Param("otherFriendName") String otherFriendName);
    int getAllFansNum(String mainFriendName);
    void addMeToSomebodyFan(@Param("mainFriendName") String mainFriendName, @Param("otherFriendName") String otherFriendName);
    void cancelToBeSomebodyFan(@Param("mainFriendName") String mainFriendName, @Param("otherFriendName") String otherFriendName);
}
