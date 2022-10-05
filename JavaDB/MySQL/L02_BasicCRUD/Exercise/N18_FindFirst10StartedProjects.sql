### Task 18. Find First 10 Started Projects

SELECT * FROM projects
ORDER BY 
	`start_date` ASC, 
    `name` ASC, 
    `project_id` ASC
LIMIT 10;
