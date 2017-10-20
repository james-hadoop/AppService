package com.leyao.app_service.dao.mapper.ls_user_message;

import com.leyao.app_service.entity.ls_user_message.LUserMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LUserMessageMapper {
    @Delete({
        "delete from l_user_message",
        "where l_user_message_id = #{lUserMessageId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long lUserMessageId);

    @Insert({
        "insert into l_user_message (l_user_message_id, h_user_id, ",
        "h_message_id, create_ts, ",
        "update_ts)",
        "values (#{lUserMessageId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{hMessageId,jdbcType=BIGINT}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(LUserMessage record);

    @InsertProvider(type=LUserMessageSqlProvider.class, method="insertSelective")
    int insertSelective(LUserMessage record);

    @Select({
        "select",
        "l_user_message_id, h_user_id, h_message_id, create_ts, update_ts",
        "from l_user_message",
        "where l_user_message_id = #{lUserMessageId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="l_user_message_id", property="lUserMessageId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="h_message_id", property="hMessageId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    LUserMessage selectByPrimaryKey(Long lUserMessageId);
    
    @Select({"select max(l_user_message_id) as l_user_message_id from ls_user_message.l_user_message"})
    @Results({
        @Result(column="v", property="lUserMessageId", jdbcType=JdbcType.BIGINT)
    })
    Long getMaxLUserMessageId();

    @UpdateProvider(type=LUserMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LUserMessage record);

    @Update({
        "update l_user_message",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "h_message_id = #{hMessageId,jdbcType=BIGINT},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where l_user_message_id = #{lUserMessageId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LUserMessage record);
}