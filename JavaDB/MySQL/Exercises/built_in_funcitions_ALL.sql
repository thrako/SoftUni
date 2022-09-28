USE `soft_uni`;
-- task 1
SELECT `first_name`, `last_name` FROM `employees`
WHERE substring(`first_name`, 1, 2) = 'Sa';

-- task 2
SELECT `first_name`, `last_name` FROM `employees`
WHERE NOT LOCATE('ei', `last_name`) = 0;

-- task 3
SELECT `first_name` FROM `employees`
WHERE 	(`department_id` IN (3, 10)) AND
		(YEAR(`hire_date`) BETWEEN 1995 AND 2005)
ORDER BY `employee_id`;

-- task 4
SELECT `first_name`, `last_name` FROM `employees`
WHERE LOCATE('engineer', `job_title`) = 0
ORDER BY `employee_id`;

-- task 5
SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5, 6)
ORDER BY `name` ASC;

-- task 6
SELECT `town_id`, `name` FROM `towns`
WHERE LEFT(`name`, 1) IN ('m','k','b','e')
ORDER BY `name` ASC;

-- task 7
SELECT `town_id`, `name` FROM `towns`
WHERE LEFT(`name`, 1) NOT IN ('r','b','d')
ORDER BY `name` ASC;

-- task 8
CREATE VIEW `v_employees_hired_after_2000` AS
	SELECT `first_name`, `last_name` FROM `employees`
	WHERE year(hire_date) > 2000;
SELECT * FROM `v_employees_hired_after_2000`;

-- task 9
SELECT `first_name`, `last_name` FROM `employees`
WHERE char_length(`last_name`) = 5;

USE `geography`;
-- task 10
SELECT `country_name`, `iso_code` FROM `countries`
WHERE `country_name` LIKE('%a%a%a%')
ORDER BY `iso_code`;

-- task 11
SELECT 
	peak_name, 
    river_name, 
    lower(concat(peaks.peak_name, substring(rivers.river_name, 2))) AS mix 
FROM peaks JOIN rivers
WHERE right(peaks.peak_name, 1) = left(rivers.river_name, 1)
ORDER BY mix;

USE `diablo`;
-- task 12
SELECT `name`, date_format(`start`, '%Y-%m-%d') as 'start' FROM `games`
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY `start`
LIMIT 50;

-- task 13
SELECT 
	`user_name`, 
    substr(`email`, locate('@', `email`) + 1) AS 'Email Provider' 
FROM `users`
ORDER BY `Email Provider`, `user_name`;

-- task 14
SELECT `user_name`, `ip_address` 
FROM `users` 
WHERE `ip_address` LIKE	'___.1%.%.___'
ORDER BY `user_name` ASC;

-- task 15
SELECT 
	`name` AS 'game', 
    (CASE 
		WHEN hour(`start`) < 12 THEN 'Morning'
		WHEN hour(`start`) < 18 THEN 'Afternoon'
		WHEN hour(`start`) < 24 THEN 'Evening'
    END) AS 'Part of the Day',
    (CASE
		WHEN `duration` <= 3 THEN 'Extra Short'
		WHEN `duration` <= 6 THEN 'Short'
		WHEN `duration` <= 10 THEN 'Long'
		ELSE 'Extra Long'
    END) AS 'Duration' 
FROM `games`;

USE `orders`;
-- task 16
SELECT `product_name`, `order_date`, 
 date_add(`order_date`, interval 3 day) AS `pay_due`, 
 date_add(`order_date`, interval 1 month) AS `deliver_due`
FROM `orders`;