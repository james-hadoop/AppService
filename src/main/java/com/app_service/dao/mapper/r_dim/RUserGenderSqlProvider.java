package com.app_service.dao.mapper.r_dim;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.r_dim.RUserGender;

public class RUserGenderSqlProvider {

    public String insertSelective(RUserGender record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("r_user_gender");
        
        if (record.getrUserGenderCd() != null) {
            sql.VALUES("r_user_gender_cd", "#{rUserGenderCd,jdbcType=INTEGER}");
        }
        
        if (record.getrUserGenderDesc() != null) {
            sql.VALUES("r_user_gender_desc", "#{rUserGenderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RUserGender record) {
        SQL sql = new SQL();
        sql.UPDATE("r_user_gender");
        
        if (record.getrUserGenderDesc() != null) {
            sql.SET("r_user_gender_desc = #{rUserGenderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("r_user_gender_cd = #{rUserGenderCd,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}