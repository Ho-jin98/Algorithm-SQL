// n -> 상빈이가 가지고 빈병의 개수
// a -> 콜라 1개를 얻을 수 있는 빈병의 개수
// b -> 마트가 반환해주는 콜라의 개수

class Solution {
    public int solution(int a, int b, int n) {
        
        // 상빈이가 마트에서 받은 총 콜라의 수
        int totalCoke = 0;
        
        while(n >= a) {
            
            // 교환 받을 콜라
            // 예를들어, 빈병 2개당 콜라 1개를 준다고 가정한다면,
            // 빈병 총 20개를 가져갔을때 콜라 10병을 받아야함
            // (20 / 2) * 1 = 10
            int result = (n / a) * b;
            
            // 보유한 총 콜라에 누적
            totalCoke += result;
            // n -> 상빈이가 보유한 빈 병의 개수
            // a -> 마트에서 콜라 1개를 얻을 수 있는 빈병의 개수
            // 상빈이가 보유한 빈병의 개수 업데이트
            n = (n % a) + result;
            
        }
        return totalCoke;
    }
}