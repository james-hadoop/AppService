package com.app_service.dao.mapper.hs_event;

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

import com.app_service.entity.hs_event.SEventActive;

public interface SEventActiveMapper {
    @Delete({
        "delete from s_event_active",
        "where s_event_active_id = #{sEventActiveId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventActiveId);

    @Insert({
        "insert into s_event_active (s_event_active_id, h_event_id, ",
        "s_event_active_ind, create_ts, ",
        "update_ts)",
        "values (#{sEventActiveId,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventActiveInd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventActive record);

    @InsertProvider(type=SEventActiveSqlProvider.class, method="insertSelective")
    int insertSelective(SEventActive record);

    @Select({
        "select",
        "s_event_active_id, h_event_id, s_event_active_ind, create_ts, update_ts",
        "from s_event_active",
        "where s_event_active_id = #{sEventActiveId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_active_id", property="sEventActiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_active_ind", property="sEventActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventActive selectByPrimaryKey(Long sEventActiveId);
    
    @Select({
        "select",
        "s_event_active_id, h_event_id, s_event_active_ind, create_ts, update_ts",
        "from s_event_active",
        "where h_event_id = #{hEventId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_active_id", property="sEventActiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_active_ind", property="sEventActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SEventActive> selectByEventId(Long hEventId);

    @UpdateProvider(type=SEventActiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventActive record);

    @Update({
        "update s_event_active",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_active_ind = #{sEventActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_active_id = #{sEventActiveId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventActive record);
}