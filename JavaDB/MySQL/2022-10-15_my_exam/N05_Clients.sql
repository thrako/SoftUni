### 05.	Clients

  SELECT `id`, `first_name`, `last_name`, `birthdate`, `card`, `review`
    FROM clients
ORDER BY `birthdate` DESC,
		 `id` DESC;

/* 
05.	Clients
Extract from the restaurant_db system database, info about the clients.
Order the results by birthdate in descending order and id in descending;
Required Columns
•	id (clients)
•	first_name
•	last_name
•	birthdate
•	card
•	review
Example
id	first_name	last_name		birthdate	card	review
88	Eal			Scorey			2000-10-29	maestro	I tried to shatter it but got potato all over it.
57	Jedidiah	Thunnercliffe	1999-09-26	NULL	I saw one of these in Bhutan and I bought one.
93	Debi		De Souza		1999-04-29	visa	NULL
31	Joye		Beveridge		1999-04-29	maestro	I tried to pepper it but got prune all over it.
...	...	...	...	...	...

*/