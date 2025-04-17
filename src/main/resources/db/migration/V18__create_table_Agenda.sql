CREATE TABLE AGENDA(
    id BIGSERIAL PRIMARY KEY,
    scheduled_Task VARCHAR(200),
    task_Date TIMESTAMP,
    status VARCHAR(9)
)