-- insert into student values('2021160123','hong','hong','홍길동','020101-3456789');
-- id : hong123, pw : pw123으로 하려고 했으나 순서를 착각해서 잘못 입력했더니 원하지 않은 결과가 발생
-- insert into student values('2021160124','pw123','hong123','황길동','020505-3123456');

-- insert into student(st_num, st_id, st_pw, st_name, st_reg_num)
-- 	values('2021160001','kang','kang','강감창','021225-3654321');
-- id : kimid, pw : pwkim으로 하기 위해 속성 순서를 st_pw, st_id 순으로 바꿔서 원하는 결과가 나옴
-- insert into student(st_num, st_pw, st_id,  st_name, st_reg_num)
-- 	values('2021160015','pwkim','kimid','김영희','021225-4654321');
insert into student 
	values(2021123005, 'park', 'parkpw', '박철수','021221-4443332'),
	(2021456005, 'parkid', 'parkpw', '박수철','020808-3985612');
SELECT * FROM university_jik.student;