CREATE TABLE `Spitter` (
  `id` bigint(20) NOT NULL auto_increment,
  `username` varchar(64) NOT NULL COMMENT '用户姓名',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `firstName` varchar(64) NOT NULL COMMENT '名字',
  `lastName` varchar(64) NOT NULL COMMENT '姓氏',
  `email` varchar(64)  COMMENT '邮箱',
  `headPicPath` varchar(64)  COMMENT '头像路径',
  PRIMARY KEY (`id`)
);

alter table Spitter add constraint username unique(username);

insert into Spitter values ('1', 'ynding', '111111', 'yanan', 'ding', '913690560@qq.com', null);
insert into Spitter values (null, 'sj-wany', '111111', 'yan', 'wang', '913690560@qq.com', null);
insert into Spitter values (null, 'admin', 'password', 'admin', 'admin', '913690560@qq.com', null);

