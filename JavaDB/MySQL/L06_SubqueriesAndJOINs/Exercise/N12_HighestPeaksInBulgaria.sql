### Task 12. Highest Peaks in Bulgaria

  SELECT mc.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
    FROM peaks AS p
			JOIN
	     mountains AS m ON p.`mountain_id` = m.`id`
			JOIN
	     mountains_countries AS mc ON p.`mountain_id` = mc.`mountain_id`
			JOIN
		 countries AS c ON mc.`country_code` = c.`country_code`
   WHERE (p.`elevation` > 2835) AND 
	     (mc.`country_code` = (SELECT `country_code` 
							     FROM countries
							    WHERE `country_name` = 'Bulgaria'
						      )
	     )
ORDER BY p.`elevation` DESC;
   