package com.app_service.dao.mapper.ls_user_message;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.ls_user_message.SUserMessageActive;

public interface SUserMessageActiveMapper {
    @Delete({
        "delete from s_user_message_active",
        "where l_user_message_id = #{lUserMessageId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long lUserMessageId);

    @Insert({
        "insert into s_user_message_active (s_user_message_active_id, l_user_message_id, ",
        "s_user_message_active_ind, create_ts, ",
        "update_ts)",
        "values (#{sUserMessageActiveId,jdbcType=BIGINT}, #{lUserMessageId,jdbcType=BIGINT}, ",
        "#{sUserMessageActiveInd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserMessageActive record);

    @InsertProvider(type=SUserMessageActiveSqlProvider.class, method="insertSelective")
    int insertSelective(SUserMessageActive record);

    @Select({
        "select",
        "s_user_message_active_id, l_user_message_id, s_user_message_active_ind, create_ts, ",
        "update_ts",
        "from s_user_message_active",
        "where s_user_message_active_id = #{sUserMessageActiveId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_message_active_id", property="sUserMessageActiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="l_user_message_id", property="lUserMessageId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_message_active_ind", property="sUserMessageActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserMessageActive selectByPrimaryKey(Long sUserMessageActiveId);

    @UpdateProvider(type=SUserMessageActiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserMessageActive record);

    @Update({
        "update s_user_message_active",
        "set l_user_message_id = #{lUserMessageId,jdbcType=BIGINT},",
          "s_user_message_active_ind = #{sUserMessageActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_message_active_id = #{sUserMessageActiveId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserMessageActive record);
}