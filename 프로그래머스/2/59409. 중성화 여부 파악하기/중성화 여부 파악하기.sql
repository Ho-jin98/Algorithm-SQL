-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME, 
IF(a.SEX_UPON_INTAKE IN('Neutered Male','Spayed Female'), 'O', 'X' ) AS '중성화'
FROM ANIMAL_INS a
ORDER BY a.ANIMAL_ID ASC;