package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserActive;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserActiveMapper {
    @Delete({
        "delete from s_user_active",
        "where s_user_active_id = #{sUserActiveId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserActiveId);

    @Insert({
        "insert into s_user_active (s_user_active_id, h_user_id, ",
        "s_user_active_ind, create_ts, ",
        "update_ts)",
        "values (#{sUserActiveId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserActiveInd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserActive record);

    @InsertProvider(type=SUserActiveSqlProvider.class, method="insertSelective")
    int insertSelective(SUserActive record);

    @Select({
        "select",
        "s_user_active_id, h_user_id, s_user_active_ind, create_ts, update_ts",
        "from s_user_active",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_active_id", property="sUserActiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_active_ind", property="sUserActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserActive selectByPrimaryKey(Long sUserActiveId);

    @UpdateProvider(type=SUserActiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserActive record);

    @Update({
        "update s_user_active",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_active_ind = #{sUserActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_active_id = #{sUserActiveId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserActive record);
}