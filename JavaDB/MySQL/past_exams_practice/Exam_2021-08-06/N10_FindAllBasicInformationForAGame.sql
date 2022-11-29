### 10.	Find all basic information for a game

DELIMITER $$

DROP FUNCTION IF EXISTS udf_game_info_by_name$$

CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    RETURN concat        ('The ', 
                          game_name, 
                          ' is developed by a ', 
                         (SELECT t.`name`
                            FROM games AS g
                                   JOIN
						         teams AS t		ON t.`id` = g.`team_id`
					       WHERE g.`name` = game_name), 
                           ' in an office with an address ',
                         (SELECT a.`name`
                            FROM games AS g
                                   JOIN
							     teams AS t		ON t.`id` = g.`team_id`
                                   JOIN
								 offices AS o 	ON o.`id` = t.`office_id`
                                   JOIN
                                 addresses AS a ON a.`id` = o.`address_id`
						   WHERE g.`name` = game_name));
END$$

DELIMITER ;

SELECT udf_game_info_by_name('Bitwolf') AS info;
SELECT udf_game_info_by_name('Fix San') AS info;
SELECT udf_game_info_by_name('Job') AS info;
           
/* 
10.	Find all basic information for a game
Create a user defined function with the name udf_game_info_by_name (game_name VARCHAR (20)) that receives a game's name and returns the basic information as a text sentence.
•	Example
o	The "game_name" is developed by a "team_name" in an office 
with an address "address_text"

Example 1
Query
SELECT udf_game_info_by_name('Bitwolf') AS info;
info
The Bitwolf is developed by a Rempel-O'Kon in an office with an address 92 Memorial Park

Example 2
Query
SELECT udf_game_info_by_name('Fix San') AS info;
info
The Fix San is developed by a Schulist in an office with an address 75 Harper Way

Example 3
Query
SELECT udf_game_info_by_name('Job') AS info;
info
The Job is developed by a Shields Group in an office with an address 036 Stuart Pass

*/