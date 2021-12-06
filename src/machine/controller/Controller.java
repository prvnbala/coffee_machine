package machine.controller;

import machine.viewer.View;
import machine.models.Beverage;
import machine.models.StorageModel;

public class Controller {
    StorageModel storageModel;
    View view;

    public Controller(StorageModel storageModel, View view) {
        this.storageModel = storageModel;
        this.view = view;
    }

    public void promptUserInput(MachineState machineState) {
        switch (machineState.name()) {
            case "ON":
                view.viewOperations();
                break;
            case "BUY":
                view.viewBuyOptions();
                break;
            case "FILL_WATER":
                view.promptFillWater();
                break;
            case "FILL_MILK":
                view.promptFillMilk();
                break;
            case "FILL_COFFEE":
                view.promptFillCoffee();
                break;
            case "FILL_CUPS":
                view.promptFillCups();
                break;
        }
    }

    public MachineState updateMachineState(MachineState machineState, String input) {
        switch (machineState.name()) {
            case "ON":
                switch (input) {
                    case "buy":
                        return MachineState.BUY;
                    case "fill":
                        return MachineState.FILL_WATER;
                    case "take":
                        view.viewTakeOptions();
                        take();
                        return MachineState.ON;
                    case "remaining":
                        view.viewStatus();
                        return MachineState.ON;
                    case "exit":
                        return MachineState.EXIT;
                }
                break;
            case "BUY":
                buy(input);
                return MachineState.ON;
            case "FILL_WATER":
                fill("water", Integer.parseInt(input));
                return MachineState.FILL_MILK;
            case "FILL_MILK":
                fill("milk", Integer.parseInt(input));
                return MachineState.FILL_COFFEE;
            case "FILL_COFFEE":
                fill("coffee beans", Integer.parseInt(input));
                return MachineState.FILL_CUPS;
            case "FILL_CUPS":
                fill("disposable cups", Integer.parseInt(input));
                return MachineState.ON;
        }
        return machineState;
    }

    public void buy(String choice) {
        Beverage beverage;
        switch (choice) {
            case "1":
                beverage = Beverage.ESPRESSO;
                break;
            case "2":
                beverage = Beverage.LATTE;
                break;
            case "3":
                beverage = Beverage.CAPPUCCINO;
                break;
            default:
                return;
        }

        boolean possible = checkIngredientQty(beverage);

        if (possible) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            updateIngredientQty(beverage);
            updateMoney(beverage.getPrice());
        }
    }
    public void take() {
        updateMoney(-storageModel.getBalance());
    }
    public void fill(String item, int value) {
        storageModel.setAvailability(item, storageModel.getAvailability(item) + value);
    }


    private boolean checkIngredientQty(Beverage beverage) {
        for (String item : Beverage.ingredients) {
            if (storageModel.getAvailability(item) < beverage.getRequirement(item)) {
                System.out.printf("Sorry, not enough %s!\n", item);
                return false;
            }
        }
        return true;
    }

    private void updateIngredientQty(Beverage beverage) {
        for (String item : Beverage.ingredients) {
            storageModel.setAvailability(item, storageModel.getAvailability(item) - beverage.getRequirement(item));
        }
    }

    private void updateMoney(int value) {
        storageModel.setBalance(storageModel.getBalance() + value);
    }
}
