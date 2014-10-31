import java.util.*;

public class Stuyablo2{
    public static void main(String[]args){
	Adventurer player, opponent, a, b, c, d;
	player = null;
	player = makeAdventurer(player);
	opponent = new Warrior();
	setUpTeam(player, opponent);

    }

    public static Adventurer makeAdventurer(Adventurer player){
	player = makeClass(player);
	InitiatePoints(player);
	return player;
    }

    public static void setUpTeam(Adventurer player, Adventurer opponent){
	Adventurer a, b, c, d;
	a= null;
	b = null;
	c = null;
	d = null;
	System.out.println("How many teammates would you like? You can have zero to three teammates. Please enter a number.");
	Scanner choice = new Scanner(System.in);
	int numPlayers = choice.nextInt();
	Adventurer[]players=new Adventurer[numPlayers+1];
	players[0] = player;
	int whichCharacter = 1;
	while(whichCharacter <= numPlayers){
	    System.out.println("Select a class for teammate " + whichCharacter+".\n");
	    System.out.println("A for Warrior, B for Wizard, C for Rogue\n");
	    String YoCharacter = choice.nextLine();
	    System.out.println(YoCharacter);
	    if(YoCharacter.equalsIgnoreCase("A")){
		players[whichCharacter] = new Warrior();
		whichCharacter ++;
		
	    }
	    else if(YoCharacter.equalsIgnoreCase("B")){
		players[whichCharacter] = new Wizard();
		whichCharacter ++;
	    }
	    else if(YoCharacter.equalsIgnoreCase("C")){
		players[whichCharacter] = new Rogue();
		whichCharacter++;
	    }
	    else{
	   	System.out.println("You have entered invalid information, please try again. Starting from player " + whichCharacter);
	    }
	}
	Combat(players, opponent);
    }

    public static void Combat(Adventurer[] friendlies, Adventurer opponent){
	int numberOfPlayers = friendlies.length;
	int[] playerHealth = new int [numberOfPlayers];
	int totalHealth = 0;
	int indexOfPlayers = 0;
	for(int i = 0; i<numberOfPlayers;i++){
	    playerHealth[i] = friendlies[i].getHP();
	    totalHealth += playerHealth[i];
	}

	while(totalHealth > 0 && opponent.getHP() > 0){
	    while(indexOfPlayers < numberOfPlayers){
		if(friendlies[indexOfPlayers].getHP() > 0){
		    System.out.println("What would " + friendlies[indexOfPlayers].getName() + " like to do?");
		    System.out.println("\nA : Attack\nS : Special Attack \nG : Give up");
		    Scanner choice = new Scanner(System.in);
		    String theirChoice = choice.nextLine();
		    if(theirChoice.equalsIgnoreCase("A")){
			friendlies[indexOfPlayers].attack(opponent);
			if(opponent.getHP() <=0){
			    System.out.println("Congratulations! You won.");
			    break;
			}
			else{
			    System.out.println("Opponent " + opponent.getStats());
			    opponent.attack(friendlies[indexOfPlayers]);
			    System.out.println(friendlies[indexOfPlayers].getStats());
			    totalHealth = totalHealth - (playerHealth[indexOfPlayers]-friendlies[indexOfPlayers].getHP());
			}
		    }
		    else if(theirChoice.equalsIgnoreCase("S")){
			friendlies[indexOfPlayers].specialAttack(opponent);
			if(opponent.getHP() <=0){
			    System.out.println("Congratulations! You won.");
			    break;
			}
			else{
			    System.out.println("Opponent " + opponent.getStats());
			    opponent.specialAttack(friendlies[indexOfPlayers]);
			    System.out.println(friendlies[indexOfPlayers].getStats());
			    totalHealth = totalHealth-(playerHealth[indexOfPlayers]-friendlies[indexOfPlayers].getHP());
			}
		    }
		    else if(theirChoice.equalsIgnoreCase("G")){
			friendlies[indexOfPlayers].setHP(0);
			totalHealth = totalHealth - playerHealth[indexOfPlayers];
		    }
		}
		indexOfPlayers ++;
	    }
	    indexOfPlayers = 0;
	}
	again(friendlies,playerHealth,opponent);
    }

    public static void again(Adventurer friendlies[], int theirHealth[], Adventurer opponent){
	System.out.println("\nWould you like to fight again? Y/N");
	Scanner choice = new Scanner(System.in);
	String theirChoice = choice.nextLine();
	if(theirChoice.equalsIgnoreCase("Y")){
		for(int i = 0; i<friendlies.length;i++){
		    friendlies[i].setHP(theirHealth[i]);
		    System.out.println(friendlies[i].getStats()+"\n");
		}
		opponent.setHP(50);
		Combat(friendlies, opponent);
	}
	else{
	    System.out.println("\nThanks for playing!");
	}
    }


	    


 
    public static void InitiatePoints(Adventurer player){//start off with 27
	player.setInt(1);
	player.setDex(1);
	player.setStr(1);
	Scanner choice = new Scanner(System.in);
	int pointsLeft = 27;
	int pointsAssigned = 0;
	int whichStat = 0;
	while(pointsAssigned < 27){
	    System.out.println("You have " + pointsLeft + " points to assign to STR, INT, and DEX.\n");
	    if(whichStat == 0){// in order of STR -> INT -> DEX
		System.out.println("Assign how many points to STR?\n");
		int theirChoice = choice.nextInt();
		if(theirChoice <= pointsLeft && theirChoice >= 0){
		    pointsAssigned += theirChoice;
		    pointsLeft = pointsLeft - theirChoice;
		    whichStat ++;
		    player.setStr(player.getStr()+theirChoice);
		    System.out.println("Assigned " + theirChoice + " points to STR. You now have " + player.getStr() + " STR.\n");
		    System.out.println("You have assigned " + pointsAssigned + " out of 27 points.\n");
		}
		else{
		    System.out.println("Sorry, you have entered an invalid number. Please try again. \n");
		}
	    }
	    else if(whichStat == 1){
		System.out.println("Assign how many points to INT?\n");
		int theirChoice = choice.nextInt();
		if(theirChoice <= pointsLeft && theirChoice >= 0){
		    pointsAssigned += theirChoice;
		    pointsLeft = pointsLeft - theirChoice;
		    whichStat ++;
		    player.setInt(player.getInt()+theirChoice);
		    System.out.println("Assigned "+theirChoice+" points to INT. You now have " + player.getInt()+" INT.\n");
		    System.out.println("You have assigned " +pointsAssigned + " out of 27 points.\n");
		}
		else{
		    System.out.println("Sorry, you have entered an invalid number. Please try again.\n");
		}
	    }
	    else{
		System.out.println("Assign how many points to DEX?\n");
		int theirChoice = choice.nextInt();
		if(theirChoice <= pointsLeft && theirChoice >= 0){
		    pointsAssigned += theirChoice;
		    pointsLeft = pointsLeft - theirChoice;
		    player.setDex(player.getDex()+theirChoice);
		    System.out.println("Assigned "+theirChoice+" points to DEX. You now have "+player.getDex()+" DEX.\n");
		    System.out.println("You have assigned "+pointsAssigned+" out of 27 points.\n");
		}
		else{
		    System.out.println("Sorry, you have entered an invalid number. Please try again.\n");
		}
	    }
	}
	System.out.println("You have " + player.getStr() + " STR, " + player.getInt() + " INT, and " + player.getDex() + " DEX.\n");
    }


    public static Adventurer makeClass(Adventurer player){
	boolean x = false;
	Scanner choice = new Scanner(System.in);
	System.out.println("Welcome to Stuyablo!");
	System.out.println("Please select a class.\nA : Warrior\nB : Wizard\nC : Rogue\n");
	do{
	    String theirChoice = choice.nextLine();
	    //.equalsIgnoreCase()
	    if(theirChoice.equalsIgnoreCase("A")){
		player = new Warrior();
		x = true;
		System.out.println("Congratulations! You have chosen the warrior class.\n");
	    }
	    else if(theirChoice.equalsIgnoreCase("B")){
		player = new Wizard();
		x = true;
		System.out.println("Congratulations! You have chosen the wizard class.\n");
	    }
	    else if(theirChoice.equalsIgnoreCase("C")){
		player = new Rogue();
		x = true;
		System.out.println("Congratulations! You have chosen the rogue class.\n");
	    }
	    else{
		System.out.println("You have entered an invalid choice. Once again:\nA: Warrior\nB: Wizard\nC: Rogue\n");
	    }
	}while(x != true);
	System.out.println("Please enter a name for your character.\n");
	String theName=choice.nextLine();
	player.setName(theName);
	System.out.println("\nYour character's name is " + player.getName()+".\n");
	return player;
    }
}
