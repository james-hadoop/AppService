package com.leyao.app_service.dao.mapper.hs_message;

import com.leyao.app_service.entity.hs_message.SMessageCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SMessageCategoryMapper {
    @Delete({
        "delete from s_message_category",
        "where s_message_content_id = #{sMessageContentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sMessageContentId);

    @Insert({
        "insert into s_message_category (s_message_content_id, h_message_id, ",
        "s_message_category_cd, create_ts, ",
        "update_ts)",
        "values (#{sMessageContentId,jdbcType=BIGINT}, #{hMessageId,jdbcType=BIGINT}, ",
        "#{sMessageCategoryCd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SMessageCategory record);

    @InsertProvider(type=SMessageCategorySqlProvider.class, method="insertSelective")
    int insertSelective(SMessageCategory record);

    @Select({
        "select",
        "s_message_content_id, h_message_id, s_message_category_cd, create_ts, update_ts",
        "from s_message_category",
        "where s_message_content_id = #{sMessageContentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_message_content_id", property="sMessageContentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_message_id", property="hMessageId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_message_category_cd", property="sMessageCategoryCd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SMessageCategory selectByPrimaryKey(Long sMessageContentId);

    @UpdateProvider(type=SMessageCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SMessageCategory record);

    @Update({
        "update s_message_category",
        "set h_message_id = #{hMessageId,jdbcType=BIGINT},",
          "s_message_category_cd = #{sMessageCategoryCd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_message_content_id = #{sMessageContentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SMessageCategory record);
}