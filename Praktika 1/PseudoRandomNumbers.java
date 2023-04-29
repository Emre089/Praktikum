import java.util.Scanner;

public class PseudoRandomNumbers {

    public final static long MODULUS = 2147483647;
    public final static long MULTIPLIER = 48271;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Anzahl Zufallszahlen (>=0): ");
        int count = scanner.nextInt();
        System.out.print("Seed (>0): ");
        long seed = scanner.nextLong();

        // Validierung der Eingaben
        if (count < 0 || seed <= 0) {
            System.err.println("Fehlerhafte Eingabe!");
            return;
        }

        long[] randomNumbers = generateRandomNumbers(seed, count);
        System.out.print("Min: ");
        int min = scanner.nextInt();
        System.out.print("Max (exklusiv, >=Min): ");
        int max = scanner.nextInt();

        // Validierung der Eingaben
        if (min >= max) {
            System.err.println("Fehlerhafte Eingabe!");
            return;
        }

        // Umwandlung in den Bereich [min, max)
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = (randomNumbers[i] % (max - min)) + min;
        }

        // Ausgabe
        for (long number : randomNumbers) {
            System.out.print(number + " ");
        }
    }

    //Algorithmus Lehmer-Pseudo-Zufallszahlengenerator
    // FOR-Schleife, nutze Array zum speichern der Ergebnisse
    public static long[] generateRandomNumbers(long seed, int count) {
        long[] result = new long[count];
        long x = seed;
        for (int i = 0; i < count; i++) {
            x = (MULTIPLIER * x) % MODULUS;
            result[i] = x;
        }
        return result;
    }
}
