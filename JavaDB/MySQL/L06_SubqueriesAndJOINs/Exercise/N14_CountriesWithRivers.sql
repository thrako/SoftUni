### Task 14. Countries with Rivers

  SELECT c.`country_name`, r.`river_name`
    FROM countries AS c
			LEFT JOIN
	     countries_rivers AS cr ON c.`country_code` = cr.`country_code`
			LEFT JOIN
		 rivers AS r ON cr.`river_id` = r.`id`
   WHERE c.`continent_code` = (SELECT `continent_code` 
								 FROM continents
								WHERE `continent_name` = 'Africa'
                              )
ORDER BY c.`country_name` ASC
   LIMIT 5;
   