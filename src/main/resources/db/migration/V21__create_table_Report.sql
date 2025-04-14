CREATE TABLE REPORT(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    generation_date TIMESTAMP,
    number_queries BIGINT,
    number_hospitalization BIGINT,
    number_exams BIGINT,
    number_prescriptions BIGINT,
    observation VARCHAR(350),
    invoicing DECIMAL(100,2)
)