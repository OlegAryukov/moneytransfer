CREATE SCHEMA IF NOT EXISTS dbtest;
CREATE TABLE dbtest.user;
ALTER TABLE dbtest.user ADD user_id INTEGER;
ALTER TABLE dbtest.user ADD user_name VARCHAR2(20);
ALTER TABLE dbtest.user ADD user_second_name VARCHAR2(20);

CREATE TABLE dbtest.bank_account;
ALTER TABLE dbtest.bank_account ADD bank_account_id INTEGER;
ALTER TABLE dbtest.bank_account ADD amount DECIMAL(10, 2);
ALTER TABLE dbtest.bank_account ADD currency_type VARCHAR2(3);
ALTER TABLE dbtest.bank_account ADD user_if INTEGER;