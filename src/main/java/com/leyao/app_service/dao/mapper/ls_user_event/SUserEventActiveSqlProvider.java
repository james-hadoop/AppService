package com.leyao.app_service.dao.mapper.ls_user_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.ls_user_event.SUserEventActive;

public class SUserEventActiveSqlProvider {

    public String insertSelective(SUserEventActive record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_event_active");
        
        if (record.getsUserEventActiveId() != null) {
            sql.VALUES("s_user_event_active_id", "#{sUserEventActiveId,jdbcType=BIGINT}");
        }
        
        if (record.getlUserEventId() != null) {
            sql.VALUES("l_user_event_id", "#{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserEventActiveInd() != null) {
            sql.VALUES("s_user_event_active_ind", "#{sUserEventActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserEventActive record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_event_active");
        
        if (record.getlUserEventId() != null) {
            sql.SET("l_user_event_id = #{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsUserEventActiveInd() != null) {
            sql.SET("s_user_event_active_ind = #{sUserEventActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_user_event_active_id = #{sUserEventActiveId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}