/**
 * @(#)BankAccount.java
 *
 *
 * @Alex Eyre
 * @version 1.00 2017/3/27
 */


public class BankAccount {

    //private variables
    private String name;
    private int balance, pin;

    //Start constructor
    public BankAccount(String name, int balance, int pin) {
        this.name = name; //give the private name the value of name
        this.balance = balance; //give the private balance the value of balance
        this.pin = pin; //give the private pin the value of pin
    }//end constructor

    //start set methods
    public void setName(String name){
        this.name = name; //give the private name the value of name
    }//end setNames
    public void setBalance(int balance){
        this.balance = balance; //give the private balance the value of balance
    }//end setBalance
    public void setPin(int pin){
        this.pin = pin; //give the private pin the value of pin
    }//end setPin

    //start get methods
    public String getName(){
        return name;
    }//end getName
    public int getBalance(){
        return balance;
    }//end getBalance
    public int getPin(){
        return pin;
    }//end getPin

    // display menu method
    public static void menu(){
        System.out.println("1.Check Bank Statement"); //option 1
        System.out.println("2.Withdraw"); //option 2
        System.out.println("3.Deposit"); //option 3
        System.out.println("4.Exit"); //option 3
    }//end menu method

    //display bank statement method
    public void display(){
        System.out.println("***Bank Statement***"); //print header
        System.out.println("Name: " + name + "\nBalance: " + balance + "\nPin: " + pin); //print statement
    }//end statement

    //deposit method
    public void deposit(int num){
        balance = getBalance() + num; //give balance the value of the hardcoding balance + the user input
        setBalance(balance); //set the balance as the newly assigned balance
    }//end deposit method

    //withdraw method
    public void withdraw(int num){
        if(num>balance){ //if the user tries to take out more funds than what is in the account
            System.out.print("\nError, Insufficent Funds\n\n"); //give error message
            System.out.print("\007"); //play beep
        }//end if
        else{ //otherwise
            balance = getBalance() - num; //give balance the value of the hardcoding balance - the user input
            setBalance(balance); //set the balance as the newly assigned balance
        }//end else

    }//end withdraw method

}//end BankAccount class