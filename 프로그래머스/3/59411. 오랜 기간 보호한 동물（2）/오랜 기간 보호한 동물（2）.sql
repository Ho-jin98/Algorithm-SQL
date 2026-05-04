-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_INS a
JOIN ANIMAL_OUTS AS o ON a.ANIMAL_ID = o.ANIMAL_ID
ORDER BY o.DATETIME - a.DATETIME DESC
LIMIT 2;

# o.DATETIME -> 입양일,
# a.DATETIME -> 보호 시작일,
# 입양일 - 보호시작일 = 보호기간
# -> 내림차순 정렬하고 2개 짜르면 맨 위 2개가 보호기간이 가장 긴 녀석들