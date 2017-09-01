package com.leyao.app_service.dao.mapper.r_dim;

import com.leyao.app_service.entity.r_dim.REventType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface REventTypeMapper {
    @Delete({
        "delete from r_event_type",
        "where r_event_type_cd = #{rEventTypeCd,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rEventTypeCd);

    @Insert({
        "insert into r_event_type (r_event_type_cd, r_event_type_desc, ",
        "create_ts, update_ts)",
        "values (#{rEventTypeCd,jdbcType=INTEGER}, #{rEventTypeDesc,jdbcType=VARCHAR}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(REventType record);

    @InsertProvider(type=REventTypeSqlProvider.class, method="insertSelective")
    int insertSelective(REventType record);

    @Select({
        "select",
        "r_event_type_cd, r_event_type_desc, create_ts, update_ts",
        "from r_event_type",
        "where r_event_type_cd = #{rEventTypeCd,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="r_event_type_cd", property="rEventTypeCd", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_event_type_desc", property="rEventTypeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    REventType selectByPrimaryKey(Integer rEventTypeCd);

    @UpdateProvider(type=REventTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(REventType record);

    @Update({
        "update r_event_type",
        "set r_event_type_desc = #{rEventTypeDesc,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where r_event_type_cd = #{rEventTypeCd,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(REventType record);
}