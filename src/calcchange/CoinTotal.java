package calcchange;

import java.text.MessageFormat;
/**
 *
 * @author Jacob Hinkebein
 */
public class CoinTotal {
    public static String coinTotal (int h, int q, int d, int n, int p){ //static so I dont have to create a CoinTotal object in CalcChange class
        String s = null;
        int totalCents = (h * 50) + (q * 25) + (d * 10) + (n * 5) + p;
        int dollars = totalCents / 100;
        int cents = totalCents % 100;
        s = MessageFormat.format("You have a total of {0} cent(s), which is {1} dollar(s) and {2} cent(s)", totalCents, dollars, cents);
        return s;
    }
    
}
