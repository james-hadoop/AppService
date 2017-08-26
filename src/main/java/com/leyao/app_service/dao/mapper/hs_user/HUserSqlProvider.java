package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.HUser;
import org.apache.ibatis.jdbc.SQL;

public class HUserSqlProvider {

    public String insertSelective(HUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("h_user");
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserPhoneNr() != null) {
            sql.VALUES("h_user_phone_nr", "#{hUserPhoneNr,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HUser record) {
        SQL sql = new SQL();
        sql.UPDATE("h_user");
        
        if (record.gethUserPhoneNr() != null) {
            sql.SET("h_user_phone_nr = #{hUserPhoneNr,jdbcType=INTEGER}");
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