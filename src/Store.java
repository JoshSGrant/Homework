//Josh Grant - CS 0401-1060
//

import javax.swing.*;
import java.util.Scanner;

public class Store {
    static Scanner input = new Scanner(System.in);
    final static String password = "password";
    static String houseNames[] = {"Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw"}; // Array for house names
    static int pinOrder[] = new int[4]; // Array to hold pin #s for each house (4)
    static int numOfPins = 0; // Variable to hold total # pins
    static int pinDiscMsg = 1;
    static int numBoxQuaffle = 0; // Variable to hold total # box of quaffles
    static int numIndQuaffle = 0; // Variable to hold total # individual quaffles
    static int numBroomstick = 0; // Var to hold total # broomstick  service kits
    static int costPin = 0; // Var to hold discount on pin cost
    static int totalRegular = 0;
    static int totalWithDiscount = 0;
    static int totalWithDiscountBeforeTen = 0;
    static boolean tenPercentOff = false;
    static int savings = 0;
    static int grandTotal = 0;
    static int changeTotal = 0;
    static int changeGalleon = 0;
    static int changeSickle = 0;
    static int changeKnut = 0;
    static boolean passwordHolder = false; //Initialize member as false, ties to pswd boolean method @ main method



    public static void globalVarReset()    // to reset program and variables without exiting program
    {
        pinOrder[0] = 0;
        pinOrder[1] = 0;
        pinOrder[2] = 0;
        pinOrder[3] = 0;
        numOfPins = 0;
        pinDiscMsg = 1;
        numBoxQuaffle = 0;
        numIndQuaffle = 0;
        numBroomstick = 0;
        costPin = 0;
        totalRegular = 0;
        totalWithDiscount = 0;
        totalWithDiscountBeforeTen = 0;
        tenPercentOff = false;
        savings = 0;
        grandTotal = 0;
        changeTotal = 0;
        changeGalleon = 0;
        changeSickle = 0;
        changeKnut = 0;
        passwordHolder = false;
    }

    public static void change()
    {
        changeTotal = changeTotal * -1;
        int tempVal = changeTotal % 493;
        changeGalleon = (changeTotal - tempVal)/493;
        changeTotal = tempVal;
        tempVal = changeTotal % 29;
        changeSickle = (changeTotal - tempVal)/29;
        changeTotal = tempVal;
        changeKnut = changeTotal;

    }

    public static void payment()
    {
        int remainCost = grandTotal;
        int paidSoFar = 0;
        System.out.println("Please enter a payment amount in the following format:\n" +
                "<amount><space><currency>\n" +
                "    - Where <amount> is an integer\n" +
                "    - Where <space> is a blank space\n" +
                "    - Where <currency> is either 'Knuts', 'Sickles', or 'Galleons'\n\n" +
                "You may enter as many times as you like. Each entry will be added to your total until " +
                "sufficient funds have been obtained.\n\nRecall the currency exchange:\n" +
                "|--------------------------------------|\n" +
                "|  29 Knuts = 1 Sickle                 |\n" +
                "|  493 Knuts = 17 Sickles = 1 Galleon  |\n" +
                "|--------------------------------------|\n");
        while (remainCost > 0)
        {
            System.out.print("\nPayment: ");
            int paymentValue = 0; //temp value, input of used for payment, reset each time
            int multiplier = 1;  // ""
            String payInput = input.nextLine();
            if(payInput.contains("-"))
            {
                System.out.println("Invalid Response. Please enter a positive integer.");
                System.out.print("\nPayment: ");
                payInput = input.nextLine();
            }

            int amtInput = Integer.parseInt(payInput.replaceAll("[^0-9]", ""));
            String typeInput = payInput.toLowerCase().replaceAll("[^a-z]", "");
            if (typeInput.equals("knut") || typeInput.equals("knuts") || typeInput.equals("sickle")
                    || typeInput.equals("sickles") || typeInput.equals("galleon") || typeInput.equals("galleons")
                    && amtInput >= 0) {
                switch (typeInput)                   //assigns type currency a multiply value to convert to knuts
                {
                    case "knut":
                        multiplier = 1;
                        break;
                    case "knuts":
                        multiplier = 1;
                        break;
                    case "sickle":
                        multiplier = 29;
                        break;
                    case "sickles":
                        multiplier = 29;
                        break;
                    case "galleon":
                        multiplier = 493;
                        break;
                    case "galleons":
                        multiplier = 493;
                        break;
                }


                paymentValue = multiplier * amtInput;
                paidSoFar = paidSoFar + paymentValue;
                remainCost = grandTotal - paidSoFar;
                System.out.println("You just added " + paymentValue + " Knuts to your total.\n" +
                        "You have paid " + (paidSoFar) + " out of " + (grandTotal) + " Knuts.");
                if (remainCost > 0) {
                    System.out.println("You still owe " + remainCost + (" Knuts."));
                } else {
                    if (remainCost == 0){
                        System.out.println("Thank you! You gave exact change.");
                    }
                    else {
                        changeTotal = remainCost;
                        change();
                        System.out.println("\nThank you!\n" +
                                "You have overpaid by " + -1 * (remainCost) + " Knuts.\n" +
                                "Here is your change:");
                        if (changeGalleon != 0){ System.out.println(changeGalleon + " Galleons");}
                        if (changeSickle != 0) { System.out.println(changeSickle + " Sickles");}
                        if (changeKnut != 0) { System.out.println(changeKnut + " Knuts");}
                    }
                    System.out.println("\nThank you for shopping at Quality Quidditch Supplies!\n\n");
                }
            }
            else
            {
                System.out.println("Invalid input, please try again.\n");
            }
        }
    }

    public static void totals() //Calculates values in the Totals
    {
        double totalWithDiscountDouble = 0;
        double tenPercentOffValue = 1;
        if (passwordHolder && numOfPins >= 10) // stores value 18 if member and buys at least 10 pins
        {
            costPin = 18;
        }
        else
        {
            costPin = 20;
        }
        totalWithDiscountBeforeTen = (numOfPins * costPin) + (numBoxQuaffle * 580) +
                (numIndQuaffle * 145) + (numBroomstick * 899);
        if (passwordHolder && (totalWithDiscountBeforeTen >= 1479)) // 3 galleons = 1479 knuts
        {
            tenPercentOffValue = 0.9;
            tenPercentOff = true;
        }
        else
        {
            tenPercentOffValue = 1;
        }
        totalRegular = (numOfPins * 20) + (numBoxQuaffle * 638) + (numIndQuaffle * 145) + (numBroomstick * 986);
        totalWithDiscountDouble = ((numOfPins * costPin) + (numBoxQuaffle * 580) +
                (numIndQuaffle * 145) + (numBroomstick * 899)) * tenPercentOffValue;
        totalWithDiscount = (int) Math.round(totalWithDiscountDouble);
        savings = totalRegular - totalWithDiscount;
        if(passwordHolder){
            grandTotal = totalRegular - savings;}
        else{
            grandTotal = totalRegular;
        }
    }

    public static void printCurrentOrder()
    {
        totals();
        System.out.println("Here is your total amount due:\n\n" +
                "Qty  Item                    Unit Price         Price\n" +
                "------------------------------------------------------------");
        if (numOfPins > 0) {
            System.out.println(numOfPins + "   " + "House Pin                " + //Pins
                    "20 Knuts          " + (numOfPins * 20) + " Knuts");
            if (pinOrder[0] > 0) {System.out.println("       " + pinOrder[0] + " " + houseNames[0]);}
            if (pinOrder[1] > 0) {System.out.println("       " + pinOrder[1] + " " + houseNames[1]);}
            if (pinOrder[2] > 0) {System.out.println("       " + pinOrder[2] + " " + houseNames[2]);}
            if (pinOrder[3] > 0) {System.out.println("       " + pinOrder[3] + " " + houseNames[3]);}
        }
        if (numBoxQuaffle > 0) {
            System.out.println(numBoxQuaffle + "   " + "Boxes of Quaffles        " + //Box Quaffles
                    "638 Knuts          " + (numBoxQuaffle * 638) + " Knuts");
        }
        if (numIndQuaffle > 0) {
            System.out.println(numIndQuaffle + "   " + "Individual Quaffle       " + "" + //Individual Quaffles
                    "145 Knuts          " + (numIndQuaffle * 145) + " Knuts");
        }
        if (numBroomstick > 0) {
            System.out.println(numBroomstick + "   " + "Broomstick Service Kit   " + //service kits
                    "986 Knuts          " + (numBroomstick * 986) + " Knuts");
        }
        System.out.println("------------------------------------------------------------"); //discounts below
        System.out.println("            Subtotal:                           " + (totalRegular) + " Knuts");
        if (passwordHolder)
        {
            System.out.println("\nDISCOUNTS:");
        }
        if (passwordHolder && numOfPins >= 10)
        {
            System.out.println("    (Discount on House Pins)                    " +//discount Pins
                    "(-" + numOfPins*(20 - costPin) + " Knuts)");
        }
        if (passwordHolder && numBoxQuaffle > 0)
        {
            System.out.println("    (Discount on Boxes of Quaffles)             " + //discount box quaffles
                    "(-" + numBoxQuaffle*(638 - 580) + " Knuts)");
        }
        if (passwordHolder && numBroomstick > 0)
        {
            System.out.println("    (Discount on Broomstick Service Kits)       " + //discount service kits
                    "(-" + numBroomstick*(986 - 899) + " Knuts)");
        }
        System.out.println("------------------------------------------------------------");
        if (tenPercentOff)
        {
            System.out.println("    **Additional 10% Off Entire Order**         " + //10% off msg
                    "(-" + (totalWithDiscountBeforeTen - totalWithDiscount) + " Knuts)");
        }
        if (passwordHolder)
        {
            System.out.println("            Total Savings: " + savings + " Knuts");
        }
        System.out.println("\n            Grand Total:                        " + grandTotal + " Knuts");
        input.nextLine();
        if (grandTotal != 0) {
            System.out.println("\n\nReady to pay? (yes/no)");
            String choice = input.nextLine();
            if (choice.toLowerCase().equals("yes")) {
                payment();
            } else {
                printOptions();
            }
        }
        else{
            System.out.println("\nNothing has been added to your order yet.\n");
            printOptions();
        }
    }

    public static void printBroomstick()
    {
        System.out.println("How many broomstick service kits would you like to order?");
        numBroomstick = input.nextInt();
        while (numBroomstick < 0)
        {
            System.out.println("Invalid Response. Please enter a positive integer.");
            numBroomstick = input.nextInt();
        }
        System.out.println("You have ordered " + numBroomstick + " broomstick service kits.");
        printOptions();
    }

    public static void printQuaffles()
    {
        System.out.println("How many individual quaffles would you like to order?");
        int numOfQuaffles = input.nextInt();
        while (numOfQuaffles < 0)
        {
            System.out.println("Invalid Response. Please enter a positive integer.");
            numOfQuaffles = input.nextInt();
        }
        numIndQuaffle = (numOfQuaffles % 5);
        numBoxQuaffle = ((numOfQuaffles - numIndQuaffle)/5);
        System.out.println("You have ordered " + numBoxQuaffle + " boxes of quaffles and " +
                numIndQuaffle + " individual quaffles.");
        printOptions();
    }

    public static void updateHousePins(int house)
    {
        System.out.println("How many " + houseNames[house] + " pins would you like?"); //method houseChoice updates this
        int pinIncrement = input.nextInt();
        while (pinIncrement < 0)
        {
            System.out.println("Invalid Response. Please enter a positive integer.");
            pinIncrement = input.nextInt();
        }
        pinOrder[house] = pinIncrement; //increments house pins
        numOfPins = pinOrder[0]+pinOrder[1]+pinOrder[2]+pinOrder[3]; //increments total pins
        if (numOfPins >= 10 && passwordHolder && pinDiscMsg > 0)
        {
            System.out.println("Congratulations! You have earned the discount price of 18 Knuts per pin!\n");
            pinDiscMsg --;
        }
        input.nextLine();
        System.out.println("Would you like to order any more pins? (yes/no)");
        String pinsMore = input.nextLine();
        if (pinsMore.toLowerCase().equals("yes"))
        {
            printHousePins();
        }
        else
        {
            printOptions();
        }
    }

    public static void houseChoice(int choice)
    {

        switch (choice)
        {
            case 1:
                //todo: Update Gryffindor Pins
                updateHousePins(0);
                break;
            case 2:
                //todo: Update Slytherin Pins
                updateHousePins(1);
                break;
            case 3:
                //todo: Update Hufflepuff Pins
                updateHousePins(2);
                break;
            case 4:
                //todo: Update Ravenclaw Pins
                updateHousePins(3);
                break;
            case 5:
                //todo: Finished Pin Order
                printOptions();
                break;
            default:
                System.out.println("Invalid Response");
                printHousePins();
        }

    }

    public static void printHousePins()
    {
        if(numOfPins == 0)
        {
            System.out.println("Here is your current pin order:\n" +
                    "No pins ordered yet.");
        }
        else
        {
            System.out.println("Here is your current pin order:\n   " + numOfPins + " Total Pins:");
            if (pinOrder[0] > 0) {System.out.println("        " + pinOrder[0] + " " + houseNames[0]);}  //if statements
            if (pinOrder[1] > 0) {System.out.println("        " + pinOrder[1] + " " + houseNames[1]);} //testing for
            if (pinOrder[2] > 0) {System.out.println("        " + pinOrder[2] + " " + houseNames[2]);} //neg inputs
            if (pinOrder[3] > 0) {System.out.println("        " + pinOrder[3] + " " + houseNames[3]);}
            /*System.out.println("Here is your current pin order:\n" +
                    numOfPins + " Total Pins:\n" +
                    "        " + pinOrder[0] + " " + houseNames[0] +
                    "\n        " + pinOrder[1] + " " + houseNames[1] +
                    "\n        " + pinOrder[2] + " " + houseNames[2] +
                    "\n        " + pinOrder[3] + " " + houseNames[3]);*/
        }
        System.out.println("\nFor which team would you like to order pins?\n" +
                "        1) " + houseNames[0] + "\n" +
                "        2) " + houseNames[1] + "\n" +
                "        3) " + houseNames[2] + "\n" +
                "        4) " + houseNames[3] + "\n" +
                "        5) Finished with Pin order");
        houseChoice(input.nextInt());
    }

    public static void optionChoice(int choice)
    {
        switch(choice)
        {
            case 1:
                printHousePins();
                break;
            case 2:
                printQuaffles();
                break;
            case 3:
                printBroomstick();
                break;
            case 4:
                if (passwordHolder == true)
                {
                    printPriceList(true);
                }
                else
                {
                    printPriceList(false);
                }
                printOptions();
                break;
            case 5:
                printCurrentOrder();
                break;
            case 6:
                System.out.println("Are you sure you want to restart your order?\n" +
                        "All ordered items will be erased. (yes/no)");
                input.nextLine();
                String response = input.nextLine();
                if (response.equals("yes"))
                {
                    System.out.println("\nOrder restarted.\n");
                    globalVarReset();

                }
                else
                {
                    printOptions();
                }
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                printOptions();
        }
    }

    public static void printOptions()
    {
        System.out.println("\nPlease choose an option:\n" +
                "        1) Update House Pins Order\n" +
                "        2) Update Quaffles Order\n" +
                "        3) Update Broomstick Service Kits Order\n" +
                "        4) Show Price List\n" +
                "        5) Review Order & Check Out\n" +
                "        6) Restart Order");
        optionChoice(input.nextInt());
    }

    public static void printPriceList(boolean member)
    {
        int pinCost = 20;
        int singleQuaffle = 145;
        int boxofQuaffles = 638;
        int broomStickServiceKit = 986;
        String pinsDiscount = "";
        String noDiscountText = "Please enjoy our items at their regular prices.\n\n";
        String pinAstr = "";
        if (member)
        {
            boxofQuaffles = 580;
            broomStickServiceKit = 899;
            pinsDiscount = 	"               **(only 18 Knuts if you buy 10 or more!)\n";
            noDiscountText = "";
            pinAstr = "**";
        }
        System.out.println("\n" + noDiscountText +
                "Here is our price list:\n" +
                "        House Pins (each)               " + pinCost + " Knuts" + pinAstr + "\n" +
                "               - Available in Gryffindor, Slytherin, HufflePuff and Ravenclaw\n" + pinsDiscount +
                "        Quaffles (each)                 " + singleQuaffle + " Knuts\n" +
                "        Quaffles (box of 5)             " + boxofQuaffles + " Knuts\n" +
                "        Broomstick Service Kits (each)  " + broomStickServiceKit + " Knuts");
    }

    public static void printPasswordInfo(){
        JOptionPane.showMessageDialog(null,
                "Welcome Dumbledore's Army member!\n" +
                        "*********************************************\n" +
                        "You will now have special discounts applied!\n" +
                        "        - Discount on 10 or more House Pins\n" +
                        "        - Discount on Boxes of Quaffles\n" +
                        "        - Discount on Broomstick Service Kits\n" +
                        "\n(see price list for more details)");
        System.out.println("Discounts applied!");
        /* In line print option
		System.out.println("\n" +
				"Welcome Dumbledore's Army Member!\n" +
				"You will get special discounts at WWW!\n" +
				"        Discount on 10 or more House Pins\n" +
				"        Discount on Boxes of Quaffles\n" +
				"        Discount on Broomstick Service Kits");
		 */
    }

    public static boolean password()
    {

        int attempts = 2;
        boolean retVal = false; //initialize return value as false
        while (attempts > 0)
        {
            System.out.println("What's the secret password?");
            String passwordInput = input.nextLine();
            if (passwordInput.equals(password))
            {
                retVal = true; //set return to true if  true
                printPasswordInfo();
                break;
            }
            else {
                if (attempts == 1){
                    System.out.println("Hmm...");
                }
                else {
                    System.out.println("Hmm... I'll give you one more chance.");
                }
                attempts -= 1;
            }

        }
        return retVal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Quality Quidditch Supplies!");
        System.out.print("Would you like to purchase anything? (yes/no): ");
        String response = input.nextLine();

        while (!response.toLowerCase().equals("no")){

            globalVarReset(); //method to reset all global variables for program replay

            passwordHolder = password();
            printPriceList(passwordHolder);
            printOptions();



            System.out.print("Would you like to purchase anything? (yes/no): ");
            response = input.nextLine();
        }
        System.out.println("Suit yourself! Have a nice day!");
    }
}

