### Task 11. Movies Database

CREATE TABLE directors (
    `id` 				INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` 	VARCHAR(50) NOT NULL, 
    `notes` 			TEXT
); 
 
INSERT INTO directors
		(`director_name`, 	`notes`)
	VALUES 
		('TestName1', 		'TestNotes'),
		('TestName2', 		'TestNotes'),
		('TestName3', 		'TestNotes'),
		('TestName4', 		'TestNotes'),
		('TestName5', 		'TestNotes');
 
CREATE TABLE genres (
    `id` 			INT PRIMARY KEY AUTO_INCREMENT , 
    `genre_name` 	VARCHAR(20) NOT NULL,
    `notes` 		TEXT
);
 
INSERT INTO genres
		(`genre_name`, 	`notes`)
	VALUES 
		('TestName1', 	'TestNotes'),
		('TestName2', 	'TestNotes'),
		('TestName3', 	'TestNotes'),
		('TestName4', 	'TestNotes'),
		('TestName5', 	'TestNotes');
 
CREATE TABLE categories (
    `id` 				INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` 	VARCHAR(20) NOT NULL,
    `notes` 			TEXT
);
 
INSERT INTO categories
		(`category_name`, 	`notes`)
	VALUES 
		('TestName1', 		'TestNotes'),
		('TestName2', 		'TestNotes'),
		('TestName3', 		'TestNotes'),
		('TestName4', 		'TestNotes'),
		('TestName5', 		'TestNotes');
 
CREATE TABLE movies (
    `id` 				INT PRIMARY KEY AUTO_INCREMENT,
    `title` 			VARCHAR(40) NOT NULL, 
    `director_id` 		INT,
    `copyright_year` 	INT,
    `length` 			INT,
    `genre_id` 			INT,
    `category_id` 		INT,
    `rating` 			DOUBLE, 
    `notes` 			TEXT
);
 
INSERT INTO movies 
		(`title`)
	VALUES 
		('TestMovie1'),
		('TestMovie2'),
		('TestMovie3'),
		('TestMovie4'),
		('TestMovie5');