### 3.	Update

  UPDATE employees
     SET `salary` = `salary` + 1000
   WHERE age < 40 AND
		 salary < 5000 AND
         id IN (SELECT `leader_id`
                  FROM teams
               ) AND
         id > 0;


/*
3.	Update
After a good work in recent months, management has decided to raise the salaries of all young team leaders.
Update all young employees (only team leaders) with age under 40(exclusive) and increase their salary with 1000. 
Skip the employees with salary over 5000(inclusive). Their salaries are already high.


*/