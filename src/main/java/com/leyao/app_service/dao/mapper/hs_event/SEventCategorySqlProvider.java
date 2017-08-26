package com.leyao.app_service.dao.mapper.hs_event;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.hs_event.SEventCategory;

public class SEventCategorySqlProvider {

    public String insertSelective(SEventCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_event_category");
        
        if (record.getsEventCategoryId() != null) {
            sql.VALUES("s_event_category_id", "#{sEventCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventCategoryCd() != null) {
            sql.VALUES("s_event_category_cd", "#{sEventCategoryCd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SEventCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("s_event_category");
        
        if (record.gethEventId() != null) {
            sql.SET("h_event_id = #{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventCategoryCd() != null) {
            sql.SET("s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("s_event_category_id = #{sEventCategoryId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}