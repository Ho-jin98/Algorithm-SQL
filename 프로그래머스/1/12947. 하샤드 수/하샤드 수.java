class Solution {
    public boolean solution(int x) {
        boolean result = true;
        int sum = 0;
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        if (x % sum == 0) {return result;}
        else {return false;}
    }
}