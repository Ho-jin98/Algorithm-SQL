-- 코드를 입력하세요
SELECT 
    i.REST_ID, 
    i.REST_NAME,
    i.FOOD_TYPE,
    i.FAVORITES,
    i.ADDRESS,
    ROUND(AVG(r.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO i
JOIN REST_REVIEW AS r ON i.REST_ID = r.REST_ID
WHERE i.ADDRESS LIKE '서울%'
GROUP BY i.REST_ID, i.REST_NAME, i.FAVORITES, i.ADDRESS
ORDER BY SCORE DESC, i.FAVORITES DESC;

# 집계함수 AVG를 사용하기 위해 GROUP BY를 사용하여 "식당 별로 그룹을 묶어주고" 평균을 내야 함!

# AVG(SCORE) -> SCORE의 평균을 구하는 함수,
# ROUND(a, 2) -> a를 소수점 3번째 자리에서 반올림 해라