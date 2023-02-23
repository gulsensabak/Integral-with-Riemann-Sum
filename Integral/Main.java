

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    // Main method is for you to test your code
    // You will not get any points here
    public static void main(String[] args) {

        Polynomial p1 = new Polynomial("-x^4+x^3+x^2-x");

        p1.setDeltaX(0.00009);
        System.out.print(p1.computeIntegral(4,6));

    }

}

