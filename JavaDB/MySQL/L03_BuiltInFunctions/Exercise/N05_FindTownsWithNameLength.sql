### Task 05. Find Towns with Name Length

SELECT `name` FROM towns
WHERE char_length(`name`) IN (5, 6)
ORDER BY `name`;
