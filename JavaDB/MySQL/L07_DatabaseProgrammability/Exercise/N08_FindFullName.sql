### Task 08. Find Full Name

DELIMITER $$

DROP PROCEDURE IF EXISTS usp_get_holders_full_name$$

CREATE PROCEDURE usp_get_holders_full_name()

BEGIN
	  SELECT  concat_ws(' ', `first_name`, `last_name`) AS `full_name`
        FROM  account_holders
    ORDER BY `full_name`, `id`;
END$$

CALL usp_get_holders_full_name()$$
