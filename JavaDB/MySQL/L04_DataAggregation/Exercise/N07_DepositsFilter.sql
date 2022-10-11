### Task 07. Deposits Filter 

SELECT `deposit_group`, sum(`deposit_amount`) AS `total_sum`
FROM wizzard_deposits
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;
