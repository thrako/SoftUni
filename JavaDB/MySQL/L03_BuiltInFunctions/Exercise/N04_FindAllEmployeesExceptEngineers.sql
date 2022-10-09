### Task 04. Find All Employees Except Engineers

SELECT `first_name`, `last_name` FROM employees
WHERE locate('engineer', `job_title`) = 0
ORDER BY `employee_id`;
