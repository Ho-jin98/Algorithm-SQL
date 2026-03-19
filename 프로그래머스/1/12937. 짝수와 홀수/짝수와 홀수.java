class Solution {
    public String solution(int num) {
        String str1 = "Even";
        String str2 = "Odd";
        if (num % 2 == 0) {
            return str1;
        } else {
            return str2;
        }
    }
}