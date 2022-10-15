### Task 10. First Letter

  SELECT  left(`first_name`, 1) AS `first_letter`	
    FROM  wizzard_deposits
   WHERE  `deposit_group` = 'Troll Chest'
GROUP BY  `first_letter`
ORDER BY  `first_letter`;
