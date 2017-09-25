/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.6.35 : Database - lms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lms`;

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DEPARTMENT_NAME_UK` (`NAME`),
  UNIQUE KEY `DEPARTMENT_CODE_UK` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `departments` */

insert  into `departments`(`ID`,`CODE`,`NAME`) values 
(1,'D001','Platform Development'),
(2,'D002','Platform Support'),
(3,'D003','Admin'),
(4,'D004','HR'),
(5,'D005','Sourcing'),
(6,'D006','Recruitment'),
(7,'D007','Marketing'),
(8,'D008','Presales'),
(9,'D009','Sales'),
(10,'D010','Accounts'),
(11,'D011','US HR');

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  `GENDER` char(1) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `DEPARTMENT_ID` int(11) NOT NULL,
  `JOINING_DATE` date NOT NULL,
  `RELEAVING_DATE` date DEFAULT NULL,
  `RELEAVING_REASON` text,
  PRIMARY KEY (`ID`),
  KEY `EMP_ROLE_ID_FK` (`ROLE_ID`),
  KEY `DEPARTMENT_ID_FK` (`DEPARTMENT_ID`),
  CONSTRAINT `DEPARTMENT_ID_FK` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `departments` (`ID`),
  CONSTRAINT `EMP_ROLE_ID_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `roles` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `employees` */

insert  into `employees`(`ID`,`NAME`,`GENDER`,`ROLE_ID`,`MANAGER_ID`,`DEPARTMENT_ID`,`JOINING_DATE`,`RELEAVING_DATE`,`RELEAVING_REASON`) values 
(1,'Ragavan','M',1,2,3,'2017-02-27',NULL,NULL),
(2,'Gowtham','M',2,1,3,'2017-03-09',NULL,NULL),
(3,'Akshay','M',3,1,4,'2017-03-14',NULL,NULL),
(4,'Priya','F',4,5,4,'2017-03-31',NULL,NULL),
(5,'Raja','M',5,6,1,'2017-03-14',NULL,NULL),
(6,'Sudharsan','M',6,8,6,'2017-03-13',NULL,NULL),
(7,'Babu','M',7,9,7,'2017-04-02',NULL,NULL),
(8,'GowthamVel','M',8,10,8,'2017-01-12',NULL,NULL),
(9,'Yuvraj','M',9,4,9,'2017-01-01',NULL,NULL),
(10,'Vignesh','M',10,2,10,'2017-02-02',NULL,NULL),
(11,'Pavan','M',11,NULL,4,'2017-02-01',NULL,NULL),
(12,'Aswini','F',4,NULL,4,'2017-03-06',NULL,NULL);

/*Table structure for table `holidays` */

DROP TABLE IF EXISTS `holidays`;

CREATE TABLE `holidays` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `HOLIDAY_DATE` date NOT NULL,
  `HOLIDAY_YEAR` year(4) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `HOLIDAY_NAME_UK` (`NAME`),
  UNIQUE KEY `HOLIDAY_DATE_UK` (`HOLIDAY_DATE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `holidays` */

insert  into `holidays`(`ID`,`NAME`,`HOLIDAY_DATE`,`HOLIDAY_YEAR`) values 
(1,'Pongal','2017-01-13',2017),
(2,'Republic day','2017-01-26',2017),
(3,'Tamil New Year','2017-04-14',2017),
(4,'May day','2017-05-01',2017),
(5,'Independence Day','2017-08-15',2017),
(6,'Ganesh Chaturthi','2017-08-25',2017),
(7,'Pooja Holiday','2017-09-29',2017),
(8,'Gandhi Jayanti','2017-10-02',2017),
(9,'Deepavali','2017-10-18',2017),
(10,'Christmas','2017-12-25',2017);

/*Table structure for table `leave_details` */

DROP TABLE IF EXISTS `leave_details`;

CREATE TABLE `leave_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `LEAVE_TYPE_ID` int(11) NOT NULL,
  `DATE_OF_LEAVE` date NOT NULL,
  `SESSION` char(1) DEFAULT NULL,
  `HANDLED_BY` int(11) DEFAULT NULL,
  `REASON` text NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT '1',
  `DENIED_REASON` text,
  `APPLIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `EMPLOYEE_ID_FK` (`EMPLOYEE_ID`),
  KEY `LEAVE_DETAILS_ID_FK` (`LEAVE_TYPE_ID`),
  KEY `STATUS_FK` (`STATUS`),
  KEY `HANDLED_BY_FK` (`HANDLED_BY`),
  CONSTRAINT `EMPLOYEE_ID_FK` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employees` (`ID`),
  CONSTRAINT `HANDLED_BY_FK` FOREIGN KEY (`HANDLED_BY`) REFERENCES `employees` (`ID`),
  CONSTRAINT `LEAVE_DETAILS_ID_FK` FOREIGN KEY (`LEAVE_TYPE_ID`) REFERENCES `leave_types` (`ID`),
  CONSTRAINT `STATUS_FK` FOREIGN KEY (`STATUS`) REFERENCES `leave_status` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

/*Data for the table `leave_details` */

insert  into `leave_details`(`ID`,`EMPLOYEE_ID`,`LEAVE_TYPE_ID`,`DATE_OF_LEAVE`,`SESSION`,`HANDLED_BY`,`REASON`,`STATUS`,`DENIED_REASON`,`APPLIED_DATE`) values 
(28,7,1,'2017-03-08',NULL,9,'Want 4 days Leave',2,NULL,'2017-03-05 17:51:26'),
(29,7,1,'2017-03-09',NULL,9,'Want 4 days Leave',2,NULL,'2017-03-05 17:51:26'),
(30,7,1,'2017-03-10',NULL,9,'Want 4 days Leave',2,NULL,'2017-03-05 17:51:26'),
(31,7,1,'2017-03-13',NULL,9,'Want 4 days Leave',2,NULL,'2017-03-05 17:51:26'),
(32,7,1,'2017-03-14','A',9,'Want Half Day Leave',2,NULL,'2017-03-05 17:52:03'),
(33,1,1,'2017-03-08',NULL,2,'want 4 days Leave',2,NULL,'2017-03-05 17:56:24'),
(34,1,1,'2017-03-09',NULL,2,'want 4 days Leave',2,NULL,'2017-03-05 17:56:24'),
(35,1,1,'2017-03-10',NULL,2,'want 4 days Leave',2,NULL,'2017-03-05 17:56:24'),
(36,1,1,'2017-03-13',NULL,2,'want 4 days Leave',2,NULL,'2017-03-05 17:56:24'),
(37,1,2,'2017-03-14','A',2,'Want half day leave',2,NULL,'2017-03-05 17:56:51'),
(38,7,1,'2017-03-15',NULL,NULL,'want 4 days leave',2,NULL,'2017-03-05 18:00:24'),
(39,7,2,'2017-03-16','A',NULL,'want leave',2,NULL,'2017-03-05 18:00:55'),
(40,7,3,'2017-05-02',NULL,9,'want leave',3,NULL,'2017-03-06 09:11:40'),
(41,7,3,'2017-05-03',NULL,9,'want leave',3,NULL,'2017-03-06 09:11:40'),
(42,7,3,'2017-05-04',NULL,9,'want leave',3,NULL,'2017-03-06 09:11:40'),
(43,7,3,'2017-05-05',NULL,9,'want leave',3,NULL,'2017-03-06 09:11:40'),
(44,7,3,'2017-03-08',NULL,9,'want leave',4,'take two days leave we have more work to do','2017-03-06 09:48:16'),
(45,7,3,'2017-03-09',NULL,9,'want leave',4,'take two days leave we have more work to do','2017-03-06 09:48:16'),
(46,7,3,'2017-03-10',NULL,9,'want leave',4,'take two days leave we have more work to do','2017-03-06 09:48:16'),
(47,7,3,'2017-03-13',NULL,9,'want leave',4,'take two days leave we have more work to do','2017-03-06 09:48:16'),
(48,7,2,'2017-03-07','A',9,'very sick',4,'Take next day leave you need to complete your work','2017-03-06 11:46:08'),
(49,7,2,'2017-03-07','F',9,'want fn',4,'take two days leave we have more work to do','2017-03-06 11:48:35'),
(50,7,4,'2017-03-08','A',9,'want an',4,'Dont take leave','2017-03-06 11:49:15'),
(51,7,2,'2017-03-14',NULL,9,'want 2 days leave',4,'mudiyathu','2017-03-06 11:50:55'),
(52,7,2,'2017-03-15',NULL,9,'want 2 days leave',4,'mudiyathu','2017-03-06 11:50:55'),
(53,7,2,'2017-03-16',NULL,9,'want 2 days leave',4,'mudiyathu','2017-03-06 11:50:55'),
(54,12,3,'2017-03-07','A',NULL,'fever',2,NULL,'2017-03-06 14:59:56'),
(55,12,3,'2017-03-07','A',NULL,'want leave',1,NULL,'2017-03-06 15:01:14'),
(56,7,1,'2017-03-08',NULL,9,'now',3,NULL,'2017-03-07 14:33:35'),
(57,7,1,'2017-03-09',NULL,9,'now',3,NULL,'2017-03-07 14:33:35'),
(58,7,1,'2017-03-15',NULL,9,'wnt leave',4,'cant approve','2017-03-07 14:39:50'),
(59,7,1,'2017-03-16',NULL,9,'wnt leave',4,'cant approve','2017-03-07 14:39:50'),
(60,1,1,'2017-03-08',NULL,2,'leaves',2,NULL,'2017-03-07 14:47:39'),
(61,1,1,'2017-03-09',NULL,2,'leaves',2,NULL,'2017-03-07 14:47:39'),
(62,1,2,'2017-03-10',NULL,2,'abc',4,'not allowed','2017-03-07 15:55:35'),
(63,1,2,'2017-03-13',NULL,2,'abc',4,'not allowed','2017-03-07 15:55:35'),
(64,1,2,'2017-03-09',NULL,2,'want leave',2,NULL,'2017-03-08 10:29:38'),
(65,1,2,'2017-03-10',NULL,2,'want leave',2,NULL,'2017-03-08 10:29:38'),
(66,1,2,'2017-03-13',NULL,2,'want leave',2,NULL,'2017-03-08 10:29:38'),
(67,1,1,'2017-03-14',NULL,NULL,'want leave',2,NULL,'2017-03-08 10:33:26'),
(68,1,1,'2017-03-09','A',2,'want leave',2,NULL,'2017-03-08 11:01:28'),
(69,1,2,'2017-03-22','A',2,'half',4,'cant take leave','2017-03-09 09:53:36'),
(70,2,4,'2017-03-16',NULL,1,'want leave',3,NULL,'2017-03-09 09:54:13'),
(71,2,4,'2017-03-17',NULL,1,'want leave',3,NULL,'2017-03-09 09:54:13'),
(72,2,4,'2017-03-20',NULL,1,'want leave',3,NULL,'2017-03-09 09:54:13'),
(73,2,4,'2017-03-21',NULL,1,'want leave',3,NULL,'2017-03-09 09:54:13'),
(74,1,1,'2017-03-14','F',2,'Emergency',4,'You have work','2017-03-09 15:27:55'),
(75,7,3,'2017-03-16','A',9,'al;saskd',4,'rejected','2017-03-10 11:31:13'),
(76,1,3,'2017-03-14','A',NULL,'diojfoisdjfs',2,NULL,'2017-03-10 11:38:19');

/*Table structure for table `leave_policy` */

DROP TABLE IF EXISTS `leave_policy`;

CREATE TABLE `leave_policy` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POLICY_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `LEAVE_TYPE_ID` int(11) NOT NULL,
  `NO_OF_DAYS` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MULTIPLE_KEY_UK` (`POLICY_ID`,`ROLE_ID`,`LEAVE_TYPE_ID`),
  KEY `LEAVE_POLICY_ID_FK` (`POLICY_ID`),
  KEY `LEAVE_POLICY_ROLE_ID_FK` (`ROLE_ID`),
  KEY `LEAVE_POLICY_LEAVE_TYPE_FK` (`LEAVE_TYPE_ID`),
  CONSTRAINT `fk_leave_id` FOREIGN KEY (`LEAVE_TYPE_ID`) REFERENCES `leave_types` (`ID`),
  CONSTRAINT `fk_leave_policy_id` FOREIGN KEY (`POLICY_ID`) REFERENCES `policies` (`ID`),
  CONSTRAINT `fk_leave_role_id` FOREIGN KEY (`ROLE_ID`) REFERENCES `roles` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `leave_policy` */

insert  into `leave_policy`(`ID`,`POLICY_ID`,`ROLE_ID`,`LEAVE_TYPE_ID`,`NO_OF_DAYS`) values 
(1,1,1,2,4),
(2,1,1,3,6),
(3,1,1,1,6),
(4,1,1,5,90),
(5,1,1,6,5),
(6,1,1,4,12),
(7,1,2,2,6),
(8,1,2,3,12),
(9,1,2,1,12),
(10,1,2,5,90),
(11,1,2,6,5),
(12,1,2,4,12),
(13,1,3,2,18),
(14,1,3,3,18),
(15,1,3,1,18),
(16,1,3,5,90),
(17,1,3,6,5),
(18,1,3,4,18),
(19,1,4,2,6),
(20,1,4,3,12),
(21,1,4,1,12),
(22,1,4,5,90),
(23,1,4,6,5),
(24,1,4,4,12),
(25,1,5,2,6),
(26,1,5,3,12),
(27,1,5,1,12),
(28,1,5,5,90),
(29,1,5,6,5),
(30,1,5,4,12),
(31,1,6,2,6),
(32,1,6,3,12),
(33,1,6,1,12),
(34,1,6,5,90),
(35,1,6,6,5),
(36,1,6,4,12),
(37,1,7,2,6),
(38,1,7,3,12),
(39,1,7,1,12),
(40,1,7,5,90),
(41,1,7,6,5),
(42,1,7,4,12),
(43,1,8,2,6),
(44,1,8,3,12),
(45,1,8,1,12),
(46,1,8,5,90),
(47,1,8,6,5),
(48,1,8,4,12),
(49,1,9,2,18),
(50,1,9,3,18),
(51,1,9,1,18),
(52,1,9,5,90),
(53,1,9,6,5),
(54,1,9,4,18),
(55,1,10,2,18),
(56,1,10,3,18),
(57,1,10,1,18),
(58,1,10,5,90),
(59,1,10,6,5),
(60,1,10,4,18);

/*Table structure for table `leave_status` */

DROP TABLE IF EXISTS `leave_status`;

CREATE TABLE `leave_status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LEAVE_STATUS_UK` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `leave_status` */

insert  into `leave_status`(`ID`,`NAME`) values 
(1,'APPLIED'),
(3,'APPROVED'),
(2,'CANCELLED'),
(4,'DECLINED');

/*Table structure for table `leave_types` */

DROP TABLE IF EXISTS `leave_types`;

CREATE TABLE `leave_types` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LEAVE_NAME_UK` (`NAME`),
  UNIQUE KEY `LEAVE_CODE_UK` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `leave_types` */

insert  into `leave_types`(`ID`,`CODE`,`NAME`) values 
(1,'L001','Paid Leave'),
(2,'L002','Casual Leave'),
(3,'L003','Sick Leave'),
(4,'L004','Privileged Leave'),
(5,'L005','Maternity Leave'),
(6,'L006','Paternity Leave');

/*Table structure for table `policies` */

DROP TABLE IF EXISTS `policies`;

CREATE TABLE `policies` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  `POLICY_YEAR` year(4) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `POLICY_NAME_UK` (`NAME`),
  UNIQUE KEY `YEAR_UK` (`POLICY_YEAR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `policies` */

insert  into `policies`(`ID`,`NAME`,`POLICY_YEAR`) values 
(1,'POLICY_2017',2017);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `LEVEL` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UK` (`CODE`),
  UNIQUE KEY `ROLE_NAME_UK` (`NAME`),
  UNIQUE KEY `LEVEL_UK` (`LEVEL`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`ID`,`CODE`,`NAME`,`LEVEL`) values 
(1,'SR001','Trainee',1),
(2,'SR002','Employee',2),
(3,'SR003','Reporting Manager',3),
(4,'SR004','Group Manager',4),
(5,'SR005','Admin',5),
(6,'SR006','Admin Officer',6),
(7,'SR007','HR',7),
(8,'SR008','HR Manager',8),
(9,'SR009','Director',9),
(10,'SR010','Managing Director',10),
(11,'SR011','System Admin',11);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `EMAIL_ID` varchar(30) NOT NULL,
  `PASSWORD` text NOT NULL,
  `ACTIVATION_CODE` varchar(30) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `LAST_LOGIN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `USERS_EMP_ID_FK` (`EMPLOYEE_ID`),
  CONSTRAINT `fk_emp_id` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employees` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`ID`,`EMPLOYEE_ID`,`EMAIL_ID`,`PASSWORD`,`ACTIVATION_CODE`,`IS_ACTIVE`,`LAST_LOGIN`) values 
(1,1,'ragav87@ymail.com','900150983cd24fb0d6963f7d28e17f72','dhfdpgyigyztzhhxmoab',1,'2017-09-25 21:42:46'),
(2,2,'gautamgow@gmail.com','900150983cd24fb0d6963f7d28e17f72','maoytkvheeyjponoezdn',1,'2017-09-25 21:28:17'),
(3,3,'akshay@gmail.com','900150983cd24fb0d6963f7d28e17f72','abc',1,'2017-09-25 21:28:22'),
(4,4,'priya@gmail.com','900150983cd24fb0d6963f7d28e17f72','abc',1,'2017-09-25 21:28:47'),
(5,5,'raja@gmail.com','900150983cd24fb0d6963f7d28e17f72','def',1,'2017-09-25 21:28:50'),
(6,6,'sudharsan@gmail.com','900150983cd24fb0d6963f7d28e17f72','def',1,'2017-09-25 21:29:09'),
(7,7,'babu@gmail.com','900150983cd24fb0d6963f7d28e17f72','def',1,'2017-09-25 21:29:14'),
(8,8,'gowthamvel@gmail.com','900150983cd24fb0d6963f7d28e17f72','def',1,'2017-09-25 21:29:18'),
(9,9,'yuvraj@gmail.com','900150983cd24fb0d6963f7d28e17f72','def',1,'2017-09-25 21:29:23'),
(10,10,'ragavanpv007@gmail.com','900150983cd24fb0d6963f7d28e17f72','efg',1,'2017-09-25 21:29:27'),
(11,11,'pavan@gmail.com','pavan','efg',1,'2017-03-04 14:32:40'),
(12,12,'aswinisnsct@gmail.com','aswini','lkjsfdlkjasdflkj',1,'2017-03-06 14:59:04');

/*Table structure for table `weekend` */

DROP TABLE IF EXISTS `weekend`;

CREATE TABLE `weekend` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DAYNAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DAYNAME_UK` (`DAYNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `weekend` */

insert  into `weekend`(`ID`,`DAYNAME`) values 
(1,'SATURDAY'),
(2,'SUNDAY');

/* Function  structure for function  `FN_CHECK_HOLIDAY` */

/*!50003 DROP FUNCTION IF EXISTS `FN_CHECK_HOLIDAY` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_CHECK_HOLIDAY`(i_date date) RETURNS tinyint(1)
BEGIN
	return IFnull((SELECT false FROM `holidays` WHERE `HOLIDAY_DATE`=i_date),true);
    END */$$
DELIMITER ;

/* Function  structure for function  `FN_CHECK_LEAVE_ALREADY_TAKEN` */

/*!50003 DROP FUNCTION IF EXISTS `FN_CHECK_LEAVE_ALREADY_TAKEN` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_CHECK_LEAVE_ALREADY_TAKEN`(i_emp_id INT,i_leave_date DATE) RETURNS tinyint(1)
BEGIN
    RETURN IFNULL((SELECT FALSE FROM `leave_details` WHERE `EMPLOYEE_ID`=i_emp_id AND `DATE_OF_LEAVE`=i_leave_date AND `STATUS` IN (1,3)),TRUE);
   END */$$
DELIMITER ;

/* Function  structure for function  `FN_CHECK_WEEKEND` */

/*!50003 DROP FUNCTION IF EXISTS `FN_CHECK_WEEKEND` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_CHECK_WEEKEND`(i_date date) RETURNS tinyint(1)
BEGIN
	return IFnull((SELECT false FROM `weekend` WHERE `DAYNAME`=DAYNAME(i_date)),true);
    END */$$
DELIMITER ;

/* Function  structure for function  `FN_GET_EMPLOYEE_LEAVES` */

/*!50003 DROP FUNCTION IF EXISTS `FN_GET_EMPLOYEE_LEAVES` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_GET_EMPLOYEE_LEAVES`(i_employee_id INT) RETURNS varchar(200) CHARSET utf8
BEGIN
   DECLARE l_leave_types INT;
   DECLARE i INT DEFAULT 1;
   DECLARE o_leaves VARCHAR(200);
   DECLARE l_leavetype VARCHAR(200);
   declare result varchar(200);
   SET o_leaves='';
   
   SELECT COUNT(*) INTO l_leave_types FROM `leave_types`;
   WHILE (i<=l_leave_types) DO
   SELECT replace(`NAME`,' ','') INTO l_leavetype FROM `leave_types` WHERE `ID`=i;
   SET o_leaves=CONCAT(o_leaves,'"',l_leavetype,'"',':',(SELECT `FN_REMAINING_LEAVE`(i_employee_id,i)),',');
   SET i=i+1;
   END WHILE;
   set result=substring(o_leaves,1,length(o_leaves)-1);
   set result=concat('{',result,'}');
   RETURN result;
       
  END */$$
DELIMITER ;

/* Function  structure for function  `FN_GET_REMAINING_LEAVES` */

/*!50003 DROP FUNCTION IF EXISTS `FN_GET_REMAINING_LEAVES` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_GET_REMAINING_LEAVES`(i_leave_type_id INT,i_employee_id INT,i_no_of_days FLOAT,i_policy_id INT) RETURNS float
BEGIN
    DECLARE l_role_id INT;
    DECLARE l_total_days INT;
    DECLARE l_taken_full_days INT;
    DECLARE l_taken_half_day INT;
    DECLARE l_year YEAR;
    SELECT `POLICY_YEAR` INTO l_year FROM `policies` WHERE `ID`=i_policy_id;
    SELECT `FN_GET_ROLE_ID`(i_employee_id) INTO l_role_id;
    SELECT `NO_OF_DAYS` INTO l_total_days FROM `leave_policy` WHERE `POLICY_ID`=i_policy_id AND `ROLE_ID`=l_role_id AND `LEAVE_TYPE_ID`=i_leave_type_id;
    SELECT COUNT(*) INTO l_taken_full_days FROM `leave_details` WHERE `EMPLOYEE_ID`=i_employee_id AND YEAR(`DATE_OF_LEAVE`)=l_year AND `LEAVE_TYPE_ID`=i_leave_type_id AND `SESSION` IS NULL AND `STATUS` IN (1,3);
    SELECT COUNT(*) INTO l_taken_half_day FROM `leave_details` WHERE `EMPLOYEE_ID`=i_employee_id AND  YEAR(`DATE_OF_LEAVE`)=l_year AND `LEAVE_TYPE_ID`=i_leave_type_id AND `SESSION` IS NOT NULL AND `STATUS` IN  (1,3);
    RETURN ((l_total_days-(l_taken_full_days+(l_taken_half_day/2)))-i_no_of_days);
END */$$
DELIMITER ;

/* Function  structure for function  `FN_GET_ROLE_ID` */

/*!50003 DROP FUNCTION IF EXISTS `FN_GET_ROLE_ID` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_GET_ROLE_ID`(i_employee_id INT) RETURNS int(11)
BEGIN
	RETURN (SELECT ROLE_ID FROM `employees` WHERE ID=i_employee_id);
    END */$$
DELIMITER ;

/* Function  structure for function  `FN_IS_FUTURE` */

/*!50003 DROP FUNCTION IF EXISTS `FN_IS_FUTURE` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_IS_FUTURE`(i_date date) RETURNS tinyint(1)
BEGIN
	return (select i_date>curdate());
    END */$$
DELIMITER ;

/* Function  structure for function  `FN_REMAINING_LEAVE` */

/*!50003 DROP FUNCTION IF EXISTS `FN_REMAINING_LEAVE` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `FN_REMAINING_LEAVE`(i_employee_id INT,i_leave_type_id INT) RETURNS float
BEGIN
    DECLARE l_total_days INT;
    DECLARE l_taken_full_days INT;
    DECLARE l_taken_half_day INT;
    DECLARE l_role_id INT;
    DECLARE l_year_id INT;
    
    SELECT policies.`ID` INTO l_year_id FROM `policies` WHERE `POLICY_YEAR`=YEAR(NOW());
    SELECT `FN_GET_ROLE_ID`(i_employee_id) INTO l_role_id;
    
    SELECT `NO_OF_DAYS` INTO l_total_days FROM `leave_policy` WHERE `POLICY_ID`=l_year_id AND `ROLE_ID`=l_role_id AND `LEAVE_TYPE_ID`=i_leave_type_id;
    SELECT COUNT(*) INTO l_taken_full_days FROM `leave_details` WHERE `EMPLOYEE_ID`=i_employee_id AND YEAR(`DATE_OF_LEAVE`)=YEAR(NOW()) AND `LEAVE_TYPE_ID`=i_leave_type_id AND `SESSION` IS NULL AND `STATUS` IN (1,3);
    SELECT COUNT(*) INTO l_taken_half_day FROM `leave_details` WHERE `EMPLOYEE_ID`=i_employee_id AND  YEAR(`DATE_OF_LEAVE`)=YEAR(NOW())AND `LEAVE_TYPE_ID`=i_leave_type_id AND `SESSION` IS NOT NULL AND `STATUS` IN (1,3);
    
    RETURN l_total_days-(l_taken_full_days+(l_taken_half_day/2));
    
    
   END */$$
DELIMITER ;

/* Procedure structure for procedure `PR_APPLY_FULLDAY_LEAVE` */

/*!50003 DROP PROCEDURE IF EXISTS  `PR_APPLY_FULLDAY_LEAVE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `PR_APPLY_FULLDAY_LEAVE`(IN i_employee_id INT,IN i_leave_id int, in i_from_date date,in i_to_date date,in i_reason text,out result varchar(50))
BEGIN
	
	declare l_policy_id int;	
	declare l_rem_leave float;
	declare l_date date;
	declare i int default 0;
	declare l_no_of_days int default 0;
	declare l_leave_days INT DEFAULT 0;
	declare l_flag boolean default true;
	declare l_timestamp timestamp;
	
	SELECT DATEDIFF(i_to_date,i_from_date)+1 INTO l_no_of_days;
	SELECT `ID` INTO l_policy_id FROM `policies` WHERE `POLICY_YEAR`=EXTRACT(YEAR FROM i_from_date);
	set l_date=i_from_date;
	
	set l_timestamp=current_timestamp();
	
	while (i<l_no_of_days) do
	IF (FN_IS_FUTURE(l_date)) THEN
	IF (FN_CHECK_LEAVE_ALREADY_TAKEN(i_employee_id,l_date)) THEN
	if (FN_CHECK_HOLIDAY(l_date)) then
	if (FN_CHECK_WEEKEND(l_date)) then
	set l_leave_days=l_leave_days+1;
	end if;
	end if;
	end if;
	END IF;
	SELECT DATE_ADD(l_date,INTERVAL 1 DAY) INTO l_date;
	set i=i+1;
	END while;
	
	SELECT `FN_GET_REMAINING_LEAVES`(i_leave_id,i_employee_id,l_leave_days,l_policy_id) INTO l_rem_leave;
	
	IF (l_rem_leave>=0) THEN 
	SET l_date=i_from_date;
	set i=0;
	
	WHILE (i<l_no_of_days) do
	IF (FN_IS_FUTURE(l_date)) THEN
	IF (FN_CHECK_LEAVE_ALREADY_TAKEN(i_employee_id,l_date)) THEN 
	IF (FN_CHECK_HOLIDAY(l_date)) THEN
	IF (FN_CHECK_WEEKEND(l_date)) THEN
	INSERT INTO `leave_details`(`EMPLOYEE_ID`,`LEAVE_TYPE_ID`,`DATE_OF_LEAVE`,`APPLIED_DATE`,`REASON`) VALUES(i_employee_id,i_leave_id,l_date,l_timestamp,i_reason);
	SET result='Success';
	set l_flag=false;
               
	END IF;
	
	END IF;
	END IF;
	
	end if;
	
	SELECT DATE_ADD(l_date,INTERVAL 1 DAY) INTO l_date;
	set i=i+1;
	end while;
	
	else
	set result='Insufficient leave';
	END IF;
	
	if (l_flag) then
	
	IF (select !(FN_CHECK_LEAVE_ALREADY_TAKEN(i_employee_id,i_from_date))) THEN 
	SET result='Already leave applied .';
	END IF;
	IF (select !(FN_CHECK_HOLIDAY(i_from_date))) THEN
	SET result='Leave not applied.Holiday.';
	END IF;
	IF (select !(FN_CHECK_WEEKEND(i_from_date))) THEN
	set result='Leave not applied.Weekend.';
	end if;
	
	end if;
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `PR_APPLY_FULLDAY_LEAVE_V2` */

/*!50003 DROP PROCEDURE IF EXISTS  `PR_APPLY_FULLDAY_LEAVE_V2` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `PR_APPLY_FULLDAY_LEAVE_V2`(IN i_employee_id INT,IN i_leave_id int, in i_from_date date,in i_to_date date,in i_reason text)
BEGIN
	
	declare l_policy_id int;	
	declare l_rem_leave float;
	declare l_date date;
	declare i int default 0;
	declare l_no_of_days int default 0;
	declare l_leave_days INT DEFAULT 0;
	
	SELECT DATEDIFF(i_to_date,i_from_date)+1 INTO l_no_of_days;
	SELECT `ID` INTO l_policy_id FROM `policies` WHERE `POLICY_YEAR`=EXTRACT(YEAR FROM i_from_date);
	set l_date=i_from_date;
	
	while (i<l_no_of_days) do
	IF (FN_IS_FUTURE(l_date)) THEN
	if (FN_CHECK_HOLIDAY(l_date)) then
	if (FN_CHECK_WEEKEND(l_date)) then
	
	set l_leave_days=l_leave_days+1;
	
	end if;
	end if;
	end if;
	SELECT DATE_ADD(l_date,INTERVAL 1 DAY) INTO l_date;
	set i=i+1;
	END while;
	SELECT `FN_GET_REMAINING_LEAVES`(i_leave_id,i_employee_id,l_leave_days,l_policy_id) INTO l_rem_leave;
	
	IF (l_rem_leave>=0) THEN 
	
	SET l_date=i_from_date;
	set i=0;
	
	WHILE (i<l_no_of_days) do
	IF (FN_IS_FUTURE(l_date)) THEN
	IF (FN_CHECK_HOLIDAY(l_date)) THEN
	IF (FN_CHECK_WEEKEND(l_date)) THEN
	
	INSERT INTO `leave_details`(`EMPLOYEE_ID`,`LEAVE_TYPE_ID`,`DATE_OF_LEAVE`,`APPLIED_DATE`,`REASON`) VALUES(i_employee_id,i_leave_id,l_date,CURDATE(),i_reason);
	
	END IF;
	END IF;
	END IF;	
	
	SELECT DATE_ADD(l_date,INTERVAL 1 DAY) INTO l_date;
	set i=i+1;
	end while;
	
	END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `PR_APPLY_HALFDAY_LEAVE` */

/*!50003 DROP PROCEDURE IF EXISTS  `PR_APPLY_HALFDAY_LEAVE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `PR_APPLY_HALFDAY_LEAVE`(IN i_employee_id INT,IN i_leave_id INT, IN i_leave_date DATE,IN i_session CHAR,IN i_reason TEXT,OUT result VARCHAR(50))
BEGIN
    
    DECLARE l_policy_id INT;
    DECLARE l_rem_leave INT;    
    
    SELECT `ID` INTO l_policy_id FROM `policies` WHERE `POLICY_YEAR`=EXTRACT(YEAR FROM i_leave_date);
    IF (FN_IS_FUTURE(i_leave_date)) THEN
    
    IF (FN_CHECK_LEAVE_ALREADY_TAKEN(i_employee_id,i_leave_date)) THEN
    
    IF (FN_CHECK_HOLIDAY(i_leave_date)) THEN
    
    IF (FN_CHECK_WEEKEND(i_leave_date)) THEN
    
    SELECT `FN_GET_REMAINING_LEAVES`(i_leave_id,i_employee_id,0.5,l_policy_id) INTO l_rem_leave;
    
    IF (l_rem_leave>=0) THEN
    
    INSERT INTO `leave_details`(`EMPLOYEE_ID`,`LEAVE_TYPE_ID`,`DATE_OF_LEAVE`,`APPLIED_DATE`,`SESSION`,`REASON`) VALUES(i_employee_id,i_leave_id,i_leave_date,CURRENT_TIMESTAMP(),i_session,i_reason);
    SET result='Success';
       
       ELSE
    SET result='Insufficient Leave';    
    END IF;
    
    ELSE
    SET result='The applied day falls on weekened';
    END IF;    
    
    ELSE
    SET result='The applied day is a holiday';
    END IF;
    
    ELSE
    SET result='Already leave applied for particular day';
    END IF;
    
    ELSE
    SET result='Enter a future date';
    END IF;
   END */$$
DELIMITER ;

/* Procedure structure for procedure `PR_CANCEL_LEAVE` */

/*!50003 DROP PROCEDURE IF EXISTS  `PR_CANCEL_LEAVE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `PR_CANCEL_LEAVE`(IN i_id int,OUT o_msg text)
BEGIN
	declare l_employee_id int;
	declare l_timestamp timestamp;
	
	select `EMPLOYEE_ID` into l_employee_id from `leave_details` where `ID`=i_id;
	select `APPLIED_TIMESTAMP` into l_timestamp from `leave_details` where `ID`=i_id;
	
	update `leave_details` set `STATUS`=3 WHERE `EMPLOYEE_ID`=l_employee_id and `APPLIED_TIMESTAMP`=l_timestamp and `DATE_OF_LEAVE`>NOW();
	set o_msg='Success';
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `PR_GET_DEPT_NAME` */

/*!50003 DROP PROCEDURE IF EXISTS  `PR_GET_DEPT_NAME` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `PR_GET_DEPT_NAME`(IN i_dept_id int,out o_dept_name varchar(20))
BEGIN
	select `NAME` into o_dept_name from `departments` where `ID`=i_dept_id;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
