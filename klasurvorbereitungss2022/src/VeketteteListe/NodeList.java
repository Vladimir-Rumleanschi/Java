package VeketteteListe;

public class NodeList {
    String wort;
    NodeList nextNode;

    public  NodeList(String word,NodeList node){
        this.wort = word;
        this.nextNode = node;
    }

    public String toString(NodeList list){
        String output = "";
        for(NodeList i = list; i != null; i = i.nextNode){
            if(i.nextNode == null){
                output = output + i.wort;
                break;
            }
           output = output + i.wort + "_";
        }

        return output;
    }

}
