class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>();
        Set<String> seenWords = new HashSet<>();
        
        for(String word : wordList)
        {
            wordSet.add(word);
        }
        
        Deque<String> q = new ArrayDeque<String>();
        
        q.offerLast(beginWord);
        
        int dis = 1; 
        int lvlCount = 1;
        int nextLvlCount  = 0;
        
        while(q.isEmpty() == false)
        {
            String currWord = q.removeFirst();
            
            if(currWord.equals(endWord))
            {
                return dis;
            }
            
            lvlCount--;
            char[] tempWord = currWord.toCharArray();
            
            for(int i =  0 ; i < currWord.length();i++)
            {
               for(char c = 'a' ; c <= 'z' ; c++)
               {
                   if(c == tempWord[i])
                   {
                       continue;
                   }
                   
                   tempWord[i] = c;
                   if(seenWords.contains(String.valueOf(tempWord)) == false && wordSet.contains(String.valueOf(tempWord)))
                   {
                       seenWords.add(String.valueOf(tempWord));
                       q.offerLast(String.valueOf(tempWord));
                       nextLvlCount++;
                   }
                   tempWord[i] = currWord.charAt(i);
               }
                
            }
            
            if(lvlCount == 0)
            {
                lvlCount = nextLvlCount;
                nextLvlCount = 0;
                dis++;
            }
        }
        
        return 0;
        
        
    }
}