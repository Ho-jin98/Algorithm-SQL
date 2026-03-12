class Solution {
    public int solution(int n) {
        for (int x = 1; x <= n; x++) {
            if(n % x == 1) {
                return x;
            }
        }
        return 0;
    }
}
// 자연수 n을 x로 나눈 나머지가 1이 되는 x중에 가장 작은 값을 리턴,
// for문안에 i대신 x를 넣어서 1부터 하나씩 증가시켜가며 n이랑 모듈러 연산 했을 때 값이 1이 되는 값을 찾음, // 어차피 x = 1부터 1씩 증가하므로, 조건에 맞는 값은 가장 작은 값이 알아서 찾아질 것이고,
// return문을 for문 안에 넣어 버려서 찾으면 바로 반복문을 종료시킨다.