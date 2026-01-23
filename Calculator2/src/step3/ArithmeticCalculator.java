package step3;

import step2.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    // 속성 = 필드값
    private ArrayList<Double> results;

    //TODO : 열거형에서 static으로 해놨기 때문에 호출이 가능함!
    //TODO : 계산하는 기능을 호출
    public Number calculate(int num1, int num2, String oprSymbol) {
        OperatorType operator = OperatorType.operatorTypeToSymbol(oprSymbol);
        return operator.apply(num1, num2).doubleValue();
    }

    public ArithmeticCalculator() {
        this.results = new ArrayList<>();
    }

    public ArrayList<Double> getResults() {
        return this.results;
    }

    public void setResults(double results) {
        this.results.add(results);
    }

    public void removeResults() {
        if (!this.results.isEmpty()) {
            this.results.remove(0);
        } else {
            System.out.println("삭제할 값이 없습니다");
        }

    }
    //TODO : stream과 람다를 활용한 큰 결과값 조회
    // 현재 필드값에 result에는 계산된 전체 값이 들어있으므로 특정값 보다 큰 값을 조회하기 위해
    // 메서드를 새로 만들어준다 >> getResultList, double로 받음
    public List<Double> getResultsList(double inputValue) {
        return this.results.stream()
                //TODO : stream >> 리스트의 값들을 펼치는 느낌
                .filter(value -> value > inputValue)
                //TODO : filter >> 말 그래도 걸러주는 것, 원하는 값만 얻기 위함.
                // inputValue >> 입력받는 값, value > 저장되어 있는 값들?
                .collect(Collectors.toList());
        //TODO : 원하는 값만 골라내기 위헤 stream으로 값들을 펼쳐놓고, filter로 값을 걸러줬다면
        // 다시 값들을 모아서 저장하기 위헤 Collectors.toList()로 List를 만들어준다.
    }

}

