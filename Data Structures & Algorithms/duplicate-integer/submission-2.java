class Solution {
    public boolean hasDuplicate(int[] nums) {
        var seen = new HashSet<Integer>();
        for (var num: nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}