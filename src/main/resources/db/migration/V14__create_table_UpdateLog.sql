CREATE TABLE UPDATE_LOG(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    professional BIGINT,
    medical_Record BIGINT,
    update_Description VARCHAR(350),
    update_Date TIMESTAMP,
    FOREIGN KEY (professional) REFERENCES HEALTH_PROFESSIONAL(id),
    FOREIGN KEY (medical_Record) REFERENCES Medical_Record(id)
)