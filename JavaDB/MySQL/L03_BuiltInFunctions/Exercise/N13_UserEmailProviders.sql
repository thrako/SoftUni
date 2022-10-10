### Task 13. User Email Providers

SELECT 
	`user_name`, 
    substr(`email`, locate('@', `email`) + 1) AS `Email Provider` 
FROM users
ORDER BY 
	`Email Provider` ASC, 
    `user_name` ASC;
