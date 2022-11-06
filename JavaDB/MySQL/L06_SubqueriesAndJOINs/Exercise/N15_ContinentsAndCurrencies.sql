### Task 15. *Continents and Currencies

    WITH `usage` AS (  SELECT `continent_code`, `currency_code`, count(currency_code) AS `usage_count`
                         FROM countries
                     GROUP BY `continent_code`, `currency_code`                   
				    )
  SELECT `continent_code`, `currency_code`, `usage_count` AS `currency_usage`
    FROM `usage`
  HAVING `currency_usage` > 1 AND 
	     `usage_count` = (SELECT max(`usage_count`)
					        FROM `usage` as u
					       WHERE `usage`.continent_code = u.continent_code
					     )
ORDER BY `continent_code`, `currency_code`;
   