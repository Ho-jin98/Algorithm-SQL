-- 코드를 입력하세요
SELECT
    BOARD_ID, 
    WRITER_ID, 
    TITLE, 
    PRICE,
    CASE
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        WHEN STATUS = 'DONE' THEN '거래완료'
    END AS STATUS_AL
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC;

# SQL에서 CASE문
# 특정 컬럼 안에 들어있는 값(데이터)들을 조건에 따라 각각 다른 별칭(원하는 문자열)으로 변경해서 출력하고 싶을 때는 CASE 문을 사용!

# 기본 구조
# SELECT 
#    CASE 
#        WHEN 조건1 THEN '별칭1'
#        WHEN 조건2 THEN '별칭2'
#        ELSE '기본별칭'
#    END AS 컬럼의_새로운_이름
# FROM 테이블명;

# CASE로 시작해서 END로 끝나며, WHEN 뒤에 조건을 적고 THEN 뒤에 바꿀 별칭을 적어줌.어떤 조건에도 해당하지 않을 때의 값은 ELSE 뒤에 적어 줌