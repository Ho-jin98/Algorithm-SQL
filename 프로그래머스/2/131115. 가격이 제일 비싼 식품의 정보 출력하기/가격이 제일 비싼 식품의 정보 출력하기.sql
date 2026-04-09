-- 코드를 입력하세요
SELECT f.PRODUCT_ID, f.PRODUCT_NAME, f.PRODUCT_CD, f.CATEGORY, f.PRICE
FROM FOOD_PRODUCT f
WHERE f.PRICE = (SELECT MAX(f.PRICE) FROM FOOD_PRODUCT f);

# 서브쿼리 -> 쿼리 안에 또 다른 쿼리를 넣는 것
# 1. 먼저 서브쿼리가 실행돼서 최댓값을 반환
# 2. 그 숫자랑 PRICE가 같은 행을 필터링

# 서브쿼리를 사용하는 경우
# 1. 집계값 (MAX, MIN, AVG 등)을 조건으로 쓸 때
# 2. 다른 테이블의 결과를 조건으로 쓸 때
# 3. 동적으로 계산된 값이 필요할 때

# WHERE절 뿐만 아니라, SELECT, FROM절에서도 다 쓸 수 있다.

# 주의할 점 : 서브쿼리가 두 개 이상의 행을 반환할 때는 = 대신 IN을 사용하는 것이 안전하다
-- ex)
-- 위험
# WHERE PRICE = (SELECT f.PRICE FROM FOOD_PRODUCT f)  -- 여러 행 반환시 오류

-- 안전
# WHERE PRICE IN (SELECT f.PRICE FROM FOOD_PRODUCT f)
