package com.leyao.app_service.dao.mapper.hs_message;

import com.leyao.app_service.entity.hs_message.SMessageContent;
import org.apache.ibatis.jdbc.SQL;

public class SMessageContentSqlProvider {

    public String insertSelective(SMessageContent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_message_content");
        
        if (record.getsMessageContentId() != null) {
            sql.VALUES("s_message_content_id", "#{sMessageContentId,jdbcType=BIGINT}");
        }
        
        if (record.gethMessageId() != null) {
            sql.VALUES("h_message_id", "#{hMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getsMessageContentStr() != null) {
            sql.VALUES("s_message_content_str", "#{sMessageContentStr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SMessageContent record) {
        SQL sql = new SQL();
        sql.UPDATE("s_message_content");
        
        if (record.gethMessageId() != null) {
            sql.SET("h_message_id = #{hMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getsMessageContentStr() != null) {
            sql.SET("s_message_content_str = #{sMessageContentStr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_message_content_id = #{sMessageContentId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}