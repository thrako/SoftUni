### Task 14. Get Users with IP Address Like Pattern

SELECT `user_name`, `ip_address` 
FROM users 
WHERE `ip_address` LIKE	'___.1%.%.___'
ORDER BY `user_name`;
