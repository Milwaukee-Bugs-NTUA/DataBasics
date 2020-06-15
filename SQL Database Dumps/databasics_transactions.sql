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
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `datetime` datetime NOT NULL,
  `card_number` bigint(255) NOT NULL,
  `total_cost` float(7,2) DEFAULT NULL,
  `payment_method` enum('cash','card') NOT NULL,
  `purchased_from` bigint(255) NOT NULL,
  PRIMARY KEY (`datetime`,`card_number`),
  KEY `card_id_idx` (`card_number`),
  KEY `FK_transactions_stores_idx` (`purchased_from`),
  CONSTRAINT `FK_transactions_stores` FOREIGN KEY (`purchased_from`) REFERENCES `stores` (`store_id`),
  CONSTRAINT `card_number` FOREIGN KEY (`card_number`) REFERENCES `users` (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('2018-01-02 19:11:51',1,1829.38,'card',3),('2018-01-02 19:11:51',95,1829.38,'card',3),('2018-01-08 16:41:04',1,1855.86,'cash',6),('2018-01-08 16:41:04',71,1855.86,'cash',6),('2018-01-08 17:15:25',1,178.00,'cash',5),('2018-01-08 17:15:25',12,178.00,'cash',5),('2018-01-16 08:43:15',1,183.80,'card',3),('2018-01-16 08:43:15',45,183.80,'card',3),('2018-01-23 16:55:20',1,178.00,'card',2),('2018-01-23 16:55:20',12,178.00,'card',2),('2018-01-27 08:32:19',1,369.95,'cash',1),('2018-01-27 08:32:19',114,369.95,'cash',1),('2018-01-28 18:51:18',1,230.79,'cash',1),('2018-01-28 18:51:18',96,230.79,'cash',1),('2018-02-01 16:39:56',1,257.90,'cash',9),('2018-02-01 16:39:56',59,257.90,'cash',9),('2018-02-05 18:21:39',1,87.00,'cash',8),('2018-02-05 18:21:39',13,87.00,'cash',8),('2018-02-05 18:58:34',1,175.68,'card',4),('2018-02-05 18:58:34',56,175.68,'card',4),('2018-02-25 17:08:42',1,887.64,'cash',8),('2018-02-25 17:08:42',85,887.64,'cash',8),('2018-03-02 10:41:05',1,136.00,'card',6),('2018-03-02 10:41:05',22,136.00,'card',6),('2018-03-02 19:01:58',1,259.26,'cash',7),('2018-03-02 19:01:58',120,259.26,'cash',7),('2018-03-04 17:05:54',1,170.00,'cash',8),('2018-03-04 17:05:54',18,170.00,'cash',8),('2018-03-12 16:57:23',1,1413.58,'card',2),('2018-03-12 16:57:23',92,1413.58,'card',2),('2018-03-13 18:34:13',1,969.89,'cash',8),('2018-03-13 18:34:13',94,969.89,'cash',8),('2018-03-19 17:58:28',1,702.39,'cash',6),('2018-03-19 17:58:28',93,702.39,'cash',6),('2018-04-05 19:43:39',1,151.84,'cash',5),('2018-04-05 19:43:39',64,151.84,'cash',5),('2018-04-07 17:16:08',1,930.68,'cash',3),('2018-04-07 17:16:08',89,930.68,'cash',3),('2018-04-16 16:00:46',1,150.00,'cash',8),('2018-04-16 16:00:46',65,150.00,'cash',8),('2018-04-25 16:11:54',1,367.16,'cash',7),('2018-04-25 16:11:54',86,367.16,'cash',7),('2018-05-20 07:03:08',1,222.22,'card',10),('2018-05-20 07:03:08',33,222.22,'card',10),('2018-05-24 19:53:26',1,213.52,'cash',5),('2018-05-24 19:53:26',55,213.52,'cash',5),('2018-06-01 07:04:39',1,1413.58,'card',1),('2018-06-01 07:04:39',75,1413.58,'card',1),('2018-06-01 12:29:19',1,233.40,'card',4),('2018-06-01 12:29:19',96,233.40,'card',4),('2018-06-10 07:41:32',1,90.00,'cash',2),('2018-06-10 07:41:32',3,90.00,'cash',2),('2018-06-19 17:38:17',1,79.00,'cash',5),('2018-06-19 17:38:17',23,79.00,'cash',5),('2018-06-21 15:45:18',1,213.99,'card',4),('2018-06-21 15:45:18',109,213.99,'card',4),('2018-06-29 17:05:15',1,208.99,'card',6),('2018-06-29 17:05:15',51,208.99,'card',6),('2018-07-02 18:02:10',1,176.23,'card',1),('2018-07-02 18:02:10',36,176.23,'card',1),('2018-07-18 15:10:57',1,76.32,'cash',9),('2018-07-18 15:10:57',98,76.32,'cash',9),('2018-07-18 15:25:13',1,187.91,'card',7),('2018-07-18 15:25:13',53,187.91,'card',7),('2018-07-24 17:23:01',1,130.00,'card',8),('2018-07-24 17:23:01',27,130.00,'card',8),('2018-08-02 17:14:12',1,313.37,'cash',1),('2018-08-02 17:14:12',100,313.37,'cash',1),('2018-08-09 18:37:32',1,385.19,'card',6),('2018-08-09 18:37:32',77,385.19,'card',6),('2018-08-13 12:31:26',1,176.00,'card',8),('2018-08-13 12:31:26',15,176.00,'card',8),('2018-08-31 18:12:56',1,192.31,'card',8),('2018-08-31 18:12:56',66,192.31,'card',8),('2018-09-29 07:51:07',1,225.99,'cash',3),('2018-09-29 07:51:07',98,225.99,'cash',3),('2018-10-04 19:35:54',1,231.50,'card',1),('2018-10-04 19:35:54',106,231.50,'card',1),('2018-10-14 18:50:39',1,794.83,'cash',9),('2018-10-14 18:50:39',91,794.83,'cash',9),('2018-10-28 08:27:31',1,76.00,'card',6),('2018-10-28 08:27:31',16,76.00,'card',6),('2018-10-31 17:38:55',1,65.00,'card',3),('2018-10-31 17:38:55',24,65.00,'card',3),('2018-11-05 19:47:33',1,114.38,'card',2),('2018-11-05 19:47:33',120,114.38,'card',2),('2018-11-19 16:56:39',1,170.00,'cash',9),('2018-11-19 16:56:39',9,170.00,'cash',9),('2018-11-29 13:58:35',1,830.24,'card',9),('2018-11-29 13:58:35',79,830.24,'card',9),('2018-12-02 14:17:14',1,164.00,'cash',4),('2018-12-02 14:17:14',6,164.00,'cash',4),('2018-12-15 11:32:23',1,215.58,'card',9),('2018-12-15 11:32:23',58,215.58,'card',9),('2018-12-19 07:24:32',1,214.19,'cash',6),('2018-12-19 07:24:32',109,214.19,'cash',6),('2018-12-23 12:34:03',1,385.19,'cash',5),('2018-12-23 12:34:03',76,385.19,'cash',5),('2019-01-06 07:12:08',1,195.10,'card',5),('2019-01-06 07:12:08',33,195.10,'card',5),('2019-01-06 14:21:24',1,1685.40,'cash',8),('2019-01-06 14:21:24',90,1685.40,'cash',8),('2019-01-08 13:08:56',1,1855.86,'cash',7),('2019-01-08 13:08:56',84,1855.86,'cash',7),('2019-01-09 17:54:17',1,171.89,'card',7),('2019-01-09 17:54:17',95,171.89,'card',7),('2019-01-15 08:39:11',1,315.37,'cash',8),('2019-01-15 08:39:11',104,315.37,'cash',8),('2019-02-14 09:07:17',1,257.93,'card',10),('2019-02-14 09:07:17',106,257.93,'card',10),('2019-02-15 07:18:07',1,122.00,'card',6),('2019-02-15 07:18:07',29,122.00,'card',6),('2019-02-21 10:28:58',1,65.00,'card',2),('2019-02-21 10:28:58',24,65.00,'card',2),('2019-02-25 18:00:53',1,158.00,'cash',5),('2019-02-25 18:00:53',29,158.00,'cash',5),('2019-02-28 11:07:25',1,176.00,'cash',4),('2019-02-28 11:07:25',28,176.00,'cash',4),('2019-03-05 11:38:27',1,222.83,'card',2),('2019-03-05 11:38:27',111,222.83,'card',2),('2019-03-29 09:49:19',1,857.52,'card',3),('2019-03-29 09:49:19',79,857.52,'card',3),('2019-04-08 17:13:54',1,209.57,'cash',6),('2019-04-08 17:13:54',42,209.57,'cash',6),('2019-04-21 16:23:31',1,152.00,'card',10),('2019-04-21 16:23:31',26,152.00,'card',10),('2019-05-02 16:40:04',1,159.29,'cash',3),('2019-05-02 16:40:04',47,159.29,'cash',3),('2019-05-23 17:11:07',1,943.29,'cash',4),('2019-05-23 17:11:07',76,943.29,'cash',4),('2019-05-26 16:54:50',1,118.61,'cash',8),('2019-05-26 16:54:50',102,118.61,'cash',8),('2019-05-29 15:04:30',1,270.49,'cash',4),('2019-05-29 15:04:30',100,270.49,'cash',4),('2019-06-09 07:09:09',1,1237.20,'cash',8),('2019-06-09 07:09:09',90,1237.20,'cash',8),('2019-06-17 16:57:36',1,234.44,'card',2),('2019-06-17 16:57:36',45,234.44,'card',2),('2019-06-20 17:40:20',1,188.78,'cash',3),('2019-06-20 17:40:20',68,188.78,'cash',3),('2019-06-23 08:16:31',1,1685.40,'cash',5),('2019-06-23 08:16:31',70,1685.40,'cash',5),('2019-06-27 17:32:22',1,202.31,'card',3),('2019-06-27 17:32:22',47,202.31,'card',3),('2019-07-16 10:18:38',1,1237.20,'card',6),('2019-07-16 10:18:38',93,1237.20,'card',6),('2019-07-18 19:21:40',1,1046.26,'card',1),('2019-07-18 19:21:40',86,1046.26,'card',1),('2019-07-19 12:12:46',1,367.16,'cash',6),('2019-07-19 12:12:46',94,367.16,'cash',6),('2019-07-19 16:16:25',1,99.20,'card',10),('2019-07-19 16:16:25',33,99.20,'card',10),('2019-07-19 16:52:31',1,146.92,'cash',9),('2019-07-19 16:52:31',104,146.92,'cash',9),('2019-07-30 07:09:25',1,176.00,'cash',9),('2019-07-30 07:09:25',25,176.00,'cash',9),('2019-08-10 12:19:53',1,218.43,'card',5),('2019-08-10 12:19:53',50,218.43,'card',5),('2019-08-11 07:14:18',1,134.00,'card',2),('2019-08-11 07:14:18',26,134.00,'card',2),('2019-08-11 19:59:59',1,954.72,'cash',1),('2019-08-11 19:59:59',71,954.72,'cash',1),('2019-08-16 08:18:39',1,188.01,'card',5),('2019-08-16 08:18:39',53,188.01,'card',5),('2019-08-24 13:44:08',1,706.79,'card',6),('2019-08-24 13:44:08',76,706.79,'card',6),('2019-09-20 12:30:33',1,90.00,'cash',8),('2019-09-20 12:30:33',26,90.00,'cash',8),('2019-09-21 16:37:14',1,192.33,'cash',7),('2019-09-21 16:37:14',37,192.33,'cash',7),('2019-09-26 13:38:03',1,213.23,'card',4),('2019-09-26 13:38:03',95,213.23,'card',4),('2019-09-27 14:57:39',1,88.00,'cash',9),('2019-09-27 14:57:39',5,88.00,'cash',9),('2019-10-24 18:48:25',1,200.16,'card',8),('2019-10-24 18:48:25',99,200.16,'card',8),('2019-11-04 15:59:22',1,136.00,'card',8),('2019-11-04 15:59:22',11,136.00,'card',8),('2019-11-08 08:51:18',1,234.22,'cash',5),('2019-11-08 08:51:18',118,234.22,'cash',5),('2019-11-12 13:06:58',1,126.51,'cash',4),('2019-11-12 13:06:58',99,126.51,'cash',4),('2019-11-14 11:33:27',1,205.54,'card',7),('2019-11-14 11:33:27',111,205.54,'card',7),('2019-11-19 15:50:31',1,173.29,'card',9),('2019-11-19 15:50:31',35,173.29,'card',9),('2019-11-24 10:04:46',1,1399.44,'card',9),('2019-11-24 10:04:46',77,1399.44,'card',9),('2019-11-25 14:49:51',1,229.25,'card',10),('2019-11-25 14:49:51',103,229.25,'card',10),('2019-11-26 07:18:35',1,161.91,'card',1),('2019-11-26 07:18:35',54,161.91,'card',1),('2019-12-07 18:37:33',1,90.00,'cash',2),('2019-12-07 18:37:33',26,90.00,'cash',2),('2019-12-15 08:28:17',1,79.00,'card',2),('2019-12-15 08:28:17',14,79.00,'card',2),('2019-12-23 11:26:09',1,205.22,'card',8),('2019-12-23 11:26:09',114,205.22,'card',8),('2019-12-24 12:54:07',1,164.98,'cash',5),('2019-12-24 12:54:07',38,164.98,'cash',5),('2020-01-02 19:11:51',1,1829.38,'card',3),('2020-01-02 19:11:51',95,1829.38,'card',3),('2020-01-06 07:12:08',1,195.10,'card',5),('2020-01-06 07:12:08',33,195.10,'card',5),('2020-01-06 14:21:24',1,1685.40,'cash',8),('2020-01-06 14:21:24',90,1685.40,'cash',8),('2020-01-08 13:08:56',1,1855.86,'cash',7),('2020-01-08 13:08:56',84,1855.86,'cash',7),('2020-01-08 16:41:04',1,1855.86,'cash',6),('2020-01-08 16:41:04',71,1855.86,'cash',6),('2020-01-08 17:15:25',1,178.00,'cash',5),('2020-01-08 17:15:25',12,178.00,'cash',5),('2020-01-09 17:54:17',1,171.89,'card',7),('2020-01-09 17:54:17',95,171.89,'card',7),('2020-01-15 08:39:11',1,315.37,'cash',8),('2020-01-15 08:39:11',104,315.37,'cash',8),('2020-01-16 08:43:15',1,183.80,'card',3),('2020-01-16 08:43:15',45,183.80,'card',3),('2020-01-23 16:55:20',1,178.00,'card',2),('2020-01-23 16:55:20',12,178.00,'card',2),('2020-01-27 08:32:19',1,369.95,'cash',1),('2020-01-27 08:32:19',114,369.95,'cash',1),('2020-01-28 18:51:18',1,230.79,'cash',1),('2020-01-28 18:51:18',96,230.79,'cash',1),('2020-02-01 16:39:56',1,257.90,'cash',9),('2020-02-01 16:39:56',59,257.90,'cash',9),('2020-02-05 18:21:39',1,87.00,'cash',8),('2020-02-05 18:21:39',13,87.00,'cash',8),('2020-02-05 18:58:34',1,175.68,'card',4),('2020-02-05 18:58:34',56,175.68,'card',4),('2020-02-14 09:07:17',1,257.93,'card',10),('2020-02-14 09:07:17',106,257.93,'card',10),('2020-02-15 07:18:07',1,122.00,'card',6),('2020-02-15 07:18:07',29,122.00,'card',6),('2020-02-21 10:28:58',1,65.00,'card',2),('2020-02-21 10:28:58',24,65.00,'card',2),('2020-02-25 17:08:42',1,887.64,'cash',8),('2020-02-25 17:08:42',85,887.64,'cash',8),('2020-02-25 18:00:53',1,158.00,'cash',5),('2020-02-25 18:00:53',29,158.00,'cash',5),('2020-02-28 11:07:25',1,176.00,'cash',4),('2020-02-28 11:07:25',28,176.00,'cash',4),('2020-03-02 10:41:05',1,136.00,'card',6),('2020-03-02 10:41:05',22,136.00,'card',6),('2020-03-02 19:01:58',1,259.26,'cash',7),('2020-03-02 19:01:58',120,259.26,'cash',7),('2020-03-04 17:05:54',1,170.00,'cash',8),('2020-03-04 17:05:54',18,170.00,'cash',8),('2020-03-05 11:38:27',1,222.83,'card',2),('2020-03-05 11:38:27',111,222.83,'card',2),('2020-03-12 16:57:23',1,1413.58,'card',2),('2020-03-12 16:57:23',92,1413.58,'card',2),('2020-03-13 18:34:13',1,969.89,'cash',8),('2020-03-13 18:34:13',94,969.89,'cash',8),('2020-03-19 17:58:28',1,702.39,'cash',6),('2020-03-19 17:58:28',93,702.39,'cash',6),('2020-03-29 09:49:19',1,857.52,'card',3),('2020-03-29 09:49:19',79,857.52,'card',3),('2020-04-05 19:43:39',1,151.84,'cash',5),('2020-04-05 19:43:39',64,151.84,'cash',5),('2020-04-07 17:16:08',1,930.68,'cash',3),('2020-04-07 17:16:08',89,930.68,'cash',3),('2020-04-08 17:13:54',1,209.57,'cash',6),('2020-04-08 17:13:54',42,209.57,'cash',6),('2020-04-16 16:00:46',1,150.00,'cash',8),('2020-04-16 16:00:46',65,150.00,'cash',8),('2020-04-21 16:23:31',1,152.00,'card',10),('2020-04-21 16:23:31',26,152.00,'card',10),('2020-04-25 16:11:54',1,367.16,'cash',7),('2020-04-25 16:11:54',86,367.16,'cash',7),('2020-05-02 16:40:04',1,159.29,'cash',3),('2020-05-02 16:40:04',47,159.29,'cash',3),('2020-05-20 07:03:08',1,222.22,'card',10),('2020-05-20 07:03:08',33,222.22,'card',10),('2020-05-23 17:11:07',1,943.29,'cash',4),('2020-05-23 17:11:07',76,943.29,'cash',4),('2020-05-24 19:53:26',1,213.52,'cash',5),('2020-05-24 19:53:26',55,213.52,'cash',5),('2020-05-26 16:54:50',1,118.61,'cash',8),('2020-05-26 16:54:50',102,118.61,'cash',8),('2020-05-29 15:04:30',1,270.49,'cash',4),('2020-05-29 15:04:30',100,270.49,'cash',4),('2020-06-01 07:04:39',1,1413.58,'card',1),('2020-06-01 07:04:39',75,1413.58,'card',1),('2020-06-01 12:29:19',1,233.40,'card',4),('2020-06-01 12:29:19',96,233.40,'card',4),('2020-06-09 07:09:09',1,1237.20,'cash',8),('2020-06-09 07:09:09',90,1237.20,'cash',8),('2020-06-10 07:41:32',1,90.00,'cash',2),('2020-06-10 07:41:32',3,90.00,'cash',2);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-14 21:10:03
