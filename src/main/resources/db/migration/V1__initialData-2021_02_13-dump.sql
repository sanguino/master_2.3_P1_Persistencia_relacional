CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB;




CREATE TABLE `plane` (
 `id` bigint NOT NULL,
 `flight_hours` bigint DEFAULT NULL,
 `maker` varchar(255) DEFAULT NULL,
 `model` varchar(255) DEFAULT NULL,
 `plate` varchar(255) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO `plane` VALUES (1,5227200000000000,'Airbus','A320','EC-FGE');
INSERT INTO `plane` VALUES (2,12427200000000000,'Boeing','747','EC-UEF');




CREATE TABLE `airport` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO `airport` VALUES (3,'Madrid','MAD','Spain','Barajas');
INSERT INTO `airport` VALUES (4,'Munich','MUC','Germany','Franz Josef Strauss');
INSERT INTO `airport` VALUES (5,'Barcelona','BCN','Spain','El prat');




CREATE TABLE `mechanic` (
    `id` bigint NOT NULL,
    `code` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `surname` varchar(255) DEFAULT NULL,
    `hired_year` int NOT NULL,
    `studies` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO `mechanic` VALUES (6,'hy76rf','Peter','Johnson',2005,'Aeronautical Engineer');
INSERT INTO `mechanic` VALUES (7,'rt91lp','Sandra','Robbert',2019,'Engineer');
INSERT INTO `mechanic` VALUES (8,'xc20ew','Ellie','Peterson',2012,'Mechanic');




CREATE TABLE `flight` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `departure_date_time` datetime(6) DEFAULT NULL,
  `duration` int NOT NULL,
  `destination_airport_id` bigint DEFAULT NULL,
  `origin_airport_id` bigint DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6uc5h994cl1g7yxsvnxkilqbl` (`destination_airport_id`),
  KEY `FKso40hf6mflwfco2iv24gwcwy7` (`origin_airport_id`),
  KEY `FK7p9fvp6d7uh9cgn47uet8a8nb` (`plane_id`),
  CONSTRAINT `FK6uc5h994cl1g7yxsvnxkilqbl` FOREIGN KEY (`destination_airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FK7p9fvp6d7uh9cgn47uet8a8nb` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKso40hf6mflwfco2iv24gwcwy7` FOREIGN KEY (`origin_airport_id`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB;


INSERT INTO `flight` VALUES (9,'LH4323','Lufthansa','2016-04-20 04:30:00.000000',132,3,4,1);
INSERT INTO `flight` VALUES (10,'IB9851','Iberia','2016-04-19 04:30:00.000000',155,4,3,1);
INSERT INTO `flight` VALUES (11,'LH5892','Lufthansa','2016-04-20 10:30:00.000000',176,4,3,1);
INSERT INTO `flight` VALUES (12,'UX3633','Air Europa','2016-04-20 16:00:00.000000',108,4,5,1);
INSERT INTO `flight` VALUES (13,'LH2564','Lufthansa','2016-04-20 05:30:00.000000',123,4,3,1);
INSERT INTO `flight` VALUES (14,'LH3855','Lufthansa','2016-04-21 04:30:00.000000',143,4,3,1);




CREATE TABLE `crew_member` (
   `id` bigint NOT NULL,
   `code` varchar(255) DEFAULT NULL,
   `name` varchar(255) DEFAULT NULL,
   `surname` varchar(255) DEFAULT NULL,
   `company` varchar(255) DEFAULT NULL,
   `position` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO `crew_member` VALUES (15,'hy76rf','John','Smith','Lufthansa','Captain');
INSERT INTO `crew_member` VALUES (16,'uj87fn','Jane','Brown','Iberia','Co-pilot');
INSERT INTO `crew_member` VALUES (17,'tk52fn','Will','Smith','Air Europa','pilot');
INSERT INTO `crew_member` VALUES (18,'ws18fn','Mario','Cart','Lufthansa','Co-pilot');
INSERT INTO `crew_member` VALUES (19,'pd27fn','Xena','Warrior','Iberia','pilot');




CREATE TABLE `flight_crew` (
  `crew_member_id` bigint NOT NULL,
  `flight_id` bigint NOT NULL,
  PRIMARY KEY (`crew_member_id`,`flight_id`),
  KEY `FKdxicgx6j3pmoveat3b67tnj49` (`flight_id`),
  CONSTRAINT `FKc2eyh6mssrxikhpw1l0f578a` FOREIGN KEY (`crew_member_id`) REFERENCES `crew_member` (`id`),
  CONSTRAINT `FKdxicgx6j3pmoveat3b67tnj49` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
) ENGINE=InnoDB;


INSERT INTO `flight_crew` VALUES (15,9);
INSERT INTO `flight_crew` VALUES (16,9);
INSERT INTO `flight_crew` VALUES (17,10);
INSERT INTO `flight_crew` VALUES (18,10);
INSERT INTO `flight_crew` VALUES (15,11);
INSERT INTO `flight_crew` VALUES (19,11);
INSERT INTO `flight_crew` VALUES (16,12);
INSERT INTO `flight_crew` VALUES (19,12);
INSERT INTO `flight_crew` VALUES (17,13);
INSERT INTO `flight_crew` VALUES (18,13);
INSERT INTO `flight_crew` VALUES (16,14);
INSERT INTO `flight_crew` VALUES (18,14);




CREATE TABLE `review` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `init_date` date DEFAULT NULL,
  `time_spent` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `airport_id` bigint DEFAULT NULL,
  `mechanic_id` bigint DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfiifebyp058mg84wscmxrxyyk` (`airport_id`),
  KEY `FKqbvyg26idtfd92sgqpy6h2wt` (`mechanic_id`),
  KEY `FKe1kp6wijwg4mn3979be8uwgjm` (`plane_id`),
  CONSTRAINT `FKe1kp6wijwg4mn3979be8uwgjm` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKfiifebyp058mg84wscmxrxyyk` FOREIGN KEY (`airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKqbvyg26idtfd92sgqpy6h2wt` FOREIGN KEY (`mechanic_id`) REFERENCES `mechanic` (`id`)
) ENGINE=InnoDB;


INSERT INTO `review` VALUES (20,'normal yearly review','2012-02-16','2012-02-14',154800000000000,'yearly review',4,6,1);
INSERT INTO `review` VALUES (21,'yearly avionic review','2015-03-11','2015-03-07',82800000000000,'avionic review',3,7,2);
INSERT INTO `review` VALUES (22,'extra landing review','2018-12-25','2018-12-22',43200000000000,'landing review',4,8,2);
INSERT INTO `review` VALUES (23,'yearly avionic review','2019-04-29','2019-04-28',18000000000000,'avionic review',3,7,1);
INSERT INTO `review` VALUES (24,'extra landing review','2018-07-30','2018-07-27',230400000000000,'landing review',4,6,1);
