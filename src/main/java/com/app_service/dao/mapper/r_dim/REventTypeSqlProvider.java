package com.app_service.dao.mapper.r_dim;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.r_dim.REventType;

public class REventTypeSqlProvider {

    public String insertSelective(REventType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("r_event_type");
        
        if (record.getrEventTypeCd() != null) {
            sql.VALUES("r_event_type_cd", "#{rEventTypeCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventTypeDesc() != null) {
            sql.VALUES("r_event_type_desc", "#{rEventTypeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(REventType record) {
        SQL sql = new SQL();
        sql.UPDATE("r_event_type");
        
        if (record.getrEventTypeDesc() != null) {
            sql.SET("r_event_type_desc = #{rEventTypeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("r_event_type_cd = #{rEventTypeCd,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}