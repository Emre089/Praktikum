
public class VirtualPetMain{

    public static void Main(String[] args){
        Pet rosco = new Pet("Rosco", PetType.DOG);
        Pet morgana = new Pet("Morgana", PetType.CAT);
        Pet rabbit = new Pet("Rabbit of Caerbannog", PetType.RABBIT);

        System.out.println(rosco);
        System.out.println(morgana);
        System.out.println(rabbit);

        morgana.play();
        morgana.eat();
        morgana.sleep();

        Pet roscoClone = new Pet(rosco);
        System.out.println("roscoClone.equals(rosco): " + roscoClone.equals(rosco));
        System.out.println("rosco == roscoClone: " + (rosco == roscoClone));

        roscoClone = rosco;
        System.out.println("rosco == roscoClone: " + (rosco == roscoClone));
    }


}
