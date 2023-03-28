-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `name_vn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Điện thoại','Iphone'),(2,'Điện thoại','Samsung'),(3,'Điện thoại','Oppo'),(4,'Điện thoại','Xiaomi'),(5,'Điện thoại','Nokia');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text,
  `star` int DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'sản phẩm rất đẹp và tôt',5,'2023-02-23',1,18),(3,'Em kiểm tra sản phẩm Điện thoại OPPO A57 128GB Giá tại Phú Yên 4.590.000₫ Giá và khuyến mãi dự kiến áp',0,'2023-02-23',1,18),(4,'Cho em hỏi máy em tải các app trên cửa hàng play mà tải mãi không được nó cứ hiện hàng chữ \" Đang chờ xử lý, play protect đã xác minh\" Em cảm ơn',0,'2023-02-23',1,18),(5,'sản phẩm đẹp ',0,'2023-02-25',1,10),(6,'sản phẩm quá đẹp',0,'2023-02-25',1,13),(7,'Sản phẩm này còn hàng không ',0,'2023-02-25',1,13),(8,'sản phẩm còn hàng không ạ ',5,'2023-02-25',1,2),(9,'quá đắt so với giá thị trường ',5,'2023-02-25',1,2),(10,'sản phẩm quá đẹp tôi rất muốn mua ',0,'2023-02-25',1,14),(11,'sản phẩm quá tuyệt vời',0,'2023-02-25',1,30),(12,'sản phẩm tuyệt với',0,'2023-02-26',1,10),(13,'sản phẩm tuyệt vời',0,'2023-02-26',1,10),(14,'sản phẩm đẹp',0,'2023-02-26',1,10),(15,'sản phẩm quá tuyệt vời trong tầm giá ',5,'2023-02-26',1,5),(16,'sản phẩm này còn không ạ, rất cảm ơn ạ ',0,'2023-02-26',1,5),(17,'tôi muốn mua với giá giảm 20 % dược không ạ ',5,'2023-02-26',1,5),(18,'ok',5,'2023-03-26',3,15),(19,'dd',0,'2023-03-26',3,8),(20,'sản phẩm quá tuyệt vời ',5,'2023-03-26',3,15),(21,'sản phẩm rất là ok ',5,'2023-03-26',3,14);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `discount` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (51,35,30,25000,1,0),(53,36,9,28490000,1,0.03),(54,37,8,23490000,2,0.05),(58,41,15,1450000,2,0.3);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `users_id` int NOT NULL,
  `order_date` timestamp NULL DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `description` text,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `users_id` (`users_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (35,1,'2022-12-14 17:00:00',21452525,'thai binh',25000,'ok',2),(36,3,'2023-02-26 06:54:53',857973867,'Vũ tiến vũ thư thái bình ',27635300,'Giao hàng buổi trưa ',2),(37,3,'2023-02-26 07:52:54',857973867,'269 Thoại Ngọc Hầu, Phú Thạnh, Tân Phú, Hồ Chí minh',44631000,'Giao hàng vào ban đêm ',2),(41,3,'2023-03-26 10:47:31',8,'thái bình ',2030000,'giao hàng buổi trưa ',1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `photo` text,
  `create_date` date DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  `quantity` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `description` text,
  `discount` float DEFAULT NULL,
  `view_count` int DEFAULT NULL,
  `special` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'iphone-11-trang-128GB',12490000,'iphone-11-trang-128GB.jpg','2022-12-15',1,15,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >IPS LCD6.1\"Liquid Retina</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A13 Bionic</p>\n     <p>4 GB</p>\n     <p>128 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 4G</p>\n     <p>3110 mAh18 W</p>\n    </div>',0.05,2400,1),(2,'iphone-13-starlight-64GB',20490000,'iphone-13-starlight.jpg','2022-12-16',1,10,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>64 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>3240 mAh18 W</p>\n    </div>',0.05,3400,1),(3,'iphone-13-starlight-64GB',20490000,'iphone-13-mini-midnight.jpg','2022-12-17',1,20,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>64 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>3240 mAh18 W</p>\n    </div>',0.06,1400,1),(4,'iphone-14',17490000,'iPhone-14.jpg','2023-01-18',1,13,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đỏ</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>64 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>4240 mAh18 W</p>\n    </div>',0.04,1000,0),(5,'iphone-14-plus',19490000,'iPhone-14-plus.jpg','2023-01-19',1,25,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>64 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>4240 mAh18 W</p>\n    </div>',0.03,900,0),(6,'iphone-14-pro',18490000,'iphone-14-pro.jpg','2023-01-10',1,23,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu tím</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>64 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>4240 mAh18 W</p>\n    </div>',0.02,850,0),(7,'iphone-13-pro-graphite',21490000,'iphone-13-pro-graphite.jpg','2023-01-11',1,33,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xám</p>\n     <p>iOS 15</p>\n     <p>2 camera 12 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>64 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>4240 mAh18 W</p>\n    </div>',0.05,3800,0),(8,'iphone-12',23490000,'iphone-12.jpg','2023-01-19',1,25,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu tím</p>\n     <p>iOS 14</p>\n     <p>2 camera 20 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>128 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>4240 mAh18 W</p>\n    </div>',0.05,3500,0),(9,'iphone-13-pro-max-graphite',28490000,'iphone-13-pro-max-graphite.jpg','2023-01-25',1,35,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xám</p>\n     <p>iOS 15</p>\n     <p>2 camera 38 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>528 GB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>5240 mAh18 W</p>\n    </div>',0.03,4500,1),(10,'iphone-14-pro-max',30490000,'iphone-14-pro-max.jpg','2023-01-25',1,20,1,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu vàng</p>\n     <p>iOS 15</p>\n     <p>2 camera 38 MP</p>\n     <p>12 MP</p>\n     <p>Apple A15 Bionic</p>\n     <p>4 GB</p>\n     <p>1 TB</p>\n     <p>1 Nano SIM & 1 eSIMHỗ trợ 5G</p>\n     <p>5240 mAh18 W</p>\n    </div>',0.04,5500,1),(11,'Nokia 8210',1800000,'Nokia 8210.jpg','2023-01-24',1,25,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đỏ</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>4 GB</p>\n     <p>12 gb</p>\n     <p>1 Nano SIM </p>\n     <p>5240 mAh18 W</p>\n    </div>',0.1,220,1),(12,'Nokia-110-4g',1900000,'nokia-110-4g.jpg','2023-01-25',1,10,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xanh</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>4 GB</p>\n     <p>12 gb</p>\n     <p>1 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.1,200,1),(13,'Nokia-215',1900000,'nokia-215.jpg','2023-01-26',1,19,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xanh ngọc</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>4 GB</p>\n     <p>12 gb</p>\n     <p>1 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.2,250,1),(14,'Nokia-c21-plus',1300000,'nokia-c21-plus.jpg','2023-01-27',1,17,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xanh </p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>4 GB</p>\n     <p>12 gb</p>\n     <p>1 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.3,215,1),(15,'Nokia-g11-plus',1450000,'nokia-g11-plus.jpg','2023-01-30',1,8,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xám </p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>2 GB</p>\n     <p>10 gb</p>\n     <p>1 Nano SIM </p>\n     <p>4240 mAh18 W</p>\n    </div>',0.3,115,1),(16,'Nokia-C21-Plus-Gray',1650000,'Nokia-C21-Plus-Gray.jpg','2022-01-30',1,18,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu gray </p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>2 GB</p>\n     <p>10 gb</p>\n     <p>1 Nano SIM </p>\n     <p>8240 mAh18 W</p>\n    </div>',0.5,120,1),(17,'Nokia-C31',2650000,'Nokia-C31-Green.jpg','2022-01-31',1,22,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu green</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>2 GB</p>\n     <p>10 gb</p>\n     <p>1 Nano SIM </p>\n     <p>8240 mAh18 W</p>\n    </div>',0.5,180,1),(18,'Nokia-g11',3650000,'Nokia-g11.jpg','2022-01-31',1,25,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xám</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>2 GB</p>\n     <p>10 gb</p>\n     <p>1 Nano SIM </p>\n     <p>8240 mAh18 W</p>\n    </div>',0.5,350,1),(19,'Nokia-g21',4650000,'nokia-g21.jpg','2022-01-31',1,15,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xanh đen</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>2 GB</p>\n     <p>10 gb</p>\n     <p>1 Nano SIM </p>\n     <p>3240 mAh18 W</p>\n    </div>',0.5,450,1),(20,'Nokia-c30',5650000,'nokia-c30.jpg','2022-02-15',1,25,5,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xám</p>\n     <p>Nokia foce 25</p>\n     <p>2 camera 2 MP</p>\n     <p>3 MP</p>\n     <p>Nokia A15 vinalink</p>\n     <p>5 GB</p>\n     <p>10 gb</p>\n     <p>1 Nano SIM </p>\n     <p>5240 mAh18 W</p>\n    </div>',0.5,250,1),(21,'Oppo-a95-4g',7650000,'oppo-a95-4g.jpg','2022-02-15',1,25,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu trắn</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo A15 pin</p>\n     <p>8 GB</p>\n     <p>128 gb</p>\n     <p>2 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.4,1500,1),(22,'Oppo-a16',8650000,'oppo-a16.jpg','2022-02-15',1,12,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu xám</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo A15 pin</p>\n     <p>8 GB</p>\n     <p>128 gb</p>\n     <p>2 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.5,1100,1),(23,'oppo-a17k',12500000,'oppo-a17k.jpg','2022-02-15',1,18,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu vàng</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo A15 pin</p>\n     <p>8 GB</p>\n     <p>128 gb</p>\n     <p>2 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.1,1000,1),(24,'OPPO-A76',15500000,'OPPO-A76.jpg','2022-02-15',1,17,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo  pin</p>\n     <p>8 GB</p>\n     <p>128 gb</p>\n     <p>2 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.1,1050,1),(25,'Oppo-reno7',20500000,'oppo-reno7.jpg','2022-02-15',1,25,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo  pin</p>\n     <p>8 GB</p>\n     <p>128 gb</p>\n     <p>2 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0.1,3050,1),(26,'Oppo-reno6',20500000,'oppo-reno6.jpg','2022-01-15',1,20,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo  pin</p>\n     <p>8 GB</p>\n     <p>128 gb</p>\n     <p>2 Nano SIM </p>\n     <p>6240 mAh18 W</p>\n    </div>',0,4050,1),(27,'Oppo-a16k',13500000,'oppo-a16k.jpg','2022-01-20',1,10,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo pin</p>\n     <p>10 GB</p>\n     <p>64 gb</p>\n     <p>2 Nano SIM </p>\n     <p>4240 mAh18 W</p>\n    </div>',0.05,2000,1),(28,'Oppo-a55',10500000,'oppo-a55.jpg','2022-01-21',1,12,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>24 MP</p>\n     <p>Oppo pin</p>\n     <p>10 GB</p>\n     <p>64 gb</p>\n     <p>2 Nano SIM </p>\n     <p>4240 mAh18 W</p>\n    </div>',0.05,2050,1),(29,'Oppo-reno8-pro',22500000,'oppo-reno8-pro.jpg','2022-01-21',1,19,3,'<div class=\"col-md-5 \" >\n     <p > <strong> Màn hình :</strong></p>\n	 <p > <strong> Màu sắc :</strong></p>\n     <p> <strong>Hệ điều hành:</strong></p>\n     <p ><strong>Camera sau: </strong></p>\n     <p> <strong>Camera trước:</strong></p>\n     <p> <strong>Chip: </strong></p>\n     <p> <strong>RAM:</strong></p>\n     <p> <strong>Dung lượng lưu trữ:</strong></p>\n     <p> <strong>SIM:</strong></p>\n     <p> <strong>Pin, Sạc:</strong></p>\n    </div>\n    <div class=\"col-md-7\" >\n     <p >OLED6.1\"Super Retina XDR</p>\n	 <p >Màu đen</p>\n     <p>Oppo oce 2x</p>\n     <p>2 camera 50 MP</p>\n     <p>128 MP</p>\n     <p>Oppo pin</p>\n     <p>20 GB</p>\n     <p>1 TB gb</p>\n     <p>2 Nano SIM </p>\n     <p>10240 mAh18 W</p>\n    </div>',0.05,8050,1),(30,'oppo-reno-8t',21550000,'oppo-reno8t.jpg','2022-01-21',1,30,3,'<p><strong>Màn hình :</strong></p><p><strong>Màu sắc :</strong></p><p><strong>Hệ điều hành:</strong></p><p><strong>Camera sau:</strong></p><p><strong>Camera trước:</strong></p><p><strong>Chip:</strong></p><p><strong>RAM:</strong></p><p><strong>Dung lượng lưu trữ:</strong></p><p><strong>SIM:</strong></p><p><strong>Pin, Sạc:</strong></p><p>OLED6.1\"Super Retina XDR</p><p>Màu hồng</p><p>Oppo oce 2x</p><p>2 camera 50 MP</p><p>128 MP</p><p>Oppo pin</p><p>20 GB</p><p>1 TB gb</p><p>2 Nano SIM</p><p>10240 mAh18 W</p>',0,8050,1),(40,'biên ',22,'Samsung-Galaxy-A13-cam-thumb-600x600.jpg','2023-03-27',1,22,1,'<ul><li><strong>Màu sắc : &nbsp;&nbsp;</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;đen&nbsp;</li><li><strong>Kích thước :</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 250</li><li><strong>ngày tạo : &nbsp;&nbsp;</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 22/12/2020</li><li><strong>Màu sắc : &nbsp;&nbsp;</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;đen&nbsp;</li><li><strong>Kích thước :</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 250</li><li><strong>ngày tạo : &nbsp;&nbsp;</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 22/12/2020</li><li><strong>Màu sắc : &nbsp;&nbsp;</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;đen&nbsp;</li><li><strong>Kích thước :</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 250</li><li><strong>ngày tạo : &nbsp;&nbsp;</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;22/12/2020</li></ul>',0,22,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `activated` tinyint(1) DEFAULT '0',
  `admin` tinyint(1) DEFAULT '0',
  `reset_password_token` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'$2a$10$OIAjiVEq0tJTr0Rl5a3blO/.SYtm8iKcj1z2sunQX/HaeVObv1gCy','Nguyen van bien',857973867,'nguyenbien@gmail.com','user.jpg',1,0,NULL),(3,'$2a$10$KqLJlPAlmI1xkDO./CyTFOHe0DXZ8klXbrEoaANbjUaSqDrc.ZCTy','Bien',857973867,'bienn270@gmail.com','79.jpg',1,0,NULL),(6,'$2a$10$thzZkVrS7VsiWYHuJX.cpu.CqVrENYnWtGwg475rjVstmBymyDLIW','nguyen van bien',857973867,'bien270@gmail.com',NULL,1,1,NULL),(8,'$2a$10$BvFydl15RILHR2P.L6AgZ.Um2DNMVYTq3e6PXpoNVUJF23N0lxlJC','ádf',857973867,'bie@gmail.com',NULL,1,1,NULL),(11,'$2a$10$6JU8qg6Q/w2i9R3HJ855rexKRgcu6iPhyIMDEjJzIze3x6CYtTxxW',NULL,NULL,'bin222@gmail.com',NULL,1,0,NULL),(12,'$2a$10$o8wBJ3r/W/mXvW8tMA9UDu64niCq8s89PAMK.Ys2yhamrz72t/xwO',NULL,NULL,'bienthaibinh@gmail.com',NULL,1,0,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-28 10:24:19
