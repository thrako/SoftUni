-- task 1
CREATE TABLE `minions` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    age INT
);
CREATE TABLE `towns` (
    town_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)
);

-- task 2
ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`);

-- task 3
INSERT INTO `towns` 
		(id, `name`) 
VALUES	(1, "Sofia"),
		(2, "Plovdiv"),
		(3, "Varna");

INSERT INTO `minions` 
		(`id`, `name`, `age`, `town_id`) 
VALUES 	(1, "Kevin", 22, 1),
		(2, "Bob", 15, 3),
		(3, "Steward", NULL, 2);

-- task 4
truncate table `minions`;

-- task 5
DROP TABLE `minions`;
DROP TABLE `towns`;

-- task 6
CREATE TABLE `people` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    picture BLOB,
    height FLOAT,
    weight FLOAT,
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO `people` (`name`, gender, birthdate) 
VALUES 	('Alexander Ivanov', 'm', '1970-01-01'),
		('Bilyana Karamazova', 'f', '1980-11-11'),
		('Chocho Popyordanov', 'm', '1990-05-16'),
		('Daniela Stoyanova Colins', 'f', '1997-01-12'),
		('Encho Kiryazov', 'm', '1979-07-22');

-- task 7
CREATE TABLE `users` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` CHAR(30) UNIQUE NOT NULL,
    `password` CHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` TIME,
    `is_deleted` BOOLEAN    
);

INSERT INTO `users` 
		(`username`, `password`)
VALUES	('abc', 'verystrongpassword'),
		('cbd', 'verystrongpassword'),
		('cba', 'verystrongpassword'),
		('dba', 'verystrongpassword'),
		('ccc', 'verystrongpassword');

-- task 8
ALTER TABLE users 
	DROP PRIMARY KEY, 
    ADD PRIMARY KEY (`id`, `username`);

-- task 9
ALTER TABLE `users`
	MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();

-- task 10
ALTER TABLE `users` 
	DROP PRIMARY KEY, 
    ADD CONSTRAINT pk_users PRIMARY KEY (`id`),	
    MODIFY COLUMN `username` CHAR(30) UNIQUE NOT NULL;

-- task 11
CREATE TABLE `directors` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50) NOT NULL, 
    `notes` TEXT
); 
 
INSERT INTO `directors`(`director_name`, `notes`)
VALUES 
('TestName1', 'TestNotes'),
('TestName2', 'TestNotes'),
('TestName3', 'TestNotes'),
('TestName4', 'TestNotes'),
('TestName5', 'TestNotes');
 
CREATE TABLE `genres` (
    `id` INT PRIMARY KEY AUTO_INCREMENT , 
    `genre_name` VARCHAR(20) NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `genres`(`genre_name`, `notes`)
VALUES 
('TestName1', 'TestNotes'),
('TestName2', 'TestNotes'),
('TestName3', 'TestNotes'),
('TestName4', 'TestNotes'),
('TestName5', 'TestNotes');
 
CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(20) NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `categories`(`category_name`, `notes`)
VALUES 
('TestName1', 'TestNotes'),
('TestName2', 'TestNotes'),
('TestName3', 'TestNotes'),
('TestName4', 'TestNotes'),
('TestName5', 'TestNotes');
 
CREATE TABLE `movies` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(40) NOT NULL, 
    `director_id` INT,
    `copyright_year` INT,
    `length` INT,
    `genre_id` INT,
    `category_id` INT,
    `rating` DOUBLE, 
    `notes` TEXT
);
 
INSERT INTO `movies` (`title`)
VALUES 
('TestMovie1'),
('TestMovie2'),
('TestMovie3'),
('TestMovie4'),
('TestMovie5');

-- task 12
CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(20), 
    `daily_rate` DOUBLE, 
    `weekly_rate` DOUBLE, 
    `monthly_rate` DOUBLE, 
    `weekend_rate` DOUBLE    
);
 
INSERT INTO `categories` (`category`)
VALUES 
('TestName1'),
('TestName2'),
('TestName3');
 
CREATE TABLE `cars` (
    `id` INT PRIMARY KEY AUTO_INCREMENT, 
    `plate_number` VARCHAR(20),
    `make` VARCHAR(20),
    `model` VARCHAR(20),
    `car_year` INT,
    `category_id` INT,
    `doors` INT,
    `picture` BLOB,
    `car_condition` VARCHAR(30),
    `available` BOOLEAN   
);
 
INSERT INTO `cars` (`plate_number`)
VALUES 
('TestName1'),
('TestName2'),
('TestName3');
 
CREATE TABLE `employees` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    `title` VARCHAR(50),
    `notes` TEXT
);
 
INSERT INTO `employees` (`first_name`, `last_name`)
VALUES 
('TestName1', 'TestName1'),
('TestName2', 'TestName2'),
('TestName3', 'TestName3');
 
CREATE TABLE `customers` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `driver_license` VARCHAR(20),
    `full_name` VARCHAR(50),
    `address` VARCHAR(50),
    `city` VARCHAR(10),
    `zip_code` VARCHAR(10),
    `notes` TEXT
);
 
INSERT INTO `customers` (`driver_license`, `full_name`)
VALUES 
('TestName1', 'TestName1'),
('TestName2', 'TestName2'),
('TestName3', 'TestName3');
 
CREATE TABLE `rental_orders` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT,
    `customer_id` INT,
    `car_id` INT,
    `car_condition` VARCHAR(50),
    `tank_level` VARCHAR(20),
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE, 
    `end_date` DATE, 
    `total_days` INT,
    `rate_applied` DOUBLE,
    `tax_rate` DOUBLE,
    `order_status` VARCHAR(20),
    `notes` TEXT
);
 
INSERT INTO `rental_orders` (`employee_id`, `customer_id`)
VALUES 
(1, 2),
(2, 3),
(3, 1);

-- task 13
INSERT INTO `towns` (`name`)
VALUES 
	('Sofia'), 
	('Plovdiv'), 
	('Varna'), 
	('Burgas');

INSERT INTO `departments` (`name`)
VALUES
	('Engineering'), 
    ('Sales'), 
    ('Marketing'), 
    ('Software Development'), 
    ('Quality Assurance');

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
	('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', (SELECT `id` FROM `departments` WHERE `name` = 'Software Development'), '2013-02-01', '3500.00'),
	('Petar', 'Petrov', 'Petrov', 'Senior Engineer', (SELECT `id` FROM `departments` WHERE `name` = 'Engineering'), '2004-03-02', '4000.00'),
	('Maria', 'Petrova', 'Ivanova', 'Intern', (SELECT `id` FROM `departments` WHERE `name` = 'Quality Assurance'), '2016-08-28', '525.25'),
	('Georgi', 'Terziev', 'Ivanov', 'CEO', (SELECT `id` FROM `departments` WHERE `name` = 'Sales'), '2007-12-09', '3000.00'),
	('Peter', 'Pan', 'Pan', 'Intern', (SELECT `id` FROM `departments` WHERE `name` = 'Marketing'), '2016-08-28', '599.88');

-- task 14
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

-- task 15
SELECT * FROM `towns` ORDER BY `name` ASC;
SELECT * FROM `departments` ORDER BY `name` ASC;
SELECT * FROM `employees` ORDER BY `salary` DESC;

-- task 16
SELECT `name` FROM `towns` ORDER BY `name` ASC;
SELECT `name` FROM `departments` ORDER BY `name` ASC;
SELECT `first_name`,`last_name`,`job_title`,`salary` FROM `employees` ORDER BY `salary` DESC;

-- task 17
UPDATE `employees`
SET `salary` = `salary` * 1.10
WHERE `id` > 0;
SELECT `salary` FROM `employees`;