class Solution {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        Boolean result = true;
        int front = 0,
            back = xStr.length() - 1;
        
        while (front < back) {
            if (xStr.charAt(front++) != xStr.charAt(back--)) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}