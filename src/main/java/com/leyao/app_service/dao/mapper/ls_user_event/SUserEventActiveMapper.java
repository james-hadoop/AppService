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

import com.leyao.app_service.entity.ls_user_event.SUserEventActive;

public interface SUserEventActiveMapper {
    @Delete({
        "delete from s_user_event_active",
        "where s_user_event_active_id = #{sUserEventActiveId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserEventActiveId);

    @Insert({
        "insert into s_user_event_active (s_user_event_active_id, l_user_event_id, ",
        "s_user_event_active_ind, create_ts, ",
        "update_ts)",
        "values (#{sUserEventActiveId,jdbcType=BIGINT}, #{lUserEventId,jdbcType=BIGINT}, ",
        "#{sUserEventActiveInd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserEventActive record);

    @InsertProvider(type=SUserEventActiveSqlProvider.class, method="insertSelective")
    int insertSelective(SUserEventActive record);

    @Select({
        "select",
        "s_user_event_active_id, l_user_event_id, s_user_event_active_ind, create_ts, ",
        "update_ts",
        "from s_user_event_active",
        "where s_user_event_active_id = #{sUserEventActiveId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_event_active_id", property="sUserEventActiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="l_user_event_id", property="lUserEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_event_active_ind", property="sUserEventActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserEventActive selectByPrimaryKey(Long sUserEventActiveId);

    @UpdateProvider(type=SUserEventActiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserEventActive record);

    @Update({
        "update s_user_event_active",
        "set l_user_event_id = #{lUserEventId,jdbcType=BIGINT},",
          "s_user_event_active_ind = #{sUserEventActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_event_active_id = #{sUserEventActiveId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserEventActive record);
}