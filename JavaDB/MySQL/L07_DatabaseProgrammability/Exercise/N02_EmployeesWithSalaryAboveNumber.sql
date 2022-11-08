### Task 02. Employees with Salary Above Number

DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above(base_salary DECIMAL(65, 4))
BEGIN

	  SELECT `first_name`, `last_name` 
        FROM  employees
       WHERE `salary` >= base_salary
    ORDER BY `first_name` ASC, 
             `last_name` ASC, 
             `employee_id` ASC;

END$$

CALL usp_get_employees_salary_above(45000)$$
