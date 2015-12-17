/*
Navicat MySQL Data Transfer

Source Server         : bend
Source Server Version : 50609
Source Host           : localhost:3306
Source Database       : hjhssmo

Target Server Type    : MYSQL
Target Server Version : 50609
File Encoding         : 65001

Date: 2015-12-17 17:20:47
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
-- Table structure for `t_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('1', '娱乐标签2');
INSERT INTO `t_tag` VALUES ('2', '体育标签');
INSERT INTO `t_tag` VALUES ('3', '游戏标签');
INSERT INTO `t_tag` VALUES ('4', '新闻标签');
