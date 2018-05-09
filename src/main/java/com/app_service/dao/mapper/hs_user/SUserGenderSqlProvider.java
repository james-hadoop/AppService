package com.app_service.dao.mapper.hs_user;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_user.SUserGender;

public class SUserGenderSqlProvider {

    public String insertSelective(SUserGender record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_gender");
        
        if (record.getsUserGenderId() != null) {
            sql.VALUES("s_user_gender_id", "#{sUserGenderId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserGenderCd() != null) {
            sql.VALUES("s_user_gender_cd", "#{sUserGenderCd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserGender record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_gender");
        
        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserGenderCd() != null) {
            sql.SET("s_user_gender_cd = #{sUserGenderCd,jdbcType=INTEGER}");
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