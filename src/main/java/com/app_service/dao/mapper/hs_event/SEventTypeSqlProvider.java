package com.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_event.SEventType;

public class SEventTypeSqlProvider {

    public String insertSelective(SEventType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_type");
        
        if (record.getsEventTypeId() != null) {
            sql.VALUES("S_EVENT_TYPE_ID", "#{sEventTypeId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("H_EVENT_ID", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventTypeCd() != null) {
            sql.VALUES("S_EVENT_TYPE_CD", "#{sEventTypeCd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventType record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_type");
        
        if (record.gethEventId() != null) {
            sql.SET("H_EVENT_ID = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventTypeCd() != null) {
            sql.SET("S_EVENT_TYPE_CD = #{sEventTypeCd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("H_EVENT_ID = #{hEventId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}