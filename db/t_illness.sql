/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : expert_sys

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-04-06 22:10:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_illness`
-- ----------------------------
DROP TABLE IF EXISTS `t_illness`;
CREATE TABLE `t_illness` (
  `id` bigint(10) NOT NULL auto_increment COMMENT '序列号',
  `illnessname` text COMMENT '疾病名称',
  `prescription_cn` text COMMENT '中医药方',
  `prescription_en` text COMMENT '西医药方\r\n',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_illness
-- ----------------------------
