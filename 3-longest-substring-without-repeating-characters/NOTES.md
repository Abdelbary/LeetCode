```
public int lengthOfLongestSubstring(String s) {
Map<Character,Integer> map = new HashMap<Character,Integer>();
int windowStart = 0;
int ans = 0;
for(int windowEnd = 0 ; windowEnd < s.length() ; windowEnd++)
{
char charToAdd = s.charAt(windowEnd);
if(map.containsKey(charToAdd))
{
windowStart = Math.max(windowStart,map.get(charToAdd)+1);
}
map.put(charToAdd,windowEnd);
ans = Math.max(ans,windowEnd-windowStart+1);
}
return ans;
}
```