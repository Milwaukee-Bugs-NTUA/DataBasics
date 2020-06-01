CREATE DATABASE  IF NOT EXISTS `databasics` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `databasics`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: databasics
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `price_history`
--

DROP TABLE IF EXISTS `price_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_history` (
  `starting_date` datetime NOT NULL,
  `barcode` bigint(255) NOT NULL,
  `ending_date` datetime NOT NULL,
  `old_price` float NOT NULL,
  PRIMARY KEY (`starting_date`,`barcode`),
  KEY `barcode_idx` (`barcode`),
  CONSTRAINT `barcode` FOREIGN KEY (`barcode`) REFERENCES `products` (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_history`
--

LOCK TABLES `price_history` WRITE;
/*!40000 ALTER TABLE `price_history` DISABLE KEYS */;
INSERT INTO `price_history` VALUES ('2018-04-30 00:00:00',2157086,'2019-03-14 00:00:00',824.46),('2018-05-02 00:00:00',2157089,'2019-10-11 00:00:00',556.16),('2018-05-04 00:00:00',2156951,'2019-10-01 00:00:00',2.84),('2018-05-06 00:00:00',2156939,'2019-02-15 00:00:00',5.34),('2018-05-12 00:00:00',2156924,'2019-10-10 00:00:00',2.64),('2018-05-13 00:00:00',2157068,'2019-12-10 00:00:00',688.07),('2018-05-14 00:00:00',2157083,'2020-01-31 00:00:00',864.44),('2018-05-17 00:00:00',2157066,'2019-01-19 00:00:00',667.79),('2018-05-21 00:00:00',2156968,'2019-03-19 00:00:00',4.97),('2018-05-24 00:00:00',2157080,'2019-04-19 00:00:00',401.21),('2018-05-26 00:00:00',2156934,'2019-03-26 00:00:00',2.16),('2018-05-27 00:00:00',2156962,'2020-02-10 00:00:00',5.32),('2018-05-31 00:00:00',2156943,'2019-12-08 00:00:00',3.08),('2018-06-03 00:00:00',2157090,'2020-01-13 00:00:00',800.73),('2018-06-04 00:00:00',2157072,'2020-04-25 00:00:00',706.43),('2018-06-13 00:00:00',2156971,'2019-04-26 00:00:00',4.52),('2018-06-13 00:00:00',2157091,'2019-02-09 00:00:00',641.4),('2018-06-17 00:00:00',2157082,'2019-09-15 00:00:00',822.66),('2018-06-18 00:00:00',2156921,'2020-04-23 00:00:00',1.54),('2018-06-19 00:00:00',2157078,'2019-01-25 00:00:00',634.78),('2018-06-27 00:00:00',2156928,'2019-03-09 00:00:00',5.04),('2018-06-28 00:00:00',2156933,'2019-10-19 00:00:00',0.41),('2018-06-28 00:00:00',2157062,'2019-02-27 00:00:00',598.82),('2018-07-01 00:00:00',2157084,'2019-04-04 00:00:00',428.71),('2018-07-03 00:00:00',2156937,'2019-01-24 00:00:00',4.84),('2018-07-03 00:00:00',2156938,'2019-09-03 00:00:00',3.67),('2018-07-05 00:00:00',2156967,'2019-09-05 00:00:00',5.16),('2018-07-06 00:00:00',2156977,'2019-09-21 00:00:00',4.85),('2018-07-13 00:00:00',2156958,'2019-08-20 00:00:00',4.13),('2018-07-14 00:00:00',2156926,'2019-12-02 00:00:00',4.28),('2018-07-14 00:00:00',2156957,'2019-03-11 00:00:00',2.88),('2018-07-17 00:00:00',2156930,'2019-08-09 00:00:00',1.93),('2018-07-20 00:00:00',2157071,'2019-05-16 00:00:00',892.18),('2018-08-01 00:00:00',2156978,'2019-06-16 00:00:00',3.35),('2018-08-05 00:00:00',2157073,'2019-05-16 00:00:00',404.43),('2018-08-06 00:00:00',2156922,'2019-10-21 00:00:00',5.27),('2018-08-12 00:00:00',2156945,'2019-04-13 00:00:00',3.3),('2018-08-16 00:00:00',2156952,'2019-02-14 00:00:00',5.11),('2018-08-16 00:00:00',2156965,'2019-04-13 00:00:00',5.3),('2018-08-16 00:00:00',2157064,'2019-04-02 00:00:00',746.69),('2018-08-21 00:00:00',2156972,'2019-11-18 00:00:00',2.75),('2018-08-22 00:00:00',2157088,'2019-05-14 00:00:00',444.72),('2018-08-23 00:00:00',2156932,'2020-02-08 00:00:00',1.1),('2018-08-23 00:00:00',2156974,'2019-11-26 00:00:00',3.25),('2018-08-25 00:00:00',2156942,'2019-04-10 00:00:00',4.96),('2018-08-27 00:00:00',2156976,'2019-09-12 00:00:00',3.89),('2018-08-30 00:00:00',2156941,'2019-04-16 00:00:00',3.13),('2018-09-01 00:00:00',2156923,'2019-10-30 00:00:00',0.46),('2018-09-04 00:00:00',2156927,'2019-08-13 00:00:00',4.48),('2018-09-10 00:00:00',2157074,'2019-12-29 00:00:00',456.54),('2018-09-10 00:00:00',2157076,'2019-05-03 00:00:00',727.06),('2018-09-12 00:00:00',2156940,'2019-03-09 00:00:00',0.35),('2018-09-14 00:00:00',2156931,'2019-02-23 00:00:00',2.5),('2018-09-14 00:00:00',2156959,'2019-04-06 00:00:00',3.46),('2018-09-18 00:00:00',2156956,'2019-03-03 00:00:00',4.42),('2018-09-19 00:00:00',2156935,'2019-06-11 00:00:00',1.3),('2018-09-21 00:00:00',2156973,'2019-02-11 00:00:00',5.11),('2018-09-24 00:00:00',2157081,'2019-08-10 00:00:00',612.17),('2018-09-30 00:00:00',2157070,'2019-07-17 00:00:00',705.61),('2018-10-02 00:00:00',2156980,'2019-04-05 00:00:00',4.42),('2018-10-04 00:00:00',2156925,'2019-04-16 00:00:00',3.1),('2018-10-05 00:00:00',2156970,'2019-11-10 00:00:00',3.64),('2018-10-06 00:00:00',2157085,'2019-03-19 00:00:00',789.87),('2018-10-13 00:00:00',2156949,'2019-04-22 00:00:00',2.07),('2018-10-21 00:00:00',2157077,'2019-04-26 00:00:00',827.23),('2018-10-22 00:00:00',2156955,'2019-06-20 00:00:00',2.74),('2018-10-24 00:00:00',2157075,'2020-04-17 00:00:00',762.25),('2018-10-27 00:00:00',2156963,'2019-10-31 00:00:00',3.06),('2018-10-29 00:00:00',2156961,'2019-11-16 00:00:00',4.96),('2018-11-01 00:00:00',2156979,'2019-12-14 00:00:00',5.21),('2018-11-03 00:00:00',2157069,'2019-12-16 00:00:00',485.49),('2018-11-06 00:00:00',2157067,'2020-01-08 00:00:00',749.94),('2018-11-17 00:00:00',2156960,'2019-03-07 00:00:00',2.7),('2018-11-17 00:00:00',2156975,'2019-02-20 00:00:00',2.57),('2018-11-21 00:00:00',2156947,'2019-06-27 00:00:00',1.77),('2018-11-22 00:00:00',2156966,'2019-05-18 00:00:00',3.87),('2018-11-23 00:00:00',2156948,'2019-09-21 00:00:00',0.77),('2018-11-26 00:00:00',2156946,'2019-06-15 00:00:00',1.65),('2018-11-26 00:00:00',2156969,'2019-07-21 00:00:00',3.38),('2018-11-28 00:00:00',2156964,'2019-04-24 00:00:00',5.38),('2018-12-02 00:00:00',2156936,'2019-12-03 00:00:00',5.36),('2018-12-05 00:00:00',2157087,'2019-06-01 00:00:00',557.87),('2018-12-06 00:00:00',2156950,'2019-04-24 00:00:00',2.51),('2018-12-13 00:00:00',2156954,'2019-03-06 00:00:00',4.75),('2018-12-20 00:00:00',2157065,'2019-03-05 00:00:00',520.46),('2018-12-26 00:00:00',2156929,'2019-10-06 00:00:00',5.4),('2018-12-26 00:00:00',2157063,'2020-03-24 00:00:00',500.95),('2018-12-27 00:00:00',2156953,'2019-10-01 00:00:00',3.36),('2019-01-04 00:00:00',2156944,'2019-04-27 00:00:00',3.14),('2019-01-08 00:00:00',2157079,'2020-03-21 00:00:00',706.12);
/*!40000 ALTER TABLE `price_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-01 23:47:47
