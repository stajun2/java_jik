/*
CREATE SCHEMA `community` ;
use `community`;
*/
CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_name`	varchar(30)	NULL,
	`me_gender`	varchar(6)	NULL,
	`me_birth`	date	NULL,
	`me_address`	varchar(100)	NULL,
	`me_phone`	varchar(13)	NULL
);

CREATE TABLE `board` (
	`bd_num`	int	NOT NULL,
	`bd_title`	varchar(100)	NULL,
	`bd_contentnts`	longtext	NULL,
	`bd_reg_date`	datetime	NULL,
	`bd_up_date`	datetime	NULL,
	`bd_type`	varchar(10)	NULL,
	`bd_me_id`	varchar(20)	NOT NULL,
	`bd_ori_num`	int	NOT NULL,
	`bd_del`	varchar(2)	NULL,
	`bd_del_date`	datetime	NULL
);

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL,
	`fi_ori_name`	varchar(255)	NULL,
	`fi_name`	varchar(255)	NULL,
	`fi_bd_num`	int	NOT NULL,
	`fi_del`	varchar(2)	NULL,
	`fi_del_date`	datetime	NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`bd_num`
);

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`fi_num`
);

ALTER TABLE `community`.`file` 
CHANGE COLUMN `fi_num` `fi_num` INT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `community`.`board` 
CHANGE COLUMN `bd_num` `bd_num` INT NOT NULL AUTO_INCREMENT ;



ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bd_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (
	`bd_ori_num`
)
REFERENCES `board` (
	`bd_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bd_num`
)
REFERENCES `board` (
	`bd_num`
);

