### Task 17. Salary Challenge

  SELECT  `first_name`, 
		  `last_name`, 
          `department_id`
    FROM  employees AS e1
   WHERE  `salary` > (SELECT avg(`salary`)
					    FROM employees AS e2
					   WHERE e2.department_id = e1.department_id
                     )
ORDER BY  `department_id`, 
		  `employee_id`
   LIMIT  10;
