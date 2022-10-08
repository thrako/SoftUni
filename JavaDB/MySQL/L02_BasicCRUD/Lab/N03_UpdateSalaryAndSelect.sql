### Task 03. Update Salary and Select

UPDATE employees 
   SET `salary` = `salary` + 100    
 WHERE `job_title` = 'Manager' AND
	   `id` > 0; 

SELECT `salary`
  FROM employees;
  