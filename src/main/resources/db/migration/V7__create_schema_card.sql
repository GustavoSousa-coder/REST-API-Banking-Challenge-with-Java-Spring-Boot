CREATE TABLE tb_cards (
    uuid BINARY(16) NOT NULL,
    card_number VARCHAR(16) NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    holder_name VARCHAR(255) NOT NULL,
    expiration_date VARBINARY(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    account_id BINARY(16),
    created_at DATETIME(6) NOT NULL,
    PRIMARY KEY (uuid),
    UNIQUE KEY uq_card_number (card_number),
    CONSTRAINT fk_cards_account FOREIGN KEY (account_id) REFERENCES tb_accounts(uuid) ON DELETE CASCADE
);