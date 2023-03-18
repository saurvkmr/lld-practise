import topping.ChickenTopping
import topping.PaneerTopping
import util.PizzaTypes

fun main() {
    checkPizza()
}

fun checkPizza() {
    val pizzaOrder = PizzaOrder(PizzaTypes.CHEESE_PIZZA)
    val pizza = pizzaOrder.orderPizza(PaneerTopping(), ChickenTopping())
    println("Total cost for your ${pizza.getName()} with extra toppings of ${pizza.getToppings()} the is ${ pizza.calculateCost() }")
}