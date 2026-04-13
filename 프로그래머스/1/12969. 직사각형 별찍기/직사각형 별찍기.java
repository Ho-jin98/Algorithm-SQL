import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < b; i++) {
            str.append("*".repeat(a));
            str.append("\n");
                
        }

        System.out.println(str);
    }
}

// Java의 이스케이프 문자
// \n -> 줄바꿈
// \t -> 탭
// \r -> 캐리지 리턴
// \\ -> 백슬래시
// \" -> 큰 따옴표
// \' -> 작은 따옴표

// String.repeat(n) -> 해당 문자열을 n번 반복한 새 문자열을 반환해줌,
// ex) "*".repeat(5) -> "*****"
// ex) "ab".repeat(3) -> "ababab"
// 안쪽 for문 없이도 한줄을 한번에 만들 수 있음!