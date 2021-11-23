-- 학번이 2021123001 학생의 id와 pw를 수정하는 쿼리문
update student 
	set 
		st_id = 'kangkidong', 
        st_pw = 'kangkidongpw' 
	where 
		st_num = 2021123001;
update student 
	set 
		st_id = 'kangkidong', 
        st_pw = 'kangkidongpw' 
	where 
		st_name = '유관순';
        
-- 2000160001교수님이 1번 과목을 강의할 강의 시간표의 일정이 나왔다. 월1,2로 결정되었고, 분반은 3분반이다.
-- 다음을 실행하는 쿼리문을 작성하세요.
update subject set su_schedule = '월1, 월2', su_class_num = 3 where su_num = 1;
