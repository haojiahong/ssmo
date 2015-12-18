/*
Navicat MySQL Data Transfer

Source Server         : bend
Source Server Version : 50609
Source Host           : localhost:3306
Source Database       : hjhssmo

Target Server Type    : MYSQL
Target Server Version : 50609
File Encoding         : 65001

Date: 2015-12-18 16:47:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `itemtest`
-- ----------------------------
DROP TABLE IF EXISTS `itemtest`;
CREATE TABLE `itemtest` (
  `uuid` char(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `price` float(8,0) DEFAULT NULL,
  `detail` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemtest
-- ----------------------------
INSERT INTO `itemtest` VALUES ('0df0a287f92349ee8cdd4af14d85e64f', '111', '12', '11');
INSERT INTO `itemtest` VALUES ('0df0a287f92349ee8cdd4af14d85e6aa', '2', '2', '2');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(20) NOT NULL,
  `aliasName` varchar(20) DEFAULT NULL,
  `iconClass` varchar(64) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '七嘴八舌', '七嘴八舌', '', '1');
INSERT INTO `t_category` VALUES ('2', '滥竽充数', '滥竽充数', '', '2');

-- ----------------------------
-- Table structure for `t_friend`
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `friendName` varchar(32) DEFAULT NULL,
  `friendUrl` varchar(32) DEFAULT NULL,
  `friendDesc` varchar(32) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES ('2', 'baidu', 'www.baidu.com', '百度', '1');

-- ----------------------------
-- Table structure for `t_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('2', 'ä½è²æ ç­¾255');
INSERT INTO `t_tag` VALUES ('3', '游戏标签');
INSERT INTO `t_tag` VALUES ('4', '新闻标签');
INSERT INTO `t_tag` VALUES ('6', '娱乐标签');
INSERT INTO `t_tag` VALUES ('7', '科技标签');
INSERT INTO `t_tag` VALUES ('9', '33');
INSERT INTO `t_tag` VALUES ('10', '444');
INSERT INTO `t_tag` VALUES ('11', '55');
INSERT INTO `t_tag` VALUES ('12', '666');
INSERT INTO `t_tag` VALUES ('13', '777');
INSERT INTO `t_tag` VALUES ('14', '9');
INSERT INTO `t_tag` VALUES ('15', '1');
INSERT INTO `t_tag` VALUES ('16', '1');
INSERT INTO `t_tag` VALUES ('17', '1');
INSERT INTO `t_tag` VALUES ('18', '1');
INSERT INTO `t_tag` VALUES ('19', '2');
INSERT INTO `t_tag` VALUES ('20', '5');
INSERT INTO `t_tag` VALUES ('21', '5');
INSERT INTO `t_tag` VALUES ('22', '5');
INSERT INTO `t_tag` VALUES ('23', '5');
