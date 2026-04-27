class Solution {
    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < eng.length; i++) {
            s = s.replace(eng[i], Integer.toString(i));
            // s는 문자열, i는 int타입
            // -> Integer.toString(i); 를 통해 String타입으로 변환 후 s에 담기
            // 기존 i : 1,2,3,...
            // toString(i) 변환 후 i : "1","2","3",....
        }
        // .replace("어떤 문자열을", "어떤 값으로 바꿀지");
        // -> replace는 바꿀 문자열이 없다면 아무일도 일어나지 않고 넘어감,
        // if문을 사용할 필요가 없음!
        
        // 마지막 결과는 모두 숫자이므로, int타입으로 파싱해줌
        return Integer.parseInt(s);
    }
}

// ex)
// String s = "one4seven";
// s = s.replace("one", "1");
// -> "one"을 찾아서 "1"로 바꿈, 없으면 그냥 넘어 감

// 영단어 문자열 배열을 미리 선언해두고, for문을 돌며, s안에 값들을 하나씩 확인,
// replace()를 통해서 바꿀 문자열과 어떤값으로 바꿀지 지정,
// 참고로, replace(a,b); -> 두 인자 모두 String 타입이어야함!
// i는 int타입이므로, Integer.toString(i)를 통해 String타입으로 변환 후 s에 담아줌,
