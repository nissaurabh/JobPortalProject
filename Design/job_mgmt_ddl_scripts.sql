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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `job_cndt` (
  `cndt_id` int(11) NOT NULL AUTO_INCREMENT,
  `cndt_nm` varchar(45) NOT NULL,
  `cndt_rsm` blob,
  `cntrctr_rt` varchar(20) DEFAULT NULL,
  `prmy_sk` blob,
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
  `job_intrvw_id` int(11) NOT NULL,
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
  KEY `job_intrvw_ref_nm_idx` (`job_intrvw_id`),
  KEY `job_id_ref_nm_idx` (`job_id`),
  CONSTRAINT `cndt_ctg_ref_nm` FOREIGN KEY (`cndt_ctg_id`) REFERENCES `cndt_ctg` (`cndt_ctg_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cndt_sts_ref_nm` FOREIGN KEY (`cndt_sts_id`) REFERENCES `cndt_sts` (`cndt_sts_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ctzn_ref_nm` FOREIGN KEY (`ctzn_shp_id`) REFERENCES `ctznshp_sts` (`ctzn_shp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_id_ref_nm` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_intrvw_ref_nm` FOREIGN KEY (`job_intrvw_id`) REFERENCES `job_intrvw` (`job_intrvw_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `res_typ_ref_nm` FOREIGN KEY (`res_typ_id`) REFERENCES `resource_typ` (`res_typ_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `job_intrvw` (
  `job_intrvw_id` int(11) NOT NULL AUTO_INCREMENT,
  `intrvr_nm` varchar(45) NOT NULL,
  `intrvw_tm` timestamp NULL DEFAULT NULL,
  `intrvr_pos` varchar(45) DEFAULT NULL,
  `intrvr_cmnts` longtext,
  `intrvw_sts_id` int(11) NOT NULL,
  PRIMARY KEY (`job_intrvw_id`),
  UNIQUE KEY `job_intrvw_id_UNIQUE` (`job_intrvw_id`),
  UNIQUE KEY `job_intrvw_nm_UNIQUE` (`intrvr_nm`),
  KEY `intrvw_sts_ref_nm_idx` (`intrvw_sts_id`),
  CONSTRAINT `intrvw_sts_ref_nm` FOREIGN KEY (`intrvw_sts_id`) REFERENCES `intrvw_sts` (`intrvw_sts_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
