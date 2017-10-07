package com.leyao.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.hs_event.SEventRecom1;

public class SEventRecom1SqlProvider {

    public String insertSelective(SEventRecom1 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_recom_1");
        
        if (record.getsEventRecom1Id() != null) {
            sql.VALUES("s_event_recom_1_id", "#{sEventRecom1Id,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventRecomPositionCd() != null) {
            sql.VALUES("s_event_recom_position_cd", "#{sEventRecomPositionCd,jdbcType=INTEGER}");
        }
        
        if (record.getsEventRecomActiveInd() != null) {
            sql.VALUES("s_event_recom_active_ind", "#{sEventRecomActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventRecom1 record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_recom_1");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventRecomPositionCd() != null) {
            sql.SET("s_event_recom_position_cd = #{sEventRecomPositionCd,jdbcType=INTEGER}");
        }
        
        if (record.getsEventRecomActiveInd() != null) {
            sql.SET("s_event_recom_active_ind = #{sEventRecomActiveInd,jdbcType=INTEGER}");
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