/*
Navicat MySQL Data Transfer

Source Server         : www.wuhen6.com
Source Server Version : 50612
Source Host           : www.wuhen6.com:3306
Source Database       : expert_sys

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-04-27 23:34:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for r_diagnose
-- ----------------------------
DROP TABLE IF EXISTS `r_diagnose`;
CREATE TABLE `r_diagnose` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `symptoms` text COMMENT '症状id的集合:#1#,#23#',
  `illness` bigint(10) DEFAULT NULL COMMENT '疾病id',
  `confidence` float(4,4) DEFAULT '0.0000' COMMENT '可信度',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_diagnose
-- ----------------------------
INSERT INTO `r_diagnose` VALUES ('10', '#1#;#2#;#4#;#5#;#6#;#7#;#50#;#41#', '1', '0.9832');
INSERT INTO `r_diagnose` VALUES ('8', '#4#;#16#;#11#', '327', '0.9840');
INSERT INTO `r_diagnose` VALUES ('9', '#16#;#17#;#18#;#19#;#20#;#21#', '328', '0.9873');
INSERT INTO `r_diagnose` VALUES ('6', '#10#;#11#;#4#;#12#;#1#;#6#', '326', '0.9999');
INSERT INTO `r_diagnose` VALUES ('7', '#6#;#13#;#14#;#22#;#23#', '222', '0.9962');
INSERT INTO `r_diagnose` VALUES ('11', '#28#;#25#;#29#;#30#', '6', '0.9852');
INSERT INTO `r_diagnose` VALUES ('12', '#24#;#31#;#26#;#27#', '329', '0.9873');
INSERT INTO `r_diagnose` VALUES ('13', '#32#;#33#;#34#;#35#', '330', '0.9862');
INSERT INTO `r_diagnose` VALUES ('14', '#36#;#37#;#38#;#39#;#40#;#41#', '331', '0.9862');
INSERT INTO `r_diagnose` VALUES ('15', '#35#;#41#;#43#;#44#', '332', '0.9862');
INSERT INTO `r_diagnose` VALUES ('16', '#39#;#40#;#45#;#47#;#2#;#12#', '333', '0.9862');
INSERT INTO `r_diagnose` VALUES ('17', '#34#;#39#;#40#;#48#;#30#;#49#', '334', '0.9862');
