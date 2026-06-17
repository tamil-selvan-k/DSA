class Solution {
    private Map<Character, Integer> getHash(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for(String s:strs) {
            Map<Character, Integer> key = getHash(s);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
        
    }
}
