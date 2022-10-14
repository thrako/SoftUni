### Task 12. Employees Minimum Salaries

SELECT 
	`department_id`, 
    min(`salary`) AS `minimum_salary`	
FROM employees
WHERE `hire_date` > DATE('2000-01-01')
GROUP BY `department_id`
HAVING `department_id` IN (2, 5, 7)
ORDER BY `department_id` ASC;
