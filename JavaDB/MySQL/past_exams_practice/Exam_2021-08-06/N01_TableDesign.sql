### 01.	Table Design

DROP DATABASE IF EXISTS sgd;
CREATE DATABASE 		sgd;
USE 					sgd;

CREATE TABLE        addresses (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(50) 	NOT NULL      
);

CREATE TABLE        categories (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(10) 	NOT NULL      
);

CREATE TABLE        offices (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
`workspace_capacity` 
                    INT             NOT NULL,
		  `website` VARCHAR(50)     ,
	   `address_id` INT				NOT NULL,
         CONSTRAINT fk_offices_ref_addresses
        FOREIGN KEY (`address_id`) 	REFERENCES addresses(`id`)
);

CREATE TABLE        employees (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
       `first_name` VARCHAR(30)		NOT NULL,       
        `last_name` VARCHAR(30)		NOT NULL,
              `age` INT				NOT NULL,
           `salary` DECIMAL(10,2)	NOT NULL,
        `job_title` VARCHAR(20)		NOT NULL,
  `happiness_level` CHAR(1)			NOT NULL
);

CREATE TABLE        teams (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(40) 	NOT NULL,
        `office_id` INT				NOT NULL,
        `leader_id` INT				NOT NULL UNIQUE,
         CONSTRAINT fk_teams_ref_offices
        FOREIGN KEY (`office_id`) REFERENCES offices(`id`),
         CONSTRAINT fk_teams_ref_employees
        FOREIGN KEY (`leader_id`) REFERENCES employees(`id`)
);

CREATE TABLE games
(
          `id` INT PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(50)       NOT NULL UNIQUE,
 `description` TEXT,
      `rating` FLOAT DEFAULT 5.5 NOT NULL,
      `budget` DECIMAL(10, 2)    NOT NULL,
`release_date` DATE,
     `team_id` INT               NOT NULL,
    CONSTRAINT fk_games_ref_teams
   FOREIGN KEY (`team_id`) REFERENCES teams (`id`)
);

CREATE TABLE games_categories
(
    `game_id` INT NOT NULL,
`category_id` INT NOT NULL,
   CONSTRAINT pk_games_categories
  PRIMARY KEY (`game_id`, `category_id`)
);


/*
#games
#Column Name		Data Type																Constraints
#id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 50 characters. Unicode is NOT needed.	NULL is NOT permitted. UNIQUE
description		A very long string field. 												NULL is permitted.
rating			A floating point numbers.	DEFAULT value is 5.5 						NULL is NOT permitted
budget			DECIMAL, up to 10 digits, 2 of which after the decimal point.			NULL is NOT permitted.
release_date	The release date of the game.											NULL is permitted.
team_id			Integer, from 1 to 2,147,483,647.										Relationship with table teams. NULL is NOT permitted.


/*
#addresses
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 50 characters. Unicode is NOT needed.	NULL is NOT permitted.

#categories
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 10 characters. Unicode is NOT needed.	NULL is NOT permitted.

#offices
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
workspace_capacity	Integer, from 1 to 2,147,483,647.									NULL is NOT permitted.
website			A string containing a maximum of 50 characters. Unicode is NOT needed.	NULL is permitted.
address_id		Integer, from 1 to 2,147,483,647.										Relationship with addresses. NULL is NOT permitted.

#employees
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
first_name		A string containing a maximum of 30 characters. Unicode is NOT needed.	NULL is NOT permitted.
last_name		A string containing a maximum of 30 characters. Unicode is NOT needed.	NULL is NOT permitted.
age				Integer, from 1 to 2,147,483,647.										NULL is NOT permitted.
salary			DECIMAL number, up to 10 digits, 2 of which after the decimal point.	NULL is NOT permitted.
job_title		A string containing a maximum of 20 characters. Unicode is NOT needed.	NULL is NOT permitted.
happiness_level	A character that shows the happiness level of the employee. 
                Can be ‘L’- Low, ‘N’ - Normal or ‘H’- High								NULL is NOT permitted.

#teams
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 40 characters. Unicode is NOT needed.	NULL is NOT permitted.
office_id		Integer, from 1 to 2,147,483,647.										Relationship with table offices. NULL is NOT permitted.
leader_id		Integer, from 1 to 2,147,483,647.										Relationship with table employees. The values are UNIQUE. NULL is NOT permitted.

games
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 50 characters. Unicode is NOT needed.	NULL is NOT permitted. UNIQUE
description		A very long string field. 												NULL is permitted.
rating			A floating point numbers.	DEFAULT value is 5.5 						NULL is NOT permitted
budget			DECIMAL, up to 10 digits, 2 of which after the decimal point.			NULL is NOT permitted.
release_date	The release date of the game.											NULL is permitted.
team_id			Integer, from 1 to 2,147,483,647.										Relationship with table teams. NULL is NOT permitted.

games_categories
Column Name	Data Type	Constraints
game_id	Integer, from 1 to 2,147,483,647.	NULL is NOT permitted.
category_id	Integer, from 1 to 2,147,483,647.	NULL is NOT permitted.
•	The games_categories table has a composite primary key from game_id and category_id.
	
Submit your solutions in Judge on the first task. Submit all SQL table creation statements.
You will also be given a data.sql file. It will contain a dataset with data which you will need to store in your local database. This data will be given to you, so you do not have to imagine it and lose precious time in the process.
The data is in the form of INSERT statement queries.


*/