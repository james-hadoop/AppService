package com.app_service.dao.mapper.ls_user_message;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.ls_user_message.LUserMessage;

public class LUserMessageSqlProvider {

    public String insertSelective(LUserMessage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("l_user_message");
        
        if (record.getlUserMessageId() != null) {
            sql.VALUES("l_user_message_id", "#{lUserMessageId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethMessageId() != null) {
            sql.VALUES("h_message_id", "#{hMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LUserMessage record) {
        SQL sql = new SQL();
        sql.UPDATE("l_user_message");
        
        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethMessageId() != null) {
            sql.SET("h_message_id = #{hMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("l_user_message_id = #{lUserMessageId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}