-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lsed_db
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `CardId` int(11) NOT NULL AUTO_INCREMENT,
  `USER_UserId` int(11) NOT NULL,
  `Title` varchar(64) NOT NULL,
  `DateCreated` date NOT NULL,
  `DateModified` date NOT NULL,
  `Description` varchar(320) DEFAULT NULL,
  `ImageLink` varchar(256) NOT NULL,
  `EmbedLink` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`CardId`,`USER_UserId`),
  KEY `fk_CARD_USER1_idx` (`USER_UserId`),
  CONSTRAINT `fk_CARD_USER1` FOREIGN KEY (`USER_UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,1,'How to make a paper airplane','2015-07-14','2015-07-15','Making a paper airplane','http://awanaincoloradosprings.org/wp-content/uploads/2013/09/paper-airplane-2.jpg','http://www.samplelink.com'),(2,3,'How to make a peanut butter and jelly sandwich','2015-07-12','2015-07-14','Making a peanut butter and jelly sandwich','http://www.dailystormer.com/wp-content/uploads/2013/11/peanut-butter-jelly-sandwich.png','http://www.anothersite.org'),(3,3,'How to make origami','2015-07-12','2015-07-13','Making a paper bird','http://s3.amazonaws.com/rapgenius/1366326727_Origami-crane.jpg','http://www.google.com'),(4,2,'How to make a paper box','2015-07-22','2015-07-22','Making a paper box','http://www.google.com/image.jpg','http://www.google.com');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_category`
--

DROP TABLE IF EXISTS `card_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card_category` (
  `CardCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_CategoryId` int(11) NOT NULL,
  `CARD_CardId` int(11) NOT NULL,
  `CARD_USER_UserId` int(11) NOT NULL,
  PRIMARY KEY (`CardCategoryId`,`CATEGORY_CategoryId`,`CARD_CardId`,`CARD_USER_UserId`),
  KEY `fk_CARD_CATEGORY_CATEGORY1_idx` (`CATEGORY_CategoryId`),
  KEY `fk_CARD_CATEGORY_CARD1_idx` (`CARD_CardId`,`CARD_USER_UserId`),
  CONSTRAINT `fk_CARD_CATEGORY_CARD1` FOREIGN KEY (`CARD_CardId`, `CARD_USER_UserId`) REFERENCES `card` (`CardId`, `USER_UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CARD_CATEGORY_CATEGORY1` FOREIGN KEY (`CATEGORY_CategoryId`) REFERENCES `category` (`CategoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_category`
--

LOCK TABLES `card_category` WRITE;
/*!40000 ALTER TABLE `card_category` DISABLE KEYS */;
INSERT INTO `card_category` VALUES (1,1,2,3),(2,2,1,1),(4,2,3,3);
/*!40000 ALTER TABLE `card_category` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_prerequisite`
--

LOCK TABLES `card_prerequisite` WRITE;
/*!40000 ALTER TABLE `card_prerequisite` DISABLE KEYS */;
INSERT INTO `card_prerequisite` VALUES (1,1,1,1),(5,3,3,1),(3,2,3,2),(4,2,3,3),(2,2,3,4);
/*!40000 ALTER TABLE `card_prerequisite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `CategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(32) NOT NULL,
  PRIMARY KEY (`CategoryId`),
  UNIQUE KEY `Category_UNIQUE` (`Category`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Cooking'),(2,'Origami');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prerequisite`
--

DROP TABLE IF EXISTS `prerequisite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prerequisite` (
  `PrerequisiteId` int(11) NOT NULL AUTO_INCREMENT,
  `Prerequisite` varchar(128) NOT NULL,
  PRIMARY KEY (`PrerequisiteId`),
  UNIQUE KEY `Prerequisite_UNIQUE` (`Prerequisite`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prerequisite`
--

LOCK TABLES `prerequisite` WRITE;
/*!40000 ALTER TABLE `prerequisite` DISABLE KEYS */;
INSERT INTO `prerequisite` VALUES (1,'A piece of paper'),(4,'Bread'),(2,'Peanut butter'),(3,'Strawberry Jelly');
/*!40000 ALTER TABLE `prerequisite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(32) NOT NULL,
  `Email` varchar(64) NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ellisong','testmail@aol.com'),(2,'karstend','sampleemail@gmail.com'),(3,'brebnerd','anotheremail@msn.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-22 14:32:33
