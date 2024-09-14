
DROP TABLE IF EXISTS student;


CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE student_academics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    student_email VARCHAR(255),
    university_name VARCHAR(255),
    course_name VARCHAR(255),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);