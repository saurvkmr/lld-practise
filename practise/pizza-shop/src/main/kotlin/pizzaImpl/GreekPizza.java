package pizzaImpl;

import org.jetbrains.annotations.NotNull;
import pizza.Pizza;
import pizza.VegPizza;
import topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class GreekPizza extends VegPizza {

    String name = "Greek Pizza";
    float cost = 15.0f;
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
