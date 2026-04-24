-- 코드를 입력하세요
SELECT MCDP_CD AS "진료과코드", COUNT(APNT_YMD) AS "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD LIKE '2022-05%'
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, MCDP_CD ASC;

# 다중 정렬의 작동 원리

# ORDER BY A, B 형식으로 쿼리를 작성하면 다음과 같은 순서로 정렬함,
#
# - 제1순위 (A): 먼저 첫 번째 컬럼(5월예약건수)을 기준으로 전체 데이터를 정렬,
#
# - 제2순위 (B): 첫 번째 기준으로 정렬했을 때 값이 똑같은 데이터들끼리만 모아서,
#   그 안에서 두 번째 기준(MCDP_CD)으로 다시 정렬