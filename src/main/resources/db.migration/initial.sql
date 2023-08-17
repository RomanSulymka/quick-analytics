CREATE TABLE statistic (
                           id SERIAL PRIMARY KEY,
                           transaction_id BIGINT NOT NULL,
                           sender_account_id BIGINT NOT NULL,
                           receiver_account_id BIGINT NOT NULL,
                           sender_wallet_id BIGINT NOT NULL,
                           receiver_wallet_id BIGINT NOT NULL,
                           amount DECIMAL(10, 2) NOT NULL,
                           currency VARCHAR(255) NOT NULL,
                           transaction_date TIMESTAMP NOT NULL,
                           status VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE analytics (
    id DECIMAL primary key ,

)