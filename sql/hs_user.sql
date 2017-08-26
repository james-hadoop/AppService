-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: hs_user
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
-- Table structure for table `h_user`
--

DROP TABLE IF EXISTS `h_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `h_user` (
  `h_user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户注册后生成的代理键，自增长',
  `h_user_phone_nr` int(20) NOT NULL DEFAULT '0' COMMENT '用户注册时使用的手机号',
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
  `h_user_phone_nr` int(20) NOT NULL DEFAULT '0' COMMENT '用户注册时使用的手机号',
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05  3:07:31
