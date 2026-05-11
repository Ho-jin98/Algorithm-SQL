-- 코드를 입력하세요
SELECT 
    MEMBER_ID,
    MEMBER_NAME, 
    GENDER, 
    DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE MONTH(DATE_OF_BIRTH) = 3 AND TLNO IS NOT NULL AND GENDER = 'W'
ORDER BY MEMBER_ID ASC;

# NULL을 처리하는 방법
# 1. IS NOT NULL -> WHERE절을 통해 사용해야함, NULL인 데이터는 아예 조회되지 않음

# 2. COALESCE(컬럼명, 대체값) -> NULL이면 대체값으로 반환해줌
# 3. IFNULL(컬럼명, 대체값) -> COALESCE와 마찬가지로, NULL이면 대체값으로 반환해줌

# COALESCE vs IFNULL

# COALESCE는 인자를 여러개 넣을 수 있음,
# ex) COALESCE(a, b, c, d) 이런식으로 인자를 여러개 받을 수 있고, 이러한 상황에서는
# 왼쪽부터 순서대로 보다가 "NULL이 아닌 값을 발견하면 즉시 반환후 종료"
# a가 NULL이 아니면 a반환, a가 NULL이고 b가 NULL이 아니면, b를 반환 ......

# IFNULL은 무조건 인자를 2개만 받을 수 있음,
# ex) IFNULL(컬럼명, 대체값) -> NULL이면 대체값을 반환