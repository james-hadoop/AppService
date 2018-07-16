CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hs_event` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `hs_event`;

--
-- Table structure for table `hs_event`
--

DROP TABLE IF EXISTS `hs_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hs_event` (
  `h_event_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件录入后生成的代理键,自增长',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COMMENT='乐谣事件记录表，乐谣创建事件时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_event`
--

LOCK TABLES `hs_event` WRITE;
/*!40000 ALTER TABLE `hs_event` DISABLE KEYS */;
INSERT INTO `hs_event` VALUES (50,'2018-07-04 22:53:30','2018-07-04 22:53:30'),(51,'2018-07-04 22:55:24','2018-07-04 22:55:24'),(52,'2018-07-04 22:55:51','2018-07-04 22:55:51'),(53,'2018-07-04 22:57:01','2018-07-04 22:57:01'),(54,'2018-07-04 22:57:18','2018-07-11 15:17:00'),(55,'2018-07-04 22:57:33','2018-07-04 22:57:33'),(56,'2018-07-04 23:19:38','2018-07-05 00:27:26'),(57,'2018-07-04 23:21:16','2018-07-05 00:37:26'),(58,'2018-07-04 23:26:24','2018-07-04 23:26:24'),(59,'2018-07-04 23:27:51','2018-07-04 23:27:51'),(60,'2018-07-04 23:34:21','2018-07-04 23:34:21'),(61,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(62,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(63,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(64,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(65,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(66,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(67,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(68,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(69,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(70,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(71,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(72,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(73,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(74,'2018-07-05 00:25:15','2018-07-05 00:25:15'),(75,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(76,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(77,'2018-07-05 00:38:31','2018-07-05 00:38:31'),(78,'2018-07-05 00:39:04','2018-07-05 00:39:04'),(79,'2018-07-05 00:39:41','2018-07-05 00:39:41'),(80,'2018-07-05 00:45:49','2018-07-05 00:45:49'),(81,'2018-07-08 08:02:28','2018-07-08 08:02:28'),(82,'2018-07-08 08:02:56','2018-07-08 08:02:56'),(83,'2018-07-08 08:03:32','2018-07-08 08:03:32'),(84,'2018-07-11 16:51:49','2018-07-11 16:51:49');
/*!40000 ALTER TABLE `hs_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_active`
--

DROP TABLE IF EXISTS `s_event_active`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_active` (
  `s_event_active_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件激活相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_active_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COMMENT='事件记录表，乐谣创建事件时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_active`
--

LOCK TABLES `s_event_active` WRITE;
/*!40000 ALTER TABLE `s_event_active` DISABLE KEYS */;
INSERT INTO `s_event_active` VALUES (45,50,0,'2018-07-04 22:53:30','2018-07-04 22:53:30'),(46,51,0,'2018-07-04 22:55:24','2018-07-04 22:55:24'),(47,52,0,'2018-07-04 22:55:51','2018-07-04 22:55:51'),(48,53,0,'2018-07-04 22:57:01','2018-07-04 22:57:01'),(49,54,0,'2018-07-04 22:57:18','2018-07-11 15:17:00'),(50,55,0,'2018-07-04 22:57:33','2018-07-04 22:57:33'),(51,56,0,'2018-07-04 23:19:38','2018-07-05 00:27:26'),(52,57,0,'2018-07-04 23:21:16','2018-07-05 00:37:26'),(53,58,0,'2018-07-04 23:26:24','2018-07-04 23:26:24'),(54,59,0,'2018-07-04 23:27:51','2018-07-05 15:24:09'),(55,60,0,'2018-07-04 23:34:21','2018-07-04 23:34:21'),(56,61,0,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(57,62,0,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(58,63,0,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(59,64,0,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(60,65,0,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(61,66,0,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(62,67,0,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(63,68,0,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(64,69,0,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(65,70,0,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(66,71,0,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(67,72,0,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(68,73,0,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(69,74,0,'2018-07-05 00:25:15','2018-07-05 00:25:15'),(70,75,0,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(71,76,0,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(72,77,0,'2018-07-05 00:38:31','2018-07-05 00:38:31'),(73,78,0,'2018-07-05 00:39:04','2018-07-05 00:39:04'),(74,79,0,'2018-07-05 00:39:41','2018-07-05 00:39:41'),(75,80,1,'2018-07-05 00:45:49','2018-07-05 00:45:49'),(76,81,0,'2018-07-08 08:02:28','2018-07-08 08:02:28'),(77,82,0,'2018-07-08 08:02:56','2018-07-08 08:02:56'),(78,83,0,'2018-07-08 08:03:32','2018-07-08 08:03:32'),(79,84,0,'2018-07-11 16:51:49','2018-07-11 16:51:49');
/*!40000 ALTER TABLE `s_event_active` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_banner`
--

DROP TABLE IF EXISTS `s_event_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_banner` (
  `s_event_banner_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件banner页信息相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_banner_position_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件banner页位置编码',
  `s_event_banner_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件banner页激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_banner_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COMMENT='事件banner页信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在banner上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_banner`
--

LOCK TABLES `s_event_banner` WRITE;
/*!40000 ALTER TABLE `s_event_banner` DISABLE KEYS */;
INSERT INTO `s_event_banner` VALUES (32,50,1,0,'2018-07-04 22:53:30','2018-07-04 22:53:30'),(33,51,2,0,'2018-07-04 22:55:24','2018-07-04 22:55:24'),(34,52,3,0,'2018-07-04 22:55:51','2018-07-04 22:55:51'),(35,53,4,0,'2018-07-04 22:57:01','2018-07-04 22:57:01'),(36,54,5,0,'2018-07-04 22:57:18','2018-07-11 15:17:00'),(37,55,6,0,'2018-07-04 22:57:33','2018-07-11 17:00:41'),(38,56,0,0,'2018-07-04 23:19:38','2018-07-05 00:27:26'),(39,57,0,0,'2018-07-04 23:21:16','2018-07-05 00:37:26'),(40,58,0,0,'2018-07-04 23:26:24','2018-07-04 23:26:24'),(41,59,0,0,'2018-07-04 23:27:51','2018-07-04 23:27:51'),(42,60,0,0,'2018-07-04 23:34:21','2018-07-04 23:34:21'),(43,61,0,0,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(44,62,0,0,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(45,63,0,0,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(46,64,0,0,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(47,65,0,0,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(48,66,0,0,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(49,67,0,0,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(50,68,0,0,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(51,69,0,0,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(52,70,0,0,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(53,71,0,0,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(54,72,0,0,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(55,73,0,0,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(56,74,0,0,'2018-07-05 00:25:15','2018-07-05 00:25:15'),(57,75,0,0,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(58,76,0,0,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(59,77,0,0,'2018-07-05 00:38:31','2018-07-05 00:38:31'),(60,78,0,0,'2018-07-05 00:39:04','2018-07-05 00:39:04'),(61,79,0,0,'2018-07-05 00:39:41','2018-07-05 00:39:41'),(62,80,0,0,'2018-07-05 00:45:49','2018-07-05 00:45:49'),(63,81,0,0,'2018-07-08 08:02:28','2018-07-08 08:02:28'),(64,82,0,0,'2018-07-08 08:02:56','2018-07-08 08:02:56'),(65,83,0,0,'2018-07-08 08:03:32','2018-07-08 08:03:32'),(66,84,0,0,'2018-07-11 16:51:49','2018-07-11 16:59:57');
/*!40000 ALTER TABLE `s_event_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_category`
--

DROP TABLE IF EXISTS `s_event_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_category` (
  `s_event_category_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件种类相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_category_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件种类编码',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_category_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COMMENT='事件种类表，乐谣创建事件时记录，存放事件种类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_category`
--

LOCK TABLES `s_event_category` WRITE;
/*!40000 ALTER TABLE `s_event_category` DISABLE KEYS */;
INSERT INTO `s_event_category` VALUES (45,50,0,'2018-07-04 22:53:30','2018-07-04 22:53:30'),(46,51,0,'2018-07-04 22:55:24','2018-07-04 22:55:24'),(47,52,0,'2018-07-04 22:55:51','2018-07-04 22:55:51'),(48,53,0,'2018-07-04 22:57:01','2018-07-04 22:57:01'),(49,54,0,'2018-07-04 22:57:18','2018-07-11 15:17:00'),(50,55,0,'2018-07-04 22:57:33','2018-07-04 22:57:33'),(51,56,4,'2018-07-04 23:19:38','2018-07-05 00:27:26'),(52,57,4,'2018-07-04 23:21:16','2018-07-05 00:37:26'),(53,58,0,'2018-07-04 23:26:24','2018-07-04 23:26:24'),(54,59,0,'2018-07-04 23:27:51','2018-07-04 23:27:51'),(55,60,0,'2018-07-04 23:34:21','2018-07-04 23:34:21'),(56,61,0,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(57,62,0,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(58,63,0,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(59,64,0,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(60,65,0,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(61,66,0,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(62,67,0,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(63,68,0,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(64,69,0,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(65,70,0,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(66,71,0,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(67,72,0,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(68,73,0,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(69,74,0,'2018-07-05 00:25:15','2018-07-05 00:25:15'),(70,75,0,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(71,76,0,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(72,77,1,'2018-07-05 00:38:31','2018-07-05 00:38:31'),(73,78,2,'2018-07-05 00:39:04','2018-07-05 00:39:04'),(74,79,3,'2018-07-05 00:39:41','2018-07-05 00:39:41'),(75,80,2,'2018-07-05 00:45:49','2018-07-05 00:45:49'),(76,81,0,'2018-07-08 08:02:28','2018-07-08 08:02:28'),(77,82,0,'2018-07-08 08:02:56','2018-07-08 08:02:56'),(78,83,0,'2018-07-08 08:03:32','2018-07-08 08:03:32'),(79,84,0,'2018-07-11 16:51:49','2018-07-11 16:51:49');
/*!40000 ALTER TABLE `s_event_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_content`
--

DROP TABLE IF EXISTS `s_event_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_content` (
  `s_event_content_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件类型相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_title_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件标题url',
  `s_event_content_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件内容url',
  `create_ts` timestamp NOT NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NOT NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_content_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COMMENT='事件内容表，乐谣创建事件时记录，存放事件web view的标题和内容url地址';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_content`
--

LOCK TABLES `s_event_content` WRITE;
/*!40000 ALTER TABLE `s_event_content` DISABLE KEYS */;
INSERT INTO `s_event_content` VALUES (45,50,'static/image/banner_1.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 22:53:30','2018-07-04 22:53:30'),(46,51,'static/image/banner_2.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','2018-07-04 22:55:24','2018-07-04 22:55:24'),(47,52,'static/image/banner_3.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 22:55:51','2018-07-04 22:55:51'),(48,53,'static/image/banner_4.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 22:57:01','2018-07-04 22:57:01'),(49,54,'static/image/banner_5.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 22:57:18','2018-07-11 15:17:00'),(50,55,'static/image/banner_6.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 22:57:33','2018-07-04 22:57:33'),(51,56,'static/image/zhuanji_2.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 23:19:38','2018-07-05 00:27:26'),(52,57,'static/image/zhuanji_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-04 23:21:16','2018-07-05 00:37:26'),(53,58,'static/image/music_1.jpg','static/audio/1.mp3','2018-07-04 23:26:24','2018-07-04 23:26:24'),(54,59,'static/image/music_2.jpg','static/audio/2.mp3','2018-07-04 23:27:51','2018-07-04 23:27:51'),(55,60,'static/image/music_3.jpg','static/audio/3.mp3','2018-07-04 23:34:21','2018-07-04 23:34:21'),(56,61,'static/image/music_3.jpg','static/audio/3.mp3','2018-07-04 23:45:37','2018-07-04 23:45:37'),(57,62,'static/image/music_4.jpg','static/audio/4.mp3','2018-07-05 00:18:13','2018-07-05 00:18:13'),(58,63,'static/image/music_5.jpg','static/audio/5.mp3','2018-07-05 00:18:49','2018-07-05 00:18:49'),(59,64,'static/image/music_6.jpg','static/audio/6.mp3','2018-07-05 00:19:08','2018-07-05 00:19:08'),(60,65,'static/image/video_1.jpg','static/video/2.mp4','2018-07-05 00:21:13','2018-07-05 00:21:13'),(61,66,'static/image/video_2.jpg','static/video/2.mp4','2018-07-05 00:21:45','2018-07-05 00:21:45'),(62,67,'static/image/video_3.jpg','static/video/2.mp4','2018-07-05 00:22:04','2018-07-05 00:22:04'),(63,68,'static/image/video_4.jpg','static/video/2.mp4','2018-07-05 00:22:23','2018-07-05 00:22:23'),(64,69,'static/image/video_5.jpg','static/video/2.mp4','2018-07-05 00:22:39','2018-07-05 00:22:39'),(65,70,'static/image/video_6.jpg','static/video/2.mp4','2018-07-05 00:22:56','2018-07-05 00:22:56'),(66,71,'static/image/read_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:24:15','2018-07-05 00:24:15'),(67,72,'static/image/read_2.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:24:40','2018-07-05 00:24:40'),(68,73,'static/image/read_3.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:24:58','2018-07-05 00:24:58'),(69,74,'static/image/read_4.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:25:15','2018-07-05 00:25:15'),(70,75,'static/image/read_5.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:25:32','2018-07-05 00:25:32'),(71,76,'static/image/read_6.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:25:51','2018-07-05 00:25:51'),(72,77,'static/image/heshenghuodong_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:38:31','2018-07-05 00:38:31'),(73,78,'static/image/yinyuejiaoxue_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:39:04','2018-07-05 00:39:04'),(74,79,'static/image/yirenfenxiang_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:39:41','2018-07-05 00:39:41'),(75,80,'static/image/yinyuejiaoxue_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-05 00:45:49','2018-07-05 00:45:49'),(76,81,'static/image/music_0.jpg','static/audio/6.mp3','2018-07-08 08:02:28','2018-07-08 08:02:28'),(77,82,'static/image/video_0.jpg','static/video/2.mp4','2018-07-08 08:02:56','2018-07-08 08:02:56'),(78,83,'static/image/read_0.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','2018-07-08 08:03:32','2018-07-08 08:03:32'),(79,84,'static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','2018-07-11 16:51:49','2018-07-11 16:51:49');
/*!40000 ALTER TABLE `s_event_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_recom_1`
--

DROP TABLE IF EXISTS `s_event_recom_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_recom_1` (
  `s_event_recom_1_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件banner页信息相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_recom_position_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件推荐1号位位置编码',
  `s_event_recom_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件推荐1号位激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_recom_1_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COMMENT='事件推荐1号位信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在推荐菜单1上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_recom_1`
--

LOCK TABLES `s_event_recom_1` WRITE;
/*!40000 ALTER TABLE `s_event_recom_1` DISABLE KEYS */;
INSERT INTO `s_event_recom_1` VALUES (31,58,1,0,'2018-07-04 23:26:24','2018-07-05 07:46:21'),(32,59,2,0,'2018-07-04 23:27:51','2018-07-05 07:46:26'),(33,61,3,0,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(34,62,4,0,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(35,63,5,0,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(36,64,6,0,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(37,81,0,0,'2018-07-08 08:02:28','2018-07-08 08:02:28');
/*!40000 ALTER TABLE `s_event_recom_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_recom_2`
--

DROP TABLE IF EXISTS `s_event_recom_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_recom_2` (
  `s_event_recom_2_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件banner页信息相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_recom_position_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件推荐2号位位置编码',
  `s_event_recom_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件推荐2号位激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_recom_2_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='事件推荐2号位信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在推荐菜单2上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_recom_2`
--

LOCK TABLES `s_event_recom_2` WRITE;
/*!40000 ALTER TABLE `s_event_recom_2` DISABLE KEYS */;
INSERT INTO `s_event_recom_2` VALUES (15,65,1,0,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(16,66,2,0,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(17,67,3,0,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(18,68,4,0,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(19,69,5,0,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(20,70,6,0,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(21,82,0,0,'2018-07-08 08:02:56','2018-07-08 08:02:56');
/*!40000 ALTER TABLE `s_event_recom_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_recom_3`
--

DROP TABLE IF EXISTS `s_event_recom_3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_recom_3` (
  `s_event_recom_3_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件banner页信息相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_recom_position_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件推荐3号位位置编码',
  `s_event_recom_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件推荐3号位激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_recom_3_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='事件推荐3号位信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在推荐菜单3上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_recom_3`
--

LOCK TABLES `s_event_recom_3` WRITE;
/*!40000 ALTER TABLE `s_event_recom_3` DISABLE KEYS */;
INSERT INTO `s_event_recom_3` VALUES (15,71,1,0,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(16,72,2,0,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(17,73,3,0,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(18,74,4,0,'2018-07-05 00:25:15','2018-07-05 00:25:15'),(19,75,5,0,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(20,76,6,0,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(21,83,0,0,'2018-07-08 08:03:32','2018-07-08 08:03:32');
/*!40000 ALTER TABLE `s_event_recom_3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_sub_content_1`
--

DROP TABLE IF EXISTS `s_event_sub_content_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_sub_content_1` (
  `s_event_sub_content_1_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件子内容1相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_sub_content_1_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件子内容1相关url',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_sub_content_1_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COMMENT='事件子内容1表，乐谣创建事件时记录，存放事件的子内容(音频链接)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_sub_content_1`
--

LOCK TABLES `s_event_sub_content_1` WRITE;
/*!40000 ALTER TABLE `s_event_sub_content_1` DISABLE KEYS */;
INSERT INTO `s_event_sub_content_1` VALUES (46,56,'static/audio/1.mp3','1999-12-31 16:00:00','2018-07-05 00:27:26'),(47,56,'static/audio/2.mp3','1999-12-31 16:00:00','2018-07-05 00:27:26'),(48,56,'static/audio/3.mp3','1999-12-31 16:00:00','2018-07-05 00:27:26'),(49,57,'static/audio/1.mp3','1999-12-31 16:00:00','2018-07-05 00:37:26'),(50,57,'static/audio/2.mp3','1999-12-31 16:00:00','2018-07-05 00:37:26'),(51,57,'static/audio/3.mp3','1999-12-31 16:00:00','2018-07-05 00:37:26');
/*!40000 ALTER TABLE `s_event_sub_content_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_sub_content_2`
--

DROP TABLE IF EXISTS `s_event_sub_content_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_sub_content_2` (
  `s_event_sub_content_2_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件子内容2相关记录序列代理键',
  `h_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `s_event_sub_content_2_str` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件子内容2相关内容描述',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_event_sub_content_2_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COMMENT='事件子内容2表，乐谣创建事件时记录，存放事件的子内容描述';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_sub_content_2`
--

LOCK TABLES `s_event_sub_content_2` WRITE;
/*!40000 ALTER TABLE `s_event_sub_content_2` DISABLE KEYS */;
INSERT INTO `s_event_sub_content_2` VALUES (46,56,'{\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\",\"song\":\"tyler\'s song\",\"description\":\"1.mp3\"}','1999-12-31 16:00:00','2018-07-05 00:27:26'),(47,56,'{\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\",\"song\":\"tyler\'s song\",\"description\":\"2.mp3\"}','1999-12-31 16:00:00','2018-07-05 00:27:26'),(48,56,'{\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\",\"song\":\"tyler\'s song\",\"description\":\"3.mp3\"}','1999-12-31 16:00:00','2018-07-05 00:27:26'),(49,57,'{\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\",\"song\":\"tyler\'s song\",\"description\":\"1.mp3\"}','1999-12-31 16:00:00','2018-07-05 00:37:26'),(50,57,'{\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\",\"song\":\"tyler\'s song\",\"description\":\"2.mp3\"}','1999-12-31 16:00:00','2018-07-05 00:37:26'),(51,57,'{\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\",\"song\":\"tyler\'s song\",\"description\":\"3.mp3\"}','1999-12-31 16:00:00','2018-07-05 00:37:26');
/*!40000 ALTER TABLE `s_event_sub_content_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event_type`
--

DROP TABLE IF EXISTS `s_event_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event_type` (
  `S_EVENT_TYPE_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件类型相关记录序列代理键',
  `H_EVENT_ID` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '事件录入后生成的代理键',
  `S_EVENT_TYPE_CD` int(20) NOT NULL DEFAULT '0' COMMENT '事件类型编码',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`S_EVENT_TYPE_ID`),
  KEY `idx_S_EVENT_TYPE_ID` (`H_EVENT_ID`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COMMENT='事件类型表，乐谣创建事件时记录，存放事件类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_type`
--

LOCK TABLES `s_event_type` WRITE;
/*!40000 ALTER TABLE `s_event_type` DISABLE KEYS */;
INSERT INTO `s_event_type` VALUES (25,50,0,'2018-07-04 22:53:30','2018-07-04 22:53:30'),(26,51,0,'2018-07-04 22:55:24','2018-07-04 22:55:24'),(27,52,0,'2018-07-04 22:55:51','2018-07-04 22:55:51'),(28,53,0,'2018-07-04 22:57:01','2018-07-04 22:57:01'),(29,54,0,'2018-07-04 22:57:18','2018-07-11 15:17:00'),(30,55,0,'2018-07-04 22:57:33','2018-07-04 22:57:33'),(31,56,0,'2018-07-04 23:19:38','2018-07-05 00:27:26'),(32,57,0,'2018-07-04 23:21:16','2018-07-05 00:37:26'),(33,58,1,'2018-07-04 23:26:24','2018-07-04 23:26:24'),(34,59,1,'2018-07-04 23:27:51','2018-07-04 23:27:51'),(35,60,1,'2018-07-04 23:34:21','2018-07-04 23:34:21'),(36,61,1,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(37,62,1,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(38,63,1,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(39,64,1,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(40,65,2,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(41,66,2,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(42,67,2,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(43,68,2,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(44,69,2,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(45,70,2,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(46,71,3,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(47,72,3,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(48,73,3,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(49,74,3,'2018-07-05 00:25:15','2018-07-05 00:25:15'),(50,75,3,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(51,76,3,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(52,77,0,'2018-07-05 00:38:31','2018-07-05 00:38:31'),(53,78,0,'2018-07-05 00:39:04','2018-07-05 00:39:04'),(54,79,0,'2018-07-05 00:39:41','2018-07-05 00:39:41'),(55,80,0,'2018-07-05 00:45:49','2018-07-05 00:45:49'),(56,81,1,'2018-07-08 08:02:28','2018-07-08 08:02:28'),(57,82,2,'2018-07-08 08:02:56','2018-07-08 08:02:56'),(58,83,3,'2018-07-08 08:03:32','2018-07-08 08:03:32'),(59,84,0,'2018-07-11 16:51:49','2018-07-11 16:51:49');
/*!40000 ALTER TABLE `s_event_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_event_page`
--

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
  `s_event_sub_content_2_str` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件子内容2相关内容描述',
  `s_event_search_content_txt` text NOT NULL COMMENT '事件搜索内容，存放搜索相关关键字集合',
  `s_event_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乐谣创建以及更新事件时更新，提供搜索引擎信息入口，将所有事件相关关键词全部存放于字段内s_event_search_content_txt';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_event_page`
--

LOCK TABLES `t_event_page` WRITE;
/*!40000 ALTER TABLE `t_event_page` DISABLE KEYS */;
INSERT INTO `t_event_page` VALUES (50,0,'未定义',0,'undefined','static/image/banner_1.jpg','http://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-04 22:53:30','2018-07-04 22:53:30'),(51,0,'未定义',0,'undefined','static/image/banner_2.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-04 22:55:24','2018-07-04 22:56:54'),(52,0,'未定义',0,'undefined','static/image/banner_3.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-04 22:55:51','2018-07-04 22:55:51'),(53,0,'未定义',0,'undefined','static/image/banner_4.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-04 22:57:01','2018-07-04 22:57:01'),(54,0,'未定义',0,'undefined','static/image/banner_5.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','search',0,'2018-07-04 22:57:18','2018-07-15 00:14:54'),(55,0,'未定义',0,'undefined','static/image/banner_6.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-04 22:57:33','2018-07-04 22:57:33'),(56,4,'音乐专辑',0,'undefined','static/image/zhuanji_2.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','com.app_service.entity.hs_event.SEventSubContent1@4103a627','com.app_service.entity.hs_event.SEventSubContent2@74431a8d','?',0,'2018-07-04 23:19:38','2018-07-05 00:27:26'),(57,4,'音乐专辑',0,'undefined','static/image/zhuanji_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','com.app_service.entity.hs_event.SEventSubContent1@39d77cc8','com.app_service.entity.hs_event.SEventSubContent2@ba240eb','?',0,'2018-07-04 23:21:16','2018-07-05 00:37:26'),(58,0,'未定义',1,'audio','static/image/music_1.jpg','static/audio/1.mp3','?','?','?',0,'2018-07-04 23:26:24','2018-07-04 23:26:24'),(59,0,'未定义',1,'audio','static/image/music_2.jpg','static/audio/2.mp3','?','?','?',0,'2018-07-04 23:27:51','2018-07-15 00:14:54'),(61,0,'未定义',1,'audio','static/image/music_3.jpg','static/audio/3.mp3','?','?','?',0,'2018-07-04 23:45:37','2018-07-04 23:45:37'),(62,0,'未定义',1,'audio','static/image/music_4.jpg','static/audio/4.mp3','?','?','?',0,'2018-07-05 00:18:13','2018-07-05 00:18:13'),(63,0,'未定义',1,'audio','static/image/music_5.jpg','static/audio/5.mp3','?','?','?',0,'2018-07-05 00:18:49','2018-07-05 00:18:49'),(64,0,'未定义',1,'audio','static/image/music_6.jpg','static/audio/6.mp3','?','?','?',0,'2018-07-05 00:19:08','2018-07-05 00:19:08'),(65,0,'未定义',2,'video','static/image/video_1.jpg','static/video/2.mp4','?','?','?',0,'2018-07-05 00:21:13','2018-07-05 00:21:13'),(66,0,'未定义',2,'video','static/image/video_2.jpg','static/video/2.mp4','?','?','?',0,'2018-07-05 00:21:45','2018-07-05 00:21:45'),(67,0,'未定义',2,'video','static/image/video_3.jpg','static/video/2.mp4','?','?','?',0,'2018-07-05 00:22:04','2018-07-05 00:22:04'),(68,0,'未定义',2,'video','static/image/video_4.jpg','static/video/2.mp4','?','?','?',0,'2018-07-05 00:22:23','2018-07-05 00:22:23'),(69,0,'未定义',2,'video','static/image/video_5.jpg','static/video/2.mp4','?','?','?',0,'2018-07-05 00:22:39','2018-07-05 00:22:39'),(70,0,'未定义',2,'video','static/image/video_6.jpg','static/video/2.mp4','?','?','?',0,'2018-07-05 00:22:56','2018-07-05 00:22:56'),(71,0,'未定义',3,'image','static/image/read_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:24:15','2018-07-05 00:24:15'),(72,0,'未定义',3,'image','static/image/read_2.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:24:40','2018-07-05 00:24:40'),(73,0,'未定义',3,'image','static/image/read_3.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:24:58','2018-07-05 00:24:58'),(74,0,'未定义',3,'image','static/image/read_4.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','ii',0,'2018-07-05 00:25:15','2018-07-11 17:39:43'),(75,0,'未定义',3,'image','static/image/read_5.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:25:32','2018-07-05 00:25:32'),(76,0,'未定义',3,'image','static/image/read_6.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:25:51','2018-07-05 00:25:51'),(77,1,'盒声活动',0,'undefined','static/image/heshenghuodong_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:38:31','2018-07-05 00:38:31'),(78,2,'音乐教学',0,'undefined','static/image/yinyuejiaoxue_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:39:04','2018-07-05 00:39:04'),(79,3,'艺人分享',0,'undefined','static/image/yirenfenxiang_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-05 00:39:41','2018-07-05 00:39:41'),(80,0,'未定义',0,'undefined','static/image/yinyuejiaoxue_1.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',1,'2018-07-05 00:45:49','2018-07-14 23:59:25'),(81,0,'未定义',1,'audio','static/image/music_0.jpg','static/audio/6.mp3','?','?','?',0,'2018-07-08 08:02:28','2018-07-08 08:02:28'),(82,0,'未定义',2,'video','static/image/video_0.jpg','static/video/2.mp4','?','?','?',0,'2018-07-08 08:02:56','2018-07-08 08:02:56'),(83,0,'未定义',3,'image','static/image/read_0.jpg','https://mp.weixin.qq.com/s/VABeuW3CNwcU_kGWEbufRA','?','?','?',0,'2018-07-08 08:03:32','2018-07-08 08:03:32'),(84,0,'未定义',0,'undefined','static/image/1.jpg','http://mp.weixin.qq.com/s/pczRcFhP97l-u8u_SpNgpw','?','?','?',0,'2018-07-11 16:51:49','2018-07-11 16:51:49');
/*!40000 ALTER TABLE `t_event_page` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15  8:25:20
