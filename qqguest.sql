/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : qqguest

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-06-08 17:36:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for domain
-- ----------------------------
DROP TABLE IF EXISTS `domain`;
CREATE TABLE `domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `url` varchar(100) NOT NULL,
  `state` int(11) NOT NULL,
  `outtime` varchar(100) NOT NULL,
  `intime` varchar(100) NOT NULL,
  `email_state` int(11) NOT NULL,
  `email_name` varchar(500) NOT NULL,
  `email_title` varchar(500) NOT NULL,
  `email_content` text NOT NULL,
  `qq` int(11) DEFAULT '0',
  `yc` int(11) DEFAULT '2',
  `kf` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of domain
-- ----------------------------

-- ----------------------------
-- Table structure for email_logs
-- ----------------------------
DROP TABLE IF EXISTS `email_logs`;
CREATE TABLE `email_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yid` int(11) NOT NULL,
  `qq` varchar(50) NOT NULL,
  `outtime` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_logs
-- ----------------------------

-- ----------------------------
-- Table structure for email_user
-- ----------------------------
DROP TABLE IF EXISTS `email_user`;
CREATE TABLE `email_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `smtp` varchar(100) NOT NULL,
  `duankou` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_user
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `yid` int(11) NOT NULL,
  `qq` varchar(100) NOT NULL,
  `data` text NOT NULL,
  `time` varchar(100) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------

-- ----------------------------
-- Table structure for proxy
-- ----------------------------
DROP TABLE IF EXISTS `proxy`;
CREATE TABLE `proxy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `money` int(11) NOT NULL,
  `zhekou` int(11) NOT NULL,
  `intime` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `content_2` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proxy
-- ----------------------------

-- ----------------------------
-- Table structure for qq
-- ----------------------------
DROP TABLE IF EXISTS `qq`;
CREATE TABLE `qq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qq
-- ----------------------------
INSERT INTO `qq` VALUES ('1', '12');

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL,
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
INSERT INTO `resources` VALUES ('1', null, '资源1', '1', '1', '/test');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '1', 'ROLE_ABCS', 'guest');
INSERT INTO `roles` VALUES ('2', '1', 'ROLE_ADMIN', 'admin');
INSERT INTO `roles` VALUES ('3', '1', 'ROLE_ABCA', 'guest');

-- ----------------------------
-- Table structure for roles_resources
-- ----------------------------
DROP TABLE IF EXISTS `roles_resources`;
CREATE TABLE `roles_resources` (
  `rr_id` int(11) NOT NULL AUTO_INCREMENT,
  `rsid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rr_id`),
  KEY `FK77tfghudlh221l0dy9q60s3mi` (`rsid`),
  KEY `FKbkwgk0hwprjy9dlmabloviy5i` (`rid`),
  CONSTRAINT `FK77tfghudlh221l0dy9q60s3mi` FOREIGN KEY (`rsid`) REFERENCES `resources` (`id`),
  CONSTRAINT `FKbkwgk0hwprjy9dlmabloviy5i` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_resources
-- ----------------------------
INSERT INTO `roles_resources` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', null, null, 'guest', null, '123456', null, null, null, 'guest');
INSERT INTO `users` VALUES ('2', null, null, 'admin', null, '123456', null, null, null, 'admin');

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  KEY `FKee0mot6r2y47ltnyjcah3r59p` (`rid`),
  KEY `FKrxg5wjyn6ahtq2vf3fgkpb06r` (`uid`),
  CONSTRAINT `FKee0mot6r2y47ltnyjcah3r59p` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKrxg5wjyn6ahtq2vf3fgkpb06r` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
