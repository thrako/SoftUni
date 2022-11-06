### Task 17. Highest Peak and Longest River by Country

   SELECT `country_name`,
		  (SELECT max(`elevation`) 
             FROM mountains_countries AS mc 
                      LEFT JOIN
		          peaks AS p ON mc.`mountain_id` = p.`mountain_id`
            WHERE c.`country_code` = mc.`country_code`
          ) AS `highest_peak_elevation`, 
          (SELECT max(`length`) 
             FROM countries_rivers AS cr 
                      LEFT JOIN
		          rivers AS r ON cr.`river_id` = r.`id`
            WHERE c.`country_code` = cr.`country_code`
          ) AS `longest_river_length`
     FROM countries AS c
 ORDER BY `highest_peak_elevation` DESC,
		  `longest_river_length` DESC,
          `country_name` ASC
	 LIMIT 5;