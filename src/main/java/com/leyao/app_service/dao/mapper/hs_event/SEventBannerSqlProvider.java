package com.leyao.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.hs_event.SEventBanner;

public class SEventBannerSqlProvider {

    public String insertSelective(SEventBanner record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_banner");
        
        if (record.getsEventBannerId() != null) {
            sql.VALUES("s_event_banner_id", "#{sEventBannerId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventBannerPositionCd() != null) {
            sql.VALUES("s_event_banner_position_cd", "#{sEventBannerPositionCd,jdbcType=INTEGER}");
        }
        
        if (record.getsEventBannerActiveInd() != null) {
            sql.VALUES("s_event_banner_active_ind", "#{sEventBannerActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventBanner record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_banner");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventBannerPositionCd() != null) {
            sql.SET("s_event_banner_position_cd = #{sEventBannerPositionCd,jdbcType=INTEGER}");
        }
        
        if (record.getsEventBannerActiveInd() != null) {
            sql.SET("s_event_banner_active_ind = #{sEventBannerActiveInd,jdbcType=INTEGER}");
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