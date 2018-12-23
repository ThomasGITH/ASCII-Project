
import java.util.Scanner;

public class ASCIIdeclaration extends Attacks implements java.io.Serializable
{	
  static Scanner scanner = new Scanner(System.in);
  static boolean againSnowManGuy;
  static boolean allowCheats;
  static boolean loadFight = false;
  static boolean skipReset = false;
  static int steps = 50;

//WALKING AND RANDOM CHANCE OF ENEMY ENCOUNTER BY EVERY 2 STEPS
static int i;
public static void retry()
{
	skipReset = false;
    String retry = scanner.nextLine();
    switch (retry)
    {
    case "A" : case "a" : walkMain();
    break;
    default :
    }
}

  public static void walkMain()
  { 
	if (skipReset == false)
	{
		steps = 50;
		health=100;
	  	monsterHealth=100;
	  	potion = 0;
	    i=0;
	    instructions();
	    String proceed = scanner.nextLine();
	    if (proceed.equals(""))
	    {}
	    else
	    {
	        walkMain();
	    }
	}
    
    while ((health > 0) && (steps > 0))
    {
      i += 1;
      steps -= 1;
      
     if(i<50)
     {
      System.out.println(steps);
      	scaredOff = false;
       if (skipReset == false)
       {
        WalkRight();
        skipMonsterIntro = false;
        monsterHealth = 100;
        sleep(350);
        walkLeft();
        sleep(350);
       }
        int potionChance = (int )(Math.random() * 100 + 1);
        if ((potionChance < 10) && (loadFight == false))
        {
        	potionFound();
        	potion += 1;
        	sleep(3000);
         }
     }
        int random = (int )(Math.random() * 100 + 1);
        if ((random < 15) || (loadFight == true))
        {
        	if (skipMonsterIntro == false)
        	{
            	//WHICH STARTING FRAME WILL THE CREATURE HAVE?
            	int creatureRandom = (int )(Math.random() * 100 + 1);
            	if ((creatureRandom < 33) && (scaredOff == false))
            	{
            		enemyAppearance1();
            	}
            	else if ((creatureRandom > 66) && (scaredOff == false))
            	{
            		enemyAppearance2();
            	}
            	else
            	{
            		if (scaredOff == false) {
            			enemyAppearance3();
            		}
            	}
        	}
            	combatSystem();
            	loadFight = false;
        }
       
    }
    
    //WIN AND DEATH SCREEN
    if (health > 0)
    {
      winScreen();
      retry();
    }

    else
    {
    	deathScreen();
    	retry();
    }
        
   }
    
  public static void sleep(int duration) {
      try
      {
        Thread.sleep(duration);
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
  }


}

