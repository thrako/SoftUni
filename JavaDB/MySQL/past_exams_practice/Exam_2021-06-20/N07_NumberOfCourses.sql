### 07. Number of courses

  SELECT cr.`id` AS car_id, cr.`make`, cr.`mileage`, count(css.`id`) AS `count_of_courses`, round(avg(css.`bill`), 2) AS `avg_bill`
    FROM cars AS cr
           LEFT JOIN
		 courses AS css ON css.`car_id` = cr.`id`
GROUP BY cr.`id`
  HAVING `count_of_courses` <> 2
ORDER BY `count_of_courses` DESC,
         cr.`id` ASC;

/* 
7.	Number of courses for each car
Extract from the database all the cars and the count of their courses. Also display the average bill of each course by the car, rounded to the second digit.
Order the results descending by the count of courses, then by the car’s id. 
Skip the cars with exactly 2 courses.
Required Columns
•	car_id
•	make
•	mileage
•	count_of_courses
•	avg_bill
Example
car_id	make	mileage	count_of_courses	avg_bill
13	Mercedes-Benz	846549	4	26.95
80	Lincoln	711184	4	22.39
1	Land Rover	550259	3	14.71
	…	…	…	…
89	Pontiac	890015	0	NULL
90	Mercedes-Benz	6482	0	NULL
95	Land Rover	176967	0	NULL

*/