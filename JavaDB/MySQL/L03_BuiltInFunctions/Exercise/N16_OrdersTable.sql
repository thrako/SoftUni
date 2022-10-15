### Task 16. Orders Table

SELECT 
	`product_name`, 
    `order_date`, 
	date_add(`order_date`, interval 3 day) AS `pay_due`, 
	date_add(`order_date`, interval 1 month) AS `deliver_due`
FROM orders;
