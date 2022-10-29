### 03.	Update

UPDATE orders
   SET `table_id` = `table_id` - 1
 WHERE `id` BETWEEN 12 AND 23;

/* 
03.	Update
Somebody made a mistake with the orders and you should correct it. 
Find the orders with id from 12(inclusive) to 23(inclusive) and lower their tables id with 1.
 - e.g. table_id 40 -> table_id 39

*/