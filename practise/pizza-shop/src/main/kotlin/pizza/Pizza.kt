package pizza

import topping.Topping

abstract class Pizza {
    private val name: String = ""
    private val cost: Float = 10.0f
    private val toppings = mutableListOf<Topping>()

    abstract fun prepare(vararg topping: Topping): Pizza
    fun bake(): Pizza {
        Thread.sleep(1000)
        return this
    }

    fun cut(): Pizza {
        Thread.sleep(100)
        return this
    }

    fun box(): Pizza {
        Thread.sleep(100)
        return this
    }

    fun getName() = name
    fun getToppings() = toppings

    abstract fun calculateCost(): Float
}