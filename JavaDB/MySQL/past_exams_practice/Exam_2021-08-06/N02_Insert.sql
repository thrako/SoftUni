### 2.	Insert

INSERT INTO games (`name`,`rating`,`budget`,`team_id`)
     SELECT reverse(lower(substring(t.`name`, 2))), t.`id`, t.`leader_id` * 1000, t.`id`
       FROM teams AS t
      WHERE t.id BETWEEN 1 AND 9;

/*
2.	Insert
The bosses urgently want to announce 9 new games and because there is no time, the developers decide not to waste time thinking about details but 
to announce something as soon as possible.
You will have to insert records of data into the games table, based on the teams table. 
For all teams with id between 1 and 9 (both inclusive), insert data in the games table with the following values:
•	name:
	o	 the name of the team but reversed
	o	 all letters must be lower case
	o	 omit the starting character of the team's name
		 Example: Team name – Thiel -> leih
•	rating – set it to be equal to the team's id
•	budget – set it to be equal to the leader's id multiplied by 1000
•	team_id – set it to be equal to the team's id

*/