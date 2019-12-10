-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: oitolabs
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `asset_details`
--

DROP TABLE IF EXISTS `asset_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_details` (
  `asset_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `asset_key` varchar(20) DEFAULT NULL,
  `product_category_name` varchar(30) DEFAULT NULL,
  `model` varchar(25) DEFAULT NULL,
  `mac_id` varchar(25) DEFAULT NULL,
  `sim_no` varchar(10) DEFAULT NULL,
  `msisdn_no` varchar(10) DEFAULT NULL,
  `enable_status` varchar(10) DEFAULT NULL,
  `updated_id` mediumtext,
  `add_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `employee_details` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`asset_id`),
  UNIQUE KEY `asset_key` (`asset_key`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_details`
--

LOCK TABLES `asset_details` WRITE;
/*!40000 ALTER TABLE `asset_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `asset_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_assignment`
--

DROP TABLE IF EXISTS `device_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_assignment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `asset_id` bigint(20) DEFAULT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `cause` varchar(50) DEFAULT NULL,
  `assign_status` varchar(10) DEFAULT NULL,
  `updated_id` mediumtext,
  `add_date` date DEFAULT NULL,
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `asset_id` (`asset_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `device_assignment_ibfk_1` FOREIGN KEY (`asset_id`) REFERENCES `asset_details` (`asset_id`),
  CONSTRAINT `device_assignment_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employee_details` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_assignment`
--

LOCK TABLES `device_assignment` WRITE;
/*!40000 ALTER TABLE `device_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_details` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_fname` varchar(20) DEFAULT NULL,
  `emp_lname` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `designation` varchar(30) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `mobile_no` varchar(20) DEFAULT NULL,
  `emergency_contact_name` varchar(30) DEFAULT NULL,
  `emergency_contact_no` varchar(20) DEFAULT NULL,
  `health_card_no` varchar(20) DEFAULT NULL,
  `blood_group` varchar(3) DEFAULT NULL,
  `enable_status` varchar(10) DEFAULT NULL,
  `emp_no` varchar(10) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `termination_date` date DEFAULT NULL,
  `emp_image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_no` (`emp_no`),
  UNIQUE KEY `mobile_no` (`mobile_no`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `health_card_no` (`health_card_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
INSERT INTO `employee_details` VALUES (1011,'Balu','Prabhakaran Valsala','balu.prabhakaran@oitolabs.io','admin','1994-12-02','8589003542','','','','','Inactive','',NULL,NULL,'1011.jpg');
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_details`
--

DROP TABLE IF EXISTS `login_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `logout_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `role` varchar(10) DEFAULT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `login_details_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee_details` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_details`
--

LOCK TABLES `login_details` WRITE;
/*!40000 ALTER TABLE `login_details` DISABLE KEYS */;
INSERT INTO `login_details` VALUES (100,'balu.prabhakaran@oitolabs.io','hbGIPbkSyBAHWRW7qqE7Jw==','Active',NULL,NULL,'admin',1011,'',1011);
/*!40000 ALTER TABLE `login_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reimbursement_details`
--

DROP TABLE IF EXISTS `reimbursement_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reimbursement_details` (
  `track_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reimbursement_id` bigint(20) DEFAULT NULL,
  `reimbursement_bill_date` date DEFAULT NULL,
  `reimbursement_description` varchar(100) DEFAULT NULL,
  `reimbursement_bill_no` bigint(20) DEFAULT NULL,
  `reimbursement_cost` double DEFAULT NULL,
  `category_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`track_id`),
  KEY `reimbursement_id` (`reimbursement_id`),
  CONSTRAINT `reimbursement_details_ibfk_1` FOREIGN KEY (`reimbursement_id`) REFERENCES `reimbursement_track` (`reimbursement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reimbursement_details`
--

LOCK TABLES `reimbursement_details` WRITE;
/*!40000 ALTER TABLE `reimbursement_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `reimbursement_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reimbursement_track`
--

DROP TABLE IF EXISTS `reimbursement_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reimbursement_track` (
  `reimbursement_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(20) DEFAULT NULL,
  `reimbursement_date` date DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  PRIMARY KEY (`reimbursement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12350 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reimbursement_track`
--

LOCK TABLES `reimbursement_track` WRITE;
/*!40000 ALTER TABLE `reimbursement_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `reimbursement_track` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09 12:14:43
