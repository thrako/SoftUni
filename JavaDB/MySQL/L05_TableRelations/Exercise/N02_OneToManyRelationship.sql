### Task 02. One-To-Many Relationship

CREATE TABLE manufacturers (
	`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
               `name` VARCHAR(50),
     `established_on` DATE
);

INSERT INTO manufacturers 	(`name`, `established_on`)
VALUES 						('BMW', 	'1916-03-01'),
							('Tesla', 	'2003-01-01'),
							('Lada', 	'1966-05-01');
    
CREATE TABLE models (
	       `model_id` INT PRIMARY KEY AUTO_INCREMENT, 
               `name` VARCHAR(50), 
    `manufacturer_id` INT,
    CONSTRAINT fk_models_manufacturers
		FOREIGN KEY (`manufacturer_id`) REFERENCES manufacturers(`manufacturer_id`)
);

ALTER TABLE models 
	AUTO_INCREMENT = 101;

INSERT INTO models 	(`name`, `manufacturer_id`)
VALUES 				('X1', 		1),
					('i6', 		1),
					('Model S',	2),
					('Model X', 2),
					('Model 3', 2),
					('Nova', 	3);