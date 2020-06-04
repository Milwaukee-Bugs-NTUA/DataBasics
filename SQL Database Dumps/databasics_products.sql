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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `barcode` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `brand_name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `category` bigint(255) NOT NULL,
  PRIMARY KEY (`barcode`),
  KEY `FK_products_category_idx` (`category`),
  CONSTRAINT `FK_products_categories` FOREIGN KEY (`category`) REFERENCES `product_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2157122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (2156921,'bread','datastore',4.8,1),(2156922,'bread','sanitas',3.58,1),(2156923,'bread','p&q',3.2,1),(2156924,'bread','nestle',0.27,1),(2156925,'bread','basilopoulos',3.64,1),(2156926,'bread','unilever',3.37,1),(2156927,'milk','datastore',2.78,1),(2156928,'milk','sanitas',1.95,1),(2156929,'milk','p&q',3.8,1),(2156930,'milk','nestle',4.93,1),(2156931,'milk','basilopoulos',5.84,1),(2156932,'milk','unilever',5.12,1),(2156933,'tomatos','datastore',2.98,1),(2156934,'tomatos','sanitas',4.32,1),(2156935,'tomatos','p&q',2.5,1),(2156936,'tomatos','nestle',0.23,1),(2156937,'tomatos','basilopoulos',0.19,1),(2156938,'tomatos','unilever',5.46,1),(2156939,'cucumber','datastore',0.5,1),(2156940,'cucumber','sanitas',0.21,1),(2156941,'cucumber','p&q',3.22,1),(2156942,'cucumber','nestle',0.14,1),(2156943,'cucumber','basilopoulos',5.15,1),(2156944,'cucumber','unilever',3.41,1),(2156945,'potatos','datastore',4.41,1),(2156946,'potatos','sanitas',5.48,1),(2156947,'potatos','p&q',4.45,1),(2156948,'potatos','nestle',2.3,1),(2156949,'potatos','basilopoulos',5.74,1),(2156950,'potatos','unilever',2.3,1),(2156951,'peas','datastore',4.13,2),(2156952,'peas','Barba Stathis',2.99,2),(2156953,'peas','Vegeterra',4.28,2),(2156954,'peas','Economy',3.79,2),(2156955,'peas','Basilopoulos',2.78,2),(2156956,'peas','Eklekti Sodia',4.43,2),(2156957,'beans','datastore',4.49,2),(2156958,'beans','Barba Stathis',4.24,2),(2156959,'beans','Vegeterra',2.84,2),(2156960,'beans','Economy',3.94,2),(2156961,'beans','Basilopoulos',4.22,2),(2156962,'beans','Eklekti Sodia',2.87,2),(2156963,'artichoke','datastore',3.14,2),(2156964,'artichoke','Barba Stathis',4.48,2),(2156965,'artichoke','Vegeterra',3.55,2),(2156966,'artichoke','Economy',2.76,2),(2156967,'artichoke','Basilopoulos',3.18,2),(2156968,'artichoke','Eklekti Sodia',2.52,2),(2156969,'cauliflower','datastore',3.46,2),(2156970,'cauliflower','Barba Stathis',4.29,2),(2156971,'cauliflower','Vegeterra',4.47,2),(2156972,'cauliflower','Economy',3.13,2),(2156973,'cauliflower','Basilopoulos',4.25,2),(2156974,'cauliflower','Eklekti Sodia',2.53,2),(2156975,'spinach','datastore',3.6,2),(2156976,'spinach','Barba Stathis',4.91,2),(2156977,'spinach','Vegeterra',2.62,2),(2156978,'spinach','Economy',4.08,2),(2156979,'spinach','Basilopoulos',4.69,2),(2156980,'spinach','Eklekti Sodia',2.67,2),(2156981,'Hogros Sec','datastore',58.17,4),(2156982,'Hogros Sec','Treasury Wine Estates',86.28,4),(2156983,'Hogros Sec','Domaine Evharis',61.45,4),(2156984,'Hogros Sec','Achaia Clauss',13.03,4),(2156985,'Hogros Sec','Kaliga',37.4,4),(2156986,'Hogros Sec','Barefoot',95.62,4),(2156987,'Xamay','datastore',59.2,4),(2156988,'Xamay','Treasury Wine Estates',64.23,4),(2156989,'Xamay','Domaine Evharis',20.02,4),(2156990,'Xamay','Achaia Clauss',79.03,4),(2156991,'Xamay','Kaliga',63.6,4),(2156992,'Xamay','Barefoot',53.37,4),(2156993,'Hame Adamado','datastore',98.97,4),(2156994,'Hame Adamado','Treasury Wine Estates',71.04,4),(2156995,'Hame Adamado','Domaine Evharis',64.07,4),(2156996,'Hame Adamado','Achaia Clauss',17.2,4),(2156997,'Hame Adamado','Kaliga',44.83,4),(2156998,'Hame Adamado','Barefoot',54.62,4),(2156999,'Gruege Granvas','datastore',49.42,4),(2157000,'Gruege Granvas','Treasury Wine Estates',82.88,4),(2157001,'Gruege Granvas','Domaine Evharis',85.3,4),(2157002,'Gruege Granvas','Achaia Clauss',18.84,4),(2157003,'Gruege Granvas','Kaliga',91.15,4),(2157004,'Gruege Granvas','Barefoot',76.35,4),(2157005,'Tremens Acescence','datastore',28.38,4),(2157006,'Tremens Acescence','Treasury Wine Estates',14.21,4),(2157007,'Tremens Acescence','Domaine Evharis',12.95,4),(2157008,'Tremens Acescence','Achaia Clauss',25.4,4),(2157009,'Tremens Acescence','Kaliga',75.28,4),(2157010,'Tremens Acescence','Barefoot',27.63,4),(2157011,'Beer 500 ml.','datastore',5.62,4),(2157012,'Beer 500 ml.','Fisher',5.93,4),(2157013,'Beer 500 ml.','Estrella',4.85,4),(2157014,'Beer 500 ml.','Kaiser',5.16,4),(2157015,'Beer 500 ml.','Mythos',5.07,4),(2157016,'Beer 500 ml.','Amstel',5.88,4),(2157017,'Beer 500 ml.','Fix',5,4),(2157018,'Beer 500 ml.','Alfa',5.18,4),(2157019,'Beer 500 ml.','Heineken',5.78,4),(2157020,'Beer 300 ml.','Korona',5.5,4),(2157021,'Beer 300 ml.','Mac Farland',5.5,4),(2157022,'Beer 500 ml.','Zita',3,4),(2157023,'Beer 300 ml.','datastore',3.61,4),(2157024,'Beer 300 ml.','Fisher',3.86,4),(2157025,'Beer 300 ml.','Estrella',4.41,4),(2157026,'Beer 300 ml.','Kaiser',3.07,4),(2157027,'Beer 300 ml.','Mythos',4.43,4),(2157028,'Beer 300 ml.','Amstel',3.25,4),(2157029,'Beer 300 ml.','Fix',3.92,4),(2157030,'Beer 300 ml.','Alfa',3.83,4),(2157031,'Beer 300 ml.','Heineken',4.08,4),(2157032,'toothpaste','datastore',3.66,5),(2157033,'toothpaste','colgate',5.45,5),(2157034,'toothpaste','p&q',4.69,5),(2157035,'toothpaste','aim',4.09,5),(2157036,'toothpaste','basilopoulos',4,5),(2157037,'toothpaste','unilever',4.5,5),(2157038,'toothbrush','datastore',4.25,5),(2157039,'toothbrush','colgate',4.9,5),(2157040,'toothbrush','p&q',4.56,5),(2157041,'toothbrush','aim',5.34,5),(2157042,'toothbrush','basilopoulos',5.11,5),(2157043,'toothbrush','unilever',5.36,5),(2157044,'toilet paper','datastore',4.65,5),(2157045,'toilet paper','colgate',4.95,5),(2157046,'toilet paper','p&q',4.72,5),(2157047,'toilet paper','aim',4.72,5),(2157048,'toilet paper','basilopoulos',4.32,5),(2157049,'toilet paper','unilever',4.97,5),(2157050,'hair sampoo','datastore',3.88,5),(2157051,'hair sampoo','colgate',4.29,5),(2157052,'hair sampoo','p&q',3.88,5),(2157053,'hair sampoo','aim',4.18,5),(2157054,'hair sampoo','basilopoulos',4.44,5),(2157055,'hair sampoo','unilever',3.54,5),(2157056,'body soap','datastore',4.11,5),(2157057,'body soap','colgate',4.22,5),(2157058,'body soap','p&q',4.56,5),(2157059,'body soap','aim',4.83,5),(2157060,'body soap','basilopoulos',3.5,5),(2157061,'body soap','unilever',4.34,5),(2157062,'stove oven','Bosh',969.89,3),(2157063,'stove oven','Pitsos',618.6,3),(2157064,'stove oven','Siemens',967.78,3),(2157065,'stove oven','Candy',857.52,3),(2157066,'stove oven','Whirlpool',702.39,3),(2157067,'stove oven','Neff',842.7,3),(2157068,'refrigerator','Bosh',523.13,3),(2157069,'refrigerator','Pitsos',443.82,3),(2157070,'refrigerator','Siemens',750.32,3),(2157071,'refrigerator','Candy',508.82,3),(2157072,'refrigerator','Whirlpool',819.58,3),(2157073,'refrigerator','Neff',367.16,3),(2157074,'washing machine','Bosh',706.79,3),(2157075,'washing machine','Pitsos',601.95,3),(2157076,'washing machine','Siemens',699.72,3),(2157077,'washing machine','Candy',954.72,3),(2157078,'washing machine','Whirlpool',794.83,3),(2157079,'washing machine','Neff',556.55,3),(2157080,'dishwasher','Bosh',496.26,3),(2157081,'dishwasher','Pitsos',385.19,3),(2157082,'dishwasher','Siemens',914.69,3),(2157083,'dishwasher','Candy',943.29,3),(2157084,'dishwasher','Whirlpool',465.34,3),(2157085,'dishwasher','Neff',516.41,3),(2157086,'freezer','Bosh',830.24,3),(2157087,'freezer','Pitsos',989.77,3),(2157088,'freezer','Siemens',717.41,3),(2157089,'freezer','Candy',966.45,3),(2157090,'freezer','Whirlpool',927.93,3),(2157091,'freezer','Neff',526.72,3),(2157092,'Dog Dry Food 15kg','AATU',68,6),(2157093,'Dog Dry Food 15kg','PEDIGREE',90,6),(2157094,'Dog Dry Food 15kg','ALMO NATURE',65,6),(2157095,'Dog Dry Food 15kg','AMBROSIA',85,6),(2157096,'Dog Dry Food 15kg','BARKING HEADS',69,6),(2157097,'Dog Dry Food 15kg','BELCANDO',76,6),(2157098,'Dog Dry Food 15kg','ROYAL CANIN',63,6),(2157099,'Dog Dry Food 15kg','BRAVERY',73,6),(2157100,'Dog Dry Food 15kg','BRIT',73,6),(2157101,'Dog Dry Food 15kg','CANAGAN',61,6),(2157102,'Dog Dry Food 15kg','CARNILOVE',70,6),(2157103,'Dog Dry Food 15kg','CIBAU',65,6),(2157104,'Dog Dry Food 15kg','DIBAQ',87,6),(2157105,'Dog Dry Food 15kg','DINGO NATURA SUPER PREMIUM',85,6),(2157106,'Dog Dry Food 15kg','DMF',88,6),(2157107,'Dog Dry Food 15kg','Dr. Clauder\'s Best Choice',85,6),(2157108,'Dog Dry Food 15kg','ECOPET NATURAL',61,6),(2157109,'Dog Dry Food 15kg','EQUILIBRIO',68,6),(2157110,'Dog Dry Food 15kg','EUKANUBA',89,6),(2157111,'Dog Dry Food 15kg','FARMINA',71,6),(2157112,'Dog Dry Food 15kg','FISH4DOGS',61,6),(2157113,'Dog Dry Food 15kg','FLATAZOR',79,6),(2157114,'Dog Dry Food 15kg','GEMON',82,6),(2157115,'Dog Dry Food 15kg','HAPPY DOG',76,6),(2157116,'Dog Dry Food 15kg','N & D',79,6),(2157117,'Dog Dry Food 15kg','HT DOG FOOD',65,6),(2157118,'Dog Dry Food 15kg','JOSERA',67,6),(2157119,'Dog Dry Food 15kg','JOSIDOG',88,6),(2157120,'Dog Dry Food 15kg','LAKY',90,6),(2157121,'Dog Dry Food 15kg','PICART',86,6);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 18:58:26
