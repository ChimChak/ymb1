-- 방명록 글을 저장할 테이블 
CREATE TABLE board_guest(
num NUMBER PRIMARY KEY,
writer VARCHAR2(50),
title VARCHAR2(100),
content CLOB,
regdate DATE
);
-- board_guest 테이블의 primary key 값을 생성할 시퀀스 
CREATE SEQUENCE board_guest_seq;
