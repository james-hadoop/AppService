package com.leyao.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.hs_event.HsEvent;

public class HsEventSqlProvider {

    public String insertSelective(HsEvent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hs_event");
        
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

    public String updateByPrimaryKeySelective(HsEvent record) {
        SQL sql = new SQL();
        sql.UPDATE("hs_event");
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("h_event_id = #{hEventId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}