-- 코드를 입력하세요
SELECT CAR_ID,
    MAX(CASE
        WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE THEN '대여중'
        ELSE '대여 가능'
    END) AS AVAILABILITY  
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

# WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE
# -> START_DATE와 END_DATE 사이에 2022-10-16이 들어있는지 확인
# 들어있다(true) -> '대여중'으로 바꾸고, 없다면(false) -> '대여 가능'으로 바꿔라

# 여기서 만약, 하나의 CAR_ID에 여러개의 대여 기록이 존재할 경우, '대여 가능'과 '대여중'이
# 따로따로 출력되거나, 여러줄이 출력되면서 에러가 발생할 수 있음
# 이것을 GROUP BY로 CAR_ID를 묶어주고, MAX()함수를 활용하여, 사전순서상 뒤에나오는 글자를 선택
# ex) '대여 가능' < '대여중' 사전 순서상, '대여중'이 뒤쪽임
# 2022-10-16일 기록이 여러개 섞여있다면, '대여중'을 채택