package com.leyao.app_service.dao.mapper.r_dim;

import com.leyao.app_service.entity.r_dim.REventCategory;
import org.apache.ibatis.jdbc.SQL;

public class REventCategorySqlProvider {

    public String insertSelective(REventCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("r_event_category");
        
        if (record.getrEventCategoryCd() != null) {
            sql.VALUES("r_event_category_cd", "#{rEventCategoryCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventCategoryDesc() != null) {
            sql.VALUES("r_event_category_desc", "#{rEventCategoryDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(REventCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("r_event_category");
        
        if (record.getrEventCategoryDesc() != null) {
            sql.SET("r_event_category_desc = #{rEventCategoryDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("r_event_category_cd = #{rEventCategoryCd,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}