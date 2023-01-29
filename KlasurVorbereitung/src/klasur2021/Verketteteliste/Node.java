package klasur2021.Verketteteliste;

public class Node {

    public String info;
    public Node next;


    public Node newNode(String value, Node list) {
        Node node = new Node();
        node.info = value;
        node.next = list;
        return node;
    }
}
