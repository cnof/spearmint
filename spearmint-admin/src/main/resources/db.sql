
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_menu`
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
                            `menu_id` varchar(36) NOT NULL,
                            `parent_id` varchar(36) DEFAULT NULL,
                            `menu_name` varchar(50) DEFAULT NULL,
                            `menu_code` varchar(50) DEFAULT NULL,
                            `menu_location` varchar(50) DEFAULT NULL,
                            `url` varchar(50) DEFAULT NULL,
                            `perms` varchar(50) DEFAULT NULL,
                            `icon` varchar(50) DEFAULT NULL,
                            `level` int(11) DEFAULT NULL,
                            `type` int(11) DEFAULT NULL,
                            PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES ('11cdca21f5f44cc881852ea47c2213b4', 'a27d9b307b91404a96be21be454745d6', '角色管理', 'S003', 'role', '', '', '', '1', '2');
INSERT INTO `admin_menu` VALUES ('2484673f769445948a81b39ec4558dc4', 'a27d9b307b91404a96be21be454745d6', '菜单管理', 'S004', 'menu', '', '', '', '1', '2');
INSERT INTO `admin_menu` VALUES ('772d336b8a6742c8aa248784a25910d2', 'a27d9b307b91404a96be21be454745d6', '用户管理', 'S002', 'user', '', '', '', '1', '2');
INSERT INTO `admin_menu` VALUES ('a27d9b307b91404a96be21be454745d6', '0', '系统管理', 'S001', 'system', '', '', '', '0', '1');

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
                            `role_id` varchar(36) NOT NULL,
                            `role_code` varchar(36) DEFAULT NULL,
                            `role_name` varchar(20) DEFAULT NULL,
                            PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('e6d729645fc5713a11f6e462b0639a7b', null, 'ROLE_admin');

-- ----------------------------
-- Table structure for `admin_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu` (
                                 `role_menu_id` varchar(36) NOT NULL,
                                 `role_id` varchar(36) DEFAULT NULL,
                                 `menu_id` varchar(36) DEFAULT NULL,
                                 PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES ('178d7a825d00e58c51fed5c09242d956', 'e6d729645fc5713a11f6e462b0639a7b', '772d336b8a6742c8aa248784a25910d2');
INSERT INTO `admin_role_menu` VALUES ('39c87ce2fa1c897c18c8e7e4024f13ea', 'e6d729645fc5713a11f6e462b0639a7b', 'a27d9b307b91404a96be21be454745d6');
INSERT INTO `admin_role_menu` VALUES ('7d698584390a5ca56fa20c3e2d6c309f', 'e6d729645fc5713a11f6e462b0639a7b', '2484673f769445948a81b39ec4558dc4');
INSERT INTO `admin_role_menu` VALUES ('d8fb2cd9c7b2ad584924aaadf8cad616', 'e6d729645fc5713a11f6e462b0639a7b', '11cdca21f5f44cc881852ea47c2213b4');

-- ----------------------------
-- Table structure for `admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
                            `user_id` varchar(36) NOT NULL,
                            `username` varchar(50) DEFAULT NULL,
                            `password` varchar(50) DEFAULT NULL,
                            `real_name` varchar(50) DEFAULT NULL,
                            `enabled` int(11) DEFAULT NULL,
                            `remark` varchar(200) DEFAULT NULL,
                            `last_password_reset_date` datetime DEFAULT NULL,
                            PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('string', 'string', 'string', 'string', '0', 'string', '2019-02-21 15:58:26');

-- ----------------------------
-- Table structure for `admin_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
                                 `user_role_id` varchar(36) NOT NULL,
                                 `role_id` varchar(36) DEFAULT NULL,
                                 `user_id` varchar(36) DEFAULT NULL,
                                 PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES ('9cd9e378f853fe0d343cf6cc361750bc', 'e6d729645fc5713a11f6e462b0639a7b', 'string');
