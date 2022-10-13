package console;

import logic.Battlefield;
import logic.Cell;

public class ConsolePrinter {

    private Battlefield firstBattlefield;
    private Battlefield secondBattlefield;

    public ConsolePrinter(Battlefield firstBattlefield, Battlefield secondBattlefield) {
        this.firstBattlefield = firstBattlefield;
        this.secondBattlefield = secondBattlefield;
    }

    private static void printField(Battlefield battlefield, boolean isWarFogActive) {
        System.out.println();
        for (Cell[] row : battlefield.getTable()) {
            System.out.println();
            for (Cell cell : row) {
                switch (cell.getType()) {
                    case SHIP -> {
                        if (!isWarFogActive) System.out.print(" " + "s");
                        else System.out.print(" " + "_");
                    }
                    case SHELLED -> System.out.print(" " + "*");
                    case SHIP_ZONE -> {
                        if (!isWarFogActive) System.out.print(" " + ".");
                        else System.out.print(" " + "_");
                    }
                    case SHIP_WRECKED -> System.out.print(" " + "w");
                    case FREE -> System.out.print(" " + "_");
                }
            }
        }
        System.out.println();
    }

    public void printScreen() {
        printField(firstBattlefield, false);
        printField(secondBattlefield, true);
        printField(secondBattlefield, false);
    }
}
