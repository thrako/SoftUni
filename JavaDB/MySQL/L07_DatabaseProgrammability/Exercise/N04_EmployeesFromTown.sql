### Task 04. Employees from Town 

DELIMITER $$

CREATE PROCEDURE usp_get_employees_from_town(`town_arg` VARCHAR(45))
BEGIN

	  SELECT e.`first_name`, e.`last_name` 
        FROM employees AS e
			     JOIN
			 addresses AS a ON a.`address_id` = e.`address_id`
                 JOIN
			 towns AS t ON t.`town_id` = a.`town_id`
       WHERE t.`name` = `town_arg`
    ORDER BY e.`first_name` ASC, 
			 e.`last_name` ASC, 
			 e.`employee_id` ASC;

END$$

CALL usp_get_employees_from_town('Sofia')$$
