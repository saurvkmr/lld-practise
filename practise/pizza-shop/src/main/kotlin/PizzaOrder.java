import factory.SimplePizzaFactory;
import pizza.Pizza;
import topping.Topping;
import util.PizzaTypes;

public class PizzaOrder {
    private Pizza pizza;

    public PizzaOrder(PizzaTypes type) {
        pizza = SimplePizzaFactory.Factory.createPizza(type);
    }

    public Pizza orderPizza(Topping... toppings) {
        return pizza.prepare(toppings)
                .bake()
                .cut()
                .box();
    }
}
