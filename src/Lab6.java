import java.util.Scanner;
import java.util.stream.*;

public class Lab6 {

    public static Scanner input = new Scanner(System.in);

    public static double max(double [] data){

       double max = data[0];
       for(int i = 0; i < data.length; i++){
           if(data[i] > max)
               max = data[i];
       }
       return max;
    }

    public static double min(double [] data){
        double min = data[0];
        for(int i = 0; i < data.length; i++){
            if(data[i] < min)
                min = data[i];
        }
        return min;

    }

    public static double sum(double [] data){
        double sum = DoubleStream.of(data).sum();
        return sum;


    }

    public static double ave(double [] data){
        double sum = DoubleStream.of(data).sum();
        double ave = sum / data.length;
        return ave;

    }

    public static void getData(double[] data){

        for (int i = 0; i < data.length; i++){
            System.out.println("Please enter item number " + (i + 1) + ": ");
            data[i] = input.nextDouble();
        }
    }

    public static void main (String [] args){

        double [] items = null;
        int num;
        System.out.println("How many items will be entered?");
        num = input.nextInt();
        items = new double[num];
        getData(items);
        System.out.println("Max: " + max(items));
        System.out.println("Min: " + min(items));
        System.out.println("Sum: " + sum(items));
        System.out.println("Ave: " + ave(items));


    }
}
