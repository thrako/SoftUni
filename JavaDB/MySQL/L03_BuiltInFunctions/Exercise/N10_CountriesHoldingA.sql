### Task 10. Countries Holding 'A' 

SELECT `country_name`, `iso_code` FROM countries
WHERE `country_name` LIKE('%a%a%a%')
ORDER BY `iso_code`;
