package com.app_service.dao.mapper.hs_message;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.hs_message.HsMessage;

public interface HsMessageMapper {
    @Delete({
        "delete from hs_message",
        "where h_message_id = #{hMessageId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long hMessageId);

    @Insert({
        "insert into hs_message (h_message_id, create_ts, ",
        "update_ts)",
        "values (#{hMessageId,jdbcType=BIGINT}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(HsMessage record);

    @InsertProvider(type=HsMessageSqlProvider.class, method="insertSelective")
    int insertSelective(HsMessage record);

    @Select({
        "select",
        "h_message_id, create_ts, update_ts",
        "from hs_message",
        "where h_message_id = #{hMessageId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="h_message_id", property="hMessageId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    HsMessage selectByPrimaryKey(Long hMessageId);
    
    @Select({"select max(h_message_id) as h_message_id from hs_message.hs_message"})
    @Results({
        @Result(column="h_message_id", property="hMessageId", jdbcType=JdbcType.BIGINT)
    })
    Long getMaxHMessageId();

    @UpdateProvider(type=HsMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HsMessage record);

    @Update({
        "update hs_message",
        "set create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where h_message_id = #{hMessageId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HsMessage record);
}