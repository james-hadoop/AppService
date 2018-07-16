-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: 47.94.94.196    Database: hs_message
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='乐谣消息推送表，乐谣创建消息时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_message`
--

LOCK TABLES `hs_message` WRITE;
/*!40000 ALTER TABLE `hs_message` DISABLE KEYS */;
INSERT INTO `hs_message` VALUES (1,'2017-09-15 14:55:00','2017-09-15 14:55:00'),(2,'2017-10-14 14:57:46','2017-12-17 14:17:14'),(3,'2017-10-14 15:19:27','2017-10-21 22:24:24'),(4,'2018-04-29 15:16:01','2018-04-29 15:16:01'),(5,'2018-05-12 09:10:55','2018-05-12 09:10:55'),(6,'2018-05-13 11:50:25','2018-05-13 11:50:25'),(7,'2018-05-13 11:56:37','2018-05-13 11:56:37'),(8,'2018-05-13 12:09:57','2018-05-13 12:09:57'),(9,'2018-05-13 12:33:48','2018-05-13 12:33:48'),(10,'2018-05-13 12:37:37','2018-05-13 12:37:37'),(11,'2018-05-13 12:39:20','2018-05-13 12:39:20'),(12,'2018-06-04 03:47:30','2018-06-25 06:22:42'),(13,'2018-07-13 13:25:21','2018-07-13 13:25:21');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='消息激活状态记录表，乐谣创建消息时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_message_active`
--

LOCK TABLES `s_message_active` WRITE;
/*!40000 ALTER TABLE `s_message_active` DISABLE KEYS */;
INSERT INTO `s_message_active` VALUES (1,1,0,'2017-09-15 14:55:00','2017-09-15 14:55:00'),(2,2,0,'2017-10-14 14:57:46','2017-12-17 14:17:14'),(3,3,0,'2017-10-14 15:19:27','2018-07-15 00:08:54'),(4,4,0,'2018-04-29 15:16:01','2018-04-29 15:16:01'),(5,5,0,'2018-05-12 09:10:55','2018-05-12 09:10:55'),(6,6,0,'2018-05-13 11:50:25','2018-05-13 11:50:25'),(7,7,0,'2018-05-13 11:56:37','2018-05-13 11:56:37'),(8,8,0,'2018-05-13 12:09:57','2018-05-13 12:09:57'),(9,9,0,'2018-05-13 12:33:48','2018-05-13 12:33:48'),(10,10,0,'2018-05-13 12:37:37','2018-05-13 12:37:37'),(11,11,0,'2018-05-13 12:39:20','2018-05-13 12:39:20'),(12,12,0,'2018-06-04 03:47:30','2018-06-25 06:22:42'),(13,13,0,'2018-07-13 13:25:21','2018-07-13 13:25:21');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='乐谣创建消息时记录，存放消息种类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_message_category`
--

LOCK TABLES `s_message_category` WRITE;
/*!40000 ALTER TABLE `s_message_category` DISABLE KEYS */;
INSERT INTO `s_message_category` VALUES (1,1,1,'2017-09-15 14:55:00','2017-09-15 14:55:00'),(2,2,1,'2017-10-14 14:57:46','2017-12-17 14:17:14'),(3,3,1,'2017-10-14 15:19:27','2017-10-21 22:24:24'),(4,4,1,'2018-04-29 15:16:01','2018-04-29 15:16:01'),(5,5,1,'2018-05-12 09:10:55','2018-05-12 09:10:55'),(6,6,1,'2018-05-13 11:50:25','2018-05-13 11:50:25'),(7,7,1,'2018-05-13 11:56:37','2018-05-13 11:56:37'),(8,8,1,'2018-05-13 12:09:57','2018-05-13 12:09:57'),(9,9,1,'2018-05-13 12:33:48','2018-05-13 12:33:48'),(10,10,1,'2018-05-13 12:37:37','2018-05-13 12:37:37'),(11,11,1,'2018-05-13 12:39:20','2018-05-13 12:39:20'),(12,12,1,'2018-06-04 03:47:30','2018-06-25 06:22:42'),(13,13,1,'2018-07-13 13:25:21','2018-07-13 13:25:21');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='消息内容记录表，乐谣创建消息时记录，存放消息内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_message_content`
--

LOCK TABLES `s_message_content` WRITE;
/*!40000 ALTER TABLE `s_message_content` DISABLE KEYS */;
INSERT INTO `s_message_content` VALUES (1,1,'first message 大附件的开发建设了深刻理解对方脸上的发上来看待加夫里什大家发上来大家来访','2017-09-15 14:55:00','2017-12-17 11:22:31'),(2,2,'message2这条消息也要加到特别长，来展示效果。哈哈哈哈哈哈哈','2017-10-14 14:57:46','2017-12-17 14:17:14'),(3,3,'message3 longlonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglong','2017-10-14 15:19:27','2017-12-17 11:22:47'),(4,4,'这是一条新消息，用来测试问题4','2018-04-29 15:16:01','2018-04-29 15:16:01'),(5,5,'今天是2018-05-12，测试轮训消息1','2018-05-12 09:10:55','2018-05-12 09:10:55'),(6,6,'2018-05-13 面对面消息1','2018-05-13 11:50:25','2018-05-13 11:50:25'),(7,7,'2018-05-13 面对面消息2','2018-05-13 11:56:37','2018-05-13 11:56:37'),(8,8,'2018-05-13 面对面消息3','2018-05-13 12:09:57','2018-05-13 12:09:57'),(9,9,'2018-05-13 面对面消息4','2018-05-13 12:33:48','2018-05-13 12:33:48'),(10,10,'2018-05-13 面对面消息5','2018-05-13 12:37:37','2018-05-13 12:37:37'),(11,11,'2018-05-13 面对面消息6','2018-05-13 12:39:20','2018-05-13 12:39:20'),(12,12,'我是一条消息，哈哈','2018-06-04 03:47:30','2018-06-25 06:22:42'),(13,13,'2018-07-13','2018-07-13 13:25:21','2018-07-13 13:25:21');
/*!40000 ALTER TABLE `s_message_content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15  8:25:27
