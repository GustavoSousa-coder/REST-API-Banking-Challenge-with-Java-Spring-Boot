CREATE TABLE tb_cards (

                          uuid CHAR(36) NOT NULL PRIMARY KEY,

                          card_number VARCHAR(16) NOT NULL UNIQUE,

                          cvv VARCHAR(3) NOT NULL,

                          holder_name VARCHAR(100) NOT NULL,

                          expiration_month INT NOT NULL,

                          expiration_year INT NOT NULL,

                          status VARCHAR(20) NOT NULL,

                          account_id CHAR(36) NOT NULL,

                          created_at TIMESTAMP NOT NULL,

                          CONSTRAINT fk_card_account
                              FOREIGN KEY (account_id)
                                  REFERENCES tb_accounts(uuid)
);