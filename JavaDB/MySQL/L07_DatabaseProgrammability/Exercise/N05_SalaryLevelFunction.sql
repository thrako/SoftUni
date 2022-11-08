### Task 05. Salary Level Function

DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(`salary_arg` INT)
RETURNS VARCHAR(7)
DETERMINISTIC
BEGIN

    DECLARE salary_lvl VARCHAR(7);
    SET salary_lvl := (CASE 
					       WHEN salary_arg < 30000 THEN 'Low'
                           WHEN salary_arg > 50000 THEN 'High'
                           ELSE 'Average'
                       END
					  );
    RETURN salary_lvl;

END$$

SELECT ufn_get_salary_level(51000)$$
