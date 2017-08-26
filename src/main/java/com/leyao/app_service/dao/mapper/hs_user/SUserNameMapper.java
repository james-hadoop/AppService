package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserName;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserNameMapper {
    @Delete({
        "delete from s_user_name",
        "where s_user_name_id = #{sUserNameId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserNameId);

    @Insert({
        "insert into s_user_name (s_user_name_id, h_user_id, ",
        "s_user_name_str, create_ts, ",
        "update_ts)",
        "values (#{sUserNameId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserNameStr,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserName record);

    @InsertProvider(type=SUserNameSqlProvider.class, method="insertSelective")
    int insertSelective(SUserName record);

    @Select({
        "select",
        "s_user_name_id, h_user_id, s_user_name_str, create_ts, update_ts",
        "from s_user_name",
        "where s_user_name_id = #{sUserNameId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_name_id", property="sUserNameId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_name_str", property="sUserNameStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserName selectByPrimaryKey(Long sUserNameId);

    @UpdateProvider(type=SUserNameSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserName record);

    @Update({
        "update s_user_name",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_name_str = #{sUserNameStr,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_name_id = #{sUserNameId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserName record);
}