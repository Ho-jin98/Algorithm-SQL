-- 코드를 입력하세요
SELECT us.USER_ID, us.NICKNAME, SUM(bo.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER us
JOIN USED_GOODS_BOARD AS bo ON us.USER_ID = bo.WRITER_ID
WHERE bo.STATUS = 'DONE'
GROUP BY us.USER_ID, us.NICKNAME
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES ASC;

# FROM / JOIN: 테이블을 가져와서 합친다.
# WHERE: 조건에 맞는 행만 골라낸다. (이 시점엔 아직 SUM 계산이 안 됨)
# GROUP BY: 데이터를 그룹으로 묶는다.
# HAVING: 그룹화된 결과 중에서 조건에 맞는 것만 남긴다. (여기서 TOTAL_SALES 체크 가능!)
# SELECT: 보여줄 컬럼을 선택한다.
# ORDER BY: 정렬한다.

# WHERE vs HAVING
# -> WHERE는 그룹화하기 전에 데이터를 걸러내는 역할을 함, SUM이나 AVG처럼 계산된 결과값(집계 결과)에 조건을 걸 때는 반드시 HAVING 절을 사용해야 한다!