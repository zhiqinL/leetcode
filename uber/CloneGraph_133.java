package leetcode.uber;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph_133 {


    public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
        if(node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        Queue<UndirectedGraphNode> queue = new LinkedList();

        map.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);

        while(!queue.isEmpty()) {
            UndirectedGraphNode curt = queue.poll();
            UndirectedGraphNode newNode = map.get(curt);

            for(UndirectedGraphNode next : curt.neighbors) {
                if(!map.containsKey(next)) {
                    map.put(next, new UndirectedGraphNode(next.label));
                    queue.offer(next);
                }
                newNode.neighbors.add(map.get(next));
            }
        }

        return map.get(node);
    }

    public UndirectedGraphNode cloneGraph_dfs(UndirectedGraphNode node) {
        if(node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        map.put(node, new UndirectedGraphNode(node.label));

        helper(node, map);

        return map.get(node);
    }

    private void helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {

        UndirectedGraphNode newNode = map.get(node);
        for(UndirectedGraphNode next : node.neighbors) {
            if(!map.containsKey(next)) {
                map.put(next, new UndirectedGraphNode(next.label));
                helper(next, map);
            }
            newNode.neighbors.add(map.get(next));
        }
    }
}
