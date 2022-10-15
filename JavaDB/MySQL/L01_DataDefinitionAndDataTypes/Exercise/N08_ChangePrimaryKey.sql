### Task 08. Change Primary Key

ALTER TABLE users 
	DROP PRIMARY KEY, 
    ADD PRIMARY KEY (`id`, `username`);