class Solution {
    public String solution(String[] seoul) {
        for (int x = 0; x < seoul.length; x++) {
            if ("Kim".equals(seoul[x])) {
                return "김서방은 " + x + "에 있다";
            }
        }
        return "";
    }
}