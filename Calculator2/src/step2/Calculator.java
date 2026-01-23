package step2;

import java.util.ArrayList;

public class Calculator {
    // 속성 = 필드값
    private ArrayList<Integer> results;

    public Calculator() {
        // ( ) 괄호 안의 값이 파라미터
        this.results = new ArrayList<>();
        // 지금 같은 경우 this키워드는 없어도 됨.
    }
    // 지금 results; 안에는 아무 데아터도 들어있지 않은 상태
    // 세터 -> 외부에서 속성을 설정해주는 기능
    // 잘 생각해보면 "저장"기능을 구현 하는 것은 데이터들을 상자에 넣어 주는 건데,
    // 캡슐화를 하게 되면 속성에 직접 접근을 못하게 되니, 게터/세터를 통해서 해야되고,
    // 세터가 외부에서 속성을 "설정"(수정) 가능하게 해주는 기능이므로
    // 빈상자에 데이터를 추가해주는 거니까 속성을 다시 설정해주는 개념이 되는것 같다.
    // 그래서 저장기능은 "세터"를 통해서 접근해야 한다는 것 같다.
    public int calculate(int input1, int input2, char operator) {
        int result = 0;
        switch (operator) {
            case '+': result = input1 + input2;
            break;
            case '-': result = input1 - input2;
            break;
            case '*': result = input1 * input2;
            break;
            case '/':
                if (input2 == 0){
                    System.out.println("분모는 0이 될 수 없습니다.");
                }
                result = input1 / input2;
            break;
            //TODO: break; >> switch문의 현재 실행 중인 블록을 빠져나감,
            // return >> 메서드를 끝내고 값을 돌려줌
            // 이 case에서 계산을 끝낫다는 의미
            // break; > 방 나가기 , return > 집 나가기
            default:
                System.out.println("잘못된 연산자입니다.");

        } return result;
    }

    public void setResults(int result) {
        this.results.add(result);
        }

    public ArrayList<Integer> getResults() {
        return this.results;
    }

    public void removeResults() {
        if (!this.results.isEmpty()) {
            this.results.remove(0);
        } else {
            System.out.println("삭제할 값이 없습니다");
        }

    }

}
