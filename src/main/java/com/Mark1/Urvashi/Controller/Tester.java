package com.Mark1.Urvashi.Controller;

public class Tester {
    public static void main(String[] args) {
        String str = "abccpa";
        String result = "";
        for(int i=0; i<str.length()/2; i++)
        {
            if(str.charAt(i) != str.charAt(str.length()-1-i))
            {
                result ="not a pelimdrome";
                break;
            }
            if(i==str.length()/2 - 1)
            {
                System.out.println(" a pelimdrom= ");

            }
        }
        System.out.println("nresult= "+result);


    }
}
