package com.rabbiter.association.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.rabbiter.association.entity.Activities;

import java.util.Map;

/**
 * 数据层处理接口
 * 活动信息
 */
@Repository("activitiesDao")
public interface ActivitiesDao extends BaseMapper<Activities> {

    /**
     * 分页查看全部活动信息
     * @param page 分页信息
     * @param activeName 活动名称
     * @param teamName 团队名称
     * t.type_id status由于没有参数，用一下typeid当作鸿蒙的状态返回值，用于判断当前活动是否被参加
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "a.id, a.name, a.comm, a.detail, a.ask, a.total, " +
            "a.active_time activeTime, a.team_id teamId, t.name teamName " +
            "FROM activities a, teams t " +
            "<where>" +
            "a.team_id = t.id " +
            "<if test='teamName != null and teamName.trim() != &quot;&quot; '>" +
            "AND t.name LIKE CONCAT('%', #{teamName}, '%') " +
            "</if>" +
            "<if test='activeName != null and activeName.trim() != &quot;&quot; '>" +
            "AND a.name LIKE CONCAT('%', #{activeName}, '%') " +
            "</if>" +
            "</where>" +
            "ORDER BY a.active_time DESC" +
            "</script>")
    public Page<Map<String, Object>> qryPageAll(Page<Map<String, Object>> page,
                                                @Param("activeName") String activeName,
                                                @Param("teamName") String teamName);
//    @Select("<script>" +
//            "SELECT " +
//            "a.id, a.name, a.comm, a.detail, a.ask, a.total, " +
//            "a.active_time activeTime, a.team_id teamId, t.name teamName t.type_id status " +
//            "FROM activities a, teams t " +
//            "<where>" +
//            "a.team_id = t.id " +
//            "<if test='teamName != null and teamName.trim() != &quot;&quot; '>" +
//            "AND t.name LIKE CONCAT('%', #{teamName}, '%') " +
//            "</if>" +
//            "<if test='activeName != null and activeName.trim() != &quot;&quot; '>" +
//            "AND a.name LIKE CONCAT('%', #{activeName}, '%') " +
//            "</if>" +
//            "</where>" +
//            "ORDER BY a.active_time DESC" +
//            "</script>")
//    public Page<Map<String, Object>> qryPageAll(Page<Map<String, Object>> page,
//                                                @Param("teamName") String teamName,
//                                                @Param("activeName") String activeName);

    /**
     * 分页查看全部活动信息
     * @param page 分页信息
     * @param activeName 活动名称
     * @param teamName 团队名称
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "a.id, a.name, a.comm, a.detail, a.ask, a.total, " +
            "a.active_time activeTime, a.team_id teamId, t.name teamName " +
            "FROM activities a, teams t " +
            "<where>" +
            "a.team_id = t.id " +
            "<if test='teamName != null and teamName.trim() != &quot;&quot; '>" +
            "AND t.name LIKE CONCAT('%', #{teamName}, '%') " +
            "</if>" +
            "<if test='activeName != null and activeName.trim() != &quot;&quot; '>" +
            "AND a.name LIKE CONCAT('%', #{activeName}, '%') " +
            "</if>" +
            "</where>" +
            "ORDER BY a.active_time DESC" +
            "</script>")
    public Page<Map<String, Object>> qryPageAll_Hom(Page<Map<String, Object>> page,
                                                @Param("teamName") String teamName,
                                                @Param("activeName") String activeName);

    /**
     * 分页查询指定成员相关的活动信息
     * @param page 分页信息
     * @param memId 成员ID
     * @param activeName 活动名称
     * @param teamName 团队名称
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "a.id, a.name, a.comm, a.detail, a.ask, a.total, " +
            "a.active_time activeTime, a.team_id teamId, t.name teamName " +
            "FROM activities a, teams t " +
            "<where>" +
            "a.team_id = t.id AND a.team_id IN (SELECT team_id FROM members WHERE user_id = #{memId}) " +
            "<if test='teamName != null and teamName.trim() != &quot;&quot; '>" +
            "AND t.name LIKE CONCAT('%', #{teamName}, '%') " +
            "</if>" +
            "<if test='activeName != null and activeName.trim() != &quot;&quot; '>" +
            "AND a.name LIKE CONCAT('%', #{activeName}, '%') " +
            "</if>" +
            "</where>" +
            "ORDER BY a.active_time DESC" +
            "</script>")
    public Page<Map<String, Object>> qryPageByMemId(Page<Map<String, Object>> page,
                                                    @Param("memId") String memId,
                                                    @Param("teamName") String teamName,
                                                    @Param("activeName") String activeName);
}