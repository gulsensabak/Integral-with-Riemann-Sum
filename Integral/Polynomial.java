

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Polynomial {

    private double deltaX = 0.0001;

    //Example solution:
    //Index 0: Coef. of x^0
    //Index 1: Coef. of x^1
    //Index 2: Coef. of x^2
    //Index 3: Coef. of x^3
    //Index 4: Coef. of x^4
    //If there is no x^n, that coefficient should be 0.

    private ArrayList<Integer> coefficients = new ArrayList<Integer>();

    //Fill in coefficients inside the constructor
    public Polynomial(String polynomial) {

        //DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

        ArrayList<String> depoArrayList= new ArrayList<>();

        // Adding space before "-".
        for(int k=0; k<polynomial.length(); k++) {
            char m= polynomial.charAt(k);
            String str = String.valueOf(m);
            if(str.equals("-")) {
                str= " "+ str;
                depoArrayList.add(str);
            }
            else {
                depoArrayList.add(str);
            }
        }

        //Controlling the coefficient of alone x for "-".
        ArrayList<String>redepoArrayList1 = new ArrayList<>();
        //Adding 1 after "-".
        for(int p=0; p<depoArrayList.size(); p++) {
            if(depoArrayList.get(p).equals(" -") && depoArrayList.get(p+1).equals("x")) {
                String de= depoArrayList.get(p);
                de= de+ "1";
                redepoArrayList1.add(de);
            }
            else {
                redepoArrayList1.add(depoArrayList.get(p));
            }
        }


        //Controlling the coefficient of alone x for "+".
        ArrayList<String>redepoArrayList = new ArrayList<>();
        if(depoArrayList.get(0).equals("x")) {
            String de= depoArrayList.get(0);
            redepoArrayList.add(0, "+1");
            redepoArrayList.add(de);

        }
        //Adding 1 before x.
        for(int p=0; p<redepoArrayList1.size(); p++) {
            if(redepoArrayList1.get(p).equals("+") && redepoArrayList1.get(p+1).equals("x")) {
                String de= redepoArrayList1.get(p);
                de= de+ "1";
                redepoArrayList.add(de);
            }
            else {
                redepoArrayList.add(redepoArrayList1.get(p));
            }
        }


        //Creating string to store our polynom
        String myString= "";
        for(int y=0; y<redepoArrayList.size(); y++) {
            myString+=redepoArrayList.get(y);
        }

        // Taking the elemnts of a polynom by using this string and split method.
        String[] myString123= myString.split("[+ ]");

        ArrayList<String> rehberArrayList= new ArrayList<>();
        for(int i=0; i<myString123.length; i++) {
            rehberArrayList.add(myString123[i]);
        }

        // all of my elements is in rehberarrayList
        ArrayList<String> sonArrayList= new ArrayList<>();
        //Creating a boolean flag to print the value taht I want once time.
        boolean flag= false;
        //Adding all elements in a certain format of polynom. ==> (x^4,x^3,x^2,x,constant).
        for(int u=0; u<rehberArrayList.size(); u++) {
            if(rehberArrayList.get(u).contains("x^4")){
                flag=false;
                char[] chars = rehberArrayList.get(u).toCharArray();
                int count=0;
                String aString2= String.valueOf(chars);
                for(int y=0; y<chars.length; y++) {
                    if(aString2.charAt(y)== ('x')) {
                        break;
                    }
                    else {
                        count++;
                    }
                }
                sonArrayList.add(rehberArrayList.get(u).substring(0,count));
                rehberArrayList.remove(rehberArrayList.get(u));
                break;
            }
            if(!rehberArrayList.get(u).contains("x^4")){
                flag=true;
            }
        }

        if(flag) {
            sonArrayList.add("0");
        }


        boolean flag2= false;
        for(int u=0; u<rehberArrayList.size(); u++) {
            if(rehberArrayList.get(u).contains("x^3")){

                flag2=false;
                char[] chars = rehberArrayList.get(u).toCharArray();
                int count=0;
                String aString2= String.valueOf(chars);
                for(int y=0; y<chars.length; y++) {
                    if(aString2.charAt(y)== ('x')) {
                        break;
                    }
                    else {
                        count++;
                    }
                }
                sonArrayList.add(rehberArrayList.get(u).substring(0,count));
                rehberArrayList.remove(rehberArrayList.get(u));
                break;
            }
            if(!rehberArrayList.get(u).contains("x^3")){
                flag2=true;
            }

        }

        if(flag2) {
            sonArrayList.add("0");
        }


        boolean flag3= false;
        for(int u=0; u<rehberArrayList.size(); u++) {
            if(rehberArrayList.get(u).contains("x^2")){

                flag3=false;
                char[] chars = rehberArrayList.get(u).toCharArray();
                int count=0;
                String aString2= String.valueOf(chars);
                for(int y=0; y<chars.length; y++) {
                    if(aString2.charAt(y)== ('x')) {
                        break;
                    }
                    else {
                        count++;
                    }
                }
                sonArrayList.add(rehberArrayList.get(u).substring(0,count));
                rehberArrayList.remove(rehberArrayList.get(u));
                break;
            }
            if(!rehberArrayList.get(u).contains("x^2")){
                flag3=true;
            }

        }

        if(flag3) {
            sonArrayList.add("0");
        }




        boolean flag5= false;
        for(int u=0; u<rehberArrayList.size(); u++) {
            if(rehberArrayList.get(u).contains("x")){

                flag5=false;
                char[] chars = rehberArrayList.get(u).toCharArray();
                int count=0;
                String aString2= String.valueOf(chars);
                for(int y=0; y<chars.length; y++) {
                    if(aString2.charAt(y)== ('x')) {
                        break;
                    }
                    else {
                        count++;
                    }
                }
                sonArrayList.add(rehberArrayList.get(u).substring(0,count));
                rehberArrayList.remove(rehberArrayList.get(u));
                break;
            }
            if(!rehberArrayList.get(u).contains("x")){
                flag5=true;
            }

        }
        if(flag5) {
            sonArrayList.add("0");
        }


        for(int u=0; u<rehberArrayList.size(); u++) {
            if(!rehberArrayList.get(u).contains("x") && !rehberArrayList.get(u).contains("x^4")
                    && !rehberArrayList.get(u).contains("x^2") && !rehberArrayList.get(u).contains("x^3") && !rehberArrayList.get(u).equals("")){

                sonArrayList.add(rehberArrayList.get(u));
                rehberArrayList.remove(rehberArrayList.get(u));
                break;
            }
            else {
                continue;
            }
        }

        // The aim of all if's and boolean flags are ordering our polynom in certain order and adding their coefficients to sonArrayList.
        for(int o=0; o<sonArrayList.size(); o++) {
            int elem= Integer.parseInt(sonArrayList.get(o));
            coefficients.add(elem);
        }

        //Controlling the length of coefficients arraylist to prevent error because of the constant value.
        if(coefficients.size()!=5) {
            coefficients.add(0);
        }
    }

    public double valueAt(double point) {

        //DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

        double result=0.0;

        //Calculating the value of polynom at given point.
        result+=coefficients.get(4)*Math.pow(point, 0)+ coefficients.get(3)* Math.pow(point, 1)
                + coefficients.get(2)* Math.pow(point, 2)+coefficients.get(1)* Math.pow(point, 3)+coefficients.get(0)* Math.pow(point, 4);

        return result;
        //DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
    }

    public void setDeltaX(double deltaX) {

        //DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
        //Creating setDeltaX method.
        this.deltaX= deltaX;
        //DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
    }


    public int computeIntegral(int min, int max) {

        double integration = 0;

        //DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
        //Calculating the integral by using rieman left sum.
        for(int i=0; i<(int)((max-min)/deltaX); i++) {
            integration+= valueAt(min+ (i)*(deltaX))*(deltaX);
        }
        //DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

        return (int)integration;
    }

}

