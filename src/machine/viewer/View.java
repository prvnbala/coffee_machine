package machine.viewer;

import machine.models.StorageModel;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    StorageModel storageModel;

    public View (StorageModel storageModel) {
        this.storageModel = storageModel;
    }

    public void viewStatus() {
        System.out.println();
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n",
                this.storageModel.getAvailability("water"),
                this.storageModel.getAvailability("milk"),
                this.storageModel.getAvailability("coffee beans"),
                this.storageModel.getAvailability("disposable cups"),
                this.storageModel.getBalance());
        System.out.println();
    }
    public void viewOperations() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    public void viewBuyOptions() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
    }

    public void promptFillWater() {
        System.out.println();
        System.out.println("Write how many ml of water you want to add: ");
    }

    public void promptFillMilk() {
        System.out.println("Write how many ml of milk you want to add: ");
    }

    public void promptFillCoffee() {
        System.out.println("Write how many grams of coffee beans you want to add: ");
    }

    public void promptFillCups() {
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        System.out.println();
    }

    public void viewTakeOptions() {
        System.out.println();
        System.out.printf("I gave you $%d\n", storageModel.getBalance());
        System.out.println();
    }

}
