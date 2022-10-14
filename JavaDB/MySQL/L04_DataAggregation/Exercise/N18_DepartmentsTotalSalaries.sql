### Task 18. Departments Total Salaries

  SELECT  `department_id`, 
		  sum(`salary`) AS `total_salary`
    FROM  employees
GROUP BY  `department_id`
ORDER BY  `department_id`;
