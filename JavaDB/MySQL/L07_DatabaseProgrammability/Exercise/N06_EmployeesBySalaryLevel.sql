### Task 06. Employees by Salary Level 

DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(`salary_arg` VARCHAR(7))
BEGIN
    SELECT `first_name`, `last_name`
      FROM  employees
     WHERE  (CASE 
				WHEN salary_arg = 'Low'     THEN `salary` < 30000
                WHEN salary_arg = 'Average' THEN `salary` >= 30000 AND `salary` <= 50000 
                WHEN salary_arg = 'High'    THEN `salary` > 50000
                ELSE 0 = 1
             END
		    )
  ORDER BY `first_name` DESC, 
           `last_name` DESC;
END$$

CALL usp_get_employees_by_salary_level('High')$$
