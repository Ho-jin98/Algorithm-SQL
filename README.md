## 계산기 과제를 소개합니다.

#### step1 - 기본적인 사칙연산(+,-,*,/) 계산기

#### step2 - Calculator 클래스를 이용해, 계산 기능을 분리, 캡슐화

#### step3 - Enum, Generic, Lambda, stream을 이용한 double타입 계산기

-----------

* stpe1
  
  * ***Scanner***를 활용해 사용자에게 0을 포함한 ____양의 정수 2개____ 입력 받기
    >
    >`if (input1 < 0 || input2 < 0) {`
    >
    > `System.out.println("0을 포함한 양의 정수만 입력해주세요.");`
    >
    > `continue;`
    >
    > `}`

    양의 정수만 입력 받기
    >
  * 사칙연산 기호 입력받기 `charAt(0);` 활용
    >`operator = oprInput.charAt(0);`
  * ***반복문***을 활용
    >`while() {...}`
  * ***try-catch***
    >`NumberFormatException e`  예외처리

-----------

* stpe2
  
  ***Calculator class***
  * **캡슐화** 
    >
    > ****`public`****
    > 
    > ****`private`****
    
  * ***getter***를 통해 간접 접근
    
        public ArrayList<Integer> getResults() {
    
        return this.results;
    
        }
    
  * *****setter*****를 활용

        public void setResults(int result) {
               this.results.add(result);
         }

        public void removeResults() {
            if (!this.results.isEmpty()) {
            this.results.remove(0);
        } else {
            System.out.println("삭제할 값이 없습니다");
        }

    }
    
-----------

 * step3

     *  ***Enum***과 ***Lambda***을 이용한 계산기능 구현

        > 
        > `PLUS("+", (num1, num2) -> num1 + num2)`
        > 

     *  `<T>` ***Generic*** 활용
  
         * **Number**로 받아서 계산을하는 메서드

        > 
        >`public <T extends Number> Number apply(T num1, T num2) {`
        >
        >`return operator.apply(num1.doubleValue(), num2.doubleValue());`
        >
        > `}`
      
     *  ******ArithmeticCalculator******
       
         * ***Enum*** 계산 기능을 호출
           
         *  **double** 타입 변환
           
         *  **stream**
      
             ** ***입력값*** 보다 ***큰 결과값*** 을 출력

          > `public List<Double> getResultsList(double inputValue) {`
          > 
          > `return this.results.stream()`
          > 
          > `.filter(value -> value > inputValue)`
          > 
          > `.collect(Collectors.toList());`




<!--
**Ho-jin98/Ho-jin98** is a ✨ _special_ ✨ repository because its `README.md` (this file) appears on your GitHub profile.

Here are some ideas to get you started:

- 🔭 I’m currently working on ...
- 🌱 I’m currently learning ...
- 👯 I’m looking to collaborate on ...
- 🤔 I’m looking for help with ...
- 💬 Ask me about ...
- 📫 How to reach me: ...
- 😄 Pronouns: ...
- ⚡ Fun fact: ...
-->
