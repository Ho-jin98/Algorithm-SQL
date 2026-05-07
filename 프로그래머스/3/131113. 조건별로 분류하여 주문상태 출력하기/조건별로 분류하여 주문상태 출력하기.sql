-- 코드를 입력하세요
SELECT f.ORDER_ID, f.PRODUCT_ID, f.OUT_DATE,
IF (f.OUT_DATE IS NULL, '출고미정', IF(f.OUT_DATE <= '2022-05-01', '출고완료', '출고대기')) AS 출고여부
FROM FOOD_ORDER f
ORDER BY f.ORDER_ID ASC;