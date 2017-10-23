package com.app_service.dao.mapper.hs_user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.hs_user.SUserFeedback;
import com.app_service.entity.hs_user.SUserFeedbackSummary;

public interface SUserFeedbackMapper {
    @Delete({ "delete from s_user_feedback", "where s_user_feedback_id = #{sUserFeedbackId,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long sUserFeedbackId);

    @Insert({ "insert into s_user_feedback (s_user_feedback_id, h_user_id, ", "s_user_feedback_str, create_ts, ",
            "update_ts)", "values (#{sUserFeedbackId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
            "#{sUserFeedbackStr,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
            "#{updateTs,jdbcType=TIMESTAMP})" })
    int insert(SUserFeedback record);

    @InsertProvider(type = SUserFeedbackSqlProvider.class, method = "insertSelective")
    int insertSelective(SUserFeedback record);

    @Select({ "select", "s_user_feedback_id, h_user_id, s_user_feedback_str, create_ts, update_ts",
            "from s_user_feedback", "where s_user_feedback_id = #{sUserFeedbackId,jdbcType=BIGINT}" })
    @Results({
            @Result(column = "s_user_feedback_id", property = "sUserFeedbackId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "h_user_id", property = "hUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "s_user_feedback_str", property = "sUserFeedbackStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP) })
    SUserFeedback selectByPrimaryKey(Long sUserFeedbackId);

    @UpdateProvider(type = SUserFeedbackSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserFeedback record);

    @Update({ "update s_user_feedback", "set h_user_id = #{hUserId,jdbcType=BIGINT},",
            "s_user_feedback_str = #{sUserFeedbackStr,jdbcType=VARCHAR},",
            "create_ts = #{createTs,jdbcType=TIMESTAMP},", "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
            "where s_user_feedback_id = #{sUserFeedbackId,jdbcType=BIGINT}" })
    int updateByPrimaryKey(SUserFeedback record);

    @SelectProvider(type = SUserFeedbackSqlProvider.class, method = "getSUserFeedbackSummaryByCondition")
    @Results({
            @Result(column = "s_user_feedback_id", property = "sUserFeedbackId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "h_user_phone_nr", property = "hUserPhoneNr", jdbcType = JdbcType.BIGINT),
            @Result(column = "h_user_id", property = "hUserId", jdbcType = JdbcType.INTEGER),
            @Result(column = "s_user_feedback_str", property = "sUserFeedbackStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP) })
    List<SUserFeedbackSummary> getSUserFeedbackSummaryByCondition(Map<String, Object> paramMap);

    @SelectProvider(type = SUserFeedbackSqlProvider.class, method = "getSUserFeedbackSummaryByConditionCount")
    Integer getSUserFeedbackSummaryByConditionCount(Map<String, Object> paramMap);
}