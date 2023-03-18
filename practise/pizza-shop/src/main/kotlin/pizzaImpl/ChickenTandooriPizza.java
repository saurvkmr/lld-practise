package pizzaImpl;

import org.jetbrains.annotations.NotNull;
import pizza.NonVegPizza;
import pizza.Pizza;
import topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class ChickenTandooriPizza extends NonVegPizza {

    String name = "Chicken Tandoori Pizza";
    float cost = 25.0f;
    private List<Topping> toppings = new ArrayList<>();
    @NotNull
    @Override
    public Pizza prepare(Topping... topping) {
        try {
            toppings.addAll(List.of(topping));
            System.out.println(String.format("Preparing %s", name));
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        return this;
    }

    @Override
    public float calculateCost() {
        return toppings.stream().map(it -> it.getCost()).reduce(cost, Float::sum);
    }
}