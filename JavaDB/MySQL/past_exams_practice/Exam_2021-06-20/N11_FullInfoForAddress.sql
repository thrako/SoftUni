### 11. Full info for address

DELIMITER $$

DROP PROCEDURE IF EXISTS udp_courses_by_address$$

CREATE PROCEDURE udp_courses_by_address (address_name VARCHAR (100))
BEGIN
      SELECT a.`name`,	
             cl.`full_name` AS `full_names`, 
             (CASE
               WHEN css.`bill` < 20 THEN 'Low'
               WHEN css.`bill` < 30 THEN 'Medium'
               ELSE 'High'
             END) AS `level_of_bill`, 
             cr.`make`, 
             cr.`condition`, 
             ctgr.`name` AS `cat_name`
	    FROM courses AS css
               LEFT JOIN
			 addresses AS a ON a.`id` = css.`from_address_id`
               JOIN
			 cars AS cr ON cr.`id` = css.`car_id`
               JOIN
             categories AS ctgr ON ctgr.`id` = cr.`category_id`
               JOIN
             clients AS cl ON cl.`id` = css.`client_id`
	   WHERE a.`name` = address_name
    ORDER BY cr.`make`,
             cl.`full_name`; 
END$$

-- Query
CALL udp_courses_by_address('700 Monterey Avenue');

-- Result
-- name						full_names			level_of_bill	make			condition	cat_name
-- 700 	Monterey Avenue		Kelcy Cody			Medium			Acura			B			Hatchback
-- 700 	Monterey Avenue		Zeke Rowston		Medium			GMC				A			Coupe
-- 700 	Monterey Avenue		Joyann Garrettson	High			Lamborghini		A			SUV
-- 700 	Monterey Avenue		Courtney Gawkes		Low				Mercedes-Benz	B			Cabrio
-- 700 	Monterey Avenue		Jeralee Tue			Low				Mercedes-Benz	B			Cabrio
-- 700 	Monterey Avenue		Haven Seaton		High			Mitsubishi		B			Hatchback


-- Query
CALL udp_courses_by_address('66 Thompson Drive');

-- Result
-- name					full_names		level_of_bill	make		condition	cat_name
-- 66 Thompson Drive	Kimball Deem	High			Pontiac		C			Hatchback
-- 66 Thompson Drive	Kaylee Coushe	High			Porsche		B			Coupe
-- 66 Thompson Drive	Gibbie Liggens	High			Volkswagen	A			Coupe

/* 
11.	Full info for address
Create a stored procedure udp_courses_by_address which accepts the following parameters:
•	address_name (with max length 100)

Extract data about the addresses with the given address_name. 
The needed data is:
 the name of the address, 
 full name of the client, 
 level of bill (depends of course bill – Low – lower than 20(inclusive), 
                                         Medium – lower than 30(inclusive), and 
                                         High), 
 make and 
 condition of the car and 
 the name of the category.
 
 Order addresses by make, then by client’s full name.

Required Columns
•	name (address)
•	full_name
•	level_of_bill
•	full_name (client)
•	make
•	condition
•	cat_name (category)

*/