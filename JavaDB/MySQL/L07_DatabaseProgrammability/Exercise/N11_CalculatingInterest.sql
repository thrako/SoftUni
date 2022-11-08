### Task 11. Calculating Interest

DELIMITER $$

DROP FUNCTION IF EXISTS ufn_calculate_future_value$$

CREATE FUNCTION ufn_calculate_future_value(arg_sum DECIMAL(19, 4), arg_yearly_interest_rate DECIMAL(19, 4), arg_years INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
	 RETURN arg_sum * pow((1 + arg_yearly_interest_rate), arg_years);
END$$

DROP PROCEDURE IF EXISTS usp_calculate_future_value_for_account$$

CREATE PROCEDURE usp_calculate_future_value_for_account(arg_account_id INT, arg_yearly_interest_rate DECIMAL(19, 4))
BEGIN
	    
	 SELECT  a.id AS `account_id`,
			`first_name`,
            `last_name`,
             a.`balance` AS `current_balance`,
             ufn_calculate_future_value(a.balance, arg_yearly_interest_rate, 5) AS `balance_in_5_years`             
	   FROM  account_holders AS ah
			     LEFT JOIN
			 accounts AS a ON ah.`id` = a.`account_holder_id`
	  WHERE  a.`id` = arg_account_id;
END$$

CALL usp_calculate_future_value_for_account(1, 0.1)$$
