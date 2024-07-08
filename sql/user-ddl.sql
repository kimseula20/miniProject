CREATE TABLE user(
	 user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30) UNIQUE NOT NULL,
    phone_num CHAR(15) NOT NULL
);

CREATE TABLE general_user(
	g_user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    favortie_shopping_address VARCHAR(30),
    my_card_num VARCHAR(20),
    my_bank_account VARCHAR(30),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
);

CREATE TABLE admin_user(
	admin_id INT AUTO_INCREMENT PRIMARY KEY,
	user_id INT,
    
	FOREIGN KEY(user_id) REFERENCES user(user_id)
);