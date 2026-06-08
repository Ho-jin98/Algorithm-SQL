-- 코드를 입력하세요
SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE '2022-03%'

UNION ALL

SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    NULL AS USER_ID,
    SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE '2022-03%'
# 합친 테이블을 기준으로 정렬
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;

# UNION ALL -> SQL에서 여러 개의 SELECT 문 결과를 위아래로 하나로 합쳐주는 연산자
# JOIN이 두 테이블을 옆으로(좌우로) 결합하는 것이라면, UNION ALL은 두 테이블의 데이터를 아래로(위아래로) 박스 쌓듯이 이어 붙이는 것

# UNION ALL을 사용할 때 반드시 지켜야 하는 규칙 2가지
# 1. 컬럼의 개수가 같아야 한다.
#    만약, 첫 번째 SELECT에서 컬럼을 4개 조회했다면,
#    두 번째 SELECT에서도 반드시 4개를 조회해야 한다.

# 2. 대응되는 컬럼의 데이터 타입이 호환되어야 한다.
#    첫 번째 컬럼이 '날짜'라면 합쳐지는 테이블의 첫 번째 컬럼도 '날짜'나 문자열이어야 한다.
#    (숫자와 문자를 같은 컬럼에 합칠 수 없음)

# NULL AS USER_ID -> UNION을 하려면 위 아래 쿼리문의 컬럼 개수가 같아야 하고,
# 문제에서 OFFLINE_SALE의 USER_ID는 NULL이라 했으므로,
# 컬럼 개수를 맞춰주기 위해 NULL값을 넣고, 이것을 USER_ID로 별칭을 지정해준다.

# ALL이 붙지 않은 UNION,
# UNION ALL vs UNION -> 이 둘의 차이점은 "중복된 데이터를 어떻게 처리하느냐"
#       연산자                 중복 제거 여부                    특징 및 성능
#     UNION ALL       중복 허용 (있는 그대로 다 합침)     중복을 검사하지 않고 단순히 결과만
#                                                     붙이기 때문에 속도가 매우 빠름

#       UNION                 중복을 제거함             내부적으로 두 결과를 합친 뒤
#                         (공통된 행은 1개만 남김)       중복을 정렬하고 제거하는 과정이 들어가므로
#                                                     속도가 상대적으로 느림.

# 매출 데이터처럼 온라인과 오프라인에서 똑같은 금액, 똑같은 상품이 팔렸어도
# 둘 다 유효한 데이터이므로 중복을 제거하면 안 됨 -> UNION ALL 사용




                    