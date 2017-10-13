package com.leyao.app_service.dao.mapper.hs_message;

import com.leyao.app_service.entity.hs_message.SMessageActive;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SMessageActiveMapper {
    @Delete({
        "delete from s_message_active",
        "where s_message_active_id = #{sMessageActiveId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sMessageActiveId);

    @Insert({
        "insert into s_message_active (s_message_active_id, h_message_id, ",
        "s_message_active_ind, create_ts, ",
        "update_ts)",
        "values (#{sMessageActiveId,jdbcType=BIGINT}, #{hMessageId,jdbcType=BIGINT}, ",
        "#{sMessageActiveInd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SMessageActive record);

    @InsertProvider(type=SMessageActiveSqlProvider.class, method="insertSelective")
    int insertSelective(SMessageActive record);

    @Select({
        "select",
        "s_message_active_id, h_message_id, s_message_active_ind, create_ts, update_ts",
        "from s_message_active",
        "where h_message_id = #{hMessageId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_message_active_id", property="sMessageActiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_message_id", property="hMessageId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_message_active_ind", property="sMessageActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SMessageActive selectByPrimaryKey(Long sMessageActiveId);

    @UpdateProvider(type=SMessageActiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SMessageActive record);

    @Update({
        "update s_message_active",
        "set h_message_id = #{hMessageId,jdbcType=BIGINT},",
          "s_message_active_ind = #{sMessageActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_message_active_id = #{sMessageActiveId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SMessageActive record);
}