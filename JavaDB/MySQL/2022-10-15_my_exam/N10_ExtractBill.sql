### 10.	Extract bill

DELIMITER $$

DROP FUNCTION IF EXISTS udf_client_bill$$

CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))  
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
    RETURN (  SELECT round(sum(p.`price`), 2) AS `bill`
                FROM products AS p
                       JOIN
                     orders_products AS op 	ON op.`product_id` = p.`id`
                       JOIN
                     orders AS o 			ON o.`id` = op.`order_id`  
                       JOIN
                     orders_clients AS oc	ON oc.`order_id` = o.`id`
                       JOIN
                     clients AS c			ON c.`id` = oc.`client_id`
		 	   WHERE concat_ws(' ', c.`first_name`, c.`last_name`) = full_name
            GROUP BY c.`id`            
           );

END$$

DELIMITER ;

SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

/* 
10.	Extract bill
Create a user defined function with the name udf_client_bill(full_name VARCHAR(50)) that 
receives a customer’s full name and 
returns the total price of products he ordered;

Required Columns
•	first_name (client)
•	last_name (client)
•	bill (udf_client_bill) (should be DECIMAL(19,2))

Example
Query
SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';
first_name	last_name	bill
Silvio	Blyth	96.90

*/