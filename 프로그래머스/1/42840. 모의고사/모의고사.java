class Solution {
    public int[] solution(int[] answers) {
        // 1번 수포자가 찍는 반폭 패턴 + 점수
        int[] math1 = {1, 2, 3, 4, 5};
        int score1 = 0;
        // 2번 수포자가 찍는 반폭 패턴 + 점수
        int[] math2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int score2 = 0;
        // 3번 수포자가 찍는 패턴 + 점수
        int[] math3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score3 = 0;
        
        // 정답 배열 answers를 for문으로 순회하며 수포자 1,2,3의 찍는 패턴과 비교
        for (int i = 0; i < answers.length; i++) {
            
            // answers배열의 길이만큼 반복을 할건데,
            // math1 배열은 길이가 5밖에 안됨, i가 배열의 길이를 넘어갈 수 있음,
            // 그래서, answers와 math1의 인덱스 N번째를 비교할 때는,
            // -> math1[i % math1.length]
            // ex) i = 5일 때, 5 % 5 = 0이므로, 다시 math1[0]번째로 돌아가서
            // answers[0]과 비교를 함, -> 배열의 길이를 벗어남을 방지
            if (math1[i % math1.length] == answers[i]) {
                score1++;
            }
            
            if (math2[i % math2.length] == answers[i]) {
                score2++;
            }
            
            if (math3[i % math3.length] == answers[i]) {
                score3++;
            }
        }
        
        // 최고 점수
        // Max.max(a, b); -> a와 b중 큰 값을 반환해줌,
        // 3개의 값을 비교해야 하므로, Math.max() 안에 하나를 더 사용
        int maxScore = Math.max(score1, Math.max(score2, score3));
        
        // 최고점을 받은 사람이 몇명인지 카운트
        int maxScoreCount = 0;
        
        // 1번 수포자가 최고 점수와 같으면 카운트 증가
        if (maxScore == score1) {
            maxScoreCount++;
        }
        
        // 2번 수포자가 최고 점수와 같으면 카운트 증가
        if (maxScore == score2) {
            maxScoreCount++;
        }
        
        // 3번 수포자가 최고 점수와 같으면 카운트 증가
        if (maxScore == score3) {
            maxScoreCount++;
        }
        
        // 우승자 결과 배열
        // 우승자가 1명이면 길이 1의 배열,
        // 우승자가 3명이면(동점) 길이 3의 배열이 생성됨
        int[] result = new int[maxScoreCount];
        
        // 결과 배열에 몇 번째 칸에 넣을지 기억하기 위한 변수
        int idx = 0;
        
        // 1번 수포자가 최고점이면 result 배열에 1번 수포자의 번호인 1을 넣음,
        // 여기서 1은 점수가 아니라 "1번 수포자"라는 의미
        if (maxScore == score1) {
            result[idx] = 1;
            idx++;
        }
        
        // 2번 수포자가 최고점이면 result 배열에 2번 수포자의 번호인 2를 넣음
        if (maxScore == score2) {
            result[idx] = 2;
            idx++;
        }
        
        // 3번 수포자가 최고점이면 result 배열에 3번 수포자의 번호인 3을 넣음
        if (maxScore == score3) {
            result[idx] = 3;
            idx++;
        }
        
        return result;
    }
}