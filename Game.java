import java.util.*;

public class Game{
    public static void main(String[]args){
  	
	Scanner choice = new Scanner(System.in);
	System.out.println("Choose the letter that represents your class:\n");
	System.out.println("A : Warrior\n");
	System.out.println("B : Wizard\n");
	System.out.println("C : Rogue\n");
	String theirChoice = choice.nextLine();




	while(!theirChoice.equals("A") && !theirChoice.equals("B") && !theirChoice.equals("C")){
	    System.out.println("Please type A for Warrior, B for Wizard, and C for Rogue.");
	    theirChoice = choice.nextLine();
	}
 
	if(theirChoice.equals("A")){
	    Adventurer player = new Warrior();
	    Adventurer opponent = new Adventurer();
	    System.out.println("You picked A, warrior.");
	    System.out.println("You will be facing " + opponent.getName());
	    while(player.getHP() > 0){
		if(opponent.getHP() <= 0){
		    player.setHP(0);
		    System.out.println("Well done! You've won.");
		}
		else{

		    Scanner option = new Scanner(System.in);
		    System.out.println();
		    System.out.println(opponent.getStats());
		    System.out.println(player.getStats());
		    System.out.println("A : attack");
		    System.out.println("S : special attack");
		    System.out.println("G : give up");
		    String theirOption = option.nextLine();

		    if(theirOption.equals("A")){
			player.attack(opponent);
			opponent.attack(player);

		}
		    if(theirOption.equals("S")){
			player.specialAttack(opponent);
			opponent.specialAttack(player);

		}
		    if(theirOption.equals("G")){
			player.setHP(0);
			System.out.println("You have given up the game.");
		    }
		}	    
	    }   
	}
	

	if(theirChoice.equals("B")){
	    Adventurer player = new Wizard();
	    System.out.println("You picked B, wizard.");
	    Adventurer opponent = new Adventurer();
	    System.out.println("You will be facing " + opponent.getName());
	    while(player.getHP() > 0){
		if(opponent.getHP() <= 0){
		    player.setHP(0);
		    System.out.println("Well done! You've won.");
		}
		else{

		    Scanner option = new Scanner(System.in);
		    System.out.println(opponent.getStats());
		    System.out.println(player.getStats());
		    System.out.println("A : attack");
		    System.out.println("S : special attack");
		    System.out.println("G : give up");
		    String theirOption = option.nextLine();

		    if(theirOption.equals("A")){
			player.attack(opponent);
			opponent.attack(player);

		}
		    if(theirOption.equals("S")){
			player.specialAttack(opponent);
			opponent.specialAttack(player);

		}
		    if(theirOption.equals("G")){
			player.setHP(0);
			System.out.println("You have given up the game.");
		    }
		}	    
	    }

	}


	if(theirChoice.equals("C")){
	    Adventurer player = new Rogue();
	    System.out.println("You picked C, rogue.");
	    Adventurer opponent = new Adventurer();
	    System.out.println("You will be facing " + opponent.getName());
	    while(player.getHP() > 0){
		if(opponent.getHP() <= 0){
		    player.setHP(0);
		    System.out.println("Well done! You've won.");
		}
		else{

		    Scanner option = new Scanner(System.in);
		    System.out.println(opponent.getStats());
		    System.out.println(player.getStats());
		    System.out.println("A : attack");
		    System.out.println("S : special attack");
		    System.out.println("G : give up");
		    String theirOption = option.nextLine();

		    if(theirOption.equals("A")){
			player.attack(opponent);

		}
		    if(theirOption.equals("S")){
			player.specialAttack(opponent);

		}
		    if(theirOption.equals("G")){
			player.setHP(0);
			System.out.println("You have given up the game.");		    }
		}
	    }
	}  
    }



}

   
    

