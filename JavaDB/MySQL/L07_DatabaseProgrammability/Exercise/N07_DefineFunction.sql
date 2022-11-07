### Task 07. Define Function

DELIMITER $$

DROP FUNCTION IF EXISTS ufn_is_word_comprised$$

CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE v_counter INT DEFAULT 1;    
    DECLARE v_length INT DEFAULT char_length(word);
    
    WHILE v_counter <= v_length DO
		 IF locate(lower(substring(word, v_counter, 1)), lower(set_of_letters)) = 0 THEN RETURN 0; 
	 END IF;
		SET v_counter = v_counter + 1;
    END WHILE;
    
    RETURN 1;  
END$$

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia')$$
