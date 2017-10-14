package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserActive;
import org.apache.ibatis.jdbc.SQL;

public class SUserActiveSqlProvider {

    public String insertSelective(SUserActive record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_active");
        
        if (record.getsUserActiveId() != null) {
            sql.VALUES("s_user_active_id", "#{sUserActiveId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserActiveInd() != null) {
            sql.VALUES("s_user_active_ind", "#{sUserActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserActive record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_active");
        
        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserActiveInd() != null) {
            sql.SET("s_user_active_ind = #{sUserActiveInd,jdbcType=INTEGER}");
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