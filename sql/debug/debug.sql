    // getAllTEventPageList
    @Select({
            "SELECT * FROM hs_event.t_event_page where s_event_active_ind=0 order by h_event_id desc limit #{start}, #{end}" })

    // getAllTEventPageListCount
    @Select({
            "select count(1) from (SELECT h_event_id FROM hs_event.t_event_page where s_event_active_ind=0 limit #{start}, #{end}) as t" })

    // getTEventPageListForRecom1
    @Select({
            "SELECT ep.*, er1.s_event_recom_position_cd FROM (select * FROM hs_event.t_event_page where s_event_type_cd=1 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_1 as er1 on er1.h_event_id=ep.h_event_id order by er1.s_event_recom_position_cd asc, ep.h_event_id desc limit #{start}, #{end}" })

    // getTEventPageListForRecom1Count
    @Select({
            "SELECT COUNT(1) FROM (SELECT ep.h_event_id FROM (select h_event_id FROM hs_event.t_event_page where s_event_type_cd=1 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_1 as er1 on er1.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })

    // getTEventPageListForRecom2
    @Select({
            "SELECT ep.*, er2.s_event_recom_position_cd FROM (select * FROM hs_event.t_event_page where s_event_type_cd=2 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_2 as er2 on er2.h_event_id=ep.h_event_id order by er2.s_event_recom_position_cd asc, ep.h_event_id desc limit #{start}, #{end}" })

    // getTEventPageListForRecom2Count
    @Select({
            "SELECT COUNT(1) FROM (SELECT ep.h_event_id FROM (select h_event_id FROM hs_event.t_event_page where s_event_type_cd=2 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_2 as er2 on er2.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })

    // getTEventPageListForRecom3
    @Select({
            "SELECT ep.*, er3.s_event_recom_position_cd FROM (select * FROM hs_event.t_event_page where s_event_type_cd=3 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_3 as er3 on er3.h_event_id=ep.h_event_id order by er3.s_event_recom_position_cd asc, ep.h_event_id desc limit #{start}, #{end}" })

    // getTEventPageListForRecom3Count
    @Select({
            "SELECT COUNT(1) FROM (SELECT ep.h_event_id FROM (select h_event_id FROM hs_event.t_event_page where s_event_type_cd=3 and s_event_active_ind=0) as ep left outer join hs_event.s_event_recom_3 as er3 on er3.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })

    // getTEventPageListByCategory
    @Select({
            "select * from hs_event.t_event_page where s_event_category_cd=#{sEventCategoryCd} and s_event_active_ind=0 order by h_event_id desc limit #{start}, #{end}" })

    // getTEventPageListByCategoryCount
    @Select({
            "select count(1) from (select * from hs_event.t_event_page where s_event_category_cd=#{sEventCategoryCd} and s_event_active_ind=0 limit #{start}, #{end}) as t" })

    // getTEventPageListForBanner
    @Select({
            "select ep.* from (select * from hs_event.t_event_page where s_event_active_ind=0) as ep left outer join hs_event.s_event_banner as eb on eb.h_event_id=ep.h_event_id  order by eb.s_event_banner_position_cd, ep.h_event_id desc limit #{start}, #{end}" })

    // getTEventPageListForBannerCount
    @Select({
            "select count(1) from (select ep.h_event_id from (select h_event_id from hs_event.t_event_page where s_event_active_ind=0) as ep left outer join hs_event.s_event_banner as eb on eb.h_event_id=ep.h_event_id limit #{start}, #{end}) as t" })
