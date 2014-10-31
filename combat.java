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
		}
		indexOfPlayers ++;
	    }
	    indexOfPlayers = 0;
	}
    }
