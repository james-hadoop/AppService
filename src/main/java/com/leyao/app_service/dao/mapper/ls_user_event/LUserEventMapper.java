package com.leyao.app_service.dao.mapper.ls_user_event;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.leyao.app_service.entity.ls_user_event.LUserEvent;

public interface LUserEventMapper {
    @Delete({
        "delete from l_user_event",
        "where l_user_event_id = #{lUserEventId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long lUserEventId);

    @Insert({
        "insert into l_user_event (l_user_event_id, h_user_id, ",
        "h_event_id, create_ts, ",
        "update_ts)",
        "values (#{lUserEventId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{hEventId,jdbcType=BIGINT}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(LUserEvent record);

    @InsertProvider(type=LUserEventSqlProvider.class, method="insertSelective")
    int insertSelective(LUserEvent record);

    @Select({
        "select",
        "l_user_event_id, h_user_id, h_event_id, create_ts, update_ts",
        "from l_user_event",
        "where l_user_event_id = #{lUserEventId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="l_user_event_id", property="lUserEventId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    LUserEvent selectByPrimaryKey(Long lUserEventId);

    @UpdateProvider(type=LUserEventSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LUserEvent record);

    @Update({
        "update l_user_event",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "h_event_id = #{hEventId,jdbcType=BIGINT},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where l_user_event_id = #{lUserEventId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LUserEvent record);
    
    @Select({"select max(l_user_event_id) as l_user_event_id from ls_user_event.l_user_event"})
    @Results({
        @Result(column="l_user_event_id", property="lUserEventId", jdbcType=JdbcType.BIGINT)
    })
    long getMaxLUserEventId();
}