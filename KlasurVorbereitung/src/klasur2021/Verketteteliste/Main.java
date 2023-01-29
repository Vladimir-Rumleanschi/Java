package klasur2021.Verketteteliste;
import java.util.*;
import klasur2021.Verketteteliste.*;

public class Main {

    public static void main(String[] args){
        Node list = new Node();
        VList op = new VList();

        op.addNode(list,"Uni");
        op.output(list);
        op.addNode(list,"Java");
        op.output(list.next);
    }
}
