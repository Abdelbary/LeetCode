/*
two solutions using BFS 
 1- create the graph
 2- try all 26 charater at all places
*/
/* second solution */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {   
    if(wordList.contains(endWord) == false)
    {
        return 0;
    }
    
    HashSet<String> wordSet = new HashSet<String>();
    
     for(String word : wordList)
     {
         wordSet.add(word);
     }
     
    return bfs(wordSet,beginWord,endWord);
    }
    
    int bfs(HashSet<String> wordSet,String beginWord,String endWord)
    {
        Deque<String> queue = new ArrayDeque<String>();
        HashSet<String> visited = new HashSet<String>();
        
        queue.offerLast(beginWord);
        
        visited.add(beginWord);
        int currentLevelNodeCount = 1;
        int nextLevelNodeCount = 0;
        int level = 1;
        
        while(queue.isEmpty() == false)
        {
            char[] currentWord = queue.removeFirst().toCharArray();
            //System.out.println(currentWord);
            if(String.valueOf(currentWord).compareTo(endWord) == 0)
            {
                return level;
            }
            
            currentLevelNodeCount--;
            
            for(int i = 0 ; i < currentWord.length; i++)
            {
                char originalCharacter = currentWord[i];
                
                for(char tempCharater = 'a' ; tempCharater <= 'z' ; tempCharater++)
                {
                    if(tempCharater == originalCharacter)
                    {
                        continue;
                    }
                    
                    currentWord[i] = tempCharater;
                    
                    if(visited.contains(String.valueOf(currentWord)) == false && wordSet.contains(String.valueOf(currentWord)) == true)
                    {
                        //System.out.println(currentWord);
                        queue.offerLast(String.valueOf(currentWord));
                        visited.add(String.valueOf(currentWord));
                        nextLevelNodeCount++;
                    }
                    currentWord[i] = originalCharacter;
                }
            }
            
            if(currentLevelNodeCount == 0)
            {
                level++;
                currentLevelNodeCount = nextLevelNodeCount;
                nextLevelNodeCount = 0;
            }
        }
        
        return 0;
    }
}
/* First Solutions
class Solution {
    int characterDistance(String firstWord, String secondWord)
    {
        int dis = 0;
        for(int i = 0 ; i < firstWord.length() ; i++)
        {
            if(firstWord.charAt(i) != secondWord.charAt(i))
            {
                dis++;
            }
        }
        
        return dis;
    }
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord) == false)
        {
            return 0;
        }
        
        Map<String,HashSet<String>> adjList= new HashMap<String,HashSet<String>>();
        
        HashSet<String> adj = new HashSet<String>();
        
        for(String word : wordList)
        {
            if(characterDistance(beginWord,word) == 1)
            {
                adj.add(word);
            }
        }
        
        adjList.put(beginWord,adj);
        
        for(String word : wordList)
        {
            adj = new HashSet<String>();
            for(String otherWord : wordList)
            {
                if(characterDistance(word,otherWord) == 1)
                {
                    adj.add(otherWord);
                }
            }
            adjList.put(word,adj);
        }
        
        return bfs(adjList,beginWord,endWord);    
    }
    
    int bfs(Map<String,HashSet<String>> adjList, String beginWord, String endWord)
    {
        Deque<String> queue = new ArrayDeque<String>();
        Set<String> visited = new HashSet<String>();
        
        queue.offerLast(beginWord);
        visited.add(beginWord);
        
        int currentLevelNodeCount = 1;
        int nextLevelNodeCount = 0;
        int level = 1;
        
        while(queue.isEmpty() == false)
        {
            String currentWord = queue.removeFirst();
            
            if(endWord.compareTo(currentWord) == 0)
            {
                return level;
            }
            
            currentLevelNodeCount--;
            
            for(String word : adjList.get(currentWord))
            {
                if(visited.contains(word) == false)
                {
                    queue.offerLast(word);
                    visited.add(word);
                    nextLevelNodeCount++;
                }
            }
            
            if(currentLevelNodeCount == 0)
            {
                currentLevelNodeCount = nextLevelNodeCount;
                nextLevelNodeCount = 0 ;
                level++;
            }
            
        }
        
        return 0;
    }
    
}
*/