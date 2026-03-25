class Solution {
    public int solution(int num) {
        long n = (long) num;
        if (n == 1) return 0;
        long result = 0;
        while(n != 1 && result < 500) {
            if (n % 2 == 0) {
                n = n / 2;
                result += 1;
            } else{
                n = n * 3 + 1;
                result += 1;
            }
        }
        if(n == 1) {
            return (int) result;
        } else return -1;
    }
}