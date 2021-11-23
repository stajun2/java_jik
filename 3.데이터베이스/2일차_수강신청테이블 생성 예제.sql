-- 1. university_jik DB 생성, 있으면 삭제 후 생성
DROP SCHEMA IF EXISTS `university_jik`;
CREATE SCHEMA `university_jik`;

-- 2. university_jik DB 선택
USE `university_jik`;

-- 3. student 테이블 생성
-- 비밀번호를 255자로 하는 이유 : 일반적으로 비밀번호는 노출되면 안되기 때문에 암호화가 이루어짐
-- 암호화가 이루어지면 짧은 비밀번호가 긴 문자열로 바뀜
DROP TABLE IF EXISTS `university_jik`.`student`;
CREATE TABLE `university_jik`.`student` (
  `st_num` CHAR(10) NOT NULL,
  `st_id` VARCHAR(15) NOT NULL,
  `st_pw` VARCHAR(255) NOT NULL,
  `st_name` VARCHAR(50) NOT NULL,
  `st_reg_num` CHAR(14) NOT NULL,
  PRIMARY KEY (`st_num`),
  UNIQUE INDEX `st_id_UNIQUE` (`st_id` ASC) VISIBLE,
  UNIQUE INDEX `st_reg_num_UNIQUE` (`st_reg_num` ASC) VISIBLE);
  
  -- 테이블명 앞에 DB명이 붙은 경우와 안 붙는 경우의 차이
  -- 테이블명 앞에 DB명이 붙으면 현재 선택된 DB와 상관없이 테이블을 활용할 수 있다
  -- 테이블명 앞에 DB명이 안 붙으면 현재 선택된 DB에 테이블을 활용할 수 있다
  -- world DB가 선택된 상태에서 create table student();를 하면 world DB안에 student 테이블을 생성
  -- world DB가 선택된 상태에서 create table university_jik.student();를 하면 
  -- 선택된 DB와 상관없이 university_jik DB안에 student 테이블을 생성

-- 4. professor 테이블 생성  
DROP TABLE IF EXISTS `university_jik`.`professor`;
CREATE TABLE `university_jik`.`professor` (
  `pr_num` CHAR(10) NOT NULL,
  `pr_id` VARCHAR(15) NOT NULL,
  `pr_pw` VARCHAR(45) NOT NULL,
  `pr_name` VARCHAR(50) NOT NULL,
  `pr_reg_num` CHAR(14) NOT NULL,
  PRIMARY KEY (`pr_num`),
  UNIQUE INDEX `pr_id_UNIQUE` (`pr_id` ASC) VISIBLE,
  UNIQUE INDEX `pr_reg_num_UNIQUE` (`pr_reg_num` ASC) VISIBLE);
-- 5. subject 테이블 생성
DROP TABLE IF EXISTS `university_jik`.`subject`;
CREATE TABLE `university_jik`.`subject` (
  `su_num` INT NOT NULL AUTO_INCREMENT,
  `su_code` CHAR(6) NOT NULL,
  `su_schedule` VARCHAR(30) NULL,
  `su_class_num` INT NOT NULL DEFAULT 1,
  `su_title` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`su_num`));
-- 5. course 테이블 생성
DROP TABLE IF EXISTS `university_jik`.`course`;
CREATE TABLE `university_jik`.`course` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_st_num` CHAR(10) NOT NULL,
  `co_su_num` INT NOT NULL,
  `co_score` VARCHAR(4) NULL,
  PRIMARY KEY (`co_num`),
  INDEX `co_st_num_idx` (`co_st_num` ASC) VISIBLE,
  INDEX `co_su_num_idx` (`co_su_num` ASC) VISIBLE,
  CONSTRAINT `co_st_num` FOREIGN KEY (`co_st_num`) 
    REFERENCES `university_jik`.`student` (`st_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_su_num` FOREIGN KEY (`co_su_num`)
    REFERENCES `university_jik`.`subject` (`su_num`) ON DELETE CASCADE ON UPDATE CASCADE);
-- 6. lecture 테이블 생성
DROP TABLE IF EXISTS `university_jik`.`lecture`;
CREATE TABLE `university_jik`.`lecture` (
  `le_num` INT NOT NULL,
  `le_pr_num` CHAR(10) NOT NULL,
  `le_su_num` INT NOT NULL,
  PRIMARY KEY (`le_num`),
  INDEX `le_pr_num_idx` (`le_pr_num` ASC) VISIBLE,
  INDEX `le_su_num_idx` (`le_su_num` ASC) VISIBLE,
  CONSTRAINT `le_pr_num` FOREIGN KEY (`le_pr_num`)
    REFERENCES `university_jik`.`professor` (`pr_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `le_su_num` FOREIGN KEY (`le_su_num`)
    REFERENCES `university_jik`.`subject` (`su_num`)   ON DELETE CASCADE ON UPDATE CASCADE);