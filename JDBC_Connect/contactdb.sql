-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: contactdb
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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `DEPT_ID` int NOT NULL,
  `DEPT_NAME` varchar(255) NOT NULL,
  `DEPT_NO` varchar(20) NOT NULL,
  `LOCATION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DEPT_ID`),
  UNIQUE KEY `DEPT_NO` (`DEPT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (10,'ACCOUNTING','D10','NEW YORK'),(20,'RESEARCH','D20','DALLAS'),(30,'SALES','D30','CHICAGO'),(40,'OPERATIONS','D40','BOSTON ABCEF'),(50,'MARKETING','D50','VIETNAM'),(60,'Human resources','D60','VIETNAM'),(70,'MANAGEMENT','D70','VIETNAM'),(80,'MAINTERNANCE','D80','VIETNAM');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EMP_ID` bigint NOT NULL,
  `EMP_NAME` varchar(50) NOT NULL,
  `EMP_NO` varchar(20) NOT NULL,
  `HIRE_DATE` date NOT NULL,
  `IMAGE` longblob,
  `JOB` varchar(30) NOT NULL,
  `SALARY` float NOT NULL,
  `DEPT_ID` int NOT NULL,
  `MNG_ID` bigint DEFAULT NULL,
  `GRD_ID` int NOT NULL,
  PRIMARY KEY (`EMP_ID`),
  UNIQUE KEY `EMP_NO` (`EMP_NO`),
  KEY `GRD_ID` (`GRD_ID`),
  KEY `FK75C8D6AE269A3C9` (`DEPT_ID`),
  KEY `FK75C8D6AE6106A42` (`EMP_ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`GRD_ID`) REFERENCES `salary_grade` (`GRADE`),
  CONSTRAINT `FK75C8D6AE269A3C9` FOREIGN KEY (`DEPT_ID`) REFERENCES `department` (`DEPT_ID`),
  CONSTRAINT `FK75C8D6AE6106A42` FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (49,'Hung','4144','2020-12-12',NULL,'Dev',30000,80,100,9),(100,'Manh','111','2021-09-09',NULL,'Dev',15000,50,123,3),(123,'Thanh Tuyen','1234','2018-01-22',NULL,'IT Manager',2500,10,321,3),(300,'Hang Nguyen','123321','2018-01-28',NULL,'Senior IT',3000,30,321,4),(321,'Minh Thang','4321','2018-01-28',NULL,'Senior IT',3000,20,321,4),(1000,'Ngoc Ngoc','12121','2020-02-12',NULL,'Lecturer',50000,60,463636,11),(9887,'Huy Truong','12345','1998-01-12',NULL,'Dev',1000,30,321,9),(463636,'The Doanh','345768','2019-01-11',NULL,'Lecturer',2245,40,321,3),(654321,'Pham Thanh','654321','0019-07-11',NULL,'Senior IT',2000,60,321,4);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_grade`
--

DROP TABLE IF EXISTS `salary_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_grade` (
  `GRADE` int NOT NULL,
  `HIGH_SALARY` float NOT NULL,
  `LOW_SALARY` float NOT NULL,
  PRIMARY KEY (`GRADE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_grade`
--

LOCK TABLES `salary_grade` WRITE;
/*!40000 ALTER TABLE `salary_grade` DISABLE KEYS */;
INSERT INTO `salary_grade` VALUES (3,20000,10000),(4,30000,20000),(9,40000,30000),(10,50000,40000),(11,55000,50000),(12,60000,55000);
/*!40000 ALTER TABLE `salary_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timekeeper`
--

DROP TABLE IF EXISTS `timekeeper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timekeeper` (
  `Timekeeper_Id` varchar(36) NOT NULL,
  `Date_Time` datetime NOT NULL,
  `In_Out` char(1) NOT NULL,
  `EMP_ID` bigint NOT NULL,
  PRIMARY KEY (`Timekeeper_Id`),
  KEY `FK744D9BFF6106A42` (`EMP_ID`),
  CONSTRAINT `FK744D9BFF6106A42` FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timekeeper`
--

LOCK TABLES `timekeeper` WRITE;
/*!40000 ALTER TABLE `timekeeper` DISABLE KEYS */;
INSERT INTO `timekeeper` VALUES ('a1','2021-01-07 00:00:00','I',123),('a10','2021-10-08 00:00:00','I',123),('a14','2021-10-10 00:00:00','I',9887),('a2','2021-01-07 00:00:00','I',123),('a3','2021-01-07 00:00:00','I',9887),('a4','2021-01-07 00:00:00','I',463636),('a5','2021-10-07 00:00:00','O',654321),('a7','2021-10-08 00:00:00','I',9887),('a8','2021-10-10 00:00:00','O',321),('a9','2021-10-07 00:00:00','I',321);
/*!40000 ALTER TABLE `timekeeper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-08 15:28:52
