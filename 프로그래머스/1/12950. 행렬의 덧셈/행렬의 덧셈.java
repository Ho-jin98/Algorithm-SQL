class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 2차원 배열 선언
        // int[][] result = new int[?][?];
        int[][] result = new int[arr1.length][arr1[0].length];
        // arr1.length -> 행의 크기
        // arr1[0].length -> 열의 크기
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return result;
    }
}

// {1,1} -> arr1[0]
// {2,2} -> arr1[1]
// {3,3} -> arr1[2]
// 이러한 2차원 배열이 있을때, 행의 크기 : arr1.legnth = 3 (행: 가로줄의 개수)
// 열의 크기 : arr1[0].length = 2
// 열: 세로줄의 개수 = 가로쥴 안에 원소 개수 = 한 행 안에 원소 개수