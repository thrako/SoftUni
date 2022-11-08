### Task 16. Emails Trigger

DELIMITER $$

DROP TABLE IF EXISTS `logs`$$

CREATE TABLE    `logs`(
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

DROP TABLE IF EXISTS notification_emails$$

CREATE TABLE    notification_emails(
		   `id` INT PRIMARY KEY AUTO_INCREMENT, 
    `recipient` INT, 
      `subject` VARCHAR(255), 
         `body` VARCHAR(255)
)$$

DROP TRIGGER IF EXISTS tr_email_log_on_balance_change$$

CREATE TRIGGER tr_email_log_on_balance_change
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	     DECLARE v_subject VARCHAR(255)
         DEFAULT concat('Balance change for account: ', NEW.account_id);
                
         DECLARE v_body VARCHAR(255)
         DEFAULT concat ('On ', date_format(now(), '%b %d %Y'), 
                         ' at ', time_format(now(), '%r'), 
						 ' your balance was changed from ', 
                         NEW.old_sum, ' to ', NEW.new_sum, '.');
    
	INSERT INTO `notification_emails` 
                (`recipient`, `subject`, `body`)
         VALUES (NEW.account_id, v_subject, v_body);
END$$

call usp_withdraw_money(1, 10)$$

call usp_deposit_money(1, 20)$$

UPDATE accounts
   SET accounts.balance = 145
 WHERE accounts.id = 1$$

SELECT * 
  FROM `logs`$$

SELECT * 
  FROM notification_emails$$
