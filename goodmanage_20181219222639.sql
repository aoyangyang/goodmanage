/*
MySQL Backup
Database: goodmanage
Backup Time: 2018-12-19 22:26:39
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `goodmanage`.`goods`;
DROP TABLE IF EXISTS `goodmanage`.`goodstype`;
DROP TABLE IF EXISTS `goodmanage`.`roles`;
DROP TABLE IF EXISTS `goodmanage`.`users`;
CREATE TABLE `goods` (
  `goodsID` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `goodsPrice` double DEFAULT NULL,
  `goodsCount` int(11) DEFAULT NULL COMMENT '商品数量',
  `goodsDep` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `goodsType` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL,
  `typename` varchar(50) CHARACTER SET utf8 NOT NULL,
  `typedes` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `roleName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `roleDesc` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
CREATE TABLE `users` (
  `userName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `pwd` varchar(32) CHARACTER SET utf8 NOT NULL,
  `validateFlag` int(11) DEFAULT '1',
  `roles` int(11) DEFAULT '2',
  PRIMARY KEY (`userName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
BEGIN;
LOCK TABLES `goodmanage`.`goods` WRITE;
DELETE FROM `goodmanage`.`goods`;
INSERT INTO `goodmanage`.`goods` (`goodsID`,`goodsName`,`goodsPrice`,`goodsCount`,`goodsDep`,`goodsType`) VALUES (1, 'iPhone5s', 5000, 13, 'A1222', 1),(2, 'SonyTV', 2999, 133, 'A2222', 2),(3, '金士顿', 220, 84, 'U盘', 4),(4, 'HP电脑', 4800, 15, '笔记本', 4),(11, '华硕电脑', 4800, 3, '手提,轻便笔记本', 4),(12, '联想电脑', 11, 33, '电子产品', 2),(13, '宏碁电脑', 3, 3, '电子产品', 4),(14, '铅笔', 220, 2, '学习用品', 5),(15, 'HP电脑', 220, 15, '笔记本', 4),(16, '书桌', 123.8, 21, '学习用品', 1);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `goodmanage`.`goodstype` WRITE;
DELETE FROM `goodmanage`.`goodstype`;
INSERT INTO `goodmanage`.`goodstype` (`id`,`typename`,`typedes`) VALUES (1, '办公用品', '用于办公的笔、纸张等'),(2, '笔记本', '笔记本电脑'),(3, '图书', '书籍'),(4, '电脑耗材', '电脑相关配件'),(5, '文具用品', '笔、纸'),(43, '3', '3');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `goodmanage`.`roles` WRITE;
DELETE FROM `goodmanage`.`roles`;
INSERT INTO `goodmanage`.`roles` (`id`,`roleName`,`roleDesc`) VALUES (1, '系统管理员', '进行商品项目后台管理'),(2, '普通用户', '进行商品订购');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `goodmanage`.`users` WRITE;
DELETE FROM `goodmanage`.`users`;
INSERT INTO `goodmanage`.`users` (`userName`,`pwd`,`validateFlag`,`roles`) VALUES ('jerry', '202cb962ac59075b964b07152d234b70', 1, 2),('lisi', 'a02cc9a3fc5def5275b5ca22f0d8f414', 0, 1),('mary', '9db06bcff9248837f86d1a6bcf41c9e7', 0, 1),('peter', 'e10adc3949ba59abbe56e057f20f883e', 0, 1),('zhangsan', '14e1b600b1fd579f47433b88e8d85291', 1, 2),('丽丽', 'e10adc3949ba59abbe56e057f20f883e', 1, 1),('城市', 'e10adc3949ba59abbe56e057f20f883e', 1, 1),('小', '3aff6673c2b44eaa948b108a0d8576a0', 1, 1),('小明', 'e10adc3949ba59abbe56e057f20f883e', 1, 2),('文文', 'e10adc3949ba59abbe56e057f20f883e', 1, 2),('王五', 'e10adc3949ba59abbe56e057f20f883e', 1, 1),('肖晓', 'e10adc3949ba59abbe56e057f20f883e', 1, 1);
UNLOCK TABLES;
COMMIT;
