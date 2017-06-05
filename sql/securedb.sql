/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.4
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : securedb

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-06-05 17:18:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `function`
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `function_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` int(11) NOT NULL,
  `function_code` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('2', '1', 'listmodule', '模块列表');
INSERT INTO `function` VALUES ('3', '1', 'addmodule', '添加模块');
INSERT INTO `function` VALUES ('4', '1', 'addmodule_submit', '添加模块提交');
INSERT INTO `function` VALUES ('5', '3', 'addrole', '添加权限');
INSERT INTO `function` VALUES ('6', '3', 'rolesubmit', '添加权限提交');
INSERT INTO `function` VALUES ('7', '3', 'listrole', '角色列表');
INSERT INTO `function` VALUES ('8', '4', 'submitfunction', '功能拉交');
INSERT INTO `function` VALUES ('9', '11', 'register', '添加用户');
INSERT INTO `function` VALUES ('10', '11', 'register_submit', '提交添加用户');
INSERT INTO `function` VALUES ('11', '11', 'listuser', '用户列表');
INSERT INTO `function` VALUES ('12', '11', 'checkuser', '用户审核');
INSERT INTO `function` VALUES ('13', '11', 'usercheck_submit', '审核用户提交');
INSERT INTO `function` VALUES ('14', '3', 'listrolefunction', '角色功能');
INSERT INTO `function` VALUES ('15', '3', 'submitfunction', '功能提交');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '模块管理', '对模块信息进行管理');
INSERT INTO `module` VALUES ('3', '权限管理', '对权限信息进行管理');
INSERT INTO `module` VALUES ('4', '功能管理', '对功能信息进行管理');
INSERT INTO `module` VALUES ('11', '用户模块', '用户管理');

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '一级管理员', '管理用户模块');
INSERT INTO `roles` VALUES ('2', '二级管理员', '管理权限模块');
INSERT INTO `roles` VALUES ('3', '超级管理', '管理所有功能');

-- ----------------------------
-- Table structure for `role_function`
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `role_id` int(11) NOT NULL,
  `function_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES ('1', '2');
INSERT INTO `role_function` VALUES ('1', '7');
INSERT INTO `role_function` VALUES ('1', '11');
INSERT INTO `role_function` VALUES ('2', '6');
INSERT INTO `role_function` VALUES ('2', '7');
INSERT INTO `role_function` VALUES ('2', '8');
INSERT INTO `role_function` VALUES ('3', '2');
INSERT INTO `role_function` VALUES ('3', '3');
INSERT INTO `role_function` VALUES ('3', '4');
INSERT INTO `role_function` VALUES ('3', '5');
INSERT INTO `role_function` VALUES ('3', '6');
INSERT INTO `role_function` VALUES ('3', '7');
INSERT INTO `role_function` VALUES ('3', '8');
INSERT INTO `role_function` VALUES ('3', '9');
INSERT INTO `role_function` VALUES ('3', '10');
INSERT INTO `role_function` VALUES ('3', '11');
INSERT INTO `role_function` VALUES ('3', '12');
INSERT INTO `role_function` VALUES ('3', '13');
INSERT INTO `role_function` VALUES ('3', '14');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '1', '小明', '123', '1');
INSERT INTO `user` VALUES ('6', '3', 'admin', '123', '1');
