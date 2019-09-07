USE Book_manegement;


CREATE TABLE Book(
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    writer VARCHAR(45) NOT NULL,
    publisher VARCHAR(45) NOT NULL,
    published_year INT NOT NULL
);


