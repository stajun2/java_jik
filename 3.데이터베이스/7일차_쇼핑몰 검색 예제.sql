-- 분류가 아우터인 모든 제품을 확인 => 점퍼,코트 x, 아크 폭스터 패딩 o, 재고와 상관없이 등록된 제품
select gd_name as '아우터 제품' from goods join category 
	on goods.ca_num = category.ca_num 
	where ca_main = '아우터';
-- 분류가 아우터이고 구매 가능한 모든 제품을 확인, 재고가 있는 제품
select gd_name as '구매 가능한 아우터' from goods join category 
	on goods.ca_num = category.ca_num
    join `option`
    on gd_num = op_gd_num
    where ca_main = '아우터' and op_stock > 0;
-- 분류가 아우터이고, 가장 많이 팔린 제품 4가지를 확인
select goods.* from `order` join `option` on or_op_num = op_num
	join goods on gd_num = op_gd_num
    join category on category.ca_num = goods.ca_num
    where ca_main = '아우터' and or_state != '주문취소' and or_state != '환불'
    group by gd_num
    order by sum(or_amount) desc
    limit 4;
select goods.* from 
(select * from `order` where or_state != '주문취소' and or_state != '환불') as order2
	join `option` on or_op_num = op_num
	join goods on gd_num = op_gd_num
    join 
    (select * from category where ca_main = '아우터' ) as category2
    on category2.ca_num = goods.ca_num
    group by gd_num
    order by sum(or_amount) desc
    limit 4;
-- 등록된 아우터 제품의 전체 제품의 갯수를 확인
select count(*) as '아우터 제품 수' from goods 
	join category on category.ca_num = goods.ca_num
	where ca_main = '아우터';
-- 등록된 아우터 제품을 10개씩 화면에 출력할 때 2페이지에 해당하는 제품을 확인
select * from goods 
	join category on category.ca_num = goods.ca_num
	where ca_main = '아우터'
    limit 10, 10;

-- abc123 회원이 주문한 횟수
select count(*) as '주문횟수' from `order` where or_me_id = 'abc123';
-- abc123 회원의 2021년 상반기 사용 금액
select sum(or_total_price) as '누적 사용금액' from `order` 
	where or_state = '결제완료' and or_date like '2021%' and or_date < '2021-07-01';

-- 아크폭스터 패딩에 달린 리뷰들을 확인
select * from review join goods on re_gd_num = gd_num 
	where gd_name = '아크 폭스터 패딩';
