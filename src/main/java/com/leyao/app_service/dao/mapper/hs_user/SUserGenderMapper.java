package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.SUserGender;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserGenderMapper {
    @Delete({
        "delete from s_user_gender",
        "where s_user_gender_id = #{sUserGenderId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sUserGenderId);

    @Insert({
        "insert into s_user_gender (s_user_gender_id, h_user_id, ",
        "s_user_gender_cd, create_ts, ",
        "update_ts)",
        "values (#{sUserGenderId,jdbcType=BIGINT}, #{hUserId,jdbcType=BIGINT}, ",
        "#{sUserGenderCd,jdbcType=INTEGER}, #{createTs,jdbcType=TIMESTAMP}, ",
        "#{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(SUserGender record);

    @InsertProvider(type=SUserGenderSqlProvider.class, method="insertSelective")
    int insertSelective(SUserGender record);

    @Select({
        "select",
        "s_user_gender_id, h_user_id, s_user_gender_cd, create_ts, update_ts",
        "from s_user_gender",
        "where s_user_gender_id = #{sUserGenderId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="s_user_gender_id", property="sUserGenderId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_gender_cd", property="sUserGenderCd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    SUserGender selectByPrimaryKey(Long sUserGenderId);

    @UpdateProvider(type=SUserGenderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUserGender record);

    @Update({
        "update s_user_gender",
        "set h_user_id = #{hUserId,jdbcType=BIGINT},",
          "s_user_gender_cd = #{sUserGenderCd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where s_user_gender_id = #{sUserGenderId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SUserGender record);
}