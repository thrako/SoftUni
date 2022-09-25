-- task 1
SELECT * FROM `departments`
ORDER BY `department_id`;

-- task 2
SELECT `name` FROM `departments`
ORDER BY `department_id`;

-- task 3
SELECT `first_name`,`last_name`,`salary` FROM `employees`
ORDER BY `employee_id`;

-- task 4
SELECT `first_name`, `middle_name`, `last_name` FROM `employees`
ORDER BY `employee_id`;

-- task 5
SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg') 
AS `full_ email_address` 
FROM `employees` 
ORDER BY `employee_id`;

-- task 6
SELECT DISTINCT `salary` FROM `employees`;

-- task 7
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

-- task 8
SELECT `first_name`, `last_name`, `job_title` FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

-- task 9
SELECT CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) AS `Full Name` FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600)
ORDER BY `employee_id`;

-- task 10
SELECT `first_name`, `last_name` FROM `employees`
WHERE `manager_id` IS NULL
ORDER BY `employee_id`;

-- task 11
SELECT `first_name`, `last_name`, `salary` FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

-- task 12
SELECT `first_name`, `last_name` FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

-- task 13
SELECT `first_name`, `last_name` FROM `employees`
WHERE NOT (`department_id` = 4);

-- task 14
SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name` ASC, `last_name` DESC, `middle_name` ASC, `employee_id` ASC;

-- task 15
CREATE VIEW `v_employees_salaries` AS
	SELECT `first_name`, `last_name`, `salary` FROM `employees`;
    
-- task 16
CREATE VIEW `v_employees_job_titles` AS
	SELECT CONCAT_WS (' ', `first_name`, `middle_name`, `last_name`) AS 'full employee name', `job_title`  FROM `employees`;
    
-- task 17
SELECT DISTINCT `job_title` 
FROM `employees`
ORDER BY `job_title`;

-- task 18
SELECT * FROM `projects`
ORDER BY `start_date` ASC, `name` ASC, `project_id` ASC
LIMIT 10;

-- task 19
SELECT `first_name`, `last_name`, `hire_date` FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

-- task 20
UPDATE `employees`
SET `salary` = `salary` * '1.12'
WHERE `department_id` IN (1, 2, 4, 11);
SELECT `salary` FROM `employees`;

-- `geography`
-- task 21
SELECT `peak_name` FROM `peaks`
ORDER BY `peak_name` ASC;

-- task 22
SELECT `country_name`, `population` FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC
LIMIT 30;

-- task 23
SELECT `country_name`, `country_code`, IF (`currency_code` = 'EUR', 'Euro', 'Not Euro') AS `currency` 
FROM `countries`
ORDER BY `country_name` ASC;

-- `diablo`
-- task 24
SELECT `name` FROM `characters` ORDER BY `name` ASC;
