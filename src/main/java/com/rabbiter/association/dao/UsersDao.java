package com.rabbiter.association.dao;

import com.rabbiter.association.entity.Notices_Hom;
import com.rabbiter.association.entity.Users_Hom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.rabbiter.association.entity.Users;

import java.util.List;

/**
 * 数据层处理接口
 * 系统用户
 */
@Repository("usersDao")
public interface UsersDao extends BaseMapper<Users> {

    /**
     * 获取鸿蒙用户
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "id,user_name,pass_word,name,gender,age,phone,address,status,create_time,type,avatar_Url url " +
            "FROM users u,user_avatarurl a " +
            "WHERE a.user_id = id and user_name = #{userName} " +
            "</script>")
    public Users_Hom getHomUserByName(String userName);

    @Select("<script>" +
            "SELECT " +
            "id,user_name,pass_word,name,gender,age,phone,address,status,create_time,type,avatar_Url url " +
            "FROM users u,user_avatarurl a " +
            "WHERE a.user_id = id and id = #{userId} " +
            "</script>")
    public Users_Hom getOne_Hom(String userId);

    @Select("<script>" +
            "SELECT " +
            "avatar_Url url " +
            "FROM users u,user_avatarurl a " +
            "WHERE a.user_id = id and id = #{userId} " +
            "</script>")
    public String getAvatar_Hom(String userId);

    @Insert("<script>" +
            "INSERT into user_avatarurl(user_id) value (#{userId})" +
            "</script>")
    public void addUserAvatar_Hom(String userId);
}