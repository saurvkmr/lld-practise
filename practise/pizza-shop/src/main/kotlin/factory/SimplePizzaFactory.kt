package factory

import pizza.Pizza
import pizzaImpl.CheesePizza
import pizzaImpl.ChickenPizza
import pizzaImpl.ChickenTandooriPizza
import pizzaImpl.GreekPizza
import pizzaImpl.PaneerPizza
import pizzaImpl.SalamiPizza
import util.PizzaTypes

class SimplePizzaFactory {
    companion object Factory {
        fun createPizza(type: PizzaTypes): Pizza =
            when (type) {
                PizzaTypes.CHEESE_PIZZA -> CheesePizza()
                PizzaTypes.CHICKEN_PIZZA -> ChickenPizza()
                PizzaTypes.GREEK_PIZZA -> GreekPizza()
                PizzaTypes.SALAMI_PIZZA -> SalamiPizza()
                PizzaTypes.CHICKEN_TANDOORI_PIZZA -> ChickenTandooriPizza()
                PizzaTypes.PANEER_PIZZA -> PaneerPizza()
            }
    }
}