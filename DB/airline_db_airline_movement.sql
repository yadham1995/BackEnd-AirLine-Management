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
  `employee_id` bigint DEFAULT NULL,
  `file_type_id` bigint DEFAULT NULL,
  `parent_customer_id` bigint DEFAULT NULL,
  `sales_person_id` bigint DEFAULT NULL,
  `sub_customer_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcv49qkjmjxtjbaa4dwf64x3v3` (`serial_number`),
  UNIQUE KEY `UKqbyreyyabcrj8raidubyxgny6` (`ticket_num`),
  KEY `FKmuskn18t5rlnloqo112vvr7s7` (`carrier_code_id`),
  KEY `FKff2ju9iv3h4l3818sobyn4vww` (`employee_id`),
  KEY `FKplj3a6ah9drq8838bypd4d7ck` (`file_type_id`),
  KEY `FKlaq74gm22evmmtne7a9h3fqm2` (`parent_customer_id`),
  KEY `FK79cwji443vqw4e2k20h7ok67q` (`sales_person_id`),
  KEY `FKgfoghbgg0edl3n687qcoufqfd` (`sub_customer_id`),
  KEY `FK1jnbr2mhguw11i25o494fw2en` (`user_id`),
  CONSTRAINT `FK1jnbr2mhguw11i25o494fw2en` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK79cwji443vqw4e2k20h7ok67q` FOREIGN KEY (`sales_person_id`) REFERENCES `sales_person` (`id`),
  CONSTRAINT `FKff2ju9iv3h4l3818sobyn4vww` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKgfoghbgg0edl3n687qcoufqfd` FOREIGN KEY (`sub_customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKlaq74gm22evmmtne7a9h3fqm2` FOREIGN KEY (`parent_customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKmuskn18t5rlnloqo112vvr7s7` FOREIGN KEY (`carrier_code_id`) REFERENCES `carrier_code` (`id`),
  CONSTRAINT `FKplj3a6ah9drq8838bypd4d7ck` FOREIGN KEY (`file_type_id`) REFERENCES `file_no_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

