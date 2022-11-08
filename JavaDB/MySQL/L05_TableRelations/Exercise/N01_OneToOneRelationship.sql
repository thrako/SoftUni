### Task 01. One-To-One Relationship 

CREATE TABLE people (
		  `person_id` INT,
		 `first_name` VARCHAR(30),
		 	 `salary` DECIMAL,
		`passport_id` INT
);

INSERT INTO people 		(`person_id`, `first_name`, `salary`, `passport_id`)
VALUES 					(1,	'Roberto',	43300.00,	102),
						(2,	'Tom',		56100.00,	103),
						(3,	'Yana',		60200.00,	101);

CREATE TABLE passports (
		   `passport_id` INT,
	   `passport_number` VARCHAR(30)
);
        
INSERT INTO passports 	(`passport_id`, `passport_number`)
VALUES					(101, 'N34FG21B'),
						(102, 'K65LO4R7'),
						(103, 'ZE657QP2');
        
ALTER TABLE passports
	MODIFY `passport_id` INT PRIMARY KEY AUTO_INCREMENT;
        
ALTER TABLE people
	ADD CONSTRAINT 	pk_people 
		PRIMARY KEY (`person_id`),
	ADD CONSTRAINT 	fk_people_passports 
		FOREIGN KEY (`passport_id`) REFERENCES passports(`passport_id`),
	MODIFY   `person_id` INT AUTO_INCREMENT,
	MODIFY      `salary` DECIMAL(11,2), 
	MODIFY `passport_id` INT UNIQUE;
