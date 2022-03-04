package Assignment01;

import java.util.Scanner;
import java.lang.Math;

public class HexadecimalConverter {

    static void decimToHexa(int number) {

        int hexaArray[] = new int[50];
        int index = 0;

        while (number > 0) {
            hexaArray[index++] = number % 16;
            number = number / 16;
        }

        for (int i = index - 1; i >= 0; i--) {

            if (hexaArray[i] == 10) {
                System.out.print('A');
            } else if (hexaArray[i] == 11) {
                System.out.print('B');
            } else if (hexaArray[i] == 12) {
                System.out.print('C');
            } else if (hexaArray[i] == 13) {
                System.out.print('D');
            } else if (hexaArray[i] == 14) {
                System.out.print('E');
            } else if (hexaArray[i] == 15) {
                System.out.print('F');
            } else {
                System.out.print(hexaArray[i]);
            }
        }

    }

    static void floatingPointDecimToHexa(double number) {

        int pointCount = 0;
        while (pointCount < 10) {
            number = number * 16;
            int x = (int) number;

            if (x == 10) {
                System.out.print('A');
            } else if (x == 11) {
                System.out.print('B');
            } else if (x == 12) {
                System.out.print('C');
            } else if (x == 13) {
                System.out.print('D');
            } else if (x == 14) {
                System.out.print('E');
            } else if (x == 15) {
                System.out.print('F');
            } else {
                System.out.print(x);
            }

            number = number - (double) x;
            pointCount++;
        }

    }

    static int hexatoDecim(String number) {

        int sum = 0;
        int power = 0;

        number = number.toUpperCase();

        String str = number;

        char[] characters = str.toCharArray();

        for (int i = characters.length - 1; i >= 0; i--) {

            if (characters[i] == 'A') {
                characters[i] = (int) 10;
                sum = (sum + (characters[i] * (int) (Math.pow(16, power))));
            } else if (characters[i] == 'B') {
                characters[i] = (int) 11;
                sum = (sum + (characters[i] * (int) (Math.pow(16, power))));
            } else if (characters[i] == 'C') {
                characters[i] = (int) 12;
                sum = (sum + (characters[i] * (int) (Math.pow(16, power))));
            } else if (characters[i] == 'D') {
                characters[i] = (int) 13;
                sum = (sum + (characters[i] * (int) (Math.pow(16, power))));
            } else if (characters[i] == 'E') {
                characters[i] = (int) 14;
                sum = (sum + (characters[i] * (int) (Math.pow(16, power))));
            } else if (characters[i] == 'F') {
                characters[i] = (int) 15;
                sum = (sum + (characters[i] * (int) (Math.pow(16, power))));
            } else {
                sum = (sum + ((Character.getNumericValue(characters[i])) * (int) (Math.pow(16, power))));
            }
            power++;
        }

        return sum;

    }

    static double floatingPointHexatoDecim(String number) {

        int power = -1;
        double sum = 0;
        number = number.toUpperCase();

        char[] characters = number.toCharArray();

        for (int i = 0; i <= characters.length - 1; i++) {

            if (characters[i] == 'A') {
                characters[i] = (int) 10;
                sum = (sum + (characters[i] * (Math.pow(16, power))));
            } else if (characters[i] == 'B') {
                characters[i] = (int) 11;
                sum = (sum + (characters[i] * (Math.pow(16, power))));
            } else if (characters[i] == 'C') {
                characters[i] = (int) 12;
                sum = (sum + (characters[i] * (Math.pow(16, power))));
            } else if (characters[i] == 'D') {
                characters[i] = (int) 13;
                sum = (sum + (characters[i] * (Math.pow(16, power))));
            } else if (characters[i] == 'E') {
                characters[i] = (int) 14;
                sum = (sum + (characters[i] * (Math.pow(16, power))));
            } else if (characters[i] == 'F') {
                characters[i] = (int) 15;
                sum = (sum + (characters[i] * (Math.pow(16, power))));
            } else {
                sum = (sum + ((Character.getNumericValue(characters[i])) * (Math.pow(16, power))));
            }

            power--;

        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Choose your conversion type");
        System.out.println("********************************************************\n"
                + "* Press 1 to Convert Decimal to Hexadecimal \n"
                + "* Press 2 to Convert floating point Decimal to Hexadecimal \n"
                + "* Press 3 to Convert Hexadecimal to Decimal \n"
                + "* Press 4 to Convert floating point Hexadecimal to Decimal \n"
                + "********************************************************\n");

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        switch (x) {

            case 1:
                System.out.print("Enter a decimal number: ");
                Scanner scan1 = new Scanner(System.in);
                int number1 = scan1.nextInt();
                decimToHexa(number1);
                System.out.println();
                break;
            case 2:
                System.out.print("Enter a floating point Decimal number: ");
                Scanner scan2 = new Scanner(System.in);
                double number2 = scan2.nextDouble();

                int integerPart = (int) number2;
                String str = String.valueOf(number2);
                int index = str.indexOf(".");
                int NumberofDecimalPoints = str.substring(index + 1).length();
                double decimalPart = number2 - integerPart;
                String roundOffasString = String.format("%." + NumberofDecimalPoints + "f", decimalPart); //decimal part roundoff as String
                decimalPart = Double.parseDouble(roundOffasString);
                decimToHexa(integerPart);
                System.out.print(".");
                floatingPointDecimToHexa(decimalPart);
                System.out.println();

                break;
            case 3:
                System.out.print("Enter a hexadecimal number: ");
                Scanner scan3 = new Scanner(System.in);
                String number3 = scan3.nextLine();
                System.out.println(hexatoDecim(number3));
                break;
            case 4:
                System.out.print("Enter a floating point hexadecimal number: ");
                Scanner scan4 = new Scanner(System.in);
                String number4 = scan4.nextLine();

                int indexNum4 = number4.indexOf(".");
                int NoofDecimalPoints = number4.substring(indexNum4 + 1).length();

                String part1 = number4.substring(0, (number4.indexOf(".")));
                String part2 = number4.substring((number4.indexOf(".") + 1), (number4.length()));
                
                System.out.println(hexatoDecim(part1) + floatingPointHexatoDecim(part2));
                break;
                
            default:
                System.out.println("Invalid input!");

        }

    }

}
