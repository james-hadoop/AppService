package com.app_service.dao.mapper.ls_user_event;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.ls_user_event.SUserEventLike;

public interface SUserEventLikeMapper {
    @Delete({
        "delete from s_user_event_like",
        "where s_user_event_like_id = #{sUserEventLikeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserEventLikeId);

    @Insert({
        "insert into s_user_event_like (s_user_event_like_id, l_user_event_id, ",
        "s_user_event_like_ind, create_ts, ",
        "update_ts)",
        "values (#{sUserEventLikeId,jdbcType=BIGINT}, #{lUserEventId,jdbcType=BIGINT}, ",
        "#{sUserEventLikeInd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserEventLike record);

    @InsertProvider(type=SUserEventLikeSqlProvider.class, method="insertSelective")
    int insertSelective(SUserEventLike record);

    @Select({
        "select",
        "s_user_event_like_id, l_user_event_id, s_user_event_like_ind, create_ts, update_ts",
        "from s_user_event_like",
        "where s_user_event_like_id = #{sUserEventLikeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_event_like_id", property="sUserEventLikeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="l_user_event_id", property="lUserEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_event_like_ind", property="sUserEventLikeInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserEventLike selectByPrimaryKey(Long sUserEventLikeId);

    @UpdateProvider(type=SUserEventLikeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserEventLike record);

    @Update({
        "update s_user_event_like",
        "set l_user_event_id = #{lUserEventId,jdbcType=BIGINT},",
          "s_user_event_like_ind = #{sUserEventLikeInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_event_like_id = #{sUserEventLikeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserEventLike record);
}