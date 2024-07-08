-- 아래 테이블이 수정되었습니다.
CREATE TABLE wish(
	wish_id INT AUTO_INCREMENT PRIMARY KEY,
    g_user_id INT NOT NULL,
    model_id INT NOT NULL,
    sneaker_size INT CHECK ( sneaker_size >= 100 ),
    expected_replenisment_date DATETIME,
    wish_at DATETIME NOT NULL,
   
	FOREIGN KEY(g_user_id) REFERENCES general_user(g_user_id),
    FOREIGN KEY(model_id) REFERENCES sneaker(model_id)
);

-- 아래 테이블이 수정되었습니다.
CREATE TABLE orders(
	  order_id INT AUTO_INCREMENT  PRIMARY KEY,
    g_user_id INT NOT NULL,
    model_id INT NOT NULL,
    sneaker_size INT NOT NULL,
		order_quantity INT NOT NULL,
    shpping_address VARCHAR(30) NOT NULL,
    total_price DOUBLE,
    order_status TINYINT, 
    order_at DATETIME NOT NULL,
   
	  FOREIGN KEY(g_user_id) REFERENCES general_user(g_user_id),
    FOREIGN KEY(model_id) REFERENCES sneaker(model_id)
);

CREATE TABLE payment(
	payment_id INT AUTO_INCREMENT PRIMARY KEY,
    g_user_id INT NOT NULL,
    order_id INT NOT NULL,
    type TINYINT NOT NULL,
    payment_at DATETIME NOT NULL,
   
	FOREIGN KEY(g_user_id) REFERENCES general_user(g_user_id),
    FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

CREATE TABLE shipping(
	 shipping_id INT AUTO_INCREMENT PRIMARY KEY,
    admin_id INT NOT NULL, 
    model_id INT NOT NULL,
    order_id INT NOT NULL,
    shipping_address VARCHAR(30) NOT NULL,
    shipping_at DATETIME NOT NULL,
   
	 FOREIGN KEY(admin_id) REFERENCES admin_user(admin_id),
   FOREIGN KEY(model_id) REFERENCES sneaker(model_id),
	 FOREIGN KEY(order_id) REFERENCES orders(order_id)
);