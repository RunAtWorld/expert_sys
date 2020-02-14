/*
Navicat MySQL Data Transfer

Source Server         : www.wuhen6.com
Source Server Version : 50612
Source Host           : www.wuhen6.com:3306
Source Database       : expert_sys

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-04-27 23:34:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for r_prescription_en
-- ----------------------------
DROP TABLE IF EXISTS `r_prescription_en`;
CREATE TABLE `r_prescription_en` (
  `num_id` int(10) NOT NULL AUTO_INCREMENT,
  `medicine_id` int(10) DEFAULT NULL COMMENT '药品id',
  `prescription_id` int(10) DEFAULT NULL COMMENT '药方标号',
  PRIMARY KEY (`num_id`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_prescription_en
-- ----------------------------
INSERT INTO `r_prescription_en` VALUES ('1', '1', '1');
INSERT INTO `r_prescription_en` VALUES ('2', '9', '1');
INSERT INTO `r_prescription_en` VALUES ('3', '14', '1');
INSERT INTO `r_prescription_en` VALUES ('4', '18', '2');
INSERT INTO `r_prescription_en` VALUES ('5', '19', '2');
INSERT INTO `r_prescription_en` VALUES ('6', '22', '2');
INSERT INTO `r_prescription_en` VALUES ('8', '19', '3');
INSERT INTO `r_prescription_en` VALUES ('9', '20', '3');
INSERT INTO `r_prescription_en` VALUES ('7', '18', '3');
INSERT INTO `r_prescription_en` VALUES ('10', '2905', '4');
INSERT INTO `r_prescription_en` VALUES ('11', '2906', '4');
INSERT INTO `r_prescription_en` VALUES ('12', '2907', '4');
INSERT INTO `r_prescription_en` VALUES ('13', '2906', '5');
INSERT INTO `r_prescription_en` VALUES ('14', '2907', '5');
INSERT INTO `r_prescription_en` VALUES ('15', '2908', '5');
INSERT INTO `r_prescription_en` VALUES ('16', '2905', '6');
INSERT INTO `r_prescription_en` VALUES ('17', '2908', '6');
INSERT INTO `r_prescription_en` VALUES ('18', '87', '7');
INSERT INTO `r_prescription_en` VALUES ('19', '228', '7');
INSERT INTO `r_prescription_en` VALUES ('20', '238', '7');
INSERT INTO `r_prescription_en` VALUES ('21', '815', '8');
INSERT INTO `r_prescription_en` VALUES ('22', '229', '8');
INSERT INTO `r_prescription_en` VALUES ('23', '105', '8');
INSERT INTO `r_prescription_en` VALUES ('24', '22', '9');
INSERT INTO `r_prescription_en` VALUES ('25', '2910', '9');
INSERT INTO `r_prescription_en` VALUES ('26', '238', '9');
INSERT INTO `r_prescription_en` VALUES ('27', '26', '10');
INSERT INTO `r_prescription_en` VALUES ('28', '238', '10');
INSERT INTO `r_prescription_en` VALUES ('29', '2907', '10');
INSERT INTO `r_prescription_en` VALUES ('30', '2912', '11');
INSERT INTO `r_prescription_en` VALUES ('31', '2913', '11');
INSERT INTO `r_prescription_en` VALUES ('32', '2914', '11');
INSERT INTO `r_prescription_en` VALUES ('33', '15', '12');
INSERT INTO `r_prescription_en` VALUES ('34', '2915', '12');
INSERT INTO `r_prescription_en` VALUES ('35', '95', '12');
INSERT INTO `r_prescription_en` VALUES ('36', '283', '13');
INSERT INTO `r_prescription_en` VALUES ('37', '253', '13');
INSERT INTO `r_prescription_en` VALUES ('38', '2914', '13');
INSERT INTO `r_prescription_en` VALUES ('39', '2916', '13');
INSERT INTO `r_prescription_en` VALUES ('40', '2917', '14');
INSERT INTO `r_prescription_en` VALUES ('41', '2914', '14');
INSERT INTO `r_prescription_en` VALUES ('42', '2918', '14');
INSERT INTO `r_prescription_en` VALUES ('43', '280', '14');
INSERT INTO `r_prescription_en` VALUES ('44', '281', '15');
INSERT INTO `r_prescription_en` VALUES ('45', '271', '15');
INSERT INTO `r_prescription_en` VALUES ('46', '2919', '16');
INSERT INTO `r_prescription_en` VALUES ('47', '2920', '16');
INSERT INTO `r_prescription_en` VALUES ('48', '487', '17');
INSERT INTO `r_prescription_en` VALUES ('49', '328', '17');
INSERT INTO `r_prescription_en` VALUES ('50', '358', '17');
INSERT INTO `r_prescription_en` VALUES ('51', '487', '18');
INSERT INTO `r_prescription_en` VALUES ('52', '2921', '18');
INSERT INTO `r_prescription_en` VALUES ('53', '2922', '18');
INSERT INTO `r_prescription_en` VALUES ('54', '270', '19');
INSERT INTO `r_prescription_en` VALUES ('55', '265', '19');
INSERT INTO `r_prescription_en` VALUES ('56', '2923', '19');
INSERT INTO `r_prescription_en` VALUES ('57', '506', '20');
INSERT INTO `r_prescription_en` VALUES ('58', '998', '20');
INSERT INTO `r_prescription_en` VALUES ('59', '478', '21');
INSERT INTO `r_prescription_en` VALUES ('60', '293', '21');
