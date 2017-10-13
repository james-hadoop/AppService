package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserPassword;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserPasswordMapper {
    @Delete({
        "delete from s_user_password",
        "where s_user_password_id = #{sUserPasswordId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserPasswordId);

    @Insert({
        "insert into s_user_password (s_user_password_id, h_user_id, ",
        "s_user_password_str, create_ts, ",
        "update_ts)",
        "values (#{sUserPasswordId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserPasswordStr,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserPassword record);

    @InsertProvider(type=SUserPasswordSqlProvider.class, method="insertSelective")
    int insertSelective(SUserPassword record);

    @Select({
        "select",
        "s_user_password_id, h_user_id, s_user_password_str, create_ts, update_ts",
        "from s_user_password",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_password_id", property="sUserPasswordId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_password_str", property="sUserPasswordStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserPassword selectByPrimaryKey(Long sUserPasswordId);

    @UpdateProvider(type=SUserPasswordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserPassword record);

    @Update({
        "update s_user_password",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_password_str = #{sUserPasswordStr,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_password_id = #{sUserPasswordId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserPassword record);
}