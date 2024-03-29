public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int j = 0;
        int start = -1;
        int star = -1;
        
        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                start = i;
                star = j;
                j++;
            }
            else if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            }
            else if (star != -1) {
                start++;
                i = start;
                j = star + 1;
            }
            else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}