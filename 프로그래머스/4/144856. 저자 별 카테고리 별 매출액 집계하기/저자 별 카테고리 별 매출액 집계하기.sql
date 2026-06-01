-- 코드를 입력하세요
SELECT
    b.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    SUM(bs.TOTAL_BOOK_SALES * b.PRICE) AS TOTAL_SALES
FROM BOOK b
JOIN AUTHOR AS a ON b.AUTHOR_ID = a.AUTHOR_ID
JOIN(
    SELECT
    BOOK_ID,
    SUM(SALES) AS TOTAL_BOOK_SALES
    FROM BOOK_SALES
    WHERE SALES_DATE LIKE '2022-01%'
    GROUP BY BOOK_ID
) AS bs ON bs.BOOK_ID = b.BOOK_ID
GROUP BY b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
ORDER BY b.AUTHOR_ID ASC, b.CATEGORY DESC;


# FROM절 서브쿼리를 통해 BOOK_SALES 테이블에서 총 판매량을 먼저 조회해옴,
# 메인쿼리에서는 서브쿼리로 먼저 조회해오는 BOOK_SALES의 총 판매량 (TOTAL_BOOK_SALES)을
# BOOK 테이블의 PRICE와 SUM함수로 총 매출액을 조회

# 주의사항
# 메인쿼리에서 GROUP BY는 SELECT절과 컬럼 일치하는지 확인하기
# 서브쿼리에서 SELECT절에는 총 컬럼이 2개지만, GROUP BY에서 BOOK_ID만 묶은 이유는,
# GROUP BY는 SUM함수 같은 집계함수에 감싸여져 있지 않은 '순수 컬럼'은 반드시 GROUP BY에 명시해줘야 하기 때문이다.
