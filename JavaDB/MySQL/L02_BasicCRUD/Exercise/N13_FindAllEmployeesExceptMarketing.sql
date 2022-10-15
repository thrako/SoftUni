### Task 13. Find All Employees Except Marketing

SELECT `first_name`, `last_name` FROM employees
WHERE NOT (`department_id` = 4);
