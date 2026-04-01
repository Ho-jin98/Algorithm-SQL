-- 코드를 입력하세요
SELECT a.ANIMAL_TYPE, COALESCE(a.NAME, 'No name') as name, a.SEX_UPON_INTAKE
FROM ANIMAL_INS a
ORDER BY a.ANIMAL_ID asc;

# COALESCE(컬럼, 대체값) -> 지정한 컬럼이 Null값일 때, 대체값으로 이름을 바꿔줌
# 단, Null일 때만 대체값으로 바꿔주고, Null이 아닐 때는 원래값 그대로
