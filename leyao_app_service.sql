--create database hs_event;
use hs_event;

DROP TABLE IF EXISTS `t_event_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_event_page` (
  `h_event_id` bigint(20) unsigned NOT NULL COMMENT '事件banner页信息相关记录序列代理键',
  `s_event_category_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件种类编码',
  `r_event_category_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件种类定义',
  `s_event_type_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件类型编码',
  `r_event_type_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件类型定义',
  `s_event_title_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件标题url',
  `s_event_content_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件内容url',
  `s_event_sub_content_1_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件子内容1相关url',
  `s_event_search_content_txt` text NOT NULL COMMENT '事件搜索内容，存放搜索相关关键字集合',
  `s_event_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乐谣创建以及更新事件时更新，提供搜索引擎信息入口，将所有事件相关关键词全部存放于字段内s_event_search_content_txt';
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('1', '1', 'd1', '3', 'image', 'image/1.jpg', 'image/1.jpg', '1');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('2', '1', 'd1', '3', 'image', 'image/2.jpg', 'image/2.jpg', '2');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('3', '1', 'd1', '3', 'image', 'image/3.jpg', 'image/3.jpg', '3');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('4', '1', 'd1', '3', 'image', 'image/4.jpg', 'image/4.jpg', '4');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('5', '1', 'd1', '3', 'image', 'image/5.jpg', 'image/5.jpg', '5');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('6', '1', 'd1', '3', 'image', 'image/6.jpg', 'image/6.jpg', '6');

INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('7', '1', 'd1', '1', 'vedio', 'vedio/1.mp4', 'vedio/1.mp4', '7');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('8', '1', 'd1', '1', 'vedio', 'vedio/2.mp4', 'vedio/2.mp4', '8');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('9', '1', 'd1', '1', 'vedio', 'vedio/3.mp4', 'vedio/3.mp4', '9');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('10', '1', 'd1', '1', 'vedio', 'vedio/4.mp4', 'vedio/1.mp4', '10');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('11', '1', 'd1', '1', 'vedio', 'vedio/5.mp4', 'vedio/2.mp4', '11');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('12', '1', 'd1', '1', 'vedio', 'vedio/6.mp4', 'vedio/3.mp4', '12');

INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('13', '1', 'd1', '2', 'audio', 'audio/1.mp3', 'audio/1.mp3', '13');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('14', '1', 'd1', '2', 'audio', 'audio/2.mp3', 'audio/2.mp3', '14');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('15', '1', 'd1', '2', 'audio', 'audio/3.mp3', 'audio/3.mp3', '15');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('16', '1', 'd1', '2', 'audio', 'audio/4.mp3', 'audio/1.mp3', '16');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('17', '1', 'd1', '2', 'audio', 'audio/5.mp3', 'audio/2.mp3', '17');
INSERT INTO `hs_event`.`t_event_page` (`h_event_id`, `s_event_category_cd`, `r_event_category_desc`, `s_event_type_cd`, `r_event_type_desc`, `s_event_title_url`, `s_event_content_url`, `s_event_search_content_txt`) VALUES ('18', '1', 'd1', '2', 'audio', 'audio/6.mp3', 'audio/3.mp3', '18');


