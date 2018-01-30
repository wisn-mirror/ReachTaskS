create database reachtask;

CREATE TABLE `rtuser` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `nickname` varchar(100)   COMMENT '用户昵称',
  `nameid` varchar(100)   COMMENT '用户号',
  `iconurl` varchar(100)   COMMENT '用户头像',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `encryption` varchar(200) NOT NULL COMMENT '密码加密',
  `phonenumber` varchar(13) NOT NULL COMMENT '手机号',
  `token` varchar(36) COMMENT 'token',
  `expired` bigint(13)  COMMENT 'token过期时间',
  `registertime` bigint(13) NOT NULL COMMENT '注册时间',
  `lastlogintime` bigint(13) NOT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `rtmessage` (
  `messageid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `fromuserid` bigint(20) NOT NULL  COMMENT '发送者用户ID',
  `targetuserid` bigint(20) NOT NULL  COMMENT '接收者用户ID',
  `messagetype` int(4) NOT NULL COMMENT '消息类型',
  `status` int(2) NOT NULL COMMENT '消息状态',
  `content` varchar(1000) NOT NULL COMMENT '消息内容',
  `createtime` bigint(13) NOT NULL COMMENT '创建时间',
  `receivetime` bigint(13) NOT NULL COMMENT '接收时间',
  PRIMARY KEY (`messageid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='消息表';

CREATE TABLE `rtresource` (
  `resourceid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `status` int(2)  COMMENT '图片状态',
  `restype` int(2)  COMMENT '文件类型',
  `imagepath` varchar(1000) NOT NULL COMMENT '图片路径',
  `createtime` bigint(13) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`resourceid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='资源表';

CREATE TABLE `rtmoment` (
  `momentid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `userid` bigint(20) NOT NULL  COMMENT '发送者用户ID',
  `status` int(2) NOT NULL COMMENT '图片状态',
  `content` varchar(1000) COMMENT '动态内容',
  `imageres` varchar(220) COMMENT '图片ids',
  `videores` varchar(220)  COMMENT '视频ids',
  `location` varchar(20)  COMMENT '地址',
  `createtime` bigint(13) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`momentid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='动态表';


insert into rtuser    (nickname,    nameid,    iconurl,    password,    encryption,    phonenumber,    registertime)     values
