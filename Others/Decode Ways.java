public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int pre1 = 1;
        int pre2 = 1;
        int cur = 0;
        
        for (int i = 0; i < s.length(); i++) {
            cur = 0;
            
            if (i >= 1 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6'))) {
                cur += pre1;
            }
            
            if (s.charAt(i) != '0') {
                cur += pre2;
            }
            
            pre1 = pre2;
            pre2 = cur;
        }
        
        return cur;
    }
}
