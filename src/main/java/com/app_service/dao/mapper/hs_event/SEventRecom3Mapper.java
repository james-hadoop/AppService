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

import com.app_service.entity.hs_event.SEventRecom3;

public interface SEventRecom3Mapper {
    @Delete({
        "delete from s_event_recom_3",
        "where s_event_recom_3_id = #{sEventRecom3Id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventRecom3Id);

    @Insert({
        "insert into s_event_recom_3 (s_event_recom_3_id, h_event_id, ",
        "s_event_recom_position_cd, s_event_recom_active_ind, ",
        "create_ts, update_ts)",
        "values (#{sEventRecom3Id,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventRecomPositionCd,jdbcType=INTEGER}, #{sEventRecomActiveInd,jdbcType=INTEGER}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventRecom3 record);

    @InsertProvider(type=SEventRecom3SqlProvider.class, method="insertSelective")
    int insertSelective(SEventRecom3 record);

    @Select({
        "select",
        "s_event_recom_3_id, h_event_id, s_event_recom_position_cd, s_event_recom_active_ind, ",
        "create_ts, update_ts",
        "from s_event_recom_3",
        "where s_event_recom_3_id = #{sEventRecom3Id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_recom_3_id", property="sEventRecom3Id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_recom_position_cd", property="sEventRecomPositionCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_event_recom_active_ind", property="sEventRecomActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventRecom3 selectByPrimaryKey(Long sEventRecom3Id);

    @UpdateProvider(type=SEventRecom3SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventRecom3 record);

    @Update({
        "update s_event_recom_3",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_recom_position_cd = #{sEventRecomPositionCd,jdbcType=INTEGER},",
          "s_event_recom_active_ind = #{sEventRecomActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_recom_3_id = #{sEventRecom3Id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventRecom3 record);
}