### Task 11. Average Interest

SELECT 
    `deposit_group`,
    `is_deposit_expired`,
    avg(`deposit_interest`) AS `avg_interest`
FROM wizzard_deposits
WHERE `deposit_start_date` > date('1985-01-01')
GROUP BY 
	`deposit_group`, 
    `is_deposit_expired`
ORDER BY 
	`deposit_group` DESC, 
	`is_deposit_expired` ASC;
