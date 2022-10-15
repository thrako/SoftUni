### Task 12. Car Rental Database

CREATE TABLE categories (
    `id` 			INT PRIMARY KEY AUTO_INCREMENT,
    `category` 		VARCHAR(20), 
    `daily_rate` 	DOUBLE, 
    `weekly_rate` 	DOUBLE, 
    `monthly_rate` 	DOUBLE, 
    `weekend_rate` 	DOUBLE    
);
 
INSERT INTO categories 
		(`category`)
	VALUES 
		('TestCat1'),
		('TestCat2'),
		('TestCat3');
 
CREATE TABLE cars (
    `id` 				INT PRIMARY KEY AUTO_INCREMENT, 
    `plate_number` 		VARCHAR(20),
    `make` 				VARCHAR(20),
    `model` 			VARCHAR(20),
    `car_year` 			INT,
    `category_id` 		INT,
    `doors` 			INT,
    `picture` 			BLOB,
    `car_condition` 	VARCHAR(30),
    `available` 		BOOLEAN   
);
 
INSERT INTO cars 
		(`plate_number`)
	VALUES 
		('TestPlate1'),
		('TestPlate2'),
		('TestPlate3');
 
CREATE TABLE employees (
    `id` 			INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` 	VARCHAR(50),
    `last_name` 	VARCHAR(50),
    `title` 		VARCHAR(50),
    `notes` 		TEXT
);
 
INSERT INTO employees 
		(`first_name`, 	`last_name`)
	VALUES 
		('TestFirst1', 	'TestLast1'),
		('TestFirst2', 	'TestLast2'),
		('TestFirst3', 	'TestLast3');
 
CREATE TABLE customers (
    `id` 				INT PRIMARY KEY AUTO_INCREMENT,
    `driver_license` 	VARCHAR(20),
    `full_name` 		VARCHAR(50),
    `address` 			VARCHAR(50),
    `city` 				VARCHAR(10),
    `zip_code` 			VARCHAR(10),
    `notes` 			TEXT
);
 
INSERT INTO customers 
		(`driver_license`, 	`full_name`)
	VALUES 
		('TestLicense1',	'TestName1'),
		('TestLicense2',	'TestName2'),
		('TestLicense3',	'TestName3');
 
CREATE TABLE rental_orders (
    `id` 					INT PRIMARY KEY AUTO_INCREMENT,
    `employee_id` 			INT,
    `customer_id` 			INT,
    `car_id` 				INT,
    `car_condition` 		VARCHAR(50),
    `tank_level` 			VARCHAR(20),
    `kilometrage_start` 	INT,
    `kilometrage_end` 		INT,
    `total_kilometrage` 	INT,
    `start_date` 			DATE, 
    `end_date` 				DATE, 
    `total_days` 			INT,
    `rate_applied` 			DOUBLE,
    `tax_rate` 				DOUBLE,
    `order_status` 			VARCHAR(20),
    `notes` 				TEXT
);
 
INSERT INTO rental_orders 
		(`employee_id`, 	`customer_id`)
	VALUES 
		(1, 				2),
		(2, 				3),
		(3, 				1);