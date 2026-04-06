class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // i는 인덱스라는걸 헷갈리지 말자!!!
            // 단순 자릿수가 아님,
            // 0번째 -> 짝수
            if (i % 2 == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }
        String result = sb.toString();
        return result;
    }
}
// String vs StringBuilder vs StringBuffer
// String은 불변 객체, 한 번 값이 정해지면 변경할 수 없음.
// String s = "안녕";
// String s = "잘가";
// 이런식으로 다시 선언해도, 참조값이 바뀌는 것이지, 기존의 값이 변경되는 구조가 아님
// => 새로운 객체가 매번 생성된다!

// StringBuilder, StringBuffer -> 얘네는 가변 객체임, 내부에 버퍼를 들고 있어서
// 값을 바꿔도 새 객체를 만들지 않음

// StringBuilder -> 단일 스레드, 속도 빠름, 동기화 X
// StringBuffer -> 멀티 스레드, 속도 느림, 동기화 O
// 버퍼(Buffer)란? "데이터를 임시로 담아두는 공간"

// StringBuilder의 주요 사용 메서드
// 뒤에 추가 -> sb.append("수");
// 앞에 추가 -> sb.insert(0, "박");
// 삭제 -> sb.delete(0, 1);
// 뒤집기 -> sb.reverse();
// 특정 위치 교체 -> sb.replace(0, 1, "수");

// 마지막은 꼭 String으로 변환해주기!! -> String result = sb.toString();