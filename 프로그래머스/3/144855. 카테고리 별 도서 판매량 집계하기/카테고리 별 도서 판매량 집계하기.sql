-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK b
JOIN BOOK_SALES AS bs ON b.BOOK_ID = bs.BOOK_ID
WHERE bs.SALES_DATE LIKE '2022-01%'
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY ASC;

# 카테고리 정보는 BOOK 테이블에만 있고, 판매량 정보는 BOOK_SALES 테이블에만 있음
# 두 테이블의 공통인 BOOK_ID를 기준으로 테이블을 합쳐야지
# 카테고리 별 판매량을 계산할 수 있음! -> JOIN을 선택