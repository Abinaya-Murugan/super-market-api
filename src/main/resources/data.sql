-- Create ProductCategory table
CREATE TABLE IF NOT EXISTS product_category (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image TEXT
);

-- Create Product table
CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    category_id VARCHAR(255),
    quantity INT NOT NULL,
    image TEXT,
    is_on_discount BOOLEAN NOT NULL,
    new_price DECIMAL(10, 2),
    FOREIGN KEY (category_id) REFERENCES product_category(id)
);

INSERT INTO product_category (id, name, description, image) VALUES
('BV', 'Beverages', 'Drinks, juices, and other beverages', 'https://i.pinimg.com/originals/3f/ef/cb/3fefcb509e1839f5a6235bcc668b711a.jpg'),
('SN', 'Snacks', 'Chips, cookies, and other snacks', 'https://i.pinimg.com/originals/66/ac/43/66ac431b2dded792837e0fba60e2240b.jpg'),
('VG', 'Vegetables', 'Fresh Vegetables', 'https://i.pinimg.com/originals/93/06/03/9306037b0fdcac44cefbdb4ecd3c91ff.jpg'),
('FR', 'Fruits', 'Fresh Fruits', 'https://i.pinimg.com/originals/33/13/c1/3313c1b779276d0cb6137f02ac586a9c.jpg');

INSERT INTO product (name, description, price, category_id, quantity, image, is_on_discount, new_price) VALUES
('Bananas', 'Fresh ripe bananas', 1.20, 'FR', 2, 'https://i.pinimg.com/originals/d8/c8/84/d8c884e540d257109a3c83c9af3821ae.jpg', false, 1.20),
('Apples', 'Crisp and juicy red apples', 2.50, 'FR', 10, 'https://i.pinimg.com/originals/7c/81/bc/7c81bcaf315dd172a56e93af2d969230.jpg', true, 2.00),
('Carrots', 'Organic fresh carrots', 1.75, 'VG', 10, 'https://i.pinimg.com/originals/6d/12/cc/6d12ccafcbb31c57857446243b8b56c9.jpg', true, 1.25),
('Broccoli', 'Green and healthy broccoli', 2.20, 'VG', 10, 'https://i.pinimg.com/originals/e7/24/09/e72409d4d846e73b00e892cfc665f3db.jpg', false, 2.20),
('Coca-Cola', 'Refreshing Coca-Cola soda', 1.50, 'BV', 10, 'https://i.pinimg.com/originals/af/25/18/af2518a1fc17277de1d2a8d833b76eb9.jpg', false, 1.50),
('Green Tea', 'Healthy green tea', 3.00, 'BV', 10, 'https://i.pinimg.com/originals/d3/85/ce/d385ce2cabe96a724807459a4190ea42.jpg', false, 3.00),
('Lays', 'Crispy and Crunchy Lays', 2.75, 'SN', 10, 'https://i.pinimg.com/originals/51/03/ea/5103eafab4a5d0d9152dc355069333d2.jpg', true, 2.50),
('Dairy Milk', 'Kuch achha ho jaaye, kuch meetha ho jaaye with Cadbury Dairy Milk', 4.00, 'SN', 10, 'https://i.pinimg.com/originals/2e/20/68/2e20684bf1861da5dd45d3b450e5dcc1.jpg', false, 4.00);