/* Project Name:    CS112_Homework_Week13
 * Objective:       1.  Read Chapter 10
 *                  2.  Re-implement Lab 5 using Java Inheritance
 *                  Lab05 Objective
 *                      Modify Lab 4 to
 *                          1. Add the ability to maintain and generate Automobile sound
 *                                  a.  Class variable
 *                                  b.  Set / Get method
 *                                  c.  Display sound as the race is progressing around the loop base on distance
 *                                          < 10: “Prrr”
 *                                          Else:“Vroom”
 *                          2.  Automobile will sound “Sputter…” if travel more than 100 miles. 
 *                          3.  Throw an exception when the automobile sputters
 *                          4.  Warn the user in the main loop that the race is in Yellow Flag
 * Programmer:      Elliot Kim
 * Date:            11/22/2016
 */
package cs112_homework_week13;

import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CS112_Homework_Week13 
{

    public static void main(String[] args) 
    {
        /*  Receive how many dice(s) user wants to throw and 
            put that random number generated into a variable OperatingCycle */
        // let's create scanner object
        Scanner input = new Scanner(System.in);
            
        // variable HowManyThrow in int data type will hold a value from user
        int HowManyThrow = 0;
        // variable RandomNumber in int data type will hold a value from static method getARandomNumber in class Dice
        int RandomNumber = 0;
        // variable OperatingCycleFromRandomNumber
        int OperatingCycleFromRandomNumber = 0;
        
        // This method is for week13_lab03 which the objectives are
        //                  1. Ask user how many dice to throw
        //                  2. Handle input exception
        try 
        {    
            // let me try to call the static method GetARandomNumber from class Dice without creating an object for it
            System.out.println("A ramdom number would be generated as you dictate how many dice(s) be thrown.\n"
            + "How many dice(s) do you want to throw?:");
            // Inputting a number of throws requested from user to variable HowManyThrow
            HowManyThrow = input.nextInt();
        }
        // An InputMismatchException occurs when Scanner method nextInt receives a String that does not represent a valid integer
        catch (InputMismatchException inputMismatchException) 
        {
            System.err.printf("The input must be an integer number\nGood By!", inputMismatchException);
        }
        // Implementing a method call to call static method GetARandomNumber from class Dice by supplying an argument required
        // Notice how I am not creating an object of class Dice since the method getARandomNumber is a static method
        RandomNumber = Dice.getARandomNumber(HowManyThrow);
                
        /* Testing class Automobile */
        // Creating objects of class Automobile
        // Demonstrating use of constructor initialzing value of how many gears each automobile has
        //      First argument, number of gears is given from professor
        //      Second argument, number of operating cycle is assigned by me
        Automobile Truck = new Automobile (3,10);
        Automobile Van = new Automobile (4,10);
        Automobile SportCar = new Automobile (6,10);
        
        // Assign the random number (now in RandomNumber) generated into variable OperatingCycle of automobile object
        //      by implementing method call of method setOperatingCycle from class Automobile
        Truck.setOperatingCycle(RandomNumber);
        Van.setOperatingCycle(RandomNumber);
        SportCar.setOperatingCycle(RandomNumber);
        
        // ================ This part of the programming is for CS112_Homework_Week13
        //      Declare variables to hold distance traveled for each vehicle
        int TotalDistanceTraveled_Truck     = 0;
        int TotalDistanceTraveled_Van       = 0;
        int TotalDistanceTraveled_SportCar  = 0;
        //      Putting for-loop to generate a sound until a vehicle reaches a distance of 100 miles.
        for (int Count = 1; Count < RandomNumber +1; Count ++)
        {
            TotalDistanceTraveled_Truck     = TotalDistanceTraveled_Truck + Truck.setDistanceTraveledNoLoop (Count);
            TotalDistanceTraveled_Van       = TotalDistanceTraveled_Van + Van.setDistanceTraveledNoLoop (Count);
            TotalDistanceTraveled_SportCar  = TotalDistanceTraveled_SportCar + SportCar.setDistanceTraveledNoLoop (Count);
            // method call to input distance traveled and receive correcponding sound
            Truck.setSound(TotalDistanceTraveled_Truck);
            System.out.println("Truck:     " + Truck.getSound() + "Distance traveled in cycle number " + Count + " is " + TotalDistanceTraveled_Truck); 
            // method call to input distance traveled and receive correcponding sound
            Van.setSound(TotalDistanceTraveled_Van);
            System.out.println("Van:       " + Truck.getSound() + "Distance traveled in cycle number " + Count + " is " + TotalDistanceTraveled_Van); 
            // method call to input distance traveled and receive correcponding sound
            SportCar.setSound(TotalDistanceTraveled_SportCar);
            System.out.println("Sport Car: " + Truck.getSound() + "Distance traveled in cycle number " + Count + " is " + TotalDistanceTraveled_SportCar);
            // Warn user the race is in yellow flag if any distance traveled of any car is over 100 miles and sputtered
            if (TotalDistanceTraveled_Truck > 100 || TotalDistanceTraveled_Van > 100 || TotalDistanceTraveled_SportCar > 100 )
            {
                System.out.println("The race is in yellow flag.\n");
            }
            else
            {
                System.out.println("\n");
            }
        }
        
        
        
        /* This method was for Exam 02
        // Putting for loop here, not in Automobile class
        //      method setDistanceTraveledNoLoop needs to be instantiated
        int TotalDistanceTraveled_Truck     = 0;
        int TotalDistanceTraveled_Van       = 0;
        int TotalDistanceTraveled_SportCar  = 0;
        for (int Count = 1; Count < RandomNumber+1; Count++)
        {            TotalDistanceTraveled_Truck     = TotalDistanceTraveled_Truck + Truck.setDistanceTraveledNoLoop (Count);
            TotalDistanceTraveled_Van       = TotalDistanceTraveled_Van + Van.setDistanceTraveledNoLoop (Count);
            TotalDistanceTraveled_SportCar  = TotalDistanceTraveled_SportCar + SportCar.setDistanceTraveledNoLoop (Count);
            
             System.out.println("A total distance the truck traveled in operating cycle No. " + Count + " is " + Integer.toString(TotalDistanceTraveled_Truck)
                            + "\nA total distance the van traveled in operating cycle No. " + Count + " is " + Integer.toString(TotalDistanceTraveled_Van)
                            + "\nA total distance the sport car traveled in operating cycle No. " + Count + " is " + Integer.toString(TotalDistanceTraveled_SportCar)
                            + "\n");
        }
        */
        
        System.out.println("Good Bye!");
        /*  // Calculate total distance the truck traveled // this is discarded because it is embeded  within the for loop
        System.out.println("A total distance the truck traveled in 10 operating cycle is " + Truck.setDistanceTraveled()
                            + "\nA total distance the van traveled in 10 operating cycle is " + Van.setDistanceTraveled()
                            + "\nA total distance the sport car traveled in 10 operating cycle is " + SportCar.setDistanceTraveled()
                            + "\n");    */
    }
}
