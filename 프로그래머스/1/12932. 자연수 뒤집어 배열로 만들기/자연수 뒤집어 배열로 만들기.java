class Solution {
    public int[] solution(long n) {
        // 1. 타입을 변환해서 새로운 배열에 모두 담아주기
        
        String str = String.valueOf(n);
        // long타입을 String타입으로 형변환 하는 이유
        // 1. long타입은 숫자 덩어리라서 자릿수를 쪼개거나 접근하는 기능이 없다.
        // 반면, String클래스는 .length(), charAt() 같은 메서드로 각 자리에 접근하기 쉬움
        // .length() -> 배열의 길이를 쉽게 파악하기 위해서, 배열의 크기 결정할 때
        // .charAt() -> 각 요소에 쉽게 접근하기 위해서, 각 자리숫자 꺼낼 때
         
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
            // result[i] = str.charAt(i) - '0';
            // 유니코드 기준으로 문자형끼리 빼줘서 char타입을 int타입으로 변환해주는 과정,
        }
        for (int i = 0; i < str.length() / 2; i++) {
            int temp = result[i]; // 임시 저장할 배열
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }
        return result;
    }
}
// 흐름 총 정리
// long n = 12345
//     ↓ String.valueOf() -> long타입을 String타입으로 변환
// String str = "12345"
//     ↓ charAt(i) -> String 타입을 char타입으로 변환
// char c = '1', '2', '3' ...
//     ↓ - '0' 또는 Character.getNumericValue() -> char타입을 숫자 타입으로 변환
// int result[i] = 1, 2, 3 ...