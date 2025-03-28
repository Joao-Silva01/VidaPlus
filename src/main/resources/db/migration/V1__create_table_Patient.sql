CREATE TABLE Patient(
    id BIGINT auto_increment primary key,
    name VARCHAR(30) NOT NULL,
    birth_date TIMESTAMP,
    sex VARCHAR(9) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(11),
    document VARCHAR(14) UNIQUE,
    role VARCHAR(13)
)