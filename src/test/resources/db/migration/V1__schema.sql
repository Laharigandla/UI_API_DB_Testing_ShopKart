CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    persona VARCHAR(30) UNIQUE,
    display_name VARCHAR(100),
    email VARCHAR(120) UNIQUE,
    password_hash VARCHAR(255)
);

CREATE TABLE products (
    sku VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(255),
    category VARCHAR(100),
    image_key VARCHAR(100),
    price_paise INT,
    stock INT
);

CREATE TABLE carts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE cart_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cart_id INT,
    sku VARCHAR(50),
    qty INT,
    line_total_paise INT,
    FOREIGN KEY (cart_id) REFERENCES carts(id),
    FOREIGN KEY (sku) REFERENCES products(sku)
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    cart_id INT,
    status VARCHAR(30),
    address VARCHAR(255),
    total_paise INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (cart_id) REFERENCES carts(id)
);