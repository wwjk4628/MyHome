-- 테이블 생성
CREATE TABLE users (
    no number primary key,
    name varchar2(20) NOT NULL,
    password varchar2(20) NOT NULL,
    email varchar2(128) UNIQUE NOT NULL,
    gender char(1) NOT NULL CHECK(gender IN ('M', 'F')),
    created_at date DEFAULT sysdate);

-- 시퀀스 생성 (users의 PK)
CREATE SEQUENCE seq_users_pk;