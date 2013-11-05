//package lsamelson_lab5;

import java.io.Console;
import java.util.Scanner;

/**
*
* @author binka
*/
public class Askuserinput {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here\
        /*Console console = System.console();
        String input = console.readLine("Please enter your first number:");
        int newinput = Integer.parseInt(input);
        String input2 = console.readLine("Please enter your second number: ");
        int newinput2 = Integer.parseInt(input2);*/
    	Scanner in = new Scanner(System.in);
    	System.out.println("Please enter your first number:");
    	int newinput = in.nextInt();
    	System.out.println("Please enter your second number: ");
    	int newinput2 = in.nextInt();
        /*int sum = newinput + newinput2;
        int diff = newinput - newinput2;
        int mult = newinput * newinput2;
        float div = newinput / newinput2;
        System.out.print(sum);
        System.out.print(diff);
        System.out.print(mult);
        System.out.print(div);*/
    	System.out.println(newinput);
    	System.out.println(newinput2);
    }
}