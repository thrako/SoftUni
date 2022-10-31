### Task 04. Self-Referencing

CREATE TABLE teachers (
	`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,	
          `name` VARCHAR(50),	
    `manager_id` INT NULL,
    CONSTRAINT fk_teachers_ref_teachers
		FOREIGN KEY (`manager_id`) REFERENCES teachers(`teacher_id`)
);

ALTER TABLE teachers 
	AUTO_INCREMENT = 101;

INSERT INTO teachers 	(`name`)
VALUES 					('John'), 
						('Maya'), 
						('Silvia'), 
						('Ted'), 
                        ('Mark'), 
                        ('Greta');

UPDATE teachers 
	SET `manager_id` = 106	WHERE `teacher_id` = 102;
UPDATE teachers 
	SET	`manager_id` = 106	WHERE `teacher_id` = 103;
UPDATE teachers 
	SET	`manager_id` = 105	WHERE `teacher_id` = 104;
UPDATE teachers 
	SET	`manager_id` = 101	WHERE `teacher_id` = 105;
UPDATE teachers 
	SET	`manager_id` = 101	WHERE `teacher_id` = 106;