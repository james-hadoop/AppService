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

import com.app_service.entity.hs_event.SEventContent;

public interface SEventContentMapper {
    @Delete({
        "delete from s_event_content",
        "where s_event_content_id = #{sEventContentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventContentId);

    @Insert({
        "insert into s_event_content (s_event_content_id, h_event_id, ",
        "s_event_title_url, s_event_content_url, ",
        "create_ts, update_ts)",
        "values (#{sEventContentId,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventTitleUrl,jdbcType=VARCHAR}, #{sEventContentUrl,jdbcType=VARCHAR}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventContent record);

    @InsertProvider(type=SEventContentSqlProvider.class, method="insertSelective")
    int insertSelective(SEventContent record);

    @Select({
        "select",
        "s_event_content_id, h_event_id, s_event_title_url, s_event_content_url, create_ts, ",
        "update_ts",
        "from s_event_content",
        "where s_event_content_id = #{sEventContentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_content_id", property="sEventContentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_title_url", property="sEventTitleUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_event_content_url", property="sEventContentUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventContent selectByPrimaryKey(Long sEventContentId);

    @UpdateProvider(type=SEventContentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventContent record);

    @Update({
        "update s_event_content",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_title_url = #{sEventTitleUrl,jdbcType=VARCHAR},",
          "s_event_content_url = #{sEventContentUrl,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_content_id = #{sEventContentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventContent record);
}