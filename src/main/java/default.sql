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
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66641','min_gan_ci_ku_tong_ji','敏感词库统计(type=1[敏感数据分类])','1','财产信息','4','2020-11-05 10:16:36',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66642','min_gan_ci_ku_tong_ji','敏感词库统计(type=1[敏感数据分类])','1','健康生理信息','2','2020-11-05 10:16:36',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66643','min_gan_ci_ku_tong_ji','敏感词库统计(type=1[敏感数据分类])','1','身份信息','2','2020-11-05 10:16:36',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66644','min_gan_ci_ku_tong_ji','(敏感词库统计type=2[敏感数据分级])','2','绝密','3','2020-11-05 10:16:36',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66645','min_gan_ci_ku_tong_ji','(敏感词库统计type=2[敏感数据分级])','2','秘密','4','2020-11-05 10:16:36',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
insert into `report_general_data` (`id`, `name`, `remark`, `type`, `report_key`, `report_value`, `CREATE_TIME`, `update_time`, `proc_name`, `event_name`) values('66646','min_gan_ci_ku_tong_ji','(敏感词库统计type=2[敏感数据分级])','2','内部','1','2020-11-05 10:16:36',NULL,'proc_min_gan_ci_ku_tong_ji','event_min_gan_ci_ku_tong_ji');
