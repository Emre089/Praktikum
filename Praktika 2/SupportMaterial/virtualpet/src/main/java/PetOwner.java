/**
 * in this class the owner and the individual functions are defined
 */

public class PetOwner {
    private final String name;
    private final Pet firstPet;
    private final Pet secondPet;

    /**
     * Constructor for the PetOwner.
     * @param name name of the owner
     * @param firstPet the first pet
     * @param secondPet the second pet
     */

    public PetOwner(String name, Pet firstPet, Pet secondPet) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Name darf nicht null oder leer sein");
        if (firstPet == null)
            throw new IllegalArgumentException("Pet1 Darf nicht null sein");

        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = secondPet;
    }

    /**
     * Constructor for the PetOwner WITHOUT the second pet.
     * @param name name of the owner
     * @param firstPet the first pet (in this case there is only one)
     */
    public PetOwner(String name, Pet firstPet) {
        this(name, firstPet, null);
    }

    /**
     * Copy constructor that works by deep copy.
     * you don't directly copy first/(second)Pet from the other one, but you create a new Pet
     * the new pet uses its own copy constructor to then copy the other pet
     * @param other other PetOwner
     */
    public PetOwner(PetOwner other) {
        if (other == null) {
            throw new IllegalArgumentException("Anderer Owner Darf nicht null sein!");
        }
        this.name = other.name;
        this.firstPet = new Pet(other.firstPet);
        this.secondPet = other.secondPet != null ? new Pet(other.secondPet) : null; //wenn other.secondpet = null, dann das hier auch
    }

    //Getter (setters don't make sense, since all variables are final, unchangeable).
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public Pet getFirstPet() {
        return firstPet;
    }

    /**
     * @return return getSecondPet
     */
    public Pet getSecondPet() {
        return secondPet;
    }

    //methods
    /**
     * looks if two instances are identical.
     * @param other other instance
     * @return true if identical, false if not
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (getClass() != other.getClass()) // Comparing classes handling errors
            return false;

        PetOwner otherPetOwner = (PetOwner) other; //cast

        //Compare attributes
        if (!name.equals(otherPetOwner.getName())) {
            return false;
        }
        if (!firstPet.equals(otherPetOwner.firstPet)) {
            return false;
        }
        if (secondPet == null) { //Falls Secondpet null ist:
            return otherPetOwner.secondPet == null; // secondpet = null
        } else return secondPet.equals(otherPetOwner.secondPet);
    }

    /**
     * @return Petowner + pets
     */
    @Override
    public String toString() {
        return String.format("%s\n-\t%s\n-\t%s", name, firstPet.toString(), secondPet != null ? secondPet.toString() : "none");
    }

    /**
     * taking care of only one pet
     */
    public void takeCareOfPet(Pet pet) {
        if (pet.getHungriness() >= pet.getSleepiness() && pet.getHungriness() >= pet.getSadness()) {
            pet.eat(); //essen wenn Hungriness am größten
        } else if (pet.getSleepiness() >= pet.getHungriness() && pet.getSleepiness() >= pet.getSadness()) {
            pet.sleep(); //schlafen wenn Sleepiness am größten
        } else {
            pet.play(); //Spielen wenn die obigen beiden nicht zutreffen
        }
    }

    /**
     * Taking care of both pets
     */
    public void takeCareOfPets() {
        takeCareOfPet(firstPet);

        if (secondPet != null) {
            takeCareOfPet(secondPet);
        }
    }

}
