package sample.SpielLogik;
import java.util.Random;

public class Logik {

    public String[] field;

    public int respond(String[] field) {
        boolean responded = false;
        Random rand = new Random();
        int output = 0;
        int randIndex = rand.ints(0, 8).findFirst().getAsInt();
        while (!responded) {
            if (field[randIndex].equals("")) {
                output = randIndex;
                responded = true;
                break;
            }
        }
        return output;
    }

    public int checkForVictory(String[] field){

        for (int i = 1; i < 9; i++) {
            String line = "";
            switch (i) {
                case 1:
                    line = field[0] + field[1] + field[2];
                    break;
                case 2:
                    line = field[3] + field[4] + field[5];
                    break;
                case 3:
                    line = field[6] + field[7] + field[8];
                    break;
                case 4:
                    line = field[0] + field[3] + field[6];
                    break;
                case 5:
                    line = field[1] + field[4] + field[7];
                    break;
                case 6:
                    line = field[2] + field[5] + field[8];
                    break;
                case 7:
                    line = field[0] + field[4] + field[8];
                    break;
                case 8:
                    line = field[2] + field[4] + field[6];
                    break;
            }
            if (line.equals("XXX") || line.equals("OOO")) return 1;
        }

        int count = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i].equals("X") || field[i].equals("O") ) {
                count++;
            } else break;
        }
        if (count == field.length) return 0;

        return -1;

    }
}
