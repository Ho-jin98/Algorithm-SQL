class Solution {
    public long solution(int a, int b) {
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        long sum = 0;
        
        for (long i = start; i <= end; i++) {
            sum = sum + i;
        }
        return sum;
    }
}