/*
SQLyog Community v11.31 Beta1 (64 bit)
MySQL - 5.7.21-log : Database - payrollsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`payrollsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `payrollsystem`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `hourly_rate` double NOT NULL,
  `type` enum('Admin','Regular') DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`emp_id`,`first_name`,`last_name`,`hourly_rate`,`type`) values (1,'John','Doe',10,'Regular'),(2,'admin','admin',20,'Admin'),(3,'Marie','Marie',10,'Regular'),(4,'asd','asd',23.3223,'Regular'),(5,'tes','tes',222,'Regular');

/*Table structure for table `logs` */

DROP TABLE IF EXISTS `logs`;

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `time_in` time DEFAULT NULL,
  `time_out` time DEFAULT NULL,
  `date` date DEFAULT NULL,
  `daily_earning` double DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `empID` (`emp_id`),
  CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `logs` */

insert  into `logs`(`log_id`,`emp_id`,`time_in`,`time_out`,`date`,`daily_earning`) values (1,1,'08:00:00','05:00:00','2018-05-14',100),(2,1,'06:00:00','03:00:00','2018-05-15',100),(3,1,'08:00:00','08:00:00','2018-05-16',100),(4,1,'08:00:00','08:00:00','2018-05-17',100),(5,1,'08:00:00','08:00:00','2018-05-18',100),(6,1,'08:00:00','08:00:00','2018-05-21',100);

/*Table structure for table `overtime_pay` */

DROP TABLE IF EXISTS `overtime_pay`;

CREATE TABLE `overtime_pay` (
  `overtime_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `salary_id` int(11) DEFAULT NULL,
  `overtime_hours` double DEFAULT NULL,
  `overtime_rate` double DEFAULT NULL,
  `log_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`overtime_id`),
  KEY `empID` (`emp_id`),
  KEY `salaryID` (`salary_id`),
  KEY `logID` (`log_id`),
  CONSTRAINT `overtime_pay_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `overtime_pay_ibfk_2` FOREIGN KEY (`salary_id`) REFERENCES `salary_per_week` (`salary_id`),
  CONSTRAINT `overtime_pay_ibfk_3` FOREIGN KEY (`log_id`) REFERENCES `logs` (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `overtime_pay` */

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `penalty_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `salary_id` int(11) DEFAULT NULL,
  `total_no_late` double DEFAULT NULL,
  `total_no_absent` double DEFAULT NULL,
  `total_no_undertime` double DEFAULT NULL,
  `penalty_rate` double DEFAULT NULL,
  `log_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`penalty_id`),
  KEY `empID` (`emp_id`),
  KEY `salaryID` (`salary_id`),
  KEY `logID` (`log_id`),
  CONSTRAINT `penalty_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `penalty_ibfk_2` FOREIGN KEY (`salary_id`) REFERENCES `salary_per_week` (`salary_id`),
  CONSTRAINT `penalty_ibfk_3` FOREIGN KEY (`log_id`) REFERENCES `logs` (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

/*Table structure for table `report_salary` */

DROP TABLE IF EXISTS `report_salary`;

CREATE TABLE `report_salary` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_id` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `salary_expense` double DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `salaryID` (`salary_id`),
  KEY `empID` (`emp_id`),
  CONSTRAINT `report_salary_ibfk_1` FOREIGN KEY (`salary_id`) REFERENCES `salary_per_week` (`salary_id`),
  CONSTRAINT `report_salary_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `report_salary` */

/*Table structure for table `salary_per_week` */

DROP TABLE IF EXISTS `salary_per_week`;

CREATE TABLE `salary_per_week` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `basic_salary` double DEFAULT NULL,
  `net_salary` double DEFAULT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `empID` (`emp_id`),
  CONSTRAINT `salary_per_week_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salary_per_week` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
