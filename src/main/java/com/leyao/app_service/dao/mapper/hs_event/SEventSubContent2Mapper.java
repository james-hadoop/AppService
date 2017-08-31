package com.leyao.app_service.dao.mapper.hs_event;

import com.leyao.app_service.entity.hs_event.SEventSubContent2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SEventSubContent2Mapper {
    @Delete({
        "delete from s_event_sub_content_2",
        "where s_event_sub_content_2_id = #{sEventSubContent2Id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventSubContent2Id);

    @Insert({
        "insert into s_event_sub_content_2 (s_event_sub_content_2_id, h_event_id, ",
        "s_event_sub_content_2_str, create_ts, ",
        "update_ts)",
        "values (#{sEventSubContent2Id,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventSubContent2Str,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventSubContent2 record);

    @InsertProvider(type=SEventSubContent2SqlProvider.class, method="insertSelective")
    int insertSelective(SEventSubContent2 record);

    @Select({
        "select",
        "s_event_sub_content_2_id, h_event_id, s_event_sub_content_2_str, create_ts, ",
        "update_ts",
        "from s_event_sub_content_2",
        "where s_event_sub_content_2_id = #{sEventSubContent2Id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_sub_content_2_id", property="sEventSubContent2Id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_sub_content_2_str", property="sEventSubContent2Str", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventSubContent2 selectByPrimaryKey(Long sEventSubContent2Id);

    @UpdateProvider(type=SEventSubContent2SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventSubContent2 record);

    @Update({
        "update s_event_sub_content_2",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_sub_content_2_str = #{sEventSubContent2Str,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_sub_content_2_id = #{sEventSubContent2Id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventSubContent2 record);
}