class Solution {
    private String getKey(String s) {
        int[] freq = new int[26];

        for(char ch:s.toCharArray()) {
            freq[ch - 'a']++;
        }
            
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append('#').append(freq[i]);
        }

        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s:strs) {
            String key = getKey(s);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new String(s));
        }

        return new ArrayList<>(map.values());
    }
}
