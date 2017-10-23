package com.app_service.dao.mapper.r_dim;

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

import com.app_service.entity.r_dim.REventPosition;

public interface REventPositionMapper {
    @Delete({
        "delete from r_event_position",
        "where r_event_position_cd = #{rEventPositionCd,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rEventPositionCd);

    @Insert({
        "insert into r_event_position (r_event_position_cd, r_event_position_desc, ",
        "create_ts, update_ts)",
        "values (#{rEventPositionCd,jdbcType=INTEGER}, #{rEventPositionDesc,jdbcType=VARCHAR}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(REventPosition record);

    @InsertProvider(type=REventPositionSqlProvider.class, method="insertSelective")
    int insertSelective(REventPosition record);

    @Select({
        "select",
        "r_event_position_cd, r_event_position_desc, create_ts, update_ts",
        "from r_event_position"
    })
    @Results({
        @Result(column="r_event_position_cd", property="rEventPositionCd", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_event_position_desc", property="rEventPositionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<REventPosition> getAll();

    @UpdateProvider(type=REventPositionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(REventPosition record);

    @Update({
        "update r_event_position",
        "set r_event_position_desc = #{rEventPositionDesc,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where r_event_position_cd = #{rEventPositionCd,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(REventPosition record);
}