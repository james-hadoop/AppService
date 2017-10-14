package com.leyao.app_service.dao.mapper.hs_message;

import com.leyao.app_service.entity.hs_message.HsMessage;
import org.apache.ibatis.jdbc.SQL;

public class HsMessageSqlProvider {

    public String insertSelective(HsMessage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hs_message.hs_message");
        
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

    public String updateByPrimaryKeySelective(HsMessage record) {
        SQL sql = new SQL();
        sql.UPDATE("hs_message");
        
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