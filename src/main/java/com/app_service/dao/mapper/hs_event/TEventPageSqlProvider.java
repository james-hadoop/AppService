package com.app_service.dao.mapper.hs_event;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.app_service.entity.hs_event.TEventPage;

public class TEventPageSqlProvider {

    public String insertSelective(TEventPage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_event_page");

        if (record.gethEventId() != null) {
            sql.VALUES("h_event_id", "#{hEventId,jdbcType=BIGINT}");
        }

        if (record.getsEventCategoryCd() != null) {
            sql.VALUES("s_event_category_cd", "#{sEventCategoryCd,jdbcType=INTEGER}");
        }

        if (record.getrEventCategoryDesc() != null) {
            sql.VALUES("r_event_category_desc", "#{rEventCategoryDesc,jdbcType=VARCHAR}");
        }

        if (record.getsEventTypeCd() != null) {
            sql.VALUES("s_event_type_cd", "#{sEventTypeCd,jdbcType=INTEGER}");
        }

        if (record.getrEventTypeDesc() != null) {
            sql.VALUES("r_event_type_desc", "#{rEventTypeDesc,jdbcType=VARCHAR}");
        }

        if (record.getsEventTitleUrl() != null) {
            sql.VALUES("s_event_title_url", "#{sEventTitleUrl,jdbcType=VARCHAR}");
        }

        if (record.getsEventContentUrl() != null) {
            sql.VALUES("s_event_content_url", "#{sEventContentUrl,jdbcType=VARCHAR}");
        }

        if (record.getsEventSubContent1Url() != null) {
            sql.VALUES("s_event_sub_content_1_url", "#{sEventSubContent1Url,jdbcType=VARCHAR}");
        }

        if (record.getsEventSubContent2Str() != null) {
            sql.VALUES("s_event_sub_content_2_str", "#{sEventSubContent2Str,jdbcType=VARCHAR}");
        }

        if (record.getsEventActiveInd() != null) {
            sql.VALUES("s_event_active_ind", "#{sEventActiveInd,jdbcType=INTEGER}");
        }

        if (record.getCreateTs() != null) {
            sql.VALUES("create_ts", "#{createTs,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTs() != null) {
            sql.VALUES("update_ts", "#{updateTs,jdbcType=TIMESTAMP}");
        }

        if (record.getsEventSearchContentTxt() != null) {
            sql.VALUES("s_event_search_content_txt", "#{sEventSearchContentTxt,jdbcType=LONGVARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TEventPage record) {
        SQL sql = new SQL();
        sql.UPDATE("t_event_page");

        if (record.getsEventCategoryCd() != null) {
            sql.SET("s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }

        if (record.getrEventCategoryDesc() != null) {
            sql.SET("r_event_category_desc = #{rEventCategoryDesc,jdbcType=VARCHAR}");
        }

        if (record.getsEventTypeCd() != null) {
            sql.SET("s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER}");
        }

        if (record.getrEventTypeDesc() != null) {
            sql.SET("r_event_type_desc = #{rEventTypeDesc,jdbcType=VARCHAR}");
        }

        if (record.getsEventTitleUrl() != null) {
            sql.SET("s_event_title_url = #{sEventTitleUrl,jdbcType=VARCHAR}");
        }

        if (record.getsEventContentUrl() != null) {
            sql.SET("s_event_content_url = #{sEventContentUrl,jdbcType=VARCHAR}");
        }

        if (record.getsEventSubContent1Url() != null) {
            sql.SET("s_event_sub_content_1_url = #{sEventSubContent1Url,jdbcType=VARCHAR}");
        }

        if (record.getsEventSubContent2Str() != null) {
            sql.SET("s_event_sub_content_2_str = #{sEventSubContent2Str,jdbcType=VARCHAR}");
        }

        if (record.getsEventActiveInd() != null) {
            sql.SET("s_event_active_ind = #{sEventActiveInd,jdbcType=INTEGER}");
        }

        if (record.getCreateTs() != null) {
            sql.SET("create_ts = #{createTs,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTs() != null) {
            sql.SET("update_ts = #{updateTs,jdbcType=TIMESTAMP}");
        }

        if (record.getsEventSearchContentTxt() != null) {
            sql.SET("s_event_search_content_txt = #{sEventSearchContentTxt,jdbcType=LONGVARCHAR}");
        }

        sql.WHERE("h_event_id = #{hEventId,jdbcType=BIGINT}");

        return sql.toString();
    }

    // getTEventPageListByCondition
    public String getTEventPageListByCondition(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT(
                "ep.h_event_id,ep.r_event_category_desc,ep.s_event_category_cd,ep.s_event_content_url,ep.s_event_title_url,ep.s_event_type_cd,sub1.s_event_sub_content_1_url,sub2.s_event_sub_content_2_str")
                .FROM("hs_event.t_event_page ep left outer join hs_event.s_event_sub_content_1 sub1 on ep.h_event_id=sub1.h_event_id left outer join hs_event.s_event_sub_content_2 sub2 on sub1.s_event_sub_content_1_id=sub2.s_event_sub_content_2_id");

        sql.WHERE("ep.s_event_active_ind=0");

        if (paramMap.get("sEventCategoryCd") != null) {
            sql.WHERE("ep.s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventTypeCd") != null) {
            sql.WHERE("ep.s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventSearchContentTxt") != null) {
            sql.WHERE("ep.s_event_search_content_txt like concat('%',#{sEventSearchContentTxt,jdbcType=VARCHAR},'%')");
        }

        sql.ORDER_BY("ep.s_event_active_ind");

        return sql.toString();
    }

    // getTEventPageListByConditionCount
    public String getTEventPageListByConditionCount(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT("count(1)").FROM("hs_event.t_event_page ep");

        sql.WHERE("ep.s_event_active_ind=0");

        if (paramMap.get("sEventCategoryCd") != null) {
            sql.WHERE("ep.s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventTypeCd") != null) {
            sql.WHERE("ep.s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sUserEventLikeInd") != null) {
            sql.INNER_JOIN(
                    "ls_user_event.s_user_event_like uel on uel.l_user_event_id=l_user_event_id and uel.s_user_event_like_ind= #{sUserEventLikeInd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sUserEventReadLogTxt") != null) {
            sql.INNER_JOIN("ls_user_event.l_user_event lue on lue.h_event_id=ep.h_event_id").INNER_JOIN(
                    "ls_user_event.s_user_event_read uer on lue.l_user_event_id=uer.l_user_event_id and uer.s_user_event_read_log_txt like concat('%',#{sUserEventReadLogTxt,jdbcType=INTEGER},'%')");
        }

        return sql.toString();
    }

    // getTEventSummaryByCondition
    public String getTEventSummaryByCondition(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT(
                "ep.h_event_id,ep.r_event_category_desc,ep.s_event_category_cd,ep.s_event_content_url,ep.s_event_title_url,ep.s_event_type_cd, ep.s_event_active_ind, ep.s_event_search_content_txt, ep.create_ts, ep.update_ts, eb.s_event_banner_position_cd, er1.s_event_recom_position_cd s_event_recom1_position_cd, er2.s_event_recom_position_cd s_event_recom2_position_cd, er3.s_event_recom_position_cd s_event_recom3_position_cd")
                .FROM("hs_event.t_event_page ep left outer join hs_event.s_event_banner eb on ep.h_event_id=eb.h_event_id left outer join hs_event.s_event_recom_1 er1 on ep.h_event_id=er1.h_event_id left outer join hs_event.s_event_recom_2 er2 on ep.h_event_id=er2.h_event_id left outer join hs_event.s_event_recom_3 er3 on ep.h_event_id=er3.h_event_id");

        if (paramMap.get("sEventCategoryCd") != null) {
            sql.OR().WHERE("ep.s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventTypeCd") != null) {
            sql.OR().WHERE("ep.s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sUserEventLikeInd") != null) {
            sql.OR().WHERE("ep.s_event_active_ind = #{sUserEventLikeInd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventSearchContentTxt") != null) {
            sql.OR().WHERE(
                    "ep.s_event_search_content_txt like concat('%',#{sEventSearchContentTxt,jdbcType=VARCHAR},'%')")
                    .AND().WHERE("ep.s_event_content_url not like '%mp3'").AND()
                    .WHERE("ep.s_event_content_url not like '%mp4'");
        }

        if (paramMap.get("urlString") != null) {
            sql.OR().WHERE("ep.s_event_title_url like concat('%',#{urlString,jdbcType=VARCHAR},'%')").OR()
                    .WHERE("ep.s_event_content_url like concat('%',#{urlString,jdbcType=VARCHAR},'%')").OR()
                    .WHERE("ep.s_event_search_content_txt like concat('%',#{urlString,jdbcType=VARCHAR},'%')");
        }

        sql.ORDER_BY("s_event_active_ind");

        sql.ORDER_BY("ep.update_ts desc");

        if (paramMap.get("start") != null && paramMap.get("end") != null) {
            String sqlString = sql.toString() + (" limit " + paramMap.get("start") + ", " + paramMap.get("end"));
            return sqlString;
        }

        return sql.toString();
    }

    // getTEventSummaryByConditionCount
    public String getTEventSummaryByConditionCount(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT(
                "ep.h_event_id,ep.r_event_category_desc,ep.s_event_category_cd,ep.s_event_content_url,ep.s_event_title_url,ep.s_event_type_cd, ep.s_event_active_ind, ep.create_ts, ep.update_ts, eb.s_event_banner_position_cd, er1.s_event_recom_position_cd s_event_recom1_position_cd, er2.s_event_recom_position_cd s_event_recom2_position_cd, er3.s_event_recom_position_cd s_event_recom3_position_cd")
                .FROM("hs_event.t_event_page ep left outer join hs_event.s_event_banner eb on ep.h_event_id=eb.h_event_id left outer join hs_event.s_event_recom_1 er1 on ep.h_event_id=er1.h_event_id left outer join hs_event.s_event_recom_2 er2 on ep.h_event_id=er2.h_event_id left outer join hs_event.s_event_recom_3 er3 on ep.h_event_id=er3.h_event_id");

        if (paramMap.get("sEventCategoryCd") != null) {
            sql.OR().WHERE("ep.s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventTypeCd") != null) {
            sql.OR().WHERE("ep.s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sUserEventLikeInd") != null) {
            sql.OR().WHERE("ep.s_event_active_ind = #{sUserEventLikeInd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sEventSearchContentTxt") != null) {
            sql.OR().WHERE(
                    "ep.s_event_search_content_txt like concat('%',#{sEventSearchContentTxt,jdbcType=VARCHAR},'%')")
                    .AND().WHERE("ep.s_event_content_url not like '%mp3'").AND()
                    .WHERE("ep.s_event_content_url not like '%mp4'");
        }

        if (paramMap.get("urlString") != null) {
            sql.OR().WHERE("ep.s_event_title_url like concat('%',#{urlString,jdbcType=VARCHAR},'%')").OR()
                    .WHERE("ep.s_event_content_url like concat('%',#{urlString,jdbcType=VARCHAR},'%')").OR()
                    .WHERE("ep.s_event_search_content_txt like concat('%',#{urlString,jdbcType=VARCHAR},'%')");
        }

        return "SELECT count(1) from( " + sql.toString() + " ) event_page_temp";
    }

    // getTEventPageListByConditionAndUser
    public String getTEventPageListByConditionAndUser(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT(
                "distinct ep.h_event_id,ep.r_event_category_desc,ep.s_event_category_cd,ep.s_event_content_url,ep.s_event_title_url,ep.s_event_type_cd,sub1.s_event_sub_content_1_url,sub2.s_event_sub_content_2_str,lue.update_ts")
                .FROM("ls_user_event.l_user_event lue inner join ls_user_event.s_user_event_active uea on uea.l_user_event_id=lue.l_user_event_id and uea.s_user_event_active_ind=0 inner join hs_event.s_event_active sea on sea.h_event_id=lue.h_event_id and sea.s_event_active_ind=0 inner join hs_user.h_user h_user on h_user.h_user_id=lue.h_user_id"
                        + " left outer join hs_event.t_event_page ep on ep.h_event_id=lue.h_event_id left outer join hs_event.s_event_sub_content_1 sub1 on ep.h_event_id=sub1.h_event_id left outer join hs_event.s_event_sub_content_2 sub2 on sub1.s_event_sub_content_1_id=sub2.s_event_sub_content_2_id");

        sql.WHERE("ep.s_event_active_ind=0").WHERE("h_user.h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");

        if (paramMap.get("sUserEventLikeInd") != null) {
            sql.INNER_JOIN(
                    "ls_user_event.s_user_event_like uel on uel.l_user_event_id=lue.l_user_event_id and uel.s_user_event_like_ind= #{sUserEventLikeInd,jdbcType=INTEGER}").ORDER_BY("uel.update_ts desc");
        }

        if (paramMap.get("sUserEventReadLogTxt") != null) {
            sql.INNER_JOIN(
                    "ls_user_event.s_user_event_read uer on lue.l_user_event_id=uer.l_user_event_id and uer.s_user_event_read_log_txt like concat('%',#{sUserEventReadLogTxt,jdbcType=VARCHAR},'%')");
        }

//        if (paramMap.get("sUserEventLikeInd") != null) {
//            sql.ORDER_BY("uel.update_ts desc");
//        } else {
            sql.ORDER_BY("lue.update_ts desc");
//        }

        if (paramMap.get("start") != null && paramMap.get("end") != null) {
            String sqlString = sql.toString() + (" limit " + paramMap.get("start") + ", " + paramMap.get("end"));
            return sqlString;
        }

        return sql.toString();
    }

    // getTEventPageListByConditionAndUserCount
    public String getTEventPageListByConditionAndUserCount(Map<String, Object> paramMap) {
        SQL sql = new SQL();

        sql.SELECT(
                "distinct ep.h_event_id,ep.r_event_category_desc,ep.s_event_category_cd,ep.s_event_content_url,ep.s_event_title_url,ep.s_event_type_cd,sub1.s_event_sub_content_1_url,sub2.s_event_sub_content_2_str")
                .FROM("ls_user_event.l_user_event lue inner join ls_user_event.s_user_event_active uea on uea.l_user_event_id=lue.l_user_event_id and uea.s_user_event_active_ind=0 inner join hs_event.s_event_active sea on sea.h_event_id=lue.h_event_id and sea.s_event_active_ind=0 inner join hs_user.h_user h_user on h_user.h_user_id=lue.h_user_id"
                        + " left outer join hs_event.t_event_page ep on ep.h_event_id=lue.h_event_id left outer join hs_event.s_event_sub_content_1 sub1 on ep.h_event_id=sub1.h_event_id left outer join hs_event.s_event_sub_content_2 sub2 on sub1.s_event_sub_content_1_id=sub2.s_event_sub_content_2_id");

        sql.WHERE("ep.s_event_active_ind=0").WHERE("h_user.h_user_phone_nr = #{hUserPhoneNr,jdbcType=BIGINT}");

        if (paramMap.get("sUserEventLikeInd") != null) {
            sql.INNER_JOIN(
                    "ls_user_event.s_user_event_like uel on uel.l_user_event_id=lue.l_user_event_id and uel.s_user_event_like_ind= #{sUserEventLikeInd,jdbcType=INTEGER}");
        }

        if (paramMap.get("sUserEventReadLogTxt") != null) {
            sql.INNER_JOIN(
                    "ls_user_event.s_user_event_read uer on lue.l_user_event_id=uer.l_user_event_id and uer.s_user_event_read_log_txt like concat('%',#{sUserEventReadLogTxt,jdbcType=VARCHAR},'%')");
        }

        return "select count(1) FROM (" + sql.toString() + ") alias_name";
    }

    public static void main(String[] args) {
        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("hMessageId", 1);
        // paramMap.put("sMessageCategoryCd", 1);
        //
        // String sql = getTMessageSummaryList(paramMap);
        // System.out.println("sql=\n" + sql);
        //
        // String sqlCount = getTMessageSummaryListCount(paramMap);
        // System.out.println("sqlCount=\n" + sqlCount);

        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("hUserPhoneNr", 13333333333l);
        // paramMap.put("sEventCategoryCd", 1);
        // // paramMap.put("sUserEventLikeInd", 1);
        // paramMap.put("sUserEventReadLogTxt", "gre");
        //
        // String sql = getTEventPageListByCondition(paramMap);
        // System.out.println("getTEventPageListByCondition=\n" + sql);
    }
}