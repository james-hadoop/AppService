truncate table hs_event.hs_event;
INSERT INTO hs_event.hs_event (h_event_id,create_ts,update_ts) VALUES 
(1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(6,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(7,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(8,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(9,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(10,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(11,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(12,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(13,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(14,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(15,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(16,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(17,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(18,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(19,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(20,'2017-09-15 22:55:00.000','2017-10-10 16:48:32.000')
,(21,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(22,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(23,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(24,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(25,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(26,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(27,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(28,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(29,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(30,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(31,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(32,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table ls_user_message.s_user_message_active; 
INSERT INTO ls_user_message.s_user_message_active (s_user_message_active_id,l_user_message_id,s_user_message_active_ind,create_ts,update_ts) VALUES 
(1,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table ls_user_message.l_user_message;
INSERT INTO ls_user_message.l_user_message (l_user_message_id,h_user_id,h_message_id,create_ts,update_ts) VALUES 
(1,1,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table ls_user_event.s_user_event_read; 
INSERT INTO ls_user_event.s_user_event_read (s_user_event_read_id,l_user_event_id,s_user_event_read_log_txt,create_ts,update_ts) VALUES 
(1,1,'great','2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table ls_user_event.s_user_event_like;
INSERT INTO ls_user_event.s_user_event_like (s_user_event_like_id,l_user_event_id,s_user_event_like_ind,create_ts,update_ts) VALUES 
(1,1,1,'2017-09-15 22:55:00.000','2017-09-17 20:24:40.000')
;

truncate table ls_user_event.s_user_event_active; 
INSERT INTO ls_user_event.s_user_event_active (s_user_event_active_id,l_user_event_id,s_user_event_active_ind,create_ts,update_ts) VALUES 
(1,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table ls_user_event.l_user_event;
INSERT INTO ls_user_event.l_user_event (l_user_event_id,h_user_id,h_event_id,create_ts,update_ts) VALUES 
(1,1,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_user.t_user_page; 
INSERT INTO hs_user.t_user_page (h_user_id,h_user_phone_nr,s_user_gender_cd,s_user_gender_desc,s_user_name_str,s_user_profile_url,s_user_email_str,s_user_active_ind,create_ts,update_ts) VALUES 
(1,13333333333,0,'','','','',0,'2000-01-01 00:00:00.000','2000-01-01 00:00:00.000')
,(3,15821615886,0,'','','','',0,'2017-09-19 23:18:55.000','2017-09-19 23:36:21.000')
;

truncate table hs_user.s_user_password;
INSERT INTO hs_user.s_user_password (s_user_password_id,h_user_id,s_user_password_str,create_ts,update_ts) VALUES 
(1,1,'5f4dcc3b5aa765d61d8327deb882cf99','2000-01-01 00:00:00.000','2017-09-17 19:46:26.000')
,(12,3,'5f4dcc3b5aa765d61d8327deb882cf99','2017-09-19 23:18:55.000','2017-09-19 23:23:49.000')
;

truncate table hs_user.s_user_feedback; 
INSERT INTO hs_user.s_user_feedback (s_user_feedback_id,h_user_id,s_user_feedback_str,create_ts,update_ts) VALUES 
(1,1,'Leyao app is great!!!','2000-01-01 00:00:00.000','2017-10-10 21:33:40.000')
,(2,1,'Hi Leyao!!!','2000-01-01 00:00:00.000','2017-10-10 23:01:04.000')
,(3,1,'Hi Leyao2!!!','2000-01-01 00:00:00.000','2000-01-01 00:00:00.000')
;

truncate table hs_user.h_user; 
INSERT INTO hs_user.h_user (h_user_id,h_user_phone_nr,create_ts,update_ts) VALUES 
(1,13333333333,'2000-01-01 00:00:00.000','2000-01-01 00:00:00.000')
,(3,15821615886,'2017-09-19 23:18:55.000','2017-09-19 23:18:55.000')
;

truncate table hs_message.s_message_content; 
INSERT INTO hs_message.s_message_content (s_message_content_id,h_message_id,s_message_content_str,create_ts,update_ts) VALUES 
(1,1,'first message','2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_message.s_message_category; 
INSERT INTO hs_message.s_message_category (s_message_content_id,h_message_id,s_message_category_cd,create_ts,update_ts) VALUES 
(1,1,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_message.s_message_active; 
INSERT INTO hs_message.s_message_active (s_message_active_id,h_message_id,s_message_active_ind,create_ts,update_ts) VALUES 
(1,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_message.hs_message; 
INSERT INTO hs_message.hs_message (h_message_id,create_ts,update_ts) VALUES 
(1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_event.t_event_page;
INSERT INTO hs_event.t_event_page (h_event_id,s_event_category_cd,r_event_category_desc,s_event_type_cd,r_event_type_desc,s_event_title_url,s_event_content_url,s_event_sub_content_1_url,s_event_sub_content_2_str,s_event_search_content_txt,s_event_active_ind,create_ts,update_ts) VALUES 
(1,1,'d1',1,'image','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','1',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(2,1,'d1',1,'image','static/image/2.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','2',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(3,1,'d1',1,'image','static/image/3.jpg','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','3',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(4,1,'d1',1,'image','static/image/4.jpg','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','4',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(5,1,'d1',1,'image','static/image/5.jpg','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','5',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(6,1,'d1',1,'image','static/image/6.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','6',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(7,2,'d1',3,'vedio','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','7',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(8,2,'d1',3,'vedio','static/image/2.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','8',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(9,2,'d1',3,'vedio','static/image/3.jpg','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','9',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(10,2,'d1',3,'vedio','static/image/4.jpg','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','10',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(11,2,'d1',3,'vedio','static/image/5.jpg','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','11',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(12,2,'d1',3,'vedio','static/image/6.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','12',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(13,3,'d1',2,'audio','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','13',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(14,3,'d1',2,'audio','static/image/2.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','14',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(15,3,'d1',2,'audio','static/image/3.jpg','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','15',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(16,3,'d1',2,'audio','static/image/4.jpg','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','16',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(17,3,'d1',2,'audio','static/image/5.jpg','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','17',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(18,3,'d1',2,'audio','static/image/6.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','18',0,'2017-09-15 23:28:19.000','2017-10-12 10:46:30.000')
,(19,4,'d2',1,'image','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','audio/1.mp3','{"lyricist":"peter","composer":"tom","singer":"linda"}','{"url":"audio/a.mp3","lyricist":"peter","composer":"tom","singer":"linda"}',0,'2017-09-15 22:55:00.000','2017-10-10 16:47:41.000')
,(20,4,'Album',1,'Audio','static/image/2.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','com.leyao.app_service.entity.hs_event.SEventSubContent1@7975f5ab','com.leyao.app_service.entity.hs_event.SEventSubContent2@ca510d1','?',0,'2017-09-15 22:55:00.000','2017-10-10 16:48:32.000')
;

truncate table hs_event.s_event_sub_content_2; 
INSERT INTO hs_event.s_event_sub_content_2 (s_event_sub_content_2_id,h_event_id,s_event_sub_content_2_str,create_ts,update_ts) VALUES 
(1,19,'{"lyricist":"peter","composer":"tom","singer":"linda"}','2017-09-15 22:55:00.000','2017-10-10 16:48:01.000')
,(2,19,'{"lyricist":"peter","composer":"tom","singer":"linda"}','2017-09-15 22:55:00.000','2017-10-10 16:48:01.000')
,(3,19,'{"lyricist":"peter","composer":"tom","singer":"linda"}','2017-09-15 22:55:00.000','2017-10-10 16:48:01.000')
,(7,20,'{"lyricist":"ss","composer":"tom","singer":"linda"}','2000-01-01 00:00:00.000','2017-10-10 16:48:32.000')
,(8,20,'{"lyricist":"peter","composer":"tom","singer":"linda"}','2000-01-01 00:00:00.000','2017-10-10 16:48:32.000')
,(9,20,'{"lyricist":"peter","composer":"tom","singer":"linda"}','2000-01-01 00:00:00.000','2017-10-10 16:48:32.000')
;

truncate table hs_event.s_event_sub_content_1; 
INSERT INTO hs_event.s_event_sub_content_1 (s_event_sub_content_1_id,h_event_id,s_event_sub_content_1_url,create_ts,update_ts) VALUES 
(1,19,'static/audio/1.mp3','2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,19,'static/audio/2.mp3','2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,19,'static/audio/3.mp3','2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(7,20,'static/audio/1.mp3','2000-01-01 00:00:00.000','2017-10-10 16:48:32.000')
,(8,20,'static/audio/2.mp3','2000-01-01 00:00:00.000','2017-10-10 16:48:32.000')
,(9,20,'static/audio/3.mp3','2000-01-01 00:00:00.000','2017-10-10 16:48:32.000')
;

truncate table hs_event.s_event_recom_3; 
INSERT INTO hs_event.s_event_recom_3 (s_event_recom_3_id,h_event_id,s_event_recom_position_cd,s_event_recom_active_ind,create_ts,update_ts) VALUES 
(1,1,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,2,2,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,3,3,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,4,4,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,5,5,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(6,6,6,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_event.s_event_recom_2; 
INSERT INTO hs_event.s_event_recom_2 (s_event_recom_2_id,h_event_id,s_event_recom_position_cd,s_event_recom_active_ind,create_ts,update_ts) VALUES 
(1,7,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,8,2,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,9,3,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,10,4,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,11,5,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(6,11,6,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_event.s_event_recom_1; 
INSERT INTO hs_event.s_event_recom_1 (s_event_recom_1_id,h_event_id,s_event_recom_position_cd,s_event_recom_active_ind,create_ts,update_ts) VALUES 
(1,13,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,14,2,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,15,3,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,16,4,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,17,5,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(6,18,6,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_event.t_event_page;
INSERT INTO hs_event.t_event_page (h_event_id,s_event_category_cd,r_event_category_desc,s_event_type_cd,r_event_type_desc,s_event_title_url,s_event_content_url,s_event_sub_content_1_url,s_event_sub_content_2_str,s_event_search_content_txt,s_event_active_ind,create_ts,update_ts) VALUES 
(1,1,'d1',1,'image','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','1',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(2,1,'d1',1,'image','static/image/2.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','2',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(3,1,'d1',1,'image','static/image/3.jpg','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','3',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(4,1,'d1',1,'image','static/image/4.jpg','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','4',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(5,1,'d1',1,'image','static/image/5.jpg','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','5',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(6,1,'d1',1,'image','static/image/6.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','6',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(7,0,'d1',3,'vedio','static/vedio/1.mp4','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','7',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(8,0,'d1',3,'vedio','static/vedio/2.mp4','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','8',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(9,0,'d1',3,'vedio','static/vedio/3.mp4','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','9',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(10,0,'d1',3,'vedio','static/vedio/4.mp4','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','10',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(11,0,'d1',3,'vedio','static/vedio/5.mp4','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','11',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(12,0,'d1',3,'vedio','static/vedio/6.mp4','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','12',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(13,0,'d1',2,'audio','static/audio/1.mp3','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','13',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(14,0,'d1',2,'audio','static/audio/2.mp3','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','14',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(15,0,'d1',2,'audio','static/audio/3.mp3','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','15',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(16,0,'d1',2,'audio','static/audio/4.mp3','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','16',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(17,0,'d1',2,'audio','static/audio/5.mp3','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','17',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:30.000')
,(18,0,'d1',2,'audio','static/audio/6.mp3','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','18',0,'2017-09-15 23:28:19.000','2017-10-12 10:46:30.000')
,(19,4,'d4',1,'image','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','audio/1.mp3','{"lyricist":"peter","composer":"tom","singer":"linda"}','{"url":"audio/a.mp3","lyricist":"peter","composer":"tom","singer":"linda"}',0,'2017-09-15 22:55:00.000','2017-10-10 16:47:41.000')
,(20,4,'d4',1,'image','static/image/2.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','com.leyao.app_service.entity.hs_event.SEventSubContent1@7975f5ab','com.leyao.app_service.entity.hs_event.SEventSubContent2@ca510d1','?',0,'2017-09-15 22:55:00.000','2017-10-10 16:48:32.000')
,(21,2,'d1',1,'image','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','1',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(22,2,'d1',1,'image','static/image/2.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','2',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(23,2,'d1',1,'image','static/image/3.jpg','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','3',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(24,2,'d1',1,'image','static/image/4.jpg','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','4',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(25,2,'d1',1,'image','static/image/5.jpg','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','5',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(26,2,'d1',1,'image','static/image/6.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','6',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(27,3,'d1',1,'image','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','1',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(28,3,'d1',1,'image','static/image/2.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','','?','2',0,'2017-09-15 22:55:00.000','2017-09-21 21:46:24.000')
,(29,3,'d1',1,'image','static/image/3.jpg','http://mp.weixin.qq.com/s/YxYsMqTQOHn9j0yhS0XqGQ','','?','3',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(30,3,'d1',1,'image','static/image/4.jpg','http://mp.weixin.qq.com/s/0i_4wHBcs-bJS8eCoPuSZg','','?','4',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(31,3,'d1',1,'image','static/image/5.jpg','http://mp.weixin.qq.com/s/w6qAt6MAc2cSXJhQgSMMQw','','?','5',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
,(32,3,'d1',1,'image','static/image/6.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','','?','6',0,'2017-09-15 22:55:00.000','2017-10-12 10:46:29.000')
;

truncate table hs_event.s_event_category; 
INSERT INTO hs_event.s_event_category (s_event_category_id,h_event_id,s_event_category_cd,create_ts,update_ts) VALUES 
(1,1,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,2,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,3,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,4,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,5,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(6,6,1,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(7,7,2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(8,8,2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(9,9,2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(10,10,2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(11,11,2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(12,12,2,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(13,13,3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(14,14,3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(15,15,3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(16,16,3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(17,17,3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(18,18,3,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(19,19,4,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(20,20,4,'2017-09-15 22:55:00.000','2017-10-10 16:48:32.000')
;

truncate table hs_event.s_event_banner; 
INSERT INTO hs_event.s_event_banner (s_event_banner_id,h_event_id,s_event_banner_position_cd,s_event_banner_active_ind,create_ts,update_ts) VALUES 
(1,1,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,2,2,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,3,3,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,4,4,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,55,5,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
;

truncate table hs_event.s_event_active; 
INSERT INTO hs_event.s_event_active (s_event_active_id,h_event_id,s_event_active_ind,create_ts,update_ts) VALUES 
(1,1,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(2,2,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(3,3,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(4,4,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(5,5,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(6,6,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(7,7,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(8,8,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(9,9,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(10,10,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(11,11,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(12,12,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(13,13,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(14,14,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(15,15,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(16,16,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(17,17,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(18,0,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(19,19,0,'2017-09-15 22:55:00.000','2017-09-15 22:55:00.000')
,(20,20,0,'2017-09-15 22:55:00.000','2017-10-10 16:48:32.000')
;