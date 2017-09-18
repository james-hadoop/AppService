package com.leyao.app_service.dao.mapper.hs_user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;

public interface TUserPageMapper {
    @Delete({
        "delete from t_user_page",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long hUserId);

    @Insert({
        "insert into t_user_page (h_user_id, h_user_phone_nr, ",
        "s_user_gender_cd, s_user_gender_desc, ",
        "s_user_name_str, s_user_profile_url, ",
        "s_user_email_str, s_user_active_ind, ",
        "create_ts, update_ts)",
        "values (#{hUserId,jdbcType=BIGINT}, #{hUserPhoneNr,jdbcType=BIGINT}, ",
        "#{sUserGenderCd,jdbcType=INTEGER}, #{sUserGenderDesc,jdbcType=VARCHAR}, ",
        "#{sUserNameStr,jdbcType=VARCHAR}, #{sUserProfileUrl,jdbcType=VARCHAR}, ",
        "#{sUserEmailStr,jdbcType=VARCHAR}, #{sUserActiveInd,jdbcType=INTEGER}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    int insert(TUserPage record);

    @InsertProvider(type=TUserPageSqlProvider.class, method="insertSelective")
    int insertSelective(TUserPage record);

    @Select({
        "select",
        "h_user_id, h_user_phone_nr, s_user_gender_cd, s_user_gender_desc, s_user_name_str, ",
        "s_user_profile_url, s_user_email_str, s_user_active_ind, create_ts, update_ts",
        "from t_user_page",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_phone_nr", property="hUserPhoneNr", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_gender_cd", property="sUserGenderCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_user_gender_desc", property="sUserGenderDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_name_str", property="sUserNameStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_profile_url", property="sUserProfileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_email_str", property="sUserEmailStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_active_ind", property="sUserActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    TUserPage selectByPrimaryKey(Long hUserId);
    
    @Select({
        "select u.*,p.s_user_password_str as s_user_password_str from (select * from hs_user.h_user where h_user_phone_nr=#{hUserPhoneNr,jdbcType=BIGINT}) as u left outer join hs_user.s_user_password as p on p.h_user_id=u.h_user_id"
    })
    @Results({
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_phone_nr", property="hUserPhoneNr", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_password_str",property="sUserPasswordStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_gender_cd", property="sUserGenderCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_user_gender_desc", property="sUserGenderDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_name_str", property="sUserNameStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_profile_url", property="sUserProfileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_email_str", property="sUserEmailStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_active_ind", property="sUserActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    TUserSummary selectByhUserPhoneNr(Long hUserPhoneNr);

    @UpdateProvider(type=TUserPageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUserPage record);

    @Update({
        "update t_user_page",
        "set h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT},",
          "s_user_gender_cd = #{sUserGenderCd,jdbcType=INTEGER},",
          "s_user_gender_desc = #{sUserGenderDesc,jdbcType=VARCHAR},",
          "s_user_name_str = #{sUserNameStr,jdbcType=VARCHAR},",
          "s_user_profile_url = #{sUserProfileUrl,jdbcType=VARCHAR},",
          "s_user_email_str = #{sUserEmailStr,jdbcType=VARCHAR},",
          "s_user_active_ind = #{sUserActiveInd,jdbcType=INTEGER},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TUserPage record);
    
    @SelectProvider(type=TUserPageSqlProvider.class, method="getTUserSummary")
    @Results({
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_phone_nr", property="hUserPhoneNr", jdbcType=JdbcType.BIGINT),
        @Result(column="s_user_gender_cd", property="sUserGenderCd", jdbcType=JdbcType.INTEGER),
        @Result(column="s_user_gender_desc", property="sUserGenderDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_name_str", property="sUserNameStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_profile_url", property="sUserProfileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_email_str", property="sUserEmailStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_user_active_ind", property="sUserActiveInd", jdbcType=JdbcType.INTEGER),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TUserPage> getTUserPage(Map<String, Object> paramMap);
}