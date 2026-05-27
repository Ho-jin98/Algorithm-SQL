-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID
HAVING COUNT(DISTINCT NAME) = 2
ORDER BY CART_ID;

# WHERE에서 IN으로 우유와 요거트를 묶어줌
# GROUP BY를 쓰는 순간, 테이블은 더 이상 한 줄 한 줄 짜리 데이터가 아니고, 지정된 컬럼을 기준으로 데이터들이 하나의 그룹(박스) 안에 뭉텅이로 들어간 상태가 되는데, SELECT절은 박스 겉면에 있는 이름표나, 박스 안에 들어있는 값들을 통으로 계산한 통계치만 볼 수 있음, 박스 안에 들어있는 값들을 하나하나 가리킬 수는 없음

# ex) SELECT CART_ID, NAME
#     GROUP BY CART_ID
# NAME 안에 여러개의 값들이 묶여있을 때 이렇게 하면 컴퓨터가 어떤것을 꺼내와야 하는지 제대로 판단을 못함

# GROUP BY를 안전하게 사용하는 규칙
# 1. GROUP BY 뒤에 적어둔 기준 컬럼만 SELECT에 명시하기
# ex) SELECT CART_ID
#     GROUP BY CART_ID

# 2. 여러개의 값을 하나로 뭉쳐주는 집계함수
# ex) COUNT(NAME), SUM(PRICE), MAX(PRICE)

# 잘못된 예시: 컴퓨터가 에러를 내거나 멍청해지는 쿼리
# SELECT CART_ID, NAME, PRICE   -- NAME과 PRICE는 박스 안에 여러 개라 결정 불가
# FROM CART_PRODUCTS
# GROUP BY CART_ID;

# 올바른 예시: 컴퓨터가 명확하게 이해하는 쿼리
# SELECT CART_ID, COUNT(NAME), SUM(PRICE) -- 이름표와 집계 함수로만 구성
# FROM CART_PRODUCTS
# GROUP BY CART_ID;