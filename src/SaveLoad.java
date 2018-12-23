

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad extends ASCIIart{

	  public static void saveGame()
	  {
			      varData e = new varData();
			      e.saveHealth = Combat.health;
			      e.savePotions = Attacks.potion;
			      e.saveSteps = ASCIIdeclaration.steps;
			      e.saveMonsterHealth = Combat.monsterHealth;
			      
			      try {
			         FileOutputStream fileOut = new FileOutputStream("src/Saves/save.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(e);
			         out.close();
			         fileOut.close();
			         System.out.printf("Saved game");
			      } catch (IOException i) {
				     System.err.println("ERROR: Unable to create save file. Please check whether Java has permission to create save file, or try running Eclipse as Administrator.");
			         i.printStackTrace();
			      }
			      
			      ASCIIdeclaration.sleep(1500);
			      
	  }
	  
	  public static void loadGame()
	  {
			      varData e = null;
			      try {
			         FileInputStream fileIn = new FileInputStream("src/Saves/save.ser");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         e = (varData)
			         in.readObject();
			         in.close();
			         fileIn.close();
			      } catch (IOException i) {
			         System.err.println("ERROR: No save file found");
			         ASCIIgame.Choose();
			         return;
			      } catch (ClassNotFoundException c) {
			    	  c.printStackTrace();
			         return;
			      } 
			      
			      Combat.health = e.saveHealth;
			      Attacks.potion = e.savePotions;
			      ASCIIdeclaration.steps = e.saveSteps;
			      Combat.monsterHealth = e.saveMonsterHealth;
			      
			      ASCIIgame.skipReset = true;
			      ASCIIdeclaration.loadFight = true;
			      Combat.skipMonsterIntro = true;
			      System.out.println("Loading your data..");

			      ASCIIdeclaration.sleep(2000);
			      ASCIIdeclaration.walkMain();
			      

	  }
}
