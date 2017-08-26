package com.leyao.app_service.dao.mapper.ls_user_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.ls_user_event.SUserEventRead;

public class SUserEventReadSqlProvider {

    public String insertSelective(SUserEventRead record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_event_read");
        
        if (record.getsUserEventReadId() != null) {
            sql.VALUES("s_user_event_read_id", "#{sUserEventReadId,jdbcType=BIGINT}");
        }
        
        if (record.getlUserEventId() != null) {
            sql.VALUES("l_user_event_id", "#{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getsUserEventReadLogTxt() != null) {
            sql.VALUES("s_user_event_read_log_txt", "#{sUserEventReadLogTxt,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserEventRead record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_event_read");
        
        if (record.getlUserEventId() != null) {
            sql.SET("l_user_event_id = #{lUserEventId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getsUserEventReadLogTxt() != null) {
            sql.SET("s_user_event_read_log_txt = #{sUserEventReadLogTxt,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("s_user_event_read_id = #{sUserEventReadId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}