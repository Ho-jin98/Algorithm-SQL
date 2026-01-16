package step1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner 사용시 엔터가 입력 버퍼에 남아서 예기치 못한 입력 스킵이 발생할 수 있음,
        // 따라서 sc.nextLine();과 sc.next(); 둘 중 하나만 사용하는 것이 좋고, sc.nextLine(); 사용을 권장함.
        int input1;
        int input2;
        int result = 0;
        char operator;
        System.out.println("=====" + "계산기 프로그램 시작" + "=====");
        // while문은 좀 더 직관적인 구조로 만드는 것이 보는 사람이 이해하기 쉬움
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력해주세요: ");
                input1 = Integer.parseInt(sc.nextLine());
                System.out.print("두 번째 숫자를 입력해주세요: ");
                input2 = Integer.parseInt(sc.nextLine());
        // sc.nextInt(); 사용 보다 Integer.parseInt(sc.nextLine());을 사용하여 sc.nextLine();으로 통일
                if (input1 < 0 || input2 < 0) {
                    System.out.println("0을 포함 양의 정수만 입력해주세요.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요");
                continue;
            }
            System.out.print("사칙 연산 기호(+, -, *, /)를 선택해주세요: ");
            operator = sc.nextLine().charAt(0);
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("(+, -, *, /)중에서 하나를 입력해주세요");
                continue;
            }
            // result 값을 중복 출력할 수 있기 때문에 수식 안에는 계산만
                if (operator == '+') {
                    result = input1 + input2;
                } else if (operator == '-') {
                    result = input1 - input2;
                } else if (operator == '*') {
                    result = input1 * input2;
                }
                if (operator == '/' && input2 == 0) {
                System.out.println("분모가 0이 될 수 없습니다.");
                continue;
                } else if (operator == '/') {
                    result = input1 / input2;
                }
            // 나누기 예외처리를 try-catch로 잡는것 보다 사전에 미리 방지하는게 더 좋음.
            // if문 보다 switch문을 활용하면 가독성이 더 높아짐
            System.out.println("계산 결과: " + result);
            System.out.print("종료하시겠습니까? (exit 입력시 종료): ");
            String exit = sc.nextLine();
            if (exit.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            }sc.close();
        }

    }








