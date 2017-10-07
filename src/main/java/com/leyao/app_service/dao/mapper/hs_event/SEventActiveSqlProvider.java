package com.leyao.app_service.dao.mapper.hs_event;

import com.leyao.app_service.entity.hs_event.SEventActive;
import org.apache.ibatis.jdbc.SQL;

public class SEventActiveSqlProvider {

    public String insertSelective(SEventActive record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_active");
        
        if (record.getsEventActiveId() != null) {
            sql.VALUES("s_event_active_id", "#{sEventActiveId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventActiveInd() != null) {
            sql.VALUES("s_event_active_ind", "#{sEventActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventActive record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_active");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventActiveInd() != null) {
            sql.SET("s_event_active_ind = #{sEventActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("h_event_id = #{hEventId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}