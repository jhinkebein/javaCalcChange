
package calcchange;

import java.text.MessageFormat;
import java.util.Scanner;
/**
 *
 * @author Jacob Hinkebein
 */
public class CalcChange {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int h = 0, q = 0, d = 0, n = 0, p = 0;
        String choice;
        System.out.println("Welcom to the Change Calculator!");
        
        System.out.println("Do you have change? (Y/N): ");
        choice = sc.nextLine();
        while (choice.toUpperCase().startsWith("Y")) {
            h += getCoin("Half-Dollars");
            q += getCoin("Quarters");
            d += getCoin("Dimes");
            n += getCoin("Nickels");
            p += getCoin("Pennies");
            sc.nextLine();
            
            String out = CoinTotal.coinTotal(h, q, d, n, p); //calling coinTotal from CoinTotal class
            
            System.out.println(out);
            
            System.out.println("Do you have more change?");
            choice = sc.nextLine();
        }
    }
    
    public static int getCoin(String coinType) {
        int c = -1;
        do{
            try {
                System.out.println(MessageFormat.format("How many {0} do you have? ", coinType)); //better than ("" + coinType + "") stuff
                c = sc.nextInt();
                if (c < 0) {
                    System.out.println("Please enter a non-negative value.");
                }
            }
            catch(Exception e){
                System.out.println("Illegal input: non-numeric");
                c = -1;
                sc.nextLine();
            }
        }while (c < 0);
        return c;
    }
    public static void coinTotal(int h, int q, int d, int n, int p){ //not used --extra credit
        int totalCents = (h * 50) + (q * 25) + (d * 10) + (n * 5) + p;
        int dollars = totalCents / 100;
        int cents = totalCents % 100;
        System.out.println(MessageFormat.format("You have a total of {0} cent(s), which is {1} dollar(s) and {2} cent(s)", totalCents, dollars, cents));
    }
}
