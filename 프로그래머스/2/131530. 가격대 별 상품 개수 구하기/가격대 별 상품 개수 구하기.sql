-- 코드를 입력하세요
SELECT
    FLOOR(PRICE / 10000) * 10000 AS PRICE_GROUP,
    COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP ASC;

# FLOOR -> 내림함수, 숫자의 소수점 이하를 잘라버리고, 그 숫자보다 작거나 같은 가장 큰 정수를 반환,

# (PRICE / 10000) * 10000
# -> "10,000원 단위의 가격대"를 만드는 것이 목적,
# 15,000원도 10,000원대로, 29,900원도 20,000원대로 묶어야 함!
# FLOOR로 소수점을 버리고, 순수 숫자만 남긴 다음 10000을 곱해주면 10000원대의 결과나 나옴

# ex) PRICE를 10000으로 나눈 결과가 예를들어 1.567로 나왔다고 가정하면,
# FLOOR(1.567) -> 1이라는 결과나 나오고, 여기에 10000을 곱해주므로, 10000원대의 결과가 나오는 원리