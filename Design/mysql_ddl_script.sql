CREATE TABLE `account` (
  `clnt_id` int(11) NOT NULL AUTO_INCREMENT,
  `clnt_nm` varchar(30) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`clnt_id`),
  UNIQUE KEY `clnt_id_UNIQUE` (`clnt_id`),
  UNIQUE KEY `clnt_nm_UNIQUE` (`clnt_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `cndt_ctg` (
  `cndt_ctg_id` int(11) NOT NULL AUTO_INCREMENT,
  `cndt_ctg_nm` varchar(30) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`cndt_ctg_id`),
  UNIQUE KEY `cndt_ctg_id_UNIQUE` (`cndt_ctg_id`),
  UNIQUE KEY `cndt_ctg_nm_UNIQUE` (`cndt_ctg_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `cndt_sts` (
  `cndt_sts_id` int(11) NOT NULL AUTO_INCREMENT,
  `cndt_sts_nm` varchar(20) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`cndt_sts_id`),
  UNIQUE KEY `cndt_sts_id_UNIQUE` (`cndt_sts_id`),
  UNIQUE KEY `cndt_sts_nm_UNIQUE` (`cndt_sts_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `ctznshp_sts` (
  `ctzn_shp_id` int(11) NOT NULL AUTO_INCREMENT,
  `ctzn_shp_nm` varchar(45) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ctzn_shp_id`),
  UNIQUE KEY `ctzn_shp_id_UNIQUE` (`ctzn_shp_id`),
  UNIQUE KEY `ctzn_shp_nm_UNIQUE` (`ctzn_shp_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `empl_typ` (
  `empt_typ_id` int(11) NOT NULL AUTO_INCREMENT,
  `empt_typ_nm` varchar(30) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` varchar(20) NOT NULL,
  PRIMARY KEY (`empt_typ_id`),
  UNIQUE KEY `empt_typ_id_UNIQUE` (`empt_typ_id`),
  UNIQUE KEY `empt_typ_nm_UNIQUE` (`empt_typ_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `intrvw_sts` (
  `intrvw_sts_id` int(11) NOT NULL AUTO_INCREMENT,
  `intrvw_sts_nm` varchar(45) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`intrvw_sts_id`),
  UNIQUE KEY `intrvw_sts_id_UNIQUE` (`intrvw_sts_id`),
  UNIQUE KEY `intrvw_sts_nm_UNIQUE` (`intrvw_sts_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `req_dt` timestamp NULL DEFAULT NULL,
  `clsr_dt` timestamp NULL DEFAULT NULL,
  `crtr_rm` varchar(45) DEFAULT NULL,
  `reqstr_rm` varchar(45) DEFAULT NULL,
  `own_rm` varchar(45) DEFAULT NULL,
  `reqmnt_spc` varchar(45) DEFAULT NULL,
  `resr_cnt` int(11) DEFAULT NULL,
  `rl_str_dt` timestamp NULL DEFAULT NULL,
  `rl_end_dt` timestamp NULL DEFAULT NULL,
  `chrg_out_rt` int(11) DEFAULT NULL,
  `cntrt_rt` int(11) DEFAULT NULL,
  `trvl` tinyint(4) DEFAULT NULL,
  `opn_dt` timestamp NULL DEFAULT NULL,
  `prsnt_dt` timestamp NULL DEFAULT NULL,
  `job_sts_id` int(11) NOT NULL,
  `empt_typ_id` int(11) NOT NULL,
  `clnt_id` int(11) NOT NULL,
  `job_stg_id` int(11) NOT NULL,
  `job_rl_id` int(11) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `wwsid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  UNIQUE KEY `job_id_UNIQUE` (`job_id`),
  KEY `job_sts_ref_nm_idx` (`job_sts_id`),
  KEY `empt_typ_ref_nm_idx` (`empt_typ_id`),
  KEY `acct_ref_nm_idx` (`clnt_id`),
  KEY `job_stg_ref_nm_idx` (`job_stg_id`),
  KEY `job_rl_ref_nm_idx` (`job_rl_id`),
  CONSTRAINT `acct_ref_nm1` FOREIGN KEY (`clnt_id`) REFERENCES `account` (`clnt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `empt_typ_ref_nm1` FOREIGN KEY (`empt_typ_id`) REFERENCES `empl_typ` (`empt_typ_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_rl_ref_nm1` FOREIGN KEY (`job_rl_id`) REFERENCES `job_role` (`job_rl_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_stg_ref_nm1` FOREIGN KEY (`job_stg_id`) REFERENCES `job_stg` (`job_stg_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_sts_ref_nm1` FOREIGN KEY (`job_sts_id`) REFERENCES `job_sts` (`job_sts_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

CREATE TABLE `job_cndt` (
  `cndt_id` int(11) NOT NULL AUTO_INCREMENT,
  `cndt_nm` varchar(45) NOT NULL,
  `cndt_rsm` blob,
  `cntrctr_rt` varchar(20) DEFAULT NULL,
  `prmy_sk` varchar(72) DEFAULT NULL,
  `bu_ld_appr` tinyint(4) DEFAULT NULL,
  `cap_ld_appr` tinyint(4) DEFAULT NULL,
  `offr_dt` timestamp NULL DEFAULT NULL,
  `offr_acpt_dt` timestamp NULL DEFAULT NULL,
  `join_dt` timestamp NULL DEFAULT NULL,
  `act_join_dt` timestamp NULL DEFAULT NULL,
  `res_typ_id` int(11) NOT NULL,
  `cndt_sts_id` int(11) NOT NULL,
  `cndt_ctg_id` int(11) NOT NULL,
  `ctzn_shp_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`cndt_id`),
  UNIQUE KEY `job_cndt_id_UNIQUE` (`cndt_id`),
  KEY `res_typ_ref_nm_idx` (`res_typ_id`),
  KEY `cndt_sts_ref_nm_idx` (`cndt_sts_id`),
  KEY `cndt_ctg_ref_nm_idx` (`cndt_ctg_id`),
  KEY `ctzn_ref_nm_idx` (`ctzn_shp_id`),
  KEY `job_id_ref_nm_idx` (`job_id`),
  CONSTRAINT `cndt_ctg_ref_nm` FOREIGN KEY (`cndt_ctg_id`) REFERENCES `cndt_ctg` (`cndt_ctg_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cndt_sts_ref_nm` FOREIGN KEY (`cndt_sts_id`) REFERENCES `cndt_sts` (`cndt_sts_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ctzn_ref_nm` FOREIGN KEY (`ctzn_shp_id`) REFERENCES `ctznshp_sts` (`ctzn_shp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_id_ref_nm` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `res_typ_ref_nm` FOREIGN KEY (`res_typ_id`) REFERENCES `resource_typ` (`res_typ_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12393 DEFAULT CHARSET=latin1;

CREATE TABLE `job_intrvw` (
  `job_intrvw_id` int(11) NOT NULL AUTO_INCREMENT,
  `intrvr_nm` varchar(45) NOT NULL,
  `intrvw_tm` timestamp NULL DEFAULT NULL,
  `intrvr_pos` varchar(45) DEFAULT NULL,
  `intrvr_cmnts` longtext,
  `intrvw_sts_id` int(11) NOT NULL,
  `cndt_id` int(11) NOT NULL,
  `job_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`job_intrvw_id`),
  UNIQUE KEY `job_intrvw_id_UNIQUE` (`job_intrvw_id`),
  KEY `intrvw_sts_ref_nm_idx` (`intrvw_sts_id`),
  KEY `intrvw_cndt_id_ref_nm_idx` (`cndt_id`),
  KEY `intrvw_sts_ref_job_id_idx` (`job_id`),
  CONSTRAINT `intrvw_cndt_id_ref_nm` FOREIGN KEY (`cndt_id`) REFERENCES `job_cndt` (`cndt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `intrvw_sts_ref_job_id` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `intrvw_sts_ref_nm` FOREIGN KEY (`intrvw_sts_id`) REFERENCES `intrvw_sts` (`intrvw_sts_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

CREATE TABLE `job_role` (
  `job_rl_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_rl_nm` varchar(45) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `srvc_ln_cap_id` int(11) NOT NULL,
  PRIMARY KEY (`job_rl_id`),
  UNIQUE KEY `job_rl_id_UNIQUE` (`job_rl_id`),
  KEY `job_role_ref_name_idx` (`srvc_ln_cap_id`),
  CONSTRAINT `job_rl_ref_nm` FOREIGN KEY (`srvc_ln_cap_id`) REFERENCES `service_ln_cap` (`srvc_ln_cap_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `job_stg` (
  `job_stg_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_stg_nm` varchar(30) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`job_stg_id`),
  UNIQUE KEY `job_stg_id_UNIQUE` (`job_stg_id`),
  UNIQUE KEY `job_stg_nm_UNIQUE` (`job_stg_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `job_sts` (
  `job_sts_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_sts_nm` varchar(45) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`job_sts_id`),
  UNIQUE KEY `job_status_id_UNIQUE` (`job_sts_id`),
  UNIQUE KEY `job_sts_nm_UNIQUE` (`job_sts_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `portal_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `job_dashboard` varchar(255) DEFAULT NULL,
  `candidate_dashboard` varchar(255) DEFAULT NULL,
  `interview_dashboard` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  `CREATE_USR_ID` varchar(32) DEFAULT NULL,
  `CREATE_DTS` timestamp NULL DEFAULT NULL,
  `UPDT_USR_ID` varchar(45) DEFAULT NULL,
  `UPDT_DTS` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `portal_user_fk_role_nm_idx` (`role_name`),
  CONSTRAINT `portal_user_fk_role_nm` FOREIGN KEY (`role_name`) REFERENCES `portal_user_role` (`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `portal_user_role` (
  `role_name` varchar(32) NOT NULL,
  `default_job_dashboard` varchar(255) DEFAULT NULL,
  `default_candidate_dashboard` varchar(255) DEFAULT NULL,
  `default_interview_dashboard` varchar(255) DEFAULT NULL,
  `CREATE_USR_ID` varchar(45) DEFAULT NULL,
  `CREATE_DTS` timestamp NULL DEFAULT NULL,
  `UPDT_USR_ID` varchar(45) DEFAULT NULL,
  `UPDT_DTS` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `resource_typ` (
  `res_typ_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_typ_nm` varchar(30) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`res_typ_id`),
  UNIQUE KEY `res_id_UNIQUE` (`res_typ_id`),
  UNIQUE KEY `res_typ_nm_UNIQUE` (`res_typ_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `service_ln` (
  `srvc_ln_id` int(11) NOT NULL AUTO_INCREMENT,
  `srvc_ln_nm` varchar(30) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`srvc_ln_id`),
  UNIQUE KEY `srvc_id_UNIQUE` (`srvc_ln_id`),
  UNIQUE KEY `srvc_nm_UNIQUE` (`srvc_ln_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `service_ln_cap` (
  `srvc_ln_cap_id` int(11) NOT NULL AUTO_INCREMENT,
  `srvc_ln_cap_nm` varchar(45) NOT NULL,
  `CREATE_USR_ID` varchar(20) NOT NULL,
  `CREATE_DTS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDT_USR_ID` varchar(20) NOT NULL,
  `UPDT_DTS` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `srvc_ln_id` int(11) NOT NULL,
  PRIMARY KEY (`srvc_ln_cap_id`),
  UNIQUE KEY `srvc_ln_cap_id_UNIQUE` (`srvc_ln_cap_id`),
  KEY `srvc_ln_cap_ref_nm_idx` (`srvc_ln_id`),
  CONSTRAINT `srvc_ln_cap_ref_nm` FOREIGN KEY (`srvc_ln_id`) REFERENCES `service_ln` (`srvc_ln_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_billability` (
  `billability_id` int(11) NOT NULL AUTO_INCREMENT,
  `billability_ds` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`billability_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(75) DEFAULT NULL,
  `moderated_name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_closed_needs` (
  `wws_id` int(11) NOT NULL,
  `closing_reason` varchar(100) DEFAULT NULL,
  `closing_reason_details` varchar(100) DEFAULT NULL,
  `closing_reason_comment` varchar(500) DEFAULT NULL,
  `closing_reason_comment_details` varchar(500) DEFAULT NULL,
  `close_date` datetime DEFAULT NULL,
  `skill_comment` varchar(5000) DEFAULT NULL,
  `need_reason` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`wws_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `wws_grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_ds` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_need_close_reasons` (
  `close_reason_id` int(11) NOT NULL AUTO_INCREMENT,
  `close_reason` varchar(45) DEFAULT NULL,
  `close_reason_dtls` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`close_reason_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_need_master` (
  `wws_id` int(11) NOT NULL,
  `need_status` varchar(45) DEFAULT NULL,
  `practice_id` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `billability_id` int(11) DEFAULT NULL,
  `wws_skill_profile_id` int(11) DEFAULT NULL,
  `close_reason_id` int(11) DEFAULT NULL,
  `close_comments` varchar(500) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL,
  `project_start_dt` date DEFAULT NULL,
  `project_end_dt` date DEFAULT NULL,
  `close_dt` date DEFAULT NULL,
  `created_dt` datetime DEFAULT NULL,
  `updted_dt` datetime DEFAULT NULL,
  `short_desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`wws_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `wws_open_needs` (
  `wws_id` int(11) NOT NULL,
  `short_desc` varchar(200) DEFAULT NULL,
  `project_name` varchar(100) DEFAULT NULL,
  `project_start_date` datetime DEFAULT NULL,
  `project_end_date` datetime DEFAULT NULL,
  `client` varchar(100) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `local_grades` varchar(45) DEFAULT NULL,
  `mission_country` varchar(45) DEFAULT NULL,
  `mission_location` varchar(45) DEFAULT NULL,
  `work_anywhere` varchar(15) DEFAULT NULL,
  `internal_desc` varchar(6000) DEFAULT NULL,
  `private_comment` varchar(4000) DEFAULT NULL,
  `rm_handler_full_name` varchar(45) DEFAULT NULL,
  `creator_full_name` varchar(45) DEFAULT NULL,
  `requester_full_name` varchar(45) DEFAULT NULL,
  `project_type` varchar(75) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `tag_global_practice` varchar(75) DEFAULT NULL,
  `tags_email_sent` varchar(75) DEFAULT NULL,
  `skill_comment` varchar(4000) DEFAULT NULL,
  `need_reason` varchar(75) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `recruitment_needs` varchar(100) DEFAULT NULL,
  `lead_time` varchar(100) DEFAULT NULL,
  `week_by_status` varchar(100) DEFAULT NULL,
  `confidential_desc` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`wws_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds the open needs information uploaded from WWS file feed.';

CREATE TABLE `wws_practice` (
  `practice_id` int(11) NOT NULL AUTO_INCREMENT,
  `practice_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`practice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_skill` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill` varchar(200) DEFAULT NULL,
  `skill_category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE TABLE `wws_skill_profile` (
  `wws_skill_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `taleo_id` varchar(45) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `skill_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`wws_skill_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
