package com.leyao.app_service.dao.mapper.hs_event;

import com.leyao.app_service.entity.hs_event.SEventSubContent1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SEventSubContent1Mapper {
    @Delete({
        "delete from s_event_sub_content_1",
        "where s_event_sub_content_1_id = #{sEventSubContent1Id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sEventSubContent1Id);

    @Insert({
        "insert into s_event_sub_content_1 (s_event_sub_content_1_id, h_event_id, ",
        "s_event_sub_content_1_url, create_ts, ",
        "update_ts)",
        "values (#{sEventSubContent1Id,jdbcType=BIGINT}, #{hEventId,jdbcType=BIGINT}, ",
        "#{sEventSubContent1Url,jdbcType=VARCHAR}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SEventSubContent1 record);

    @InsertProvider(type=SEventSubContent1SqlProvider.class, method="insertSelective")
    int insertSelective(SEventSubContent1 record);

    @Select({
        "select",
        "s_event_sub_content_1_id, h_event_id, s_event_sub_content_1_url, create_ts, ",
        "update_ts",
        "from s_event_sub_content_1",
        "where s_event_sub_content_1_id = #{sEventSubContent1Id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_event_sub_content_1_id", property="sEventSubContent1Id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_event_id", property="hEventId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_event_sub_content_1_url", property="sEventSubContent1Url", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SEventSubContent1 selectByPrimaryKey(Long sEventSubContent1Id);

    @UpdateProvider(type=SEventSubContent1SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SEventSubContent1 record);

    @Update({
        "update s_event_sub_content_1",
        "set h_event_id = #{hEventId,jdbcType=BIGINT},",
          "s_event_sub_content_1_url = #{sEventSubContent1Url,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_event_sub_content_1_id = #{sEventSubContent1Id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SEventSubContent1 record);
}