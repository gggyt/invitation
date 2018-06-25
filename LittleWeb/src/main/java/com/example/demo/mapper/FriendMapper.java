package com.example.demo.mapper;

import com.example.demo.Entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
@Mapper
public interface FriendMapper {

    List<Friend> findFriendOrNotWithOther(@Param("mainFriendName") String mainFriendName, @Param("otherFriendName") String otherFriendName);

    void addFriendWithMe(@Param("myUserName") String myUserName, @Param("friendName") String friendName, @Param("friendOrNot") int friendOrNot);

    List<Friend> getAllDontAgreeFriend(String nowUserName);

    void addSomeoneToFriend(@Param("mainFriendName") String mainFriendName, @Param("otherFriendName") String otherFriendName);

    List<Friend> getAllAddFriend(@Param("myUserName") String myUserName, @Param("friendOrNot") int friendOrNot);
    void deleteMyFriend(@Param("name1") String name1, @Param("name2") String name2);
}
