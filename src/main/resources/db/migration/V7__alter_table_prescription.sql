ALTER TABLE PRESCRIPTION
ADD COLUMN consultation BIGINT;

ALTER TABLE PRESCRIPTION
ADD CONSTRAINT fk_consultation_prescription
FOREIGN KEY (consultation)
REFERENCES CONSULTATION(ID)
ON DELETE CASCADE;