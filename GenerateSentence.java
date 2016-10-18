import java.util.*;

public class GenerateSentence {
    private Node head;
    private Node foundNode = null;

    public GenerateSentence(){
        head = new Node("xxx");
    }

    public void insertSentence(String sentence){
        Node temp = head;
        Node n = null;
        foundNode = null;   // reset
        for(String word : sentence.split(" ")){
            findNode(word, head);   // sets foundNode
            if(foundNode == null){
                n = new Node(word);
            }else{
                n = foundNode;
            }
            temp.addChild(n);
            temp = n;
        }
        n.addEnd(); // end node for this sentence
    }

    public String createSentence(){
        List<Node> nodes = new ArrayList<>();
        Node temp = head;
        Node n;
        while(true){
            n = temp.getRandomChild();
            if(n == temp) break;  // self ref returned = end
            nodes.add(n);
            temp = n;
        }
        String sentence = "";
        for(Node node : nodes){
            sentence += node.getWord() + " ";
        }
        return sentence;
    }

    private void findNode(String word, Node start){
        if(start.getWord().equals(word)){
            foundNode = start;
        }else{
            for(Node child : start.getChildren()){
                findNode(word, child);
            }
        }
    }

    // no javac on this shitcomputer
    // compile and test for me :^)
    public static void main(String[] args){
        GenerateSentence gs = new GenerateSentence();
        gs.insertSentence("hej jag är en fisk");
        gs.insertSentence("hej jag är fisk");
        gs.insertSentence("hundar har pinnar");
        gs.insertSentence("katter har knivar");
        String s = gs.createSentence();
        System.out.println(s);
    }
}
