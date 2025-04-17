CREATE TABLE MEDICAL_RECORD(
    id BIGSERIAL PRIMARY KEY,
    date_record TIMESTAMP,
    diagnostic VARCHAR(300),
    patient_Observation VARCHAR(350)
)