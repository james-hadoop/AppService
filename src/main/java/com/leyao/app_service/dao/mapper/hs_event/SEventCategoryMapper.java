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

import com.leyao.app_service.entity.hs_event.SEventCategory;

public interface SEventCategoryMapper {
    @Delete({
        "delete from s_event_category",
        "where s_event_category_id = #{sEventCategoryId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventCategoryId);

    @Insert({
        "insert into s_event_category (s_event_category_id, h_event_id, ",
        "s_event_category_cd, create_ts, ",
        "update_ts)",
        "values (#{sEventCategoryId,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventCategoryCd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventCategory record);

    @InsertProvider(type=SEventCategorySqlProvider.class, method="insertSelective")
    int insertSelective(SEventCategory record);

    @Select({
        "select",
        "s_event_category_id, h_event_id, s_event_category_cd, create_ts, update_ts",
        "from s_event_category",
        "where s_event_category_id = #{sEventCategoryId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_category_id", property="sEventCategoryId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_category_cd", property="sEventCategoryCd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventCategory selectByPrimaryKey(Long sEventCategoryId);

    @UpdateProvider(type=SEventCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventCategory record);

    @Update({
        "update s_event_category",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_category_id = #{sEventCategoryId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventCategory record);
}