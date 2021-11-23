-- select문 기본 예제
select * from student;
select * from university_jik.student;
select * from `university_jik`.`student`;
select st_num, st_id, st_pw, st_name, st_reg_num from student;

select * from student where st_num = 2021123005;
select * from student where st_num = '2021123005';

-- 입학한 학생 전체를 확인하는 쿼리문을 작성하세요.
select * from student;

-- 홍길동 학생의 정보를 확인하는 쿼리문을 작성하세요.
select * from student where st_name = '홍길동';

-- 홍길동 학생이 아닌 학생들의 정보를 확인하는 쿼리문을 작성하세요.
select * from student where st_name != '홍길동';
select * from student where st_name <> '홍길동';
