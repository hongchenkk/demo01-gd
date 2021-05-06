/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.7.26-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `report_general_data` (
	`id` int (11),
	`name` varchar (150),
	`remark` varchar (150),
	`type` varchar (150),
	`report_key` varchar (1500),
	`report_value` varchar (150),
	`CREATE_TIME` datetime ,
	`update_time` datetime ,
	`proc_name` varchar (300),
	`event_name` varchar (300)
); 
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66695','min_gan_ci_ku_tong_ji','敏感词库统计(type=1[敏感数据分类])','1','财产信息','1','2020-11-05 11:39:31',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66696','min_gan_ci_ku_tong_ji','敏感词库统计(type=1[敏感数据分类])','1','健康生理信息','1','2020-11-05 11:39:31',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66697','min_gan_ci_ku_tong_ji','敏感词库统计(type=1[敏感数据分类])','1','身份信息','1','2020-11-05 11:39:31',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66698','min_gan_ci_ku_tong_ji','(敏感词库统计type=2[敏感数据分级])','2','绝密','2','2020-11-05 11:39:31',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66699','min_gan_ci_ku_tong_ji','(敏感词库统计type=2[敏感数据分级])','2','秘密','1','2020-11-05 11:39:31',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
