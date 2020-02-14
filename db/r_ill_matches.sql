/*
Navicat MySQL Data Transfer

Source Server         : www.wuhen6.com
Source Server Version : 50612
Source Host           : www.wuhen6.com:3306
Source Database       : expert_sys

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-04-27 23:34:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for r_ill_matches
-- ----------------------------
DROP TABLE IF EXISTS `r_ill_matches`;
CREATE TABLE `r_ill_matches` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '西医处方序列号',
  `illness_id` bigint(10) DEFAULT NULL COMMENT '疾病id',
  `prescription_id` int(10) DEFAULT NULL COMMENT '药方id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_ill_matches
-- ----------------------------
INSERT INTO `r_ill_matches` VALUES ('10', '1', '7');
INSERT INTO `r_ill_matches` VALUES ('11', '1', '8');
INSERT INTO `r_ill_matches` VALUES ('12', '329', '9');
INSERT INTO `r_ill_matches` VALUES ('4', '326', '4');
INSERT INTO `r_ill_matches` VALUES ('5', '327', '5');
INSERT INTO `r_ill_matches` VALUES ('6', '328', '6');
INSERT INTO `r_ill_matches` VALUES ('15', '6', '12');
INSERT INTO `r_ill_matches` VALUES ('13', '329', '10');
INSERT INTO `r_ill_matches` VALUES ('14', '6', '11');
INSERT INTO `r_ill_matches` VALUES ('16', '330', '13');
INSERT INTO `r_ill_matches` VALUES ('17', '330', '14');
INSERT INTO `r_ill_matches` VALUES ('18', '331', '15');
INSERT INTO `r_ill_matches` VALUES ('19', '331', '16');
INSERT INTO `r_ill_matches` VALUES ('20', '332', '17');
INSERT INTO `r_ill_matches` VALUES ('21', '332', '18');
INSERT INTO `r_ill_matches` VALUES ('22', '333', '19');
INSERT INTO `r_ill_matches` VALUES ('23', '333', '20');
INSERT INTO `r_ill_matches` VALUES ('24', '334', '21');
