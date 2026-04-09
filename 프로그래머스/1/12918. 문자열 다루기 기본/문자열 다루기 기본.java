class Solution {
    public boolean solution(String s) {
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
            }
        if(s.length() == 4 || s.length() == 6) {
                return result;
        }
        return false;
    }
}
// Character.isDigit(); -> 꺼낸 문자가 숫자인지 판별해주는 메서드
// 꺼낸 문자가 숫자면 -> true, 아니면 -> false 반환
// s 문자열에서 i번째 인덱스 값을 하나씩 가져와서 숫자인지 검사,
// 만약 숫자가 아니라면, return false;

// 문제에서 문자열의 길이는 4 혹은 6이고, 숫자로만 구성돼있을 때만 true리턴,
// 문자가 섞여있으면 false를 리턴 하므로,
// 가장 첫 번째 if문에서 문자가 포함 되어 있는지 확인 후 문자가 있으면 false를 바로 리턴,
// 마지막 if문에서 길이 체크해주고 앞에서 문자가 들어 있는 경우는 걸러졌으므로 true 리턴