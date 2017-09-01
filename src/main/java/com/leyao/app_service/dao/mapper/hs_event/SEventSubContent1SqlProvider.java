package com.leyao.app_service.dao.mapper.hs_event;

import com.leyao.app_service.entity.hs_event.SEventSubContent1;
import org.apache.ibatis.jdbc.SQL;

public class SEventSubContent1SqlProvider {

    public String insertSelective(SEventSubContent1 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_sub_content_1");
        
        if (record.getsEventSubContent1Id() != null) {
            sql.VALUES("s_event_sub_content_1_id", "#{sEventSubContent1Id,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventSubContent1Url() != null) {
            sql.VALUES("s_event_sub_content_1_url", "#{sEventSubContent1Url,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventSubContent1 record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_sub_content_1");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventSubContent1Url() != null) {
            sql.SET("s_event_sub_content_1_url = #{sEventSubContent1Url,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_event_sub_content_1_id = #{sEventSubContent1Id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}