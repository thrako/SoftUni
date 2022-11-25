### 04. Delete

DELETE 
  FROM clients
 WHERE `id` NOT IN (SELECT DISTINCT `client_id` FROM courses) AND
       char_length(`full_name`) > 3 AND
       `id` > 0; 

/* 
4.	Delete
Some of the clients have not used the services of our company recently, so we need to remove them 
from the database.	
Delete all clients from clients table, that do not have any courses and the count of the characters in the full_name is more than 3 characters. 



*/