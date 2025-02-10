CREATE TABLE tb_credit_card (
    id BIGSERIAL PRIMARY KEY,
    card_owner_id BIGINT NOT NULL,
    bank_account_id BIGINT NOT NULL,
    card_number VARCHAR(50) UNIQUE NOT NULL,
    validate_date DATE NOT NULL,
    cvv INTEGER NOT NULL,
    credit_limit NUMERIC(15,2) NOT NULL DEFAULT 0.00,
    invoice NUMERIC(15,2) NOT NULL DEFAULT 0.00,
    minimum_payment NUMERIC(15,2) NOT NULL DEFAULT 0.00,
    FOREIGN KEY (card_owner_id) REFERENCES tb_users(id) ON DELETE CASCADE,
    FOREIGN KEY (bank_account_id) REFERENCES tb_bank_account(id) ON DELETE CASCADE
);
