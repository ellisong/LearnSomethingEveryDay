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
-- Table structure for table `card_prerequisite`
--

DROP TABLE IF EXISTS `card_prerequisite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card_prerequisite` (
  `CardPrerequisiteId` int(11) NOT NULL AUTO_INCREMENT,
  `CARD_CardId` int(11) NOT NULL,
  `CARD_USER_UserId` int(11) NOT NULL,
  `PREREQUISITE_PrerequisiteId` int(11) NOT NULL,
  PRIMARY KEY (`CardPrerequisiteId`,`CARD_CardId`,`CARD_USER_UserId`,`PREREQUISITE_PrerequisiteId`),
  KEY `fk_CARD_PREREQUISITE_CARD1_idx` (`CARD_CardId`,`CARD_USER_UserId`),
  KEY `fk_CARD_PREREQUISITE_PREREQUISITE1_idx` (`PREREQUISITE_PrerequisiteId`),
  CONSTRAINT `fk_CARD_PREREQUISITE_CARD1` FOREIGN KEY (`CARD_CardId`, `CARD_USER_UserId`) REFERENCES `card` (`CardId`, `USER_UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CARD_PREREQUISITE_PREREQUISITE1` FOREIGN KEY (`PREREQUISITE_PrerequisiteId`) REFERENCES `prerequisite` (`PrerequisiteId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_prerequisite`
--

LOCK TABLES `card_prerequisite` WRITE;
/*!40000 ALTER TABLE `card_prerequisite` DISABLE KEYS */;
INSERT INTO `card_prerequisite` VALUES (5,5,4,1),(7,6,4,1),(6,5,4,2),(8,6,4,2),(4,4,2,3),(1,1,1,4),(2,3,3,5),(3,3,3,6),(9,2,2,7);
/*!40000 ALTER TABLE `card_prerequisite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-21 16:15:29
