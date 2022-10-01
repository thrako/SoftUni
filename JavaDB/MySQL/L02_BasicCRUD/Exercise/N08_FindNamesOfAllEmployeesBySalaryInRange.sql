### Task  08. Find Names of All Employees by Salary in Range

SELECT `first_name`, `last_name`, `job_title` FROM employees
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;
