

public class EnemyAttacks extends SaveLoad{
    public static void monsterTurn()
    {	
    	for(int b=0; b<3;b++) {
        monsterAttackAnimation();
        ASCIIdeclaration.sleep(300);
        monsterAttackAnimation2();
        ASCIIdeclaration.sleep(300);

    	}
        int monsterAttackDecision = (int )(Math.random() * 100 + 1);
        if (monsterAttackDecision < 25)
        {
          Combat.health = Combat.health -25;
          int addDamageBite = (int )(Math.random()* 15 + 1);
          Combat.health = Combat.health - addDamageBite;
          if (Combat.health < 0)
          {
        	  Combat.health = 0;
          }
          monsterAttack1();
          ASCIIdeclaration.sleep(3000);
        }
        else if (monsterAttackDecision > 75)
        {
        	Combat.health = Combat.health -15;
          int addDamageDisrespect = (int )(Math.random()* 15 + 1);
          Combat.health = Combat.health - addDamageDisrespect;
          if (Combat.health < 0)
          {
        	  Combat.health = 0;
          }
          monsterAttack2();
          ASCIIdeclaration.sleep(3000);
         
        }
        else
        {
          monsterNoAttack();
          ASCIIdeclaration.sleep(3000);
        }
        
    }
}
