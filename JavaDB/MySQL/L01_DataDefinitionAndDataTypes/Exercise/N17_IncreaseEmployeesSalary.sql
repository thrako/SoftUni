### Task 17. Increase Employees Salary 

UPDATE employees
	SET `salary` = `salary` * 1.10
	WHERE `id` > 0;

SELECT `salary` FROM employees;
