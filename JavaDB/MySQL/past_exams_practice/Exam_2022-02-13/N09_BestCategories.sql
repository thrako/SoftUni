### 09.	Best categories

  SELECT count(p.id) AS `items_count`,
         c.`name`,
         sum(p.`quantity_in_stock`) AS `total_quantity`
    FROM products AS p
           JOIN
		 categories AS c ON p.`category_id` = c.`id`
GROUP BY c.`id`
ORDER BY `items_count` DESC,
         `total_quantity` ASC
   LIMIT 5;


/*
09.	Best categories
Extract from the database, the top 5 categories.
Order the results descending by items count, then by total_quantity in ascending. 
Required Columns
•	items_count (number of items in the category)
•	name
•	total_quantity (sum of all items in this category)
Example
items_count	name	total_quantity
12	Small domestic appliances	639
10	Phones and tablets	775
9	Photo and Video	259
9	Laptops	437
9	Home appliances	542

*/