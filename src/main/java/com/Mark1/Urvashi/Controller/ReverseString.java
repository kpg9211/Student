package com.Mark1.Urvashi.Controller;
import java.io.*;

public class ReverseString {
    public static void main(String[] args){
        String str= "pooja";
        String reverseStr= "";
        for (int i=str.length()-1;i>=0;i
                --)
        {
            reverseStr =  (reverseStr+str.charAt(i));
        }
        System.out.println("reverse string" +reverseStr);

       // int[] arr= new int[5];
        int[] arr1={1,5,9,6,3,16};
        int max = arr1[0];

        for (int i =1; i<arr1.length;i++)
        {
            if(max<arr1[i])
            {

                max = arr1[i];
            }
            }
        System.out.println("max number" +max);
        int max2 =arr1[0];
        for (int i =1;i<arr1.length;i++) {
            if ((arr1[i] > max2) & (arr1[i]!= max)) {
                max2 = arr1[i];
            }
        }
        System.out.println("max2 number" +max2);

        String str1="ammia";

        for (int i =0;i<str1.length()/2;i++)
        {
            if(str1.charAt(i)!= str1.charAt(str1.length()-1-i)){
                System.out.println("not a palindrome");
                break;
            }
        }

    }

}

