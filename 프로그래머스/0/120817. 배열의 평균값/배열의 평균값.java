import java.util.Arrays;
class Solution {
    public double solution(int[] numbers) {
    //     int sum = 0;
    //     for (int num : numbers){
    //         sum = sum + num;
    //     }
    //     double result = (double) sum / numbers.length;
    //     return result;
        
        double result = Arrays.stream(numbers).average().getAsDouble();
        
        return result;
    }    
}