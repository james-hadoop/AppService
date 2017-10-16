package com.leyao.app_service.dao.mapper.r_dim;

import com.leyao.app_service.entity.r_dim.RMessageCategory;

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

public interface RMessageCategoryMapper {
    @Delete({
        "delete from r_message_category",
        "where r_message_category_cd = #{rMessageCategoryCd,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rMessageCategoryCd);

    @Insert({
        "insert into r_message_category (r_message_category_cd, r_message_category_desc, ",
        "create_ts, update_ts)",
        "values (#{rMessageCategoryCd,jdbcType=INTEGER}, #{rMessageCategoryDesc,jdbcType=VARCHAR}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(RMessageCategory record);

    @InsertProvider(type=RMessageCategorySqlProvider.class, method="insertSelective")
    int insertSelective(RMessageCategory record);

    @Select({
        "select",
        "r_message_category_cd, r_message_category_desc, create_ts, update_ts",
        "from r_message_category"
    })
    @Results({
        @Result(column="r_message_category_cd", property="rMessageCategoryCd", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_message_category_desc", property="rMessageCategoryDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RMessageCategory> getAll();

    @UpdateProvider(type=RMessageCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RMessageCategory record);

    @Update({
        "update r_message_category",
        "set r_message_category_desc = #{rMessageCategoryDesc,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where r_message_category_cd = #{rMessageCategoryCd,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RMessageCategory record);
}