package com.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_event.SEventSubContent2;

public class SEventSubContent2SqlProvider {

    public String insertSelective(SEventSubContent2 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_sub_content_2");
        
        if (record.getsEventSubContent2Id() != null) {
            sql.VALUES("s_event_sub_content_2_id", "#{sEventSubContent2Id,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventSubContent2Str() != null) {
            sql.VALUES("s_event_sub_content_2_str", "#{sEventSubContent2Str,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventSubContent2 record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_sub_content_2");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventSubContent2Str() != null) {
            sql.SET("s_event_sub_content_2_str = #{sEventSubContent2Str,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_event_sub_content_2_id = #{sEventSubContent2Id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}