class Solution {
    public int solution(int[] number) {
        int result = 0;
        
        // 첫 번째 학생 선택
        for (int i = 0; i < number.length - 2; i++) {
            // 두 번째 학생 선택 (첫 번째 다음)
            for (int j = i + 1; j < number.length - 1; j++) {
                // 세 번째 학생 선택 (두 번째 다음)
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}