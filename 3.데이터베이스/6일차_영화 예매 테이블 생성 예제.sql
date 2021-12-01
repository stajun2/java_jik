/* 영화 티켓 예매 사이트를 구축하기 위한 ERD를 설계하세요.
- CGV, 롯데시네마를 참고
- 예매는 회원만 가능
- 예매는 한번에 여러 좌석 가능
- 테이블

- 영화
  - 영화번호(pk), 제목, 연령, 런닝타임, 개봉일, 영화상세
- 영화장르
  - 영화장르번호(pk), 영화번호(fk), 장르명(fk)
- 장르
  - 장르명(pk)
- 인물
  - 인물번호(pk), 이름, 출생, 국적, 직업, 학력, 가족, 취미, 신체, 사이트, 바이오그래피 등
  - 가족을 테이블로 관리할 수 있지만 영화와 관련해서 배우 가족은 중요한게 아니기 때문에 하나의 속성으로 관리
  - 학력은 최종학력만 기술
  - 취미도 테이블로 만들 수 있지만 속성으로 관리
  - 직업도 테이블로 만들 수 있지만 속성으로 관리
- 참여
  - 참여번호(pk), 영화번호(fk), 인물번호(fk), 역할
- 극장
  - 극장번호(pk), 지역, 지점명, 주소, 교통안내, 주차안내, 관 갯수, 총 좌석
- 좌석
  - 좌석번호(pk), 좌석명, 극장번호(fk), 관번호, 좌석상태, 좌석타입
- 상영시간
  - 상영번호(pk), 영화번호(fk), 극장번호(fk),상영날짜, 상영시간, 관번호, 옵션(2D,4D), 총좌석수, 예약가능좌석수
- 회원
  - 아이디(pk), 비번, 기타 등
- 예매
  - 예매번호(pk), 아이디(fk), 상영번호(fk), [영화명]
- 예매 리스트
  - 예매리스트번호(pk), 예매번호(fk), 좌석번호(fk)

*/
CREATE DATABASE cgv;
USE cgv;

CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50)	NULL,
	`mo_age`	varchar(50)	NULL,
	`mo_runtime`	int	NULL,
	`mo_date`	date	NULL,
	`mo_detail`	longtext	NULL
);

CREATE TABLE `genre` (
	`ge_name`	varchar(50)	NOT NULL
);

CREATE TABLE `movie_genre` (
	`mg_num`	int	NOT NULL,
	`mg_ge_name`	varchar(50)	NOT NULL,
	`mg_mo_num`	int	NOT NULL
);

CREATE TABLE `character` (
	`ch_num`	int	NOT NULL,
	`ch_name`	varchar(50)	NULL,
	`ch_birthday`	varchar(10)	NULL,
	`ch_nationality`	varchar(50)	NULL,
	`ch_job`	varchar(50)	NULL
);

CREATE TABLE `participation` (
	`pt_num`	int	NOT NULL,
	`pt_mo_num`	int	NOT NULL,
	`pt_ch_num`	int	NOT NULL,
	`pt_role`	varchar(50)	NULL
);

CREATE TABLE `theater` (
	`th_num`	int	NOT NULL,
	`th_area`	varchar(50)	NULL,
	`th_name`	varchar(50)	NULL,
	`th_address`	varchar(50)	NULL,
	`th_traffic`	longtext	NULL,
	`th_parking`	longtext	NULL,
	`th_room_count`	int	NULL,
	`th_seat_count`	int	NULL
);

CREATE TABLE `seat` (
	`st_num`	int	NOT NULL,
	`st_name`	char(3)	NULL,
	`st_th_num`	int	NOT NULL,
	`st_room_num`	int	NULL,
	`st_state`	varchar(50)	NULL,
	`st_type`	varchar(50)	NULL
);

CREATE TABLE `schedule` (
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_th_num`	int	NOT NULL,
	`sc_date`	date	NULL,
	`sc_time`	varchar(5)	NULL,
	`sc_room_num`	int	NULL,
	`sc_option`	varchar(10)	NULL,
	`sc_total_seat`	int	NULL,
	`sc_seat`	int	NULL
);

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(255)	NULL
);

CREATE TABLE `ticketing` (
	`tk_num`	varchar(10)	NOT NULL,
	`tk_me_id`	varchar(50)	NOT NULL,
	`tk_sc_num`	int	NOT NULL
);

CREATE TABLE `ticketing_list` (
	`tl_num`	int	NOT NULL,
	`tl_tk_num`	varchar(10)	NOT NULL,
	`tl_st_num`	int	NOT NULL
);

ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`mo_num`
);

ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `PK_MOVIE_GENRE` PRIMARY KEY (
	`mg_num`
);

ALTER TABLE `character` ADD CONSTRAINT `PK_CHARACTER` PRIMARY KEY (
	`ch_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `PK_PARTICIPATION` PRIMARY KEY (
	`pt_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `PK_THEATER` PRIMARY KEY (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `PK_TICKETING` PRIMARY KEY (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `PK_TICKETING_LIST` PRIMARY KEY (
	`tl_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_movie_TO_participation_1` FOREIGN KEY (
	`pt_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_character_TO_participation_1` FOREIGN KEY (
	`pt_ch_num`
)
REFERENCES `character` (
	`ch_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_theater_TO_seat_1` FOREIGN KEY (
	`st_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_theater_TO_schedule_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`tk_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`tk_sc_num`
)
REFERENCES `schedule` (
	`sc_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_tk_num`
)
REFERENCES `ticketing` (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`tl_st_num`
)
REFERENCES `seat` (
	`st_num`
);

