
public class Pet{

private String name;
private PetType type;
private int happiness;
private int hungriness;
private int sleepiness;

/**
 * Konstruktor für die Klasse Pet
 * @param name
 * @param type
 */
public Pet(String name, PetType type){
    this.name = name;
    this.type = type;

    if(name == null || name.isEmpty()){
    throw new IllegalArgumentException("name must not be null");
    }
    if(type == null){
        throw new IllegalArgumentException("type must not be null");
    }
}

/**
 * Copy Konstruktor für die Klasse Pet
 * @param other
 */
// Copy Konstruktor
public Pet(Pet other){
    
}

/**
 *  Getters
 *
 */
public String getName(){
    return name;
}
public PetType getType(){
 return type;   
}

public int getHappiness() {
    return happiness;
}

public int getHungriness() {
    return hungriness;
}
public int getSleepiness(){
    return sleepiness;
}

/**
 * Sadness kann nur durch dwn Parameter happiness berechnet werden.
 * 
 */
public int getSadness() {
    return 10 - happiness;
}


/**
 * Method for checking if the pet is sad
 * @return false
 */
public boolean isSad(){
    if(happiness <= 2){
        return true;
    }
    return false;
}
/**
 * Method for checking if the pet is happy
 * @return true;
 */
public boolean isHappy(){
    if(happiness >= 8){
        return true;
    }
    return false;
}

public int changeHappiness(int change){
    happiness = change + happiness;
    return happiness;
}

public int changeHungriness(int change){
    hungriness = change + hungriness;
    return hungriness;
}
public int changeSleepiness(int change){
    sleepiness = change+ sleepiness;
    return sleepiness;
}

public void play(){

}
public void eat(){

}
public void sleep(){

}
/**
 * Equals Methode in der zwei Obekte nach Gleichheit überprüft werden
 * @return false
 */
@Override
public boolean equals(Object other){

    if(this == other){

    }

    return false;
}

/**
 * toString Methode
 * @return name
 */
public String toString(){
    return name;
    }

}