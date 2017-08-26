package com.leyao.app_service.dao.mapper.hs_event;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.leyao.app_service.entity.hs_event.SEventRecom2;

public interface SEventRecom2Mapper {
    @Delete({
        "delete from s_event_recom_2",
        "where s_event_recom_2_id = #{sEventRecom2Id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventRecom2Id);

    @Insert({
        "insert into s_event_recom_2 (s_event_recom_2_id, h_event_id, ",
        "s_event_recom_position_cd, s_event_recom_active_ind, ",
        "create_ts, update_ts)",
        "values (#{sEventRecom2Id,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventRecomPositionCd,jdbcType=INTEGER}, #{sEventRecomActiveInd,jdbcType=INTEGER}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventRecom2 record);

    @InsertProvider(type=SEventRecom2SqlProvider.class, method="insertSelective")
    int insertSelective(SEventRecom2 record);

    @Select({
        "select",
        "s_event_recom_2_id, h_event_id, s_event_recom_position_cd, s_event_recom_active_ind, ",
        "create_ts, update_ts",
        "from s_event_recom_2",
        "where s_event_recom_2_id = #{sEventRecom2Id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_recom_2_id", property="sEventRecom2Id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_recom_position_cd", property="sEventRecomPositionCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_event_recom_active_ind", property="sEventRecomActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventRecom2 selectByPrimaryKey(Long sEventRecom2Id);

    @UpdateProvider(type=SEventRecom2SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventRecom2 record);

    @Update({
        "update s_event_recom_2",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_recom_position_cd = #{sEventRecomPositionCd,jdbcType=INTEGER},",
          "s_event_recom_active_ind = #{sEventRecomActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_recom_2_id = #{sEventRecom2Id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventRecom2 record);
}