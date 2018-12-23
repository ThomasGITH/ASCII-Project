public class Combat extends EnemyAttacks{
	
	public static int health;
	public static int monsterHealth;
	public static boolean scaredOff;
	public static boolean skipMonsterIntro;
	  
	//TURN-BASED COMBAT-SYSTEM WHICH LOOPS UNTIL ONE PARTY HAS FAINTED
  	public static void combatSystem()
  	{
    	while ((monsterHealth > 0) && (health > 0) && (scaredOff == false))
    	{
    		Attacks.enemyChoice1();
    		if ((monsterHealth > 0) && (health > 0) && (scaredOff == false))
    		{
    			EnemyAttacks.monsterTurn();
    		}
    		if ((health <= 0) && (ASCIIdeclaration.invincibility == true))
    		{
    			health ++;
    		}
    		skipMonsterIntro = true;
        }
    	ASCIIdeclaration.skipReset = false;
  	}
}
