### 07.	Review

  SELECT *
    FROM reviews
   WHERE left(`content`, 2) = 'My' AND
         char_length(`content`) > 61
ORDER BY `rating` DESC;

/*
07.	Review
Write a query that returns: id, content, rating, picture_url and published_at for all reviews 
which content starts with ‘My’ and the characters of the content are more than 61 symbols.
Order by rating in descending order.
Required Columns
•	id (reviews)
•	content
•	rating
•	picture_url
•	published_at
Example
id	content	rating	picture_url	published_at
13	My kids love this product! I am amazed how well it works actually.	4.80	kjF54Foiu982	2020-10-12 23:12:00
12	My experience with those type of products is really bad, but i am very impressed with this	4.70	ds245asdfa84e88	2019-12-11 13:14:00
2	My neighbor Karly has one of these. She works as a gambler and she says it looks tall.	4.60	ukQQ_TEYAfBGkw%3A1635	2019-10-02 14:32:00
…	…	…	…	…


*/