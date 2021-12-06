package machine.models;

import java.util.HashMap;

public class StorageModel {

    private HashMap<String, Integer> availability = new HashMap<>();
    private int balance;

    public StorageModel() {
        updateDefaultValues();
    }

    public void updateDefaultValues() {
        availability.put("water", 400);
        availability.put("milk", 540);
        availability.put("coffee beans", 120);
        availability.put("disposable cups", 9);
        this.balance = 550;
    }

    public int getAvailability(String item) {
        return availability.get(item);
    }

    public int setAvailability(String item, int value) {
        return availability.put(item, value);
    }



    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
