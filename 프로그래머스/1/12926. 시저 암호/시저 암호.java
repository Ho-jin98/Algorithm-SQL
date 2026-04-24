class Solution {
    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 공백일 때는 뒤에서 부터 추가해주고 넘어가기
            if (c == ' ') {
                result.append(c);
                continue;
            }
            
            // 소문자인 경우
            if (Character.isLowerCase(c)) {
                // n만큼 밀되, z를 넘어가면 a로 돌아오게
                char pushed = (char) ((c - 'a' + n) % 26 + 'a');
                result.append(pushed);
                
                // 대문자인 경우
            } else if (Character.isUpperCase(c)) {
            // ch를 n만큼 밀되, 'Z'를 넘어가면 'A'로 돌아오는 계산
            char pushed = (char) ((c - 'A' + n) % 26 + 'A');
            result.append(pushed);
            }
        }
        return result.toString();
    }
}
// 아스키 코드
// 대문자 A~Z -> 65번 ~ 90번까지
// 소문자 a~z -> 97번 ~ 122번까지

// 핵심 : z를 밀었을 때 a가 다시 나오게 해야됨
// (현재위치 + 밀 공간) % 26
// 만약, Z(25번)에서 1만큼 밀면 26이고, 26 % 26 = 0이 되어 A로 돌아옴