class Solution {
    Set<String> set;//true
    Map<String,Boolean> cache;
	
    private String getKey(String s,int i)
    {
        return i + s;
    }
    private boolean helper(String s, int i, String subStr)
	{
		if(i == s.length())
			return set.contains(subStr.toString());
		
        String key = getKey(subStr,i);
		
        if(cache.containsKey(key))
            return cache.get(key);
        
        char currChar = s.charAt(i);
		
		
		Boolean ret = false;
		
		ret |= helper(s,i+1,subStr + currChar);
		if(set.contains(subStr.toString()) && !ret)
        {
           ret |= helper(s,i,"");
           cache.put(key,ret);
           return ret;
        }
       
        cache.put(key,ret);

		return ret;
	}

    
    public boolean wordBreak(String s, List<String> wordDict) {
        set =  new HashSet<String>();
	
	    cache = new HashMap<String,Boolean>();
        for(String word : wordDict)
		    set.add(word);

        return helper(s,0,"");

    }
}