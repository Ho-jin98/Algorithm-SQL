-- 코드를 입력하세요
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
)
ORDER BY PRICE DESC;

# IN() -> OR연산자를 사용하는 것과 같으며, 여러 값 중 하나라도 일치하면 가져온다.

# 서브쿼리로 먼저 가져오는 이유,
# 문제에서 '식품 분류별로 가격이 제일 비싼' + '해당 가격의 상품 이름' 이 두가지 데이터를 모두 조회하기를 원하고 있음, GROUP BY를 사용하여 MAX(PRICE)를 구하면 각 카테고리별로 가장 높은 '가격'은 정확히 찾아낼 순 있지만 PRODUCT_NAME은 그 최고가에 해당하는 상품이 아니라, 해당 그룹 내의 임의의 상품명을 가져오는 경우가 많음 -> 엉뚱한 상품을 가져올 수 있다!

# 서브쿼리를 통해, 식품 분류별로 가장 비싼 가격을 먼저 가져오고, 메인 쿼리를 실행 