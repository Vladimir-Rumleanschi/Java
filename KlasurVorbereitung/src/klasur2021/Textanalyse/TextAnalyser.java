package klasur2021.Textanalyse;


import java.util.ArrayList;

public class TextAnalyser {
    String Text;

    public void setText(String text){
        this.Text = text;
    }

    private String toString(ArrayList<ArrayList<String>> sortedWords){
        String fotmatedText = "";

        String[] numbers ;


        for(int i = 0; i < sortedWords.size() - 1 ;i++){
            for(int j = 0; j < sortedWords.size() - 1 ;j++ ){
                ArrayList<String> temp = sortedWords.get(j);
                if(!(i + 1 == sortedWords.size() && j + 1 == sortedWords.size())){
                    if(Integer.parseInt(sortedWords.get(j).get(0))  > Integer.parseInt(sortedWords.get(j+1).get(0))){
                        sortedWords.set(j,sortedWords.get(j+1));
                        sortedWords.set(j + 1,temp);
                    }
                }
            }
        }


        for( int i = 0; i < sortedWords.size(); i++ ){
            for(int j = 0; j < sortedWords.get(i).size();j++){
                fotmatedText = fotmatedText + " " + sortedWords.get(i).get(j);
            }
            fotmatedText = fotmatedText + "\n";
        }
        return fotmatedText;
    }


    public String analyseText(){
        ArrayList<ArrayList<String>> sortedWords = new ArrayList<ArrayList<String>>();
        String[] unsortedWords = this.Text.split(" ");

        for(int i  = 0; i < unsortedWords.length; i++){


            int count = unsortedWords[i].length();
            if(sortedWords.size() == 0){
                ArrayList<String> countWords = new ArrayList<String>();
                countWords.add(""+ count);
                countWords.add(unsortedWords[i]);
                sortedWords.add(countWords);
                System.out.println(sortedWords);
            }else{

                int checkPlace = 0;


                for(int j = 0; j < sortedWords.size(); j++){

                    String cmp= "" + count;
                    if(cmp.equals(sortedWords.get(j).get(0)) ){
                        sortedWords.get(j).add(unsortedWords[i]);
                    }else{
                        checkPlace++;
                    }
                }

                if(checkPlace == sortedWords.size()){
                    ArrayList<String> newWords = new ArrayList<String>();
                    newWords.add(""+ count);
                    newWords.add(unsortedWords[i]);
                    sortedWords.add(newWords);
                }
            }
        }
        return toString(sortedWords);
    }


}
