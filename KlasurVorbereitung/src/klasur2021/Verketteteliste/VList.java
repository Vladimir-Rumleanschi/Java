package klasur2021.Verketteteliste;

import klasur2021.Verketteteliste.Node;

public class VList {



    public Node addNode(Node list, String info){
        Node op = new Node();
        if(list.info == null){
            return list = op.newNode(info,null);
        }else if (list.info.compareTo(info) > 0){
            list = op.newNode(info,list);
        }else{
            for(Node n = list; n != null; n = n.next){
                if(n.next == null)return list;
            }
        }
        return list;
    }

    public void output(Node list){
       // while(list != null){
            System.out.println(list.info);
        //    if(list.next != null) System.out.print("_");
        //    list = list.next;
       // }

    }
}
