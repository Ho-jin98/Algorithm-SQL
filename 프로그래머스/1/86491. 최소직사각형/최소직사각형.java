class Solution {
    public int solution(int[][] sizes) {
        // 지갑의 가로 길이
        int width = 0;
        // 지갑의 세로 길이
        int height = 0;
        
        for(int[] size : sizes) {
            // 현재 명함에서 가장 긴 변과 가장 짧은 변을 구분
            // Math.max -> 두 인자 중 큰 값을 반환
            int max = Math.max(size[0], size[1]);
            // Math.min ->  두 인자 중 작은 값을 반환
            int min = Math.min(size[0], size[1]);
            
            // 명함의 가장 긴 변이 지갑의 가로길이보다 크다면
            // 명함의 긴 변들 중 가장 큰 값을 지갑의 가로 길이로 배정
            if (max > width) {
                width = max;
            }
            
            // 명함의 가장 짧은 변이 지갑의 세로 길이보다 크다면
            // 명함의 짧은 변들 중 가장 작은 값을 지갑의 세로 길이로 배정
            if (min > height) {
                height = min;
            }
        }
        return width * height;
    }
}
// 해당 문제의 핵심은 "모든 명함을 수납"하는 것,
// 모든 명함을 수납하기 위해서는 명함은 지갑의 가로 길이보다 짧아야하고, 세로 길이보다도 짧아야함
// Math.max와 Math.min으로 가장 긴 값과 가장 짧은 값을 추출하고
// 해당 지갑의 길이로 배정하면 명함은 항상 지갑에 수납될 수 있는 사이즈가 됨
// ex) int max = Math.max(10, 7); -> max = 10;
// ex) int min = Math.min(8,6); -> min = 6;
// 총 지갑의 크기 = 10 * 6;