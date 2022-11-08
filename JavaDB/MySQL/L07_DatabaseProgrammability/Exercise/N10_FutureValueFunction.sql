### Task 10. Future Value Function

DELIMITER $$

DROP FUNCTION IF EXISTS ufn_calculate_future_value$$

CREATE FUNCTION ufn_calculate_future_value(arg_sum DECIMAL(19, 4), arg_yearly_interest_rate DOUBLE, arg_years INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
	 RETURN arg_sum * pow((1 + arg_yearly_interest_rate), arg_years);
END$$

SELECT ufn_calculate_future_value(1000, 0.5, 5)$$
