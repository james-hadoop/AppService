package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserProfile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserProfileMapper {
    @Delete({
        "delete from s_user_profile",
        "where s_user_profile_id = #{sUserProfileId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserProfileId);

    @Insert({
        "insert into s_user_profile (s_user_profile_id, h_user_id, ",
        "s_user_profile_url, create_ts, ",
        "update_ts)",
        "values (#{sUserProfileId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserProfileUrl,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserProfile record);

    @InsertProvider(type=SUserProfileSqlProvider.class, method="insertSelective")
    int insertSelective(SUserProfile record);

    @Select({
        "select",
        "s_user_profile_id, h_user_id, s_user_profile_url, create_ts, update_ts",
        "from s_user_profile",
        "where s_user_profile_id = #{sUserProfileId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_profile_id", property="sUserProfileId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_profile_url", property="sUserProfileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserProfile selectByPrimaryKey(Long sUserProfileId);

    @UpdateProvider(type=SUserProfileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserProfile record);

    @Update({
        "update s_user_profile",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_profile_url = #{sUserProfileUrl,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_profile_id = #{sUserProfileId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserProfile record);
}