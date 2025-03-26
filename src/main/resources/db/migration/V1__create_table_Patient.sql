CREATE TABLE Patient(
    id BIGINT auto_increment primary key,
    name VARCHAR(30) NOT NULL,
    birthDate DATE,
    sex VARCHAR(9) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(11),
    cpf VARCHAR(14) UNIQUE,
    role VARCHAR(13)
)