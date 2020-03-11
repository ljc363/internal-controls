-- 菜单
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) COMMENT '菜单名称',
  `url` varchar(200) COMMENT '菜单URL',
  `perms` varchar(500) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) COMMENT '菜单图标',
  `order_num` int COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='菜单管理';

-- 岗位
CREATE TABLE `sys_post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COMMENT '岗位名称',
  `order_num` int COMMENT '排序',
  `del_flag` tinyint DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`position_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='岗位管理';

-- 系统用户
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) COMMENT '密码',
  `salt` varchar(20) COMMENT '盐',
  `status` tinyint COMMENT '状态  0：禁用   1：正常',
  `post_name` bigint(20) COMMENT '岗位',
  `create_user_id` bigint(20) COMMENT '创建者ID',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统用户';

-- 角色
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) COMMENT '角色名称',
  `remark` varchar(100) COMMENT '备注',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='角色';

--项目记录
CREATE TABLE `sys_project_m` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL COMMENT '项目名称',
  `number` varchar(50) COMMENT '项目编号',
  `person_in_charge` varchar(100) NOT NULL COMMENT '负责人',
  `starts_time` datetime COMMENT '开始时间',
  `end_time` datetime COMMENT '结束时间',
  `status` tinyint COMMENT '状态  0未开始，1开发中，2延期，3完成',
  `remark` varchar(500) COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='项目记录';

--任务计划表
CREATE TABLE `sys_task_schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL COMMENT '项目名称',
  `task_name` varchar(100) NOT NULL COMMENT '任务名称',
  `sub_task` varchar(100) COMMENT '子任务',
  `planned_start_time` datetime COMMENT '计划开始时间',
  `planned_end_time` datetime COMMENT '计划结束时间',
  `actual_start_time` datetime COMMENT '实际开始时间',
  `actual_end_time` datetime COMMENT '实际结束时间',
  `status` tinyint COMMENT '状态 ',
  `person_in_charge` varchar(100) NOT NULL COMMENT '负责人',
  `auditor` varchar(100) COMMENT '审核人',
  `remark` varchar(500) COMMENT '备注',
  "estimated_working_hours" varchar(20) COMMENT '预计工时',
  "actual_working_hours" varchar(20) COMMENT '实际工时',
   PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='任务计划表';

--工作日报
CREATE TABLE `sys_daily_work_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `work_done_today` MEDIUMTEXT  COMMENT '完成的工作',
  `unfinished_work` MEDIUMTEXT  COMMENT '未完成的工作',
  `coordinate` varchar(500) COMMENT '协调工作',
  `submission_time` datetime COMMENT '提交时间',
  `submitter` varchar(100) COMMENT '提交人',
  `remarks` varchar(500) COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='工作日报';

--工作周报
CREATE TABLE `sys_weekly_work_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `work_done_this_week` MEDIUMTEXT  COMMENT '本周完成的工作',
  `week_summary` MEDIUMTEXT  COMMENT '本周工作总结',
  `work_plan_for_next_week` MEDIUMTEXT  COMMENT '下周工作计划',
  `coordinate` varchar(500) COMMENT '协调工作',
  `submission_time` datetime COMMENT '提交时间',
  `submitter` varchar(100) COMMENT '提交人',
  `remarks` varchar(500) COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='工作周报';

-- 用户与角色对应关系
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint COMMENT '用户ID',
  `role_id` bigint COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='用户与角色对应关系';

-- 用户与岗位对应关系
CREATE TABLE `sys_user_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint COMMENT '用户ID',
  `post_id` bigint COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='用户与岗位对应关系';


-- 角色与菜单对应关系
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint COMMENT '角色ID',
  `menu_id` bigint COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='角色与菜单对应关系';


-- 系统用户Token
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统用户Token';

-- 系统验证码
CREATE TABLE `sys_captcha` (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统验证码';



-- 系统配置信息
CREATE TABLE `sys_config` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`param_key` varchar(50) COMMENT 'key',
	`param_value` varchar(2000) COMMENT 'value',
	`status` tinyint DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
	`remark` varchar(500) COMMENT '备注',
	PRIMARY KEY (`id`),
	UNIQUE INDEX (`param_key`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统配置信息表';


-- 系统日志
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COMMENT '用户名',
  `operation` varchar(50) COMMENT '用户操作',
  `method` varchar(200) COMMENT '请求方法',
  `params` varchar(5000) COMMENT '请求参数',
  `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) COMMENT 'IP地址',
  `create_date` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统日志';


-- 文件上传
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) COMMENT 'URL地址',
  `create_date` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='文件上传';








-- 初始数据 
INSERT INTO `sys_user` (`user_id`, `username`, `password`, `salt`, `status`,`position_id`, `create_user_id`, `create_time`) VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '1','1', '1', '2020-3-8 11:11:11');

INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 2);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'http://localhost:8089/internal-control/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO `sys_menu` VALUES (31, 0, '其他管理', '', '', 0, 'shouye', 3);
INSERT INTO `sys_menu` VALUES (32, 31, '项目管理', 'sys/projectM', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (34, 32, '新增', 'sys/user', 'sys:projectM:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (35, 32, '修改', 'sys/projectM', 'sys:projectM:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (36, 32, '删除', 'sys/projectM', 'sys:projectM:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (37, 31, ' 任务计划表', 'sys/taskSchedule', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (39, 32, '查看', 'sys/projectM', 'sys:projectM:list,sys:projectM:info', 2, '', 0);
INSERT INTO `sys_menu` VALUES (40, 37, '查看', 'sys/taskSchedule', 'sys:taskSchedule:list,sys:taskSchedule:info', 2, '', 0);
INSERT INTO `sys_menu` VALUES (41, 37, '新增', 'sys/taskSchedule', 'sys:taskSchedule:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (42, 37, '修改', 'sys/taskSchedule', 'sys:taskSchedule:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (43, 37, '删除', 'sys/taskSchedule', 'sys:taskSchedule:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (44, 31, '周报', 'sys/weeklyWorkReport', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (46, 44, '新增', 'sys/weeklyWorkReport', 'sys:weeklyWorkReport:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (47, 44, '修改', 'sys/weeklyWorkReport', 'sys:weeklyWorkReport:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (48, 44, '删除', 'sys/weeklyWorkReport', 'sys:weeklyWorkReport:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (49, 44, '查看', 'sys/weeklyWorkReport', 'sys:weeklyWorkReport:list,sys:weeklyWorkReport:info', 2, 'sys/weeklyWorkReport', 0);
INSERT INTO `sys_menu` VALUES (50, 31, '日报', 'sys/dailyWorkReport', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (51, 50, '查看', 'sys/dailyWorkReport', 'sys:dailyWorkReport:list,sys:dailyWorkReport:info', 2, '', 0);
INSERT INTO `sys_menu` VALUES (52, 50, '新增', 'sys/dailyWorkReport', 'sys:dailyWorkReport:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (53, 50, '修改', 'sys/dailyWorkReport', 'sys:dailyWorkReport:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (54, 50, '删除', 'sys/dailyWorkReport', 'sys:dailyWorkReport:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (55, 0, '用户管理', '', '', 0, '', 1);
INSERT INTO `sys_menu` VALUES (56, 55, '岗位管理', '/sys/position', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (57, 56, '查看', '/sys/position', 'sys:position:list,sys:position:info', 2, '', 0);
INSERT INTO `sys_menu` VALUES (59, 56, '修改', 'sys/position', 'sys:position:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (60, 56, '删除', 'sys/position', 'sys:position:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (61, 56, '新增', 'sys/position', 'sys:position:save', 2, '', 0);


INSERT INTO `sys_config` (`param_key`, `param_value`, `status`, `remark`) VALUES ('CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');


INSERT INTO `sys_position` (`position_id`, `parent_id`, `name`, `order_num`, `del_flag`) VALUES ('1', '0', '技术一部', '0', '0');
INSERT INTO `sys_position` (`position_id`, `parent_id`, `name`, `order_num`, `del_flag`) VALUES ('2', '1', 'java', '1', '0');
INSERT INTO `sys_position` (`position_id`, `parent_id`, `name`, `order_num`, `del_flag`) VALUES ('3', '1', 'Ios', '2', '0');
INSERT INTO `sys_position` (`position_id`, `parent_id`, `name`, `order_num`, `del_flag`) VALUES ('4', '1', '测试', '0', '0');
INSERT INTO `sys_position` (`position_id`, `parent_id`, `name`, `order_num`, `del_flag`) VALUES ('5', '1', 'Android', '1', '0');







