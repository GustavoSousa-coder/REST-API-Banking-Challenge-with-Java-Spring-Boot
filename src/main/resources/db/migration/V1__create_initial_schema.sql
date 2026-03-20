CREATE TABLE tb_clients (
    uuid BINARY(16) PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    password VARCHAR(100),
    client_status INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_accounts (
    uuid BINARY(16) PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL,
    agency_number VARCHAR(10) NOT NULL,
    balance DECIMAL(19, 2) DEFAULT 0.00,
    overdraft_limit DECIMAL(19, 2) DEFAULT 0.00,
    status INT DEFAULT 0,
    type INT DEFAULT 0,
    client_id BINARY(16),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_client_account FOREIGN KEY (client_id) REFERENCES tb_clients(uuid)
);

CREATE TABLE tb_address_keys (
    uuid BINARY(16) PRIMARY KEY,
    key_type VARCHAR(20) NOT NULL,
    key_value VARCHAR(100) UNIQUE NOT NULL,
    account_id BINARY(16),
    CONSTRAINT fk_account_key FOREIGN KEY (account_id) REFERENCES tb_accounts(uuid)
);

CREATE TABLE tb_transactions (
    uuid BINARY(16) PRIMARY KEY,
    amount DECIMAL(19, 2) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    status INT DEFAULT 0,
    transaction_type VARCHAR(30) NOT NULL,
    sender_account_id BINARY(16),
    receiver_account_id BINARY(16),
    CONSTRAINT fk_sender FOREIGN KEY (sender_account_id) REFERENCES tb_accounts(uuid),
    CONSTRAINT fk_receiver FOREIGN KEY (receiver_account_id) REFERENCES tb_accounts(uuid)
);