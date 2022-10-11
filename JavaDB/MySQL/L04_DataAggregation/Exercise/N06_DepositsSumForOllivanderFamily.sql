### Task 06. Deposits Sum for Ollivander Family 

SELECT `deposit_group`, sum(`deposit_amount`) AS `total_sum`
FROM wizzard_deposits
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;
