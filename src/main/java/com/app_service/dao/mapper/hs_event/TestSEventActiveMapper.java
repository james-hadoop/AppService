package com.app_service.dao.mapper.hs_event;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.app_service.entity.hs_event.TEventPage;

public interface TestSEventActiveMapper {
    @Select({ "select", "s_event_active_id, h_event_id, s_event_active_ind, create_ts, update_ts",
            "from s_event_active" })
    @Results({
            @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP) })
    List<TEventPage> getAllSEventActive();
    
    @InsertProvider(type=TestSEventActiveSqlProvider.class, method="insertSelective")
    int insertSelective(TEventPage record);
}