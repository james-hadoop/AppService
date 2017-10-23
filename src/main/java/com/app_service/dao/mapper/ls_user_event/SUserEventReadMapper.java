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

import com.app_service.entity.ls_user_event.SUserEventRead;

public interface SUserEventReadMapper {
    @Delete({
        "delete from s_user_event_read",
        "where s_user_event_read_id = #{sUserEventReadId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserEventReadId);

    @Insert({
        "insert into s_user_event_read (s_user_event_read_id, l_user_event_id, ",
        "create_ts, update_ts, ",
        "s_user_event_read_log_txt)",
        "values (#{sUserEventReadId,jdbcType=BIGINT}, #{lUserEventId,jdbcType=BIGINT}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP}, ",
        "#{sUserEventReadLogTxt,jdbcType=LONGVARCHAR})"
    })
    int insert(SUserEventRead record);

    @InsertProvider(type=SUserEventReadSqlProvider.class, method="insertSelective")
    int insertSelective(SUserEventRead record);

    @Select({
        "select",
        "s_user_event_read_id, l_user_event_id, create_ts, update_ts, s_user_event_read_log_txt",
        "from s_user_event_read",
        "where s_user_event_read_id = #{sUserEventReadId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_event_read_id", property="sUserEventReadId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="l_user_event_id", property="lUserEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="s_user_event_read_log_txt", property="sUserEventReadLogTxt", jdbcType=JdbcType.LONGVARCHAR)
    })
    SUserEventRead selectByPrimaryKey(Long sUserEventReadId);

    @UpdateProvider(type=SUserEventReadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserEventRead record);

    @Update({
        "update s_user_event_read",
        "set l_user_event_id = #{lUserEventId,jdbcType=BIGINT},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP},",
          "s_user_event_read_log_txt = #{sUserEventReadLogTxt,jdbcType=LONGVARCHAR}",
        "where s_user_event_read_id = #{sUserEventReadId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(SUserEventRead record);

    @Update({
        "update s_user_event_read",
        "set l_user_event_id = #{lUserEventId,jdbcType=BIGINT},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_event_read_id = #{sUserEventReadId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserEventRead record);
}