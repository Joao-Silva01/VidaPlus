CREATE TABLE HOSPITAL_ADMISSION(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hospitalization_Date TIMESTAMP,
    discharge_Date TIMESTAMP,
    reason VARCHAR(200),
    patient_Room INT,
    situation VARCHAR(17),
    observation VARCHAR(350)
)