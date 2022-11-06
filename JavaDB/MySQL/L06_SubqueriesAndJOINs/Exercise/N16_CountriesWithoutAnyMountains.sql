### Task 16.  Countries Without Any Mountains

SELECT count(*) AS `country_count`
  FROM countries AS c
	       LEFT JOIN
	   mountains_countries AS m ON c.`country_code` = m.`country_code`
WHERE m.`mountain_id` IS NULL;
   