-- 컴퓨터 개론을 강의하는 교수님 교수번호을 확인하는 쿼리문을 작성하세요.
-- inner join : 테이블 순서에 상관없이 동일한 결과가 나옴
select le_pr_num from lecture
	inner join subject
    on le_su_num = su_num
    where su_title ='컴퓨터 개론';
select le_pr_num from subject
	inner join lecture
    on le_su_num = su_num
    where su_title ='컴퓨터 개론';
select le_pr_num from lecture
	join subject
    on le_su_num = su_num
    where su_title ='컴퓨터 개론';
    
-- 컴퓨터 개론 3분반 강의를 듣는 학생들의 명단을 확인하는 쿼리를 작성하세요.
-- 컴퓨터 개론 3분반 강의를 수강하는 학생들의 명단을 확인하는 쿼리를 작성하세요.
-- 수강 테이블
select st_num, st_name from course
	join subject
		on co_su_num = su_num
	join student
		on co_st_num = st_num
	where su_title = '컴퓨터 개론' and su_class_num = 3;

-- 2021160123 학번인 홍길동 학생이 수강한 모든 과목명을 확인하는 쿼리를 작성하세요.    
select su_title from course
	join subject
		on co_su_num = su_num
	where co_st_num = 2021160123;

-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인하는 쿼리를 작성하세요.
select st_name from lecture
	join professor	on pr_num = le_pr_num
	join course on co_su_num = le_su_num
    join student on co_st_num = st_num
    where pr_name = '이순신';
    



