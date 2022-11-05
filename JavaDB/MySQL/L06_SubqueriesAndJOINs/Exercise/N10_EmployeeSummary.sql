### Task 10. Employee Summary

  SELECT e.`employee_id`,
		 concat(e.`first_name`, ' ', e.`last_name`) AS `employee_name`,		 
         (SELECT concat(m.`first_name`, ' ', m.`last_name`)
            FROM employees AS m
		   WHERE e.`manager_id` = m.`employee_id`
         ) AS `manager_name`,
         (SELECT d.`name`
            FROM departments AS d
            WHERE e.`department_id` = d.`department_id`         
         ) AS `department_name`         
    FROM employees AS e 			
   WHERE NOT e.`manager_id` IS NULL
ORDER BY e.`employee_id`
   LIMIT 5;
   