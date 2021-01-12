package machine;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CoffeeMachine {

   /* private static int possibleCoffee(int totalWater, int totalMilk, int totalBeans) {
        int waterCupCoffee = 200;
        int milkCupCoffee = 50;
        int beansCupCoffee = 15;
        int possibleCoffee = Integer.MAX_VALUE;

        int[] ingredientsCoffee = new int[]{waterCupCoffee, milkCupCoffee, beansCupCoffee};
        int[] totalIngredientsCoffee = new int[]{totalWater, totalMilk, totalBeans};
        int[] potentialCoffee = new int[3];

        for (int ingredients = 0; ingredients < 3; ingredients++) {
            potentialCoffee[ingredients] = totalIngredientsCoffee[ingredients] / ingredientsCoffee[ingredients];
            if (potentialCoffee[ingredients] < possibleCoffee) {
                possibleCoffee = potentialCoffee[ingredients];
            }
        }
        return possibleCoffee;
    }

    private static int coffeeTest(int possibleCoffee, int numCoffeeCups) {
        int coffeeTest = Integer.MAX_VALUE;
        if (possibleCoffee == numCoffeeCups) {
            coffeeTest = 0;
        } else if (possibleCoffee > numCoffeeCups) {
            coffeeTest = possibleCoffee - numCoffeeCups;
        } else {
            coffeeTest = possibleCoffee * -1;
        }
        return coffeeTest;
    }*/



    private static int[] machineState(int[] machineChange) {
        int waterState = 400;
        int milkState = 540;
        int beansState = 120;
        int cupsState = 9;
        int moneyState = 550;
        int[] machineState = new int[]{waterState, milkState, beansState, cupsState, moneyState};
        for (int changes = 0; changes < 5; changes++) {
            machineState[changes] += + machineChange[changes];
        }
        return machineState;
    }

    private static void statePrint(int[] machineState) {
        System.out.println("The coffee machine has: ");
        System.out.println(machineState[0] + " of water");
        System.out.println(machineState[1] + " of milk");
        System.out.println(machineState[2] + " of coffee beans");
        System.out.println(machineState[3] + " of disposable cups");
        System.out.println(machineState[4] + " of money");
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

        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        System.out.printf("For %d cups of Coffee you will need:\n", numCoffeeCups);
        System.out.println(numCoffeeCups * waterCupCoffee + "ml of water");
        System.out.println(numCoffeeCups * milkCupCoffee + "ml of milk");
        System.out.println(numCoffeeCups * beansCupCoffee + "ml of coffee beans");
        */



        /*System.out.println("Write how many ml of water the coffee machine has: ");
        int totalWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int totalMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int totalBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int numCoffeeCups = scanner.nextInt();

        if (coffeeTest(possibleCoffee(totalWater, totalMilk, totalBeans), numCoffeeCups) == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (coffeeTest(possibleCoffee(totalWater, totalMilk, totalBeans), numCoffeeCups) > 0) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n",
                    coffeeTest(possibleCoffee(totalWater, totalMilk, totalBeans), numCoffeeCups));
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n",
                    coffeeTest(possibleCoffee(totalWater, totalMilk, totalBeans), numCoffeeCups));
        }*/
        int[] machineChanges = new int[5];
        statePrint(machineState(machineChanges));
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        //String action = "take";

        while(!action.equals("exit")) {
            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int coffeeType = scanner.nextInt();
                machineChanges = buyOrder(coffeeType);
                statePrint(machineState(machineChanges));
            } else if (action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int addWater = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int addMilk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int addBeans = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                int addCups = scanner.nextInt();
                int[] addedResources = new int[]{addWater, addMilk, addBeans, addCups, 0};
                for (int changes = 0; changes < 5; changes++) {
                    machineChanges[changes] = addedResources[changes];
                }
                statePrint(machineState(machineChanges));
            } else if (action.equals("take")) {
                System.out.println("I gave you $" + machineState(machineChanges)[4]);
                int[] retrieveMoney = new int[]{0, 0, 0, 0, -machineState(machineChanges)[4]};
                System.out.println();
                statePrint(machineState(retrieveMoney));
            }
        }









    }

}
