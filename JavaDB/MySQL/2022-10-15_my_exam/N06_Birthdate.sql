### 06.	Birthdate

  SELECT `first_name`, `last_name`, `birthdate`, `review`
    FROM clients
   WHERE `card` IS NULL AND
         year(`birthdate`) BETWEEN 1978 AND 1993
ORDER BY `last_name` DESC,
         `id` ASC
   LIMIT 5;

/* 
06.	Birthdate
Write a query that returns: first_name, last_name, birthdate and review from clients. 
Filter clients which don’t have card and 
               their birthdate is between 1978 and  1993 inclusive.
Show only the first 5 results and 
order them descending by last_name, then 
                      by id ascending.
Required Columns
•	first_name
•	last_name 
•	birthdate
•	review
Example
first_name	last_name	birthdate	review
Trudie	Swayte	1979-10-14	heard about this on melodic death metal radio, decided to give it a try.
Chantal	Sor	1978-12-04	My neighbor Krista has one of these. She works as a salesman and she says it looks soapy.
Alphard	Skelly	1978-05-15	My neighbor Lori has one of these. She works as a taxidermist and she says it looks whopping.
Marya	Niessen	1989-06-09	The box this comes in is 5 light-year by 6 foot and weights 17 megaton!!!
George	Dymocke	1988-04-03	i use it barely when i'm in my store.

*/