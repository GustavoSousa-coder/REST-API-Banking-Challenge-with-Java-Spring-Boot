INSERT INTO tb_clients (uuid, name, cpf, email, date_of_birth, password, client_status, created_at) VALUES
    (UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'), 'Fernando', '05695355121', 'fernando@gmail.com', '2006-05-08', '$2a$10$8.UnVuG9HHgffUDAlk8qfOu5HEpL.gxXvG.Y95V/9.2.2.2.2.2', 0, '2026-03-15 18:18:35'),
    (UUID_TO_BIN('a7b3c1d2-e4f5-4a6b-8c9d-0e1f2a3b4c5d'), 'Max Verstapen', '06863900151', 'Verstapen@gmail.com', '1998-10-09', '$2a$10$ZxANVBY6CFkBuyMD7TLaSeq08OgcsxSKt8juuOCFofp.sAPW9/uOS', 0, '2026-03-18 00:13:56');

INSERT INTO tb_accounts (uuid, account_number, agency_number, balance, overdraft_limit, status, type, client_id, created_at) VALUES
    (UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479'), '5706', '0001', 375.00, 1.00, 0, 0, UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'), '2026-02-10 23:12:59'),
    (UUID_TO_BIN('bc661c56-745a-436d-9781-91f8c6d6786e'), '5707', '0001', 0.00, 1.00, 0, 0, UUID_TO_BIN('a7b3c1d2-e4f5-4a6b-8c9d-0e1f2a3b4c5d'), '2026-02-18 14:34:59');

INSERT INTO tb_address_keys (uuid, key_type, key_value, account_id) VALUES
    (UUID_TO_BIN('d290f1ee-6c54-4b01-90e6-d701748f0851'), 'CPF', '06462800151', UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479')),
    (UUID_TO_BIN('e301a2ff-7d65-4c12-81f7-e812859a1962'), 'CPF', '16483900262', UUID_TO_BIN('bc661c56-745a-436d-9781-91f8c6d6786e'));

INSERT INTO tb_transactions (uuid, amount, data_hora, status, transaction_type, sender_account_id, receiver_account_id) VALUES
    (UUID_TO_BIN('123e4567-e89b-12d3-a456-426614174000'), 25.00, '2026-02-18 14:12:36', 0, 'TRANSFER', UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479'), UUID_TO_BIN('bc661c56-745a-436d-9781-91f8c6d6786e')),
    (UUID_TO_BIN('987f6543-21cb-43d2-b543-123456789abc'), 150.00, '2026-02-18 13:54:17', 0, 'TRANSFER', UUID_TO_BIN('bc661c56-745a-436d-9781-91f8c6d6786e'), UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479'));