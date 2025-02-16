CREATE TABLE tb_pix (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id BIGINT  NOT NULL,
    bank_account_id BIGINT NOT NULL,
    key VARCHAR(255) UNIQUE NOT NULL,
    pix_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now(),
    CONSTRAINT fk_pix_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE,
    CONSTRAINT fk_pix_bank FOREIGN KEY (bank_account_id) REFERENCES tb_bank_account(id) ON DELETE CASCADE
);
