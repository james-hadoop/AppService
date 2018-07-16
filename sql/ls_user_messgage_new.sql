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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='用户与消息关系表，乐谣创建消息发送对象时记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_user_message`
--

LOCK TABLES `l_user_message` WRITE;
/*!40000 ALTER TABLE `l_user_message` DISABLE KEYS */;
INSERT INTO `l_user_message` VALUES (1,1,1,'2017-09-15 14:55:00','2017-09-15 14:55:00'),(2,1,2,'2017-10-21 11:25:42','2017-10-21 11:25:42'),(3,1,3,'2017-10-21 12:33:43','2017-10-21 12:33:43'),(4,4,4,'2018-05-08 20:42:15','2018-05-08 20:42:15'),(5,4,5,'2018-05-12 09:11:29','2018-05-12 09:11:29'),(6,4,6,'2018-05-13 11:51:08','2018-05-13 11:51:08'),(7,4,7,'2018-05-13 11:57:23','2018-05-13 11:57:23'),(8,4,8,'2018-05-13 12:13:53','2018-05-13 12:13:53'),(9,4,9,'2018-05-13 12:34:58','2018-05-13 12:34:58'),(12,4,11,'2018-05-13 13:03:52','2018-05-13 13:03:52'),(14,4,12,'2018-06-25 06:23:21','2018-06-25 06:23:21'),(16,3,11,'2018-06-25 06:24:55','2018-06-25 06:24:55'),(17,3,5,'2018-06-25 06:28:57','2018-06-25 06:28:57'),(20,3,12,'2018-06-25 06:47:20','2018-06-25 06:47:20'),(21,4,13,'2018-07-13 13:25:57','2018-07-13 13:25:57'),(23,4,10,'2018-07-13 13:30:35','2018-07-13 13:30:35');
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='用户与消息关系激活状态记录表，乐谣创建消息发送对象时记录，写入默认值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_message_active`
--

LOCK TABLES `s_user_message_active` WRITE;
/*!40000 ALTER TABLE `s_user_message_active` DISABLE KEYS */;
INSERT INTO `s_user_message_active` VALUES (1,1,0,'2017-09-15 14:55:00','2018-07-15 00:04:56'),(2,2,0,'2017-10-21 11:21:26','2018-07-15 00:04:56'),(3,3,0,'2017-10-21 11:25:42','2018-07-15 00:04:56'),(4,4,0,'2018-05-08 20:42:15','2018-07-15 00:04:56'),(5,5,0,'2018-05-12 09:11:29','2018-07-15 00:04:56'),(6,6,0,'2018-05-13 11:51:08','2018-07-15 00:04:56'),(7,7,0,'2018-05-13 11:57:23','2018-07-15 00:04:56'),(8,8,0,'2018-05-13 12:13:53','2018-07-15 00:04:56'),(9,9,0,'2018-05-13 12:34:58','2018-07-15 00:04:57'),(12,12,0,'2018-05-13 13:03:52','2018-07-15 00:04:57'),(14,14,0,'2018-06-25 06:23:21','2018-07-15 00:04:57'),(16,16,0,'2018-06-25 06:24:55','2018-07-15 00:04:57'),(17,17,0,'2018-06-25 06:28:57','2018-07-15 00:04:57'),(20,20,0,'2018-06-25 06:47:20','2018-07-15 00:04:57'),(21,21,0,'2018-07-13 13:25:57','2018-07-15 00:04:57'),(23,23,0,'2018-07-13 13:30:35','2018-07-15 00:05:02');
/*!40000 ALTER TABLE `s_user_message_active` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15  8:25:29
