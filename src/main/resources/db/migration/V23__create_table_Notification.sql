CREATE TABLE NOTIFICATION(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(50),
    message VARCHAR(350),
    moment_Email TIMESTAMP,
    patient BIGINT,
    FOREIGN KEY (patient)
    REFERENCES PATIENT(id)
)