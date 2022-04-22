class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> indexStack = new ArrayDeque<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(c == '(') indexStack.offerLast(i);
            else if(c == ')')
            {
                if(indexStack.isEmpty())    set.add(i);
                else                        indexStack.removeLast();
            }
        }
        
        set.addAll(indexStack);
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(!set.contains(i)) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}