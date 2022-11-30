### 04.	Delete

DELETE  
  FROM customers AS c         
 WHERE (c.id NOT IN (SELECT o.customer_id FROM orders AS o)) AND
	   (c.id > 0);

/*
04.	Delete
Delete all customers, who didn't order anything.

*/