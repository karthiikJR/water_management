-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: water_management
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `areaid` int NOT NULL,
  `aname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`areaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (123,'Kavoor'),(234,'Kankanady'),(321,'Adyar'),(678,'Bejai');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `backendstuffs`
--

DROP TABLE IF EXISTS `backendstuffs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backendstuffs` (
  `a` int NOT NULL,
  `cid` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `newfkcid_idx` (`cid`),
  CONSTRAINT `newfkcid3` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backendstuffs`
--

LOCK TABLES `backendstuffs` WRITE;
/*!40000 ALTER TABLE `backendstuffs` DISABLE KEYS */;
INSERT INTO `backendstuffs` VALUES (28,457,1),(69,123,2),(69,21,3),(30,456,4);
/*!40000 ALTER TABLE `backendstuffs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaints`
--

DROP TABLE IF EXISTS `complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaints` (
  `compid` int NOT NULL AUTO_INCREMENT,
  `custid` int DEFAULT NULL,
  `complain` varchar(45) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`compid`),
  KEY `hahafk_idx` (`custid`),
  CONSTRAINT `hahafk` FOREIGN KEY (`custid`) REFERENCES `customer` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaints`
--

LOCK TABLES `complaints` WRITE;
/*!40000 ALTER TABLE `complaints` DISABLE KEYS */;
INSERT INTO `complaints` VALUES (3,123,'Water Discoloration',1),(5,456,'Pipe Leakage',1),(9,123,'Meter Broken',0),(10,456,'Pipe Leakage Again',1),(11,456,'PIpe Dint Fix',1),(12,456,'Water Discoloration',1),(13,456,'colour\n',0),(34,456,'hi',1),(35,456,'water colour changes',1),(36,456,'water',0),(37,457,'vfgtykkh',0),(39,456,'water color',1);
/*!40000 ALTER TABLE `complaints` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `complaints_BEFORE_INSERT` BEFORE INSERT ON `complaints` FOR EACH ROW BEGIN
SET new.status=0;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cid` int NOT NULL,
  `cname` varchar(45) DEFAULT NULL,
  `areaid` int DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `age` int DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `aidfk_idx` (`areaid`),
  CONSTRAINT `aidfk` FOREIGN KEY (`areaid`) REFERENCES `areas` (`areaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cfk` FOREIGN KEY (`cid`) REFERENCES `login` (`lid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (21,'minaz',234,'Kankanady','1990-12-09',25,'9663566515'),(111,'BBB',123,'Kavoor','2002-03-03',21,'9986123831'),(123,'Mafaz',234,'Kankanady','2002-05-01',21,'7899322469'),(222,'bbb',123,'Kavoor','2002-01-01',21,'9876543212'),(456,'Shreya',678,'Bejai','2002-12-13',21,'7443551501'),(457,'vidya',321,'Adyar','2002-01-12',34,'9663584624'),(555,'BBB',123,'Kavoor','2002-03-03',21,'9876543212'),(787,'anna',321,'Adyar','2010-12-12',23,'1234556789');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `customer_BEFORE_INSERT` BEFORE INSERT ON `customer` FOR EACH ROW BEGIN
IF NOT NEW.phone REGEXP '[0-9]{10}' THEN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT ='Enter valid number!';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `customer_BEFORE_UPDATE` BEFORE UPDATE ON `customer` FOR EACH ROW BEGIN
IF NOT NEW.phone REGEXP '[0-9]{10}' THEN
	SIGNAL SQLSTATE '45000' SET message_text ='Enter valid number';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `lid` int NOT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `ltype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (21,'abcd','User'),(111,'aaa','User'),(123,'ayesha','Admin'),(222,'aaa','User'),(456,'shreya','User'),(457,'samved','User'),(555,'aaa','User'),(787,'qwer','User');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paid_list`
--

DROP TABLE IF EXISTS `paid_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paid_list` (
  `uniq` int NOT NULL AUTO_INCREMENT,
  `no` int NOT NULL,
  `areaid` int NOT NULL,
  `cid` int NOT NULL,
  `pendingdue` int DEFAULT NULL,
  `fine` int DEFAULT '0',
  PRIMARY KEY (`uniq`),
  KEY `aidfk_idx` (`areaid`),
  KEY `nofk_idx` (`no`),
  KEY `cidfk_idx` (`cid`),
  CONSTRAINT `aidfkpl` FOREIGN KEY (`areaid`) REFERENCES `areas` (`areaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cidfk` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nofk` FOREIGN KEY (`no`) REFERENCES `pending_list` (`no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paid_list`
--

LOCK TABLES `paid_list` WRITE;
/*!40000 ALTER TABLE `paid_list` DISABLE KEYS */;
INSERT INTO `paid_list` VALUES (1,4,678,123,1000,0),(4,11,234,123,1000,0),(8,15,321,457,1000,100),(10,17,234,123,3000,0);
/*!40000 ALTER TABLE `paid_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pending_list`
--

DROP TABLE IF EXISTS `pending_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pending_list` (
  `no` int NOT NULL AUTO_INCREMENT,
  `cid` int NOT NULL,
  `areaid` int DEFAULT NULL,
  `pldate` date DEFAULT NULL,
  `pendingbool` int DEFAULT NULL,
  `amount` bigint DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `areafkpend_idx` (`areaid`),
  KEY `cidfkpend` (`cid`),
  CONSTRAINT `areafkpend` FOREIGN KEY (`areaid`) REFERENCES `areas` (`areaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cidfkpend` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending_list`
--

LOCK TABLES `pending_list` WRITE;
/*!40000 ALTER TABLE `pending_list` DISABLE KEYS */;
INSERT INTO `pending_list` VALUES (1,123,678,'2019-01-01',0,5000),(2,123,678,'2020-05-23',0,2000),(3,123,678,'2020-06-18',0,3900),(4,123,678,'2023-01-01',1,NULL),(5,456,234,'2019-05-01',0,5000),(6,456,234,'2020-08-04',0,4000),(7,456,234,'2021-12-13',0,9000),(8,456,234,'2022-02-10',0,15000),(11,123,234,'2023-01-01',1,NULL),(14,456,678,'2023-02-01',0,1000),(15,457,321,'2023-01-28',1,NULL),(17,123,234,'2023-04-04',1,NULL),(18,456,678,'2023-02-10',0,3000);
/*!40000 ALTER TABLE `pending_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'water_management'
--

--
-- Dumping routines for database 'water_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 23:09:57
