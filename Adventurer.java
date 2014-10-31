import java.util.Random;

public class Adventurer {
    private String name;
    private int HP, Str, Intelligence, Dex;
    Random rand = new Random();
    
    public void setStr(int Str){
	this.Str = Str;
    }

    public int getStr(){
	return Str;
    }

    public int getDex(){
	return Dex;
    }

    public int getInt(){
	return Intelligence;
    }


    public void setInt(int Intelligence){
	this.Intelligence = Intelligence;
    }

    public void setDex(int Dex){
	this.Dex = Dex;
    }


    public String  getName(){
	return name;
    }

    public void setName(String name){
	this.name = name;
    }

    public int getHP(){
	return HP;
    }

    public void setHP(int HP){
	this.HP = HP;
    }

    public Adventurer(){
	setName("Lester");
	setHP(20);
	setInt(1);
	setDex(1);
	setStr(1);
    }

    public Adventurer(String name){
	setName(name);
	setHP(20);
	setInt(1);
	setDex(1);
	setStr(1);
    }

    public Boolean hit(){
	Double x = rand.nextDouble();
	if (x  >= .35){
	    return true;
	}
	else{ 
	    return false;
	}
    }
     
    public String getStats(){
	return getName() + " " + getHP() + "HP";
    }



     public void attack(Adventurer other){// other = opponent
	 if(hit()){
	     int y = rand.nextInt(3) + 1;
	     other.setHP((other.getHP()) - y);
	     System.out.println(getName() + " blows raspberries at " + other.getName() + " for " + y + " damage");
	 }
	 else{
	     System.out.println( getName() +  " blows raspberries at " + other.getName() + " and misses, dealing 0 damage");
	 }
     }

	 
    public void specialAttack(Adventurer other){
	int y = rand.nextInt(5) + 1;
	if(hit()){
	    other.setHP((other.getHP()) - y);
	    System.out.println( getName() + " throws racial slurs at " + other.getName() + " for " + y + " damage");
	}
	else{
	    System.out.println(getName() + " throws racial slurs at " + other.getName() + " but falls on deaf ears! Instead, ");
	    attack(other);
	}
    }
}
