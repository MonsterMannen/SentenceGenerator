public class GenerateSentence {
    private Node head;

    public GenerateSentence(){
        head = new Node("xxx");
    }

    public void insertSentence(String sentence){
        Node temp = head;
        Node n;
        for(String word : sentence.split(" ")){
            foundNode = findNode(word, head);
            if(foundNode != null){
                n = foundNode;
            }else{
                n = new Node(word);
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
        for(Node n : nodes){
            sentence += n.getWord();
        }
        return sentence;
    }

    private Node findNode(String word, Node start){
        if(start.getWord.equals(word)){
            return start;
        }else{
            for(Node child : start.getChildren){
                findNode(word, child);
            }
        }
        // does this return NULL if word is not found?
    }

    // no javac on this shitcomputer
    // compile and test for me :^)
    public static void main(String[] args){
        GenerateSentence gs = new GenerateSentence();
        gs.insertSentence("hej jag är en fisk");
        gs.insertSentence("hej jag är fisk");
        gs.insertSentence("hundar har pinnar");
        gs.insertSentence("katter har knivar");
        String s = gs.GenerateSentence();
        System.out.println(s);
    }
}
