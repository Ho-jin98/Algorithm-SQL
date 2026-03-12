import java.util.*;

public class Solution {
    public int solution(int n) {
        
        String result = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < result.length(); i++) {
            sum = sum + result.charAt(i) - '0';
        }
        return sum;
      
    }
}