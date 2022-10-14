### Task 13. Employees Average Salaries

CREATE TABLE highest_paid AS (
				SELECT  * 
				  FROM  `employees`
			     WHERE  `salary` > 30000	 
);

ALTER TABLE  highest_paid
     MODIFY  `employee_id` INT NOT NULL PRIMARY KEY;

  DELETE 
    FROM  highest_paid 
   WHERE  `manager_id` = 42 AND `employee_id` > 0;

  UPDATE  highest_paid
     SET  `salary` = `salary` + 5000
   WHERE  `department_id` = 1 AND 
		  `employee_id` > 0;

  SELECT  `department_id`, 
		  avg(`salary`) AS `avg_salary`
    FROM  highest_paid
GROUP BY  `department_id`
ORDER BY  `department_id`;
