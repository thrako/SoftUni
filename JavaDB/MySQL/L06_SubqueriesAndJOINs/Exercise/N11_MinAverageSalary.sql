### Task 11. Min Average Salary

  SELECT avg(e.`salary`) AS `min_average_salary`         
    FROM employees AS e
			JOIN
		 departments AS d
GROUP BY e.`department_id`
ORDER BY `min_average_salary`
   LIMIT 1;
   