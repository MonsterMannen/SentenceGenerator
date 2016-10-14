import java.util.*;

public class Node {
    private String word;
    private List<Node> children = new ArrayList<>();
    private int ends = 0;    // how many sentences end with this word

    public Node(String word){
        this.word = word;
    }

    public void addEnd(){
        ends++;
    }

    // returns a random child node or a self ref if end
    public Node getRandomChild(){
        Node[] nodes = new Node[end + children.size()];
        for(int i = 0; i < children; i++){
            nodes[i] = children.get(i);
        }
        for(int j = 0; j < ends; j++){
            nodes[childred.size() + j] = this;  // self ref for every end
        }
        int r = (int)(Math.random() * (nodes.length + 1))
        return nodes[r];
    }

    public void addChild(Node n){
        children.add(n);
    }

    public List<Node> getChildren(){
        return children;
    }

    public String getWord(){
        return word;
    }
}
