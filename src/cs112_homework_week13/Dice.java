/* Objective:   1. Create a Dice class with a static method that accepts number of dice to be thrown:
 *                  a. 1 dice will return 1-6
 *                  b. 2 dices will return 2-12
 *                  c. 3 dices will return 3-18
 *                  d. ....
 */
package cs112_homework_week13;

import java.util.Random;

public class Dice
{
    // public is access modifier making this class available to main class
    // static is to make this method available to other class without creating an object
    // int means that this method will return a value in int data type
    // GetANUmber is the name of the method given
    // (int HowManyDice) means that this method requires a value in int data type to perform
    public static int getARandomNumber(int HowManyThrow)
    {
        
        // a value as int HowManyDice would be processed and be assigned to the variable randomNumber
        // An initial value of 0 is given to the variable randomNumber
        int randomNumber = 0;
        
        // the following statements will calculate a random number by throwing a dice as many as requested
        // this for loop will repeat creating a random number and add up the random number       
        for (int Count = 0; HowManyThrow > Count; Count++)
        {
            randomNumber = (1 + (int) ( Math.random() * 6)) + randomNumber;
        }
        
        // Display the random number as a reference
        System.out.println("The random number is " + randomNumber);
        return randomNumber;
    }
}
 
