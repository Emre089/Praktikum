<<<<<<< HEAD
public class ResistorColorConverter {

    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) {
            System.out.println("Ungültige Anzahl von Argumenten. Verwenden Sie drei oder vier Farbwerte.");
            return;
        }

        String color1 = args[0].toLowerCase();
        String color2 = args[1].toLowerCase();
        String color3 = args[2].toLowerCase();
        String color4 = "";
        if (args.length == 4) {
            color4 = args[3].toLowerCase();
        }

        int value1 = colorToValue(color1);
        int value2 = colorToValue(color2);
        int value3 = colorToValue(color3);
        double multiplier = colorToMultiplier(color4);

        if (multiplier == -1) {
            System.out.println("Ungültiger Multiplikator. Verwenden Sie eine der folgenden Farben: silber, gold, schwarz, braun, rot, orange, gelb, grün, blau, violett, grau, weiß.");
            return;
        }

        double resistance = (value1 * 10 + value2) * multiplier;

        System.out.printf("Der Widerstand hat den Wert: %.6f Ohm%n", resistance);
    }

    private static int colorToValue(String color) {
        switch (color) {
            case "schwarz":
                return 0;
            case "braun":
                return 1;
            case "rot":
                return 2;
            case "orange":
                return 3;
            case "gelb":
                return 4;
            case "grün":
                return 5;
            case "blau":
                return 6;
            case "violett":
                return 7;
            case "grau":
                return 8;
            case "weiß":
                return 9;
            default:
                System.out.println("Ungültige Farbe. Verwenden Sie eine der folgenden Farben: schwarz, braun, rot, orange, gelb, grün, blau, violett, grau, weiß.");
                System.exit(1);
                return -1;
        }
    }

    private static double colorToMultiplier(String color) {
        switch (color) {
            case "":
                return 1.0;
            case "silber":
                return 0.01;
            case "gold":
                return 0.1;
            case "schwarz":
                return 1.0;
            case "braun":
                return 10.0;
            case "rot":
                return 100.0;
            case "orange":
                return 1000.0;
            case "gelb":
                return 10000.0;
            case "grün":
                return 100000.0;
            case "blau":
                return 1000000.0;
            case "violett":
                return 10000000.0;
            case "grau":
                return 100000000.0;
            case "weiß":
                return 1000000000.0;
            default:
                return -1.0;
        }
    }
}
=======
public class ResistorColorConverter {

    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) {
            System.out.println("Ungültige Anzahl von Argumenten. Verwenden Sie drei oder vier Farbwerte.");
            return;
        }

        String color1 = args[0].toLowerCase();
        String color2 = args[1].toLowerCase();
        String color3 = args[2].toLowerCase();
        String color4 = "";
        if (args.length == 4) {
            color4 = args[3].toLowerCase();
        }

        int value1 = colorToValue(color1);
        int value2 = colorToValue(color2);
        int value3 = colorToValue(color3);
        double multiplier = colorToMultiplier(color4);

        if (multiplier == -1) {
            System.out.println("Ungültiger Multiplikator. Verwenden Sie eine der folgenden Farben: silber, gold, schwarz, braun, rot, orange, gelb, grün, blau, violett, grau, weiß.");
            return;
        }

        double resistance = (value1 * 10 + value2) * multiplier;

        System.out.printf("Der Widerstand hat den Wert: %.6f Ohm%n", resistance);
    }

    private static int colorToValue(String color) {
        switch (color) {
            case "schwarz":
                return 0;
            case "braun":
                return 1;
            case "rot":
                return 2;
            case "orange":
                return 3;
            case "gelb":
                return 4;
            case "grün":
                return 5;
            case "blau":
                return 6;
            case "violett":
                return 7;
            case "grau":
                return 8;
            case "weiß":
                return 9;
            default:
                System.out.println("Ungültige Farbe. Verwenden Sie eine der folgenden Farben: schwarz, braun, rot, orange, gelb, grün, blau, violett, grau, weiß.");
                System.exit(1);
                return -1;
        }
    }

    private static double colorToMultiplier(String color) {
        switch (color) {
            case "":
                return 1.0;
            case "silber":
                return 0.01;
            case "gold":
                return 0.1;
            case "schwarz":
                return 1.0;
            case "braun":
                return 10.0;
            case "rot":
                return 100.0;
            case "orange":
                return 1000.0;
            case "gelb":
                return 10000.0;
            case "grün":
                return 100000.0;
            case "blau":
                return 1000000.0;
            case "violett":
                return 10000000.0;
            case "grau":
                return 100000000.0;
            case "weiß":
                return 1000000000.0;
            default:
                return -1.0;
        }
    }
}
>>>>>>> 83277f9b9b694a11ed85f76b8d863a4dc76ccd0c
