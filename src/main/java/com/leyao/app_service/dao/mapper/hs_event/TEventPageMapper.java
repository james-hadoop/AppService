package com.leyao.app_service.dao.mapper.hs_event;

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

import com.leyao.app_service.entity.hs_event.TEventPage;

public interface TEventPageMapper {
    @Delete({ "delete from t_event_page", "where h_event_id = #{hEventId,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long hEventId);

    @Insert({ "insert into t_event_page (h_event_id, s_event_category_cd, ", "r_event_category_desc, s_event_type_cd, ",
            "r_event_type_desc, s_event_title_url, ", "s_event_content_url, s_event_sub_content_1_url, ",
            "s_event_sub_content_2_str, s_event_active_ind, ", "create_ts, update_ts, ", "s_event_search_content_txt)",
            "values (#{hEventId,jdbcType=BIGINT}, #{sEventCategoryCd,jdbcType=INTEGER}, ",
            "#{rEventCategoryDesc,jdbcType=VARCHAR}, #{sEventTypeCd,jdbcType=INTEGER}, ",
            "#{rEventTypeDesc,jdbcType=VARCHAR}, #{sEventTitleUrl,jdbcType=VARCHAR}, ",
            "#{sEventContentUrl,jdbcType=VARCHAR}, #{sEventSubContent1Url,jdbcType=VARCHAR}, ",
            "#{sEventSubContent2Str,jdbcType=VARCHAR}, #{sEventActiveInd,jdbcType=INTEGER}, ",
            "#{createTs,jdbcType=TIMESTAMP}, #{updateTs,jdbcType=TIMESTAMP}, ",
            "#{sEventSearchContentTxt,jdbcType=LONGVARCHAR})" })
    int insert(TEventPage record);

    @InsertProvider(type = TEventPageSqlProvider.class, method = "insertSelective")
    int insertSelective(TEventPage record);

    @Select({ "select", "h_event_id, s_event_category_cd, r_event_category_desc, s_event_type_cd, r_event_type_desc, ",
            "s_event_title_url, s_event_content_url, s_event_sub_content_1_url, s_event_sub_content_2_str, ",
            "s_event_active_ind, create_ts, update_ts, s_event_search_content_txt", "from t_event_page",
            "where h_event_id = #{hEventId,jdbcType=BIGINT}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_2_str", property = "sEventSubContent2Str", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    TEventPage selectByPrimaryKey(Long hEventId);

    @UpdateProvider(type = TEventPageSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TEventPage record);

    @Update({ "update t_event_page", "set s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER},",
            "r_event_category_desc = #{rEventCategoryDesc,jdbcType=VARCHAR},",
            "s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER},",
            "r_event_type_desc = #{rEventTypeDesc,jdbcType=VARCHAR},",
            "s_event_title_url = #{sEventTitleUrl,jdbcType=VARCHAR},",
            "s_event_content_url = #{sEventContentUrl,jdbcType=VARCHAR},",
            "s_event_sub_content_1_url = #{sEventSubContent1Url,jdbcType=VARCHAR},",
            "s_event_sub_content_2_str = #{sEventSubContent2Str,jdbcType=VARCHAR},",
            "s_event_active_ind = #{sEventActiveInd,jdbcType=INTEGER},", "create_ts = #{createTs,jdbcType=TIMESTAMP},",
            "update_ts = #{updateTs,jdbcType=TIMESTAMP},",
            "s_event_search_content_txt = #{sEventSearchContentTxt,jdbcType=LONGVARCHAR}",
            "where h_event_id = #{hEventId,jdbcType=BIGINT}" })
    int updateByPrimaryKeyWithBLOBs(TEventPage record);

    @Update({ "update t_event_page", "set s_event_category_cd = #{sEventCategoryCd,jdbcType=INTEGER},",
            "r_event_category_desc = #{rEventCategoryDesc,jdbcType=VARCHAR},",
            "s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER},",
            "r_event_type_desc = #{rEventTypeDesc,jdbcType=VARCHAR},",
            "s_event_title_url = #{sEventTitleUrl,jdbcType=VARCHAR},",
            "s_event_content_url = #{sEventContentUrl,jdbcType=VARCHAR},",
            "s_event_sub_content_1_url = #{sEventSubContent1Url,jdbcType=VARCHAR},",
            "s_event_sub_content_2_str = #{sEventSubContent2Str,jdbcType=VARCHAR},",
            "s_event_active_ind = #{sEventActiveInd,jdbcType=INTEGER},", "create_ts = #{createTs,jdbcType=TIMESTAMP},",
            "update_ts = #{updateTs,jdbcType=TIMESTAMP}", "where h_event_id = #{hEventId,jdbcType=BIGINT}" })
    int updateByPrimaryKey(TEventPage record);

    @Select({ "select * from t_event_page where s_event_type_cd = #{sEventTypeCd} limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageList(Map<String, Object> paramMap);

    @Select({
            "select count(1) from t_event_page where s_event_type_cd = #{sEventTypeCd,jdbcType=INTEGER} limit #{start}, #{end}" })
    Integer getTEventPageListCount(Map<String, Object> paramMap);

    // getAllTEventPageList
    @Select({
            "SELECT * FROM hs_event.t_event_page where s_event_active_ind=0 order by h_event_id desc limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getAllTEventPageList(Map<String, Object> paramMap);

    // getAllTEventPageListCount
    @Select({
            "select count(1) from (SELECT h_event_id FROM hs_event.t_event_page where s_event_active_ind=0 limit #{start}, #{end}) as t" })
    Integer getAllTEventPageListCount(Map<String, Object> paramMap);

    // getTEventPageListForRecom1
    @Select({
            "SELECT ep.*, er1.s_event_recom_position_cd FROM (select * FROM hs_event.t_event_page where s_event_type_cd=1 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_1 as er1 on er1.h_event_id=ep.h_event_id order by er1.s_event_recom_position_cd asc, ep.h_event_id desc limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageListForRecom1(Map<String, Object> paramMap);

    // getTEventPageListForRecom1Count
    @Select({
            "SELECT COUNT(1) FROM (SELECT ep.h_event_id FROM (select h_event_id FROM hs_event.t_event_page where s_event_type_cd=1 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_1 as er1 on er1.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })
    Integer getTEventPageListForRecom1Count(Map<String, Object> paramMap);

    // getTEventPageListForRecom2
    @Select({
            "SELECT ep.*, er2.s_event_recom_position_cd FROM (select * FROM hs_event.t_event_page where s_event_type_cd=2 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_2 as er2 on er2.h_event_id=ep.h_event_id order by er2.s_event_recom_position_cd asc, ep.h_event_id desc limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_2_url", property = "sEventSubContent2Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageListForRecom2(Map<String, Object> paramMap);

    // getTEventPageListForRecom2Count
    @Select({
            "SELECT COUNT(1) FROM (SELECT ep.h_event_id FROM (select h_event_id FROM hs_event.t_event_page where s_event_type_cd=2 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_2 as er2 on er2.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })
    Integer getTEventPageListForRecom2Count(Map<String, Object> paramMap);

    // getTEventPageListForRecom3
    @Select({
            "SELECT ep.*, er3.s_event_recom_position_cd FROM (select * FROM hs_event.t_event_page where s_event_type_cd=3 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_3 as er3 on er3.h_event_id=ep.h_event_id order by er3.s_event_recom_position_cd asc, ep.h_event_id desc limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_3_url", property = "sEventSubContent3Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageListForRecom3(Map<String, Object> paramMap);

    // getTEventPageListForRecom3Count
    @Select({
            "SELECT COUNT(1) FROM (SELECT ep.h_event_id FROM (select h_event_id FROM hs_event.t_event_page where s_event_type_cd=3 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_3 as er3 on er3.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })
    Integer getTEventPageListForRecom3Count(Map<String, Object> paramMap);

    // getTEventPageListByCategory
    @Select({
            "select p.*,sc.s_event_sub_content_1_url as s_event_sub_content_1_url_r,sc.s_event_sub_content_2_str as s_event_sub_content_2_str_r from  (select * from hs_event.t_event_page where s_event_category_cd=#{sEventCategoryCd} and s_event_active_ind=0) as p left outer join (select sc1.h_event_id, sc1.s_event_sub_content_1_url,sc2.s_event_sub_content_2_str from hs_event.s_event_sub_content_1 as sc1 inner join hs_event.s_event_sub_content_2 as sc2 on sc1.s_event_sub_content_1_id = sc2.s_event_sub_content_2_id) as sc on sc.h_event_id=p.h_event_id order by h_event_id desc limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url_r", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_2_str_r", property = "sEventSubContent2Str", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageListByCategory(Map<String, Object> paramMap);

    // getTEventPageListByCategoryCount
    @Select({
            "select count(1) from (select * from hs_event.t_event_page where s_event_category_cd=#{sEventCategoryCd} and s_event_active_ind=0 limit #{start}, #{end}) as t" })
    Integer getTEventPageListByCategoryCount(Map<String, Object> paramMap);

    // getTEventPageListForBanner
    @Select({
            "select ep.* from (select * from hs_event.t_event_page where s_event_active_ind=0) as ep left outer join hs_event.s_event_banner as eb on eb.h_event_id=ep.h_event_id  order by eb.s_event_banner_position_cd, ep.h_event_id desc limit #{start}, #{end}" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageListForBanner(Map<String, Object> paramMap);

    // getTEventPageListForBannerCount
    @Select({
            "select count(1) from (select ep.h_event_id from (select h_event_id from hs_event.t_event_page where s_event_active_ind=0) as ep left outer join hs_event.s_event_banner as eb on eb.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })
    Integer getTEventPageListForBannerCount(Map<String, Object> paramMap);
    
    // getTEventPageListByCondition
    @SelectProvider(type=TEventPageSqlProvider.class, method="getTMessageSummaryListByCondition")
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getTEventPageListByCondition(Map<String, Object> paramMap);

    // getTEventPageListByConditionCount
    @SelectProvider(type=TEventPageSqlProvider.class, method="getTEventPageListByConditionCount")
    Integer getTEventPageListByConditionCount(Map<String, Object> paramMap);
}