CREATE TABLE `t_notice` (
  `id` varchar(36) NOT NULL COMMENT '逻辑主键',
  `context` varchar(200) DEFAULT NULL COMMENT '公告内容',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_use` int(11) DEFAULT NULL COMMENT '0--可用 1--不可用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;