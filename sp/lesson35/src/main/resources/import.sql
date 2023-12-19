CREATE TABLE MyUser (
                      id int AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      role VARCHAR(255) NOT NULL
);

INSERT INTO MyUser (username, password, role) VALUES ('admin', '123', 'ADMIN');

CREATE TABLE Product (
                         id int AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         cost DECIMAL(10, 2) NOT NULL
);

INSERT INTO Product (name, cost) VALUES ('Margherita', 9.99);
INSERT INTO Product (name, cost) VALUES ('Pepperoni', 11.99);
INSERT INTO Product (name, cost) VALUES ('Vegetarian', 10.99);
INSERT INTO Product (name, cost) VALUES ('Hawaiian', 12.99);
INSERT INTO Product (name, cost) VALUES ('Meat Lovers', 13.99);