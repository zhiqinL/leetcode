package leetcode.uber;

import java.util.*;

public class SerializeandDeserializeNaryTree_428 {

    public String serialize(Node root) {
        if(root == null) return "";

        Queue<Node> queue = new LinkedList();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        res.append(root.val).append('|');

        while(!queue.isEmpty()) {
            Node curt = queue.poll();

            if(curt.children.isEmpty())
                res.append('#');

            for(Node child : curt.children) {
                res.append(child.val).append(',');
                queue.offer(child);
            }
            res.append('|');
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) return null;

        String[] values = data.split("\\|");
        Node root = new Node(Integer.valueOf(values[0]), new ArrayList());

        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int index = 1;

        while(index < values.length) {
            Node curt = queue.poll();
            String[] children = values[index++].split(",");

            if(children[0].equals("#")) continue;

            for(String val : children) {
                Node child = new Node(Integer.valueOf(val), new ArrayList());
                curt.children.add(child);
                queue.offer(child);
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}