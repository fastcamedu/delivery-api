-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: delivery_partner
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `delivery_partner_settlement_histories`
--

DROP TABLE IF EXISTS `delivery_partner_settlement_histories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_partner_settlement_histories` (
  `delivery_partner_settlement_history_id` bigint NOT NULL COMMENT '배달파트너 정산 이력 ID',
  `delivery_partner_id` bigint NOT NULL COMMENT '배달파트너 ID',
  `order_id` varchar(45) NOT NULL COMMENT '주문 ID',
  `order_delivery_id` varchar(45) NOT NULL COMMENT '주문에 대한 배달 ID',
  `delivery_fee` varchar(45) NOT NULL COMMENT '배달수수료',
  `delivery_promotion_fee` varchar(45) NOT NULL COMMENT '배달 프로모션 수수료',
  `settlement_status` varchar(45) NOT NULL COMMENT '정산의 상태 (대기, 보류, 지급)\n',
  `settlement_amount` varchar(45) NOT NULL COMMENT '정산 금액',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`delivery_partner_settlement_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_partner_settlement_histories`
--

LOCK TABLES `delivery_partner_settlement_histories` WRITE;
/*!40000 ALTER TABLE `delivery_partner_settlement_histories` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_partner_settlement_histories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_partner_settlements`
--

DROP TABLE IF EXISTS `delivery_partner_settlements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_partner_settlements` (
  `delivery_partner_settlement_id` bigint NOT NULL AUTO_INCREMENT COMMENT '배달파트너 정산 ID',
  `delivery_partner_id` bigint NOT NULL COMMENT '배달파트너 ID',
  `order_id` bigint NOT NULL COMMENT '주문 ID',
  `order_delivery_id` bigint NOT NULL COMMENT '주문 배달 ID',
  `delivery_fee` decimal(10,0) NOT NULL COMMENT '배달료',
  `delivery_promotion_fee` decimal(10,0) NOT NULL COMMENT '배달 미션 프로모션 금액',
  `settlement_amount` decimal(10,0) NOT NULL COMMENT '정산 금액',
  `settlement_status` varchar(45) NOT NULL COMMENT '정산의 상태 (대기, 보류, 완료)',
  `is_deleted` bit(1) NOT NULL COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`delivery_partner_settlement_id`),
  KEY `idx_01_delivery_partner_id` (`delivery_partner_id`),
  KEY `idx_02_order_id` (`order_id`),
  KEY `idx_03_order_delivery_id` (`order_delivery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_partner_settlements`
--

LOCK TABLES `delivery_partner_settlements` WRITE;
/*!40000 ALTER TABLE `delivery_partner_settlements` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_partner_settlements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_partner_wallet_histories`
--

DROP TABLE IF EXISTS `delivery_partner_wallet_histories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_partner_wallet_histories` (
  `delivery_partner_wallet_history_id` bigint NOT NULL AUTO_INCREMENT COMMENT '배달파트너 지갑 이력 ID',
  `delivery_partner_wallet_id` bigint unsigned NOT NULL COMMENT '배달파트너 지갑 ID',
  `wallet_job_type` varchar(45) NOT NULL COMMENT '지갑의 이력 유형 - 입금, 출금',
  `money` decimal(10,2) NOT NULL COMMENT '입출금 금액',
  `deposit` decimal(10,2) NOT NULL COMMENT '작업 후 금액',
  `is_deleted` bit(1) NOT NULL COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`delivery_partner_wallet_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_partner_wallet_histories`
--

LOCK TABLES `delivery_partner_wallet_histories` WRITE;
/*!40000 ALTER TABLE `delivery_partner_wallet_histories` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_partner_wallet_histories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_partner_wallets`
--

DROP TABLE IF EXISTS `delivery_partner_wallets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_partner_wallets` (
  `delivery_partner_wallet_id` bigint NOT NULL AUTO_INCREMENT COMMENT '배달파트너 지갑 ID',
  `delivery_partner_id` bigint NOT NULL COMMENT '배달파트너 ID',
  `deposit` decimal(10,0) NOT NULL COMMENT '예금, 예치금',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`delivery_partner_wallet_id`),
  KEY `idx_01_delivery_partner_id` (`delivery_partner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_partner_wallets`
--

LOCK TABLES `delivery_partner_wallets` WRITE;
/*!40000 ALTER TABLE `delivery_partner_wallets` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_partner_wallets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_partners`
--

DROP TABLE IF EXISTS `delivery_partners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_partners` (
  `delivery_partner_id` bigint NOT NULL AUTO_INCREMENT COMMENT '배달파트너 ID',
  `email` varchar(55) NOT NULL COMMENT '이메일',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '비밀번호',
  `transportation` varchar(45) NOT NULL COMMENT '배달수단',
  `delivery_zone` varchar(255) NOT NULL COMMENT '배달지, 배달구역',
  `bank_code` varchar(45) DEFAULT NULL COMMENT '은행 식별 코드',
  `bank_account` varchar(45) NOT NULL COMMENT '은행계좌',
  `bank_account_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '은행명',
  `delivery_partner_role` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'BASIC',
  `status` varchar(45) NOT NULL COMMENT '배달파트너 상태',
  `is_deleted` varchar(45) NOT NULL DEFAULT '0' COMMENT '소프트삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`delivery_partner_id`),
  KEY `idx_01_email` (`email`),
  KEY `idx_02_bank_account` (`bank_account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_partners`
--

LOCK TABLES `delivery_partners` WRITE;
/*!40000 ALTER TABLE `delivery_partners` DISABLE KEYS */;
INSERT INTO `delivery_partners` VALUES (3,'test@test.com','$2a$10$pjuxHdy9wJB2W8WcsRqIp.1etQfRtsJ3GS06lVYrFbaclJZIj9y/G','CAR','평내동','KB','1111-22-3333','번쩍 배달원','BASIC','ACTIVE','0','2023-12-10 05:37:11','2023-12-10 05:37:11','',''),(4,'susia@susia.com','$2a$10$zioQU5ou4l8Psb9rnwZFWOUmIghxvS8EO4DyeOWCtAlWvxmhMbjHK','CAR','호평동','SHINHAN','1111223333','수시아','BASIC','ACTIVE','0','2023-12-10 10:35:36','2023-12-10 10:35:36','','');
/*!40000 ALTER TABLE `delivery_partners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_requests`
--

DROP TABLE IF EXISTS `delivery_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_requests` (
  `delivery_request_id` bigint NOT NULL AUTO_INCREMENT COMMENT '주문 배달 ID',
  `order_id` bigint NOT NULL COMMENT '주문 ID',
  `order_shorten_id` varchar(45) NOT NULL COMMENT '짧은 주문 번호',
  `store_id` bigint NOT NULL COMMENT '매장 ID',
  `customer_id` bigint NOT NULL COMMENT '고객 ID',
  `store_address` varchar(255) NOT NULL COMMENT '매장 주소',
  `delivery_address` varchar(255) NOT NULL COMMENT '고객 배달지 주소',
  `delivery_status` varchar(45) NOT NULL DEFAULT 'READY' COMMENT '주문 배달 상태',
  `delivery_partner_id` bigint NOT NULL COMMENT '배달 파트너 ID',
  `delivery_fee` decimal(10,2) NOT NULL COMMENT '배달 수수료',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`delivery_request_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_requests`
--

LOCK TABLES `delivery_requests` WRITE;
/*!40000 ALTER TABLE `delivery_requests` DISABLE KEYS */;
INSERT INTO `delivery_requests` VALUES (1,7,'XDS12D',1,3,'경기도 남양주시 호평동 늘을2로 27','경기도 남양주시 호평동 638','DELIVERY_COMPLETE',4,3000.00,_binary '\0','2023-11-20 21:55:02','2023-11-20 21:55:02','delivery-partner-id','delivery-partner-id');
/*!40000 ALTER TABLE `delivery_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refresh_tokens`
--

DROP TABLE IF EXISTS `refresh_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refresh_tokens` (
  `refresh_token_id` bigint NOT NULL AUTO_INCREMENT COMMENT '리프레시 토큰 ID',
  `email` varchar(255) NOT NULL COMMENT '이메일',
  `refresh_token` varchar(255) NOT NULL COMMENT '리프레시 토큰',
  PRIMARY KEY (`refresh_token_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refresh_tokens`
--

LOCK TABLES `refresh_tokens` WRITE;
/*!40000 ALTER TABLE `refresh_tokens` DISABLE KEYS */;
INSERT INTO `refresh_tokens` VALUES (1,'test@test.com','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwiaWF0IjoxNzAyMTg5NzM1LCJleHAiOjE3MDIyNzYxMzV9.OJuTKhjHN3QfEzgMm4qvvopIjQLNfZmHR2maJBzedgI'),(2,'susia@susia.com','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXNpYUBzdXNpYS5jb20iLCJpYXQiOjE3MDIyMDk1NTcsImV4cCI6MTcwMjI5NTk1N30.X88EqWjC5dRp8S6Um_OLAPY7jm_jqvGKUCT41Opg4PA');
/*!40000 ALTER TABLE `refresh_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'delivery_partner'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-12 23:50:35
