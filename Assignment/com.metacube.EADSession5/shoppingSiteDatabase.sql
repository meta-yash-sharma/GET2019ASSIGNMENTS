use shoppingSite;

CREATE TABLE Product(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_type VARCHAR(20) NOT NULL,
    product_name VARCHAR(20) NOT NULL,
    product_price FLOAT NOT NULL);
    
CREATE TABLE Users(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL,
    user_email VARCHAR(40) NOT NULL,
    user_password VARCHAR(30) NOT NULL);
    
CREATE TABLE ShoppingCart(
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    product_quantity INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES Users(user_id),
    FOREIGN KEY(product_id) REFERENCES Product(product_id));
    
    
INSERT INTO Users(user_name, user_email, user_password) VALUES
    ('Yash', 'yash@metacube.com', '123456'),
    ('Vatsal', 'Vatsal@metacube.com', '1234567'),
    ('Ajay', 'ajay@metacube.com', '1234568'),
    ('Vinode', 'vinode@metacube.com', '1234569'),
    ('rahul', 'rahul@metacube.com', '12345');
    
INSERT INTO Product(product_type, product_name, product_price) VALUES
    ('Mobile', 'Oppo A83', 13000.0),
    ('Mobile', 'Oppo A3S', 11000.0),
    ('Mobile', 'Moto E4+', 12000.0),
    ('Mobile', 'Vivo V11 Pro', 23000.0),
    ('Shoes', 'Nike Shoes', 1300.0),
    ('Shoes', 'Puma Shoes', 2500.0),
    ('Cloth', 'Peter England Shirt', 1300.0),
    ('Cloth', 'Arrow Finch Jeans', 900.0);
