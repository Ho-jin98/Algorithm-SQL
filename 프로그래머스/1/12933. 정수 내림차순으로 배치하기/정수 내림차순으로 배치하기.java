import java.util.Arrays;
class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        Arrays.sort(result);
        
        for (int i = 0; i < str.length() / 2; i++) {
            int temp = result[i]; // 임시 저장할 배열
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }
        long answer = 0;
        for (int i = 0; i < result.length; i++) {
            
            answer = answer * 10 + result[i];
        }
        return answer;
    }
}

// answer = answer * 10 + result[i];
// answer = 0
// i=0: answer = 0 * 10 + 8  = 8
// i=1: answer = 8 * 10 + 7  = 87
// i=2: answer = 87 * 10 + 3 = 873
// i=3: answer = 873 * 10 + 2 = 8732
// i=4: answer = 8732 * 10 + 1 = 87321
// i=5: answer = 87321 * 10 + 1 = 873211
// 기존 숫자를 왼쪽으로 밀면서 다름 새로운 자릿수를 더해줌