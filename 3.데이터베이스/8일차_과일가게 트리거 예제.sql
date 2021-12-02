/* 트리거 : 테이블에 대한 이벤트에 반응해 자동으로 실행되는 작업
 - 데이터 무결성을 지킬 수 있다 => 연관된 테이블간의 데이터 일관성을 유지
 - 트리거 사용 방법
   1. 트리거 생성
   2. 이벤트를 발생
 - 트리거 기본 형태
delimiter //
create trigger 트리거명 타이밍(after|before) 이벤트명(insert|update|delete) on 테이블명
for each row
begin
-- 실행코드
end //
delimiter ; 
 - old : update 이벤트 발생할 때 사용 가능한 것으로, 값이 바뀌기전의 행
 - new : insert, update 이벤트 발생할 때 사용한 것으로, 값이 바뀐후의 행 또는 새로 추가된 행
 - 변수 방법
 declare 변수명 자료형 default 기본값;
 - 변수값 변경 방법
 set 변수명 = 값;
 set 변수명 = (select를 이용한 검색 결과);
*/
use fruit_jik;
drop trigger if exists insert_buy;
delimiter //
create trigger insert_buy after insert on buy
for each row
begin
	-- 구매한 과일의 수량 : new.bu_amount
    -- 구매한 과일의 이름 : new.bu_fr_name
    update fruit
		set
			fr_amount = fr_amount + new.bu_amount
		where
			fr_name = new.bu_fr_name;
end //
delimiter ;
-- 트리거 확인을 위해 buy 테이블에 행을 추가
-- insert into buy values(2, '바나나', 50, now(), '송이', '과일상회');
-- 트리거에 의해 fruit 테이블이 변경됐는지 확인
SELECT * FROM fruit_jik.fruit;
-- 만들어진 트리거를 확인
show triggers;
-- 과일을 판매 했을 때 과일 수량을 맞춰주는 트리거를 만들어 보세요.
drop trigger if exists insert_sell;
delimiter //
create trigger insert_sell after insert on sell
for each row
begin
	declare _amount int default 0;
    set _amount = new.se_amount;
    update fruit
		set
			fr_amount = fr_amount - _amount
		where
			fr_name = new.se_fr_name;
end //
delimiter ;
-- 트리거 확인을 위해 sell 테이블에 행 추가
insert into sell values(2,'바나나', 3, '송이', 12000, now(), '카드');
-- 트리거 동작 확인
select * from fruit;



