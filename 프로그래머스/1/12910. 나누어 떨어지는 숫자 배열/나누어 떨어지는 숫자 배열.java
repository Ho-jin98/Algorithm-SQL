import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr)
            .filter(num -> num % divisor == 0)
            // filter로 조건에 맞는 즉, 나누어 떨어지는 것만 거르기
            .sorted() // 오름 차순 정렬
            .toArray(); // 배열로 다시 합치기 (List가 아님)
        
    return result.length == 0 ? new int[]{-1} : result;
    }
 }
