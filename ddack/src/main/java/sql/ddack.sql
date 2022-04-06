create sequence review_re_code
start with 111
INCREMENT by 1
maxvalue 99999
cycle;

select * from user_sequence


CREATE TABLE `BOM`  (
  `mat_code` varchar(255) NOT NULL COMMENT '원자재코드',
  `mat_name` varchar(255) NOT NULL COMMENT '원자재이름',
  `mat_type` varchar(255) NOT NULL COMMENT '원자재종류(내부생산,외부생산)',
  `mat_unit` varchar(255) NOT NULL COMMENT '단위',
  `mat_count` varchar(255) NOT NULL COMMENT '현재 갯수',
  `mat_person` varchar(255) NOT NULL COMMENT '원자재 관리자',
  `mat_container_code` varchar(255) NOT NULL COMMENT '원자재 보관장소 (컬럼값 세가지 A, B, C)',
  `mat_life_t` date NULL COMMENT '유통기한(단위 일)',
  `clean_code` varchar(255) NOT NULL COMMENT '위생( 값 O ,X 두개)',
  `b_order_code` varchar(255) NULL COMMENT '외부거래처',
  PRIMARY KEY (`mat_code`)
);

CREATE TABLE `BUYCOMPANY`  (
  `b_comp_code` varchar(255) NOT NULL,
  `b_comp_name` varchar(255) NOT NULL,
  `b_comp_addr` varchar(255) NOT NULL,
  `b_comp_tell` varchar(255) NOT NULL,
  `arrive_date` date NOT NULL,
  PRIMARY KEY (`b_comp_code`)
);

CREATE TABLE `BUYCOMP_ORDER`  (
  `b_order_code` varchar(255) NOT NULL,
  `b_comp_code` varchar(255) NOT NULL,
  `mat_order_d` date NOT NULL COMMENT '재료주문날짜',
  `mat_count` varchar(255) NOT NULL,
  `exp_in_d` varchar(255)  COMMENT '예상입고일',
  `tru_in_d` varchar(255)  COMMENT '실제입고일',
  `quality` varchar(255)  COMMENT '품질검사(OX)',
  PRIMARY KEY (`b_order_code`)
);

CREATE TABLE `CH_PROCESS`  (
  `ch_pro_code` varchar(255) NOT NULL,
  `start_od_code` varchar(255) NOT NULL,
  `p_code` varchar(255) NOT NULL,
  `mat_code1` varchar(255) NOT NULL,
  `mat_code2` varchar(255) NULL,
  `mat_code3` varchar(255) NULL,
  `cook_code` varchar(255) NOT NULL,
  `mk_time` timestamp NULL,
  `mk_ps_code` varchar(255) NOT NULL COMMENT '관리자 코드',
  `line_code` varchar(255) NOT NULL COMMENT 'fk',
  `clean_code` varchar(255) NOT NULL COMMENT 'fk',
  `q_code` varchar(255) NOT NULL COMMENT 'fk',
  PRIMARY KEY (`ch_pro_code`)
);

CREATE TABLE `CLEAN`  (
  `clean_code` varchar(255) NOT NULL,
  `c_cycle_d` date NULL,
  `c_check` varchar(255) NULL,
  PRIMARY KEY (`clean_code`)
);

CREATE TABLE `COOK`  (
  `cook_code` varchar(255) NOT NULL,
  `cook` varchar(255) NULL,
  PRIMARY KEY (`cook_code`)
);

CREATE TABLE `ITEM_INVENT`  (
  `invent_code` varchar(255) NOT NULL,
  `p_code` varchar(255) NOT NULL,
  `invent_qty` varchar(255) NOT NULL COMMENT '재고량',
  `update` timestamp NULL COMMENT '수정일',
  `store_code` varchar(255) NOT NULL,
  PRIMARY KEY (`invent_code`)
);

CREATE TABLE `ITEM_IO`  (
  `io_cd` varchar(255) NOT NULL,
  `io_time` timestamp NOT NULL,
  `io_type` varchar(255) NOT NULL,
  `store_code` varchar(255) NOT NULL,
  `m_od_code` varchar(255) NOT NULL,
  PRIMARY KEY (`io_cd`)
);

CREATE TABLE `LINECHECK`  (
  `check_code` varchar(255) NOT NULL,
  `line_code` varchar(255) NOT NULL COMMENT '라인코드',
  `check_date` date NULL COMMENT '점검일',
  `check_content` varchar(255) NULL COMMENT '점검내용',
  PRIMARY KEY (`check_code`)
);

CREATE TABLE `LINES`  (
  `line_code` varchar(255) NOT NULL COMMENT '라인코드',
  `line_name` varchar(255) NOT NULL COMMENT '라인이름',
  `line_usable` varchar(255) NOT NULL COMMENT '사용가능 여부',
  `line_q` varchar(255) NULL,
  PRIMARY KEY (`line_code`)
);

CREATE TABLE `MEMBER`  (
  `m_code` varchar(255) NOT NULL ,
  `m_type` varchar(255) NOT NULL COMMENT '회원 비회원 관리자 구분 ( Y , N , A)',
  `m_id` varchar(255) NULL COMMENT 'unique 키 ',
  `m_pw` varchar(255) NULL,
  `m_name` varchar(255) NOT NULL,
  `m_jumin` varchar(255) NULL,
  `m_phone` varchar(255) NOT NULL,
  `m_email` varchar(255) NULL,
  `post_code` varchar(255) NOT NULL,
  PRIMARY KEY (`m_code`)
);

CREATE TABLE `MEMORDER`  (
  `m_od_code` varchar(255) NOT NULL,
  `m_code` varchar(255) NOT NULL,
  `p_code` varchar(255) NOT NULL,
  `p_count` varchar(255) NOT NULL,
  `order_date` date NOT NULL COMMENT '주문일',
  `dead_line` date NULL COMMENT '마감일 (우리선에서 끝내야 하는 날짜 )',
  `due_date` date NULL COMMENT '납기일  (진짜 약속날짜)',
  `delay_date` date NULL COMMENT '납기지연일',
  PRIMARY KEY (`m_od_code`)
);

CREATE TABLE `MKPERSON`  (
  `mk_ps_code` varchar(255) NOT NULL,
  `mk_person` varchar(255) NULL,
  PRIMARY KEY (`mk_ps_code`)
);

CREATE TABLE `MONTH_PAY`  (
  `month_p_code` varchar(255) NOT NULL,
  `b_comp_code` varchar(255) NOT NULL,
  `month_pay` varchar(255) NOT NULL,
  `payment_d` date NOT NULL COMMENT '지불일',
  PRIMARY KEY (`month_p_code`)
);

CREATE TABLE `POST`  (
  `post_code` varchar(255) NOT NULL,
  `post_num` varchar(255) NOT NULL,
  `do` varchar(255) NOT NULL,
  `ci` varchar(255) NOT NULL,
  `gungu` varchar(255) NOT NULL,
  `dong` varchar(255) NOT NULL,
  `be_addr` varchar(255) NULL,
  PRIMARY KEY (`post_code`)
);

CREATE TABLE `PRODUCT`  (
  `p_code` varchar(255) NOT NULL,
  `p_name` varchar(255) NOT NULL COMMENT '완제품이름',
  `eq_code` varchar(255) NOT NULL COMMENT '완제품상태 (불량검사)\r\n',
  `p_kg` varchar(255) NOT NULL COMMENT '단위',
  `p_life` varchar(255) NOT NULL COMMENT '유통기한',
  PRIMARY KEY (`p_code`)
);

CREATE TABLE `P_INFO`  (
  `p_info_code` varchar(255) NOT NULL,
  `p_code` varchar(255) NOT NULL,
  `p_info_text` varchar(255) NOT NULL,
  `p_pay` varchar(255) NOT NULL,
  `re_code` varchar(255) NOT NULL,
  PRIMARY KEY (`p_info_code`)
);

CREATE TABLE `QUALITY`  (
  `q_code` varchar(255) NOT NULL,
  `ch_pro_code` varchar(255) NOT NULL COMMENT '부모한테 상속받음 ',
  `mat_code1` varchar(255) NOT NULL,
  `mat_code2` varchar(255) NULL,
  `mat_code3` varchar(255) NULL,
  `cook_code` varchar(255) NULL,
  PRIMARY KEY (`q_code`)
);

CREATE TABLE `REVIEW`  (
  `re_code` varchar(255) NOT NULL,
  `m_id` varchar(255) NOT NULL,
  `p_code` varchar(255) NOT NULL,
  `p_review` varchar(255) NOT NULL,
  PRIMARY KEY (`re_code`)
);

CREATE TABLE `STARTORDER`  (
  `start_od_code` varchar(255) NOT NULL,
  `start_date` date NULL,
  `m_od_code` varchar(255) NOT NULL,
  `total_date` varchar(255) NULL COMMENT 'p_mk_time + arrive_date  더해지는 함수기능이 발동될까?',
  `begin_date` date NOT NULL COMMENT '생산시작 날짜',
  `end_date` date NULL COMMENT '생산종료 날짜',
  PRIMARY KEY (`start_od_code`)
);

CREATE TABLE `Storage`  (
  `store_code` varchar(255) NOT NULL COMMENT '창고 코드',
  `store_name` varchar(255) NOT NULL,
  `store_loc` varchar(255) NOT NULL,
  PRIMARY KEY (`store_code`)
);

ALTER TABLE BUYCOMP_ORDER ADD  FOREIGN KEY (b_comp_code) REFERENCES BUYCOMPANY (b_comp_code);
ALTER TABLE `BOM` ADD FOREIGN KEY (`b_order_code`) REFERENCES `BUYCOMP_ORDER` (`b_order_code`);
ALTER TABLE `MONTH_PAY` ADD FOREIGN KEY (`b_comp_code`) REFERENCES `BUYCOMP_ORDER` (`b_order_code`);
ALTER TABLE `QUALITY` ADD  FOREIGN KEY (`ch_pro_code`) REFERENCES `CH_PROCESS` (`ch_pro_code`);
ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`clean_code`) REFERENCES `CLEAN` (`clean_code`);
ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`cook_code`) REFERENCES `COOK` (`cook_code`);
ALTER TABLE `LINECHECK` ADD FOREIGN KEY (`line_code`) REFERENCES `LINES` (`line_code`);
ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`line_code`) REFERENCES `LINES` (`line_code`);
ALTER TABLE `MEMORDER` ADD FOREIGN KEY (`m_code`) REFERENCES `MEMBER` (`m_code`);
ALTER TABLE `STARTORDER` ADD FOREIGN KEY (`m_od_code`) REFERENCES `MEMORDER` (`m_od_code`);
ALTER TABLE `ITEM_IO` ADD FOREIGN KEY (`m_od_code`) REFERENCES `MEMORDER` (`m_od_code`);
ALTER TABLE `MEMBER` ADD FOREIGN KEY (`post_code`) REFERENCES `POST` (`post_code`);
ALTER TABLE `REVIEW` ADD FOREIGN KEY (`p_code`) REFERENCES `PRODUCT` (`p_code`);
ALTER TABLE `P_INFO` ADD FOREIGN KEY (`p_code`) REFERENCES `PRODUCT` (`p_code`);
ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`p_code`) REFERENCES `PRODUCT` (`p_code`);
ALTER TABLE `MEMORDER` ADD FOREIGN KEY (`p_code`) REFERENCES `PRODUCT` (`p_code`);
ALTER TABLE `ITEM_INVENT` ADD FOREIGN KEY (`p_code`) REFERENCES `PRODUCT` (`p_code`);
ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`q_code`) REFERENCES `QUALITY` (`q_code`);
ALTER TABLE `P_INFO` ADD FOREIGN KEY (`re_code`) REFERENCES `REVIEW` (`re_code`);
ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`start_od_code`) REFERENCES `STARTORDER` (`start_od_code`);
ALTER TABLE `ITEM_INVENT` ADD FOREIGN KEY (`store_code`) REFERENCES `Storage` (`store_code`);
ALTER TABLE `ITEM_IO` ADD FOREIGN KEY (`store_code`) REFERENCES `Storage` (`store_code`);

ALTER TABLE BOM MODIFY clean_code  varchar(255);
ALTER TABLE `BOM` ADD FOREIGN KEY (`clean_code`) REFERENCES `CLEAN` (`clean_code`); 

/*2-1.m_id 유니크키로 만들기*/
ALTER TABLE MEMBER ADD UNIQUE KEY (m_id);
/*2-2.m_id  를  int -> varchar(255)으로 변경하기 
ALTER TABLE REVIEW MODIFY m_id varchar(255);*/

ALTER TABLE `REVIEW` ADD FOREIGN KEY (`m_id`) REFERENCES `MEMBER` (`m_id`);

/*CH_PROCESS 에서 mk_ps_code varchar 를 int 로 바꾸기
ALTER TABLE CH_PROCESS MODIFY mk_ps_code int;*/

ALTER TABLE `CH_PROCESS` ADD FOREIGN KEY (`mk_ps_code`) REFERENCES `MKPERSON` (`mk_ps_code`);
