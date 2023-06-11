
import java.util.Scanner;


public class ShipSalvage {

    private static final char[][] exampleMap = {
            {'O', 'O', ' ', 'O', ' ', ' ', 'O', 'O', 'O', 'O'},
            {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', 'O', 'O', 'O', 'O', 'O', 'O'}
    };


    public static boolean allSalvaged(FieldState[][] map) {
        for (FieldState[] fieldStates : map) {
            for (FieldState fieldState : fieldStates) {
                if (fieldState == FieldState.OCCUPIED_HIDDEN) {
                    return false;
                }
            }
        }
        return true;
    }
    public static FieldState[][] getExample() {
        FieldState[][] result = new FieldState[10][10];
        for (int i = 0; i < exampleMap.length; i++) {
            for (int j = 0; j < exampleMap[i].length; j++) {
                result[i][j] = FieldState.fromOutput(exampleMap[i][j]);
            }
        }
        return result;
    }
    public static void probeField(FieldState[][] map, String field) {
        // Convert the field string to uppercase and remove any spaces
        field = field.toUpperCase().replaceAll("\\s", "");

        // Check if the field has a valid format
        if (!field.matches("[A-J][1-9]0?1?0?")) {
            System.out.println("Ungültige Eingabe! Feld konnte nicht untersucht werden.");
            return;
        }

        // Extract the column and row from the field string
        char column = field.charAt(0);
        int row = Integer.parseInt(field.substring(1));

        // Adjust the column and row to match the array indices
        int columnIndex = column - 'A';
        int rowIndex = row - 1;

        // Check if the indices are within the valid range
        if (rowIndex < 0 || rowIndex >= map.length || columnIndex < 0 || columnIndex >= map[rowIndex].length) {
            System.out.println("Ungültige Eingabe! Feld konnte nicht untersucht werden.");
            return;
        }

        FieldState currentState = map[rowIndex][columnIndex];
        FieldState newState;

        // Update the field state based on the current state
        switch (currentState) {
            case EMPTY -> {
                newState = FieldState.MISS;
                System.out.println("Nichts zu finden!");
            }
            case OCCUPIED_HIDDEN -> {
                newState = FieldState.OCCUPIED_SALVAGED;
                System.out.println("Wrack gefunden!");
            }
            case OCCUPIED_SALVAGED -> {
                newState = FieldState.OCCUPIED_SALVAGED;
                System.out.println("Bereits untersucht!");
            }
            case MISS -> {
                newState = FieldState.MISS;
                System.out.println("Bereits untersucht!");
            }
            default -> throw new IllegalArgumentException("Ungültiger Feldzustand!");
        }

        // Update the field state in the map
        map[rowIndex][columnIndex] = newState;
    }

    public static void checkValidMap(FieldState[][] map) {
        if (map == null) {
            throw new IllegalArgumentException("The map must not be null.");
        }
        if (map.length != 10) {
            throw new IllegalArgumentException("The map must have exactly 10 rows.");
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) {
                throw new IllegalArgumentException("Row " + i + " of the map must not be null.");
            }
            if (map[i].length != 10) {
                throw new IllegalArgumentException("Row " + i + " of the map must have exactly 10 columns.");
            }
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    throw new IllegalArgumentException("The element at row " + i + ", column " + j + " of the map must not be null.");
                }
            }
        }
    }

    public static void printMap(FieldState[][] map, boolean showHidden) {
        checkValidMap(map);
        System.out.println("  ABCDEFGHIJ");
        System.out.println(" +----------+");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == FieldState.OCCUPIED_HIDDEN && !showHidden) {
                    System.out.print(FieldState.EMPTY.output);
                } else {
                    System.out.print(map[i][j].output);
                }
            }
            System.out.println("|");
        }
        System.out.println(" +----------+");
    }

    public static void main(String[] args) {
        // Get the example map
        FieldState[][] map = getExample();

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (!allSalvaged(map)) {
            // Print the map
            printMap(map, false);

            // Read a line of input from the user
            String input = scanner.next();

            // Probe the field
            probeField(map, input);
        }

        // All ships salvaged
        System.out.println("Alle Schiffe geborgen!");

        // Print the final map
        printMap(map, false);
        }

    public enum FieldState {
        EMPTY(' '), MISS('X'), OCCUPIED_HIDDEN('O'), OCCUPIED_SALVAGED('X');

        public final char output;

        FieldState(char output) {
            this.output = output;
        }

        public static FieldState fromOutput(char output) {
            for (FieldState state : FieldState.values()) {
                if (state.output == output) {
                    return state;
                }
            }
            throw new IllegalArgumentException("Invalid field state output: " + output);
        }
    }
}
