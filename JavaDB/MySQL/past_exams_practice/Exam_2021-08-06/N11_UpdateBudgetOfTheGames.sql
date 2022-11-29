### 11.	Update budget of the games

DELIMITER $$

DROP PROCEDURE IF EXISTS udp_update_budget$$

CREATE PROCEDURE udp_update_budget (min_game_rating FLOAT)
BEGIN
    UPDATE games
       SET `budget` = `budget` + 100000,
           `release_date` = date_add(`release_date`, interval 1 year)
	 WHERE `id` NOT IN (SELECT game_id FROM games_categories) AND
           `release_date` IS NOT NULL AND
           `rating` > min_game_rating AND
           `id` > 0;
END$$

DELIMITER ;
SELECT * FROM games;
CALL udp_update_budget (8);
SELECT * FROM games;
/* 
11.	Update budget of the games 
We will have to increase the support of the games that do not have any categories yet. 
We should find them and increase their budget, as well as push their release date
The procedure must increase the budget by 100,000 and add one year to their release_date 
to the games that do not have any categories and their rating is more than (not equal) the given parameter min_game_rating and release date is NOT NULL.
Create a stored procedure udp_update_budget which accepts the following parameters:
•	min_game_rating(floating point number) 

Query
CALL udp_update_budget (8);
This execution will update three games – Quo Lux, Daltfresh and Span.
Result
Quo Lux - 23384.32 -> 123384.32 | 2022-06-26 -> 2023-06-26
Daltfresh - 86012.38 -> 186012.38 | 2021-06-17 -> 2022-06-17
Span - 47468.36 -> 147468.36 | 2022-06-05 -> 2023-06-05

*/