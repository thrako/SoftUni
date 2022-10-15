### Task 15. Show All Games with Duration 

SELECT 
	`name` AS `game`, 
    (CASE 
		WHEN hour(`start`) < 12 THEN 'Morning'
		WHEN hour(`start`) < 18 THEN 'Afternoon'
		WHEN hour(`start`) < 24 THEN 'Evening'
    END) AS `Part of the Day`,
    (CASE
		WHEN `duration` <= 3 THEN 'Extra Short'
		WHEN `duration` <= 6 THEN 'Short'
		WHEN `duration` <= 10 THEN 'Long'
		ELSE 'Extra Long'
    END) AS `Duration` 
FROM games;
