CREATE TABLE IF NOT EXISTS person (
    id INT PRIMARY KEY,
    dni VARCHAR(20) NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    birthDate DATE
);

INSERT INTO person (id, dni, name, surname, address, birthDate) VALUES
(1, '12345678A', 'Jorge', 'Gonzales', '123 Su casa', '1990-01-01'),
(2, '23456789B', 'Gustavo', 'Perez', 'Calle Nueva #234 Av. Reciente', '1985-05-15'),
(3, '34567890C', 'Maria', 'Diaz', '1234 Su Nueva casa', '1978-09-30');