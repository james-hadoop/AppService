package com.leyao.app_service.dao.mapper.ls_user_message;

import com.leyao.app_service.entity.ls_user_message.SUserMessageActive;
import org.apache.ibatis.jdbc.SQL;

public class SUserMessageActiveSqlProvider {

    public String insertSelective(SUserMessageActive record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_message_active");
        
        if (record.getsUserMessageActiveId() != null) {
            sql.VALUES("s_user_message_active_id", "#{sUserMessageActiveId,jdbcType=BIGINT}");
        }
        
        if (record.getlUserMessageId() != null) {
            sql.VALUES("l_user_message_id", "#{lUserMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserMessageActiveInd() != null) {
            sql.VALUES("s_user_message_active_ind", "#{sUserMessageActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserMessageActive record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_message_active");
        
        if (record.getlUserMessageId() != null) {
            sql.SET("l_user_message_id = #{lUserMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserMessageActiveInd() != null) {
            sql.SET("s_user_message_active_ind = #{sUserMessageActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_user_message_active_id = #{sUserMessageActiveId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}