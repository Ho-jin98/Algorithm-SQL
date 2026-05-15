-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;

# HAVING -> GROUP BY로 그룹화된 데이터에서 필터링 한다고 생각하면 됨,
# WHERE는 전체 데이터에서 조건을 거는 것,

# USER_ID와 PRODUCT_ID를 한 쌍으로 묶고, 이 쌍 중에서 COUNT로 데이터 개수를 세어봄,
# HAVING COUNT(*) > 1 -> 그룹화된 데이터에서 1보다 크다 -> 2번 이상 구매 -> 재구매 데이터

# 그러면 GROUP BY로 USER_ID와 PRODUCT_ID를 묶어줬는데, 왜 COUNT쿼리는 PRODUCT_ID만 카운팅 하는 것 처럼 보일까? -> GROUP BY의 동작 과정을 이해해보자,

# USER_ID와 PRODUCT_ID를 GROUP BY로 묶으면, 두 컬럼의 값이 모두 일치하는 값들을 하나의 그룹으로 묶음

# ex)
# SALES_DATE	USER_ID	PRODUCT_ID
# 2026-01-01	   1	    10
# 2026-01-05       1	    10
# 2026-01-10	   1	    20

# 이러한 테이블을 GROUP BY로 묶으면,
# A: (USER_ID: 1, PRODUCT_ID: 10) 인 데이터들이 모임 -> 2건 있음
# B: (USER_ID: 1, PRODUCT_ID: 20) 인 데이터들이 모임 -> 1건 있음
# 이런식으로 묶이고, COUNT(*)가 이 안에 있는 데이터들의 행이 몇 줄인지 카운트함,
# A를 열어보니 2줄이 들어있네? -> COUNT 결과는 2
# B를 열어보니 1줄이 들어있네? -> COUNT 결과는 1
# 즉, COUNT가 특정 컬럼 하나만 세는 게 아니라, "유저1이 상품10을 산 행이 총 몇 개인가"를 세는 것!
