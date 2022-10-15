### Task 02. Select Employees with Filter

  SELECT `id`, concat_ws(' ', `first_name`, `last_name`) AS `full_name`, `job_title`, `salary`
    FROM employees
   WHERE `salary` > 1000.00
ORDER BY `id`; 
