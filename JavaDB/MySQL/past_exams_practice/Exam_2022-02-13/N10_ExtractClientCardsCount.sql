### 10.	Extract client cards count

DELIMITER $$

DROP FUNCTION IF EXISTS udf_customer_products_count$$

CREATE FUNCTION udf_customer_products_count(arg_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN (SELECT count(p.id)
              FROM customers AS c
                     JOIN
				   orders AS o ON c.id = o.customer_id
                     JOIN
				   orders_products AS op ON o.id = op.order_id
                     JOIN
				   products AS p ON op.product_id = p.id
			  WHERE c.first_name = arg_name
           );
END$$

DELIMITER ;

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';

/*
10.	Extract client cards count
Create a user defined function with the name udf_customer_products_count(name VARCHAR(30)) 
that receives a customer’s first name and returns the total number of products he ordered;

Required Columns
•	first_name (customers)
•	last_name (customers)
•	total_products (udf_customer_products_count)

Example
Query
SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';

first_name	last_name	total_products
Shirley	Clayfield	5

*/