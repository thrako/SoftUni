### 06.	Quantity

      SELECT `id`, `brand_id`, `name`, `quantity_in_stock`
        FROM products
       WHERE price > 1000 AND 
             quantity_in_stock < 30
    ORDER BY quantity_in_stock ASC,
	         id ASC;

/*
06.	Quantity
Write a query that returns: product_id, brand_id, name and quantity from table products. 
Filter products which price is higher than 1000 and their quantity is lower than 30.
Order the results ascending by quantity_in_stock, then by id.
Required Columns
•	id (product)
•	brand_id 
•	name (product)
•	quantity_in_stock
Example
id	brand_id	name	quantity_in_stock
19	6	GeneralElectric superCool	4
36	3	Overhold	13
2	11	DSLR camera NIKON D5600	21
27	3	Eagle Vision GS340	24

*/