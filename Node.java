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
        Node[] nodes = new Node[ends + children.size()];
        for(int i = 0; i < children.size(); i++){
            nodes[i] = children.get(i);
        }
        for(int j = 0; j < ends; j++){
            nodes[children.size() + j] = this;  // self ref for every end
        }
        int r = (int)(Math.random() * (nodes.length));  // removed (+1)
        System.out.println("word:" + word + " childs:" + children.size() + " ends:" + ends + " r:" + r);   // test
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
