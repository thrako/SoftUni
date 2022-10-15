### Task 12. Games From 2011 and 2012 Year 

SELECT `name`, date_format(`start`, '%Y-%m-%d') AS `start` 
FROM games
WHERE year(`start`) IN (2011, 2012)
ORDER BY `start`
LIMIT 50;
