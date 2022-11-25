### 01.	Table Design

DROP DATABASE IF EXISTS stc;
CREATE DATABASE 		stc;
USE 					stc;

CREATE TABLE        addresses (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(100) 	NOT NULL      
);

CREATE TABLE        categories (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(10) 	NOT NULL      
);

CREATE TABLE        clients (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
        `full_name` VARCHAR(50) 	NOT NULL,      
     `phone_number` VARCHAR(20) 	NOT NULL      
);

CREATE TABLE        drivers (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
       `first_name` VARCHAR(30) 	NOT NULL,      
        `last_name` VARCHAR(30) 	NOT NULL,      
              `age` INT 			NOT NULL,      
           `rating` FLOAT 			DEFAULT 5.5      
);

CREATE TABLE        cars (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `make` VARCHAR(20) 	NOT NULL,      
            `model` VARCHAR(20) 	,      
             `year` INT 			NOT NULL DEFAULT 0,      
          `mileage` INT 			DEFAULT 0,      
        `condition` CHAR(1) 		NOT NULL,      
      `category_id` INT 			NOT NULL,
         CONSTRAINT fk_cars_ref_categories
        FOREIGN KEY (`category_id`) REFERENCES categories(`id`)
);

CREATE TABLE        courses (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
  `from_address_id` INT 			NOT NULL,
            `start` DATETIME 		NOT NULL,
		     `bill` DECIMAL(10,2) 	DEFAULT 10,
           `car_id` INT 			NOT NULL,
        `client_id` INT 			NOT NULL,
         CONSTRAINT fk_courses_ref_addresses
        FOREIGN KEY (`from_address_id`) REFERENCES addresses(`id`),
         CONSTRAINT fk_courses_ref_cars
        FOREIGN KEY (`car_id`) REFERENCES cars(`id`),
         CONSTRAINT fk_courses_ref_clients
        FOREIGN KEY (`client_id`) REFERENCES clients(`id`)
);

CREATE TABLE        cars_drivers (
		   `car_id` INT 			NOT NULL,
		`driver_id` INT 			NOT NULL,
         CONSTRAINT pk_cars_drivers
        PRIMARY KEY (`car_id`, `driver_id`),
         CONSTRAINT fk_cars_drivers_ref_cars
        FOREIGN KEY (`car_id`) REFERENCES cars(`id`),
         CONSTRAINT fk_cars_drivers_ref_drivers
        FOREIGN KEY (`driver_id`) REFERENCES drivers(`id`)
);


/*
#addresses
Column Name			Data Type																	Constraints
id					Integer, from 1 to 2,147,483,647.											Primary Key AUTO_INCREMENT
name				A string containing a maximum of 100 characters. Unicode is NOT needed.		NULL is NOT permitted.

#categories
Column Name			Data Type																	Constraints
id					Integer, from 1 to 2,147,483,647.											Primary Key AUTO_INCREMENT
name				A string containing a maximum of 10 characters. Unicode is NOT needed.		NULL is NOT permitted.

#clients
Column Name			Data Type																	Constraints
id					Integer, from 1 to 2,147,483,647.											Primary Key AUTO_INCREMENT
full_name			A string containing a maximum of 50 characters. Unicode is NOT needed.		NULL is NOT permitted.
phone_number		A string containing a maximum of 20 characters. Unicode is NOT needed.		NULL is NOT permitted.

#drivers
Column Name			Data Type																	Constraints
id					Integer, from 1 to 2,147,483,647.											Primary Key AUTO_INCREMENT
first_name			A string containing a maximum of 30 characters. Unicode is NOT needed.		NULL is NOT permitted.
last_name			A string containing a maximum of 30 characters. Unicode is NOT needed.		NULL is NOT permitted.
age					Integer, from 1 to 2,147,483,647.											NULL is NOT permitted.
rating				Floating point number														DEFAULT value is 5.5 NULL is permitted.

#cars
Column Name			Data Type																	Constraints
id					Integer, from 1 to 2,147,483,647.											Primary Key AUTO_INCREMENT
make				A string containing a maximum of 20 characters. Unicode is NOT needed.		NULL is NOT permitted.
model				A string containing a maximum of 20 characters. Unicode is NOT needed.		NULL is permitted.
year				Integer, from 1 to 2,147,483,647.											DEFAULT value is 0 NULL is NOT permitted.
mileage				Integer, from 1 to 2,147,483,647.											DEFAULT value is 0 NULL is permitted.
condition			character that shows the condition of the car.  One character.				NULL is NOT permitted.
category_id			Integer, from 1 to 2,147,483,647.											Relationship with table categories. NULL is NOT permitted.

#courses
Column Name			Data Type																	Constraints
id					Integer, from 1 to 2,147,483,647.											Primary Key AUTO_INCREMENT
from_address_id		Integer, from 1 to 2,147,483,647.											Relationship with table addresses. NULL is NOT permitted.
start				The date and time when the course starts									NULL is NOT permitted.
bill				DECIMAL, up to 10 digits, 2 of which after the decimal point.				DEFAULT value is 10
car_id				Integer, from 1 to 2,147,483,647.											Relationship with table cars. NULL is NOT permitted.
client_id			Integer, from 1 to 2,147,483,647.											Relationship with table clients. NULL is NOT permitted.

#cars_drivers
Column Name			Data Type																	Constraints
car_id				Integer, from 1 to 2,147,483,647.											Relationship with table cars. NULL is NOT permitted.
driver_id			Integer, from 1 to 2,147,483,647.											Relationship with table drivers. NULL is NOT permitted.

o		Have composite primary key from the car_id column and the driver_id column

*/