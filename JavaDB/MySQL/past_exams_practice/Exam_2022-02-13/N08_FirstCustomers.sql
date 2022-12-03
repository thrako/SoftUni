### 08.	First customers

  SELECT concat_ws(' ', c.`first_name`, c.`last_name`) AS `full_name`,
         `address`,
         o.`order_datetime`
    FROM customers AS c
           JOIN
		 orders AS o ON c.`id` = o.`customer_id`
   WHERE year(o.`order_datetime`) <= 2018
ORDER BY `full_name` DESC;


/*
08.	First customers
There are many customers in our shop system, but we need to find only those who are clients from the beginning of the online store creation.
Extract from the database, the full name of customer, the address, and the date of order. The year must be lower or equal to 2018.
Order the results descending by full_name.
Required Columns
•	full_name (first_name + " " + last_name)
•	address
•	order_datetime


Examples
full_name	address	order_date
Shirley Clayfield	51 East Drive	2018-02-04 20:34:33
Selene Mateo	9 Elka Point	2018-04-13 07:44:15
…	…	…
Cherilyn Bradane	323 Steensland Parkway	2018-12-03 05:19:24

*/