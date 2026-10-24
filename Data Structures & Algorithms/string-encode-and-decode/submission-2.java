class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.stream().forEach(str -> {
            sb.append(str.length())
                .append('#')
                .append(str);
        });
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int len = 0;
            while (str.charAt(i) != '#') {
                len = len * 10 + (str.charAt(i) - '0');
                i++;
            }
            
            i++;
            
            output.add(str.substring(i, i + len));
            i = i + len;
        }
        return output;
    }
}
