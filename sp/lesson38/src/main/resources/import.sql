CREATE TABLE IF NOT EXISTS Product (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       cost DOUBLE PRECISION NOT NULL
);

CREATE TABLE IF NOT EXISTS Orders (
                                     id SERIAL PRIMARY KEY,
                                     date TIMESTAMP,
                                     cost DOUBLE PRECISION NOT NULL,
                                     product_id INT NOT NULL,
                                     FOREIGN KEY (product_id) REFERENCES Product(id)
);
