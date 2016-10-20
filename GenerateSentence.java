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
        for(String word : sentence.split(" ")){
            foundNode = null;   // reset
            findNode(word, head);   // sets foundNode
            if(foundNode == null){
                n = new Node(word);
                System.out.print("NewNode:" + word);
            }else{
                n = foundNode;
                System.out.print("ExistingNode:" + word);
            }
            System.out.println(" parent:" + temp.getWord());
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
        String sentence = "\n";
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

    // test
    private void printNodes(){

    }

    // no javac on this shitcomputer
    // compile and test for me :^)
    public static void main(String[] args){
        GenerateSentence gs = new GenerateSentence();
        //gs.insertSentence("hello I'm a fish");
        //gs.insertSentence("hello I'm fish");
        //gs.insertSentence("dogs have swag");
        //gs.insertSentence("cats have knives");

        gs.insertSentence("I like rabbits");
        gs.insertSentence("I like turtles");
        gs.insertSentence("I like dogs");
        gs.insertSentence("I don't like rabbits");

        String s = gs.createSentence();
        System.out.println(s);
    }
}
