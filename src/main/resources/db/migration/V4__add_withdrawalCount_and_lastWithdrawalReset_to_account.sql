ALTER TABLE tb_accounts ADD COLUMN withdrawal_count INT NOT NULL DEFAULT 0;
ALTER TABLE tb_accounts ADD COLUMN last_withdrawal_reset DATE NOT NULL DEFAULT (CURRENT_DATE);