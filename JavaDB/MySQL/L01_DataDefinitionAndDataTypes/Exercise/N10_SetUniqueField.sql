### Task 10. Set Unique Field

ALTER TABLE users 
	DROP PRIMARY KEY, 
    ADD CONSTRAINT pk_users 
		PRIMARY KEY (`id`),	
    MODIFY COLUMN `username` CHAR(30) UNIQUE NOT NULL;