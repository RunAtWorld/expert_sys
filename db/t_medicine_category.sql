/*
Navicat MySQL Data Transfer

Source Server         : www.wuhen6.com
Source Server Version : 50612
Source Host           : www.wuhen6.com:3306
Source Database       : expert_sys

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-04-27 23:35:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_medicine_category
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_category`;
CREATE TABLE `t_medicine_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_category
-- ----------------------------
INSERT INTO `t_medicine_category` VALUES ('1', '感冒药');
INSERT INTO `t_medicine_category` VALUES ('2', '眼药水');
INSERT INTO `t_medicine_category` VALUES ('3', '糖尿病');
INSERT INTO `t_medicine_category` VALUES ('4', '肝病');
INSERT INTO `t_medicine_category` VALUES ('5', '减肥药');
INSERT INTO `t_medicine_category` VALUES ('6', '消炎药');
INSERT INTO `t_medicine_category` VALUES ('7', '维生素');
INSERT INTO `t_medicine_category` VALUES ('8', '肠胃药');
INSERT INTO `t_medicine_category` VALUES ('9', '高血压');
INSERT INTO `t_medicine_category` VALUES ('10', '心脑血管');
INSERT INTO `t_medicine_category` VALUES ('11', '避孕药');
INSERT INTO `t_medicine_category` VALUES ('12', '保健品');
INSERT INTO `t_medicine_category` VALUES ('13', '药妆');
INSERT INTO `t_medicine_category` VALUES ('14', '皮肤病');
INSERT INTO `t_medicine_category` VALUES ('15', ' 呼吸系统疾病');
INSERT INTO `t_medicine_category` VALUES ('16', '消化系统疾病 ');
INSERT INTO `t_medicine_category` VALUES ('17', ' 循环系统疾病 ');
INSERT INTO `t_medicine_category` VALUES ('18', '神经系统疾病');
INSERT INTO `t_medicine_category` VALUES ('19', '五官科疾病药');
INSERT INTO `t_medicine_category` VALUES ('20', '口腔疾病药');
INSERT INTO `t_medicine_category` VALUES ('21', '外科疾病药');
INSERT INTO `t_medicine_category` VALUES ('22', '泌尿生殖疾病');
INSERT INTO `t_medicine_category` VALUES ('23', '妇科疾病');
INSERT INTO `t_medicine_category` VALUES ('24', '儿科疾病');
INSERT INTO `t_medicine_category` VALUES ('25', '心理疾病');
