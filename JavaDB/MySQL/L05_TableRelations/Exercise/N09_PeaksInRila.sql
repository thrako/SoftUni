### Task 09. Peaks in Rila

SELECT 
    `mountain_range`,
    `peak_name`,
    `elevation` AS `peak_elevation`
FROM
    mountains AS m
        JOIN
    peaks AS p 
		ON m.`id` = p.`mountain_id`
WHERE
    `mountain_range` = 'Rila'
ORDER BY 
	`peak_elevation` DESC;