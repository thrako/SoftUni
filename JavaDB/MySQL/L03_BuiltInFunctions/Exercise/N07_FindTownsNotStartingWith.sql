### Task 07. Find Towns Not Starting With

SELECT `town_id`, `name` FROM towns
WHERE left(`name`, 1) NOT IN ('r','b','d')
ORDER BY `name`;
