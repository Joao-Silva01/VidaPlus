CREATE TABLE MEDICAL_EXAMINATION(
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    exam_Date TIMESTAMP NOT NULL,
    type VARCHAR(14) NOT NULL,
    status VARCHAR(9),
    result VARCHAR(250)
)