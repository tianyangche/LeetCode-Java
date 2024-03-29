public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            throw new IllegalArgumentException();
        }
        
        if (S.length() < T.length()) {
            return 0;
        }
        
        int len1 = T.length();
        int len2 = S.length();
        int[][] rec = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0) {
                    rec[i][j] = 1;
                }
                else if (j == 0) {
                    rec[i][j] = 0;
                }
                else {
                    rec[i][j] = rec[i][j - 1];
                    
                    if (T.charAt(i - 1) == S.charAt(j - 1)) {
                        rec[i][j] += rec[i - 1][j - 1];
                    }
                }
            }
        }
        
        return rec[len1][len2];
    }
}
