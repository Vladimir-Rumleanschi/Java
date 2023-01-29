package VeketteteListe;



public class InsertInList {
    public NodeList addList(NodeList list,String word){
        if(list == null){
            list = new NodeList(word, null);
            return list;
        }
        if(word.compareTo(list.wort) > 0){
            list.nextNode = addList(list.nextNode,word);
            return list;
        }

        if(word.compareTo(list.wort) < 0){
            NodeList tempList = new NodeList(word,list);
            return tempList;
        }

        return list;
    }
}
