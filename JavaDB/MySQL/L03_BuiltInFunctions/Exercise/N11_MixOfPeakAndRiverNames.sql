### Task 11. Mix of Peak and River Names 

SELECT 
	`peak_name`, 
    `river_name`, 
    lower(concat(p.`peak_name`, substring(r.`river_name`, 2))) AS `mix` 
FROM 
	peaks AS p, 
	rivers AS r
WHERE right(p.`peak_name`, 1) = left(r.`river_name`, 1)
ORDER BY `mix`;
