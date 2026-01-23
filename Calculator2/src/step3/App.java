package step3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);
        int input1;
        int input2;
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
                System.out.print("사칙연산 기호(+, -, *, /)중 하나를 입력하세요: ");
                String oprInput = sc.nextLine();
                if (oprInput.isEmpty()) {
                    System.out.println("연산자를 입력해주세요");
                    continue;
                }
//            OperatorType type1 = OperatorType.operatorTypeToSymbol(oprInput);
                //TODO : ArithmeticCalculator클래스와 중복 코드!!!

                //TODO : 입력 받은 연산자로 enum상수랑 비교?
                double result = (double) calculator.calculate(input1, input2, oprInput);
                //TODO : 열거형에서 Number로 넘겨받으니까 꼭 형변환을 해줘야한다! (double)
                calculator.setResults(result);
                System.out.println("계산 결과: " + result);
                System.out.println("현재 저장된 결과들: " + calculator.getResults());
                System.out.print("첫 번째 값을 삭제하시겠습니까? yes/no (yes 입력시 삭제): ");
                if (sc.nextLine().equalsIgnoreCase("yes")) {
                    calculator.removeResults();
                }
                System.out.print("특정 값 보다 큰 결과를 조회하겠습니까? (yes 입력시 조회): ");
                if(sc.nextLine().equalsIgnoreCase("yes")) {
                    System.out.print("기준 값 입력: ");
                    double numbers =  Double.parseDouble(sc.nextLine());
                    System.out.println("기준 값 보다 큰 값: " + calculator.getResultsList(numbers));
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("분모는 0이 될 수 없습니다.");
            }
            System.out.print("계산을 계속 하겠습니까? (exit 입력시 종료): ");
            if (sc.nextLine().equalsIgnoreCase("exit")) {
                System.out.println("계산기 프로그램 종료");
                break;
            }
        }
        sc.close();
    }
}







