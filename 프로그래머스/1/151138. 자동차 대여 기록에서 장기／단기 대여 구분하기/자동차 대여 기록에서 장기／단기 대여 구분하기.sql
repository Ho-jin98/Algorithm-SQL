-- 코드를 입력하세요
SELECT 
    HISTORY_ID, 
    CAR_ID,
    DATE_FORMAT(START_DATE, "%Y-%m-%d") AS START_DATE,
    DATE_FORMAT(END_DATE, "%Y-%m-%d") AS END_DATE,
    CASE
        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
        ELSE '단기 대여'
    END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE "2022-09%"
ORDER BY HISTORY_ID DESC;

# DATEDIFF(END_DATE, START_DATE) -> 실제 자동차를 대여한 총 일수가 30일 이상인지 확인하는 식
# 두 날짜 사이의 단순 차이를 구해주는 역할
# 계산 방식 -> 종료일 - 시작일을 계산

# DATEDIFF(END_DATE, START_DATE) + 1 >= 30
# + 1을 더해주는 이유는 SQL 날짜 함수는 당일 대여를 0으로 계산하기 때문이다.
# 대여 시작일 당일(첫째 날)을 대여 기간에 포함시키기 위해 무조건 + 1을 해주는 것!

# >= 30 -> 위에서 계산한 실제 대여 일수가 30일 이상(장기 대여)인지 비교하는 조건