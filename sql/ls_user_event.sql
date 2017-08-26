-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: ls_user_event
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05  3:08:42
