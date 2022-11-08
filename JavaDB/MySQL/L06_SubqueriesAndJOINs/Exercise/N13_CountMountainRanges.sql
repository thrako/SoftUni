### Task 13. Count Mountain Ranges

  SELECT mc.`country_code`, count(m.`mountain_range`) AS `mountain_range`
    FROM mountains AS m
			JOIN
	     mountains_countries AS mc ON m.`id` = mc.`mountain_id`
			JOIN
		 countries AS c ON mc.`country_code` = c.`country_code`
   WHERE mc.`country_code` IN (SELECT `country_code` 
							   FROM countries
							   WHERE `country_name` IN ('United States', 'Russia', 'Bulgaria')
						      )
GROUP BY mc.`country_code`
ORDER BY count(m.`mountain_range`) DESC;
   