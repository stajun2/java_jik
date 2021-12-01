/* 음원 관리하는 사이트를 구축하려 한다. 이 때 필요한 ERD를 설계하세요. 
- 멜론, 지니 등을 참고
- 각자 제한 조건을 기술하고, 해당 제한 조건에 맞는 ERD를 설계
- 추천
  - 한명의 회원은 음원 하나당 한번만 추천 가능하고, 추천을 한번 더 누르면 취소
  - 하나의 음원에는 여러 회원이 추천 가능
- 재생목록
  - 회원당 여러 재생 목록을 가질 수 있다
  - 한 재생목록에는 여러 음원을 넣을 수 있다.
  - 하나의 음원은 여러 재생 목록에 들어 갈 수 있다
- 음원
  - 노래 하나하나
  - 하나의 음원에는 여러 가수들이 포함될 수 있다.
  - 어떤 가수가 피처링 했는지도 알 수 있다.
- 앨범
  - 여러 음원이 하나로 묶여 있는 테이블
  - 한 앨범에는 여러 음원을 같은 장르로 묶는다
  - 한 앨범에는 대표 가수 하나만 나타낸다
- 아티스트
  - 가수 개인
- 그룹
  - 앨범/음원을 발매할 때 포함되는 아티스트로, 솔로도 그룹으로 포함
- 구매
  - 회원은 포인트를 충전하여 음원을 구매한다.
  - 모든 음원은 고정되고 동일한 가격이다. 할인은 x, 이벤트 x
  - 한달 이용권 x
  - 구매한 음원은 취소 불가능
*/
CREATE DATABASE melon;
use melon;

DROP TABLE IF EXISTS `soundtrack`;

CREATE TABLE `soundtrack` (
	`sd_num`	int	NOT NULL,
	`sd_title`	varchar(50)	NULL,
	`sd_like`	int	NULL,
	`sd_lyrics`	longtext	NULL
);

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
	`ab_num`	int	NOT NULL,
	`ab_title`	varchar(50)	NULL,
	`ab_date`	date	NULL,
	`ab_publisher`	varchar(50)	NULL,
	`ab_agency`	varchar(50)	NULL,
	`ab_introduce`	longtext	NULL,
	`ab_genre`	varchar(50)	NULL,
	`ab_gr_num`	int	NOT NULL,
	`ab_gr_count`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist` (
	`at_num`	int	NOT NULL,
	`at_name`	varchar(50)	NULL,
	`at_birthday`	date	NULL,
	`at_agency`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
	`gr_num`	int	NOT NULL,
	`gr_name`	varchar(50)	NULL,
	`gr_type`	varchar(10)	NULL,
	`gr_agency`	varchar(50)	NULL,
	`gr_date`	date	NULL
);

DROP TABLE IF EXISTS `act`;

CREATE TABLE `act` (
	`ac_num`	int	NOT NULL,
	`ac_at_num`	int	NOT NULL,
	`ac_gr_num`	int	NOT NULL,
	`ac_role`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `sing`;

CREATE TABLE `sing` (
	`si_num`	int	NOT NULL,
	`si_sd_num`	int	NOT NULL,
	`si_gr_num`	int	NOT NULL,
	`si_feat`	int	NULL
);

DROP TABLE IF EXISTS `include`;

CREATE TABLE `include` (
	`in_num`	int	NOT NULL,
	`in_ab_num`	int	NOT NULL,
	`in_sd_num`	int	NOT NULL,
	`in_procedure`	varchar(10)	NULL,
	`in_title`	int	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
	`li_num`	int	NOT NULL,
	`li_sd_num`	int	NOT NULL,
	`li_me_id`	varchar(50)	NOT NULL,
	`li_state`	int	NULL
);

DROP TABLE IF EXISTS `playlist`;

CREATE TABLE `playlist` (
	`pl_num`	int	NOT NULL,
	`pl_sd_num`	int	NOT NULL,
	`pl_me_id`	varchar(50)	NOT NULL,
	`pl_name`	varchar(50)	NULL,
	`pl_procedure`	int	NULL
);

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
	`bu_num`	int	NOT NULL,
	`bu_sd_num`	int	NOT NULL,
	`bu_me_id`	varchar(50)	NOT NULL
);

ALTER TABLE `soundtrack` ADD CONSTRAINT `PK_SOUNDTRACK` PRIMARY KEY (
	`sd_num`
);

ALTER TABLE `album` ADD CONSTRAINT `PK_ALBUM` PRIMARY KEY (
	`ab_num`
);

ALTER TABLE `artist` ADD CONSTRAINT `PK_ARTIST` PRIMARY KEY (
	`at_num`
);

ALTER TABLE `group` ADD CONSTRAINT `PK_GROUP` PRIMARY KEY (
	`gr_num`
);

ALTER TABLE `act` ADD CONSTRAINT `PK_ACT` PRIMARY KEY (
	`ac_num`
);

ALTER TABLE `sing` ADD CONSTRAINT `PK_SING` PRIMARY KEY (
	`si_num`
);

ALTER TABLE `include` ADD CONSTRAINT `PK_INCLUDE` PRIMARY KEY (
	`in_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `like` ADD CONSTRAINT `PK_LIKE` PRIMARY KEY (
	`li_num`
);

ALTER TABLE `playlist` ADD CONSTRAINT `PK_PLAYLIST` PRIMARY KEY (
	`pl_num`
);

ALTER TABLE `buy` ADD CONSTRAINT `PK_BUY` PRIMARY KEY (
	`bu_num`
);

ALTER TABLE `album` ADD CONSTRAINT `FK_group_TO_album_1` FOREIGN KEY (
	`ab_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `act` ADD CONSTRAINT `FK_artist_TO_act_1` FOREIGN KEY (
	`ac_at_num`
)
REFERENCES `artist` (
	`at_num`
);

ALTER TABLE `act` ADD CONSTRAINT `FK_group_TO_act_1` FOREIGN KEY (
	`ac_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `sing` ADD CONSTRAINT `FK_soundtrack_TO_sing_1` FOREIGN KEY (
	`si_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `sing` ADD CONSTRAINT `FK_group_TO_sing_1` FOREIGN KEY (
	`si_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `include` ADD CONSTRAINT `FK_album_TO_include_1` FOREIGN KEY (
	`in_ab_num`
)
REFERENCES `album` (
	`ab_num`
);

ALTER TABLE `include` ADD CONSTRAINT `FK_soundtrack_TO_include_1` FOREIGN KEY (
	`in_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_soundtrack_TO_like_1` FOREIGN KEY (
	`li_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_member_TO_like_1` FOREIGN KEY (
	`li_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `playlist` ADD CONSTRAINT `FK_soundtrack_TO_playlist_1` FOREIGN KEY (
	`pl_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `playlist` ADD CONSTRAINT `FK_member_TO_playlist_1` FOREIGN KEY (
	`pl_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_soundtrack_TO_buy_1` FOREIGN KEY (
	`bu_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_member_TO_buy_1` FOREIGN KEY (
	`bu_me_id`
)
REFERENCES `member` (
	`me_id`
);

