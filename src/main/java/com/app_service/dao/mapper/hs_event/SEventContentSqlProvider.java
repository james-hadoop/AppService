package com.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_event.SEventContent;

public class SEventContentSqlProvider {

    public String insertSelective(SEventContent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_content");
        
        if (record.getsEventContentId() != null) {
            sql.VALUES("s_event_content_id", "#{sEventContentId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventTitleUrl() != null) {
            sql.VALUES("s_event_title_url", "#{sEventTitleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventContentUrl() != null) {
            sql.VALUES("s_event_content_url", "#{sEventContentUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventContent record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_content");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventTitleUrl() != null) {
            sql.SET("s_event_title_url = #{sEventTitleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventContentUrl() != null) {
            sql.SET("s_event_content_url = #{sEventContentUrl,jdbcType=VARCHAR}");
        }
        
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