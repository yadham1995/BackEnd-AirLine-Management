CREATE TABLE `airline_movement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `credit_card_no` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `gds` enum('Amadeus','Galileo','Other','Saber','WorldSpan') DEFAULT NULL,
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
  `travel_date` datetime(6) DEFAULT NULL,
  `carrier_code_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `sales_person_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcv49qkjmjxtjbaa4dwf64x3v3` (`serial_number`),
  KEY `FKmuskn18t5rlnloqo112vvr7s7` (`carrier_code_id`),
  KEY `FKonf0nsms6b7tpsmciiuj1kyvl` (`customer_id`),
  KEY `FK79cwji443vqw4e2k20h7ok67q` (`sales_person_id`),
  KEY `FK1jnbr2mhguw11i25o494fw2en` (`user_id`),
  CONSTRAINT `FK1jnbr2mhguw11i25o494fw2en` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK79cwji443vqw4e2k20h7ok67q` FOREIGN KEY (`sales_person_id`) REFERENCES `sales_person` (`id`),
  CONSTRAINT `FKmuskn18t5rlnloqo112vvr7s7` FOREIGN KEY (`carrier_code_id`) REFERENCES `carrier_code` (`id`),
  CONSTRAINT `FKonf0nsms6b7tpsmciiuj1kyvl` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `carrier_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKicbdcbq4213vllyrigeu140dm` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK114lxb57nwilrwigcoi6nm3ln` (`customer_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sales_person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sales_person_code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKecs2qb68k0vch5mdf1gi4ryq` (`sales_person_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(255) NOT NULL,
  `iata_code` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlqjrcobrh9jc8wpcar64q1bfh` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;












