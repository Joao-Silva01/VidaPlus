CREATE TABLE Patient(
    id BIGSERIAL primary key,
    name VARCHAR(40) NOT NULL,
    birth_date DATE,
    sex VARCHAR(9) NOT NULL,
    password VARCHAR(150) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(10),
    document VARCHAR(11) UNIQUE,
    role VARCHAR(13)
)