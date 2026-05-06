class Solution {
    public String solution(int[] food) {
        StringBuilder result = new StringBuilder();
        // 왼쪽 선수 음식 배치,
        // i = 0은 물이므로, i = 1부터 시작
        for (int i = 1; i < food.length; i++) {
            // food의 인덱스 -> 두 선수가 나눠서 먹을 음식
            // food[i] / 2 -> 한 선수가 먹는 음식의 개수
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                // food[1] -> 1번 음식의 개수
                // food[2] -> 2번 음식의 개수...
                // food의 인덱스 (i) -> 바깥 for문에서 구한 음식의 번호
                // j를 저장하면 단순 반복문에 사용되는 j = 0,1,2... 반복 횟수가 들어감
                // i를 넣어서 현재 조사하고 있는 음식 번호를 저장
                result.append(i);
            }
            // 바깥 for문 -> "음식의 종류"
            // 안쪽 for문 -> "음식의 개수"
            // 바깥 for문의 count가 1이면, 안쪽 for문은 1번 반복,
            // 바깥 for문의 count가 2이면, 안쪽 for문은 2번 반복....
        }
        
        // 물 없는 상태로 왼쪽 선수가 먹을거 저장
        String left = result.toString();
        // 기존 문자열에 물 넣기
        result.append("0");
        
        // StringBuilder의 reverse를 활용하여, left를 반대로 뒤집기
        StringBuilder right = new StringBuilder(left).reverse();
        // 기존 result 문자열에 그대로 저장
        // append -> 문자열의 뒤쪽으로 차례대로 추가
        result.append(right);
        
        // StringBuilder를 toString()을 통해 String 타입으로 변환하여 반환
        return result.toString();
    }
}