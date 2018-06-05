/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hwl002

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-04 16:53:37
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('7', '5', '1', '5', '2018-05-29 15:27:08', null);
INSERT INTO `article` VALUES ('8', '6', '1', '6', '2018-05-29 15:30:22', null);
INSERT INTO `article` VALUES ('9', '22', '1', '22', '2018-05-29 15:32:30', null);
INSERT INTO `article` VALUES ('12', '你好世界', '2', '嘻嘻', '2018-05-30 21:03:08', null);
INSERT INTO `article` VALUES ('16', '今天', 'ergou', '今天是我使用回帖吧的第一天，激动', '2018-05-31 20:25:11', null);
INSERT INTO `article` VALUES ('17', '大家好', 'lisi', '大家好我是lisi，很高兴认识你们', '2018-06-01 10:42:36', null);
INSERT INTO `article` VALUES ('18', '大家好，我是张三', '张三', '大家好，我是张三，很高兴认识大家', '2018-06-01 10:43:20', null);
INSERT INTO `article` VALUES ('26', '又是一个周一', 'ergou', '又要开始上学啦！', '2018-06-04 16:14:58', null);
INSERT INTO `article` VALUES ('27', '你们是谁，在下面留下你们的名字', '11', '大家好我的11，很开心认识你们。', '2018-06-04 16:25:58', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

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
INSERT INTO `comment` VALUES ('50', '0', 'nihao', '2018-05-31 20:44:23', '17', 'ergou');
INSERT INTO `comment` VALUES ('52', '0', '123', '2018-05-31 22:22:51', '8', '1');
INSERT INTO `comment` VALUES ('53', '0', '1234', '2018-05-31 22:23:21', '16', '1');
INSERT INTO `comment` VALUES ('54', '43', '1212', '2018-05-31 22:25:17', '16', '1');
INSERT INTO `comment` VALUES ('55', '50', '你好，我也是第一天使用这个呢', '2018-06-01 10:45:04', '17', '张三');
INSERT INTO `comment` VALUES ('56', '0', '欢迎大家在我的帖子里多留言。新人初到，请多多关照', '2018-06-01 10:45:37', '18', '张三');
INSERT INTO `comment` VALUES ('57', '56', '很开心见到你', '2018-06-01 10:53:39', '18', 'ergou');
INSERT INTO `comment` VALUES ('58', '0', '你好，我也是新人', '2018-06-01 11:13:27', '18', '1');
INSERT INTO `comment` VALUES ('59', '0', '可爱的小伙伴们今天有课吗？', '2018-06-04 16:15:21', '26', 'ergou');
INSERT INTO `comment` VALUES ('60', '58', '以后多多给我回帖呀            ', '2018-06-04 16:15:42', '18', 'ergou');
INSERT INTO `comment` VALUES ('61', '59', '呀，今天我们课超级多！    ', '2018-06-04 16:18:18', '26', 'xigua');
INSERT INTO `comment` VALUES ('62', '0', '你好，我是2，很高兴认识你', '2018-06-04 16:27:54', '27', '2');
INSERT INTO `comment` VALUES ('63', '0', '你好呀', '2018-06-04 16:37:30', '12', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1');
INSERT INTO `user` VALUES ('2', '2', '2');
INSERT INTO `user` VALUES ('6', '3', '3');
INSERT INTO `user` VALUES ('7', 'ergou', '123');
INSERT INTO `user` VALUES ('8', 'lisi,', ',');
INSERT INTO `user` VALUES ('9', 'lisi', '123');
INSERT INTO `user` VALUES ('10', '张三', '123');
INSERT INTO `user` VALUES ('11', 'xigua', '123');
INSERT INTO `user` VALUES ('12', '11', '11');

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

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
