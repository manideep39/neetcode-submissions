class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        var charCnt = new int[26];
        for (var c: s.toCharArray())
            charCnt[c - 'a']++;

        for (var c: t.toCharArray()) {
            charCnt[c - 'a']--;
            if (charCnt[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
