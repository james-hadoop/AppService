package com.app_service.dao.mapper.hs_user;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.hs_user.SUserSearch;

public interface SUserSearchMapper {
    @Delete({
        "delete from s_user_search",
        "where s_user_search_id = #{sUserSearchId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserSearchId);

    @Insert({
        "insert into s_user_search (s_user_search_id, h_user_id, ",
        "s_user_feedback_str, create_ts, ",
        "update_ts)",
        "values (#{sUserSearchId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserFeedbackStr,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserSearch record);

    @InsertProvider(type=SUserSearchSqlProvider.class, method="insertSelective")
    int insertSelective(SUserSearch record);

    @Select({
        "select",
        "s_user_search_id, h_user_id, s_user_feedback_str, create_ts, update_ts",
        "from s_user_search",
        "where s_user_search_id = #{sUserSearchId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_search_id", property="sUserSearchId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_feedback_str", property="sUserFeedbackStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserSearch selectByPrimaryKey(Long sUserSearchId);

    @UpdateProvider(type=SUserSearchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserSearch record);

    @Update({
        "update s_user_search",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_feedback_str = #{sUserFeedbackStr,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_search_id = #{sUserSearchId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserSearch record);
}