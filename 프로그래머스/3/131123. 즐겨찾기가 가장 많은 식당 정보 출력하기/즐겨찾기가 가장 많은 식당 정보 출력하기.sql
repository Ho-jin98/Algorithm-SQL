-- 코드를 입력하세요
# SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
# FROM REST_INFO
# WHERE (FOOD_TYPE, FAVORITES) IN (
#     SELECT FOOD_TYPE, MAX(FAVORITES)
#     FROM REST_INFO
#     GROUP BY FOOD_TYPE
# )
# ORDER BY FOOD_TYPE DESC;

# 서브 쿼리 -> 쿼리 안에 쿼리,
# 전체 결과를 내기 위해 중간 단계의 데이터나 특정 기준값이 필요할 때 사용
# 이 문제에서 GROUP BY와 MAX만 쓰면 음식 종류별 1등은 나오지만, 정확하지 않을 수 있음,
# -> 엉뚱한 식당이 나올 수도 있음

# 서브쿼리로, 1등 점수 명단을 먼저 만들어 놓고,
# 그 명단에 있는 데이터만 전체 테이블에서 골라내는 방법을 사용

# 서브쿼리는 SQL문이 실행될 때 가장 먼저 실행이 됨,
# WHERE절에서 연결하여 사용,
# 다중 행 서브쿼리 -> IN, ANY, ALL 같은 연산자를 사용
# 단일 행 서브쿼리 -> >, =, < 같은 연산자 사용

# 윈도우 함수
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM (
    SELECT *, 
           # 음식 종류별로 묶기(PARTITION BY), 즐겨찾기 순으로(ORDER BY) 순위를 매김
           RANK() OVER (PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC) as ranking
    FROM REST_INFO
) f
# f -> FROM절에서 사용한 해당 서브쿼리 덩어리를 가리키는 별칭
WHERE ranking = 1 # 각 그룹에서 1등인 데이터만 선택
ORDER BY FOOD_TYPE DESC;

# RANK() 함수 -> 공동 1위가 있으면 두 식당을 모두 1위로 처리

# GROUP BY vs PARTITION BY

# GROUP BY: 데이터를 뭉쳐서 줄여버림 (10개 행 → 1개 행)
# PARTITION BY: 데이터의 모든 행을 유지하면서, 옆에 계산 결과만 슬쩍 붙여줌

# PARTITION BY FOOD_TYPE
# -> 음식 종류 (일식, 한식, 중식) 끼리 모아줌,
# 이렇게 모아놓은 그룹 안에서 ORDER BY FAVORITES DESC를 실행시킴
# 여기서 나온 등수를 rank라고 지정해 놓은 별칭에 넣어줌