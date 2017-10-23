package com.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_event.SEventRecom2;

public class SEventRecom2SqlProvider {

    public String insertSelective(SEventRecom2 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_recom_2");
        
        if (record.getsEventRecom2Id() != null) {
            sql.VALUES("s_event_recom_2_id", "#{sEventRecom2Id,jdbcType=BIGINT}");
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

    public String updateByPrimaryKeySelective(SEventRecom2 record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_recom_2");
        
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