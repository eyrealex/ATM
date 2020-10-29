/**
 * @(#)UseBankAccount.java
 *
 *
 * @Alex Eyre
 * @version 1.00 2017/3/27
 */

import java.util.Scanner; //import scanner
import java.util.Date; //import date
public class UseBankAccount {

    //declare global variables
    public static Scanner input = new Scanner(System.in);
    static Date d = new Date();
    static int tries=0;

    //start main method
    public static void main(String args[]) {

        //create object
        BankAccount Acc[] = new BankAccount[5];

        //declare variables
        String name="", strpin, strnum, strinput;
        int pin=0, sub=0, choice=0, num=0;
        boolean flag=false;

        //create array of objects
        Acc[0] = new BankAccount("Alex", 900, 111);
        Acc[1] = new BankAccount("James", 200, 222);
        Acc[2] = new BankAccount("Cian", 400, 333);
        Acc[3] = new BankAccount("Keith", 500, 444);
        Acc[4] = new BankAccount("Steven", 100, 555);

        //print welcome message on start up
        System.out.println("****WELCOME TO ALEX'S ATM****");

        while(flag==false){ //use while loop to go through array of objects

            //prompt user to login
            System.out.print("Enter your pin to login: ");
            strpin = input.next(); //take in input
            pin = pinValidate(strpin); //pass input to validate method

            for(int i=0;i<Acc.length;i++){ //for loop go through pins in the array of objects
                if(pin == Acc[i].getPin()){ //if the input pin is equal to the hardcoded pin
                    flag=true; //change flag to true
                    sub=i; //give sub the value of i to be used outside loop
                    System.out.println(); //blank line
                    System.out.print("Welcome " + Acc[sub].getName() + "\n"); //welcome the user plus their name
                    break; //break loop
                }//end if
            }//end for

            if(flag==false){ //if flag remains false
                System.out.println("Error, pin is incorrect!"); //print error message
                System.out.print("\007"); //play beep
                tries++; //increment tries
                if(tries>=3){ //if user enters in too any wrong pins
                    System.out.println("You have entered the wrong pin too many times!"); //print error messsage
                    System.exit(0); //shut down system
                }//end if tries
            }//end if
        }//end while

        while(choice!=4){ //while the choice is not equal to 4
            Acc[sub].menu(); //display bank menu
            System.out.println(); //blank line
            System.out.print("Please choose an option: "); //prompt user to choose an option
            strinput = input.next(); //take in input
            choice = choiceValidate(strinput); //pass input to validate method
            System.out.println(); //blank line

            if(choice == 1){ //if the user chooses 1
                Acc[sub].display(); //display statement
                System.out.println(); //blank line
            }//end if
            else if(choice == 2){ //if the user chooses 2
                //prompt user to withdraw
                System.out.print("How much do you want to withdraw : ");
                strnum = input.next(); //take in input
                num = withdrawValidate(strnum); //pass input to validate method
                Acc[sub].withdraw(num); //pass the input to the withdraw method to be set
                System.out.print("New Balance : " + Acc[sub].getBalance() + "\n"); //show new balance
            } //end else if
            else if(choice == 3){ //if the user chooses 3
                //prompt user to withdraw
                System.out.print("How much do you want to depost : ");
                strnum = input.next(); //take in input
                num = depositValidate(strnum); //pass input to validate method
                Acc[sub].deposit(num); //pass the input to withdraw method to be set
                System.out.print("New Balance : " + Acc[sub].getBalance() + "\n"); //show newe balance
            } //end else if
            else{ //otherwise if user chooses 4
                System.out.println("Thank you for using ALEX'S ATM"); //print good bye message
                System.exit(0);// exit system
            }//end else
        }//end while

    }//end main method

    //pinValidate method
    public static int pinValidate(String strpin){
        while(!strpin.matches("\\d{3}")){ //while the pin does not match 3 digits only
            System.out.print("ERROR, 3 digits only!\n");//print error message
            System.out.print("\007"); //play beep
            System.out.print("Re-Enter your pin to login: "); // prompt user again
            strpin = input.next();//take in input
        }//end while
        return(Integer.parseInt(strpin));//return the parsed input
    }//end pinValidation

    //choiceValidate method
    public static int choiceValidate(String strinput){
        while(!strinput.matches("[1-4]")){ //choice can only be between 1-4
            System.out.print("ERROR, between 1-4 only!\n"); //print error message
            System.out.print("\007"); //play beep
            System.out.print("Please choose an option: "); //prompt user to choose an option again
            strinput = input.next(); //take in input
        }//end while
        return(Integer.parseInt(strinput));//return the parsed input
    }//end choiceValidation

    //withdrawValidate method
    public static int withdrawValidate(String strnum){
        while(!strnum.matches("\\d+")){ //input can only include digits
            System.out.println("ERROR, digits only!\n"); //print error message
            System.out.print("\007"); //play beep
            System.out.print("How much do you want to withdraw: "); //prompt user again
            strnum = input.next(); //take in input
        }//end while
        return(Integer.parseInt(strnum));//return the parsed input
    }//end withdrawValidation

    //depositValidate method
    public static int depositValidate(String strnum){
        while(!strnum.matches("\\d+")){ //input can only include digits
            System.out.println("ERROR, digits only!");//print error message
            System.out.print("\007");//play beep
            System.out.print("How much do you want to deposit : ");//prompt user again
            strnum = input.next();//take in input
        }//end while
        return(Integer.parseInt(strnum));//return the parsed input
    }//end depositValidation

}//end class

