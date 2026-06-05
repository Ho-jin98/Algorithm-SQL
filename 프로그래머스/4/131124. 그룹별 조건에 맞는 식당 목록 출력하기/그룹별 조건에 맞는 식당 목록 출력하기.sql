-- 코드를 입력하세요
SELECT
    m.MEMBER_NAME,
    r.REVIEW_TEXT,
    DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE m
JOIN REST_REVIEW AS r ON m.MEMBER_ID = r.MEMBER_ID
WHERE r.MEMBER_ID = (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
ORDER BY r.REVIEW_DATE ASC, r.REVIEW_TEXT ASC;

# 보통 IN은 서브쿼리의 결과가 여러 개(Multi-row) 나올 수 있을 때 사용하고,
# = -> 은 결과가 단 하나(Single-row)만 나올 때 사용!

# 서브쿼리로 각 MEMBER_ID를 그룹화 하여 같은 MEMBER_ID끼리 뭉치고,
# 회원들이 작성한 리뷰 개수를 카운팅 해서 가장 높은 값 1개를 가져옴,
# ex)
# MEMBER_ID  REVIEW_TEXT
# A, id = 1, review = " 밥이 맛있어요"
# A, id = 1, review = " 김치찌개 최고"
# A, id = 1, review = " 된장찌개 짱"
# B, id = 2, review = " 다음에 또 올게요"
# B, id = 2, review = " 양이 어마어마 해요"
# C, id = 3, review = " 언제 먹어도 굿굿"
# 예를 들어 이런 식으로 있다고 가정했을 때,
# GROUP BY로 MEMBER_ID끼리 묶어주고, COUNT(*)로 세어보면,
# 1번(A): 리뷰 3개 담김 -> COUNT(*) = 3
# 2번(B): 리뷰 2개 담김 -> COUNT(*) = 2
# 3번(C): 리뷰 1개 담김 -> COUNT(*) = 1
# 이렇게 되고, 내림차순 정렬해서 가장 큰 값을 최상단으로 올림,
# 이 상태로 LIMIT 1 -> 가장 큰 값, 즉 가장 첫번째 행만 살리고 나머지는 전부 버림
