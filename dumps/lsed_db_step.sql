-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: lsed_db
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `step` (
  `StepId` int(11) NOT NULL AUTO_INCREMENT,
  `card_CardId` int(11) NOT NULL,
  `card_USER_UserId` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `TimeToComplete` time NOT NULL,
  `ImageLink` varchar(256) DEFAULT NULL,
  `Description` varchar(512) NOT NULL,
  PRIMARY KEY (`StepId`,`card_CardId`,`card_USER_UserId`),
  KEY `fk_step_card1_idx` (`card_CardId`,`card_USER_UserId`),
  CONSTRAINT `fk_step_card1` FOREIGN KEY (`card_CardId`, `card_USER_UserId`) REFERENCES `card` (`CardId`, `USER_UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step`
--

LOCK TABLES `step` WRITE;
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
INSERT INTO `step` VALUES (1,7,2,1,'00:00:30',NULL,'Place two slices of bread in the toaster'),(2,7,2,2,'00:00:15','http://www.chinatraderonline.com/Files2/2009-10/30/2-slice-electric-toaster-10171592741.jpg','Press the button down on the toaster with the heat setting at maximum'),(3,7,2,3,'00:05:00',NULL,'Wait for the toaster to finish cooking your bread'),(4,7,2,4,'00:00:15',NULL,'When the bread \"pops\" out from the toaster, grab the two slices of bread and place them on a plate'),(5,7,2,5,'00:01:00','http://images.vectorhq.com/images/previews/d72/peanut-butter-on-bread-psd-429934.png','Spread peanut butter on both slices of bread on the side that is towards you'),(6,7,2,6,'00:00:30','http://www.thegreenhead.com/imgs/peanut-butter-jelly-spreader-2.jpg','Spread jelly on one slices on bread on top of the peanut butter'),(7,7,2,7,'00:00:15','https://upload.wikimedia.org/wikipedia/commons/6/6a/Peanut-Butter-Jelly-Sandwich.png','Place both slices of bread together'),(8,7,2,8,'00:00:00','https://wellnessandequality.files.wordpress.com/2013/05/pbandj.jpg','Enjoy!');
/*!40000 ALTER TABLE `step` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-19 13:35:17
