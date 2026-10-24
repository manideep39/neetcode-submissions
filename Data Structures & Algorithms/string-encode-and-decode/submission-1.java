class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.stream().forEach(str -> {
            sb.append(str.length()).append('#').append(str);
        });
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder();
            while (str.charAt(i) != '#')
                sb.append(str.charAt(i++));
            int len = Integer.parseInt(sb.toString());
            output.add(str.substring(i + 1, i + 1 + len));
            i = i + 1 + len;
        }
        return output;
    }
}
