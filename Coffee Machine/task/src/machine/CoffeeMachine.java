package machine;

import java.util.Scanner;

import static machine.MachineConsole.machineState;

public class CoffeeMachine {

    private static int[] machineState(int[]machineState, int[] machineChanges, String action) {
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

    private static void statePrint(int[] machineState) {
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(machineState[0] + " of water");
        System.out.println(machineState[1] + " of milk");
        System.out.println(machineState[2] + " of coffee beans");
        System.out.println(machineState[3] + " of disposable cups");
        System.out.println(machineState[4] + " of money");
        System.out.println();
    }

    private static int[] buyOrder(int coffeeType) {

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

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int waterState = 400;
        int milkState = 540;
        int beansState = 120;
        int cupsState = 9;
        int moneyState = 550;
        int[] machineState = new int[5];
        int[] machineChanges = {waterState, milkState, beansState, cupsState, moneyState};
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        machineState(machineState, machineChanges, action);


        //String action = "take";

        while(!action.equals("exit")) {
            if (action.equals("buy")) {
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String coffeeInput = scanner.nextLine();
                if (coffeeInput.equals("back")) {
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                } else {
                    int coffeeType = Integer.valueOf(coffeeInput);
                    machineChanges = buyOrder(coffeeType);
                    machineState(machineState, machineChanges, action);
                    for (int changes = 0; changes < 5; changes++) {
                        machineChanges[changes] = 0;
                    }
                }
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                action = scanner.nextLine();
                continue;

            } else if (action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int addWater = Integer.valueOf(scanner.nextLine());
                System.out.println("Write how many ml of milk do you want to add:");
                int addMilk = Integer.valueOf(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int addBeans = Integer.valueOf(scanner.nextLine());
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                int addCups = Integer.valueOf(scanner.nextLine());
                int[] addedResources = new int[]{addWater, addMilk, addBeans, addCups, 0};
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = addedResources[changes];
                }
                machineState(machineState, machineChanges, action);
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = 0;
                }
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                action = scanner.nextLine();
                continue;
            } else if (action.equals("take")) {
                System.out.println("I gave you $" + machineState(machineState, machineChanges, action)[4]);
                int[] retrieveMoney = new int[]{0, 0, 0, 0, -machineState(machineState, machineChanges, action)[4]};
                machineState(machineState, retrieveMoney, action);
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                action = scanner.nextLine();
                continue;
            } else if (action.equals("remaining")) {
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = 0;
                }
                statePrint(machineState(machineState, machineChanges, action));
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                action = scanner.nextLine();
                continue;
            }
            else {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                action = scanner.nextLine();
                continue;
            }
        }
        if (action.equals("exit")) {
            System.exit(0);
        }
    }
}
/*
package machine;
        import static machine.MachineConsole.machineState;


public class CoffeeMachine {

    public static void main(String[] args) {

        int waterState = 400;
        int milkState = 540;
        int beansState = 120;
        int cupsState = 9;
        int moneyState = 550;
        int[] machineState = new int[5];
        int[] machineChanges = {waterState, milkState, beansState, cupsState, moneyState};
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        MachineConsole machineConsole = new MachineConsole();
        String action = machineConsole.userInput();
        machineState(machineState, machineChanges, action);


        //String action = "take";

        while(machineConsole.userInput().equals("exit")) {
            if (action.equals("buy")) {
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                machineConsole.userInput();
                if (machineConsole.userInput().equals("back")) {
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                } else {
                    int coffeeType = Integer.valueOf(machineConsole.userInput());
                    machineChanges = machineConsole.buyOrder(coffeeType);
                    machineState(machineState, machineChanges, action);
                    for (int changes = 0; changes < 5; changes++) {
                        machineChanges[changes] = 0;
                    }
                }
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                machineConsole.userInput();
                continue;

            } else if (machineConsole.userInput().equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int addWater = Integer.valueOf(machineConsole.userInput());
                System.out.println("Write how many ml of milk do you want to add:");
                int addMilk = Integer.valueOf(machineConsole.userInput());
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int addBeans = Integer.valueOf(machineConsole.userInput());
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                int addCups = Integer.valueOf(machineConsole.userInput());
                int[] addedResources = new int[]{addWater, addMilk, addBeans, addCups, 0};
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = addedResources[changes];
                }
                machineState(machineState, machineChanges, action);
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = 0;
                }
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                machineConsole.userInput();
                continue;
            } else if (machineConsole.userInput().equals("take")) {
                System.out.println("I gave you $" + machineState(machineState, machineChanges, action)[4]);
                int[] retrieveMoney = new int[]{0, 0, 0, 0, -machineState(machineState, machineChanges, action)[4]};
                machineState(machineState, retrieveMoney, action);
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                machineConsole.userInput();
                continue;
            } else if (machineConsole.userInput().equals("remaining")) {
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = 0;
                }
                machineConsole.statePrint(machineState(machineState, machineChanges, action));
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                machineConsole.userInput();
                continue;
            }
            else {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                machineConsole.userInput();
                continue;
            }
        }
        if (machineConsole.userInput().equals("exit")) {
            System.exit(0);
        }
    }
}
*/