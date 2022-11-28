### 8. Games of 2022

    SELECT g.`name`, 
           g.`release_date`, 
           concat(left(g.description, 10), '...') AS `summary`, 
           (CASE 
               WHEN month(g.release_date) <= 3 THEN 'Q1'
               WHEN month(g.release_date) <= 6 THEN 'Q2'
               WHEN month(g.release_date) <= 9 THEN 'Q3'
               WHEN month(g.release_date) <= 12 THEN 'Q4'
           END) AS `quarter`, 
           t.`name` AS `team_name`
      FROM games AS g
             JOIN
           teams AS t ON g.`team_id` = t.`id`
	 WHERE year(g.`release_date`) = 2022 AND
           month(g.`release_date`) % 2 = 0 AND
           right(g.`name`, 1) = '2'
  ORDER BY `quarter`;  
           
/* 
8.	Games of 2022
Now, we need to find all interesting upcoming games.
# Extract from the database all games that are being released in the year 2022. 
# Also, the month must be even. 
#We need only the first game sequel (ends with '…2'). 
We need the information of the game name, the game release date, a short summary (only the first 10 characters + '…') and the name of the team.
At last, a column ‘Quarters’ depends on the month of the release date:
•	January, February, and March (Q1)
•	April, May, and June (Q2)
•	July, August, and September (Q3)
•	October, November, and December (Q4)

Order by Quarters.

Required Columns
•	name (of the game)
o	 only the first sequel
	 Ends with '...2'
	 Voyatouch 2 -> Valid
	 Voyatouch 3 -> Invalid
•	release_date
o	 only even months
•	summary
o	 the first 10 characters + '...'
•	quarter
o	 Depends on the month
•	team_name (name of the team)

Example
name	release_date	summary	quarter	team_name
Y-Solowarm 2	2022-02-28	In hac hab...	Q1	Jenkins-Kiehn
Mat Lam Tam 2	2022-08-21	Proin leo ...	Q3	Roob, Mann and Goldner
Voyatouch 2	2022-12-26	In sagitti...	Q4	Weissnat-Wolf

*/