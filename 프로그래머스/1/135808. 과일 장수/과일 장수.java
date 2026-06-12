import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        
        // score 배열 오름차순 정렬
        Arrays.sort(score); // [1, 1, 1, 2, 2, 3, 3]
        
        // 만들 수 있는 상자의 개수
        int box = score.length / m;
        
        for (int i = 1; i <= box; i++) {
            result += score[score.length - m * i] * m;
        }
        
        return result;
    }
}

// ex)
// score = [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]
// m = 3

// 정렬 후
// score = [1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4]

//  index:  0  1  2  3  4  5  6  7  8  9 10 11
//  score: [1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4]
// -> 여기서 비싼 상자를 만들려면, 오름차순으로 정렬했기 때문에, 뒤에서 부터 m개씩 끊어야함, (3개씩)

// 첫 번째 상자 -> index = 9, 10, 11 / score = [4, 4, 4]
// -> 여기서의 최소 점수 score[9], 가격 -> score[9] * 3

// 두 번째 상자 -> index = 6, 7, 8 / score = [4, 4, 4]
// -> 여기서의 최소 점수 score[6], 가격 -> score[6] * 3
// ...

// 더해야 하는 인덱스 : 9,6,3,0, m = 3이므로 3칸씩 줄고 있음

// i = 9  -> [4, 4, 4]의 최저 점수 -> 4
// i = 6  -> [4, 4, 4]의 최저 점수 -> 4
// i = 3  -> [2, 2, 2]의 최저 점수 -> 1
// i = 0  -> [1, 1, 2]의 최저 점수 -> 1