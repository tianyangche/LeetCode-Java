public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 1;
        }
        
        for (int i = 0; i < len; i++) {
            while (A[i] - 1 >= 0 && A[i] - 1 < len && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return len + 1;
    }
}
