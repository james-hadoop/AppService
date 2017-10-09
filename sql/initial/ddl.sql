-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: hs_event
-- ------------------------------------------------------
-- Server version   5.7.18-log

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

-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: hs_message
-- ------------------------------------------------------
-- Server version   5.7.18-log

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
-- Current Database: `hs_message`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hs_message` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `hs_message`;

--
-- Table structure for table `hs_message`
--

DROP TABLE IF EXISTS `hs_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hs_message` (
  `h_message_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '乐谣创建系统推送消息后生成的代理键，自增长',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_message_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乐谣消息推送表，乐谣创建消息时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_message`
--

LOCK TABLES `hs_message` WRITE;
/*!40000 ALTER TABLE `hs_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `hs_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_message_active`
--

DROP TABLE IF EXISTS `s_message_active`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_message_active` (
  `s_message_active_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息激活相关记录序列代理键',
  `h_message_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_message_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '消息激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_message_active_id`),
  KEY `idx_h_message_id` (`h_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息激活状态记录表，乐谣创建消息时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_message_active`
--

LOCK TABLES `s_message_active` WRITE;
/*!40000 ALTER TABLE `s_message_active` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_message_active` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_message_category`
--

DROP TABLE IF EXISTS `s_message_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_message_category` (
  `s_message_content_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息内容相关记录序列代理键',
  `h_message_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_message_category_cd` int(20) NOT NULL DEFAULT '0' COMMENT '消息种类编码',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_message_content_id`),
  KEY `idx_h_message_id` (`h_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乐谣创建消息时记录，存放消息种类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_message_category`
--

LOCK TABLES `s_message_category` WRITE;
/*!40000 ALTER TABLE `s_message_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_message_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_message_content`
--

DROP TABLE IF EXISTS `s_message_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_message_content` (
  `s_message_content_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息内容相关记录序列代理键',
  `h_message_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_message_content_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '消息的具体文本内容',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_message_content_id`),
  KEY `idx_h_message_id` (`h_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息内容记录表，乐谣创建消息时记录，存放消息内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_message_content`
--

LOCK TABLES `s_message_content` WRITE;
/*!40000 ALTER TABLE `s_message_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_message_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hs_message'
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


-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: hs_user
-- ------------------------------------------------------
-- Server version   5.7.18-log

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
-- Current Database: `hs_user`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hs_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `hs_user`;

--
-- Table structure for table `h_user`
--

DROP TABLE IF EXISTS `h_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `h_user` (
  `h_user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户注册后生成的代理键，自增长',
  `h_user_phone_nr` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户注册时使用的手机号',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_user_id`),
  KEY `idx_user_phone_nr` (`h_user_phone_nr`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户注册记录表，用户注册返回验证码，验证成功后生成用户id';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h_user`
--

LOCK TABLES `h_user` WRITE;
/*!40000 ALTER TABLE `h_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `h_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_active`
--

DROP TABLE IF EXISTS `s_user_active`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_active` (
  `s_user_active_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户激活相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户注册后生成的代理键',
  `s_user_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '用户激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_active_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户激活状态记录表，用户注册返回验证码，验证成功后记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_active`
--

LOCK TABLES `s_user_active` WRITE;
/*!40000 ALTER TABLE `s_user_active` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_active` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_email`
--

DROP TABLE IF EXISTS `s_user_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_email` (
  `s_user_email_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户邮箱地址相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_user_email_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户邮箱地址',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_email_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户头像地址记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_email`
--

LOCK TABLES `s_user_email` WRITE;
/*!40000 ALTER TABLE `s_user_email` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_feedback`
--

DROP TABLE IF EXISTS `s_user_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_feedback` (
  `s_user_feedback_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息内容相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_user_feedback_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户反馈信息',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_feedback_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户反馈信息记录表，个人页面中，我的意见模块记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_feedback`
--

LOCK TABLES `s_user_feedback` WRITE;
/*!40000 ALTER TABLE `s_user_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_gender`
--

DROP TABLE IF EXISTS `s_user_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_gender` (
  `s_user_gender_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户性别相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户注册后生成的代理键',
  `s_user_gender_cd` int(20) NOT NULL DEFAULT '0' COMMENT '用户性别编码',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_gender_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户性别记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_gender`
--

LOCK TABLES `s_user_gender` WRITE;
/*!40000 ALTER TABLE `s_user_gender` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_name`
--

DROP TABLE IF EXISTS `s_user_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_name` (
  `s_user_name_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户姓名相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_user_name_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户姓名',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_name_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户姓名记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_name`
--

LOCK TABLES `s_user_name` WRITE;
/*!40000 ALTER TABLE `s_user_name` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_password`
--

DROP TABLE IF EXISTS `s_user_password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_password` (
  `s_user_password_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户密码相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_user_password_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户密码',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_password_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户密码记录表，1.用户注册返回验证码，验证成功后记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_password`
--

LOCK TABLES `s_user_password` WRITE;
/*!40000 ALTER TABLE `s_user_password` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_profile`
--

DROP TABLE IF EXISTS `s_user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_profile` (
  `s_user_profile_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户头像地址相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_user_profile_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '用户头像地址',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_profile_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户头像地址记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_profile`
--

LOCK TABLES `s_user_profile` WRITE;
/*!40000 ALTER TABLE `s_user_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_search`
--

DROP TABLE IF EXISTS `s_user_search`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_search` (
  `s_user_search_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户搜索相关记录序列代理键',
  `h_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '乐谣创建系统推送消息后生成的代理键',
  `s_user_feedback_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户搜索信息',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_search_id`),
  KEY `idx_h_user_id` (`h_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户搜索记录表，记录用户搜索框的内容，当用户点击搜索查询时，记录下查询的关键字';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_search`
--

LOCK TABLES `s_user_search` WRITE;
/*!40000 ALTER TABLE `s_user_search` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_search` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_page`
--

DROP TABLE IF EXISTS `t_user_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_page` (
  `h_user_id` bigint(20) unsigned NOT NULL COMMENT '用户注册后生成的代理键',
  `h_user_phone_nr` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户注册时使用的手机号',
  `s_user_gender_cd` int(20) NOT NULL DEFAULT '0' COMMENT '用户性别编码',
  `s_user_gender_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户性别定义',
  `s_user_name_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户姓名',
  `s_user_profile_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '用户头像地址',
  `s_user_email_str` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户邮箱地址',
  `s_user_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '用户激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_user_id`),
  KEY `idx_h_user_phone_nr` (`h_user_phone_nr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户页面查询信息访问表，同步update操作，用户访问个人页面时，信息查看接口获取数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_page`
--

LOCK TABLES `t_user_page` WRITE;
/*!40000 ALTER TABLE `t_user_page` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hs_user'
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


-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: ls_user_event
-- ------------------------------------------------------
-- Server version   5.7.18-log

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
-- Current Database: `ls_user_event`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ls_user_event` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ls_user_event`;

--
-- Table structure for table `l_user_event`
--

DROP TABLE IF EXISTS `l_user_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `l_user_event` (
  `l_user_event_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户接触到事件标题或者内容产生关系后生成的代理键，自增长',
  `h_user_id` bigint(20) unsigned NOT NULL COMMENT '用户注册后生成的代理键',
  `h_event_id` bigint(20) unsigned NOT NULL COMMENT '事件录入后生成的代理键',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`l_user_event_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_h_event_id` (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与事件关系表，加载页面时，创建用户对应读取到的事件标题链接时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_user_event`
--

LOCK TABLES `l_user_event` WRITE;
/*!40000 ALTER TABLE `l_user_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `l_user_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_event_active`
--

DROP TABLE IF EXISTS `s_user_event_active`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_event_active` (
  `s_user_event_active_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户与事件关系激活相关记录序列代理键',
  `l_user_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户接触到事件标题或者内容产生关系后生成的代理键',
  `s_user_event_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '用户与事件关系激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_event_active_id`),
  KEY `idx_l_user_event_id` (`l_user_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与事件关系激活状态记录表，加载页面时，创建用户对应读取到的事件标题链接时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_event_active`
--

LOCK TABLES `s_user_event_active` WRITE;
/*!40000 ALTER TABLE `s_user_event_active` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_event_active` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_event_like`
--

DROP TABLE IF EXISTS `s_user_event_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_event_like` (
  `s_user_event_like_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户与事件关系用户点赞事件相关记录序列代理键',
  `l_user_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户接触到事件标题或者内容产生关系后生成的代理键',
  `s_user_event_like_ind` int(20) NOT NULL DEFAULT '0' COMMENT '用户与事件关系用户点赞事件状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_event_like_id`),
  KEY `idx_l_l_user_event_id` (`l_user_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与事件关系用户点赞事件记录表，用户点赞后记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_event_like`
--

LOCK TABLES `s_user_event_like` WRITE;
/*!40000 ALTER TABLE `s_user_event_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_event_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_event_read`
--

DROP TABLE IF EXISTS `s_user_event_read`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_event_read` (
  `s_user_event_read_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户与事件关系阅读相关记录序列代理键',
  `l_user_event_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户接触到事件标题或者内容产生关系后生成的代理键',
  `s_user_event_read_log_txt` text NOT NULL COMMENT '用户与事件关系阅读日志内容',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_event_read_id`),
  KEY `idx_l_l_user_event_id` (`l_user_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与事件关系阅读记录表，用户进入事件页面后记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_event_read`
--

LOCK TABLES `s_user_event_read` WRITE;
/*!40000 ALTER TABLE `s_user_event_read` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_event_read` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ls_user_event'
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


-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: ls_user_message
-- ------------------------------------------------------
-- Server version   5.7.18-log

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
-- Current Database: `ls_user_message`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ls_user_message` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ls_user_message`;

--
-- Table structure for table `l_user_message`
--

DROP TABLE IF EXISTS `l_user_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `l_user_message` (
  `l_user_message_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户设定可接触到消息后生成的代理键，自增长',
  `h_user_id` bigint(20) unsigned NOT NULL COMMENT '用户注册后生成的代理键',
  `h_message_id` bigint(20) unsigned NOT NULL COMMENT '乐谣创建系统推送消息后生成的代理键',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`l_user_message_id`),
  KEY `idx_h_user_id` (`h_user_id`),
  KEY `idx_h_h_message_id` (`h_message_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与消息关系表，乐谣创建消息发送对象时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_user_message`
--

LOCK TABLES `l_user_message` WRITE;
/*!40000 ALTER TABLE `l_user_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `l_user_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_message_active`
--

DROP TABLE IF EXISTS `s_user_message_active`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_message_active` (
  `s_user_message_active_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户与消息关系激活相关记录序列代理键',
  `l_user_message_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户设定可接触到消息后生成的代理键',
  `s_user_message_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '用户与消息关系激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`s_user_message_active_id`),
  KEY `idx_l_user_message_id` (`l_user_message_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与消息关系激活状态记录表，乐谣创建消息发送对象时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_message_active`
--

LOCK TABLES `s_user_message_active` WRITE;
/*!40000 ALTER TABLE `s_user_message_active` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user_message_active` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ls_user_message'
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


-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: r_dim
-- ------------------------------------------------------
-- Server version   5.7.18-log

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
-- Current Database: `r_dim`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `r_dim` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `r_dim`;

--
-- Table structure for table `r_event_category`
--

DROP TABLE IF EXISTS `r_event_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_event_category` (
  `r_event_category_cd` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件种类编码',
  `r_event_category_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件种类定义',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`r_event_category_cd`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件种类关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_event_category`
--

LOCK TABLES `r_event_category` WRITE;
/*!40000 ALTER TABLE `r_event_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_event_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_event_position`
--

DROP TABLE IF EXISTS `r_event_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_event_position` (
  `r_event_position_cd` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件位置编码',
  `r_event_position_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件位置定义',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`r_event_position_cd`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件位置关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_event_position`
--

LOCK TABLES `r_event_position` WRITE;
/*!40000 ALTER TABLE `r_event_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_event_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_event_type`
--

DROP TABLE IF EXISTS `r_event_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_event_type` (
  `r_event_type_cd` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '事件类型编码',
  `r_event_type_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件类型定义',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`r_event_type_cd`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事件类型关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_event_type`
--

LOCK TABLES `r_event_type` WRITE;
/*!40000 ALTER TABLE `r_event_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_event_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_message_category`
--

DROP TABLE IF EXISTS `r_message_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_message_category` (
  `r_message_category_cd` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息种类编码',
  `r_message_category_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '消息种类定义',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`r_message_category_cd`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息种类关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_message_category`
--

LOCK TABLES `r_message_category` WRITE;
/*!40000 ALTER TABLE `r_message_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_message_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_user_gender`
--

DROP TABLE IF EXISTS `r_user_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_user_gender` (
  `r_user_gender_cd` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户性别编码',
  `r_user_gender_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '用户性别定义',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`r_user_gender_cd`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户性别关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_user_gender`
--

LOCK TABLES `r_user_gender` WRITE;
/*!40000 ALTER TABLE `r_user_gender` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_user_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'r_dim'
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
