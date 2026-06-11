import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        // 기존 배열을 List로 변환
        List<String> cardList1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> cardList2 = new ArrayList<>(Arrays.asList(cards2));
        
        for (String result : goal) {
            // cardList1이 비어있지 않고,
            // goal에서 하나씩 순서대로 꺼내오는 값이랑 cardList1에 0번째 인덱스 값이 같다면,
            // 이미 사용된 값이므로 cardList1에서 제거,
            if (!cardList1.isEmpty() && result.equals(cardList1.get(0))) {
                cardList1.remove(0);
                // cardList2가 비어있지 않고,
                // goal에서 하나씩 순서대로 꺼내오는 값이랑 cardList2에 0번째 인덱스 값이 같다면,
                // 이미 사용된 값이므로 cardList2에서 제거,
                // 인데스 순서대로 비교
            } else if (!cardList2.isEmpty() && result.equals(cardList2.get(0))) {
                cardList2.remove(0);
            } else {
                // 둘 다 맨앞 카드가 result와 다르다면, 완성 시킬 수 없으므로 No를 리턴
                return "No";
            }
        }
        // 해당 조건을 모두 통과하면 Yes 리턴
        return "Yes";
        
    }
}