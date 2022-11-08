### Task 01. Employee Address

  SELECT `employee_id`, `job_title`, e.`address_id`, `address_text`
    FROM employees AS e
			JOIN
		 addresses AS a
			ON e.`address_id` = a.`address_id`
ORDER BY `address_id`
   LIMIT 5;
   