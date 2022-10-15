### Task 08. Create View Employees Hired After

CREATE VIEW v_employees_hired_after_2000 AS
	SELECT `first_name`, `last_name` FROM employees
	WHERE year(hire_date) > 2000;
    
SELECT * FROM v_employees_hired_after_2000;
