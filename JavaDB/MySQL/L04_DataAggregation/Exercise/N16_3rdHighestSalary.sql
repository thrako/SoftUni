### Task 16. 3rd Highest Salary

  SELECT  department_id AS `dep_id`, 
		  (SELECT DISTINCT  `salary` 
			          FROM  employees
			         WHERE  department_id = `dep_id`
	  	          ORDER BY  `salary` DESC
			         LIMIT  2, 1
		  ) AS `third_highest_salary`
    FROM  employees
GROUP BY  `dep_id`
  HAVING  `third_highest_salary` IS NOT NULL
ORDER BY  `dep_id`;
