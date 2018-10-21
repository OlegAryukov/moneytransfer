CREATE SCHEMA IF NOT EXISTS dbtest;
DROP TABLE IF EXISTS dbtest.user;
CREATE TABLE dbtest.user;
ALTER TABLE dbtest.user ADD user_id INTEGER NOT NULL;
ALTER TABLE dbtest.user ADD CONSTRAINT USER_PK PRIMARY KEY (user_id);
ALTER TABLE dbtest.user ADD user_name VARCHAR2(20);
ALTER TABLE dbtest.user ADD user_second_name VARCHAR2(20);

DROP TABLE IF EXISTS dbtest.bank_account;
CREATE TABLE dbtest.bank_account;
ALTER TABLE dbtest.bank_account ADD bank_account_id INTEGER NOT NULL;
ALTER TABLE dbtest.bank_account ADD amount DECIMAL(10, 2);
ALTER TABLE dbtest.bank_account ADD currency_type VARCHAR2(3);
ALTER TABLE dbtest.bank_account ADD user_user_id INTEGER NOT NULL;
ALTER TABLE dbtest.bank_account ADD CONSTRAINT fk_bc_user FOREIGN KEY (user_user_id) REFERENCES dbtest.user(user_id);

DROP TABLE IF EXISTS dbtest.operation_history;
CREATE TABLE dbtest.operation_history;
ALTER TABLE dbtest.operation_history ADD operation_history_id UUID NOT NULL ;
ALTER TABLE dbtest.operation_history ADD operation_type VARCHAR2(10);
ALTER TABLE dbtest.operation_history ADD user_id_from INTEGER;
ALTER TABLE dbtest.operation_history ADD bank_account_id_from INTEGER;
ALTER TABLE dbtest.operation_history ADD user_id_to INTEGER;
ALTER TABLE dbtest.operation_history ADD bank_account_id_to INTEGER;
ALTER TABLE dbtest.operation_history ADD operation_date_utc TIMESTAMP;
