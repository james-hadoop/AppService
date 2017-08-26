package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserEmail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserEmailMapper {
    @Delete({
        "delete from s_user_email",
        "where s_user_email_id = #{sUserEmailId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserEmailId);

    @Insert({
        "insert into s_user_email (s_user_email_id, h_user_id, ",
        "s_user_email_str, create_ts, ",
        "update_ts)",
        "values (#{sUserEmailId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserEmailStr,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserEmail record);

    @InsertProvider(type=SUserEmailSqlProvider.class, method="insertSelective")
    int insertSelective(SUserEmail record);

    @Select({
        "select",
        "s_user_email_id, h_user_id, s_user_email_str, create_ts, update_ts",
        "from s_user_email",
        "where s_user_email_id = #{sUserEmailId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_email_id", property="sUserEmailId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_email_str", property="sUserEmailStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserEmail selectByPrimaryKey(Long sUserEmailId);

    @UpdateProvider(type=SUserEmailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserEmail record);

    @Update({
        "update s_user_email",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_email_str = #{sUserEmailStr,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_email_id = #{sUserEmailId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserEmail record);
}