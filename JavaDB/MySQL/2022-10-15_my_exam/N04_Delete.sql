### 04.	Delete

DELETE
  FROM waiters
 WHERE NOT `id` IN (SELECT `waiter_id`
                     FROM orders);

/* 
04.	Delete
Delete all waiters, who don't have any orders.

*/