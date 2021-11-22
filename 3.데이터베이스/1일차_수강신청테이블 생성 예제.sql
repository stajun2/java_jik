-- university 데이터베이스를 생성하여,
-- ERD를 이용하여 student 테이블, professor 테이블, subject 테이블을 생성하세요.
-- university DB 생성
-- create database university;
-- 생성한 university DB 확인
-- show databases;
use university;
DROP TABLE IF EXISTS student;
create table student(
	st_id varchar(15) not null unique,
    st_pw varchar(20) not null,
    st_reg_num char(14) not null unique,
    st_name varchar(50) not null,
    st_num char(10) not null,
    constraint primary key(st_num)
);

-- explain student;

DROP TABLE IF EXISTS professor;
create table professor(
	pr_id varchar(15) not null unique,
    pr_pw varchar(20) not null,
    pr_reg_num char(14) not null unique,
    pr_name varchar(50) not null,
    pr_num char(10) not null,
    constraint primary key(pr_num)
);
explain professor;

DROP TABLE IF EXISTS subject;
create table subject(
	su_num int not null auto_increment,
    su_title varchar(30) not null,
    su_code varchar(6) not null,
    su_schedule varchar(30),
    su_class_num int,
    constraint primary key(su_num)
);
explain subject;

-- 수강테이블(course)
drop table if exists course;
create table course(
	co_num int auto_increment,
    co_st_num char(10) not null,
    co_su_num int not null,
    co_score varchar(4),
    constraint primary key(co_num),
    constraint foreign key(co_st_num) references student(st_num),
    constraint foreign key(co_su_num) references subject(su_num)
);
explain course;
-- 강의테이블(lecture)
drop table if exists lecture;
create table lecture(
	le_num int auto_increment,
    le_pr_num char(10) not null,
    le_su_num int not null,
    constraint primary key(le_num),
    constraint foreign key(le_pr_num) references professor(pr_num),
    constraint foreign key(le_su_num) references subject(su_num)
);
explain lecture;