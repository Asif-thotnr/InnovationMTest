CREATE DATABASE  IF NOT EXISTS `PPS` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `PPS`;
-- MySQL dump 10.13  Distrib 8.0.29
--
-- Host: 127.0.0.1    Database: PPS
-- ------------------------------------------------------


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
-- Table structure for table `Designations`
--

DROP TABLE IF EXISTS `Designations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Designations` (
  `Id` bigint NOT NULL,
  `Designation` varchar(64) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Designation_UNIQUE` (`Designation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Designations`
--

LOCK TABLES `Designations` WRITE;
/*!40000 ALTER TABLE `Designations` DISABLE KEYS */;
INSERT INTO `Designations` VALUES (3,'Architect'),(1,'Software Engineer'),(2,'Sr. Software Engineer');
/*!40000 ALTER TABLE `Designations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `EmpId` varchar(64) NOT NULL,
  `EmpFName` varchar(64) NOT NULL,
  `EmpLName` varchar(64) NOT NULL,
  `DesignationId` bigint NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `EmpId_UNIQUE` (`EmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
INSERT INTO `Employees` VALUES (1,'emp101','Bill','Gates',1),(2,'emp102','Md.','Asif',2),(3,'emp103','Steve','Jobs',3),(4,'emp104','Martin','Fowler',1);
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EventType`
--

DROP TABLE IF EXISTS `EventType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EventType` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Event` varchar(64) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EventType`
--

LOCK TABLES `EventType` WRITE;
/*!40000 ALTER TABLE `EventType` DISABLE KEYS */;
INSERT INTO `EventType` VALUES (1,'ONBOARD'),(2,'SALARY'),(3,'BONUS'),(4,'EXIT'),(5,'REIMBURSEMENT');
/*!40000 ALTER TABLE `EventType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Events`
--

DROP TABLE IF EXISTS `Events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Events` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Sequence` varchar(45) DEFAULT NULL,
  `EmpId` bigint DEFAULT NULL,
  `EventTypeId` bigint DEFAULT NULL,
  `Value` varchar(64) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `Notes` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Events`
--

LOCK TABLES `Events` WRITE;
/*!40000 ALTER TABLE `Events` DISABLE KEYS */;
INSERT INTO `Events` VALUES (1,'101',1,1,'2022-01-01','2022-01-01','Onboarded'),(2,'102',1,2,'5000','2022-02-01','Salary'),(3,'103',2,1,'2022-01-01','2022-01-01','Onboarded'),(4,'104',3,1,'2022-02-01','2022-02-01','Onboarded'),(5,'105',4,1,'2022-03-01','2022-02-01','Onboarded'),(6,'106',2,2,'3000','2022-03-01','Salary'),(7,'107',4,3,'4000','2022-03-01','Bonus'),(8,'108',3,4,'2022-10-01','2022-10-01','Exit'),(9,'109',2,5,'4000','2022-03-01','Reimbur');
/*!40000 ALTER TABLE `Events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-20 20:17:35
