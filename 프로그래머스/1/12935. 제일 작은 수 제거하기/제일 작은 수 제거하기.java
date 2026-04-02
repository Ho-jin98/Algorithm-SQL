class Solution {
    public int[] solution(int[] arr) {
        // 배열의 길이가 1이면 -1 얼리리턴
        if(arr.length == 1) return new int[]{-1};
        // 최솟값 찾기
        // 1. 최솟값 min을 임시로 선언
        int min = arr[0];
        // foreach문으로 하나씩 비교하기
        for (int num : arr)
            // 만약 num이 min보다 작다면, 이 순간이 배열 내의 최솟값을 찾은 시점
            if (num < min) {
                // 바로 담아주기
                min = num;
            }
        // 최솟값을 찾았으니, arr 배열의 길이 -1만큼 새로운 배열을 선언
        int result[] = new int[arr.length - 1];
        int idx = 0; // result용 인덱스
        // for문으로 하나씩 돌며 배열에서 가장 최솟값을 걸러내기
        for (int i = 0; i < arr.length; i++) {
            // 만약 arr배열의 인덱스 위치의 값이 최솟값이 아닌 경우 result 배열에 담기
            if (arr[i] != min) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }
}