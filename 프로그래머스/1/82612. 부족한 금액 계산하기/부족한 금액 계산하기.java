class Solution {
    public long solution(int price, int money, int count) {
        
        long totalPrice = 0;
        
        // 놀이기구 이용료
        totalPrice = (long) price * (count * (count + 1) / 2);
        
        if(money - totalPrice >= 0) {
            return 0;
        } else {
         return (totalPrice - money);
        }
    }
}