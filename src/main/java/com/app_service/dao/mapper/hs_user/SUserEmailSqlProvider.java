package com.app_service.dao.mapper.hs_user;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_user.SUserEmail;

public class SUserEmailSqlProvider {

    public String insertSelective(SUserEmail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_email");
        
        if (record.getsUserEmailId() != null) {
            sql.VALUES("s_user_email_id", "#{sUserEmailId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserEmailStr() != null) {
            sql.VALUES("s_user_email_str", "#{sUserEmailStr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserEmail record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_email");
        
        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserEmailStr() != null) {
            sql.SET("s_user_email_str = #{sUserEmailStr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_user_email_id = #{sUserEmailId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}