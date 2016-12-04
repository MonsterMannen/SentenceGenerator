import java.util.*;

public class GenerateSentence {
    private Node head;
    private Node foundNode = null;
    public static boolean debug = false;

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
                print("NewNode:" + word);
            }else{
                n = foundNode;
                print("ExistingNode:" + word);
            }
            print(" parent:" + temp.getWord() + "\n");
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

    public static void print(String s){
        if(debug) System.out.print(s);
    }

    public static void main(String[] args){
        GenerateSentence gs = new GenerateSentence();
        if(args.length > 0){
            if(args[0].equals("-d")) debug = true;
        }

        String[] sentences = {
            "asus monitor 144hz",
            "monitor the cameras",
            "gpu asus"
        };

        for(String sentece : sentences){
            gs.insertSentence(sentece);
        }

        String s = gs.createSentence();
        System.out.println(s);
    }
}
