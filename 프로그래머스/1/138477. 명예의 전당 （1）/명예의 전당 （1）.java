import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // 매일 최 하위 점수를 담을 result 배열
        int[] result = new int[score.length];
        // 명예의 전당 리스트
        ArrayList<Integer> honorList = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            honorList.add(score[i]);
            Collections.sort(honorList, Collections.reverseOrder());
            
            if (honorList.size() > k) {
                honorList.remove(k);
            }
            
            // 정렬과 삭제가 끝난 후, 현재 명예의 전당의 가장 마지막(최하위) 점수를 result 배열에 추가,
            // 내림차순 정렬이므로 리스트의 맨 마지막 인덱스(size - 1)가 가장 작은 값!
            result[i] = honorList.get(honorList.size() - 1);
        }
        return result;
    }
}

// Collections.reverseOrder() -> 쉽게 말해 "순서를 반대로(역순으로) 뒤집어라"
// 자바에서 숫자를 정렬할 때 기본 값은 오름차순 정렬, 하지만 이 문제에서는
// 명예의 전당에 높은 점수를 상위에 두고 싶기 때문에, 반대로 뒤짚어야 함! -> 내림차순 정렬