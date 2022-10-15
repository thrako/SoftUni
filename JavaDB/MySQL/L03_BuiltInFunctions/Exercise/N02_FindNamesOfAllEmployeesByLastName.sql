### Task 02. Find Names of All Employees by Last Name

SELECT `first_name`, `last_name` FROM employees
WHERE NOT locate('ei', `last_name`) = 0;
