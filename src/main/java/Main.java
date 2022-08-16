import service.CalculationService;
import store.State;


public class Main {
    public static void main(String[] args) {

        State state = new State();
        System.out.println(CalculationService.calculateTotalCost(state," XABCDABA"));

    }
}
