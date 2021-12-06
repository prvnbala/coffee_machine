package machine.models;

import java.util.HashMap;

public enum Beverage {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);


    public static String[] ingredients = {"water", "milk", "coffee beans", "disposable cups"};

    final int requiredWater;
    final int requiredMilk;
    final int requiredCoffee;
    final int requiredCups;
    final int price;

    HashMap<String, Integer> requirements = new HashMap<>();

    Beverage(int requiredWater, int requiredMilk, int requiredCoffee, int requiredCups, int price) {
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredCoffee = requiredCoffee;
        this.requiredCups = requiredCups;
        this.price = price;

        requirements.put("water", requiredWater);
        requirements.put("milk", requiredMilk);
        requirements.put("coffee beans", requiredCoffee);
        requirements.put("disposable cups", requiredCups);
    }

    public int getRequirement(String item) {
        return requirements.get(item);
    }

    public int getPrice() {
        return price;
    }
}
