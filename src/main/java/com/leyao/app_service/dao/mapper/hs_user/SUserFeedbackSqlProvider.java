package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserFeedback;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class SUserFeedbackSqlProvider {

    public String insertSelective(SUserFeedback record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("s_user_feedback");

        if (record.getsUserFeedbackId() != null) {
            sql.VALUES("s_user_feedback_id", "#{sUserFeedbackId,jdbcType=BIGINT}");
        }

        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }

        if (record.getsUserFeedbackStr() != null) {
            sql.VALUES("s_user_feedback_str", "#{sUserFeedbackStr,jdbcType=VARCHAR}");
        }

        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SUserFeedback record) {
        SQL sql = new SQL();
        sql.UPDATE("s_user_feedback");

        if (record.gethUserId() != null) {
            sql.SET("h_user_id = #{hUserId,jdbcType=BIGINT}");
        }

        if (record.getsUserFeedbackStr() != null) {
            sql.SET("s_user_feedback_str = #{sUserFeedbackStr,jdbcType=VARCHAR}");
        }

        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("s_user_feedback_id = #{sUserFeedbackId,jdbcType=BIGINT}");

        return sql.toString();
    }

    // getSUserFeedbackSummaryByCondition
    public String getSUserFeedbackSummaryByCondition(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("u.h_user_phone_nr, uf.*").FROM("hs_user.h_user u, hs_user.s_user_feedback uf");

        sql.WHERE("u.h_user_id=uf.h_user_id");

        if (paramMap.get("hUserPhoneNr") != null) {
            sql.WHERE("u.h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");
        }

        return sql.toString();
    }

    // getSUserFeedbackSummaryByConditionCount
    public String getSUserFeedbackSummaryByConditionCount(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("count(1)").FROM("hs_user.h_user u, hs_user.s_user_feedback uf");

        sql.WHERE("u.h_user_id=uf.h_user_id");

        if (paramMap.get("hUserPhoneNr") != null) {
            sql.WHERE("u.h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");
        }

        return sql.toString();
    }
}