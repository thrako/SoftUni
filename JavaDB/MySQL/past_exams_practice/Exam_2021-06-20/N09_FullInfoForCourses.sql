### 09. Full info for courses 

  SELECT a.`name`,
         (CASE 
           WHEN hour(css.start) BETWEEN 6 AND 20 THEN 'Day'
           ELSE 'Night'
         END) AS `day_time`,
         css.`bill`,
         cl.`full_name`,
         cr.`make`,
         cr.`model`,
         ctgr.`name` AS `category_name`
    FROM courses AS css
           LEFT JOIN
		 addresses AS a ON a.`id` = css.`from_address_id`
           JOIN
		 cars AS cr ON cr.`id` = css.`car_id`
           JOIN
         categories AS ctgr ON ctgr.`id` = cr.`category_id` 
           JOIN
         clients AS cl ON cl.`id` = css.`client_id`
ORDER BY css.`id`;

/* 
9.	Full information of courses

The headquarters want us to make a query that shows the complete information about all courses in the database. 
The information that they need is the address, 
if the course is made in the Day (between 6 and 20(inclusive both)) or in the Night (between 21 and 5(inclusive both)), 
the bill of the course, 
the full name of the client, 
the car maker, 
the model and 
the name of the category.
Order the results by course id.

Required Columns
•	name (address)
•	day_time
•	bill
•	full_name (client)
•	make
•	model
•	category_name (category)
Example
name					day_time	bill	full_name			make		model		category_name
2 Del Mar Park			Night		46.92	Randie Cridge		Mitsubishi	Galant		Hatchback
24402 Warner Place		Day			14.47	Henrik Sivyer		Lincoln		MKT			Hatchback
80678 Green Ridge Court	Day			44.01	Randie Cridge		Isuzu		Rodeo Sport	Cabrio
…									…		…					…			…			…
34 Briar Crest Crossing	Night		14.86	Georges Lanston		Isuzu		Rodeo Sport	Cabrio
86462 Buena Vista Point	Day			16.06	Jefferson Montacute	Buick		Hearse		Coupe

*/