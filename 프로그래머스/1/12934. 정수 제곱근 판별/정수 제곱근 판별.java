class Solution {
    public long solution(long n) {
        long x = (long) Math.sqrt(n);
        // Math.sqrt()는 double타입을 반환 하므로, long으로 형변환
        if (n == x*x) {
            return (x+1)*(x+1);
        }
        if (n != x*x) {
            return -1;
        }
        return 0;
    }
}

// Math.sqrt() -> 제곱근을 구하는 메서드, double타입을 반환해줌,