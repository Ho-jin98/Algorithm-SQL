-- 코드를 입력하세요
# HOUR함수는 시간을 정수(Integer)타입으로 반환함, 정수 타입은 앞에 0이 붙지 않기 때문에
# 09시가 아닌 9시로 출력이됨
# 또는 DATE_FORMAT(DATETIME, '%k') AS HOUR
# -> '%k' k포맷팅을 사용하면, 24시간 형식이지만 한 자릿수 시간 앞에 0을 붙이지 않음
SELECT HOUR(a.DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS a
WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20
GROUP BY HOUR
ORDER BY HOUR ASC;