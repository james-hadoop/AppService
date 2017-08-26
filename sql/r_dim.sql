-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: r_dim
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05  3:09:34
