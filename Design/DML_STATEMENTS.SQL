INSERT INTO `jobmgmt`.`job_sts`(`job_sts_id`,`job_sts_nm`,`CREATE_USR_ID`,`CREATE_DTS`,`UPDT_USR_ID`, `UPDT_DTS`)
VALUES (1, 'Open','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`job_sts`(`job_sts_id`,`job_sts_nm`,`CREATE_USR_ID`,`CREATE_DTS`,`UPDT_USR_ID`, `UPDT_DTS`)
VALUES (2, 'Closed','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`account` (`clnt_id`,`clnt_nm`,`CREATE_USR_ID`,`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'Disney','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`account` (`clnt_id`,`clnt_nm`,`CREATE_USR_ID`,`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'Cisco','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());


INSERT INTO `jobmgmt`.`job_stg` (`job_stg_id`,`job_stg_nm`,`CREATE_USR_ID`,`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'FINALIZED','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`job_stg` (`job_stg_id`,`job_stg_nm`,`CREATE_USR_ID`,`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'NON_FINALIZED','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());


INSERT INTO `jobmgmt`.`empt_typ` (`empt_typ_id`,`empt_typ_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`, `UPDT_DTS`)
VALUES (1, 'FULL TIME','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`empt_typ` (`empt_typ_id`,`empt_typ_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`, `UPDT_DTS`)
VALUES (2, 'CONTRACTOR','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`service_ln` (`srvc_ln_id`,`srvc_ln_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`, `UPDT_DTS`)
VALUES (1, 'CSD','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`service_ln` (`srvc_ln_id`,`srvc_ln_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`, `UPDT_DTS`)
VALUES (2, 'SAP','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`service_ln_cap` (`srvc_ln_cap_id`,`srvc_ln_cap_nm`,`CREATE_USR_ID`,
`CREATE_DTS`, `UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_id`)
VALUES (1, 'CORE','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),1);

INSERT INTO `jobmgmt`.`service_ln_cap` (`srvc_ln_cap_id`,`srvc_ln_cap_nm`,`CREATE_USR_ID`,
`CREATE_DTS`, `UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_id`)
VALUES (2, 'BA','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),1);

INSERT INTO `jobmgmt`.`service_ln_cap` (`srvc_ln_cap_id`,`srvc_ln_cap_nm`,`CREATE_USR_ID`,
`CREATE_DTS`, `UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_id`)
VALUES (3, 'CORE','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),2);

INSERT INTO `jobmgmt`.`service_ln_cap` (`srvc_ln_cap_id`,`srvc_ln_cap_nm`,`CREATE_USR_ID`,
`CREATE_DTS`, `UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_id`)
VALUES (4, 'FUNCTIONAL','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),2);


INSERT INTO `jobmgmt`.`job_role` (`job_rl_id`,`job_rl_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_cap_id`)
VALUES (1, 'JAVA DEVELOPER','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),1);

INSERT INTO `jobmgmt`.`job_role` (`job_rl_id`,`job_rl_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_cap_id`)
VALUES (2, 'ORACLE DEVELOPER','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),1);

INSERT INTO `jobmgmt`.`job_role` (`job_rl_id`,`job_rl_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_cap_id`)
VALUES (3, 'SAP DEVELOPER','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),3);

INSERT INTO `jobmgmt`.`job_role` (`job_rl_id`,`job_rl_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`,`srvc_ln_cap_id`)
VALUES (4, 'SAP TESTER','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP(),3);

INSERT INTO `jobmgmt`.`resource_typ` (`res_typ_id`,`res_typ_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'GX EMPLOYEE','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`resource_typ` (`res_typ_id`,`res_typ_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'US EMPLOYEE','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`resource_typ` (`res_typ_id`,`res_typ_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (3, 'CONTRACTOR','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_sts`(`cndt_sts_id`,`cndt_sts_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'ACTIVE','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_sts`(`cndt_sts_id`,`cndt_sts_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'HIRED','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_sts`(`cndt_sts_id`,`cndt_sts_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (3, 'REJECTED','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_sts`(`cndt_sts_id`,`cndt_sts_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (4, 'DID NOT JOIN','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_ctg`(`cndt_ctg_id`,`cndt_ctg_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'INTERNAL','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_ctg`(`cndt_ctg_id`,`cndt_ctg_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'FOR HIRE','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`cndt_ctg`(`cndt_ctg_id`,`cndt_ctg_nm`,`CREATE_USR_ID`,`CREATE_DTS`,
`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (3, 'CONTRACTOR','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`ctznshp_sts` (`ctzn_shp_id`,`ctzn_shp_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'H1B','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`ctznshp_sts` (`ctzn_shp_id`,`ctzn_shp_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'OPT','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`ctznshp_sts` (`ctzn_shp_id`,`ctzn_shp_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (3, 'CITIZEN','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`ctznshp_sts` (`ctzn_shp_id`,`ctzn_shp_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (4, 'L1','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`intrvw_sts`(`intrvw_sts_id`,`intrvw_sts_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (1, 'PENDING','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`intrvw_sts`(`intrvw_sts_id`,`intrvw_sts_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (2, 'RECOMMENDED','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`intrvw_sts`(`intrvw_sts_id`,`intrvw_sts_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (3, 'NEXT ROUND','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

INSERT INTO `jobmgmt`.`intrvw_sts`(`intrvw_sts_id`,`intrvw_sts_nm`,`CREATE_USR_ID`,
`CREATE_DTS`,`UPDT_USR_ID`,`UPDT_DTS`)
VALUES (4, 'REJECTED','jobmgmt',CURRENT_TIMESTAMP(),'jobmgmt',CURRENT_TIMESTAMP());

