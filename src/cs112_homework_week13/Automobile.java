/* Objective:   2.  Create an Automobile classes that allow the users to create an automobile with the following attributes
 *                  a.    Year, Make, Model, Color, Name, Number of Gears
 *                  b.    Operating cycle (1,2,3,4,5……) which can be incremented or set by user
 *                  c.    Current gear, which is set to Operating cycle (max out at Number of Gears)
 *                  d.    Current speed (current gear * 10)
 *                  e.    Distance travel  (cumulative, each operating cycle’s distance = current speed/60)
 */
package cs112_homework_week13;

public class Automobile 
{
    // Requested attributes for class Automobile are created
    private int Year = 0;
    private String Make = "CarMaker";
    private String Model = "CarModel";
    private String Color = "CarColor";
    private String Name = "CarName";
    private int Gears;
    
    private int OperatingCycle = 0;
    private int CurrentGear = 0;
    private int CurrentSpeed = 0;
    private int DistanceTraveled = 0;
    private int DistanceTraveledEachCycle = 0;
    
    // Creating constructor to make assigning initial value easy in main method
    public Automobile (int gear, int cycle)
    {
        Gears = gear;
        OperatingCycle = cycle;
    }
    
    // Declare variables to hold 3 different types of sound
    private String SoundInitial     = "Prrr~~.  "; // When the total distance traveled is less than 10 miiles.
    private String SoundCruising    = "Vroom~.  "; // When the total ditance travled is 10 or more miles and same or less than 100 miles.
    private String SoundBlew        = "Sputter! "; // When the total distance traveled is more 100 miles.
    // Declare variables to hold sound of a vehicle based on distance it traveled.     
    private String Sound            = "Idling...";
    // This method sound will send a propriate sound of a vehicle based on distance it has traveled.
    // This method setSound is set method 
    // Variable Sound is initialized to store WhatSound from main method.
    public void setSound (int TotalDistanceTraveled)
    {
        if (TotalDistanceTraveled <10)
        {
            Sound = SoundInitial; // Making Prrr sound if total distance traveled is less than 10.
        }
        else
        {
            if (TotalDistanceTraveled <= 100)
            {
                Sound = SoundCruising; // Making Vroom sound if total distance travled is same or less than 100.
            }
            else
            {
                Sound = SoundBlew; // Making Sputter if total distance traveled is more than 100.
            }
        }
    }
    // This method getSound is get method
    // This method will return Sound to main method
    public String getSound ()
    {
        return Sound;
    }
    
    
     
    
    
    
    

    // this method whatIsGear will receive a number of gears an user wants to define
    // this is a get method which receives a value and assign it to instance variable Gears
    // this method whatIsGear is not needed anymore since constructor would be used to initialize a value to an attribute, variable of Gears
    public int whatIsGear (int WhatIsGear)
    {
        Gears = WhatIsGear;
        return Gears;
    }
    
    // this method setOperatingCycle will receive a number of operating cycle set by user
    // this method setOperatingCycle is not needed anymore 
    //      since constructor would be used to initialize a value to an attribute, variable of OperatingCycle
    public int setOperatingCycle (int WhatIsOperatingCycle)
    {
        OperatingCycle = WhatIsOperatingCycle;
        return OperatingCycle;
    }
    
    
    // this method setCurrentGear will calculate a current gear possible for a vehicle
    // simply put, CurrentGear should be either (same or lower than variable Gears) or (same as a varialbe OperatingCycle)
    public int setCurrentGear (int ChangingGear)
    {
        if (0 >= ChangingGear)
        {
            CurrentGear = 0;
        }
        else
        {
            if (Gears >= ChangingGear)
            {
                CurrentGear = ChangingGear;
            }
            else
            {
                CurrentGear = Gears;
            }
        }
        return CurrentGear;
    }
    
    // this method setCurrentSpeed will set a current speed
    public int setCurrentSpeed (int CurrentGear)
    {
        // method setCurrentGear is embedded in method setCurrentSpeed
        // or method setCurrentGear needs to be called in main method each time before method setCurrentSpeed is called
        CurrentSpeed = CurrentGear * 10;
        return CurrentSpeed;
    }
    
    
    // this method setDistanceTraveld will calculate a total distance a vehicle traveled within the operating cycle
    public int setDistanceTraveled ()
    {
        for (int Count = 0; Count < OperatingCycle+1; Count++)
        {
                // First, method setCurrentGear is called with required argument of changing gear which is variable Count. 
                //      It will return CurrentGear.
                //      Method setCurrentGear is maxed at a number of gears given to a vehicle.
                // Second, method setCurrentSpeed is called with required argument of current gear which is variable CurretGear. 
                //      It will return CurrentSpeed, which is same as a distance for a cycle.
                // For loop will repeat calculating distance traveled for a cycle and accumulate the distance 
                //      as many as the operating cycle provided.
                DistanceTraveled = DistanceTraveled + setCurrentSpeed(setCurrentGear(Count)) ;
        }
        return DistanceTraveled;
    }
    
    // This method will call method setCurrentGear and setCurrentSpeed to calculate a total distance it traveled each cycle
    //      and return the total distance it raveled each cycle
    public int setDistanceTraveledNoLoop (int Count)
    {
         DistanceTraveledEachCycle = setCurrentSpeed(setCurrentGear(Count)) ;
         return DistanceTraveledEachCycle;
    }
}
