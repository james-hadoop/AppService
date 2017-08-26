package com.leyao.app_service.dao.mapper.r_dim;

import com.leyao.app_service.entity.r_dim.RUserGender;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RUserGenderMapper {
    @Delete({
        "delete from r_user_gender",
        "where r_user_gender_cd = #{rUserGenderCd,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rUserGenderCd);

    @Insert({
        "insert into r_user_gender (r_user_gender_cd, r_user_gender_desc, ",
        "create_ts, update_ts)",
        "values (#{rUserGenderCd,jdbcType=INTEGER}, #{rUserGenderDesc,jdbcType=VARCHAR}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(RUserGender record);

    @InsertProvider(type=RUserGenderSqlProvider.class, method="insertSelective")
    int insertSelective(RUserGender record);

    @Select({
        "select",
        "r_user_gender_cd, r_user_gender_desc, create_ts, update_ts",
        "from r_user_gender",
        "where r_user_gender_cd = #{rUserGenderCd,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="r_user_gender_cd", property="rUserGenderCd", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_user_gender_desc", property="rUserGenderDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    RUserGender selectByPrimaryKey(Integer rUserGenderCd);

    @UpdateProvider(type=RUserGenderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RUserGender record);

    @Update({
        "update r_user_gender",
        "set r_user_gender_desc = #{rUserGenderDesc,jdbcType=VARCHAR},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where r_user_gender_cd = #{rUserGenderCd,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RUserGender record);
}