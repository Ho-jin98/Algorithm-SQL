import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        
        // Map으로 <글자, 마지막 위치>를 저장
        Map<Character, Integer> map = new HashMap<>();
        
        // for문으로 하나씩 순회하면서
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Map에 포함된 값이 아니면 -1을 넣어줌,
            if (!map.containsKey(c)) {
                result[i] = -1;
            } else {
                // Map에 들어있으면 현재위치 - 마지막 위치
                // map.get(c) -> Map에서 "정수"를 꺼내옴
                // 그래서 i - map.get(c)는 "정수"의 결과가 나옴
                // 그래서 result[] 배열에 담아줄 수 있음
                result[i] = i - map.get(c);
            }
            // 나온 최종 결과를 map에 저장
            map.put(c, i);
        }
        return result;
    }
}

// Map<Key,Value> -> Key : 글자, Value : 마지막 위치로 활용

// 헷갈리지 말아야 할게, char c = s.charAt(i); -> c에는 문자 하나를 담고있는 녀석임,
// map.get(c) -> 이것의 의미는 map에 이미 있는 문자를 가져오는것임,
// 인덱스 위치에 있는 녀석을 가져온다는 의미가 절대 아님!