package com.leyao.app_service.dao.mapper.hs_event;

import com.leyao.app_service.entity.hs_event.TEventPage;
import org.apache.ibatis.jdbc.SQL;

public class TEventPageSqlProvider {

    public String insertSelective(TEventPage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_event_page");
        
        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }
        
        if (record.getsEventCategoryCd() != null) {
            sql.VALUES("s_event_category_cd", "#{sEventCategoryCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventCategoryDesc() != null) {
            sql.VALUES("r_event_category_desc", "#{rEventCategoryDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventTypeCd() != null) {
            sql.VALUES("s_event_type_cd", "#{sEventTypeCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventTypeDesc() != null) {
            sql.VALUES("r_event_type_desc", "#{rEventTypeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventTitleUrl() != null) {
            sql.VALUES("s_event_title_url", "#{sEventTitleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventContentUrl() != null) {
            sql.VALUES("s_event_content_url", "#{sEventContentUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventSubContent1Url() != null) {
            sql.VALUES("s_event_sub_content_1_url", "#{sEventSubContent1Url,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventSubContent2Str() != null) {
            sql.VALUES("s_event_sub_content_2_str", "#{sEventSubContent2Str,jdbcType=VARCHAR}");
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
        
        if (record.getsEventSearchContentTxt() != null) {
            sql.VALUES("s_event_search_content_txt", "#{sEventSearchContentTxt,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TEventPage record) {
        SQL sql = new SQL();
        sql.UPDATE("t_event_page");
        
        if (record.getsEventCategoryCd() != null) {
            sql.SET("s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventCategoryDesc() != null) {
            sql.SET("r_event_category_desc = #{rEventCategoryDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventTypeCd() != null) {
            sql.SET("s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventTypeDesc() != null) {
            sql.SET("r_event_type_desc = #{rEventTypeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventTitleUrl() != null) {
            sql.SET("s_event_title_url = #{sEventTitleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventContentUrl() != null) {
            sql.SET("s_event_content_url = #{sEventContentUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventSubContent1Url() != null) {
            sql.SET("s_event_sub_content_1_url = #{sEventSubContent1Url,jdbcType=VARCHAR}");
        }
        
        if (record.getsEventSubContent2Str() != null) {
            sql.SET("s_event_sub_content_2_str = #{sEventSubContent2Str,jdbcType=VARCHAR}");
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
        
        if (record.getsEventSearchContentTxt() != null) {
            sql.SET("s_event_search_content_txt = #{sEventSearchContentTxt,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("h_event_id = #{hEventId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}