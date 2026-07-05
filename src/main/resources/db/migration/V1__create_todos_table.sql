CREATE TABLE todos (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(200) NOT NULL,
                       description VARCHAR(1000),
                       completed BOOLEAN NOT NULL DEFAULT FALSE,
                       priority VARCHAR(20) NOT NULL DEFAULT 'MEDIUM',
                       created_at TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP
);