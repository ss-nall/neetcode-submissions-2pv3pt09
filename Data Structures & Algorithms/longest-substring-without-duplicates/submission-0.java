class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int right=0;right<s.length(); right++){
            char current = s.charAt(right);
            if(map.containsKey(current) &&map.get(current)>=left){
                left = map.get(current)+1;
            }
            map.put(current, right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
