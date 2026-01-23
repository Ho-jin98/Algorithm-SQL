package step1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input1;
        int input2;
        int result;
        char operator;
        System.out.println("=====" + "계산기 프로그램 시작" + "======");
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                input1 = Integer.parseInt(sc.nextLine());
                System.out.print("두 번째 숫자를 입력하세요: ");
                input2 = Integer.parseInt(sc.nextLine());
                if (input1 < 0 || input2 < 0) {
                    System.out.println("0을 포함한 양의 정수만 입력해주세요.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요");
                continue;
            }
            System.out.print("사칙연산 기호(+, -, *, /)중 하나를 입력하세요: ");
            String oprInput = sc.nextLine();
            if (oprInput.isEmpty()) {
                System.out.println("연산자를 입력해주세요");
                continue;
            }
            // .isEmpty() >> 문자열의 길이가 0이면 true를 반환 (null이면 예외 발생)
            //  반대로 문자열의 길이가 0이 아니면 false 반환
            // oprInput에 사용자가 입력을 안하고 비어있는 상태라면 true가 되기 때문에
            // if의 조건문이 true가 되어서 "연산자를 입력해주세요"가 출력되고, continue;가 동작하는 원리.
            operator = oprInput.charAt(0);
            switch (operator) {
                case '+':
                    result = input1 + input2;
                    break;
                case '-':
                    result = input1 - input2;
                    break;
                case '*':
                    result = input1 * input2;
                    break;
                case '/':
                    if (input2 == 0) {
                        System.out.println("분모가 0이 될 수 없습니다");
                        continue;
                    }
                    result = input1 / input2;
                    break;
                default:
                    System.out.println("(+, -, *, /)중에서 하나를 입력하세요");
                    continue;
            }
            System.out.println("계산 결과: " + result);
            System.out.println("종료하시겠습니까? (exit 입력시 종료): ");
            String exit = sc.nextLine();
            if (exit.equalsIgnoreCase("exit")) {
                System.out.println("계산기 프로그램 종료");
                break;
            }
        }
        sc.close();
    }
}

