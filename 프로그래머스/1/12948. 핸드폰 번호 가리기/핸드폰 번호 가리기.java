class Solution {
    public String solution(String phone_number) {
        String byl = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            byl = byl + "*";
        }
        
        String result = byl + phone_number.substring(phone_number.length() - 4);
        return result;
    }
}