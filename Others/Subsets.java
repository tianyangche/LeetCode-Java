public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(S, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] S, int start, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < S.length; i++) {
            cur.add(S[i]);
            helper(S, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
