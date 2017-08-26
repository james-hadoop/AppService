package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.TUserPage;
import org.apache.ibatis.jdbc.SQL;

public class TUserPageSqlProvider {

    public String insertSelective(TUserPage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_page");
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserPhoneNr() != null) {
            sql.VALUES("h_user_phone_nr", "#{hUserPhoneNr,jdbcType=INTEGER}");
        }
        
        if (record.getsUserGenderCd() != null) {
            sql.VALUES("s_user_gender_cd", "#{sUserGenderCd,jdbcType=INTEGER}");
        }
        
        if (record.getsUserGenderDesc() != null) {
            sql.VALUES("s_user_gender_desc", "#{sUserGenderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserNameStr() != null) {
            sql.VALUES("s_user_name_str", "#{sUserNameStr,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserProfileUrl() != null) {
            sql.VALUES("s_user_profile_url", "#{sUserProfileUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserEmailStr() != null) {
            sql.VALUES("s_user_email_str", "#{sUserEmailStr,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserActiveInd() != null) {
            sql.VALUES("s_user_active_ind", "#{sUserActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TUserPage record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_page");
        
        if (record.gethUserPhoneNr() != null) {
            sql.SET("h_user_phone_nr = #{hUserPhoneNr,jdbcType=INTEGER}");
        }
        
        if (record.getsUserGenderCd() != null) {
            sql.SET("s_user_gender_cd = #{sUserGenderCd,jdbcType=INTEGER}");
        }
        
        if (record.getsUserGenderDesc() != null) {
            sql.SET("s_user_gender_desc = #{sUserGenderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserNameStr() != null) {
            sql.SET("s_user_name_str = #{sUserNameStr,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserProfileUrl() != null) {
            sql.SET("s_user_profile_url = #{sUserProfileUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserEmailStr() != null) {
            sql.SET("s_user_email_str = #{sUserEmailStr,jdbcType=VARCHAR}");
        }
        
        if (record.getsUserActiveInd() != null) {
            sql.SET("s_user_active_ind = #{sUserActiveInd,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("h_user_id = #{hUserId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}