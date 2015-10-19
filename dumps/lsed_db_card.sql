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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `CardId` int(11) NOT NULL AUTO_INCREMENT,
  `USER_UserId` int(11) NOT NULL,
  `Title` varchar(64) NOT NULL,
  `DateCreated` datetime NOT NULL,
  `DateModified` datetime NOT NULL,
  `Description` varchar(128) NOT NULL,
  `ImageLink` varchar(256) NOT NULL,
  `Comments` varchar(512) NOT NULL,
  `TimeToComplete` time NOT NULL,
  PRIMARY KEY (`CardId`,`USER_UserId`),
  KEY `fk_CARD_USER1_idx` (`USER_UserId`),
  CONSTRAINT `fk_CARD_USER1` FOREIGN KEY (`USER_UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,1,'Beat a video game','2015-07-28 00:00:00','2015-07-30 00:00:00','How to beat a video game','http://www.aol.com/image.png','','00:00:00'),(2,2,'Throwing a baseball','2014-01-27 00:00:00','2014-02-21 00:00:00','Learn how to throw a baseball','http://www.aol.com/image2.png','','00:00:00'),(3,3,'Drive a ball in golf','2015-06-22 00:00:00','2015-06-24 00:00:00','How to start your first stroke on a hole','http://www.aol.com/image3.png','','00:00:00'),(4,2,'Learn how to play basketball','2015-06-13 00:00:00','2015-06-14 00:00:00','How to shoot hoops in basketball','http://www.aol.com/image4.png','','00:00:00'),(5,4,'Look up your favorite band','2015-07-28 00:00:00','2015-07-30 00:00:00','Learn how to look up your favorite music band','http://www.microsoft.com/insertimagehere.jpg','','00:00:00'),(6,4,'Look up your favorite TV show','2015-07-30 00:00:00','2015-07-31 00:00:00','Look up your favorite TV show','http://www.geico.com/img.jpg','','00:00:00'),(7,2,'How to make a peanut butter and jelly sandwich','2015-08-26 05:14:30','2015-08-29 12:46:15','Make a peanut butter and jelly sandwich','http://www.seriouseats.com/images/20070401istockpbjbeauty.jpg','','00:10:00');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
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
