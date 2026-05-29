-- 코드를 입력하세요
SELECT f.FLAVOR
FROM FIRST_HALF f
JOIN(
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS JULY_TOTAL
    FROM JULY
    GROUP BY FLAVOR
) AS j ON f.FLAVOR = j.FLAVOR
ORDER BY (f.TOTAL_ORDER + j.JULY_TOTAL) DESC
LIMIT 3;

# 서브쿼리 WHERE vs JOIN

# WHERE절 서브쿼리 -> 쉽게 말해 "조건 검사기",
# 메인 테이블에서 데이터를 한 줄씩 읽으면서 "너 이 조건 만족해?"라고 물어보는 역할
# 특징: 메인 테이블의 모양(열 개수)은 그대로 유지되면서, 행(줄)만 걸러짐,
# 한계: 서브쿼리 안에서 계산한 값(SUM, AVG 등)을 메인 쿼리로 가져와서 더하거나 출력할 수 없음.
#      딱 '조건 검사'용으로만 쓰고 버려짐

# JOIN 서브쿼리 -> JOIN에서 서브쿼리는 "원래 없던 새로운 테이블을 내가 즉석에서 하나 만들어내는 것"이라고 볼 수 있다. 데이터베이스 용어로는 이를 인라인 뷰(Inline View)라고 부름
# JOIN에서 서브쿼리를 사용하면, 컴퓨터가 이 서브쿼리를 만나는 순간, 메모리에 지정해놓은 별칭 이름의 임시 테이블을 진짜로 하나 만들어 버림

# 그렇다면 이번 문제에서 왜 JOIN에서 서브쿼리를 사용해야할까?
# WHERE 절 서브쿼리로는 "7월 총주문량과 상반기 주문량을 더하는 연산"을 할 수 없기 때문!
# JOIN에서 사용하면, [상반기 주문량] [7월 주문량 합계]가 한 줄에 모이게 됨
# 그래서 메인 쿼리에서 (f.TOTAL_ORDER + j.JULY_TOTAL) 처럼 두 열을 더하는 계산도 할 수 있고,
# 그걸로 정렬(ORDER BY)도 할 수 있음!

