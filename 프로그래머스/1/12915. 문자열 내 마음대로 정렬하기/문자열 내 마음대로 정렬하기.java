import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (s1, s2) -> {
            // 정렬할 대상과 기준을 정의
            // 정렬 대상 : strings
            // sort 메서드가 배열에서 두 요소 s1과 s2를 꺼내어 {} 안의 로직에 넣음
            // s1이랑 s2 중에 누가 더 앞인지 내가 정해줄게 라고 알려주는 역할
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            return Character.compare(s1.charAt(n), s2.charAt(n));
        });
        return strings;
    }
}

// s1.compareTo(s2) -> .compareTo()는 두 문자열 전체를 사전순으로 비교하는 메서드,
// s1이 s2보다 사전적으로 앞에 있으면 음수를 반환,
// 두 문자열이 완전히 같으면 0을 반환,
// s1이 더 뒤에 있으면 양수를 반환
// -> Arrays.sort는 이 결과값이 음수인지 양수인지를 보고 두 데이터의 위치를 바꿀지 말지 결정 함4


// Character.compare('a', 'b');
// -> 'a'와 'b' 중 누가 더 작은지 판단해서 결과를 정수(음수, 0, 양수)로 알려줌