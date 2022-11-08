### Task 15. Log Accounts Trigger

DELIMITER $$

DROP TABLE IF EXISTS `logs`$$

CREATE TABLE     `logs`(
		`log_id` INT PRIMARY KEY AUTO_INCREMENT, 
    `account_id` INT NOT NULL, 
       `old_sum` DECIMAL(19,4), 
       `new_sum` DECIMAL(19,4) NOT NULL
)$$

DROP TRIGGER IF EXISTS tr_log_balance_changes$$

CREATE TRIGGER tr_log_balance_changes
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	         IF (OLD.balance <> NEW.balance) THEN
	INSERT INTO `logs` 
                (`account_id`, `old_sum`, `new_sum`)
         VALUES (OLD.id,  OLD.balance, NEW.balance);
	     END IF;
END$$

call usp_withdraw_money(1, 10)$$

call usp_deposit_money(1, 20)$$

UPDATE accounts
   SET accounts.balance = 145.43
 WHERE accounts.id = 1$$

SELECT * 
  FROM `logs`$$
