-- 학번이 2021123001 학생의 id와 pw를 수정하는 쿼리문
update student 
	set 
		st_id = 'kangkidong', 
        st_pw = 'kangkidongpw' 
	where 
		st_num = '2021123001';
update student 
	set 
		st_id = 'kangkidong', 
        st_pw = 'kangkidongpw' 
	where 
		st_name = '유관순';
SELECT * FROM university_jik.student;