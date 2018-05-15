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
  `EmpID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `hourlyRate` double NOT NULL,
  `type` enum('Admin','Regular') DEFAULT NULL,
  PRIMARY KEY (`EmpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*Table structure for table `logs` */

DROP TABLE IF EXISTS `logs`;

CREATE TABLE `logs` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `empID` int(11) DEFAULT NULL,
  `timeIN` time DEFAULT NULL,
  `timeOUT` time DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`logId`),
  KEY `empID` (`empID`),
  CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `logs` */

/*Table structure for table `overtimepay` */

DROP TABLE IF EXISTS `overtimepay`;

CREATE TABLE `overtimepay` (
  `overtimeID` int(11) NOT NULL AUTO_INCREMENT,
  `empID` int(11) DEFAULT NULL,
  `salaryID` int(11) DEFAULT NULL,
  `overtimeHours` double DEFAULT NULL,
  `overtimeRate` double DEFAULT NULL,
  `logID` int(11) DEFAULT NULL,
  PRIMARY KEY (`overtimeID`),
  KEY `empID` (`empID`),
  KEY `salaryID` (`salaryID`),
  KEY `logID` (`logID`),
  CONSTRAINT `overtimepay_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmpID`),
  CONSTRAINT `overtimepay_ibfk_2` FOREIGN KEY (`salaryID`) REFERENCES `salaryperweek` (`salaryID`),
  CONSTRAINT `overtimepay_ibfk_3` FOREIGN KEY (`logID`) REFERENCES `logs` (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `overtimepay` */

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `penaltyiD` int(11) NOT NULL AUTO_INCREMENT,
  `empID` int(11) DEFAULT NULL,
  `salaryID` int(11) DEFAULT NULL,
  `totalNoLate` double DEFAULT NULL,
  `totalNoAbsent` double DEFAULT NULL,
  `totalNoUnderTime` double DEFAULT NULL,
  `penaltyRate` double DEFAULT NULL,
  `logID` int(11) DEFAULT NULL,
  PRIMARY KEY (`penaltyiD`),
  KEY `empID` (`empID`),
  KEY `salaryID` (`salaryID`),
  KEY `logID` (`logID`),
  CONSTRAINT `penalty_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmpID`),
  CONSTRAINT `penalty_ibfk_2` FOREIGN KEY (`salaryID`) REFERENCES `salaryperweek` (`salaryID`),
  CONSTRAINT `penalty_ibfk_3` FOREIGN KEY (`logID`) REFERENCES `logs` (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

/*Table structure for table `reportsalary` */

DROP TABLE IF EXISTS `reportsalary`;

CREATE TABLE `reportsalary` (
  `reportID` int(11) NOT NULL AUTO_INCREMENT,
  `salaryID` int(11) DEFAULT NULL,
  `empID` int(11) DEFAULT NULL,
  `salaryExpense` double DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  PRIMARY KEY (`reportID`),
  KEY `salaryID` (`salaryID`),
  KEY `empID` (`empID`),
  CONSTRAINT `reportsalary_ibfk_1` FOREIGN KEY (`salaryID`) REFERENCES `salaryperweek` (`salaryID`),
  CONSTRAINT `reportsalary_ibfk_2` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reportsalary` */

/*Table structure for table `salaryperweek` */

DROP TABLE IF EXISTS `salaryperweek`;

CREATE TABLE `salaryperweek` (
  `salaryID` int(11) NOT NULL AUTO_INCREMENT,
  `empID` int(11) DEFAULT NULL,
  `basicSalary` double DEFAULT NULL,
  `netSalary` double DEFAULT NULL,
  PRIMARY KEY (`salaryID`),
  KEY `empID` (`empID`),
  CONSTRAINT `salaryperweek_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salaryperweek` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
