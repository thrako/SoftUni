### Task 06. University Database

CREATE TABLE subjects (
	  `subject_id` INT PRIMARY KEY AUTO_INCREMENT,	
    `subject_name` VARCHAR(50)    
);

CREATE TABLE majors (
	    `major_id` INT PRIMARY KEY AUTO_INCREMENT,	
            `name` VARCHAR(50)
);

CREATE TABLE payments (
	  `payment_id` INT PRIMARY KEY AUTO_INCREMENT,	
    `payment_date` DATE,
  `payment_amount` DECIMAL(8,2),
	  `student_id` INT    
);

CREATE TABLE students (
	  `student_id` INT PRIMARY KEY AUTO_INCREMENT,
  `student_number` VARCHAR(12),
    `student_name` VARCHAR(50),
        `major_id` INT
);

CREATE TABLE agenda (
	  `student_id` INT,	
      `subject_id` INT, 
    CONSTRAINT pk_agenda
		PRIMARY KEY(`student_id`, `subject_id`) 
);

ALTER TABLE payments
	ADD CONSTRAINT fk_payments_ref_students
		FOREIGN KEY (`student_id`) REFERENCES students(`student_id`);
    
ALTER TABLE students
	ADD CONSTRAINT fk_students_ref_majors
		FOREIGN KEY (`major_id`) REFERENCES majors(`major_id`);

ALTER TABLE agenda
	ADD CONSTRAINT fk_agenda_ref_students
		FOREIGN KEY (`student_id`) REFERENCES students(`student_id`),
	ADD CONSTRAINT fk_agenda_ref_subjects
		FOREIGN KEY (`subject_id`) REFERENCES subjects(`subject_id`);