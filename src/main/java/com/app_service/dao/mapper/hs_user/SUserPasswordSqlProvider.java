package com.app_service.dao.mapper.hs_user;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_user.SUserPassword;

public class SUserPasswordSqlProvider {

    public String insertSelective(SUserPassword record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_password");
        
        if (record.getsUserPasswordId() != null) {
            sql.VALUES("s_user_password_id", "#{sUserPasswordId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserPasswordStr() != null) {
            sql.VALUES("s_user_password_str", "#{sUserPasswordStr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserPassword record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_password");
        
        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserPasswordStr() != null) {
            sql.SET("s_user_password_str = #{sUserPasswordStr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("h_user_id = #{hUserId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}