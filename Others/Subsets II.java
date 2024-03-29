public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(num, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, int start, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i - 1] == num[i]) {
                continue;
            }
            
            cur.add(num[i]);
            helper(num, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
