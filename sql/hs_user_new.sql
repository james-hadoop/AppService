-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: 47.94.94.196    Database: hs_user
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
  `h_user_phone_nr` bigint(20) DEFAULT NULL,
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_user_id`),
  KEY `idx_user_phone_nr` (`h_user_phone_nr`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户注册记录表，用户注册返回验证码，验证成功后生成用户id';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h_user`
--

LOCK TABLES `h_user` WRITE;
/*!40000 ALTER TABLE `h_user` DISABLE KEYS */;
INSERT INTO `h_user` VALUES (1,13333333333,'1999-12-31 16:00:00','2018-05-09 07:22:04'),(2,13333333331,'2017-10-12 11:47:15','2018-05-09 06:21:14'),(3,13301615967,'2017-12-25 12:10:19','2018-06-25 07:31:13'),(4,13333333334,'2018-05-05 14:13:16','2018-07-13 13:11:21'),(5,13334445556,'2018-06-04 03:44:24','2018-06-04 03:45:14'),(6,17098075837,'2018-06-25 06:29:26','2018-06-25 06:29:26');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户激活状态记录表，用户注册返回验证码，验证成功后记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_active`
--

LOCK TABLES `s_user_active` WRITE;
/*!40000 ALTER TABLE `s_user_active` DISABLE KEYS */;
INSERT INTO `s_user_active` VALUES (1,1,0,'1999-12-31 16:00:00','2018-05-09 07:22:04'),(2,2,1,'2017-10-12 11:47:15','2018-06-04 03:46:02'),(3,3,0,'2017-12-25 12:10:19','2018-06-25 07:31:13'),(4,4,0,'2018-05-05 14:13:16','2018-07-13 13:11:21'),(5,5,0,'2018-06-04 03:44:24','2018-06-04 03:45:14'),(6,6,0,'2018-06-25 06:29:26','2018-06-25 06:29:26');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户头像地址记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_email`
--

LOCK TABLES `s_user_email` WRITE;
/*!40000 ALTER TABLE `s_user_email` DISABLE KEYS */;
INSERT INTO `s_user_email` VALUES (1,1,'','1999-12-31 16:00:00','2018-01-01 23:13:34'),(2,2,'13333333331@leyao.com','2017-10-12 11:47:15','2018-03-02 21:42:59'),(3,3,'philroc@soundcube.info','2017-12-25 12:10:19','2018-01-03 12:18:06'),(4,4,'huage@hotmail.com','2018-05-05 14:13:16','2018-05-05 14:13:16'),(5,5,'james@126.com','2018-06-04 03:44:24','2018-06-04 03:44:24'),(6,6,'','2018-06-25 06:29:26','2018-06-25 06:29:26');
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='用户反馈信息记录表，个人页面中，我的意见模块记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_feedback`
--

LOCK TABLES `s_user_feedback` WRITE;
/*!40000 ALTER TABLE `s_user_feedback` DISABLE KEYS */;
INSERT INTO `s_user_feedback` VALUES (1,1,'Leyao app is great!!!','1999-12-31 16:00:00','2017-10-10 13:33:40'),(2,1,'Hi Leyao!!!','1999-12-31 16:00:00','2017-10-10 15:01:04'),(3,1,'Hi Leyao2!!!','1999-12-31 16:00:00','1999-12-31 16:00:00'),(4,1,'123456','1999-12-31 16:00:00','1999-12-31 16:00:00'),(5,1,'12345','1999-12-31 16:00:00','1999-12-31 16:00:00'),(6,1,'','1999-12-31 16:00:00','1999-12-31 16:00:00'),(7,1,'','1999-12-31 16:00:00','1999-12-31 16:00:00'),(8,1,'We’re ','1999-12-31 16:00:00','1999-12-31 16:00:00'),(9,2,'12345','1999-12-31 16:00:00','1999-12-31 16:00:00'),(10,2,'1234','1999-12-31 16:00:00','1999-12-31 16:00:00'),(11,2,'1234','1999-12-31 16:00:00','1999-12-31 16:00:00'),(12,2,'123','1999-12-31 16:00:00','1999-12-31 16:00:00'),(13,2,'1233','1999-12-31 16:00:00','1999-12-31 16:00:00'),(14,2,'123','1999-12-31 16:00:00','1999-12-31 16:00:00'),(15,1,'测试','1999-12-31 16:00:00','1999-12-31 16:00:00'),(16,3,'牛逼的2018即将到来','1999-12-31 16:00:00','1999-12-31 16:00:00'),(17,3,'性别修改没效果，始终还是姑娘','2018-04-16 06:53:31','1999-12-31 16:00:00'),(18,3,'bug1: 性别还是改不了，始终是女性\nbug2: 消息提交后台看不到','2018-04-16 06:56:03','1999-12-31 16:00:00'),(19,1,'Test for suggestion.','2018-04-25 09:05:02','1999-12-31 16:00:00'),(20,4,'我的建议','2018-05-08 07:36:41','1999-12-31 16:00:00'),(21,4,'this is feedback','2018-05-08 20:37:46','1999-12-31 16:00:00'),(22,4,'Houston','2018-05-09 15:30:52','1999-12-31 16:00:00'),(23,4,'this is feedback','2018-05-09 22:23:37','1999-12-31 16:00:00'),(24,4,'Huage','2018-05-10 02:06:13','1999-12-31 16:00:00'),(25,4,'Huage','2018-05-10 02:06:39','1999-12-31 16:00:00'),(26,4,'汶川大地震','2018-05-12 09:19:48','1999-12-31 16:00:00'),(27,4,'Jesse1005','2018-05-13 12:41:38','1999-12-31 16:00:00'),(28,4,'意见反馈','2018-06-25 06:20:20','1999-12-31 16:00:00'),(29,3,'意见反馈','2018-06-25 06:44:05','1999-12-31 16:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户性别记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_gender`
--

LOCK TABLES `s_user_gender` WRITE;
/*!40000 ALTER TABLE `s_user_gender` DISABLE KEYS */;
INSERT INTO `s_user_gender` VALUES (1,1,1,'1999-12-31 16:00:00','2018-05-09 07:22:04'),(2,2,1,'2017-10-12 11:47:15','2018-03-02 21:42:59'),(3,3,0,'2017-12-25 12:10:19','2018-06-25 07:31:13'),(4,4,1,'2018-05-05 14:13:16','2018-07-13 13:11:21'),(5,5,1,'2018-06-04 03:44:24','2018-06-04 03:45:14'),(6,6,1,'2018-06-25 06:29:26','2018-06-25 06:29:26');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户姓名记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_name`
--

LOCK TABLES `s_user_name` WRITE;
/*!40000 ALTER TABLE `s_user_name` DISABLE KEYS */;
INSERT INTO `s_user_name` VALUES (1,1,'Tset','1999-12-31 16:00:00','2018-01-01 23:13:34'),(2,2,'Jack','2017-10-12 11:47:15','2018-03-02 21:42:59'),(3,3,'陈鹏','2017-12-25 12:10:19','2018-01-03 12:18:06'),(4,4,'HuaGe','2018-05-05 14:13:16','2018-05-05 14:13:16'),(5,5,'James','2018-06-04 03:44:24','2018-06-04 03:44:24'),(6,6,'李栓柱','2018-06-25 06:29:26','2018-06-25 06:29:26');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户密码记录表，1.用户注册返回验证码，验证成功后记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_password`
--

LOCK TABLES `s_user_password` WRITE;
/*!40000 ALTER TABLE `s_user_password` DISABLE KEYS */;
INSERT INTO `s_user_password` VALUES (1,1,'5a22e6c339c96c9c0513a46e44c39683','1999-12-31 16:00:00','2018-05-09 07:22:04'),(2,2,'696d29e0940a4957748fe3fc9efd22a3','2017-10-12 11:47:15','2018-05-09 06:21:14'),(3,3,'14e1b600b1fd579f47433b88e8d85291','2017-12-25 12:10:19','2018-06-25 06:28:07'),(4,4,'696d29e0940a4957748fe3fc9efd22a3','2018-05-05 14:13:16','2018-05-13 12:53:06'),(5,5,'696d29e0940a4957748fe3fc9efd22a3','2018-06-04 03:44:24','2018-06-04 03:45:14'),(6,6,'14e1b600b1fd579f47433b88e8d85291','2018-06-25 06:29:26','2018-06-25 06:29:26');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户头像地址记录表，1.用户注册成功后跳转至信息填写页面记录。2.用户个人页面修改信息记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_profile`
--

LOCK TABLES `s_user_profile` WRITE;
/*!40000 ALTER TABLE `s_user_profile` DISABLE KEYS */;
INSERT INTO `s_user_profile` VALUES (1,1,'portrait/13333333333.jpg','1999-12-31 16:00:00','2018-01-01 23:13:34'),(2,2,'portrait/13333333331.jpg','2017-10-12 11:47:15','2018-03-02 21:42:59'),(3,3,'','2017-12-25 12:10:19','2018-01-03 12:18:06'),(4,4,'','2018-05-05 14:13:16','2018-05-05 14:13:16'),(5,5,'','2018-06-04 03:44:24','2018-06-04 03:44:24'),(6,6,'','2018-06-25 06:29:26','2018-06-25 06:29:26');
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
  `h_user_phone_nr` bigint(20) DEFAULT NULL,
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
INSERT INTO `t_user_page` VALUES (1,13333333333,1,'男','HuaGe','portrait/13333333333.jpg','huage@hotmail.com',0,'1999-12-31 16:00:00','2018-05-09 07:22:04'),(2,13333333331,1,'男','Jack','portrait/13333333331.jpg','13333333331@leyao.com',1,'2017-10-12 11:47:15','2018-06-04 03:46:02'),(3,13301615967,0,'未知','Philroc','portrait/13301615967_2.jpg','philroc@soundcube.info',0,'2017-12-25 12:10:19','2018-06-25 07:31:13'),(4,13333333334,1,'男','HuaGe','portrait/13333333334_2.jpg','huage1005@hotmail.com',0,'2018-05-05 14:13:16','2018-07-13 13:11:21'),(5,13334445556,1,'男','James','','james@126.com',0,'2018-06-04 03:44:24','2018-06-04 03:45:14'),(6,17098075837,1,'男','李栓柱','','',0,'2018-06-25 06:29:26','2018-06-25 06:29:26');
/*!40000 ALTER TABLE `t_user_page` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15  8:25:25
