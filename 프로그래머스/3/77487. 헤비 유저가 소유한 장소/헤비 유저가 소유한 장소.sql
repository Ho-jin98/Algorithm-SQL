-- 코드를 입력하세요
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >= 2
)
ORDER BY ID;

# 서브쿼리 사용 시 주의사항
# 1. WHERE에 사용한 IN 연산자와 서브쿼리 SELECT의 컬럼 갯수를 일치시켜야 한다,
# ex) WHERE ID IN (SELECT ID) -> 이런식으로 동일해야 함

# HAVING 사용할 때는 꼭 GROUP BY로 먼저 묶어줘야함
# WHERE -> 기존 테이블들에서 조건을 정의함
# HAVING -> GROUP BY로 묶은 컬럼들에서 조건을 정의함

# 서브 쿼리에서 COUNT함수로 HOST_ID가 2 이상인 녀석들을 먼저 찾아오기 때문에,
# 메인 쿼리에서 COUNT를 다시 쓸 필요가 없음