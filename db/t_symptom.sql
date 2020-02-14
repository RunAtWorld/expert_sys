/*
Navicat MySQL Data Transfer

Source Server         : www.wuhen6.com
Source Server Version : 50612
Source Host           : www.wuhen6.com:3306
Source Database       : expert_sys

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-04-27 23:35:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_symptom
-- ----------------------------
DROP TABLE IF EXISTS `t_symptom`;
CREATE TABLE `t_symptom` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '序列号',
  `symptom` text NOT NULL COMMENT '症状名',
  `remark` char(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_symptom
-- ----------------------------
INSERT INTO `t_symptom` VALUES ('1', '咳嗽', null);
INSERT INTO `t_symptom` VALUES ('2', '发热', null);
INSERT INTO `t_symptom` VALUES ('3', '全身无力', null);
INSERT INTO `t_symptom` VALUES ('4', '鼻塞', null);
INSERT INTO `t_symptom` VALUES ('5', '流鼻涕', null);
INSERT INTO `t_symptom` VALUES ('6', '打喷嚏', null);
INSERT INTO `t_symptom` VALUES ('7', '咽喉肿痛', null);
INSERT INTO `t_symptom` VALUES ('8', '发冷', null);
INSERT INTO `t_symptom` VALUES ('9', '舌苔淡白', null);
INSERT INTO `t_symptom` VALUES ('14', '流泪', null);
INSERT INTO `t_symptom` VALUES ('23', '哮喘', null);
INSERT INTO `t_symptom` VALUES ('21', '牙痛', null);
INSERT INTO `t_symptom` VALUES ('15', '喉痛', null);
INSERT INTO `t_symptom` VALUES ('16', '前额或面颊持续疼痛', '在弯腰、躺下或咳嗽时疼痛加剧');
INSERT INTO `t_symptom` VALUES ('13', '眼痛', null);
INSERT INTO `t_symptom` VALUES ('17', '有黄绿色鼻涕或鼻涕带血丝', null);
INSERT INTO `t_symptom` VALUES ('10', '时常流清鼻涕', null);
INSERT INTO `t_symptom` VALUES ('12', '头痛', null);
INSERT INTO `t_symptom` VALUES ('20', '多泪水', null);
INSERT INTO `t_symptom` VALUES ('18', '体温升高', null);
INSERT INTO `t_symptom` VALUES ('11', '嗅觉不灵', null);
INSERT INTO `t_symptom` VALUES ('22', '湿疹', null);
INSERT INTO `t_symptom` VALUES ('19', '双眼疲倦', null);
INSERT INTO `t_symptom` VALUES ('24', '全身发冷', null);
INSERT INTO `t_symptom` VALUES ('25', '全身发热', null);
INSERT INTO `t_symptom` VALUES ('26', '流清鼻涕', null);
INSERT INTO `t_symptom` VALUES ('27', '舌苔淡白', '');
INSERT INTO `t_symptom` VALUES ('28', '有汗', null);
INSERT INTO `t_symptom` VALUES ('29', '流黄色稠鼻涕', null);
INSERT INTO `t_symptom` VALUES ('30', '舌头红', null);
INSERT INTO `t_symptom` VALUES ('31', '无汗', null);
INSERT INTO `t_symptom` VALUES ('32', '消化不良', null);
INSERT INTO `t_symptom` VALUES ('33', '上腹隐痛', null);
INSERT INTO `t_symptom` VALUES ('34', '腹胀', null);
INSERT INTO `t_symptom` VALUES ('35', '嗳气', null);
INSERT INTO `t_symptom` VALUES ('36', '阵发性胃烧灼感（烧心）', null);
INSERT INTO `t_symptom` VALUES ('37', '反酸（吐酸水）', null);
INSERT INTO `t_symptom` VALUES ('38', '胃痛（上腹部痛）', null);
INSERT INTO `t_symptom` VALUES ('39', '恶心', null);
INSERT INTO `t_symptom` VALUES ('40', '呕吐', null);
INSERT INTO `t_symptom` VALUES ('41', '食欲不振', null);
INSERT INTO `t_symptom` VALUES ('45', '腹痛', null);
INSERT INTO `t_symptom` VALUES ('43', '腹鸣', null);
INSERT INTO `t_symptom` VALUES ('44', '放屁', null);
INSERT INTO `t_symptom` VALUES ('46', '腹泻', null);
INSERT INTO `t_symptom` VALUES ('47', '寒战', null);
INSERT INTO `t_symptom` VALUES ('48', '便秘', null);
INSERT INTO `t_symptom` VALUES ('49', '舌苔厚黄腻', null);
INSERT INTO `t_symptom` VALUES ('50', '精神萎靡', null);
