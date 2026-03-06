-- 코드를 입력하세요
SELECT a.animal_id, a.name
FROM ANIMAL_INS a
WHERE a.name LIKE "%el%" AND a.animal_type = "Dog"
ORDER BY a.name ASC