/* 프로시저 : 쿼리의 집합으로 함수라고 생각하면 됨 
- 장점
  1. 하나의 요청으로 여러 SQL문을 실행할 수 있다 => 네트워크 부하를 줄일 수 있다 
  2. 처리시간이 줄어든다 
  3. 응용 프로그램측 로직을 가지지 않고도 데이터의 앞뒤가 맞게 할 수 있다 
  4. 보수성이 뛰어나다 
- 단점
  1. 재사용성이 나쁘다 
  2. 업무의 사양 변경 시 프로시저의 정의를 병경할 필요가 있다 
- 프로시저 목록 확인 
show procedure status;
- 프로시저 스크립트 확인
show create procedure 프로시저명;
- 프로시저 정의 
drop procedure if exists 프로시저명;
delimiter //
create procedure 프로시저명
(
	[(in | out) 변수명 타입,
    ...
    (in | out) 변수명 타입]
)
begin
-- 실행코드
end //
delimiter ;
- 프로시저 호출 
call 프로시저명(변수나 값들); 
*/
-- show procedure status;
-- use sakila;
-- show create procedure film_in_stock;
use fruit_jik;
-- 과일 판매시 판매 금액을 자동으로 입력하여 판매 정보를 sell 테이블에 추가하는 프로시저 
drop procedure if exists insert_sell;
delimiter //
create procedure insert_sell(
	in in_fr_name varchar(50),
    in in_amount int,
    in in_unit varchar(50),
    in in_type varchar(50)
)
begin 
	declare _total_price int default 0; -- 과일 총 가격 
    declare _price int default 0; -- 과일 개당 가격
    set _price = (select fr_price from fruit where fr_name = in_fr_name);
    set _total_price = _price * in_amount;
    insert into sell
		select max(se_num)+1, in_fr_name, in_amount, in_unit, _total_price, now(), in_type
			from sell;
end //
delimiter ;
call insert_sell('딸기', 3, '상자', '카드');
select * from sell;

/* 
insert 트리거에서 새로 추가된 행에 update를 못함. 이럴 땐 프로시저를 이용해야 함. 
트리거는 이벤트마다 동일하게 처리하는 경우 사용. 아니면 프로시저를 이용
통신사에서 작년 사용 금액을 기준으로 올해 등급을 결정하는 과정을 하려 한다.
이때 프로시저? 트리거? => 프로시저 
제품을 구매할 때마다 구매 금액의 10프로를 포인트로 지급하려 한다. 
이때 프로시저? 트리거? => 트리거 
*/




