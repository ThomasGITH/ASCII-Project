public class Attacks extends Combat{
  	public static String snowManGuy;
    static int potion;
    static boolean invincibility = false;

    //PLAYER ATTACKS AND CHANCES
    public static void enemyChoice1()
    {
      if (skipMonsterIntro == true)
      {
      	  enemyChoiceFrame();
      }
      snowManGuy = scanner.nextLine();
      switch (snowManGuy)
      {
        case "A" : case "a" :
        enemyFrame1Intimidate();
        ASCIIdeclaration.sleep(1000);
        intimidationAnimation();
        int random = (int )(Math.random() * 100 + 1);
          if (random < 60) //80 normaal
          {
            enemy1Fail();
            ASCIIdeclaration.sleep(3000);
          }
          else
          {
            enemy1Succeed();
            scaredOff = true;
            ASCIIdeclaration.sleep(3000);
          }
        break;
        case "B" : case "b" :
        enemyframe1RockThrow();
        ASCIIdeclaration.sleep(2000);
        int randomRock = (int )(Math.random() * 100 + 1);
          if (randomRock < 40)
          {
            enemy1RockThrowFail();
            ASCIIdeclaration.sleep(3000);
          }
          else if (randomRock > 55)
          {
        	monsterHealth -= 25;
            int addDamageRockthrow = (int )(Math.random()* 10 + 1);
            monsterHealth -= addDamageRockthrow;
        	if (monsterHealth < 0)
        	{
        		monsterHealth = 0;
        	}
            enemy1RockThrowSucceed();
            ASCIIdeclaration.sleep(3000);
          }
          else
          {
            enemy1RockThrowFail2();
            ASCIIdeclaration.sleep(3000);
          }
        break;
        case "C" : case "c" :
        EnemyGunner();
        ASCIIdeclaration.sleep(2000);
        int randomGun = (int )(Math.random() * 100 + 1);
          if (randomGun < 33)
          {
            enemy1GunFail();
            ASCIIdeclaration.sleep(3000);
          }
          else if (randomGun > 50) //70 normaal
          {
        	monsterHealth -= 50;
            int addDamageBullets = (int )(Math.random()* 20 + 1);
            monsterHealth -= addDamageBullets;
        	if (monsterHealth < 0)
        	{
        		monsterHealth = 0;
        	}
            enemy1GunSucceed();
            ASCIIdeclaration.sleep(3000);
          }
          else
          {
            enemy1GunFail2();
            ASCIIdeclaration.sleep(3000);
          }
        break;
        case "D" : case "d" :
        kys();
        ASCIIdeclaration.sleep(2000);
        int kysRandom = (int )(Math.random() * 100 + 1);
          if (kysRandom < 25)
          {
            health -= 15;
            int addDamageFootknife = (int )(Math.random()* 10 + 1);
            health = health - addDamageFootknife;
        	if (health < 0)
        	{
        		health = 0;
        	}
            kysFail();
            ASCIIdeclaration.sleep(3000);
          }
          else if (kysRandom > 50)
          {
            health -= 105;
        	if (health < 0)
        	{
        		health = 0;
        	}
            kysSucceed();
            ASCIIdeclaration.sleep(3000);
          }
          else
            {
        	  monsterHealth -= 35;
              int addDamageFootknife = (int )(Math.random()* 10 + 1);
              monsterHealth = monsterHealth - addDamageFootknife;
          	  if (monsterHealth < 0)
          	  {
          		  monsterHealth = 0;
          	  }
              kysFail2();
              System.out.println(health);
              ASCIIdeclaration.sleep(3000);
            }
        break;
        case "E" : case "e" :
        if (potion > 0)
        {
        	health = health +40;
        	if (health > 100)
        	{
        		health = 100;
        	}
        	potion = potion -1;
        	drinkPotion();
            ASCIIdeclaration.sleep(3000);
        }
        else
        {
        	noPotion();
            ASCIIdeclaration.sleep(3000);
        }
        break;
        case "pause":
        	Menu();
        	enemyChoice1();
        	break;
        case "save":
        	SaveLoad.saveGame();
        	enemyChoice1();
        	break;
        case "load":
        	SaveLoad.loadGame();
        	break;
        case ("FULLHEALTH"):
        	health = 100;
        	break;
        case "KILLENEMY":
        	monsterHealth = 0;
        	break;
        case "KYS":
        	health = 0;
        	break;
        case "POTIONMAX":
        	potion = 999;
        	break;
        case "INVINCIBILITY TRUE":
        	invincibility = true;
        	System.out.println("Enabled invincibility");
            ASCIIdeclaration.sleep(1500);
        	break;
        case "INVINCIBILITY?":
        	if (invincibility == true) {
        		System.out.println("Invincibility is active");
                ASCIIdeclaration.sleep(1500);
            	enemyChoice1();
        	}
        	else {
        		System.out.println("Invincibility is off");
                ASCIIdeclaration.sleep(1500);
            	enemyChoice1();
        	}
        	break;
        case "INVINCIBILITY FALSE":
        	invincibility = false;
        	System.out.println("Disabled invincibility");
            ASCIIdeclaration.sleep(1500);
        	enemyChoice1();	//<--- NEW AND UNSURE CHOICE, IF AN ERROR IS FOUND THIS MAY BE THE CAUSE
        	break;
        case "RESETC":
        	if (potion >= 50)
        	{
        	potion = 1;
        	}
        	invincibility = false;
        	System.out.println("Terminated all active cheats");
            ASCIIdeclaration.sleep(1500);
        	break;
        default :
        System.out.println("Not found: '" + snowManGuy + "'");
        ASCIIdeclaration.sleep(3000);
        enemyChoice1();
        break;
      }
    }

}
