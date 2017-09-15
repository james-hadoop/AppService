package com.leyao.app_service.dao.mapper.hs_event;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.leyao.app_service.entity.hs_event.HsEvent;

public interface HsEventMapper {
    @Delete({
        "delete from hs_event",
        "where h_event_id = #{hEventId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long hEventId);

    @Insert({
        "insert into hs_event (h_event_id, create_ts, ",
        "update_ts)",
        "values (#{hEventId,jdbcType=BIGINT}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    long insert(HsEvent record);

    @InsertProvider(type=HsEventSqlProvider.class, method="insertSelective")
    long insertSelective(HsEvent record);

    @Select({
        "select",
        "h_event_id, create_ts, update_ts",
        "from hs_event",
        "where h_event_id = #{hEventId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    HsEvent selectByPrimaryKey(Long hEventId);
    
    @Select({"select max(update_ts) from hs_event.hs_event;"})
    @Results({
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    Date checkUpdate();
    
    @Select({
        "select",
        "h_event_id, create_ts, update_ts",
        "from hs_event"
    })
    @Results({
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HsEvent> getAllHsEvent();

    @UpdateProvider(type=HsEventSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HsEvent record);

    @Update({
        "update hs_event",
        "set create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where h_event_id = #{hEventId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HsEvent record);
}