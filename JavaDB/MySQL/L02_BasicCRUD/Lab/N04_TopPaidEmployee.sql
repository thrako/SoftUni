### Task 04. Top Paid Employee

CREATE VIEW v_top_paid_employee AS
	 SELECT `id`, `first_name`, `last_name`, `job_title`, `department_id`, `salary`
       FROM employees
   ORDER BY `salary` DESC
      LIMIT 1;
    
     SELECT * 
       FROM v_top_paid_employee;
       