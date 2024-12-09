-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: airline_db
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `airline_movement`
--

DROP TABLE IF EXISTS `airline_movement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airline_movement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `air_line_ticket_settlement` enum('CASH_AND_CREDIT','CC','CREDIT','Cash') DEFAULT NULL,
  `air_line_ticket_type` enum('ISSUE','REFUND','REISSUE','VOID') DEFAULT NULL,
  `credit_card_no` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `gds` enum('Amadeus','Galileo','Other','Saber','WorldSpan') DEFAULT NULL,
  `iata` varchar(255) DEFAULT NULL,
  `invoice_num` varchar(255) DEFAULT NULL,
  `issue_date` datetime(6) DEFAULT NULL,
  `passenger_name` varchar(255) DEFAULT NULL,
  `pay_form` enum('Cash','Credit') DEFAULT NULL,
  `personal_id` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `saving_amount` decimal(38,2) DEFAULT NULL,
  `saving_reason` varchar(255) DEFAULT NULL,
  `serial_number` int NOT NULL,
  `ticket_form` enum('BSP','STK','VCH') DEFAULT NULL,
  `ticket_num` int NOT NULL,
  `travel_date` datetime(6) DEFAULT NULL,
  `carrier_code_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `employee_id` bigint DEFAULT NULL,
  `file_type_id` bigint DEFAULT NULL,
  `sales_person_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcv49qkjmjxtjbaa4dwf64x3v3` (`serial_number`),
  UNIQUE KEY `UKqbyreyyabcrj8raidubyxgny6` (`ticket_num`),
  KEY `FKmuskn18t5rlnloqo112vvr7s7` (`carrier_code_id`),
  KEY `FKonf0nsms6b7tpsmciiuj1kyvl` (`customer_id`),
  KEY `FKff2ju9iv3h4l3818sobyn4vww` (`employee_id`),
  KEY `FKplj3a6ah9drq8838bypd4d7ck` (`file_type_id`),
  KEY `FK79cwji443vqw4e2k20h7ok67q` (`sales_person_id`),
  KEY `FK1jnbr2mhguw11i25o494fw2en` (`user_id`),
  CONSTRAINT `FK1jnbr2mhguw11i25o494fw2en` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK79cwji443vqw4e2k20h7ok67q` FOREIGN KEY (`sales_person_id`) REFERENCES `sales_person` (`id`),
  CONSTRAINT `FKff2ju9iv3h4l3818sobyn4vww` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKmuskn18t5rlnloqo112vvr7s7` FOREIGN KEY (`carrier_code_id`) REFERENCES `carrier_code` (`id`),
  CONSTRAINT `FKonf0nsms6b7tpsmciiuj1kyvl` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKplj3a6ah9drq8838bypd4d7ck` FOREIGN KEY (`file_type_id`) REFERENCES `file_no_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline_movement`
--

LOCK TABLES `airline_movement` WRITE;
/*!40000 ALTER TABLE `airline_movement` DISABLE KEYS */;
INSERT INTO `airline_movement` VALUES (1,'Cash','ISSUE','4111111111111111','London','Amadeus','1234','INV20241206','2024-11-22 00:00:00.000000','John Doe','Cash','123456789','Urgent','2025-01-15 00:00:00.000000','NYC-LON',200.50,'Special Offer',1234,'BSP',123456,'2024-12-15 00:00:00.000000',1,1,1,1,1,1);
/*!40000 ALTER TABLE `airline_movement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 14:02:51
