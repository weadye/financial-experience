drop database if exists FinExperienceDB ;
CREATE DATABASE FinExperienceDB DEFAULT CHARACTER SET = utf8mb4;

use FinExperienceDB;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(500) NOT NULL DEFAULT 'default' COMMENT '用户名',
  `password` varchar(500) NOT NULL DEFAULT 'default' COMMENT '用户密码',
  `openid` varchar(500) NOT NULL DEFAULT '' COMMENT '用户密码',
  `session_key` varchar(500) NOT NULL DEFAULT '' COMMENT '用户密码',
  `unionid` varchar(500) NOT NULL DEFAULT '' COMMENT '用户密码',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `created_by` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `changed_by` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `changed_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';