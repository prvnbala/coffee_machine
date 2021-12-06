package machine;

import machine.controller.Controller;
import machine.controller.MachineState;
import machine.models.StorageModel;
import machine.viewer.View;

import java.util.Scanner;

public class CoffeeMachine {
    MachineState machineState;

    public CoffeeMachine() {
        this.machineState = MachineState.ON;
    }

    StorageModel storageModel = new StorageModel();
    View view = new View(storageModel);
    Controller controller = new Controller(storageModel, view);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (coffeeMachine.machineState != MachineState.EXIT) {
            coffeeMachine.controller.promptUserInput(coffeeMachine.machineState);
            String input = scanner.next();
            coffeeMachine.machineState = coffeeMachine.controller.updateMachineState(coffeeMachine.machineState, input);
        }
    }

}
