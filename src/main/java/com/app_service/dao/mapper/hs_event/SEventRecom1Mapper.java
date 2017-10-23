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

import com.app_service.entity.hs_event.SEventRecom1;

public interface SEventRecom1Mapper {
    @Delete({
        "delete from s_event_recom_1",
        "where s_event_recom_1_id = #{sEventRecom1Id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventRecom1Id);

    @Insert({
        "insert into s_event_recom_1 (s_event_recom_1_id, h_event_id, ",
        "s_event_recom_position_cd, s_event_recom_active_ind, ",
        "create_ts, update_ts)",
        "values (#{sEventRecom1Id,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventRecomPositionCd,jdbcType=INTEGER}, #{sEventRecomActiveInd,jdbcType=INTEGER}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventRecom1 record);

    @InsertProvider(type=SEventRecom1SqlProvider.class, method="insertSelective")
    int insertSelective(SEventRecom1 record);

    @Select({
        "select",
        "s_event_recom_1_id, h_event_id, s_event_recom_position_cd, s_event_recom_active_ind, ",
        "create_ts, update_ts",
        "from s_event_recom_1",
        "where s_event_recom_1_id = #{sEventRecom1Id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_recom_1_id", property="sEventRecom1Id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_recom_position_cd", property="sEventRecomPositionCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_event_recom_active_ind", property="sEventRecomActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventRecom1 selectByPrimaryKey(Long sEventRecom1Id);

    @UpdateProvider(type=SEventRecom1SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventRecom1 record);

    @Update({
        "update s_event_recom_1",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_recom_position_cd = #{sEventRecomPositionCd,jdbcType=INTEGER},",
          "s_event_recom_active_ind = #{sEventRecomActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_recom_1_id = #{sEventRecom1Id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventRecom1 record);
}