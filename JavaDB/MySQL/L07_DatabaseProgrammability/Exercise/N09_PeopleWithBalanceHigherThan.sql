### Task 09. People with Balance Higher Than

DELIMITER $$

DROP PROCEDURE IF EXISTS usp_get_holders_with_balance_higher_than$$

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(threshold INT)

BEGIN
	 SELECT `first_name`, `last_name`
       FROM accounts AS a
                JOIN
	        account_holders AS ah ON ah.`id` = a.`account_holder_id`
   GROUP BY a.`account_holder_id`
     HAVING sum(a.`balance`) > threshold
   ORDER BY ah.`id`;
END$$

CALL usp_get_holders_with_balance_higher_than(7000)$$
