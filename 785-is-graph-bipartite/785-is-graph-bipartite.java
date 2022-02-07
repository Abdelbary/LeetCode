class Solution {
    
enum Color{UNCOLORED,RED,BLUE}
public boolean isBipartite(int[][] graph) {
    int numberOfVertex = graph.length;

    Color[] color = new Color[numberOfVertex];

    Arrays.fill(color,Color.UNCOLORED);

    for(int i = 0 ; i < numberOfVertex ; i++)
    {
      if(color[i] == Color.UNCOLORED)
      {
        if(bfs(graph,color,i) == false)
        {
          return false;
        }
      }
    }
    return true;
}

boolean bfs(int[][] adjList,Color[] color, int startNode)
{
color[startNode] = Color.BLUE;

Deque<Integer> q = new ArrayDeque<Integer>();

q.offerLast(startNode);

while(q.isEmpty() == false)
{
  int currNode = q.removeFirst();

  for(int adj : adjList[currNode])
  {
    if(color[adj] == Color.UNCOLORED)
    {
      color[adj] = (color[currNode] == Color.BLUE)? Color.RED : Color.BLUE;

      q.offerLast(adj);
    }
    else if(color[adj] == color[currNode])
    {
      return false;
    }
  }
}
return true;
}
}