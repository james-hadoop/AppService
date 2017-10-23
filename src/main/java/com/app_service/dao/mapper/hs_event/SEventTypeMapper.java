package com.app_service.dao.mapper.hs_event;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.hs_event.SEventType;

public interface SEventTypeMapper {
    @Delete({
        "delete from s_event_type",
        "where S_EVENT_TYPE_ID = #{sEventTypeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventTypeId);

    @Insert({
        "insert into s_event_type (S_EVENT_TYPE_ID, H_EVENT_ID, ",
        "S_EVENT_TYPE_CD, create_ts, ",
        "update_ts)",
        "values (#{sEventTypeId,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventTypeCd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventType record);

    @InsertProvider(type=SEventTypeSqlProvider.class, method="insertSelective")
    int insertSelective(SEventType record);

    @Select({
        "select",
        "S_EVENT_TYPE_ID, H_EVENT_ID, S_EVENT_TYPE_CD, create_ts, update_ts",
        "from s_event_type",
        "where S_EVENT_TYPE_ID = #{sEventTypeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="S_EVENT_TYPE_ID", property="sEventTypeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="H_EVENT_ID", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="S_EVENT_TYPE_CD", property="sEventTypeCd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventType selectByPrimaryKey(Long sEventTypeId);

    @UpdateProvider(type=SEventTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventType record);

    @Update({
        "update s_event_type",
        "set H_EVENT_ID = #{hEventId,jdbcType=BIGINT},",
          "S_EVENT_TYPE_CD = #{sEventTypeCd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where S_EVENT_TYPE_ID = #{sEventTypeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventType record);
}