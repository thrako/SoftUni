### Task 20. Increase Salaries

UPDATE employees
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1, 2, 4, 11);
SELECT `salary` FROM employees;
