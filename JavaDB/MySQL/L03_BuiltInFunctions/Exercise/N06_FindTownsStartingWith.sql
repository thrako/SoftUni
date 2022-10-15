### Task 06. Find Towns Starting With

SELECT `town_id`, `name` FROM towns
WHERE left(`name`, 1) IN ('m','k','b','e')
ORDER BY `name`;
