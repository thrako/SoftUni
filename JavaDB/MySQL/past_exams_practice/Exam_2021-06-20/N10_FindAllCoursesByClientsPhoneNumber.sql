### 10. Find all courses by client’s phone number 

DELIMITER $$

DROP FUNCTION IF EXISTS udf_courses_by_client$$

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC
BEGIN
  RETURN (SELECT count(css.`id`) 
            FROM clients AS c
                   LEFT JOIN
				 courses AS css ON css.`client_id` = c.`id`
		   WHERE c.`phone_number` = phone_num
		GROUP BY c.`id`);
END$$

-- Query
SELECT udf_courses_by_client ('(803) 6386812') as `count`; 
-- count
-- 5

-- Query
SELECT udf_courses_by_client ('(831) 1391236') as `count`;
-- count
-- 3

-- Query
SELECT udf_courses_by_client ('(704) 2502909') as `count`;
-- count
-- 0

/* 
10.	Find all courses by client’s phone number
Create a user defined function with the name udf_courses_by_client (phone_num VARCHAR (20)) that 
receives a client’s phone number and returns the number of courses that clients have in database.

Example
Query
SELECT udf_courses_by_client ('(803) 6386812') as `count`; 
count
5

Query
SELECT udf_courses_by_client ('(831) 1391236') as `count`;
count
3

Query
SELECT udf_courses_by_client ('(704) 2502909') as `count`;
count
0

*/