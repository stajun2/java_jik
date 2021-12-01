/*
-- 카테고리 항목 추가
insert into category(ca_main, ca_sub) 
	values('아우터','점퍼'),('아우터','코트'),('상의','티셔츠'),('상의','블라우스/셔츠'),
    ('하의','데님'),('하의','팬츠'),('하의','스커트');
*/
-- 제품 등록
/*
insert into goods 
	values(1, '아크 폭스터 패딩', 159000, '패딩입니다', 1),
    (2, '엘비아 앙모코트', 229000, '앙모코트입니다', 2),
    (3, '클로 다운후드', 99000, '다운 후드입니다', 3),
    (4, '파코 레이어드탑', 43000, '탑', 4),
    (5, '기모 와이드 데님 팬츠', 43000, '팬츠', 5),
    (6, '롤스 버튼 팬츠', 36000, '팬츠', 6);
*/
-- 아이디가 abc123, 비밀번호가 abc123, 이름은 홍길동, 폰 번호는 010-1234-5678, 성별은 남자, 
-- 주소는 청주시, 우편번호는 1234, 주소 상세는 그린컴퓨터학원인 회원이 가입을 했다
-- 회원가입 => 신규 정보 => insert => member 테이블, address 테이블
-- 제품등록 => 신규 정보 => insert
-- 회원가입 순서1
-- member에 insert => address에 insert => member에 update
-- 회원가입 순서2
-- address에 insert => member에 insert
/*
insert into address values(1, null, '청주시', '1234', '그린컴퓨터학원');
insert into member values('abc123','abc123','홍길동','010-1234-5678','남자', 1);
*/
-- 아크 폭스터 패딩이 크기가 s, 색상은 화이트인 제품이 10개 입고 되었다
-- insert into `option` values(1, '화이트', 's', 10, 1);

-- abc123 회원이 아크 폭스터 패딩을 화이트 색상에 s 사이즈를 1개 구매했다
-- order에 insert
-- insert into `order` values('2021HNT001','abc123', 1, now(), 1, 159000, '결제완료');
-- option에 update
-- update `option` set op_stock = op_stock - 1 where op_num = 1;
-- abc123 회원이 주문한 아크 폭스터 패딩에 리뷰를 작성
-- insert into review values(1, '패딩 좋아요', '따뜻하고 좋아요', now(), 1, 'abc123');
select * from review;
