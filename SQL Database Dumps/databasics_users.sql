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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `card_number` bigint(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `sex` enum('male','female','other') NOT NULL,
  `address_street` varchar(50) NOT NULL,
  `address_number` int(10) NOT NULL,
  `address_postal_code` varchar(50) NOT NULL,
  `address_city` varchar(50) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `marital_status` enum('single','married','divorced','in_relationship') NOT NULL,
  `number_of_children` int(11) NOT NULL,
  `points` int(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`card_number`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ac.metus.vitae@at.net','Robert','Mcfadden','1975-12-07','male','3 Septembriou',31,'27639','Acharnes','30-711-244-9250','single',4,752),(2,'enim.sit.amet@Donec.edu','Leroy','Dawson','1960-12-14','male',' Adrianou',16,'3404',' Agia Paraskevi','30-244-121-4056','married',4,79),(3,'elit@placerat.net','Jerome','Peterson','1962-08-12','male',' Agiou Konstantinou',30,'78-861',' Agia Varvara','30-704-740-8437','in_relationship',0,507),(4,'a.magna@blanditNamnulla.co.uk','Leroy','Benton','1974-09-25','male',' Aiolou',69,'3306',' Agioi Anargyroi','30-276-376-9264','divorced',2,598),(5,'Donec.vitae@vestibulumlorem.org','Burton','Puckett','1976-04-10','male',' Akadimias',27,'40113',' Agios Dimitrios','30-548-402-7937','single',4,447),(6,'Curabitur@nullamagna.ca','Lucas','Harper','1977-07-01','male',' Alexandras Avenue',47,'2392',' Agios Ioannis Rentis','30-295-619-9245','married',0,806),(7,'amet.dapibus.id@Nunclaoreet.org','Nehru','Crosby','1960-03-27','male',' Amalias Avenue',47,'41112',' Agios Konstantinos','30-388-688-9113','in_relationship',1,989),(8,'In@pellentesqueSed.co.uk','Bruce','Lynch','1966-11-21','male',' Antigonis',92,'75800',' Agios Stefanos','30-637-454-2269','divorced',2,350),(9,'ornare@leoVivamusnibh.ca','Zachary','Roth','1976-07-10','male',' Aristeidou',44,'1352',' Aigaleo','30-299-784-1461','single',0,465),(10,'pulvinar.arcu@dignissimlacus.org','Drew','Moreno','1962-03-09','male',' Athanasiou Diakou',45,'1884',' Alimos','30-896-268-6337','married',0,929),(11,'pellentesque@pulvinararcuet.com','Gary','Yates','1974-05-28','male',' Athinas',80,'57611',' Amarousio','30-175-395-9727','in_relationship',3,578),(12,'parturient.montes@eget.edu','Magee','Franks','1967-03-04','male',' Athinon Avenue',87,'275964',' Anavyssos','30-801-668-9303','divorced',3,64),(13,'dui.nec@metusInlorem.com','Adam','Jefferson','1966-04-01','male',' Benaki',10,'199304',' Ano Liosia','30-154-351-9950','single',2,390),(14,'Sed@utlacus.co.uk','Chancellor','Craft','1975-11-11','male',' Chalkokondyli',19,'3783',' Anoixi','30-654-115-7837','married',4,714),(15,'eu.enim@eusem.com','Zeus','Hinton','1961-05-02','male',' Dionysiou Areopagitou',90,'97677',' Argyroupoli','30-791-839-6672','in_relationship',0,665),(16,'velit.Sed@nequeIn.com','Chancellor','Mejia','1967-01-28','male',' Dragatsanou',59,'5701 VS',' Artemida','30-472-619-1917','divorced',4,8),(17,'vestibulum.massa@nuncidenim.com','Phillip','Garrison','1974-07-01','male',' Eupolidos',5,'8563',' Aspropyrgos','30-315-967-6699','single',4,165),(18,'non.lacinia@aliquet.net','Reece','Pollard','1962-01-09','male',' Ermou',56,'771363',' Athens','30-384-141-2659','married',3,75),(19,'et.nunc.Quisque@temporarcuVestibulum.ca','Arsenio','Bennett','1965-06-18','male',' Evripidou',92,'6026',' Avlonas','30-253-372-7328','in_relationship',1,850),(20,'mauris@nislQuisque.org','Clayton','Chapman','1978-06-16','male',' Eynardou',77,'1576',' Chaidari','30-272-752-5352','divorced',1,424),(21,'Donec.porttitor@ad.net','Gloria','Stone','1976-10-15','female','Eynardou',26,'36158-056','Chaidari','30-384-269-0473','single',4,441),(22,'Mauris.blandit@augueSedmolestie.ca','Paloma','Wolf','1975-04-18','female',' Filopimenos',62,'Z8742',' Chalandri','30-740-510-4748','married',1,398),(23,'consequat@lorem.net','Ann','Bond','1974-12-09','female',' Herodou Attikou',27,'8677 NB',' Cholargos','30-600-147-7723','divorced',4,542),(24,'turpis.Aliquam.adipiscing@molestietellusAenean.com','Sara','Boyer','1968-06-28','female',' Hymittou',71,'29758',' Dafni','30-779-422-2622','in_relationship',4,12),(25,'nisl.Nulla.eu@ante.net','Keiko','Carpenter','1970-05-31','female',' Iera Odos',73,'86473',' Dionysos','30-845-310-6069','single',0,828),(26,'viverra.Maecenas@nonummyFusce.edu','Kaitlin','Cooper','1971-01-16','female',' Ioanninon',81,'Z9726',' Drapetsona','30-568-400-9214','married',1,935),(27,'hendrerit@ornare.com','Aretha','Hodges','1977-07-28','female',' Kifissias Avenue',75,'263481',' Drosia','30-437-200-3479','divorced',1,84),(28,'Proin@loremsit.com','Shay','Peck','1965-04-07','female',' Kolokotroni',6,'Z8864',' Ekali','30-887-471-3433','in_relationship',0,908),(29,'magna.a@tincidunt.ca','Lillian','Fowler','1964-05-20','female',' Konstantinoupoleos Avenue',69,'225522',' Eleusis','30-269-190-0988','single',3,461),(30,'Morbi@sociosqu.org','Ella','Beasley','1968-04-26','female',' Lada',1,'6582',' Elliniko','30-434-425-3032','married',1,800),(31,'Quisque.ac.libero@egettincidunt.net','Winifred','Griffin','1972-05-30','female',' Lampsakou',75,'4513 DP',' Erythres','30-464-276-1767','divorced',4,821),(32,'Curabitur.dictum.Phasellus@et.net','Inez','Silva','1966-12-27','female',' Larissis',17,'1585',' Filothei','30-113-378-1968','in_relationship',3,410),(33,'nisi@viverra.com','Olivia','Sanders','1969-05-06','female',' Lenormant',24,'2470',' Galatsi','30-399-790-6994','single',3,761),(34,'In.mi.pede@porttitor.net','Remedios','Hancock','1966-09-07','female',' Edouardou Law',54,'85573',' Gerakas','30-681-346-8104','married',2,251),(35,'in@ligula.org','Freya','Garrison','1969-05-30','female',' Lykourgou',64,'469209',' Glyfada','30-304-638-2147','divorced',1,139),(36,'Nulla.facilisi.Sed@sollicitudin.co.uk','Justina','Lyons','1977-11-24','female',' Mavrokordatou',42,'29903',' Glyka Nera','30-304-973-8114','in_relationship',4,244),(37,'Fusce.mi@parturientmontesnascetur.co.uk','Maryam','Gates','1967-12-12','female',' Marni',71,'47849',' Grammatiko','30-506-949-6507','single',0,983),(38,'ultrices.posuere@purus.edu','Ivory','Horn','1973-08-25','female',' Menandrou',24,'31622',' Ilion','30-601-767-1652','married',4,332),(39,'convallis.in.cursus@idnuncinterdum.edu','Raya','Buck','1971-11-14','female',' Mesogeion Avenue',20,'39300',' Ilioupoli','30-173-565-8881','divorced',1,859),(40,'vulputate.lacus.Cras@malesuada.net','Leah','Morrow','1977-06-20','female',' Miltiadou',63,'8977',' Irakleio','30-665-156-0248','in_relationship',2,197),(41,'lobortis@enimcommodo.com','Nathan','Nguyen','1952-02-24','male','Omirou',36,'0058','Kalamos','30-755-839-5106','single',4,524),(42,'bibendum.Donec.felis@sit.ca','Magee','Carey','1950-06-09','male',' Palamidiou',37,'8014',' Kallithea','30-588-846-4725','married',1,255),(43,'augue.ut@erat.edu','Nicholas','Sutton','1959-03-23','male',' Pandrossou',76,'36-148',' Kalyvia Thorikou','30-594-903-1042','divorced',4,427),(44,'enim@atauctorullamcorper.com','Richard','Fields','1955-05-16','male',' Panepistimiou',95,'738568',' Kamatero','30-470-812-9815','in_relationship',1,139),(45,'magna@lobortisClassaptent.net','Patrick','Sparks','1951-06-12','male',' Paparrigopoulou',96,'33156',' Kapandriti','30-312-208-6823','single',3,418),(46,'neque.venenatis@cursus.net','Jermaine','Evans','1953-04-04','male',' Pelopida',70,'38822',' Keratea','30-752-947-7130','married',4,261),(47,'elit.pretium.et@anequeNullam.co.uk','Gray','Dodson','1956-03-11','male',' Peiraios',31,'325762',' Keratsini','30-122-603-6427','divorced',4,25),(48,'eros.turpis.non@maurisblanditmattis.com','Hector','Adkins','1960-11-07','male',' Pesmazoglou',10,'38328',' Kifisia','30-674-141-2528','in_relationship',3,825),(49,'mollis.dui.in@dictumPhasellus.org','Cole','Simon','1953-11-19','male',' Petrou Ralli',71,'809706',' Korydallos','30-590-662-6682','single',3,867),(50,'et@Aliquamrutrum.ca','Tarik','Prince','1957-01-14','male',' Rizari',43,'241815',' Kouvaras','30-779-770-8396','married',3,269),(51,'massa.Vestibulum.accumsan@elementumloremut.net','Cain','Turner','1960-03-27','male',' Santaroza',36,'6392',' Kropia','30-225-388-2185','divorced',1,90),(52,'erat@acorciUt.co.uk','Philip','Malone','1955-12-24','male',' Sepolion',43,'745370',' Kryoneri','30-785-877-4272','in_relationship',1,483),(53,'tincidunt.dui.augue@Maurismolestiepharetra.co.uk','Samson','Skinner','1958-01-16','male',' Sofokleous',7,'46157',' Lavreotiki','30-392-728-8565','single',4,585),(54,'Proin.eget@Nullamscelerisque.ca','Uriel','Lowery','1954-06-09','male',' Stadiou',7,'622885',' Lykovrysi','30-782-515-8039','married',4,89),(55,'scelerisque@nislarcuiaculis.org','Marsden','Silva','1959-06-20','male',' Stavrou',10,'2865',' Magoula','30-331-554-8126','divorced',4,474),(56,'dictum.cursus.Nunc@tortordictumeu.co.uk','Julian','Shannon','1950-03-06','male',' Andrea Syngrou Avenue',26,'C0Z 0J0',' Malakasa','30-659-683-7202','in_relationship',4,181),(57,'Nullam@diamatpretium.com','Wesley','Lang','1953-07-21','male',' Vasilissis Sofias Avenue',44,'1525',' Mandra','30-292-726-2844','single',1,202),(58,'eu@malesuadaInteger.edu','Kevin','Cervantes','1960-11-03','male',' Vasileos Pavlou Avenue',93,'502668',' Marathon','30-818-507-3096','married',2,132),(59,'nunc.In.at@natoquepenatibuset.org','Bevis','Villarreal','1956-03-08','male',' Voreou',3,'947617',' Markopoulo Mesoaias','30-733-158-5540','divorced',0,671),(60,'lobortis@actellus.com','Hamilton','Guzman','1959-01-10','male',' Voukourestiou',1,'72850',' Markopoulo Oropou','30-966-895-1832','in_relationship',4,212),(61,'pede.Nunc.sed@tristiqueac.net','Hope','Patrick','1952-05-01','female','Panepistimiou',6,'44109','Megara','30-224-924-5729','single',0,78),(62,'imperdiet.nec@fermentum.ca','Alexa','Campos','1954-12-19','female',' Paparrigopoulou',90,'339244',' Melissia','30-267-759-3868','married',0,448),(63,'aliquet.Phasellus@commodo.org','Lareina','Davidson','1958-06-13','female',' Pelopida',36,'B9H 6R0',' Metamorfosi','30-576-329-2334','divorced',4,340),(64,'Nam@euismod.ca','Vivian','Macias','1952-09-02','female',' Peiraios',89,'16311-979',' Moschato','30-487-225-2423','in_relationship',0,32),(65,'sed.sem@laciniaorciconsectetuer.ca','Regan','Simmons','1954-12-27','female',' Pesmazoglou',62,'898232',' Nea Chalkidona','30-312-259-2228','single',4,325),(66,'purus.ac.tellus@Proin.com','Kay','Cummings','1955-02-02','female',' Petrou Ralli',46,'2662',' Nea Erythraia','30-460-545-5268','married',2,156),(67,'dictum.Proin@imperdiet.org','Heidi','Hatfield','1954-09-28','female',' Rizari',36,'31800',' Nea Filadelfeia','30-552-555-8876','divorced',0,871),(68,'sit.amet@Aliquamnec.edu','Moana','Morton','1960-04-14','female',' Santaroza',89,'77367',' Nea Ionia','30-261-287-5246','in_relationship',4,379),(69,'ornare.Fusce@sed.com','Natalie','Harrell','1950-03-30','female',' Sepolion',38,'269108',' Nea Makri','30-910-272-0128','single',2,943),(70,'natoque@Sed.co.uk','Ingrid','Maddox','1959-04-16','female',' Sofokleous',48,'94995',' Nea Palatia','30-833-891-4687','married',3,199),(71,'metus@suscipit.ca','Sarah','Burt','1951-08-15','female',' Stadiou',33,'27633',' Nea Penteli','30-381-968-6209','divorced',0,766),(72,'id.sapien@Cumsociis.com','Kristen','Patterson','1953-06-03','female',' Stavrou',98,'430904',' Nea Peramos','30-484-685-5906','in_relationship',2,284),(73,'lacus.Quisque@nequeseddictum.ca','Serina','Mcpherson','1955-01-15','female',' Andrea Syngrou Avenue',83,'60415-404',' Nea Smyrni','30-394-791-7304','single',4,325),(74,'Sed@facilisislorem.com','Dahlia','Wyatt','1954-11-10','female',' Vasilissis Sofias Avenue',34,'90600',' Neo Psychiko','30-400-100-3539','married',1,250),(75,'magna.Cras@tortordictumeu.com','Orli','Bentley','1951-08-27','female',' Vasileos Pavlou Avenue',49,'6338',' Nikaia','30-429-512-5055','divorced',3,714),(76,'ac@ligulaAliquamerat.edu','Astra','Velasquez','1959-01-16','female',' Voreou',58,'17054',' Oinoi','30-327-615-1432','in_relationship',3,640),(77,'ultricies.sem@magnaa.ca','Cora','Walls','1953-08-26','female',' Voukourestiou',44,'19858-33265',' Oropos','30-318-718-3879','single',4,557),(78,'feugiat@lacusNullatincidunt.com','Tana','Juarez','1951-12-15','female',' Vouliagmenis Avenue',56,'485288',' Paiania','30-727-242-8054','married',4,266),(79,'odio@iderat.co.uk','Kameko','Ware','1954-09-10','female',' Vyssis',38,'8158',' Palaio Faliro','30-987-936-4727','divorced',4,917),(80,'gravida.non@malesuadautsem.org','Venus','Marks','1950-03-22','female','Panepistimiou',12,'591240',' Pallini','30-384-370-9255','in_relationship',3,751),(81,'in@dictumeleifendnunc.ca','Marvin','Norman','2000-12-11','male',' Paparrigopoulou',8,'Z2111',' Melissia','30-278-287-2822','married',0,810),(82,'morbi.tristique.senectus@malesuada.edu','Xanthus','Herring','2001-09-23','male',' Vasilissis Sofias Avenue',87,'31114',' Neo Psychiko','30-581-931-4836','married',0,860),(83,'enim.Curabitur@egestaslacinia.ca','Cole','Blair','1992-12-09','male','Filopimenos',57,'97441-009','Papagou','30-791-102-6928','single',0,15),(84,'Suspendisse.commodo@a.com','Abel','Benton','1982-11-21','male',' Herodou Attikou',9,'Z0210',' Pefki','30-329-243-1692','in_relationship',0,872),(85,'turpis.vitae.purus@sapienCrasdolor.org','Evan','Riley','1984-11-15','male',' Hymittou',13,'4370',' Penteli','30-190-432-3507','single',0,702),(86,'accumsan.interdum.libero@nibhenimgravida.ca','Brendan','Burris','1989-03-15','male',' Iera Odos',18,'97224',' Perama','30-607-101-8551','in_relationship',0,770),(87,'a.sollicitudin@maurisSuspendissealiquet.net','Harlan','Molina','1988-02-21','male',' Ioanninon',27,'33213',' Peristeri','30-363-890-6176','single',0,764),(88,'vestibulum.lorem.sit@Fuscealiquam.org','Chase','Cabrera','2000-06-17','male',' Kifissias Avenue',43,'20096',' Petroupoli','30-787-916-8805','in_relationship',0,503),(89,'elit.pellentesque@purusDuis.net','Oleg','Holman','1993-02-22','male',' Kolokotroni',24,'9316',' Pikermi','30-832-717-2532','single',0,623),(90,'elit.erat@lacusUt.ca','Dylan','Hawkins','2000-10-10','male',' Konstantinoupoleos Avenue',1,'1023 SF',' Piraeus','30-793-371-5015','in_relationship',0,574),(91,'diam@cubiliaCuraeDonec.ca','Kane','Roth','1986-03-05','male',' Lada',7,'70-520',' Polydendri','30-132-471-3011','single',0,700),(92,'Sed.id.risus@MaurismagnaDuis.edu','Jonah','Lara','1991-06-18','male',' Lampsakou',92,'92331-48682',' Psychiko','30-611-303-7881','in_relationship',0,877),(93,'a.ultricies@sitametlorem.net','Malcolm','Erickson','1992-07-31','male',' Larissis',41,'09250',' Rafina','30-148-621-1036','single',0,199),(94,'a@in.co.uk','Ryder','Dawson','1988-09-21','male',' Lenormant',78,'8977 VG',' Saronida','30-868-794-7998','in_relationship',0,582),(95,'sit@Vestibulumante.com','Kelly','Delaney','1985-10-16','male',' Edouardou Law',15,'A4M 6A5',' Tavros','30-791-638-2378','single',0,126),(96,'ac@interdumligula.com','Conan','Larsen','1988-12-29','male',' Lykourgou',67,'Z5652',' Thrakomakedones','30-274-710-7347','in_relationship',0,426),(97,'Cum.sociis@enimSuspendisse.org','Patrick','Montoya','1994-08-01','male',' Mavrokordatou',63,'48367-762',' Vari','30-962-375-9594','single',0,996),(98,'fermentum.metus@magnanecquam.co.uk','Francis','Ferguson','2001-05-14','male',' Marni',12,'774600',' Voula','30-292-894-7898','in_relationship',0,445),(99,'pede@quispede.org','Hop','Dorsey','1991-09-19','male',' Menandrou',34,'73631-833',' Vouliagmeni','30-143-847-8053','single',0,932),(100,'at.auctor@Nunc.edu','Ross','Wheeler','2000-09-18','male',' Mesogeion Avenue',27,'31104',' Vrilissia','30-244-259-3639','in_relationship',0,299),(101,'semper@arcuiaculisenim.com','Fitzgerald','Rich','1998-08-02','male',' Miltiadou',52,'109392',' Vyronas','30-989-319-5235','single',0,313),(102,'nunc@Phasellusataugue.com','Wyatt','Mooney','1997-09-26','male',' Mitropoleos',29,'02961',' Zografou','30-861-590-7968','in_relationship',0,533),(103,'sodales@enimSednulla.ca','Wynter','Butler','2000-08-16','female','3 Septembriou',69,'167324','Acharnes','30-234-380-5853','single',0,302),(104,'cursus.luctus@quisaccumsanconvallis.co.uk','Sade','Mitchell','1995-01-26','female',' Adrianou',53,'3248',' Agia Paraskevi','30-810-317-4825','in_relationship',0,14),(105,'mi@sapienmolestie.com','Irma','Herring','1981-11-20','female',' Agiou Konstantinou',79,'4347',' Agia Varvara','30-534-139-4565','single',0,701),(106,'tellus.imperdiet.non@etmagnisdis.net','Quon','Key','1983-01-01','female',' Aiolou',62,'3504 MK',' Agioi Anargyroi','30-966-114-8280','in_relationship',0,139),(107,'vel.sapien.imperdiet@sociosqu.ca','Adara','Merritt','1990-06-07','female',' Akadimias',95,'94924',' Agios Dimitrios','30-118-214-5896','single',0,443),(108,'elit@amagna.com','Kiona','Gaines','1998-05-24','female',' Alexandras Avenue',42,'156517',' Agios Ioannis Rentis','30-875-308-4821','in_relationship',0,921),(109,'erat.Vivamus@luctusutpellentesque.ca','Indigo','Atkinson','1986-02-20','female',' Amalias Avenue',2,'609142',' Agios Konstantinos','30-447-747-8656','single',0,611),(110,'volutpat.Nulla@ultriciesligula.edu','Katell','Johns','1985-02-20','female',' Antigonis',55,'87819-130',' Agios Stefanos','30-614-476-7115','in_relationship',0,718),(111,'Suspendisse.ac.metus@urnanec.co.uk','Buffy','Warren','1982-12-17','female',' Aristeidou',73,'7973',' Aigaleo','30-351-430-3827','single',0,380),(112,'Sed.nec.metus@facilisiSedneque.co.uk','Jada','Gillespie','1992-02-29','female',' Athanasiou Diakou',60,'3140',' Alimos','30-701-707-2253','in_relationship',0,168),(113,'Aliquam.ornare@adlitora.edu','Winifred','Blevins','2001-01-30','female',' Athinas',33,'8536',' Amarousio','30-283-497-6255','single',0,907),(114,'lacus@eu.com','Astra','Shepard','1995-01-09','female',' Athinon Avenue',83,'48977',' Anavyssos','30-333-911-2278','in_relationship',0,667),(115,'non.egestas.a@metuseu.ca','Katell','Maxwell','1989-07-27','female',' Benaki',80,'5680',' Ano Liosia','30-621-221-8591','single',0,914),(116,'molestie@fringillamilacinia.org','Noelle','Pollard','1988-11-23','female',' Chalkokondyli',77,'Z5348',' Anoixi','30-359-107-3658','in_relationship',0,561),(117,'vulputate.posuere@turpisIncondimentum.ca','Bianca','Padilla','1995-10-16','female',' Dionysiou Areopagitou',20,'M5B 4E9',' Argyroupoli','30-424-290-6898','single',0,441),(118,'arcu.Vestibulum.ante@nonquamPellentesque.net','Aurora','Guy','1988-01-04','female',' Dragatsanou',74,'B5R 5N6',' Artemida','30-499-104-0439','in_relationship',0,836),(119,'tristique.pharetra.Quisque@duiFusce.co.uk','Leah','Byrd','1998-12-22','female',' Eupolidos',25,'033388',' Aspropyrgos','30-417-201-8141','single',0,293),(120,'tellus.faucibus@eget.co.uk','Freya','Cotton','1992-07-17','female',' Ermou',28,'8837',' Athens','30-904-943-1151','in_relationship',0,35),(121,'tincidunt@massalobortis.edu','Inga','Washington','1990-07-14','female',' Evripidou',70,'301264',' Avlonas','30-207-410-1514','single',0,566),(122,'ipsum@facilisisvitaeorci.com','Myra','Simon','1982-05-07','female',' Eynardou',88,'09862',' Chaidari','30-207-742-3140','in_relationship',0,908);
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

-- Dump completed on 2020-06-07 19:32:07
