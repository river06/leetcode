import java.util.*;

public class CloneGraph{
    public static void main(String[] args) {
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        
        UndirectedGraphNode nodeNeighbor = new UndirectedGraphNode(2);
        node.neighbors.add(nodeNeighbor);
        
        UndirectedGraphNode result = Solution.cloneGraph(node);
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
         queue.add(result);
        
        while( !queue.isEmpty()) { //?
            UndirectedGraphNode oriNode = queue.poll();
            System.out.println(oriNode.label);
            List<UndirectedGraphNode> oriNeighborList = oriNode.neighbors;
            
            if(!oriNeighborList.isEmpty()) queue.addAll(oriNeighborList);
        }

        
    }
}