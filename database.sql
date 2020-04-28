-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminId` int NOT NULL AUTO_INCREMENT,
  `adminName` varchar(100) NOT NULL,
  `adminPwd` varchar(20) NOT NULL,
  `phone` int NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'AA','123456',400111111,'abcd@gmail.com'),(2,'BB','abcdef',400222222,'1234@gmail.com'),(3,'CC','abcd1234',400333333,'6666@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allBooks`
--

DROP TABLE IF EXISTS `allBooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allBooks` (
  `bookId` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(100) NOT NULL,
  `price` float(50,2) NOT NULL,
  `bookCounts` int NOT NULL,
  `detail` varchar(300) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `photoAddress` varchar(100) DEFAULT NULL,
  `clickTime` int NOT NULL,
  `department` varchar(100) NOT NULL,
  `adminId` int NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allBooks`
--

LOCK TABLES `allBooks` WRITE;
/*!40000 ALTER TABLE `allBooks` DISABLE KEYS */;
INSERT INTO `allBooks` VALUES (1,'Java',20.00,99,'The book is published by UNSW and the book is about how to learn Java','UNSW Publisher 1','UNSW Author 1','0',0,'COMP0000',1),(2,'Python',25.00,100,'The book is published by UNSW and the book is about how to learn Python','UNSW Publisher 2','UNSW Author 2','0',0,'COMP1111',1),(3,'C',15.00,50,'The book is published by UNSW and the book is about how to learn C','UNSW Publisher 3','UNSW Author 3','0',0,'COMP2222',2),(4,'C++',30.00,60,'The book is published by UNSW and the book is about how to learn C++','UNSW Publisher 4','UNSW Author 4','0',0,'COMP3333',2),(5,'AA',20.00,99,'The book is published by UNSW and the book is about how to learn Java','UNSW Publisher 5','UNSW Author 5','0',0,'COMP4444',1),(6,'BB',25.00,100,'The book is published by UNSW and the book is about how to learn Python','UNSW Publisher 6','UNSW Author 6','0',0,'COMP5555',1),(7,'CC',15.00,50,'The book is published by UNSW and the book is about how to learn C','UNSW Publisher 7','UNSW Author 7','0',0,'COMP6666',2),(8,'DD',30.00,60,'The book is published by UNSW and the book is about how to learn C++','UNSW Publisher 8','UNSW Author 8','0',0,'COMP7777',2),(9,'EE',20.00,99,'The book is published by UNSW and the book is about how to learn Java','UNSW Publisher 9','UNSW Author 9','0',0,'COMP8888',1),(10,'FF',25.00,100,'The book is published by UNSW and the book is about how to learn Python','UNSW Publisher 10','UNSW Author 10','0',0,'COMP9999',1),(11,'GG',15.00,50,'The book is published by UNSW and the book is about how to learn C','UNSW Publisher 11','UNSW Author 11','0',0,'COMP0111',2),(12,'HH',30.00,60,'The book is published by UNSW and the book is about how to learn C++','UNSW Publisher 12','UNSW Author 12','0',0,'COMP0222',2);
/*!40000 ALTER TABLE `allBooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `bookId` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(100) NOT NULL,
  `price` float(50,2) NOT NULL,
  `bookCounts` int NOT NULL,
  `detail` varchar(300) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `photoAddress` varchar(100) DEFAULT NULL,
  `clickTime` int NOT NULL,
  `department` varchar(100) NOT NULL,
  `adminId` int NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Java',20.00,99,'The book is published by UNSW and the book is about how to learn Java','UNSW Publisher 1','UNSW Author 1','0',0,'COMP0000',1),(2,'Python',25.00,100,'The book is published by UNSW and the book is about how to learn Python','UNSW Publisher 2','UNSW Author 2','0',0,'COMP1111',1),(3,'C',15.00,50,'The book is published by UNSW and the book is about how to learn C','UNSW Publisher 3','UNSW Author 3','0',0,'COMP2222',2),(4,'C++',30.00,60,'The book is published by UNSW and the book is about how to learn C++','UNSW Publisher 4','UNSW Author 4','0',0,'COMP3333',2),(5,'AA',20.00,99,'The book is published by UNSW and the book is about how to learn Java','UNSW Publisher 5','UNSW Author 5','0',0,'COMP4444',1),(6,'BB',25.00,100,'The book is published by UNSW and the book is about how to learn Python','UNSW Publisher 6','UNSW Author 6','0',0,'COMP5555',1),(7,'CC',15.00,50,'The book is published by UNSW and the book is about how to learn C','UNSW Publisher 7','UNSW Author 7','0',0,'COMP6666',2),(8,'DD',30.00,60,'The book is published by UNSW and the book is about how to learn C++','UNSW Publisher 8','UNSW Author 8','0',0,'COMP7777',2),(9,'EE',20.00,99,'The book is published by UNSW and the book is about how to learn Java','UNSW Publisher 9','UNSW Author 9','0',0,'COMP8888',1),(10,'FF',25.00,100,'The book is published by UNSW and the book is about how to learn Python','UNSW Publisher 10','UNSW Author 10','0',0,'COMP9999',1),(11,'GG',15.00,50,'The book is published by UNSW and the book is about how to learn C','UNSW Publisher 11','UNSW Author 11','0',0,'COMP0111',2),(12,'HH',30.00,60,'The book is published by UNSW and the book is about how to learn C++','UNSW Publisher 12','UNSW Author 12','0',0,'COMP0222',2);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `zId` int NOT NULL,
  `userName` varchar(100) NOT NULL,
  `userPwd` varchar(20) NOT NULL,
  `phone` int NOT NULL,
  `email` varchar(30) NOT NULL,
  `department` varchar(20) DEFAULT '',
  `address` varchar(100) DEFAULT '',
  `auth` varchar(50) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,5000000,'Rachid','123456',400111111,'abcd@gmail.com','IT','UNSW','user:admin'),(2,5111111,'Yi','abcdef',400222222,'1234@gmail.com','CS','UNSW','user:normal'),(3,5222222,'ABC','abcd1234',400333333,'6666@gmail.com','EE','UNSW','user:normal');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_books`
--

DROP TABLE IF EXISTS `user_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_books` (
  `ubId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `bookId` int NOT NULL,
  `numbers` int NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`ubId`),
  UNIQUE KEY `ubId` (`ubId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_books`
--

LOCK TABLES `user_books` WRITE;
/*!40000 ALTER TABLE `user_books` DISABLE KEYS */;
INSERT INTO `user_books` VALUES (1,1,1,1,'ordered'),(2,1,2,2,'ordered'),(3,2,1,3,'ordered'),(4,3,3,1,'ordered');
/*!40000 ALTER TABLE `user_books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-17 13:46:24
