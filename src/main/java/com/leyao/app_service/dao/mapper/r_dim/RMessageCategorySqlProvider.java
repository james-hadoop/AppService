package com.leyao.app_service.dao.mapper.r_dim;

import com.leyao.app_service.entity.r_dim.RMessageCategory;
import org.apache.ibatis.jdbc.SQL;

public class RMessageCategorySqlProvider {

    public String insertSelective(RMessageCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("r_message_category");
        
        if (record.getrMessageCategoryCd() != null) {
            sql.VALUES("r_message_category_cd", "#{rMessageCategoryCd,jdbcType=INTEGER}");
        }
        
        if (record.getrMessageCategoryDesc() != null) {
            sql.VALUES("r_message_category_desc", "#{rMessageCategoryDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RMessageCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("r_message_category");
        
        if (record.getrMessageCategoryDesc() != null) {
            sql.SET("r_message_category_desc = #{rMessageCategoryDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("r_message_category_cd = #{rMessageCategoryCd,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}