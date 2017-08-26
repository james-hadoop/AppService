package com.leyao.app_service.dao.mapper.ls_user_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.ls_user_event.LUserEvent;

public class LUserEventSqlProvider {

    public String insertSelective(LUserEvent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("l_user_event");
        
        if (record.getlUserEventId() != null) {
            sql.VALUES("l_user_event_id", "#{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LUserEvent record) {
        SQL sql = new SQL();
        sql.UPDATE("l_user_event");
        
        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("l_user_event_id = #{lUserEventId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}