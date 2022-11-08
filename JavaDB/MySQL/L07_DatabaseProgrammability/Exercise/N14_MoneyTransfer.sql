### Task 14. Money Transfer

DELIMITER $$

DROP PROCEDURE IF EXISTS usp_transfer_money$$

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
	DECLARE old_balance_from DECIMAL(19,4) 
    DEFAULT (SELECT balance
               FROM accounts
              WHERE id = from_account_id);
	
    DECLARE is_valid_from_account BOOLEAN 
    DEFAULT (SELECT count(id) 
               FROM accounts 
              WHERE id = from_account_id);
    
    DECLARE is_valid_to_account BOOLEAN 
    DEFAULT (SELECT count(id) 
               FROM accounts 
              WHERE id = to_account_id);
       
	  START TRANSACTION;    
         
     UPDATE accounts
        SET balance = balance - amount
      WHERE id = from_account_id;      
               
     UPDATE accounts
        SET balance = balance + amount
      WHERE id = to_account_id;
       
         IF old_balance_from < amount OR 
            amount < 0 OR
            NOT is_valid_from_account OR
			NOT is_valid_to_account           
       THEN ROLLBACK;
       ELSE COMMIT;
        END IF;      
END$$

CALL usp_transfer_money(1, 2, 100)$$

SELECT a.id AS account_id, ah.id AS holder_id, ah.first_name, ah.last_name, a.balance 
FROM accounts AS a 
       JOIN
	 account_holders AS ah ON ah.id = a.account_holder_id
WHERE a.id IN (1,2)$$
