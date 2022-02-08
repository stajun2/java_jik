-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `co_num` int NOT NULL AUTO_INCREMENT,
  `co_bd_num` int NOT NULL,
  `co_me_id` varchar(20) NOT NULL,
  `co_reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `co_del` varchar(2) NOT NULL DEFAULT 'N',
  `co_ori_num` int NOT NULL,
  `co_contents` longtext NOT NULL,
  PRIMARY KEY (`co_num`),
  KEY `co_bd_num_idx` (`co_bd_num`),
  KEY `co_me_id_idx` (`co_me_id`),
  CONSTRAINT `co_bd_num` FOREIGN KEY (`co_bd_num`) REFERENCES `board` (`bd_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_me_id` FOREIGN KEY (`co_me_id`) REFERENCES `member` (`me_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,47,'qwe','2022-01-24 11:04:51','Y',1,'dd'),(2,47,'qwe','2022-01-24 11:08:20','Y',2,'댓글 등록'),(3,47,'qwe','2022-01-24 12:37:28','N',3,'2월 3일 수정 123456'),(4,47,'qwe','2022-01-24 12:41:58','N',4,'새로운댓글 수정'),(5,47,'qwe','2022-01-24 12:42:33','Y',5,'새로운 댓글 2 수정입니다.'),(6,47,'qwe','2022-01-24 12:42:43','Y',6,'ㅇㅇ'),(7,47,'qwe','2022-01-24 12:42:47','Y',7,'ㄹㄹ'),(8,47,'qwe','2022-01-24 12:42:51','Y',8,'ㅁㅁ'),(9,47,'qwe','2022-01-24 12:56:58','Y',9,'수정수정'),(10,42,'qwe','2022-01-24 14:13:19','N',10,'dd'),(11,39,'qwe','2022-01-24 14:26:10','N',11,'1'),(12,39,'qwe','2022-01-24 14:26:13','N',12,'2'),(13,39,'qwe','2022-01-24 14:26:16','N',13,'3'),(14,39,'qwe','2022-01-24 14:26:19','N',14,'4'),(15,39,'qwe','2022-01-24 14:26:22','N',15,'5'),(16,39,'qwe','2022-01-24 14:26:25','N',16,'6'),(17,47,'qwe','2022-01-24 15:48:49','Y',17,'qwe 수정'),(18,31,'qwe','2022-01-24 15:52:31','N',18,'1'),(19,31,'qwe','2022-01-24 15:52:34','N',19,'2'),(20,31,'qwe','2022-01-24 15:52:36','N',20,'3'),(21,31,'qwe','2022-01-24 15:52:40','N',21,'4'),(22,31,'qwe','2022-01-24 15:52:43','N',22,'5'),(23,31,'qwe','2022-01-24 15:52:46','N',23,'6'),(24,47,'asd','2022-01-25 15:15:29','N',3,'qwe 댓글에 대댓'),(25,40,'asd','2022-01-25 16:21:09','Y',25,'댓글 수정'),(26,40,'asd','2022-01-25 16:36:06','Y',25,'답글 테스트'),(27,40,'asd','2022-01-25 16:36:06','Y',25,'답글 테스트'),(28,47,'asd','2022-01-26 15:08:48','N',28,'47번 게시글 댓글'),(29,47,'qwe','2022-01-26 15:13:51','Y',29,'댓글'),(30,47,'qwe','2022-01-26 15:36:47','Y',30,'3시 36분 댓글'),(31,40,'qwe','2022-01-27 10:23:47','N',31,'댓글'),(32,42,'qwe','2022-01-27 12:49:48','N',32,'댓글'),(33,32,'qwe','2022-01-27 14:15:00','N',33,'ddd'),(34,47,'qwe','2022-02-03 09:35:24','Y',34,'dd'),(35,47,'qwe','2022-02-03 11:43:18','N',35,'1'),(36,47,'qwe','2022-02-03 11:43:21','N',36,'2'),(37,47,'qwe','2022-02-03 11:43:24','Y',37,'3222'),(38,47,'qwe','2022-02-03 14:37:52','N',36,'2 대댓');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-08 11:49:25
