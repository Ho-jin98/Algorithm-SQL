class Solution {
    public int solution(String t, String p) {
        
        Long lp = Long.parseLong(p);
        
        int count = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            // p.length() -> 길이 3
            // substring으로 잘라야하는 인덱스 위치가,
            // (0,3) -> (1,4) -> (2,5) 하나씩 늘어나며 짤라야함, 그래서 for문 활용
            String sub = t.substring(i, i + p.length());
        
            if(Long.parseLong(sub) <= lp) {
                count++;
            }
        }
        return count;
    }
}

// sub를 Long타입으로 파싱해주는 이유는, 예를들어 "10", "2" 문자열 두개를 비교할 때
// 컴퓨터는 사전순서로 따지기 때문에 첫 글자가 1인 "10"이 "2"보다 작다고 잘못 판단할 수 있음
// 정확한 크기 비교를 하기 위해 숫자로 먼저 변환 후 비교!

// t라는 긴 문자열에서 길이가 3인 부분 문자열 중 p보다 작은 값들을 찾아서 총 몇개인지 리턴해줘야함
// 그래서 마지막 if문으로 sub와 lp를 비교하고 참이면 카운트를 올려주고,
// 마지막 결과 값으로 count를 리턴