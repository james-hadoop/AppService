-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: hs_event
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `hs_event`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乐谣事件记录表，乐谣创建事件时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_event`
--

LOCK TABLES `hs_event` WRITE;
/*!40000 ALTER TABLE `hs_event` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件记录表，乐谣创建事件时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_active`
--

LOCK TABLES `s_event_active` WRITE;
/*!40000 ALTER TABLE `s_event_active` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件banner页信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在banner上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_banner`
--

LOCK TABLES `s_event_banner` WRITE;
/*!40000 ALTER TABLE `s_event_banner` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件种类表，乐谣创建事件时记录，存放事件种类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_category`
--

LOCK TABLES `s_event_category` WRITE;
/*!40000 ALTER TABLE `s_event_category` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件内容表，乐谣创建事件时记录，存放事件web view的标题和内容url地址';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_content`
--

LOCK TABLES `s_event_content` WRITE;
/*!40000 ALTER TABLE `s_event_content` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件推荐1号位信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在推荐菜单1上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_recom_1`
--

LOCK TABLES `s_event_recom_1` WRITE;
/*!40000 ALTER TABLE `s_event_recom_1` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件推荐2号位信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在推荐菜单2上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_recom_2`
--

LOCK TABLES `s_event_recom_2` WRITE;
/*!40000 ALTER TABLE `s_event_recom_2` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件推荐3号位信息表，乐谣创建事件时记录，后台管理可更新，存放事件web view在推荐菜单3上的位置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_recom_3`
--

LOCK TABLES `s_event_recom_3` WRITE;
/*!40000 ALTER TABLE `s_event_recom_3` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件子内容1表，乐谣创建事件时记录，存放事件的子内容(音频链接)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_sub_content_1`
--

LOCK TABLES `s_event_sub_content_1` WRITE;
/*!40000 ALTER TABLE `s_event_sub_content_1` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件子内容2表，乐谣创建事件时记录，存放事件的子内容描述';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_sub_content_2`
--

LOCK TABLES `s_event_sub_content_2` WRITE;
/*!40000 ALTER TABLE `s_event_sub_content_2` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件类型表，乐谣创建事件时记录，存放事件类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event_type`
--

LOCK TABLES `s_event_type` WRITE;
/*!40000 ALTER TABLE `s_event_type` DISABLE KEYS */;
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
INSERT INTO `t_event_page` VALUES (1,1,'d1',3,'image','image/1.jpg','image/1.jpg','?','1',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(2,1,'d1',3,'image','image/2.jpg','image/2.jpg','?','2',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(3,1,'d1',3,'image','image/3.jpg','image/3.jpg','?','3',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(4,1,'d1',3,'image','image/4.jpg','image/4.jpg','?','4',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(5,1,'d1',3,'image','image/5.jpg','image/5.jpg','?','5',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(6,1,'d1',3,'image','image/6.jpg','image/6.jpg','?','6',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(7,1,'d1',1,'vedio','vedio/1.mp4','vedio/1.mp4','?','7',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(8,1,'d1',1,'vedio','vedio/2.mp4','vedio/2.mp4','?','8',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(9,1,'d1',1,'vedio','vedio/3.mp4','vedio/3.mp4','?','9',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(10,1,'d1',1,'vedio','vedio/4.mp4','vedio/1.mp4','?','10',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(11,1,'d1',1,'vedio','vedio/5.mp4','vedio/2.mp4','?','11',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(12,1,'d1',1,'vedio','vedio/6.mp4','vedio/3.mp4','?','12',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(13,1,'d1',2,'audio','audio/1.mp3','audio/1.mp3','?','13',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(14,1,'d1',2,'audio','audio/2.mp3','audio/2.mp3','?','14',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(15,1,'d1',2,'audio','audio/3.mp3','audio/3.mp3','?','15',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(16,1,'d1',2,'audio','audio/4.mp3','audio/1.mp3','?','16',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(17,1,'d1',2,'audio','audio/5.mp3','audio/2.mp3','?','17',0,'1999-12-31 16:00:00','1999-12-31 16:00:00'),(18,1,'d1',2,'audio','audio/6.mp3','audio/3.mp3','?','18',0,'1999-12-31 16:00:00','1999-12-31 16:00:00');
/*!40000 ALTER TABLE `t_event_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hs_event'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-31  2:01:01
