class Solution {
    public String solution(String s) {
        String result = "";
        if (s.length() % 2 == 0) {
            // 문자열 길이 짝수일 때
            result = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            // 문자열 길이 홀수일 때
            result = s.substring(s.length() / 2, s.length() / 2 + 1);
        }
        return result;
    }
}
// substring의 구조는 substring(a, b) -> a ~ b-1까지
// 인자를 2개 받는 경우는 a는 포함되지만 b는 포함 안되고 b 전까지만 포함됨,

// 문자열 길이 홀수 ex) 문자열 길이 5
// 길이가 5인 문자열에서 가운데 값을 구하려면 substring(2, 3)이 되어야 함,
// -> s.substring(s.length() / 2 , s.length() / 2 + 1);
// s.length() / 2 -> 시작 인덱스
// s.length() / 2 + 1 -> 끝 인덱스
// 5 / 2 -> 2 , 5 / 2 + 1 -> 3

// 문자열 길이 짝수 ex) 문자열 길이 4
// 길이가 4인 문자열에서 가운데 두 글자를 구하려면 substring(1, 3)이 되어야 함,
// -> s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
// s.length() / 2 - 1 -> 시작 인덱스
// s.length() / 2 + 1 -> 끝 인덱스
// 5 / 2 - 1 -> 1, 5 / 2 + 1 -> 3