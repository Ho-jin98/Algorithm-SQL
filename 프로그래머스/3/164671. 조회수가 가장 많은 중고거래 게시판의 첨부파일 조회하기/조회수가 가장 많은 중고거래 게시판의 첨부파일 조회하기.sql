-- 코드를 입력하세요
SELECT CONCAT_WS(
    '/',
    '/home/grep/src',
    f.BOARD_ID,
    CONCAT(f.FILE_ID, f.FILE_NAME, f.FILE_EXT)
) AS FILE_PATH
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_FILE AS f ON b.BOARD_ID = f.BOARD_ID
WHERE b.VIEWS IN (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD 
)
ORDER BY f.FILE_ID DESC;

# CONCAT_WS -> WS(With Separator), 즉 '구분자'를 사이에 두고 컬럼들을 이어붙여주는 함수, NULL을 자동으로 걸러줌
# ex) CONCAT_WS(' ', HOUR, '시', MINUTES, '분'); -> 3 시 30 분 (사이 사이 공백이 다 들어감)
#              (' ' -> 띄어쓰기)
# CONCAT -> 마찬가지로, 지정한 컬럼들을 이어 붙여줌, 하지만 NULL을 자동으로 걸러주지 못하기 때문에,
# IFNULL(컬럼, '') 이나 COALESCE(컬럼, '') 같은 함수로 NULL을 빈 문자열('')로 변환한 뒤에 CONCAT으로 묶어주는 게 안전함
