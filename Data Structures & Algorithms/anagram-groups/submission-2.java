class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagPairs = new HashMap<String, List<String>>();
        for (var str: strs) {
            var count = new int[26];
            for (char c: str.toCharArray())
                count[c - 'a']++;
            String key = Arrays.toString(count);
            anagPairs.putIfAbsent(key, new ArrayList<>());
            anagPairs.get(key).add(str);
        }
        return new ArrayList<>(anagPairs.values());
    }
}
