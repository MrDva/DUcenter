/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : user_center

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-07-28 12:31:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `authority_table`
-- ----------------------------
DROP TABLE IF EXISTS `authority_table`;
CREATE TABLE `authority_table` (
  `Authority_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Authority_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Authority_Id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of authority_table
-- ----------------------------

-- ----------------------------
-- Table structure for `login_table`
-- ----------------------------
DROP TABLE IF EXISTS `login_table`;
CREATE TABLE `login_table` (
  `Access_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Id` int(11) NOT NULL,
  `Mac` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Point_X` varchar(50) NOT NULL,
  `Point_Y` varchar(50) NOT NULL,
  `Datetime` datetime NOT NULL,
  PRIMARY KEY (`Access_id`) USING BTREE,
  KEY `User_Id` (`User_Id`),
  CONSTRAINT `login_table_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `user_table` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of login_table
-- ----------------------------

-- ----------------------------
-- Table structure for `role_authority_table`
-- ----------------------------
DROP TABLE IF EXISTS `role_authority_table`;
CREATE TABLE `role_authority_table` (
  `Role_Authority_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role_Id` int(11) NOT NULL,
  `Authority_Id` int(11) NOT NULL,
  PRIMARY KEY (`Role_Authority_Id`) USING BTREE,
  KEY `Role_Id` (`Role_Id`),
  KEY `Authority_Id` (`Authority_Id`),
  CONSTRAINT `role_authority_table_ibfk_1` FOREIGN KEY (`Role_Id`) REFERENCES `role_table` (`Role_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_authority_table_ibfk_2` FOREIGN KEY (`Authority_Id`) REFERENCES `authority_table` (`Authority_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_authority_table
-- ----------------------------

-- ----------------------------
-- Table structure for `role_table`
-- ----------------------------
DROP TABLE IF EXISTS `role_table`;
CREATE TABLE `role_table` (
  `Role_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role_Name` varchar(50) NOT NULL,
  `Role_Level` varchar(50) NOT NULL,
  PRIMARY KEY (`Role_Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_table
-- ----------------------------
INSERT INTO `role_table` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `three_login_table`
-- ----------------------------
DROP TABLE IF EXISTS `three_login_table`;
CREATE TABLE `three_login_table` (
  `Access_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Id` int(11) NOT NULL,
  `Mac` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Datetime` datetime NOT NULL,
  PRIMARY KEY (`Access_id`) USING BTREE,
  KEY `User_Id` (`User_Id`),
  CONSTRAINT `three_login_table_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `user_table` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of three_login_table
-- ----------------------------

-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Password` varchar(50) NOT NULL,
  `Affiliation` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Role_Id` int(11) NOT NULL,
  `Is_Delete` tinyint(1) DEFAULT '0',
  `Is_Login` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`User_Id`) USING BTREE,
  KEY `Role_Id` (`Role_Id`),
  CONSTRAINT `user_table_ibfk_1` FOREIGN KEY (`Role_Id`) REFERENCES `role_table` (`Role_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_table
-- ----------------------------
