-- 코드를 입력하세요
SELECT 
    u.USER_ID,
    u.NICKNAME, 
    CONCAT_WS(' ', u.CITY, u.STREET_ADDRESS1, u.STREET_ADDRESS2) AS 전체주소,
    CONCAT(
        SUBSTRING(u.TLNO, 1, 3), '-',
        SUBSTRING(u.TLNO, 4, 4), '-',
        SUBSTRING(u.TLNO, 8, 4))
        AS 전화번호
FROM USED_GOODS_USER u
JOIN USED_GOODS_BOARD AS b ON u.USER_ID = b.WRITER_ID
GROUP BY u.USER_ID
HAVING COUNT(b.BOARD_ID) >= 3
ORDER BY u.USER_ID DESC;

# CONCAT -> "흩어져 있는 문자열 조각들을 하나로 강력하게 이어 붙여주는 풀(Glue)" 같은 녀석
# CONCAT 함수는 괄호 안에 넣은 인자들을 왼쪽에서 오른쪽 순서대로 그대로 이어 붙임

# ex) SELECT CONCAT('Java', ' ', 'Backend', ' ', 'Developer') AS 직무;
# -> Java Backend Developer

# CONCAT의 치명적인 약점: NULL
# CONCAT은 연결하려는 항목 중 단 하나라도 NULL이 섞여 있으면, 결과 전체를 NULL로 만들어버림!
# ex) NULL이 섞인 경우: CONCAT('서울시', ' ', NULL) -> 결과 : NULL
# 그래서 NULL 문제를 해결하기 위해 나온 업그레이드 버전이 -> CONCAT_WS()
# CONCAT_WS는 NULL을 만났을 때 NULL만 쏙 빼고 남은 데이터끼리만 연결해줌