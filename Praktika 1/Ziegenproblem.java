<<<<<<< HEAD
public static void main(String[] args) {
    int winsA = 0;
    int winsB = 0;
    int iterations = 10000000;

    for (int i = 0; i < iterations; i++) {
        // Choose a random door
        int candidateDoor = (int) (Math.random() * 3);

        // The host opens a goat door
        int goatDoor;
        if (candidateDoor == 0) {
            goatDoor = (Math.random() < 0.5) ? 1 : 2;
        } else {
            goatDoor = getRemainingDoor(0, candidateDoor);
        }

        // Strategy A: stick with the original door
        if (candidateDoor == 0) {
            winsA++;
        }

        // Strategy B: switch to the other door
        int otherDoor = getRemainingDoor(candidateDoor, goatDoor);
        if (otherDoor == 0) {
            winsB++;
        }
    }

    // Print the results
    double percentWinsA = 100.0 * winsA / iterations;
    double percentWinsB = 100.0 * winsB / iterations;
    System.out.printf("Strategy A: %d wins (%.2f%%)\n", winsA, percentWinsA);
    System.out.printf("Strategy B: %d wins (%.2f%%)\n", winsB, percentWinsB);
}
=======
public static void main(String[] args) {
    int winsA = 0;
    int winsB = 0;
    int iterations = 10000000;

    for (int i = 0; i < iterations; i++) {
        // Choose a random door
        int candidateDoor = (int) (Math.random() * 3);

        // The host opens a goat door
        int goatDoor;
        if (candidateDoor == 0) {
            goatDoor = (Math.random() < 0.5) ? 1 : 2;
        } else {
            goatDoor = getRemainingDoor(0, candidateDoor);
        }

        // Strategy A: stick with the original door
        if (candidateDoor == 0) {
            winsA++;
        }

        // Strategy B: switch to the other door
        int otherDoor = getRemainingDoor(candidateDoor, goatDoor);
        if (otherDoor == 0) {
            winsB++;
        }
    }

    // Print the results
    double percentWinsA = 100.0 * winsA / iterations;
    double percentWinsB = 100.0 * winsB / iterations;
    System.out.printf("Strategy A: %d wins (%.2f%%)\n", winsA, percentWinsA);
    System.out.printf("Strategy B: %d wins (%.2f%%)\n", winsB, percentWinsB);
}
>>>>>>> 83277f9b9b694a11ed85f76b8d863a4dc76ccd0c
