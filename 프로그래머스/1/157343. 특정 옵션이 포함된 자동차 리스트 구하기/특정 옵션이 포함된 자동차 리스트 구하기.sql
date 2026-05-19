-- 코드를 입력하세요
SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
FROM CAR_RENTAL_COMPANY_CAR
WHERE INSTR(OPTIONS, '네비게이션') > 0
# WHERE OPTIONS LIKE '%네이게이션%'
ORDER BY CAR_ID DESC;

# INSTR() -> 문자열 안에서 특정 글자의 위치(인덱스)를 찾을 때 사용하는 함수
# INSTR()은 원본 문자열을 첫 번째에 적음
# ex) INSTR(원본문자열, 찾을문자열)
# 일치하는 값이 없으면 0을 반환 -> 0보다 크다는 조건을 걸어서, 존재하는 값만 가져오기

# INSTR()를 SELETE절에서 사용하는 경우
# SELECT 절에 사용하면 조건 검사를 하는 게 아니라, 진짜 글자가 몇 번째 위치에 있는지 숫자로 계산해서 결과 화면에 보여주는 역할을 함
# ex) SELECT OPTIONS, INSTR(OPTIONS, '네비게이션') AS navi_position
# -> 가죽시트,열선시트,후방카메라	0 (없으니까 0)
#    스마트키,네비게이션,열선시트	6 (6번째 글자부터 시작)
#    주차감지센서,후방카메라,네비게이션	13 (13번째 글자부터 시작)

# INSTR()를 WHERE절에서 사용하는 경우 -> WHERE절에 넣으면 원치 않는 행을 걸러내는 '필터' 역할을 함
# ex) WHERE INSTR(OPTIONS, '네비게이션') > 0;
# -> 내부적으로 각 행의 INSTR() 값을 계산(0, 6, 13 등등..),
#    그다음 뒤에 붙은 > 0 조건과 비교하여 참(TRUE)인 행,
#    즉 계산 결과 값이 나온 행만 남기고 0이 나온 행은 버림
