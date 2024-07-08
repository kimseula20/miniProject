CREATE TABLE sneaker(
	model_id INT AUTO_INCREMENT PRIMARY KEY,
    price double CHECK (price >= 0.0)
);

CREATE TABLE korea_inventory(
		korea_inventory_id INT AUTO_INCREMENT PRIMARY KEY,
	  model_id INT,
		sneaker_size INT CHECK( sneaker_size >= 100 ),
    stock INT CHECK (stock >= 0),
    FOREIGN KEY(model_id) REFERENCES sneaker(model_id)
);

CREATE TABLE abraod_inventory(
		abroad_inventory_id INT AUTO_INCREMENT PRIMARY KEY,
	  model_id INT,
		sneaker_size INT CHECK ( sneaker_size >= 100 ),
    stock INT CHECK (stock >= 0),
    expected_delivered_day INT,
	FOREIGN KEY(model_id) REFERENCES sneaker(model_id)
);

CREATE TABLE sneaker_traits(
	trait_id INT AUTO_INCREMENT PRIMARY KEY,
    descriptions MEDIUMTEXT,
    english_desc MEDIUMTEXT
);

CREATE TABLE sneaker_model_traits(
	model_trait_id INT AUTO_INCREMENT PRIMARY KEY,
    model_id INT NOT NULL,
	trait_id INT NOT NULL,
    
    FOREIGN KEY(model_id) REFERENCES sneaker(model_id),
    FOREIGN KEY(trait_id) REFERENCES sneaker_traits(trait_id)
);