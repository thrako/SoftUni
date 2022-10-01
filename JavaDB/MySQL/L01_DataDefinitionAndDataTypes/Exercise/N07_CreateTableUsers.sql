### Task 07. Create Table Users 

CREATE TABLE users (
    `id` 				INT AUTO_INCREMENT PRIMARY KEY,
    `username` 			CHAR(30) UNIQUE NOT NULL,
    `password` 			CHAR(26) NOT NULL,
    `profile_picture` 	BLOB,
    `last_login_time` 	TIME,
    `is_deleted` 		BOOLEAN    
);

INSERT INTO users 
		(`username`, 	`password`)
	VALUES	
		('user1', 		'verystrongpassword'),
		('user2', 		'verystrongpassword'),
		('user3', 		'verystrongpassword'),
		('user4', 		'verystrongpassword'),
		('user5', 		'verystrongpassword');