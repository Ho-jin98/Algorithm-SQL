import java.util.*;

class Solution {
    public String solution(int a, int b) {
        
        // 편의성을 위해 0번 인덱스는 그냥 0으로 둠,
        // 1번 인덱스 -> 1월, 2번 인덱스 -> 2월 ....
        int[] monthLastDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 월별 일수 총합
        int totalDays = 0;
        
        for (int i = 1; i < a; i++) {
            totalDays += monthLastDays[i];
        }
        
        totalDays += b;
        
        // if (totalDays % 7 == 1) {
        //     return "FRI";
        // } else if (totalDays % 7 == 2) {
        //     return "SAT";
        // } else if (totalDays % 7 == 3) {
        //     return "SUN";
        // } else if (totalDays % 7 == 4) {
        //     return "MON";
        // } else if (totalDays % 7 == 5) {
        //     return "TUE";
        // } else if (totalDays % 7 == 6) {
        //     return "WED";
        // } else {
        //     return "THU";
        // }
        
        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        return dayOfWeek[totalDays % 7];
             
        }
}