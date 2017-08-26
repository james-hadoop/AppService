package com.leyao.app_service.dao.mapper.ls_user_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.ls_user_event.SUserEventLike;

public class SUserEventLikeSqlProvider {

    public String insertSelective(SUserEventLike record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_event_like");
        
        if (record.getsUserEventLikeId() != null) {
            sql.VALUES("s_user_event_like_id", "#{sUserEventLikeId,jdbcType=BIGINT}");
        }
        
        if (record.getlUserEventId() != null) {
            sql.VALUES("l_user_event_id", "#{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserEventLikeInd() != null) {
            sql.VALUES("s_user_event_like_ind", "#{sUserEventLikeInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserEventLike record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_event_like");
        
        if (record.getlUserEventId() != null) {
            sql.SET("l_user_event_id = #{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserEventLikeInd() != null) {
            sql.SET("s_user_event_like_ind = #{sUserEventLikeInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_user_event_like_id = #{sUserEventLikeId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}