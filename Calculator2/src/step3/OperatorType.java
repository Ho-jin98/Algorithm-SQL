package step3;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", (num1, num2) -> num1 + num2),
    //TODO : PLUS의 ( ) 괄호 안은 "생성자 호출"이다. 그렇기 때문에, ( )괄호를 사용하려면,
    //TODO : 인스턴스 변수와 생성자를 새로 추가해줘야한다.
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0)
            throw new ArithmeticException("분모는 0이 될 수 없습니다.");
        return num1 / num2;
    });
    //TODO : 열거형은 멤버를 추가하여 사용할 수 있는데, 불연속적으로 여러개의 값을 사용하려면
    //TODO : 객체의 ( )괄호 안의 값들을 저장할 인스턴스 변수와 생성자를 추가해줘야 한다.

    //TODO : 위의 값들을 저장할 인스턴스 변수 선언
    private final String oprSymbol; //TODO : 연산 기호들이 들어갈 인스턴스 변수
    //TODO : 보통 변수명을 symbol로 많이씀.
    private final BiFunction<Double, Double, Double> operator; //TODO : num1,num2 연산 결과 값이 저장된 인스턴스 변수
    // TODO : BiFunction은 두 개의 입력값을 받아 하나의 결과를 반환하는 함수형 인터페이스
    // TODO : BiFunction 내부의 R apply(T t, U u);가 연산을 수행,
    //  BiFunction<T, U, R>에서 T,U가 계산되고 R로 결과값이 반환되는 원리
//     TODO : <T> – the type of the first argument to the function
//     TODO : <U> – the type of the second argument to the function
//     TODO : <R> – the type of the result of the function

    //TODO : 생성자 추가
    //TODO : 열거형의 생성자는 묵시적으로 private이므로 외부에서 객체 생성 불가!
    OperatorType(String oprSymbol, BiFunction<Double, Double, Double> operator) {
        this.oprSymbol = oprSymbol;
        this.operator = operator;
    }

    //TODO : 실제 연산을 하는 기능
    //TODO : enum에서는 제네릭을 직접적으로 사용하지 못함!!!
    //TODO : 그렇기 때문에, 메서드로 만들어 놓고, 간접적으로 활용!
    public <T extends Number> Number apply(T num1, T num2) {
        return operator.apply(num1.doubleValue(), num2.doubleValue());
    }
    //TODO : .doubleValue() >> Number 클래스가 가진 추상 메서드
    //TODO : 실제 연산 결과는 double로 나오기 때문에 반환 타입을 맞춰준다.
    //TODO : 그 외의 Double.valueOf() >> 다양한 데이터 타입을 Double 래퍼클래스로 변환해주는 기능
    //TODO : Double valueOf()는 숫자뿐만 아니라 문자열도 Double객체로 변환해주는 유용한 메서드

    public static OperatorType operatorTypeToSymbol(String oprSymbol) {
        for (OperatorType type : values()) {
            if (type.oprSymbol.equals(oprSymbol))
                return type;
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
    //TODO : values() >> enum의 상수들을 의미,
    //TODO : values()를 type변수에 저장해주고, 만약 type과 oprSymbol이 일치한다면, type을 반환해주겠다.

//    public String getOprSymbol() {
//        return oprSymbol;
//    }

}





