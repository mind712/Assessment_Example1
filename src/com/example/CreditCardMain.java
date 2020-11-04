package com.example;

import java.util.Scanner;

public class CreditCardMain {

    public static void main(String args[]) {
        Long cardNum;
        System.out.println("Please enter your 16 digit card number" + ":- ");
        Scanner scan = new Scanner(System.in);
        cardNum = scan.nextLong();
        boolean y = checkSum(cardNum);
        if (y == true)
            System.out.println("Your card is valid :-" + cardNum);
        else {
            System.out.println("The card enter by you is not valid :-" + cardNum);
        }
    }

    public static int cardLength(Long cardNumber) {
        String s = Long.toString(cardNumber);
        int length = s.length();
        return length;
    }

    public static Long reverse(Long cardNumber) {
        System.out.println("Card Number : " + cardNumber);
        long reverse = 0;
        while (cardNumber != 0) {
            reverse = reverse * 10;
            reverse = reverse + cardNumber % 10;
            cardNumber = cardNumber / 10;
        }
        return reverse;
    }

    static int sumOdd(Long cardNumber) {

        String str = Long.toString(cardNumber);
        String newvalue = "";
        for (int i = 0; i < cardLength(cardNumber); i += 2) {
            newvalue = newvalue + str.charAt(i);
        }
        //Long sumValue = 0L;
        Long oddValue = Long.parseLong(newvalue);
        return sumOfNumbers(oddValue);
    }

    static int evenSum(Long cardNumber) {
        String str = Long.toString(cardNumber);
        String newvalue = "";
        int result = 0;
        for (int i = 1; i < cardLength(cardNumber); i += 2) {
            newvalue = newvalue + str.charAt(i);
        }
        //   System.out.println("New Value is " + newvalue);
        if (newvalue.length() > 0) {
            for (int x = 0; x < newvalue.length(); x++) {

                int intValue = Integer.parseInt(String.valueOf(newvalue.charAt(x)));
                intValue = intValue * 2;
                //   System.out.println("The Converted Value is "+intValue);

                int len = Integer.toString(intValue).length();
                if (len >= 2) {
                    //     System.out.println("Entering for the even loop");
                    intValue = sumOfNumbers((long) intValue);
                }
                result = result + intValue;
            }

        }
        return result;
    }

    static int sumOfNumbers(Long sum) {
        Long checkValue = sum;
        long result = 0;
        if (checkValue != 0) {
            while (checkValue != 0) {
                long mod = checkValue % 10;
                result = result + mod;
                checkValue = checkValue / 10;
            }
        }
        return (int) result;
    }

    static int sumOfOddEven(int even, int odd) {
        return (even + odd);
    }

    static boolean checkSum(Long cardNumber) {

        long reversed = reverse(cardNumber);
        int odd = sumOdd(reversed);
        int even = evenSum(reversed);
        int result = sumOfOddEven(even, odd);
        System.out.println("The reversed number is " + reversed);
        System.out.println("The even number is " + even);
        System.out.println("The Odd number is " + odd);
        System.out.println("The calculated result is " + result);
        if (result % 10 == 0) {
            return true;
        }
        return false;

    }
}
