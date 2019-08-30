use student_data;


CREATE TABLE StudentData (

    student_id INT PRIMARY KEY AUTO_INCREMENT not null,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    father_name VARCHAR(45),
    email VARCHAR(45) UNIQUE,
    class INT,
    age INT
);

SELECT *
FROM StudentData;

-- DROP TABLE StudentData;

-- INSERT INTO StudentData(first_name,last_name, father_name,email,class,age) VALUES('yash', 'sharma','sunil', 'yas@gmail.com', 12, 17);