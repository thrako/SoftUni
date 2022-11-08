### Task 12. Deposit Money

DELIMITER $$

DROP PROCEDURE IF EXISTS usp_deposit_money$$

CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN

	 START TRANSACTION;    
     
     UPDATE  accounts
        SET `balance` = `balance` + money_amount
      WHERE `id` = account_id;
     
         IF money_amount < 0 THEN ROLLBACK;
       ELSE COMMIT;
     END IF;
      
END$$

CALL usp_deposit_money(1, 10)$$

SELECT * 
  FROM accounts AS a 
           JOIN
	   account_holders AS ah ON ah.`id` = a.`account_holder_id`
 WHERE ah.`id` = 1 AND a.`id` = 1 $$


