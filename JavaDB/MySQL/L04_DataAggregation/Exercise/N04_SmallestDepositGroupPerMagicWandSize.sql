### Task 04. Smallest Deposit Group per Magic Wand Size

SELECT `deposit_group`
FROM wizzard_deposits
GROUP BY `deposit_group`
ORDER BY avg(`magic_wand_size`)
LIMIT 1;
