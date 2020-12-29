/*
Navicat MySQL Data Transfer

Source Server         : Mysql8
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-12-29 17:05:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', 'IT');
INSERT INTO `dept` VALUES ('2', 'ETF');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(32) DEFAULT NULL,
  `deptID` int(11) DEFAULT NULL,
  `money` bigint(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `empImg` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('22', '曾爷', '1', '20000', '0', '/uploadfile/img/船长.PNG');
INSERT INTO `emp` VALUES ('23', '大肥鱼', '2', '20000', '1', '/uploadfile/img/1-120R1145T2.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `empID` int(11) DEFAULT NULL,
  `sname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'fishman', '980813', '1', '捕鱼达人');
INSERT INTO `user` VALUES ('2', 'fish', '951103', '2', '大肥鱼');
