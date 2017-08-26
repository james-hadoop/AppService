package com.leyao.app_service.dao.mapper.r_dim;

import com.leyao.app_service.entity.r_dim.REventPosition;
import org.apache.ibatis.jdbc.SQL;

public class REventPositionSqlProvider {

    public String insertSelective(REventPosition record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("r_event_position");
        
        if (record.getrEventPositionCd() != null) {
            sql.VALUES("r_event_position_cd", "#{rEventPositionCd,jdbcType=INTEGER}");
        }
        
        if (record.getrEventPositionDesc() != null) {
            sql.VALUES("r_event_position_desc", "#{rEventPositionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(REventPosition record) {
        SQL sql = new SQL();
        sql.UPDATE("r_event_position");
        
        if (record.getrEventPositionDesc() != null) {
            sql.SET("r_event_position_desc = #{rEventPositionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("r_event_position_cd = #{rEventPositionCd,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}