-- 고객 명단 확인
select * from 고객;
-- 고객의 등급을 확인(중복을 제거)
select distinct 등급 from 고객;
-- 아이디가 apple인 고객의 주문 내역을 확인
select * from 주문 where 주문고객 = 'apple';
-- 아이디가 apple인 고객의 주문 제품을 확인
select distinct 제품명 from 주문 
	join 제품 on 주문제품 = 제품번호 where 주문고객 = 'apple';
-- 쿵떡 파이를 주문한 고객 명단을 확인
select distinct 주문고객 from 주문 
	join 제품 on 주문제품 = 제품번호
    where 제품명 = '쿵떡파이';
