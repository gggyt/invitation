/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hwl002

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-25 15:05:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_title` varchar(255) DEFAULT NULL,
  `a_author` varchar(30) DEFAULT NULL,
  `a_content` varchar(2555) DEFAULT NULL,
  `a_date` datetime DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`a_id`),
  KEY `c_id` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('7', '5', '1', '5', '2018-05-29 15:27:08', null);
INSERT INTO `article` VALUES ('8', '6', '1', '6', '2018-05-29 15:30:22', null);
INSERT INTO `article` VALUES ('9', '22', '1', '22', '2018-05-29 15:32:30', null);
INSERT INTO `article` VALUES ('12', '你好世界', '2', '嘻嘻', '2018-05-30 21:03:08', null);
INSERT INTO `article` VALUES ('16', '今天', 'ergou', '今天是我使用回帖吧的第一天，激动', '2018-05-31 20:25:11', null);
INSERT INTO `article` VALUES ('18', '大家好，我是张三', '张三', '大家好，我是张三，很高兴认识大家', '2018-06-01 10:43:20', null);
INSERT INTO `article` VALUES ('26', '又是一个周一', 'ergou', '又要开始上学啦！', '2018-06-04 16:14:58', null);
INSERT INTO `article` VALUES ('27', '你们是谁，在下面留下你们的名字', '11', '大家好我的11，很开心认识你们。', '2018-06-04 16:25:58', null);
INSERT INTO `article` VALUES ('35', '今天周二', 'ergou', '今天周二啦，有课哦。', '2018-06-05 09:41:36', null);
INSERT INTO `article` VALUES ('37', '33test', 'ergou', 'test', '2018-06-17 10:49:17', null);
INSERT INTO `article` VALUES ('40', 'dp专题', null, '学习dp', '2018-06-17 10:57:41', null);
INSERT INTO `article` VALUES ('41', 'miner', 'ergou', '矿工', '2018-06-17 22:55:42', null);
INSERT INTO `article` VALUES ('42', '西瓜', 'ergou', '嘻嘻，西瓜xigu', '2018-06-19 13:36:56', null);
INSERT INTO `article` VALUES ('43', 'er', 'lisi', '你好呀er', '2018-06-19 13:37:40', null);
INSERT INTO `article` VALUES ('64', '测试未选择分类', 'ergou', '测试未选择分类', '2018-06-25 14:28:33', null);
INSERT INTO `article` VALUES ('65', '测试删除分类', 'ergou', '测试删除分类', '2018-06-25 14:28:58', null);
INSERT INTO `article` VALUES ('66', 'acm', 'ergou', '今天做了比赛，很开心', '2018-06-25 15:04:02', null);
INSERT INTO `article` VALUES ('67', '个人心得', 'ergou', '大学生活真愉快', '2018-06-25 15:04:19', null);

-- ----------------------------
-- Table structure for `book_category`
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category` (
  `a_id` int(11) NOT NULL,
  `ca_name` varchar(11) NOT NULL,
  KEY `a_id` (`a_id`),
  KEY `ca_name` (`ca_name`),
  CONSTRAINT `a_id` FOREIGN KEY (`a_id`) REFERENCES `article` (`a_id`),
  CONSTRAINT `ca_name` FOREIGN KEY (`ca_name`) REFERENCES `category` (`ca_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES ('7', '未分类');
INSERT INTO `book_category` VALUES ('8', '未分类');
INSERT INTO `book_category` VALUES ('9', '未分类');
INSERT INTO `book_category` VALUES ('12', '未分类');
INSERT INTO `book_category` VALUES ('16', '未分类');
INSERT INTO `book_category` VALUES ('18', '未分类');
INSERT INTO `book_category` VALUES ('26', '未分类');
INSERT INTO `book_category` VALUES ('35', '未分类');
INSERT INTO `book_category` VALUES ('35', '未分类');
INSERT INTO `book_category` VALUES ('35', '未分类');
INSERT INTO `book_category` VALUES ('27', '未分类');
INSERT INTO `book_category` VALUES ('37', '未分类');
INSERT INTO `book_category` VALUES ('40', '未分类');
INSERT INTO `book_category` VALUES ('41', '未分类');
INSERT INTO `book_category` VALUES ('42', '未分类');
INSERT INTO `book_category` VALUES ('43', '未分类');
INSERT INTO `book_category` VALUES ('64', '测试');
INSERT INTO `book_category` VALUES ('65', '未分类');
INSERT INTO `book_category` VALUES ('66', 'acm');
INSERT INTO `book_category` VALUES ('67', '个人心得');
INSERT INTO `book_category` VALUES ('67', '大学');
INSERT INTO `book_category` VALUES ('67', '生活');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ca_name` varchar(255) NOT NULL,
  PRIMARY KEY (`ca_name`),
  KEY `ca_name` (`ca_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('acm');
INSERT INTO `category` VALUES ('个人心得');
INSERT INTO `category` VALUES ('大学');
INSERT INTO `category` VALUES ('未分类');
INSERT INTO `category` VALUES ('测试');
INSERT INTO `category` VALUES ('生活');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `c_content` varchar(255) DEFAULT NULL,
  `c_date` datetime DEFAULT NULL,
  `wa_id` int(11) DEFAULT NULL,
  `u_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `wa_id` (`wa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '0', null, '2018-05-29 20:16:42', null, null);
INSERT INTO `comment` VALUES ('2', '0', null, '2018-05-29 20:17:09', null, null);
INSERT INTO `comment` VALUES ('3', '0', null, '2018-05-29 20:17:36', null, null);
INSERT INTO `comment` VALUES ('4', '0', '33', '2018-05-29 20:18:28', null, null);
INSERT INTO `comment` VALUES ('6', '0', '444', '2018-05-29 22:20:41', null, null);
INSERT INTO `comment` VALUES ('7', '0', '555', '2018-05-29 22:22:11', '11', 'ergou');
INSERT INTO `comment` VALUES ('8', '0', '666', '2018-05-29 22:34:20', '11', 'xg');
INSERT INTO `comment` VALUES ('9', '0', '677', '2018-05-29 22:35:50', '11', 'xgg');
INSERT INTO `comment` VALUES ('10', '8', '99', '2018-05-29 22:35:50', '11', 'xggg');
INSERT INTO `comment` VALUES ('15', '0', 'tt', '2018-05-30 17:39:29', '11', '2');
INSERT INTO `comment` VALUES ('37', '8', '回复 xggg: 444', '2018-05-30 18:57:38', '11', '2');
INSERT INTO `comment` VALUES ('38', '0', '无聊', '2018-05-30 21:03:18', '12', '2');
INSERT INTO `comment` VALUES ('39', '38', '你也很无聊', '2018-05-30 21:03:27', '12', '2');
INSERT INTO `comment` VALUES ('43', '0', '大家好，我是xxx', '2018-05-31 20:25:22', '16', 'ergou');
INSERT INTO `comment` VALUES ('44', '0', '我也很好啊', '2018-05-31 20:25:47', '15', 'ergou');
INSERT INTO `comment` VALUES ('52', '0', '123', '2018-05-31 22:22:51', '8', '1');
INSERT INTO `comment` VALUES ('54', '43', '1212', '2018-05-31 22:25:17', '16', '1');
INSERT INTO `comment` VALUES ('56', '0', '欢迎大家在我的帖子里多留言。新人初到，请多多关照', '2018-06-01 10:45:37', '18', '张三');
INSERT INTO `comment` VALUES ('57', '56', '很开心见到你', '2018-06-01 10:53:39', '18', 'ergou');
INSERT INTO `comment` VALUES ('58', '0', '你好，我也是新人', '2018-06-01 11:13:27', '18', '1');
INSERT INTO `comment` VALUES ('59', '0', '可爱的小伙伴们今天有课吗？', '2018-06-04 16:15:21', '26', 'ergou');
INSERT INTO `comment` VALUES ('60', '58', '以后多多给我回帖呀            ', '2018-06-04 16:15:42', '18', 'ergou');
INSERT INTO `comment` VALUES ('61', '59', '呀，今天我们课超级多！    ', '2018-06-04 16:18:18', '26', 'xigua');
INSERT INTO `comment` VALUES ('62', '0', '你好，我是2，很高兴认识你', '2018-06-04 16:27:54', '27', '2');
INSERT INTO `comment` VALUES ('63', '0', '你好呀', '2018-06-04 16:37:30', '12', '1');
INSERT INTO `comment` VALUES ('64', '0', '你好，我是二狗，很开心认识你', '2018-06-05 09:40:56', '27', 'ergou');
INSERT INTO `comment` VALUES ('67', '0', '你在干嘛啊', '2018-06-05 14:28:10', '35', 'lisi');
INSERT INTO `comment` VALUES ('68', '0', '现在在工程实践上机', '2018-06-12 20:08:03', '35', 'ergou');
INSERT INTO `comment` VALUES ('69', '67', '我在上机呀   ', '2018-06-12 20:11:03', '35', 'ergou');
INSERT INTO `comment` VALUES ('71', '62', '嘻嘻             ', '2018-06-19 13:32:07', '27', 'ergou');
INSERT INTO `comment` VALUES ('75', '0', '敏儿是miner是矿工', '2018-06-19 18:25:42', '41', 'ergou');

-- ----------------------------
-- Table structure for `fans`
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `fan_id` int(11) NOT NULL AUTO_INCREMENT,
  `mainFriendName` varchar(255) DEFAULT NULL,
  `otherFriendName` varchar(255) DEFAULT NULL,
  `fansOrNot` int(11) DEFAULT NULL COMMENT '0--未添加好友1--已添加2--等待同意',
  PRIMARY KEY (`fan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fans
-- ----------------------------
INSERT INTO `fans` VALUES ('1', '2', 'ergou', '1');
INSERT INTO `fans` VALUES ('2', 'lisi', 'ergou', '1');
INSERT INTO `fans` VALUES ('5', '1', 'ergou', '1');
INSERT INTO `fans` VALUES ('6', 'ergou', 'xixi', '1');
INSERT INTO `fans` VALUES ('7', 'lisi', '11', '1');
INSERT INTO `fans` VALUES ('10', 'lanyu', '1', '1');
INSERT INTO `fans` VALUES ('11', 'lanyu', '2', '1');
INSERT INTO `fans` VALUES ('15', 'ergou', 'lisi', '1');

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `friend_id` int(11) NOT NULL AUTO_INCREMENT,
  `mainFriendName` varchar(255) DEFAULT NULL,
  `otherFriendName` varchar(255) DEFAULT NULL,
  `friendOrNot` int(11) DEFAULT NULL COMMENT '0--未添加好友1--已添加2--等待同意',
  PRIMARY KEY (`friend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('8', 'ergou', '热爱学习', '2');
INSERT INTO `friend` VALUES ('9', 'ergou', '张三', '2');
INSERT INTO `friend` VALUES ('10', 'ergou', 'xixi', '1');
INSERT INTO `friend` VALUES ('11', 'xixi', 'ergou', '1');
INSERT INTO `friend` VALUES ('12', '2', 'lisi', '1');
INSERT INTO `friend` VALUES ('13', 'lisi', '2', '1');
INSERT INTO `friend` VALUES ('14', '11', '1', '1');
INSERT INTO `friend` VALUES ('15', '1', '11', '1');
INSERT INTO `friend` VALUES ('18', 'miner', '1', '2');
INSERT INTO `friend` VALUES ('19', 'lanyu', '1', '1');
INSERT INTO `friend` VALUES ('20', '1', 'lanyu', '1');
INSERT INTO `friend` VALUES ('21', 'ergou', 'wangwu', '1');
INSERT INTO `friend` VALUES ('22', 'wangwu', 'ergou', '1');
INSERT INTO `friend` VALUES ('26', '1', '2', '1');
INSERT INTO `friend` VALUES ('27', '2', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(30) DEFAULT NULL,
  `u_passwd` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_name` (`u_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1');
INSERT INTO `user` VALUES ('2', '2', '2');
INSERT INTO `user` VALUES ('6', '3', '3');
INSERT INTO `user` VALUES ('7', 'ergou', '123');
INSERT INTO `user` VALUES ('9', 'lisi', '123');
INSERT INTO `user` VALUES ('10', '张三', '123');
INSERT INTO `user` VALUES ('11', 'xigua', '123');
INSERT INTO `user` VALUES ('12', '11', '11');
INSERT INTO `user` VALUES ('13', 'wangwu', '123');
INSERT INTO `user` VALUES ('14', 'wangliu', '123');
INSERT INTO `user` VALUES ('15', '热爱学习', '123');
INSERT INTO `user` VALUES ('16', 'xixi', '123');
INSERT INTO `user` VALUES ('17', 'miner', '123');
INSERT INTO `user` VALUES ('18', 'lanyu', '123456');

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('1', '1');
INSERT INTO `visitor` VALUES ('2', '2');
INSERT INTO `visitor` VALUES ('3', '1');
INSERT INTO `visitor` VALUES ('4', '2');
INSERT INTO `visitor` VALUES ('5', '1');
INSERT INTO `visitor` VALUES ('6', '1');
INSERT INTO `visitor` VALUES ('7', '1');
INSERT INTO `visitor` VALUES ('8', '1');
INSERT INTO `visitor` VALUES ('9', '1');
INSERT INTO `visitor` VALUES ('10', '1');
INSERT INTO `visitor` VALUES ('11', '2');
INSERT INTO `visitor` VALUES ('12', '2');
INSERT INTO `visitor` VALUES ('13', '2');
INSERT INTO `visitor` VALUES ('14', '2');
INSERT INTO `visitor` VALUES ('15', '2');
INSERT INTO `visitor` VALUES ('16', '2');
INSERT INTO `visitor` VALUES ('17', '2');
INSERT INTO `visitor` VALUES ('18', '2');
INSERT INTO `visitor` VALUES ('19', '2');
INSERT INTO `visitor` VALUES ('20', '2');
INSERT INTO `visitor` VALUES ('21', '2');
INSERT INTO `visitor` VALUES ('22', '1');
INSERT INTO `visitor` VALUES ('23', '2');
INSERT INTO `visitor` VALUES ('24', '2');
INSERT INTO `visitor` VALUES ('25', '2');
INSERT INTO `visitor` VALUES ('26', 'ergou');
INSERT INTO `visitor` VALUES ('27', 'ergou');
INSERT INTO `visitor` VALUES ('28', 'ergou');
INSERT INTO `visitor` VALUES ('29', 'ergou');
INSERT INTO `visitor` VALUES ('30', '二狗');
INSERT INTO `visitor` VALUES ('31', 'ergou');
INSERT INTO `visitor` VALUES ('32', 'ergou');
INSERT INTO `visitor` VALUES ('33', 'ergou');
INSERT INTO `visitor` VALUES ('34', 'ergou');
INSERT INTO `visitor` VALUES ('35', 'ergou');
INSERT INTO `visitor` VALUES ('36', 'ergou');
INSERT INTO `visitor` VALUES ('37', 'ergou');
INSERT INTO `visitor` VALUES ('38', 'ergou');
INSERT INTO `visitor` VALUES ('39', '1');
INSERT INTO `visitor` VALUES ('40', 'ergou');
INSERT INTO `visitor` VALUES ('41', '1');
INSERT INTO `visitor` VALUES ('42', 'ergou');
INSERT INTO `visitor` VALUES ('43', '1');
INSERT INTO `visitor` VALUES ('44', '1');
INSERT INTO `visitor` VALUES ('45', '1');
INSERT INTO `visitor` VALUES ('46', 'ergou');
INSERT INTO `visitor` VALUES ('47', 'ergou');
INSERT INTO `visitor` VALUES ('48', 'ergou');
INSERT INTO `visitor` VALUES ('49', 'ergou');
INSERT INTO `visitor` VALUES ('50', '1');
INSERT INTO `visitor` VALUES ('51', '1');
INSERT INTO `visitor` VALUES ('52', 'lisi');
INSERT INTO `visitor` VALUES ('53', 'lisi');
INSERT INTO `visitor` VALUES ('54', '张三');
INSERT INTO `visitor` VALUES ('55', 'ergou');
INSERT INTO `visitor` VALUES ('56', '1');
INSERT INTO `visitor` VALUES ('57', '1');
INSERT INTO `visitor` VALUES ('58', '1');
INSERT INTO `visitor` VALUES ('59', 'ergou');
INSERT INTO `visitor` VALUES ('60', 'ergou');
INSERT INTO `visitor` VALUES ('61', 'xigua');
INSERT INTO `visitor` VALUES ('62', '1');
INSERT INTO `visitor` VALUES ('63', '11');
INSERT INTO `visitor` VALUES ('64', '2');
INSERT INTO `visitor` VALUES ('65', '2');
INSERT INTO `visitor` VALUES ('66', '1');
INSERT INTO `visitor` VALUES ('67', 'ergou');
INSERT INTO `visitor` VALUES ('68', '1');
INSERT INTO `visitor` VALUES ('69', '1');
INSERT INTO `visitor` VALUES ('70', '1');
INSERT INTO `visitor` VALUES ('71', '1');
INSERT INTO `visitor` VALUES ('72', '1');
INSERT INTO `visitor` VALUES ('73', 'ergou');
INSERT INTO `visitor` VALUES ('74', 'ergou');
INSERT INTO `visitor` VALUES ('75', 'ergou');
INSERT INTO `visitor` VALUES ('76', 'ergou');
INSERT INTO `visitor` VALUES ('77', 'lisi');
INSERT INTO `visitor` VALUES ('78', 'ergou');
INSERT INTO `visitor` VALUES ('79', 'ergou');
INSERT INTO `visitor` VALUES ('80', '1');
INSERT INTO `visitor` VALUES ('81', 'ergou');
INSERT INTO `visitor` VALUES ('82', '1');
INSERT INTO `visitor` VALUES ('83', '1');
INSERT INTO `visitor` VALUES ('84', '1');
INSERT INTO `visitor` VALUES ('85', 'ergou');
INSERT INTO `visitor` VALUES ('86', 'ergou');
INSERT INTO `visitor` VALUES ('87', 'ergou');
INSERT INTO `visitor` VALUES ('88', 'ergou');
INSERT INTO `visitor` VALUES ('89', 'ergou');
INSERT INTO `visitor` VALUES ('90', 'ergou');
INSERT INTO `visitor` VALUES ('91', 'ergou');
INSERT INTO `visitor` VALUES ('92', 'ergou');
INSERT INTO `visitor` VALUES ('93', 'ergou');
INSERT INTO `visitor` VALUES ('94', 'ergou');
INSERT INTO `visitor` VALUES ('95', 'ergou');
INSERT INTO `visitor` VALUES ('96', 'ergou');
INSERT INTO `visitor` VALUES ('97', 'ergou');
INSERT INTO `visitor` VALUES ('98', 'ergou');
INSERT INTO `visitor` VALUES ('99', 'ergou');
INSERT INTO `visitor` VALUES ('100', 'ergou');
INSERT INTO `visitor` VALUES ('101', 'ergou');
INSERT INTO `visitor` VALUES ('102', 'ergou');
INSERT INTO `visitor` VALUES ('103', 'ergou');
INSERT INTO `visitor` VALUES ('104', 'ergou');
INSERT INTO `visitor` VALUES ('105', 'ergou');
INSERT INTO `visitor` VALUES ('106', 'ergou');
INSERT INTO `visitor` VALUES ('107', 'lisi');
INSERT INTO `visitor` VALUES ('108', 'ergou');
INSERT INTO `visitor` VALUES ('109', 'ergou');
INSERT INTO `visitor` VALUES ('110', 'ergou');
INSERT INTO `visitor` VALUES ('111', 'ergou');
INSERT INTO `visitor` VALUES ('112', 'ergou');
INSERT INTO `visitor` VALUES ('113', 'ergou');
INSERT INTO `visitor` VALUES ('114', 'ergou');
INSERT INTO `visitor` VALUES ('115', 'ergou');
INSERT INTO `visitor` VALUES ('116', 'ergou');
INSERT INTO `visitor` VALUES ('117', 'ergou');
INSERT INTO `visitor` VALUES ('118', 'ergou');
INSERT INTO `visitor` VALUES ('119', 'lisi');
INSERT INTO `visitor` VALUES ('120', '1');
INSERT INTO `visitor` VALUES ('121', 'ergou');
INSERT INTO `visitor` VALUES ('122', '1');
INSERT INTO `visitor` VALUES ('123', 'ergou');
INSERT INTO `visitor` VALUES ('124', 'ergou');
INSERT INTO `visitor` VALUES ('125', 'ergou');
INSERT INTO `visitor` VALUES ('126', 'ergou');
INSERT INTO `visitor` VALUES ('127', 'ergou');
INSERT INTO `visitor` VALUES ('128', 'ergou');
INSERT INTO `visitor` VALUES ('129', 'xixi');
INSERT INTO `visitor` VALUES ('130', '热爱学习');
INSERT INTO `visitor` VALUES ('131', 'ergou');
INSERT INTO `visitor` VALUES ('132', 'ergou');
INSERT INTO `visitor` VALUES ('133', 'ergou');
INSERT INTO `visitor` VALUES ('134', 'ergou');
INSERT INTO `visitor` VALUES ('135', 'ergou');
INSERT INTO `visitor` VALUES ('136', 'ergou');
INSERT INTO `visitor` VALUES ('137', 'ergou');
INSERT INTO `visitor` VALUES ('138', 'ergou');
INSERT INTO `visitor` VALUES ('139', 'xigua');
INSERT INTO `visitor` VALUES ('140', 'ergou');
INSERT INTO `visitor` VALUES ('141', 'xigua');
INSERT INTO `visitor` VALUES ('142', 'ergou');
INSERT INTO `visitor` VALUES ('143', '2');
INSERT INTO `visitor` VALUES ('144', 'lisi');
INSERT INTO `visitor` VALUES ('145', 'ergou');
INSERT INTO `visitor` VALUES ('146', 'lisi');
INSERT INTO `visitor` VALUES ('147', '11');
INSERT INTO `visitor` VALUES ('148', '1');
INSERT INTO `visitor` VALUES ('149', 'ergou');
INSERT INTO `visitor` VALUES ('150', '2');
INSERT INTO `visitor` VALUES ('151', 'ergou');
INSERT INTO `visitor` VALUES ('152', 'ergou');
INSERT INTO `visitor` VALUES ('153', 'ergou');
INSERT INTO `visitor` VALUES ('154', 'lisi');
INSERT INTO `visitor` VALUES ('155', 'ergou');
INSERT INTO `visitor` VALUES ('156', 'ergou');
INSERT INTO `visitor` VALUES ('157', '3');
INSERT INTO `visitor` VALUES ('158', 'ergou');
INSERT INTO `visitor` VALUES ('159', 'miner');
INSERT INTO `visitor` VALUES ('160', 'ergou');
INSERT INTO `visitor` VALUES ('161', 'ergou');
INSERT INTO `visitor` VALUES ('162', 'ergou');
INSERT INTO `visitor` VALUES ('163', 'ergou');
INSERT INTO `visitor` VALUES ('164', 'ergou');
INSERT INTO `visitor` VALUES ('165', 'ergou');
INSERT INTO `visitor` VALUES ('166', 'lanyu');
INSERT INTO `visitor` VALUES ('167', '1');
INSERT INTO `visitor` VALUES ('168', 'lanyu');
INSERT INTO `visitor` VALUES ('169', 'lanyu');
INSERT INTO `visitor` VALUES ('170', '1');
INSERT INTO `visitor` VALUES ('171', 'ergou');
INSERT INTO `visitor` VALUES ('172', 'ergou');
INSERT INTO `visitor` VALUES ('173', 'ergou');
INSERT INTO `visitor` VALUES ('174', '1');
INSERT INTO `visitor` VALUES ('175', '1');
INSERT INTO `visitor` VALUES ('176', '1');
INSERT INTO `visitor` VALUES ('177', 'ergou');
INSERT INTO `visitor` VALUES ('178', 'ergou');
INSERT INTO `visitor` VALUES ('179', 'wangwu');
INSERT INTO `visitor` VALUES ('180', 'ergou');
INSERT INTO `visitor` VALUES ('181', 'ergou');
INSERT INTO `visitor` VALUES ('182', 'ergou');
INSERT INTO `visitor` VALUES ('183', 'ergou');
INSERT INTO `visitor` VALUES ('184', 'lisi');
INSERT INTO `visitor` VALUES ('185', 'ergou');
INSERT INTO `visitor` VALUES ('186', 'ergou');
INSERT INTO `visitor` VALUES ('187', 'ergou');
INSERT INTO `visitor` VALUES ('188', 'lisi');
INSERT INTO `visitor` VALUES ('189', 'lisi');
INSERT INTO `visitor` VALUES ('190', 'lisi');
INSERT INTO `visitor` VALUES ('191', 'lisi');
INSERT INTO `visitor` VALUES ('192', 'ergou');
INSERT INTO `visitor` VALUES ('193', 'ergou');
INSERT INTO `visitor` VALUES ('194', 'ergou');
INSERT INTO `visitor` VALUES ('195', 'ergou');
INSERT INTO `visitor` VALUES ('196', '2');
INSERT INTO `visitor` VALUES ('197', '1');
INSERT INTO `visitor` VALUES ('198', '2');
INSERT INTO `visitor` VALUES ('199', 'ergou');
INSERT INTO `visitor` VALUES ('200', '1');
INSERT INTO `visitor` VALUES ('201', 'wangwu');
INSERT INTO `visitor` VALUES ('202', 'ergou');
