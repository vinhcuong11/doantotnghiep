-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: foodshopdemo
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
                           `accid` int(11) NOT NULL AUTO_INCREMENT,
                           `roleid` int(11) NOT NULL DEFAULT 2,
                           `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                           `username` varchar(100) NOT NULL,
                           `password` varchar(255) NOT NULL,
                           `email` varchar(50) NOT NULL,
                           `image` varchar(50) DEFAULT NULL,
                           `phone_number` int(12) DEFAULT NULL,
                           PRIMARY KEY (`accid`),
                           CONSTRAINT `account_fk_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1,'Hoài Nam','hoainam','123','hoainam@gmail,com',NULL,812085585),(2,1,'Nguyễn Hoài Nam','nam','123','hoainam@gmail,com',NULL,NULL),(3,2,'Văn Thành','vanthanh','123','vanthanh@gmail,com',NULL,NULL),(4,2,'Đỗ Hiền','hien','123','hien@gmail,com',NULL,NULL),(5,2,'Cường','cuong','123','cuong@gmail,com',NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authori`
--
--
-- DROP TABLE IF EXISTS `authori`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- SET character_set_client = utf8mb4 ;
-- CREATE TABLE `authori` (
--                            `id_authori` int(11) NOT NULL AUTO_INCREMENT,
--                            `user_id` int(11) DEFAULT NULL,
--                            `role_id` int(11) DEFAULT NULL,
--                            PRIMARY KEY (`id_authori`),
--                            UNIQUE KEY `user_id` (`user_id`,`role_id`),
--                            UNIQUE KEY `UKjlvujpqq3xu6qo3pgvfravb02` (`user_id`,`role_id`),
--                            KEY `authori_fk_role` (`role_id`),
--                            CONSTRAINT `authori_fk_account` FOREIGN KEY (`user_id`) REFERENCES `account` (`accid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
--                            CONSTRAINT `authori_fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
-- ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;
--
-- --
-- -- Dumping data for table `authori`
-- --
--
-- LOCK TABLES `authori` WRITE;
-- /*!40000 ALTER TABLE `authori` DISABLE KEYS */;
-- INSERT INTO `authori` VALUES (1,1,1),(2,5,2);
-- /*!40000 ALTER TABLE `authori` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
                            `id` varchar(50) NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('HAISAN','hải sản tươi sống'),('QUA','Củ, Quả'),('RAU','trái cây tươi '),('THIT','thịt tươi sống');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `orderdetail` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `delivery_address` text NOT NULL,
                               `order_id` int(11) NOT NULL,
                               `product_id` int(11) NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `orderdetail_fk_product_productid` (`product_id`),
                               KEY `orderdetail_fk_product_orderid` (`order_id`),
                               CONSTRAINT `orderdetail_fk_product_orderid` FOREIGN KEY (`order_id`) REFERENCES `orders` (`orderId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                               CONSTRAINT `orderdetail_fk_product_productid` FOREIGN KEY (`product_id`) REFERENCES `product` (`productid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,'30/6a, Hà Thị Khiêm, p.Trung Mỹ Tây, q.12',1,2);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
                          `orderId` int(11) NOT NULL AUTO_INCREMENT,
                          `orderDate` date NOT NULL,
                          `deliverydate` date NOT NULL,
                          `user_id` int(11) NOT NULL,
                          `status` tinyint(1) NOT NULL,
                          PRIMARY KEY (`orderId`),
                          KEY `order_fk_account_userid` (`user_id`),
                          CONSTRAINT `order_fk_account_userid` FOREIGN KEY (`user_id`) REFERENCES `account` (`accid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2023-11-13','2023-11-30',5,0);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
                           `productid` int(255) NOT NULL AUTO_INCREMENT,
                           `image` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `price` float DEFAULT '0',
                           `quantity` int(11) NOT NULL,
                           `category_id` varchar(50) NOT NULL,
                           `description` text,
                           `createdate` datetime(6) DEFAULT NULL,
                           `mass` varchar(50) DEFAULT NULL,
                           `numberMass` int(50) DEFAULT NULL,
                           `status` bit(10) DEFAULT NULL,
                           PRIMARY KEY (`productid`),
                           KEY `category_id` (`category_id`),
                           CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'e9484dd5.jpg','sdfsadfasdf00g',70000,123,'THIT',NULL,'2023-11-13 19:00:44.096000','g',500,_binary '\0'),(2,'7345bb23.jpg','Xương Ống Heo Sạch CP 500G',62000,300,'THIT',NULL,'2023-11-13 19:17:19.719000','Kg',NULL,_binary '\0'),(3,'80b3824e.jpg','Chân Giò Sau Heo Sạch CP 500G',68000,200,'THIT',NULL,'2023-11-13 08:00:00.000000','g',500,_binary '\0'),(4,'1fc88d9b.jpg','Xương Đuôi Heo Sạch CP 500G',75000,200,'THIT',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(5,'9b056838.jpg','Xương Cổ Heo Sạch CP 500G',67000,200,'THIT',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(6,'ab0bc929.jpg','Ba Rọi Rút Sườn Heo Sạch CP 300G',79000,200,'THIT',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(7,'c1a95ba6.jpg','Ba Rọi Heo Sạch CP 300G',62000,200,'THIT',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(8,'e1a63c46.jpg','Sườn non heo sạch CP 500g',125000,200,'THIT',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(10,'85fb077f.jpg','Rau Muống Hạt Vietgap 500G Vico Farm',27000,200,'RAU',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(11,'6446d226.jpg','Rau Muống Hạt Vietgap 500G Vico Farm',27000,200,'RAU',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(12,'22dcb021.jpg','Cải Dún Vietgap 500g Vico Farm',27000,200,'RAU',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(13,'cba283b2.jpg','Bắp cải trắng Vico Farm',30000,200,'RAU',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0\0'),(14,'b290400d.jpg','Xà lách Lolo Xanh Vico Farm 300g',20000,200,'RAU',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0'),(15,'e4566c99.jpg','Rau tần ô Vico Farm 350G',23000,200,'RAU',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0'),(16,'e0620180.jpg','Rau Mồng Tơi Vietgap 300g Vico Farm',19000,200,'RAU',NULL,'2023-11-19 08:00:00.000000',NULL,NULL,_binary '\0'),(17,NULL,'Nghêu sạch Lenger nâu 1.2 kg',103000,200,'HAISAN',NULL,'2023-11-19 08:00:00.000000',NULL,NULL,_binary '\0'),(18,NULL,'Đầu cá hồi Nauy Kome88',70000,200,'HAISAN',NULL,'1970-01-01 08:00:00.000000',NULL,NULL,_binary '\0\0'),(19,NULL,'Cá hú tươi làm sạch PGP',99000,200,'HAISAN',NULL,'1970-01-01 08:00:00.000000',NULL,NULL,_binary '\0'),(20,NULL,'Xương cá hồi Nauy Kome88',50000,200,'HAISAN',NULL,'2023-11-19 08:00:00.000000',NULL,NULL,_binary '\0'),(21,NULL,'Cá trê làm sạch không đầu PGP',105000,200,'HAISAN',NULL,'1970-01-01 08:00:00.000000',NULL,NULL,_binary '\0\0'),(22,NULL,'Cá kèo tươi làm sạch PGP',270000,200,'HAISAN',NULL,'1970-01-01 08:00:00.000000',NULL,NULL,_binary '\0'),(23,NULL,'Cá Chim Trắng làm sạch PGP',340000,200,'HAISAN',NULL,'1970-01-01 08:00:00.000000',NULL,NULL,_binary '\0'),(24,NULL,'Nghêu sạch Lenger nâu 1.2 kg',23000,150,'HAISAN',NULL,'2023-11-19 08:00:00.000000',NULL,NULL,_binary '\0'),(25,NULL,'Rau Mồng Tơi',23000,150,'RAU',NULL,'2023-11-19 08:00:00.000000',NULL,NULL,_binary '\0\0'),(26,'54e3e06.png','test',646549000,255,'HAISAN',NULL,'2023-11-15 00:00:00.000000',NULL,NULL,_binary '\0\0'),(30,'','Hoàng',1,1638,'HAISAN',NULL,'2023-11-09 20:18:33.189000',NULL,NULL,_binary '\0'),(31,'7f2bdb39.jpg','Bàn Phím Cơ',1000,32323,'THIT',NULL,'2023-11-13 08:00:00.000000',NULL,NULL,_binary '\0'),(32,'450c96d8.jpg','fsaf',24234,243234,'HAISAN',NULL,'1970-01-01 08:00:00.000000',NULL,NULL,_binary '\0'),(33,NULL,'ádfasfd',4135130,1313,'HAISAN',NULL,'2023-11-19 00:00:00.000000',NULL,NULL,_binary '\0'),(34,NULL,'sdfsadf',NULL,13213,'QUA',NULL,'2023-11-19 00:00:00.000000',NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_product`
--

DROP TABLE IF EXISTS `status_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `status_product` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `name` varchar(50) NOT NULL,
                                  `productid` int(11) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `statusProduct_fk_product_id` (`productid`),
                                  CONSTRAINT `statusProduct_fk_product_id` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_product`
--

LOCK TABLES `status_product` WRITE;
/*!40000 ALTER TABLE `status_product` DISABLE KEYS */;
INSERT INTO `status_product` VALUES (1,'Đã Giao',NULL),(2,'Chưa Giao',NULL),(3,'Đã Thanh Toán',NULL),(4,'Chưa Thanh Toán',NULL),(5,'Đã Hủy',NULL),(6,'Đã Chờ Thanh Toán',NULL);
/*!40000 ALTER TABLE `status_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-30 16:03:11
-- Dump completed on 2023-11-30 16:03:11