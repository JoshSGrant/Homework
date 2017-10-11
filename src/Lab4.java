import java.util.Scanner;
import java.util.Random;


public class Lab4 {
    public static int sum;
    public static int inputRolls;
    public static int two =0, three =0, four =0, five =0, six =0,
            seven =0, eight =0, nine =0, ten =0, eleven =0, twelve =0;

    public static void RollDice(){
        int numberDieOne;
        int numberDieTwo;
        int count = inputRolls;
        Random random = new Random();

        while(count > 0) {

            numberDieOne = random.nextInt(6) + 1; //+1 because the bound includes 0-5 and excludes 6
            numberDieTwo = random.nextInt(6) + 1;
            int sumDice = numberDieOne + numberDieTwo;
            switch(sumDice){
                case 2:
                    ++ two;
                    break;
                case 3:
                    ++ three;
                    break;
                case 4:
                    ++ four;
                    break;
                case 5:
                    ++ five;
                    break;
                case 6:
                    ++ six;
                    break;
                case 7:
                    ++ seven;
                    break;
                case 8:
                    ++ eight;
                    break;
                case 9:
                    ++nine;
                    break;
                case 10:
                    ++ten;
                    break;
                case 11:
                    ++eleven;
                    break;
                case 12:
                    ++twelve;
                    break;
            }
            --count;
        }

    }

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        String response = "";
        while (!response.toLowerCase().equals("no")){
            two =0; three =0; four =0; five =0; six =0; seven =0; eight =0; nine =0; ten =0; eleven =0; twelve =0;
            System.out.println("Please enter the # of rolls you'd like to perform with two six-sided dice.");
            inputRolls = input.nextInt();
            while (inputRolls < 0) {
                System.out.println("Invalid Response. Please enter a positive integer.");
                inputRolls = input.nextInt();
            }
            RollDice();
            System.out.println("Here are the results for " + inputRolls + " rolls:\n\n" +
                    "VALUE  PROBABILITY  ACTUAL\n" +
                    "--------------------------\n" +
                    "2      1/36         " + two + "/" + inputRolls +
                    "\n3      2/36         " + three + "/" + inputRolls +
                    "\n4      3/36         " + four + "/" + inputRolls +
                    "\n5      4/36         " + five + "/" + inputRolls +
                    "\n6      5/36         " + six + "/" + inputRolls +
                    "\n7      6/36         " + seven + "/" + inputRolls +
                    "\n8      5/36         " + eight + "/" + inputRolls +
                    "\n9      4/36         " + nine + "/" + inputRolls +
                    "\n10     3/36         " + ten + "/" + inputRolls +
                    "\n11     2/36         " + eleven + "/" + inputRolls +
                    "\n12     1/36         " + twelve + "/" + inputRolls);
            input.nextLine();
            System.out.println("\nWould you like to roll again? ('yes' or 'no')");
            response = input.nextLine();
        }
    }
}
