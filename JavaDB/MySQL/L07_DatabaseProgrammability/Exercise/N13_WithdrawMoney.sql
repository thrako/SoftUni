### Task 13. Withdraw Money

DELIMITER $$

DROP PROCEDURE IF EXISTS usp_withdraw_money$$

CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	DECLARE old_balance DECIMAL(19,4) DEFAULT (SELECT balance
                                                 FROM accounts
                                                WHERE id = account_id);
	  START TRANSACTION;    
         
     UPDATE accounts
        SET balance = balance - money_amount
      WHERE id = account_id;
       
         IF old_balance < money_amount OR money_amount < 0 
       THEN ROLLBACK;
       ELSE COMMIT;
        END IF;      
END$$

CALL usp_withdraw_money(1, 10)$$

SELECT * 
  FROM accounts AS a 
           JOIN 
       account_holders AS ah 
           ON ah.id = a.account_holder_id
 WHERE ah.id = 1 AND a.id = 1$$
