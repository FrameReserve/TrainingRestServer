/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : qqguest

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-06-17 08:12:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qq
-- ----------------------------
DROP TABLE IF EXISTS `qq`;
CREATE TABLE `qq` (
  `id` varchar(36) NOT NULL,
  `qq` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qq
-- ----------------------------

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` varchar(36) NOT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` varchar(36) NOT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for roles_resources
-- ----------------------------
DROP TABLE IF EXISTS `roles_resources`;
CREATE TABLE `roles_resources` (
  `id` varchar(36) NOT NULL,
  `rsid` varchar(36) DEFAULT NULL,
  `rid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK77tfghudlh221l0dy9q60s3mi` (`rsid`),
  KEY `FKbkwgk0hwprjy9dlmabloviy5i` (`rid`),
  CONSTRAINT `FK77tfghudlh221l0dy9q60s3mi` FOREIGN KEY (`rsid`) REFERENCES `resources` (`id`),
  CONSTRAINT `FKbkwgk0hwprjy9dlmabloviy5i` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_resources
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `logintime` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `proxy_id` int(11) DEFAULT NULL,
  `qq` int(11) DEFAULT NULL,
  `qq_au` varchar(255) DEFAULT NULL,
  `regtime` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `id` varchar(36) NOT NULL,
  `rid` varchar(36) DEFAULT NULL,
  `uid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKee0mot6r2y47ltnyjcah3r59p` (`rid`),
  KEY `FKrxg5wjyn6ahtq2vf3fgkpb06r` (`uid`),
  CONSTRAINT `FKee0mot6r2y47ltnyjcah3r59p` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKrxg5wjyn6ahtq2vf3fgkpb06r` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
