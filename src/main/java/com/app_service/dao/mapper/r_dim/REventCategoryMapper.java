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

import com.app_service.entity.r_dim.REventCategory;

public interface REventCategoryMapper {
    @Delete({
        "delete from r_event_category",
        "where r_event_category_cd = #{rEventCategoryCd,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rEventCategoryCd);

    @Insert({
        "insert into r_event_category (r_event_category_cd, r_event_category_desc, ",
        "create_ts, update_ts)",
        "values (#{rEventCategoryCd,jdbcType=INTEGER}, #{rEventCategoryDesc,jdbcType=VARCHAR}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(REventCategory record);

    @InsertProvider(type=REventCategorySqlProvider.class, method="insertSelective")
    int insertSelective(REventCategory record);

    @Select({
        "select",
        "r_event_category_cd, r_event_category_desc, create_ts, update_ts",
        "from r_event_category"
    })
    @Results({
        @Result(column="r_event_category_cd", property="rEventCategoryCd", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_event_category_desc", property="rEventCategoryDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<REventCategory> getAll();

    @UpdateProvider(type=REventCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(REventCategory record);

    @Update({
        "update r_event_category",
        "set r_event_category_desc = #{rEventCategoryDesc,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where r_event_category_cd = #{rEventCategoryCd,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(REventCategory record);
}