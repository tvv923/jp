CREATE TABLE Homework
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE Lesson
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    updatedAt   DATETIME,
    homework_id INT,
    FOREIGN KEY (homework_id) REFERENCES Homework (id) ON DELETE CASCADE
);