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

-- 시간표 일정이 등록된 과목들
select * from subject where su_schedule is not null;

-- 시간표 일정이 등록되지 않은 과목들
select * from subject where su_schedule is null;

-- 과목 제목이 컴퓨터가 들어간 과목들
select * from subject where su_title like '%컴퓨터%';
-- 과목 제목이 컴퓨터로 시작하는 과목들
select * from subject where su_title like '컴퓨터%';
-- 과목 제목이 컴퓨터로 끝나는 과목들
select * from subject where su_title like '%컴퓨터';
-- 과목 제목이 컴퓨터로 시작하고, 과목 제목의 글자수가 5자인 과목들
select * from subject where su_title like '컴퓨터__';
-- 과목 제목이 컴퓨터로 시작하고, 과목 제목의 글자수가 6자인 과목들
select * from subject where su_title like '컴퓨터___';

-- 21학번 학생들을 확인하는 쿼리문을 작성하세요.
select * from student where st_num like '2021%';
select * from student where st_num like '2021______';
select * from student where st_num >= 2021000000 and st_num < 2022000000;

-- 컴공 학생들을 확인하는 쿼리문을 작성하세요. 컴공과 번호는 160
-- 학번 : 년도4자리 + 과번호 3자리 + 이름순 3자리
select * from student where st_num like '____160%';
-- 컴공 학생 + 끝자리가 160으로 끝나는 학생
select * from student where st_num like '%160%';

-- 학생들 중 여학생들을 확인하는 쿼리문을 작성하세요.
select * from student where st_reg_num like '______-2%' or st_reg_num like '______-4%';
select * from student where st_reg_num like '%-2%' or st_reg_num like '%-4%';

-- 학생들 정보를 이름순으로 정렬하는 쿼리문
select * from student order by st_name asc, st_num desc;