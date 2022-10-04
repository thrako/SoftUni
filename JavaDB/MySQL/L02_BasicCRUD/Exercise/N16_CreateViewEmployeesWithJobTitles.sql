### Task 16. Create View Employees with Job Titles

CREATE VIEW v_employees_job_titles AS
	SELECT 
		CONCAT_WS (' ', `first_name`, `middle_name`, `last_name`) 
			AS `full employee name`, 
		`job_title` 
	FROM employees;
