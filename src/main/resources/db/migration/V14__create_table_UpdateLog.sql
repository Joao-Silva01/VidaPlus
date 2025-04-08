CREATE TABLE UPDATE_LOG(
    professional BIGINT,
    medical_Record BIGINT,
    update_Description VARCHAR(350),
    update_Date TIMESTAMP NOT NULL,
    PRIMARY KEY(professional, medical_Record),
    FOREIGN KEY (professional) REFERENCES HEALTH_PROFESSIONAL(id),
    FOREIGN KEY (medical_Record) REFERENCES Medical_Record(id)
)