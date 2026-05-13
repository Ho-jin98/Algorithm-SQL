-- 코드를 입력하세요
# SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
# FROM FOOD_PRODUCT
# WHERE (CATEGORY, PRICE) IN (
#     SELECT CATEGORY, MAX(PRICE)
#     FROM FOOD_PRODUCT
#     WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
#     GROUP BY CATEGORY
# )
# ORDER BY PRICE DESC;

# IN() -> OR연산자를 사용하는 것과 같으며, 여러 값 중 하나라도 일치하면 가져온다.

# 서브쿼리로 먼저 가져오는 이유,
# 문제에서 '식품 분류별로 가격이 제일 비싼' + '해당 가격의 상품 이름' 이 두가지 데이터를 모두 조회하기를 원하고 있음, GROUP BY를 사용하여 MAX(PRICE)를 구하면 각 카테고리별로 가장 높은 '가격'은 정확히 찾아낼 순 있지만 PRODUCT_NAME은 그 최고가에 해당하는 상품이 아니라, 해당 그룹 내의 임의의 상품명을 가져오는 경우가 많음 -> 엉뚱한 상품을 가져올 수 있다!

# 서브쿼리를 통해, 식품 분류별로 가장 비싼 가격을 먼저 가져오고, 메인 쿼리를 실행


# 윈도우 함수
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM (
    SELECT CATEGORY, PRICE, PRODUCT_NAME,
    # PARTITION BY -> 데이터를 자동으로 그룹화해줌,
    # PARTITION BY CATEGORY -> 식품 분류별로 그룹화
    # ORDER BY PRICE -> 그 그룹 안에서 가격이 높은 순서대로
    RANK() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS rk
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
) AS FOOD_PRICE_RANK
# 가장 비싼 상품 1위
WHERE rk = 1
ORDER BY MAX_PRICE DESC;

# RANK() -> 공동 1위가 있으면 둘 다 1위로 표시하고 출력해줌
# 만약, TOP3를 뽑고 싶다 -> WHERE rk <= 3 으로 바꾸면 된다.
