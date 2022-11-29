### 4.	Delete

  DELETE 
    FROM games
   WHERE `release_date` IS NULL AND
         `id` NOT IN (SELECT `game_id` FROM games_categories) AND
         `id` > 0;


/*
4.	Delete
After a lot of manipulations on our base, now we must clean up.
Delete all games from table games, which do not have a category and release date. 

*/