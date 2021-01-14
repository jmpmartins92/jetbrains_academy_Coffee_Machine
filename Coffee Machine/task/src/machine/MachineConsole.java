package machine;

import java.util.Scanner;

public class MachineConsole {
    Scanner scanner = new Scanner(System.in);

    public String userInput() {
        return scanner.nextLine();
    }

    public static int[] machineState(int[]machineState, int[] machineChanges, String action) {
        for (int changes = 0; changes < 5; changes++) {
            machineState[changes] += machineChanges[changes];
        }
        if (action.equals("buy")) {
            if (machineState[0] < 0) {
                System.out.println("Sorry, not enough water!");
                for (int changes = 0; changes < 5; changes++) {
                    machineState[changes] -= machineChanges[changes];
                }
            } else if (machineState[1] < 0) {
                System.out.println("Sorry, not enough milk!");
                for (int changes = 0; changes < 5; changes++) {
                    machineState[changes] -= machineChanges[changes];
                }
            } else if (machineState[2] < 0) {
                System.out.println("Sorry, not enough coffee beans!");
                for (int changes = 0; changes < 5; changes++) {
                    machineState[changes] -= machineChanges[changes];
                }
            } else if (machineState[3] < 0) {
                System.out.println("Sorry, not enough disposable cups!");
                for (int changes = 0; changes < 5; changes++) {
                    machineState[changes] -= machineChanges[changes];
                }
            } else {
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
        return machineState;
    }

    public static void statePrint(int[] machineState) {
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(machineState[0] + " of water");
        System.out.println(machineState[1] + " of milk");
        System.out.println(machineState[2] + " of coffee beans");
        System.out.println(machineState[3] + " of disposable cups");
        System.out.println(machineState[4] + " of money");
        System.out.println();
    }

    public static int[] buyOrder(int coffeeType) {

        int[] machineChanges = new int[5];
        int[] changesEspresso = new int[]{-250, 0, -16, -1, 4};
        int[] changesLatte = new int[]{-350, -75, -20, -1, 7};
        int[] changesCappuccino = new int[]{-200, -100, -12, -1, 6};
        if (coffeeType == 1) {
            for (int changes = 0; changes < 5; changes++) {
                machineChanges[changes] = changesEspresso[changes];
            }
        }
        if (coffeeType == 2) {
            for (int changes = 0; changes < 5; changes++) {
                machineChanges[changes] = changesLatte[changes];
            }
        }
        if (coffeeType == 3) {
            for (int changes = 0; changes < 5; changes++) {
                machineChanges[changes] = changesCappuccino[changes];
            }
        }

        return machineChanges;
    }

}
