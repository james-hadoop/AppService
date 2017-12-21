package com.app_service.dao.mapper.hs_message;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_message.SMessageContent;

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

        sql.WHERE("h_message_id = #{hMessageId,jdbcType=BIGINT}");

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

        sql.INNER_JOIN("hs_message.s_message_active a on a.h_message_id= c.h_message_id and a.s_message_active_ind=0")
                .INNER_JOIN("hs_message.s_message_category ca on ca.h_message_id= c.h_message_id");

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

        sql.INNER_JOIN("hs_message.s_message_active a on a.h_message_id= c.h_message_id and a.s_message_active_ind=0")
                .INNER_JOIN("hs_message.s_message_category ca on ca.h_message_id= c.h_message_id");

        return sql.toString();
    }

    public static String getTMessageSummaryListByCondition(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("mc.*, mca.s_message_category_cd, ma.s_message_active_ind").FROM(
                "hs_user.h_user u, ls_user_message.l_user_message um, ls_user_message.s_user_message_active uma,hs_message.s_message_content mc,hs_message.s_message_category mca,hs_message.s_message_active ma");

        sql.WHERE(
                "u.h_user_id=um.h_user_id and um.l_user_message_id=uma.l_user_message_id and uma.s_user_message_active_ind=0 and um.h_message_id=mc.h_message_id and mc.h_message_id=mca.h_message_id and mc.h_message_id=ma.h_message_id and ma.s_message_active_ind=0");

        if (paramMap.get("hUserPhoneNr") != null) {
            sql.WHERE("u.h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");
        }

        if (paramMap.get("sMessageCategoryCd") != null) {
            sql.WHERE("mca.s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER}");
        }
        
        sql.ORDER_BY("ma.s_message_active_ind");
        
        sql.ORDER_BY("mc.update_ts desc");

        if (paramMap.get("start") != null && paramMap.get("end") != null) {
            String sqlString = sql.toString() + (" limit " + paramMap.get("start") + ", " + paramMap.get("end"));
            return sqlString;
        }

        return sql.toString();
    }

    public String getTMessageSummaryListByConditionCount(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("count(1)").FROM(
                "hs_user.h_user u, ls_user_message.l_user_message um, ls_user_message.s_user_message_active uma,hs_message.s_message_content mc,hs_message.s_message_category mca,hs_message.s_message_active ma");

        sql.WHERE(
                "u.h_user_id=um.h_user_id and um.l_user_message_id=uma.l_user_message_id and uma.s_user_message_active_ind=0 and um.h_message_id= mc.h_message_id and mc.h_message_id=mca.h_message_id and mc.h_message_id=ma.h_message_id and ma.s_message_active_ind=0");

        if (paramMap.get("hUserPhoneNr") != null) {
            sql.WHERE("u.h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");
        }

        if (paramMap.get("sMessageCategoryCd") != null) {
            sql.WHERE("mca.s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER}");
        }

        return sql.toString();
    }
    
    public static String getTMessageSummaryListByConditionGlobal(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("mc.*, mca.s_message_category_cd, ma.s_message_active_ind").FROM(
                "hs_message.s_message_content mc,hs_message.s_message_category mca,hs_message.s_message_active ma");

        sql.WHERE(
                "mc.h_message_id=mca.h_message_id and mc.h_message_id=ma.h_message_id");

        if (paramMap.get("sMessageCategoryCd") != null) {
            sql.WHERE("mca.s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER}");
        }
        
        if (paramMap.get("sMessageContentStr") != null) {
            sql.WHERE("mc.s_message_content_str like concat('%', #{sMessageContentStr,jdbcType=VARCHAR}, '%')");
        }
        
        sql.ORDER_BY("ma.s_message_active_ind");
        
        sql.ORDER_BY("mc.update_ts desc");

        if (paramMap.get("start") != null && paramMap.get("end") != null) {
            String sqlString = sql.toString() + (" limit " + paramMap.get("start") + ", " + paramMap.get("end"));
            return sqlString;
        }

        return sql.toString();
    }

    public String getTMessageSummaryListByConditionCountGlobal(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("count(1)").FROM(
                "hs_message.s_message_content mc,hs_message.s_message_category mca,hs_message.s_message_active ma");

        sql.WHERE(
                "mc.h_message_id=mca.h_message_id and mc.h_message_id=ma.h_message_id");

        if (paramMap.get("sMessageCategoryCd") != null) {
            sql.WHERE("mca.s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public static void main(String[] args) {
        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("hMessageId", 1);
        // paramMap.put("sMessageCategoryCd", 1);
        //
        // String sql = getTMessageSummaryList(paramMap);
        // System.out.println("sql=\n" + sql);
        //
        // String sqlCount = getTMessageSummaryListCount(paramMap);
        // System.out.println("sqlCount=\n" + sqlCount);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("hUserPhoneNr", 13333333333l);
        paramMap.put("sMessageCategoryCd", 1);

        String sql = getTMessageSummaryListByCondition(paramMap);
        System.out.println("getTMessageSummaryListByCondition=\n" + sql);

        // String sqlCount = getTMessageSummaryListByConditionCount(paramMap);
        // System.out.println("getTMessageSummaryListByConditionCount=\n" +
        // sqlCount);
    }
}