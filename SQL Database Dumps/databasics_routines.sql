CREATE DATABASE  IF NOT EXISTS `databasics` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `databasics`;
-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: databasics
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Temporary view structure for view `transactions_category_stores`
--

DROP TABLE IF EXISTS `transactions_category_stores`;
/*!50001 DROP VIEW IF EXISTS `transactions_category_stores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `transactions_category_stores` AS SELECT 
 1 AS `card_number`,
 1 AS `datetime`,
 1 AS `category`,
 1 AS `store_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `users_transactions`
--

DROP TABLE IF EXISTS `users_transactions`;
/*!50001 DROP VIEW IF EXISTS `users_transactions`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `users_transactions` AS SELECT 
 1 AS `card_number`,
 1 AS `email`,
 1 AS `first_name`,
 1 AS `last_name`,
 1 AS `date_of_birth`,
 1 AS `sex`,
 1 AS `address_street`,
 1 AS `address_number`,
 1 AS `address_postal_code`,
 1 AS `address_city`,
 1 AS `phone_number`,
 1 AS `marital_status`,
 1 AS `number_of_children`,
 1 AS `points`,
 1 AS `transaction_datetime`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `transactions_category_stores`
--

/*!50001 DROP VIEW IF EXISTS `transactions_category_stores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `transactions_category_stores` AS select distinct `tr`.`card_number` AS `card_number`,`tr`.`datetime` AS `datetime`,`p`.`category` AS `category`,`st`.`store_id` AS `store_id` from (((`transactions` `tr` join `stores` `st`) join `contains` `c`) join `products` `p`) where ((`tr`.`purchased_from` = `st`.`store_id`) and (`tr`.`datetime` = `c`.`datetime`) and (`tr`.`card_number` = `c`.`card_number`) and (`p`.`barcode` = `c`.`product_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `users_transactions`
--

/*!50001 DROP VIEW IF EXISTS `users_transactions`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `users_transactions` AS select distinct `u`.`card_number` AS `card_number`,`u`.`email` AS `email`,`u`.`first_name` AS `first_name`,`u`.`last_name` AS `last_name`,`u`.`date_of_birth` AS `date_of_birth`,`u`.`sex` AS `sex`,`u`.`address_street` AS `address_street`,`u`.`address_number` AS `address_number`,`u`.`address_postal_code` AS `address_postal_code`,`u`.`address_city` AS `address_city`,`u`.`phone_number` AS `phone_number`,`u`.`marital_status` AS `marital_status`,`u`.`number_of_children` AS `number_of_children`,`u`.`points` AS `points`,`tr`.`datetime` AS `transaction_datetime` from (`users` `u` join `transactions` `tr`) where (`u`.`card_number` = `tr`.`card_number`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping routines for database 'databasics'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 16:28:40
