-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: hs_message
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05  3:07:15
