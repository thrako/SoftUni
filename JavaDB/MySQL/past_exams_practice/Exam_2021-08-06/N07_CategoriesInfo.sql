### 7. Categories Info

    SELECT c.`name`, 
           count(g.`id`) AS `games_count`, 
		   round(avg(g.`budget`), 2) AS `avg_budget`, 
           max(g.rating) AS `max_rating`
      FROM categories AS c
             JOIN
		   games_categories AS gc ON c.`id` = gc.`category_id`
             JOIN
           games AS g ON gc.`game_id` = g.`id`
  GROUP BY c.`id`
    HAVING `max_rating` >= 9.5
  ORDER BY `games_count` DESC,
           c.`name` ASC;



/* 
7.	    Categories Info
Now, we need a more detailed information about categories – count of game, average budget and max rating.
Select all 
   categories names, 
   count of the games from each category, 
   the average budget (rounded to the second digit after the decimal point) of all games from the current category and 
   the max rating of games from a category.
Order the result by count of games in descending order, then by the name of the category alphabetically. 
Skip categories with max rating lower than 9.5(exclusive).

Required Columns
•	name
•	games_count
•	avg_budget (rounded to the second digit after the decimal point)
•	max_rating
Example
name	games_count	avg_budget	max_rating
Puzzle	18	54340.62	9.8
Action	14	46425.07	9.6
MMORPG	14	57006.74	9.5
Strategy	14	39754.41	9.6
Sports	13	41122.07	9.8

*/