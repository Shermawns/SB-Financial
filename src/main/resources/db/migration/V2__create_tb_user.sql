CREATE TABLE tb_users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    address_id BIGINT UNIQUE,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(250) NOT NULL,
    role VARCHAR(20) DEFAULT 'ROLE_CLIENT',
    FOREIGN KEY (address_id) REFERENCES tb_address(id) ON DELETE SET NULL
);
