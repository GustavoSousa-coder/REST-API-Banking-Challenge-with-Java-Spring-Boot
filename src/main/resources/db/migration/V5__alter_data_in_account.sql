ALTER TABLE tb_accounts
DROP COLUMN type,
ADD COLUMN daily_transfer_limit DECIMAL(19,2) NOT NULL DEFAULT 5000.00,
ADD COLUMN daily_transfer_used DECIMAL(19,2) NOT NULL DEFAULT 0.00,
ADD COLUMN last_transfer_reset DATE;

UPDATE tb_accounts
SET last_transfer_reset = CURRENT_DATE
WHERE last_transfer_reset IS NULL;

ALTER TABLE tb_accounts
    MODIFY COLUMN last_transfer_reset DATE NOT NULL;