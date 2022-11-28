### 5.	Employees

    SELECT `first_name`, `last_name`, `age`, `salary`, `happiness_level`
      FROM employees
  ORDER BY `salary` ASC,
		   `id` ASC;


/*
5.	Employees
Extract from the SoftUni Game Dev Branch (sgd) database, info about all the employees. 
Order the results by the employee's salary, then by their id.
Required Columns
•	first_name
•	last_name
•	age
•	salary	
•	happiness_level
Example
first_name	last_name	age	salary	happiness_level
Bondon	Toquet	20	1289.90	H
Eldon	Dot	46	1321.13	N
Garrett	Jocelyn	30	1378.71	L
…	…	…	…	…
Baron	Sange	20	8866.37	H
Roley	Robertz	45	8987.87	L
*/