PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS SAVING_ACCOUNT;
DROP TABLE IF EXISTS CURRENT_ACCOUNT;
DROP TABLE IF EXISTS ACCOUNT;

CREATE TABLE ACCOUNT(
    id_account INTEGER PRIMARY KEY,
    owner_name VARCHAR(100) NOT NULL,
    balance DECIMAL(12,2) NOT NULL
);

CREATE TABLE SAVING_ACCOUNT(
    id_saving_account INTEGER PRIMARY KEY,
    id_account INTEGER NOT NULL,
    interest_rate DECIMAL(5,4) NOT NULL,
    CONSTRAINT fk_saving_account_account
        FOREIGN KEY(id_account) REFERENCES ACCOUNT(id_account)
);

CREATE TABLE CURRENT_ACCOUNT(
    id_current_account INTEGER PRIMARY KEY,
    id_account INTEGER NOT NULL,
    overdraft_limit DECIMAL(12,2) NOT NULL,
    CONSTRAINT fk_current_account_account
        FOREIGN KEY(id_account) REFERENCES ACCOUNT(id_account)
);
