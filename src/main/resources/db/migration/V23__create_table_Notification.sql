CREATE TABLE NOTIFICATION(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    message VARCHAR(350),
    patient BIGINT,
    FOREIGN KEY (patient)
    REFERENCES PATIENT(id)
)