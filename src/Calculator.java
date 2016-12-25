/**
 * Created by Hudson on 12/25/2016.
 */
import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //variables (7 inputs, 1 output)
        char remainder, operator = ' ', option, arrayAccess = 'y', feedback;//all inputs
        int arrayCall = 0;//input
        double[] number = new double [2];//array declaration, this is an input
        double answer;//output

        //description of the program
        introductoryMessage();

        //asks user if he/she wants to find a remainder, a function that the calculator doesn't have
        System.out.println(" Before you use this calculator application, would you like use a remainder calculator? ");
        System.out.println("Commands: y/n");
        remainder = input.next().charAt(0);

        //remainder and simple calculator
        while (remainder == 'y')//this will only work if the user wants to use the remainder calculator by entering y in the statement above
        {
            System.out.println(" REMAINDER CALCULATOR: \n -------------------- ");
            System.out.print(" Enter a number: ");//asks user to enter a number
            number[0] = input.nextDouble();
            System.out.print(" Enter another number: ");//asks user to enter another number
            number[1] = input.nextDouble();

            System.out.print(" The answer is " + number[0]%number[1] + "\n");//computes the remainder and outputs the remainder

            System.out.print(" Would you like to use this function again? ");//loops if the user enters y and moves onto the calculator if the user enters n
            remainder = input.next().charAt(0);
        }
        while (remainder != 'y' && remainder != 'n')//loops the input if the user enters an invalid input
        {
            System.out.println(" You have entered an invalid input. Please try again. ");//asks user to enter a valid input(y or n)
            remainder = input.next().charAt(0);
        }

        System.out.println(" SIMPLE CALCULATOR: \n ----------------- ");//signals to the user that this is the start if the simple calculator
        //simple calculator
        do
        {
            if (arrayAccess == 'y' || arrayAccess == 'n')//whether or not the user wants to use the array, the user will still have to enter a number
            {
                if (arrayCall == 2 || arrayCall == 0 || arrayAccess == 'n')//this will trigger if the user doesn't want to use the array, at the start of the program, and if the user wants to reuse one of the numbers
                {
                    System.out.print(" Enter one number: ");//asks user to enter a number
                    number[0] = input.nextDouble();
                }
                if (arrayCall == 1 || arrayCall == 0 || arrayAccess == 'n')//this will trigger if the user doesn't want to use the array, at the start of the program, and if the user wants to reuse one of the numbers
                {
                    System.out.print(" Enter another number: ");//asks user to enter another number
                    number[1] = input.nextDouble();
                }
                System.out.print(" Which operator would you like to use? ");//asks user to enter a operator
                operator = input.next().charAt(0);
            }
            while (operator != '+' && operator != '-' && operator != '*' && operator != '/')//keeps on looping when the operator is not a valid input
            {
                System.out.print(" You have entered an invalid operator. Please try again. ");//asks user to input a operator again
                operator = input.next().charAt(0);
            }
            //operator multibranch statement, allows the user to choose what operator to use depending on the input
            if (operator == '+')
            {
                answer = addition(number);
                System.out.println(" The answer is: " + answer);//displays the answer by calling the addition method
            }
            else if (operator == '-')
            {
                answer = subtraction(number);
                System.out.println(" The answer is: " + answer);//displays the answer by calling the subtraction method
            }
            else if (operator == '*')
            {
                answer = multiplication(number);
                System.out.println(" The answer is: " + answer);//displays the answer by calling the multiplication method
            }
            else if (operator == '/')
            {
                answer = division(number);
                System.out.println(" The answer is: " + answer);//displays the answer by calling the division method
            }

            System.out.print(" Would you like to use this program again? Input 'y' for yes and 'n' for no. ");//asks user to enter y or n to loop the program
            option = input.next().charAt(0);

            while(option != 'y' && option != 'n')//this will loop if the user doesn't enter a valid input of y or n
            {
                System.out.print(" You have entered an invalid input. Please type y for yes and n for no. ");
                option = input.next().charAt(0);
            }

            //access the array
            if (option == 'y')//activates this whole section if the user wants to use the array
            {
                System.out.print(" Would you like to use a number that you used before? ");//asks user to enter y or n to use a previously entered number
                arrayAccess = input.next().charAt(0);

                if (arrayAccess == 'y')//if they want to use a previously entered number
                {
                    System.out.println(" Choose the number you want to access. ");//asks user to enter a number corresponding to the number they want to repeat on the list
                    System.out.println(" 1. " + number[0] + "\n 2. " + number[1] + "\n 3. Both ");
                    arrayCall = input.nextInt();

                    switch (arrayCall){
                        case 1:
                            number [0] = number [0];//makes the first number static and will only ask the user to input one number
                            break;
                        case 2:
                            number [1] = number [1];//makes the second number static and will only ask the user to input one number
                            break;
                        case 3: //makes both numbers the same and will only ask the user to input a different operator
                            number [0] = number [0];
                            number [1] = number [1];
                            break;
                        default:
                            System.out.print(" You have entered an invalid input. Please enter a number 1-3. ");//if the user doesn't enter a number between 1-3, it will loop asking the user to enter a correct input
                            arrayCall = input.nextInt();
                    }
                }
                while (arrayAccess != 'y' && arrayAccess != 'n')//loops when the user enters a something that is not y or n
                {
                    System.out.print(" You have entered an invalid character. Please input y for yes or n for no. ");//asks user to reenter y or n
                    arrayAccess = input.next().charAt(0);
                }
            }

        }while(option == 'y');//loops the simple calculator if the user enters y and wants to use it again

        if (option == 'n')//if the user enters n, the program will display this message and end
        {
            System.out.println(" Bye! ");
        }

        //feedback
        System.out.print(" Did you enjoy my program, enter y for yes and n for no. ");//asks user to enter y or n depending on what the user thought about the program
        feedback = input.next().charAt(0);

        do{
            if (feedback == 'y')//if user enters y, this will show
                System.out.println(" Thank you and have a nice day! ");
            else if (feedback == 'n')//if user enters n, this will show
                System.out.println(" I appreciate the feedback and have a nice day. ");
        }while (feedback != 'y' && feedback != 'n');//loops if the user enters something that isn't y or n
    }

    //methods
    public static void introductoryMessage()//beginning message to introduce the user to this program
    {
        System.out.println(" This application is a simple calculator containing the operators +, -, *, /. ");
    }

    public static double addition(double []number)//if user wants to add, the program will call this method
    {
        double answer;
        answer = number[0] + number[1];//adds the numbers inputted
        return answer;
    }

    public static double subtraction(double []number)//if user wants to subtract, the program will call this method
    {
        double answer;
        answer = number[0] - number[1];//subtracts the numbers inputted
        return answer;
    }

    public static double multiplication(double []number)//if user wants to multiply, the program will call this method
    {
        double answer;
        answer = number[0] * number[1];//multiplies the numbers inputted
        return answer;
    }

    public static double division(double []number)//if user wants to divide, the program will call this method
    {
        double answer;
        answer = number[0] / number[1];//divides the numbers inputted
        return answer;
    }
}

