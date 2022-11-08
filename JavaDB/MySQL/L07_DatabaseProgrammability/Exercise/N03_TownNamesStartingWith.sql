### Task 03. Town Names Starting With 

DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(`string_arg` VARCHAR(45))
BEGIN

	  SELECT `name` 
        FROM  towns
       WHERE  locate(`string_arg`, `name`) = 1
    ORDER BY `name` ASC;

END$$

CALL usp_get_towns_starting_with('b')$$
