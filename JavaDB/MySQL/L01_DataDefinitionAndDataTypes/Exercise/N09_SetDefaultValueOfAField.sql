### Task 09. Set Default Value of a Field

ALTER TABLE users
	MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();