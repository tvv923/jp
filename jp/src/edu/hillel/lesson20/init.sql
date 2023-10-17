CREATE TABLE Homework
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT
);

CREATE TABLE Lesson
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    updatedAt   TIMESTAMP,
    homework_id INT,
    FOREIGN KEY (homework_id) REFERENCES Homework (id)
);

CREATE TABLE Schedule
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255),
    updatedAt TIMESTAMP
);

CREATE TABLE Schedule_Lesson
(
    schedule_id INT,
    lesson_id   INT,
    FOREIGN KEY (schedule_id) REFERENCES Schedule (id),
    FOREIGN KEY (lesson_id) REFERENCES Lesson (id)
);

INSERT INTO Homework (name, description)
VALUES ('Math Homework', 'Solve math problems for chapter 1'),
       ('History Assignment', 'Write an essay on the American Revolution'),
       ('Science Project', 'Experiment on photosynthesis'),
       ('Literature Reading', 'Read "To Kill a Mockingbird"'),
       ('Programming Exercise', 'Write a Java program'),
       ('Art Project', 'Create a painting on canvas'),
       ('Music Composition', 'Compose a new music piece'),
       ('Physical Education', 'Complete a 5km run'),
       ('Geography Homework', 'Label countries on a world map'),
       ('Language Study', 'Learn new vocabulary words');

INSERT INTO Lesson (name, updatedAt, homework_id)
VALUES ('Math Lesson', NOW(), 1),
       ('History Lesson', NOW(), 2),
       ('Science Lab', NOW(), 3),
       ('Literature Class', NOW(), 4),
       ('Programming Workshop', NOW(), 5),
       ('Art Class', NOW(), 6),
       ('Music Lesson', NOW(), 7),
       ('PE Session', NOW(), 8),
       ('Geography Class', NOW(), 9),
       ('Language Study Session', NOW(), 10);

INSERT INTO Schedule (name, updatedAt)
VALUES ('Monday Schedule', NOW()),
       ('Tuesday Schedule', NOW()),
       ('Wednesday Schedule', NOW()),
       ('Thursday Schedule', NOW()),
       ('Friday Schedule', NOW()),
       ('Saturday Schedule', NOW()),
       ('Sunday Schedule', NOW()),
       ('Weekend Schedule', NOW()),
       ('Workweek Schedule', NOW()),
       ('Holiday Schedule', NOW());

INSERT INTO Schedule_Lesson (schedule_id, lesson_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 7),
       (3, 8),
       (4, 9),
       (4, 10);