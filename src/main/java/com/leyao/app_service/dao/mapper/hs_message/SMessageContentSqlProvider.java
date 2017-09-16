package com.leyao.app_service.dao.mapper.hs_message;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.leyao.app_service.entity.hs_message.SMessageContent;

public class SMessageContentSqlProvider {

    public String insertSelective(SMessageContent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_message_content");

        if (record.getsMessageContentId() != null) {
            sql.VALUES("s_message_content_id", "#{sMessageContentId,jdbcType=BIGINT}");
        }

        if (record.gethMessageId() != null) {
            sql.VALUES("h_message_id", "#{hMessageId,jdbcType=BIGINT}");
        }

        if (record.getsMessageContentStr() != null) {
            sql.VALUES("s_message_content_str", "#{sMessageContentStr,jdbcType=VARCHAR}");
        }

        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SMessageContent record) {
        SQL sql = new SQL();
        sql.UPDATE("s_message_content");

        if (record.gethMessageId() != null) {
            sql.SET("h_message_id = #{hMessageId,jdbcType=BIGINT}");
        }

        if (record.getsMessageContentStr() != null) {
            sql.SET("s_message_content_str = #{sMessageContentStr,jdbcType=VARCHAR}");
        }

        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("s_message_content_id = #{sMessageContentId,jdbcType=BIGINT}");

        return sql.toString();
    }

    public static String getTMessageSummaryList(Map<String, Object> paramMap) {
        SQL sql = new SQL();
        sql.SELECT("c.*, ca.s_message_category_cd").FROM("hs_message.s_message_content c");

        if (paramMap.get("hMessageId") != null) {
            sql.OR().WHERE("c.h_message_id = #{hMessageId,jdbcType=BIGINT}");
        }

        if (paramMap.get("sMessageCategoryCd") != null) {
            sql.OR().WHERE("s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER}");
        }

        sql.INNER_JOIN("hs_message.s_message_active a on a.h_message_id= c.h_message_id and a.s_message_active_ind=0").INNER_JOIN("hs_message.s_message_category ca on ca.h_message_id= c.h_message_id");

        return sql.toString();
    }
    
    public String getTMessageSummaryListCount(Map<String, Object> paramMap) {
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("hs_message.s_message_content c");

        if (paramMap.get("hMessageId") != null) {
            sql.OR().WHERE("c.h_message_id = #{hMessageId,jdbcType=BIGINT}");
        }

        if (paramMap.get("sMessageCategoryCd") != null) {
            sql.OR().WHERE("s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER}");
        }
        
        sql.INNER_JOIN("hs_message.s_message_active a on a.h_message_id= c.h_message_id and a.s_message_active_ind=0").INNER_JOIN("hs_message.s_message_category ca on ca.h_message_id= c.h_message_id");
        
        return sql.toString();
    }

//    public static void main(String[] args) {
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("hMessageId", 1);
//        paramMap.put("sMessageCategoryCd", 1);
//
//        String sql = getTMessageSummaryList(paramMap);
//        System.out.println("sql=\n" + sql);
//        
//        String sqlCount = getTMessageSummaryListCount(paramMap);
//        System.out.println("sqlCount=\n" + sqlCount);
//    }
}