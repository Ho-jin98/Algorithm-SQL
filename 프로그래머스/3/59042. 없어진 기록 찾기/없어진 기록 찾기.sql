-- 코드를 입력하세요
# 유실된 데이터까지 다 들어있는 OUTS 테이블을 기준으로 조회,
# INS 테이블에는 ID,NAME이 이미 유실되어 있는 상태임, 조회해도 의미 X
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_OUTS outs
# INNER JOIN -> 공통된 부분만 모두 가져와라
# LEFT JOIN -> 왼쪽 테이블에 있는 데이터를 모두 가져와라
# 왼쪽의 기준 -> FROM절에 명시되는 테이블이 왼쪽(left)
# 오른쪽의 기존 -> JOIN 옆에 명시되는 테이블이 오른쪽(right)
LEFT JOIN ANIMAL_INS AS ins ON outs.ANIMAL_ID = ins.ANIMAL_ID
WHERE ins.ANIMAL_ID IS NULL
ORDER BY outs.ANIMAL_ID;
# 한마디로, 현재 유실된 데이터가 없이 모든 데이터가 들어있는 테이블은 OUTS 테이블,
# FROM절에 OUTS 테이블을 명시해서 OUTS를 기준으로 데이터를 조회하고,
# LEFT JOIN의 대상도 유실된 데이터가 없는 OUTS 테이블로 잡아야됨