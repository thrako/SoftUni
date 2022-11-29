### 03. Update

UPDATE cars
   SET `condition` = 'C'
 WHERE (`mileage` > 800000 OR `mileage` IS NULL) AND 
       NOT make = 'Mercedes-Benz' AND
       `id` > 0; 

/* 
3.	Update
After many kilometers and over the years, the condition of cars is expected to deteriorate.
Update all cars and set the condition to be 'C'. 
The cars  must have a mileage greater than 800000 (inclusive) or NULL and must be older than 2010(inclusive).
Skip the cars that contain a make value of Mercedes-Benz. They can work for many more years.


*/