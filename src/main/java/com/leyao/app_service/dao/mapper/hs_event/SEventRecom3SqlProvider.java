package com.leyao.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.hs_event.SEventRecom3;

public class SEventRecom3SqlProvider {

    public String insertSelective(SEventRecom3 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_recom_3");
        
        if (record.getsEventRecom3Id() != null) {
            sql.VALUES("s_event_recom_3_id", "#{sEventRecom3Id,jdbcType=BIGINT}");
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

    public String updateByPrimaryKeySelective(SEventRecom3 record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_recom_3");
        
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