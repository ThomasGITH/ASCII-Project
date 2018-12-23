

public class ASCIIgame extends ASCIIdeclaration
{
  ASCIIdeclaration object = new ASCIIdeclaration();

  static boolean keepOnPause = true;
  
//ENTRY POINT OF THE APPLICATION
  public static void main(String[]args)
  {
    welcomeMessage();
    Menu();
  }
  
//MAIN-MENU OPTIONS CALLED FROM HERE
  public static void Choose()
  {
  	keepOnPause = true;
  	
	if (keepOnPause = true) {
    String menuInput = scanner.nextLine();
    switch (menuInput)
    {
    case "A" : case "a" : 
    skipReset = false;
    walkMain();
    break;
    case "B" : case "b" : saveGame();
    Choose();
    break;
    case "C" : case "c" : loadGame();
	break;
    default :
    Menu();
    case "pause" : keepOnPause = false;
    break;
    }
   }
  }
}
