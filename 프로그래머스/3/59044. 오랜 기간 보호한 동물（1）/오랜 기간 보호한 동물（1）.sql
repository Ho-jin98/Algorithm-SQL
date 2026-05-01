-- 코드를 입력하세요
SELECT i.NAME, i.DATETIME
FROM ANIMAL_INS i
LEFT JOIN ANIMAL_OUTS AS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.ANIMAL_ID IS NULL
ORDER BY i.DATETIME ASC
LIMIT 3;

# LEFT JOIN의 원리
# ANIMAL_INS 테이블의 아이디가 ANIMAL_OUTS 테이블에 없으면,
# 조인 결과에서 o.ANIMAL_ID 값은 빈칸(NULL)으로 채워짐

# WHERE o.ANIMAL_ID IS NULL이라고 명시해야 "입양 기록이 없는 동물"만 정확히 골라낼 수 있음

# JOIN과 LEFT JOIN의 차이
# JOIN -> INNER JOIN -> 두 테이블 모두 데이터가 존재하는 경우 (교집합),
# 한쪽이라도 정보가 없으면 결과에서 빠짐, 두 테이블에 공통된 데이터가 확실히 있을 때 사용

# LEFT JOIN -> 왼쪽 테이블은 다 보여주고, 오른쪽 테이블은 있는 것만!
# 왼쪽 테이블(A)의 모든 데이터를 일단 다 가져오고,
# 오른쪽 테이블(B)에 일치하는 정보가 있으면 붙이고 없으면 NULL로 표시
# 없는 데이터를 찾을 때 필수!