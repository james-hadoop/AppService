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

import com.app_service.entity.hs_event.SEventBanner;

public interface SEventBannerMapper {
    @Delete({
        "delete from s_event_banner",
        "where s_event_banner_id = #{sEventBannerId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventBannerId);
    
    @Delete({
        "delete from s_event_banner",
        "where h_event_id = #{hEventId,jdbcType=BIGINT}"
    })
    int deleteEventId(Long hEventId);

    @Insert({
        "insert into s_event_banner (s_event_banner_id, h_event_id, ",
        "s_event_banner_position_cd, s_event_banner_active_ind, ",
        "create_ts, update_ts)",
        "values (#{sEventBannerId,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventBannerPositionCd,jdbcType=INTEGER}, #{sEventBannerActiveInd,jdbcType=INTEGER}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventBanner record);

    @InsertProvider(type=SEventBannerSqlProvider.class, method="insertSelective")
    int insertSelective(SEventBanner record);

    @Select({
        "select",
        "s_event_banner_id, h_event_id, s_event_banner_position_cd, s_event_banner_active_ind, ",
        "create_ts, update_ts",
        "from s_event_banner",
        "where s_event_banner_id = #{sEventBannerId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_banner_id", property="sEventBannerId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_banner_position_cd", property="sEventBannerPositionCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_event_banner_active_ind", property="sEventBannerActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventBanner selectByPrimaryKey(Long sEventBannerId);

    @UpdateProvider(type=SEventBannerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventBanner record);

    @Update({
        "update s_event_banner",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_banner_position_cd = #{sEventBannerPositionCd,jdbcType=INTEGER},",
          "s_event_banner_active_ind = #{sEventBannerActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_banner_id = #{sEventBannerId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventBanner record);
}