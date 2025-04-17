CREATE TABLE CONSULTATION(
    id BIGSERIAL PRIMARY KEY,
    consultation_moment TIMESTAMP,
    diagnostic VARCHAR(200),
    symptoms VARCHAR (200),
    consultation_fee DECIMAL(10,2),
    type VARCHAR(9),
    status VARCHAR(9),
    consultation_link VARCHAR(100)
)