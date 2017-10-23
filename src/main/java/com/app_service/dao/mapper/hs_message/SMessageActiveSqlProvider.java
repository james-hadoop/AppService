package com.app_service.dao.mapper.hs_message;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_message.SMessageActive;

public class SMessageActiveSqlProvider {

    public String insertSelective(SMessageActive record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_message_active");
        
        if (record.getsMessageActiveId() != null) {
            sql.VALUES("s_message_active_id", "#{sMessageActiveId,jdbcType=BIGINT}");
        }
        
        if (record.gethMessageId() != null) {
            sql.VALUES("h_message_id", "#{hMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getsMessageActiveInd() != null) {
            sql.VALUES("s_message_active_ind", "#{sMessageActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SMessageActive record) {
        SQL sql = new SQL();
        sql.UPDATE("s_message_active");
        
        if (record.gethMessageId() != null) {
            sql.SET("h_message_id = #{hMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getsMessageActiveInd() != null) {
            sql.SET("s_message_active_ind = #{sMessageActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("h_message_id = #{hMessageId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}