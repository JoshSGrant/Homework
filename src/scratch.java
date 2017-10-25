import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class scratch {

    public static void main(String[] args) throws IOException {

        String realWord = "sprinkle";
        StringBuilder word = new StringBuilder();
        String scramWord = "";
        int wordLength = realWord.length();
        int num;
        StringBuilder wordNum = new StringBuilder(); //scrambled charAt#s to String for comparing

        Scanner input = new Scanner(System.in);
        Random ranNum = new Random();

        for (int i = 0; i < wordLength; i++) { //scrambling sequence
            num = ranNum.nextInt(wordLength);

            while(wordNum.toString().contains(Integer.toString(num))){
                num = ranNum.nextInt(wordLength);
            }
            wordNum.append(Integer.toString(num));
            word.append(realWord.charAt(num));
        }

        scramWord = word.toString();  //assign scrambled substring to string
        System.out.println(scramWord); //print scrambled word


        }

    }
