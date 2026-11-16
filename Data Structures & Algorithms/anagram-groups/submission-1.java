class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagPairs = new HashMap<String, List<String>>();
        for (var str: strs) {
            var chars = new int[26];
            for (char c: str.toCharArray())
                chars[c - 'a']++;
            String uniq = Arrays.stream(chars)
                .mapToObj(String::valueOf)
                .reduce("", (a, c) -> a + "-" + c)
                .toString();
            var values = anagPairs.getOrDefault(uniq, new ArrayList<String>());
            values.add(str);
            anagPairs.put(uniq, values);
        }
        return new ArrayList<>(anagPairs.values());
    }
}
