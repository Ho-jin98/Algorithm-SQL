class Solution {
    public String solution(String s) {
        
        StringBuilder result = new StringBuilder();
        
        // 단어별 인덱스를 관리할 변수
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 문자열 s에서 하나씩 꺼내어 c에 저장
            char c = s.charAt(i);
            
            // 1. 만약 c가 공백이라면, 인덱스를 0번째로 봐라, -> 카운트를 0부터 다시해라
            if (c == ' ') {
                idx = 0;
                result.append(c);
            } else {
                
            if (idx % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
                idx++;
          }
       }
        return result.toString();
    }
}

// 사람은 "try hello world"를 그냥 하나의 덩어리 하나의 단어로 보이지만,
// 컴퓨터는 한번 읽을때 한 글자씩만 읽기때문에, 읽고있는 글자가 첫번째인지 두번째인지 알 방법이 없음,
// 그래서 공백을 만나면 idx = 0; 0으로 다시 돌아가서 0부터 카운팅해라,
// try를 다 읽으면 공백을 만날것이고, 다시 0번째로 돌아간 다음 hello를 읽게됨
// 그래서 규칙대로 짝수 번쨰 인덱스 -> 대문자, 홀수 번째 인덱스 -> 소문자를 적용하게됨

// 사람은 공백은 문자로 생각 안하고 넘길 수 있지만, 컴퓨터는 공백도 문자로 포함하여 생각함,
// 현재 문제에서는 짝수번째 "문자"를 대문자로, 홀수번째 "문자"를 소문자로 바꾸라는 요구가 있었음,
// 만약 공백을 만났을 때 idx = 0;으로 인덱스를 초기화해주지 않으면,
// 컴퓨터는 공백까지 문자로 인식하기 때문에 우리가 생각하는 결과와 많이 다른 결과가 나올 수 있음