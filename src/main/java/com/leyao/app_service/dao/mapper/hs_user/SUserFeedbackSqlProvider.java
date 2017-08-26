package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserFeedback;
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
}