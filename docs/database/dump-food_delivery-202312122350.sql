-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: food_delivery
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
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `cart_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '장바구니에 담긴 아이템 ID',
  `cart_id` varchar(45) NOT NULL COMMENT '장바구니 ID',
  `menu_id` varchar(45) NOT NULL COMMENT '음식 메뉴 ID',
  `store_id` varchar(45) NOT NULL COMMENT '상점 ID',
  `quantity` int NOT NULL DEFAULT '0' COMMENT '수량',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '삭제 여부',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`cart_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `cart_id` bigint NOT NULL AUTO_INCREMENT COMMENT '장바구니 ID',
  `customer_id` bigint NOT NULL COMMENT '고객 ID',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '장바구니 삭제 여부',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '음식 카테고리 ID',
  `category_name` varchar(45) NOT NULL COMMENT '카테고리 이름',
  `category_main_image` varchar(255) NOT NULL COMMENT '카테고리 메인 이미지',
  `rank` int NOT NULL DEFAULT '0' COMMENT '카테고리 순서',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'치킨','http://localhost:8080/images/categories/chicken-leg.png',0,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(2,'일식','http://localhost:8080/images/categories/ramen.png',1,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(3,'돈까스','http://localhost:8080/images/categories/schnitzel.png',2,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(4,'구이','http://localhost:8080/images/categories/meat.png',3,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(5,'중식','http://localhost:8080/images/categories/noodle.png',4,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(6,'도시락','http://localhost:8080/images/categories/bento.png',5,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(7,'족발/보쌈','http://localhost:8080/images/categories/bossam.png',6,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(8,'버거','http://localhost:8080/images/categories/burger.png',7,0,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(9,'피자','http://localhost:8080/images/categories/pizza.png',8,1,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin'),(10,'분식','http://localhost:8080/images/categories/tteokbokki.png',9,1,'2023-10-14 21:34:16','2023-10-14 21:34:16','delivery-admin','delivery-admin');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_store_mappings`
--

DROP TABLE IF EXISTS `category_store_mappings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_store_mappings` (
  `category_menu_mapping_id` bigint NOT NULL AUTO_INCREMENT COMMENT '카테고리 - 매장 매핑 ID',
  `category_id` bigint NOT NULL COMMENT '카테고리 ID',
  `store_id` bigint NOT NULL COMMENT '상점 ID',
  `is_deleted` bit(1) NOT NULL COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`category_menu_mapping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_store_mappings`
--

LOCK TABLES `category_store_mappings` WRITE;
/*!40000 ALTER TABLE `category_store_mappings` DISABLE KEYS */;
INSERT INTO `category_store_mappings` VALUES (1,1,1,_binary '\0','2023-10-28 18:26:49','2023-10-28 18:26:49','category-manager','category-manager'),(2,1,2,_binary '\0','2023-10-28 18:26:51','2023-10-28 18:26:51','category-manager','category-manager');
/*!40000 ALTER TABLE `category_store_mappings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkout_discount_items`
--

DROP TABLE IF EXISTS `checkout_discount_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkout_discount_items` (
  `checkout_discount_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '체크아웃 할인정보 ID',
  `checkout_id` bigint NOT NULL COMMENT '체크아웃 ID',
  `discount_id` varchar(45) NOT NULL COMMENT '할인 ID',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`checkout_discount_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkout_discount_items`
--

LOCK TABLES `checkout_discount_items` WRITE;
/*!40000 ALTER TABLE `checkout_discount_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkout_discount_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkout_items`
--

DROP TABLE IF EXISTS `checkout_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkout_items` (
  `checkout_item_id` int NOT NULL AUTO_INCREMENT COMMENT '체크아웃 아이템 ID',
  `checkout_id` bigint NOT NULL COMMENT '체크아웃 ID',
  `menu_id` bigint NOT NULL COMMENT '메뉴 ID',
  `menu_price` decimal(10,2) NOT NULL COMMENT '메뉴 가격',
  `menu_quantity` int NOT NULL COMMENT '메뉴 수량',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`checkout_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkout_items`
--

LOCK TABLES `checkout_items` WRITE;
/*!40000 ALTER TABLE `checkout_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkout_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkouts`
--

DROP TABLE IF EXISTS `checkouts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkouts` (
  `checkout_id` bigint NOT NULL AUTO_INCREMENT COMMENT '체크아웃 ID',
  `customer_id` varchar(45) NOT NULL COMMENT '고객 ID',
  `store_id` varchar(45) NOT NULL COMMENT '상점 ID',
  `is_deleted` varchar(45) NOT NULL DEFAULT '0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`checkout_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkouts`
--

LOCK TABLES `checkouts` WRITE;
/*!40000 ALTER TABLE `checkouts` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkouts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT COMMENT '고객 ID',
  `name` varchar(45) NOT NULL COMMENT '고객명',
  `email` varchar(255) NOT NULL COMMENT '이메일',
  `password` varchar(255) NOT NULL COMMENT '비밀번호',
  `phone` varchar(45) NOT NULL COMMENT '폰번호',
  `address` varchar(255) NOT NULL COMMENT '주소',
  `status` varchar(45) NOT NULL COMMENT '고객 상태 (회원, 휴면회원, 탈퇴)',
  `role` varchar(45) NOT NULL DEFAULT 'USER' COMMENT '역할',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'system' COMMENT '생성자',
  `updated_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'system' COMMENT '수정자',
  PRIMARY KEY (`customer_id`),
  KEY `idx_01_email` (`email`) USING BTREE,
  KEY `idx_02_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (3,'마징가','ultrakain@gmail.com','$2a$10$10h6X.mgkqQXRChbLw2EuOAN1vWpzWSF/MjiT2p1f3RjTkSQgm9zq','010-2222-3334','경기도 남양주시 다산동 중흥아파트 1002-212','ACTIVE','CUSTOMER',_binary '\0','2023-11-08 12:24:40','2023-11-08 12:24:40','delivery-api','delivery-api'),(4,'소닉','test@test.com','$2a$10$OOV2O7gQcGKFCgiZR7bL9.VuQkPq854h89Bjnj3W/9Xtf8OzjWPPu','010-1111-3333','경기도 남양주시 다산동','ACTIVE','CUSTOMER',_binary '\0','2023-12-04 11:40:37','2023-12-04 11:40:37','delivery-api','delivery-api');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discounts` (
  `discount_id` bigint NOT NULL COMMENT '할인 정보 ID',
  `discount_type` varchar(45) NOT NULL COMMENT '할인 유형',
  `discount_method` varchar(45) NOT NULL COMMENT '할인 방법',
  `discount_value` tinyint NOT NULL COMMENT '할인율',
  `discount_start_date` datetime NOT NULL COMMENT '쿠폰 유효 시작일',
  `discount_expiration_date` datetime NOT NULL COMMENT '쿠폰 만료일',
  `is_available` bit(1) NOT NULL COMMENT '쿠폰 활성화 여부',
  `is_deleted` bit(1) NOT NULL COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounts`
--

LOCK TABLES `discounts` WRITE;
/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menus`
--

DROP TABLE IF EXISTS `menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menus` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '메뉴 ID',
  `store_id` bigint NOT NULL COMMENT '상점 ID',
  `menu_name` varchar(45) NOT NULL COMMENT '메뉴명',
  `menu_main_image` varchar(255) NOT NULL COMMENT '메뉴 메인 이미지',
  `price` decimal(10,2) NOT NULL COMMENT '가격',
  `status` varchar(45) NOT NULL COMMENT '메뉴 상태',
  `description` varchar(255) NOT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`menu_id`),
  KEY `idx_01_store_id` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menus`
--

LOCK TABLES `menus` WRITE;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` VALUES (1,1,'크리스피한 맛의 치킨','http://localhost:8080/images/menu/menu-2.png',30000.00,'READY','먹고 또 먹어도 질리지 않는 맛',_binary '\0','2023-11-18 01:52:24','2023-11-18 01:52:24','${server.role-name','${server.role-name'),(2,3,'엄청난 피자','http://localhost:8080/images/menu/menu-1.png',40000.00,'SALE','엄청나게 크고 맛있는 피자입니다.',_binary '\0','2023-10-22 23:14:13','2023-10-22 23:14:13','admin','admin'),(3,1,'불맛나는 치킨','http://localhost:8080/images/menu/menu-3.png',15000.00,'SALE','화끈한 향을 즐길 수 있는 치킨',_binary '\0','2023-10-29 11:09:19','2023-10-29 11:09:19','admin','admin'),(4,1,'바삭한 치킨','http://localhost:8080/images/menu/menu-4.png',18000.00,'SALE','입안에 가득 바삭함을 느끼는 치킨',_binary '\0','2023-10-29 11:09:19','2023-10-29 11:09:19','admin','admin'),(5,1,'모듬 치킨','http://localhost:8080/images/menu/menu-5.png',21000.00,'SALE','훈제, 만두, 다양한 디쉬를 즐길 수 있는 치킨',_binary '\0','2023-10-29 11:09:19','2023-10-29 11:09:19','admin','admin'),(25,1,'(신규) 바삭한 치킨과 감자','http://localhost:8080/images/menu/menu-2.png',15000.00,'READY','정말 끝내줍니다.',_binary '\0','2023-11-18 02:24:48','2023-11-18 02:24:48','${server.role-name','${server.role-name'),(26,1,'(신규) 촉촉한 치킨과 감자','http://localhost:8080/images/menu/menu-2.png',20000.00,'READY','한번 먹어보면 멈출 수 없다',_binary '\0','2023-11-18 02:24:48','2023-11-18 02:24:48','${server.role-name','${server.role-name'),(27,1,'(신규) 쫄깃한 치킨과 콘샐러드','http://localhost:8080/images/menu/menu-2.png',30000.00,'READY','먹고 또 먹어도 질리지 않는 맛',_binary '\0','2023-11-18 02:24:48','2023-11-18 02:24:48','${server.role-name','${server.role-name');
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_discount_items`
--

DROP TABLE IF EXISTS `order_discount_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_discount_items` (
  `order_discount_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '체크아웃 할인정보 ID',
  `order_id` bigint NOT NULL COMMENT '체크아웃 ID',
  `discount_id` varchar(45) NOT NULL COMMENT '할인 ID',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  `discount_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '최종 할인 금액',
  PRIMARY KEY (`order_discount_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_discount_items`
--

LOCK TABLES `order_discount_items` WRITE;
/*!40000 ALTER TABLE `order_discount_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_discount_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL COMMENT '주문 ID',
  `menu_id` bigint NOT NULL COMMENT '음식 메뉴 ID',
  `menu_price` decimal(10,0) NOT NULL COMMENT '음식 메뉴 가격',
  `menu_quantity` int NOT NULL DEFAULT '0' COMMENT '메뉴 개수',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`order_item_id`),
  KEY `idx_01_order_id` (`order_id`),
  KEY `idx_02_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '주문 ID',
  `order_uuid` varchar(255) NOT NULL,
  `order_shorten_id` varchar(45) NOT NULL,
  `checkout_id` bigint NOT NULL COMMENT '체크아웃 ID',
  `order_amount` decimal(10,0) NOT NULL COMMENT '주문 금액',
  `discount_amount` decimal(10,0) NOT NULL COMMENT '할인 금액',
  `delivery_fee` decimal(10,0) NOT NULL COMMENT '배달료',
  `total_order_amount` decimal(10,0) NOT NULL COMMENT '총 주문 금액',
  `order_status` varchar(45) NOT NULL COMMENT '주문 상태',
  `store_id` bigint NOT NULL COMMENT '주문하는 상점 ID',
  `customer_id` bigint NOT NULL COMMENT '주문하는 고객 ID',
  `is_deleted` varchar(45) NOT NULL DEFAULT '0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '결제 ID',
  `payment_method` varchar(45) NOT NULL COMMENT '결제 수단',
  `pg_id` bigint NOT NULL COMMENT 'PG 업체 ID',
  `pg_payment_id` varchar(255) NOT NULL COMMENT 'PG 업체의 결제 ID',
  `pay_amount` decimal(10,0) NOT NULL COMMENT '결제 금액',
  `payment_status` varchar(45) NOT NULL COMMENT '결제 상태',
  `order_id` bigint NOT NULL COMMENT '주문서 ID',
  `customer_id` bigint NOT NULL COMMENT '결제 고객 ID',
  `store_id` bigint NOT NULL COMMENT '상점 ID',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refresh_tokens`
--

LOCK TABLES `refresh_tokens` WRITE;
/*!40000 ALTER TABLE `refresh_tokens` DISABLE KEYS */;
INSERT INTO `refresh_tokens` VALUES (14,'ultrakain@gmail.com','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1bHRyYWthaW5AZ21haWwuY29tIiwiaWF0IjoxNjk5NzY5NTE4LCJleHAiOjE2OTk4NTU5MTh9.caPZFYjL8BLsuo3IKvun7YLhcwHN1uz9_3JdX088XNU'),(16,'test@test.com','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwiaWF0IjoxNzAyMjE3MDE0LCJleHAiOjE3MDIzMDM0MTR9.h64SjPizM36At5uOT783twlZGkCn12T95oQI1hTqwrM');
/*!40000 ALTER TABLE `refresh_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_settlements`
--

DROP TABLE IF EXISTS `store_settlements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_settlements` (
  `store_settlement_id` bigint NOT NULL COMMENT '정산 ID',
  `store_id` bigint NOT NULL COMMENT '상점 ID',
  `order_id` bigint NOT NULL COMMENT '주문 ID',
  `order_amount` decimal(10,0) NOT NULL COMMENT '주문 금액',
  `discount_amount` decimal(10,0) NOT NULL COMMENT '할인 금액',
  `delivery_fee` decimal(10,0) NOT NULL COMMENT '배달료',
  `total_order_amount` decimal(10,0) NOT NULL COMMENT '총 주문 금액',
  `service_fee` decimal(10,0) NOT NULL COMMENT '서비스 수수료',
  `promotion_fee` decimal(10,0) NOT NULL COMMENT '프로모션 수수료',
  `settlement_amount` decimal(10,0) NOT NULL COMMENT '정산 금액',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`store_settlement_id`),
  KEY `idx_01_store_id` (`store_id`),
  KEY `idx_02_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_settlements`
--

LOCK TABLES `store_settlements` WRITE;
/*!40000 ALTER TABLE `store_settlements` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_settlements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_wallets`
--

DROP TABLE IF EXISTS `store_wallets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_wallets` (
  `store_wallet_id` bigint NOT NULL AUTO_INCREMENT COMMENT '상점 지갑 ID',
  `store_id` bigint NOT NULL COMMENT '상점 ID',
  `deposit` decimal(10,0) NOT NULL COMMENT '예금, 예치금',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`store_wallet_id`),
  KEY `idx_01_store_id` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_wallets`
--

LOCK TABLES `store_wallets` WRITE;
/*!40000 ALTER TABLE `store_wallets` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_wallets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stores`
--

DROP TABLE IF EXISTS `stores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stores` (
  `store_id` bigint NOT NULL AUTO_INCREMENT COMMENT '상점 ID',
  `email` varchar(55) NOT NULL COMMENT '상점 계정 아이디',
  `business_number` varchar(45) NOT NULL COMMENT '사업자 번호',
  `name` varchar(45) NOT NULL COMMENT '상점 이름',
  `phone` varchar(45) NOT NULL COMMENT '상점 대표 폰번호',
  `address` varchar(255) NOT NULL COMMENT '상점 주소',
  `password` varchar(45) NOT NULL COMMENT '비밀번호',
  `bank_account` varchar(45) NOT NULL COMMENT '은행 계좌',
  `bank_name` varchar(45) NOT NULL COMMENT '은행명',
  `delivery_time` varchar(45) NOT NULL DEFAULT '30분 ~ 40분' COMMENT '배달 평균 시간',
  `main_image_url` varchar(255) NOT NULL COMMENT '상점 대표 이미지',
  `description` varchar(1024) NOT NULL COMMENT '상점 상세 설명',
  `delivery_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '기본 배달 수수료',
  `review_grade` tinyint(1) NOT NULL DEFAULT '5' COMMENT '평점',
  `minimum_order_price` decimal(10,2) NOT NULL DEFAULT '8000.00',
  `status` varchar(45) NOT NULL COMMENT '상점상태',
  `is_deleted` varchar(45) NOT NULL DEFAULT '0' COMMENT '소프트 삭제',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `created_by` varchar(45) NOT NULL COMMENT '생성자',
  `updated_by` varchar(45) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`store_id`),
  KEY `idx_01_store_account_id` (`email`),
  KEY `idx_02_business_number` (`business_number`),
  KEY `idx_03_phone` (`phone`),
  KEY `idx_04_bank_account` (`bank_account`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stores`
--

LOCK TABLES `stores` WRITE;
/*!40000 ALTER TABLE `stores` DISABLE KEYS */;
INSERT INTO `stores` VALUES (1,'store1@fc.com','1111199999','아트한 치킨집','01022223333','서울특별시 송파구 잠실동','1234','1111-22-3333','배달은행','20분 ~ 30분','http://localhost:8080/images/store/store-1.png','동네에서 맛집으로 소문난 치킨집, 별점 5점',3000.00,5,8000.00,'SALE','0','2023-10-14 18:28:43','2023-10-14 18:28:43','onboarding','onboarding'),(2,'store2@home.com','2222233333','달콤한 족발집','01011112222','서울특별시 삼성역 부근','1234','2222-33-4444','궁민은행','10분 ~ 15분','http://localhost:8080/images/store/store-2.png','정말 엄청 달콤하고 쫀득한 족발집',2500.00,5,8000.00,'SALE','0','2023-10-28 22:18:42','2023-10-28 22:18:42','onboarding','onboarding'),(3,'store3@food.com','333344445','빅 피자','01033334444','서울특별시 강남구 강남역','1234','3333-44-5555','번쩍은행','30분 ~ 40분','http://localhost:8080/images/store/store-3.png','엄청난 사이즈의 피자, 국내 최대의 피자',2000.00,5,8000.00,'SALE','0','2023-10-29 10:47:30','2023-10-29 10:47:30','onboarding','onboarding'),(4,'store4@rank.com','4444555566','한번에 2마리 치킨','01044445555','서울특별시 강남구 선릉역','1234','4444-55-6666','달콤은행','30분 ~ 40분','http://localhost:8080/images/store/store-4.png','묻지도 따지지 않고 한번에 2마리 치킨',2500.00,3,8000.00,'SALE','0','2023-10-29 10:47:30','2023-10-29 10:47:30','onboarding','onboarding'),(5,'store5@cup.co.kr','2222333344','무조건 벤티 커피','01012341234','경기도 남양주시 호평동','1234','1111-12-1234','배달은행','30분 ~ 40분','http://localhost:8080/images/store/store-5.png','큰 사이즈의 커피를 기본으로 드립니다',2000.00,5,8000.00,'SALE','0','2023-10-29 10:49:28','2023-10-29 10:49:28','onboarding','onboarding'),(6,'store6@pork.com','111122223333','불맛 구이','010223344556','서울특별시 송파구 잠실동','1234','6666-22-3333','넘버원은행','30분 ~ 40분','http://localhost:8080/images/store/store-6.png','불맛이 살아있는 돼지고기 구이 전문점',1500.00,5,8000.00,'SALE','0','2023-10-29 10:57:59','2023-10-29 10:57:59','onboarding','onboarding');
/*!40000 ALTER TABLE `stores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'food_delivery'
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
