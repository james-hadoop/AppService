package com.leyao.app_service.dao.mapper.hs_user;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.leyao.app_service.entity.hs_user.HUser;

public interface HUserMapper {
    @Delete({
        "delete from h_user",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long hUserId);

    @Insert({
        "insert into h_user (h_user_id, h_user_phone_nr, ",
        "create_ts, update_ts)",
        "values (#{hUserId,jdbcType=BIGINT}, #{hUserPhoneNr,jdbcType=BIGINT}, ",
        "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="hUserId", keyColumn="h_user_id")
    long insert(HUser record);

    @InsertProvider(type=HUserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="hUserId", keyColumn="h_user_id")
    long insertSelective(HUser record);

    @Select({
        "select",
        "h_user_id, h_user_phone_nr, create_ts, update_ts",
        "from h_user",
        "where h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="h_user_phone_nr", property="hUserPhoneNr", jdbcType=JdbcType.BIGINT),
        @Result(column="create_ts", property="createTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_ts", property="updateTs", jdbcType=JdbcType.TIMESTAMP)
    })
    HUser selectByPrimaryKey(Long hUserId);
    
    @UpdateProvider(type=HUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HUser record);

    @Update({
        "update h_user",
        "set h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT},",
          "create_ts = #{createTs,jdbcType=TIMESTAMP},",
          "update_ts = #{updateTs,jdbcType=TIMESTAMP}",
        "where h_user_id = #{hUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HUser record);
    
    @Select({"select max(h_user_id) as h_user_id from hs_user.h_user"})
    @Results({
        @Result(column="h_user_id", property="hUserId", jdbcType=JdbcType.BIGINT)
    })
    long getMaxHUserId();
}