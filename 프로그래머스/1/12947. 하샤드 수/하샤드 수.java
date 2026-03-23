class Solution {
    public boolean solution(int x) {
        boolean result = true;
        int sum = 0;
        // x의 자릿수를 각각 꺼내서 더해야되니, String타입으로 형변환
        String str = String.valueOf(x);
        // 자릿수가 달라질 수 있으므로, str.length()를 활용
        for (int i = 0; i < str.length(); i++) {
            // chatAt(i) -> 문자열에서 하나씩 꺼냄,
            // Character.getNumericValue(); -> char타입을 숫자타입으로 변환해주는 녀석
            sum += Character.getNumericValue(str.charAt(i));
        }
        if (x % sum == 0) {return result;}
        else {return false;}
    }
}