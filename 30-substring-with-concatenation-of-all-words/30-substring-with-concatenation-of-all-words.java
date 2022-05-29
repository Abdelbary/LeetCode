class Solution {
    int wordsCount;
    int wordLength;
    int stringLength;
    Map<String,Integer> wordFrq;
    List<Integer> ans;
    
    private void slidingWindow(int left, String s, List<Integer> answer) {
        int windowStart = left;
        Map<String,Integer> wordFrq = new HashMap<String,Integer>(this.wordFrq);
        int remaningWords = wordFrq.size();
        
        for(int windowEnd = left ; windowEnd + wordLength <= stringLength ; windowEnd += wordLength)
        {
            String subStr = s.substring(windowEnd,windowEnd+wordLength);
            
            if(!wordFrq.containsKey(subStr))
            {
                windowStart = windowEnd + wordLength;
                wordFrq = new HashMap<String,Integer>(this.wordFrq);
                remaningWords = wordFrq.size();
                continue;
            }
            
            wordFrq.put(subStr,wordFrq.get(subStr)-1);
            
            if(wordFrq.get(subStr) == 0)
                remaningWords--;
            
            if(remaningWords == 0)
                ans.add(windowStart);
            
            if(windowEnd - windowStart + wordLength == wordsCount*wordLength )
            {
                String wordOut = s.substring(windowStart,windowStart+wordLength);
                windowStart += wordLength;
                
                if(wordFrq.get(wordOut) == 0)
                    remaningWords++;

                wordFrq.put(wordOut,wordFrq.get(wordOut)+1);
            }
        }
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        this.wordsCount = words.length;
        this.wordLength = words[0].length();
        this.wordFrq    = new HashMap<String,Integer>();
        this.stringLength = s.length();
        
        for(String word : words)
            wordFrq.put(word,wordFrq.getOrDefault(word,0)+1);
        
        ans = new ArrayList<Integer>();    
        
        for(int i = 0 ; i < wordLength ; i++)
        {
            slidingWindow(i,s,ans);
        }
        
        return ans;
    }
}