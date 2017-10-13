package com.leyao.app_service.dao.mapper.hs_user;

import com.leyao.app_service.entity.hs_user.TUserPage;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class TUserPageSqlProvider {

    public String insertSelective(TUserPage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_page");
        
        if (record.gethUserId() != null) {
            sql.VALUES("h_user_id", "#{hUserId,jdbcType=BIGINT}");
        }
        
        if (record.gethUserPhoneNr() != null) {
            sql.VALUES("h_user_phone_nr", "#{hUserPhoneNr,jdbcType=BIGINT}");
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
            sql.SET("h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");
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
    
    public String getTUserSummary(Map<String, Object> paramMap){
        SQL sql = new SQL();
        sql.SELECT("*").FROM("t_user_page");
        
        if (paramMap.get("sUserNameStr") != null) {
            sql.OR().WHERE("s_user_name_str = #{sUserNameStr,jdbcType=VARCHAR}");
        }
        
        if (paramMap.get("sUserEmailStr") != null) {
            sql.OR().WHERE("s_user_email_str = #{sUserEmailStr,jdbcType=VARCHAR}");
        }
        
        if (paramMap.get("hUserPhoneNr") != null) {
            sql.OR().WHERE("h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");
        }
        
        if (paramMap.get("start") != null && paramMap.get("end") != null) {
            String sqlString = sql.toString() + (" limit " + paramMap.get("start") + ", " + paramMap.get("end"));
            return sqlString;
        }
        
        return sql.toString();
    }
    
    public static void main(String[] args){
        TUserPageSqlProvider provider =new TUserPageSqlProvider();
        
        TUserPage record=new TUserPage();
        record.setsUserNameStr("james");
        record.setsUserEmailStr("james@126.com");
        record.sethUserPhoneNr(13333333333L);
        
        String updateByPrimaryKeySelective=provider.updateByPrimaryKeySelective(record);
        System.out.println(updateByPrimaryKeySelective);
        System.out.println("\n");
        
        Map<String, Object> paramMap=new HashMap<String,Object>();
        paramMap.put("sUserNameStr", "james");
        paramMap.put("sUserEmailStr", "james@mail.com");
        paramMap.put("hUserPhoneNr",13333333333L);
        String getTUserSummary=provider.getTUserSummary(paramMap);
        System.out.println(getTUserSummary);
    }
}