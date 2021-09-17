
import java.util.Random;
import java.util.*;
public class BeanSlots{

    public static void main(String[] args) {
        int balls = 5;
        int beanSlots = 7;
        int[][] slots = new int[beanSlots][beanSlots];
        String ball1 = "";
        int col = 0;
        int row = 0;

        for(int i=0; i<7; i++){
            ball1 = path(7);
            col = traverseString(ball1);
            System.out.println(ball1);
            if(slots[0][col] == 1){
                while(slots[row][col] == 1){
                    row++;
                }
                slots[row][col] = 1;
            }
            row = 0;
            slots[0][col] = 1;
        }
        flipInPlace(slots);
        toString(slots);

    }
    public static String path(int beanSlots){
        String s = "";
        boolean check = true;
        for(int i=0; i<7; i++){
            check = getRandomBoolean();
            if(check == true){
                s = s + "R";
            }else{
                s = s + "L";
            }
        }
        return s;
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static int traverseString(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'R'){
                count++;

            }
        }
        return count;
    }

    public static void toString(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void flipInPlace(int[][] theArray) {
        for(int i = 0; i < (theArray.length / 2); i++) {
            int[] temp = theArray[i];
            theArray[i] = theArray[theArray.length - i - 1];
            theArray[theArray.length - i - 1] = temp;
        }
    }
}

