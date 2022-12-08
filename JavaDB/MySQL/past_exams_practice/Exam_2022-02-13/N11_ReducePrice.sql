### 11.	Reduce price

DELIMITER $$

DROP PROCEDURE IF EXISTS udp_reduce_price$$

CREATE PROCEDURE udp_reduce_price (category_name VARCHAR(50))
BEGIN
    UPDATE products                          
       SET `price` = `price` * (1 - 0.3)
     WHERE category_id = (SELECT `id`
						    FROM categories AS c
					       WHERE c.`name` = category_name) 
		     AND
		   (SELECT rating
              FROM reviews AS r
  	         WHERE r.id = review_id)  < 4;
END$$

DELIMITER ;

-- test
# SELECT * FROM products WHERE category_id = 1;
# CALL udp_reduce_price ('Phones and tablets');
# SELECT * FROM products WHERE category_id = 1;

/*
11.	Reduce price
Create a stored procedure udp_reduce_price which accepts the following parameters:
•	category_name (VARCHAR(50))
Extracts data about the products from the given category and 
reduces the prices by 30% of all products which 
have reviews with rating less than 4 and are from the given category.

Result
Query
CALL udp_reduce_price ('Phones and tablets');
This execution will update 6 products – Galaxy M52 5G, Galaxy Z Fold3 5G, XS 420 …
Result
Galaxy M52 5G - 789.00 -> 552.30 
Galaxy Z Fold3 5G – 599.00 -> 419.30 
XS 420 – 754.00 -> 527.80
…    …   … 
*/