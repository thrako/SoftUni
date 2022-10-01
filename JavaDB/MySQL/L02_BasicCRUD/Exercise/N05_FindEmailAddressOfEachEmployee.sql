### Task  05. Find Email Address of Each Employee

SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg') AS `full_ email_address` 
	FROM employees 
ORDER BY `employee_id`;
